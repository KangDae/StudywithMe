package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.nio.BufferUnderflowException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import DTO.Protocol;
import DTO.Room;
import DTO.User;

public class ServerHandler extends Thread {
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	private User user;
	private BufferedWriter fw;

	private Connection conn;
	private PreparedStatement pstmt;

	private ArrayList<ServerHandler> allUserList; // 전체 사용자
	private ArrayList<ServerHandler> waitUserList;// 대기실 사용자
	private ArrayList<Room> roomtotalList; // 전체 방 리스트

	private Room priRoom;
	private String fileName;
	String path = System.getProperty("user.dir");

	public ServerHandler(Socket socket, ArrayList<ServerHandler> allUserList, ArrayList<ServerHandler> waitUserList,
			ArrayList<Room> roomtotalList, Connection conn) throws IOException {
		this.user = new User();
		this.priRoom = new Room();
		this.socket = socket;
		this.allUserList = allUserList;
		this.waitUserList = waitUserList;
		this.roomtotalList = roomtotalList;
		this.conn = conn;

		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

		this.fileName = "";
	}

	@Override
	public void run() {

		try {
			OutputStream out = null;
			String[] line = null;
			while (true) {
				line = br.readLine().split("\\|");
				if (line == null) {
					break;
				}

				// REGISTER가 true일때
				if (line[0].compareTo(Protocol.REGISTER) == 0) // [회원가입]
				{
					// line[0]은 프로토콜 split
					// line[1]은 %까지 split
					String userContent[] = line[1].split("%");
					System.out.println(line[1]);
					String sql = "Insert into UserContent values(nextval(num),?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					// DB의 회원정보 순서
					pstmt.setString(1, userContent[0]); // ID
					pstmt.setString(2, userContent[1]); // Password
					pstmt.setString(3, userContent[2]); // name
					pstmt.setString(4, userContent[3]); // age
					pstmt.setString(5, userContent[4]); // eamil
					pstmt.setString(6, sql);
					String Roompath = path + "\\userFolder\\" + userContent[0];

					File folder = new File(Roompath);

					File RoomList = new File(Roompath + "\\Roomlist.txt");

					if (folder.exists()) {// exists-> 파일폴더가 존재하는지.
						try {
							System.out.println("폴더가 이미 존재합니다.");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if (!folder.exists()) {// 폴더가 존재하지 않을때
						folder.mkdir();// mkdir-> 폴더 새로 생성
						RoomList.createNewFile();
						System.out.println("폴더가 생성되었습니다.");
					}

					int su = pstmt.executeUpdate(); // 항상 몇개를 실행(CRUD)한지 갯수를 return
					System.out.println(su + "회원가입[DB]");

				} else if (line[0].compareTo(Protocol.IDSEARCHCHECK) == 0) {// ID찾기 중복확인

					System.out.println(line[0] + "/" + line[1]);
					String sql = "select * from UserContent where IDNAME = '" + line[1] + "'";
					// prepareStatement-> 객체를 캐시에 담아 사용.
					pstmt = conn.prepareStatement(sql);
					// executeQuery-> 데이터베이스에서 데이터를 가져와서 결과 집합을 반환
					ResultSet rs = pstmt.executeQuery(sql);
					String name = null;
					int count = 0;
					while (rs.next()) {
						name = rs.getString("IDNAME");
						// 아이디가 같으면 counrt++->로그인됨
						if (name.compareTo(line[1]) == 0) {
							count++;
						}
					}
					System.out.println(count);
					if (count == 0) // 중복안되서 가입가능
					{
						pw.println(Protocol.IDSEARCHCHECK_OK + "|" + "MESSAGE");
						pw.flush();// br내용을 전송해줌.
					} else {
						pw.println(Protocol.IDSEARCHCHECK_NO + "|" + "MESSAGE");
						pw.flush();
					}
				} else if (line[0].compareTo(Protocol.IDSEARCH) == 0) // ID 찾기
				{
					System.out.println("ID찾기");
					String userContent[] = line[1].split("%");

					System.out.println(userContent[0]);// ID
					System.out.println(userContent[1]);// AGE
					System.out.println(userContent[2]);// EMAIL

					String sql = "select * from UserContent where (NAME = '" + userContent[0] + "' and age = '"
							+ userContent[1] + "' and email ='" + userContent[2] + "')";

					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery(sql);
					String name = null;
					String id = null;
					int count = 0;
					while (rs.next()) {
						name = rs.getString("NAME");
						id = rs.getString("IDNAME");
						if (name.compareTo(userContent[0]) == 0) {
							count++;
						}
					}
					System.out.println(count);

					if (count == 0) // ID가 없음
					{
						pw.println(Protocol.IDSEARCH_NO + "|" + "등록된 아이디가 없습니다.");
						pw.flush();// 저장하고 close
					} else { // 기존에ID 찾음
						// StringBuffer - 입력된 String id를 읽어온다.
						StringBuffer stb = new StringBuffer(id);
						stb.replace(stb.length() - 4, stb.length() - 1, "***");
						pw.println(Protocol.IDSEARCH_OK + "|" + "ID : " + stb.toString());
						pw.flush();
					}

				} else if (line[0].compareTo(Protocol.PWSEARCH) == 0) { // PW 찾기

					System.out.println("PW찾기");
					String userContent[] = line[1].split("%");

					System.out.println(line[1]);
					System.out.println("\n" + userContent[0] + "유저컨텐츠0");

					String sql = "select * from UserContent where (IDNAME = '" + userContent[1] + "')";

					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery(sql);
					String id = null;
					String name = null;

					int count = 0;
					while (rs.next()) {
						id = rs.getString("IDNAME");
						name = rs.getString("NAME");
						if (id.equals(userContent[1])) {
							count++;
						}
					}
					System.out.println("\n" + userContent[1] + "유저컨텐츠1");
					System.out.println("\n" + count + "카운트");

					if (count == 0) // 기존의 ID가 없음
					{
						pw.println(Protocol.PWSEARCH_NO + "|" + "등록되어있는 정보가 없습니다.");
						pw.flush();
					} else { // 기존의 ID 찾음
						String updateSql = "update usercontent set password=? where IDNAME=?";

						System.out.println("line[0] = " + userContent[0]);
						System.out.println("line[1] = " + userContent[1]);

						pstmt = conn.prepareStatement(updateSql);

						pstmt.setString(1, userContent[2]);
						pstmt.setString(2, userContent[1]);
						pstmt.executeUpdate();

						pw.println(Protocol.PWSEARCH_OK + "|" + "정보가 확인되었습니다.");
						pw.flush();
					}

				} else if (line[0].compareTo(Protocol.ENTERLOGIN) == 0) // 로그인
				{
					boolean con = true;
					System.out.println("login");
					String userContent[] = line[1].split("%");

					System.out.println(userContent[0] + "/" + userContent[1]);

					// 로그인후 대기실인원=waitUserList
					for (int i = 0; i < waitUserList.size(); i++) {
						if ((waitUserList.get(i).user.getIdName()).compareTo(userContent[0]) == 0) {
							con = false; // 대기실ID랑, DB에 있는 ID랑 같을때 로그인이 되었다.
						}
					}

					if (con) {
//						String sql = "select * from UserContent where (IDNAME = '" + userContent[0] + "' and PASSWORD = '"
//						+ userContent[1] + "')";

						String sql = "select * from UserContent where idname = '" + userContent[0]
								+ "' and password = '" + userContent[1] + "'";

						pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery(sql);
						int count = 0;

						// 회원가입
						while (rs.next()) {
							user.setName(rs.getString("NAME"));
							user.setIdName(rs.getString("IDNAME"));
							user.setAge(rs.getString("AGE"));
							user.setPassword(rs.getString("PASSWORD"));
							user.setPryNumber(rs.getInt("priNumber"));
							user.setEmail(rs.getString("email"));

							count++;
						}

						System.out.println(count);
						// count는 user가 로그인이 됬을때 count++로 1이되면 로그인이 된거고 0이면 실패.
						if (count == 0) // ID,PW 틀리면
						{
							pw.println(Protocol.ENTERLOGIN_NO + "|" + "로그인에 실패하였습니다");
							pw.flush();

							// 오류발생방지로 전체 회원가입 초기화
							user.setName("");
							user.setIdName("");
							user.setAge("");
							user.setPassword("");
							user.setPryNumber(0);
							user.setEmail("");

						} else { // 로그인 되었을때
							waitUserList.add(this); // 대기방 인원수 추가

							String userinfo = "";
							userinfo += user.getName() + "%" + user.getIdName() + "%" + user.getPassword() + "%"
									+ user.getEmail() + "%" + user.getAge();

							pw.println(Protocol.ENTERLOGIN_OK_USERINFOMATION + "|" + userinfo);
							pw.flush();

							String userline = "";
							for (int i = 0; i < waitUserList.size(); i++) {
								userline += (waitUserList.get(i).user.getIdName() + ":");
							}

							for (int i = 0; i < waitUserList.size(); i++) {
								waitUserList.get(i).pw.println(
										Protocol.ENTERLOGIN_OK + "|" + user.getIdName() + "|님이 입장하였습니다.|" + userline);
								waitUserList.get(i).pw.flush();
							}
							System.out.println("[대기방 인원수] :" + waitUserList.size());

							System.out.println("[Room 정보]");
							for (Room room : roomtotalList) {// 전체방리스트
								System.out.println(room.toString() + "현재방에 인원수 : " + room.roomInUserList.size());
							}
							System.out.println("[전체 Room 갯수 ]" + roomtotalList.size());

							// RoomtotalList 전체 정보를 Message로 만들어서 보내야된다
							String roomListMessage = "";

							// roomtotalList의 정보들을 console로 알려줌.
							for (int i = 0; i < roomtotalList.size(); i++) {
								roomListMessage += (roomtotalList.get(i).getrID() + "%"
										+ roomtotalList.get(i).getTitle() + "%" + "%"
										+ roomtotalList.get(i).getUserCount() + "%"
										+ roomtotalList.get(i).getMasterName() + "%" + roomtotalList.get(i).getSubject()
										+ "%" + roomtotalList.get(i).roomInUserList.size() + "-");

							}

							System.out.println(roomListMessage);
							// 대기실에 방이 생겼다고 대기유저들한테 브로드캐스트로 알려주는것.
							if (roomListMessage.length() != 0) {
								for (int i = 0; i < waitUserList.size(); i++) {
									waitUserList.get(i).pw.println(Protocol.ROOMMAKE_OK + "|" + roomListMessage);
									waitUserList.get(i).pw.flush();
								}
							}
						}

						System.out.println(user.toString());
					} else {
						pw.println(Protocol.ENTERLOGIN_NO + "|" + "이미 로그인 중입니다.");
						pw.flush();
					}

				} else if (line[0].compareTo(Protocol.EXITWAITROOM) == 0) { // 대기방에서 exit클릭

					// indexOf 는 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환하며 만약 찾지 못했을 경우 "-1"을 반환함
					// 대기자 ID - indexOf(this)는 대기실 인원중 자기 자신의 아이디
					String thisName = waitUserList.get(waitUserList.indexOf(this)).user.getIdName();

					waitUserList.remove(this);
					System.out.println("[대기방 인원수] :" + waitUserList.size());

					String userline = "";
					for (int i = 0; i < waitUserList.size(); i++) {
						userline += (waitUserList.get(i).user.getIdName() + ":");
					}

					System.out.println("대기자 인원 :" + userline);
					for (int i = 0; i < waitUserList.size(); i++) {
						// 대기방에서 exit클릭
						waitUserList.get(i).pw
								.println(Protocol.EXITWAITROOM + "|" + thisName + "|님이 퇴장하였습니다.|" + userline);
						waitUserList.get(i).pw.flush();
					}
					// 초기화
					user.setName("");
					user.setIdName("");
					user.setAge("");
					user.setPassword("");
					user.setPryNumber(0);
					user.setEmail("");

				} else if (line[0].compareTo(Protocol.ROOMSORT) == 0) { // 방정렬

					System.out.println(line[1]);
					String roomListMessage = "";

					for (int i = 0; i < roomtotalList.size(); i++) {

						if (roomtotalList.get(i).getSubject().equals(line[1])) {

							roomListMessage += (roomtotalList.get(i).getrID() + "%" + roomtotalList.get(i).getTitle()
									+ "%" + roomtotalList.get(i).getUserCount() + "%"
									+ roomtotalList.get(i).getMasterName() + "%" + roomtotalList.get(i).getSubject()
									+ "%" + roomtotalList.get(i).roomInUserList.size() + "-");
						}

						else if (line[1].equals("모두")) {
							roomListMessage += (roomtotalList.get(i).getrID() + "%" + roomtotalList.get(i).getTitle()
									+ "%" + roomtotalList.get(i).getUserCount() + "%"
									+ roomtotalList.get(i).getMasterName() + "%" + roomtotalList.get(i).getSubject()
									+ "%" + roomtotalList.get(i).roomInUserList.size() + "-");
						} else if (line[1].equals("내방")) {
							System.out.println("내방이다아아아");

						}

						else if (line[1].equals("내방만")) {
							// Roomlist.txt파일 불러오기
							System.out.println("내방 불러오기");
							File MyRoom = new File(path + "\\userFolder\\" + this.user.getIdName() + "\\Roomlist.txt");
							// Roomlist.txt파일 읽어오기
							BufferedReader reader = new BufferedReader(new FileReader(MyRoom));
							String s = reader.readLine();// 한줄로 가져오기
							String[] inRoomList = s.split("%");
							for (int j = 0; j < inRoomList.length; j++) {
								System.out.println(inRoomList[j]);
								// roomlist.txt.랑 내가참가한 방이랑 같을때
								if (inRoomList[j].equals(String.valueOf(roomtotalList.get(i).getrID()))) {
									// 방리스트 불러오기
									roomListMessage += (roomtotalList.get(i).getrID() + "%"
											+ roomtotalList.get(i).getTitle() + "%"
											+ roomtotalList.get(i).getUserCount() + "%"
											+ roomtotalList.get(i).getMasterName() + "%"
											+ roomtotalList.get(i).getSubject() + "%"
											+ roomtotalList.get(i).roomInUserList.size() + "-");
								}
							}
						}

					}

					// 신호를 보낸 user

					pw.println(Protocol.ROOMSORT + "|" + roomListMessage);
					pw.flush();

					// 방 검색
				} else if (line[0].compareTo(Protocol.SearchRoom) == 0) {
					String testTitle = line[1];// 내가 입력한 방이름
					System.out.println("내가 입력한 방 : " + testTitle);
					String roomListMessage = "";

					for (int i = 0; i < roomtotalList.size(); i++) {
						// 현재방이름과 내가 검색한 방이름과 같을때
						if (roomtotalList.get(i).getTitle().equals(testTitle)) {
							roomListMessage += (roomtotalList.get(i).getrID() + "%" + roomtotalList.get(i).getTitle()
									+ "%" + roomtotalList.get(i).getUserCount() + "%"
									+ roomtotalList.get(i).getMasterName() + "%" + roomtotalList.get(i).getSubject()
									+ "%" + roomtotalList.get(i).roomInUserList.size() + "-");
						} else {
							System.out.println("입력한 방 정보가 없습니다.");
						}
					}
					pw.println(Protocol.SearchRoom + "|" + roomListMessage);
					pw.flush();
				}

				else if (line[0].compareTo(Protocol.SENDMESSAGE) == 0) { // 대기실방에서 메세지보내기

					for (int i = 0; i < waitUserList.size(); i++) {
						waitUserList.get(i).pw
								.println(Protocol.SENDMESSAGE_ACK + "|" + user.getIdName() + " |" + line[1]);
						waitUserList.get(i).pw.flush();
					}
				} else if (line[0].compareTo(Protocol.ROOMMAKE) == 0) { // 방만들기

					String userContent[] = line[1].split("%");
					for (int i = 0; i < userContent.length; i++) {
						System.out.println(userContent[i]);
					}

					String sql = "";
					String updateSql = "";
					Room tempRoom = new Room();
					String userpath = path + "\\userFolder\\" + user.getIdName() + "\\Roomlist.txt";

					sql = "Insert into Room values(nextval(num),?,?,?,?)";
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, userContent[0]); // title
					pstmt.setString(2, userContent[1]); // count
					pstmt.setString(3, user.getIdName()); // admin
					pstmt.setString(4, userContent[2]); // subject

					tempRoom.setTitle(userContent[0]);
					tempRoom.setUserCount(userContent[1]);
					tempRoom.setMasterName(user.getIdName());
					tempRoom.setSubject(userContent[2]);
					System.out.println(tempRoom.toString());

					sql = "select * from Room where title = '" + userContent[0] + "' and  userCount= '" + userContent[1]
							+ "' and  admin= '" + user.getIdName() + "' and  subject= '" + userContent[2] + "'";

					updateSql = "update usercontent set RoomList=? where IDNAME=?";

					int su = pstmt.executeUpdate(); // 항상 몇개를 실행(CRUD)한지 갯수를 return

					System.out.println(su + "Room 만듬[DB]");// 흐에

					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery(sql);

					int count = 0;
					int priNumber = 0;// DB

					while (rs.next()) {
						count++;
						priNumber = rs.getInt("RID");
					}

					if (count != 0) {// 로그인 했을때
						tempRoom.setrID(priNumber);
						tempRoom.roomInUserList.add(this);
						roomtotalList.add(tempRoom);
						priRoom = tempRoom; // 현재 룸을 지정함

					}

					fw = new BufferedWriter(new FileWriter(userpath, true));
					fw.write(priNumber + "%");
					fw.flush();

					pstmt = conn.prepareStatement(updateSql);

					String roomId = Files.readString(Paths.get(userpath));
					pstmt.setString(1, roomId);
					pstmt.setString(2, user.getIdName());
					pstmt.executeUpdate();

					System.out.println("[Room 정보]");
					for (Room room : roomtotalList) {
						System.out.println(room.toString() + "현재방에 인원수 : " + room.roomInUserList.size());
					}
					System.out.println("[전체 Room 갯수 ]" + roomtotalList.size());

					// RoomtotalList 전체 정보를 Message로 만들어서 보내야된다
					String roomListMessage = "";
					// 룸리스트 정보
					for (int i = 0; i < roomtotalList.size(); i++) {
						roomListMessage += (roomtotalList.get(i).getrID() + "%" + roomtotalList.get(i).getTitle() + "%"
								+ roomtotalList.get(i).getUserCount() + "%" + roomtotalList.get(i).getMasterName() + "%"
								+ roomtotalList.get(i).getSubject() + "%" + roomtotalList.get(i).roomInUserList.size()
								+ "%" + "-");
					}

					System.out.println(roomListMessage);

					for (int i = 0; i < waitUserList.size(); i++) {// 대기자수
						// 방만든사람에게는 바로 채팅화면으로
						// 대기자ID랑 방만든사람ID가 같을때
						if (waitUserList.get(i).user.getIdName().compareTo(tempRoom.getMasterName()) == 0) {
							waitUserList.get(i).pw.println(Protocol.ROOMMAKE_OK1 + "|" + tempRoom.getMasterName());
							// 방 만든사람에게 대기방 새로고침
							waitUserList.get(i).pw.println(Protocol.ROOMMAKE_OK + "|" + roomListMessage);
							waitUserList.get(i).pw.flush();
						} else { // 다른 대기방사람들에게는 대기방만 새로고침
							waitUserList.get(i).pw.println(Protocol.ROOMMAKE_OK + "|" + roomListMessage);
							waitUserList.get(i).pw.flush();
						}
					}

					waitUserList.remove(this); // 채팅방에 참가해 대기자명단에 remove.
					System.out.println("대기방 인원수 누군가 방만들었을때" + waitUserList.size());

					String userline = "";
					for (int i = 0; i < waitUserList.size(); i++) {
						userline += (waitUserList.get(i).user.getIdName() + ":");
					}

					// 방 만들었을때 대기방에서 출력됨
					for (int i = 0; i < waitUserList.size(); i++) {
						waitUserList.get(i).pw.println(Protocol.ENTERLOGIN_OK + "|" + tempRoom.getMasterName() + "|님이"
								+ tempRoom.getrID() + "번 방을 만들었습니다.|" + userline);
						waitUserList.get(i).pw.flush();
					}

					String Roompath = path + "\\roomFolder\\" + priNumber;
					String Path = path + "\\roomFolder\\" + priRoom.getrID() + "\\ChattingLog.txt";

					File folder = new File(Roompath);

					if (folder.exists()) {// exists-> 파일폴더가 존재하는지.
						try {
							System.out.println("폴더가 이미 존재합니다.");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if (!folder.exists()) {// 폴더가 존재하지 않을때
						folder.mkdir();// mkdir-> 폴더 새로 생성
						fw = new BufferedWriter(new FileWriter(Path, true));
						System.out.println("폴더가 생성되었습니다.");
					}

					// 방 입장버튼
				} else if (line[0].compareTo(Protocol.ENTERROOM) == 0) {

					// 대기실인원중 내 ID
					System.out.println(waitUserList.size());
					String thisName = waitUserList.get(waitUserList.indexOf(this)).user.getIdName();
					String[] RoomListArr = null;
					String userid = null;
					boolean FirstRoom = true;

					String sql = "select * from UserContent where IDNAME = '" + this.user.getIdName() + "'";
					String updateSql = "update usercontent set RoomList=? where IDNAME=?";
					String userpath = path + "\\userFolder\\" + this.user.getIdName() + "\\Roomlist.txt";

					int roomid = Integer.parseInt(line[1]); // 룸ID

					int index = 0;
					for (int i = 0; i < roomtotalList.size(); i++) {
						// 전제룸리스트ID중에서 입장하는룸아이디와 같을때
						if (roomtotalList.get(i).getrID() == roomid) {
							roomtotalList.get(i).roomInUserList.add(this); // 방에 유저 넣고
							// waitUserList.get(i).pw.println(Protocol.ROOMMAKE_OK); // 룸리스트 새로고침
							// 방 만들었을때 방 정보를 room의 생성자의 priRoom
							priRoom = roomtotalList.get(i);
							index = i;
						}
					}

					ResultSet rs = pstmt.executeQuery(sql);
					while (rs.next()) {
						RoomListArr = rs.getString("RoomList").split("%");// DB 사용자 방 리스트
						userid = rs.getString("IDNAME");
					}
					String RoomNum = priRoom.getrID() + "";

					if (!Arrays.asList(RoomListArr).contains(RoomNum)) {
						System.out.println("방에 속해있지 않습니다.");

						fw = new BufferedWriter(new FileWriter(userpath, true));
						fw.write(priRoom.getrID() + "%");
						fw.flush();
						pstmt = conn.prepareStatement(updateSql);
						String roomId = Files.readString(Paths.get(userpath));
						pstmt.setString(1, roomId);
						pstmt.setString(2, user.getIdName());
						pstmt.executeUpdate();

					} else if (Arrays.asList(RoomListArr).contains(RoomNum)) {
						System.out.println("방에 이미 들어가있습니다.");
					}

					String roomListMessage = "";
					for (int i = 0; i < roomtotalList.size(); i++) {
						roomListMessage += (roomtotalList.get(i).getrID() + "%" + roomtotalList.get(i).getTitle() + "%"
								+ roomtotalList.get(i).getUserCount() + "%" + roomtotalList.get(i).getMasterName() + "%"
								+ roomtotalList.get(i).getSubject() + "%" + roomtotalList.get(i).roomInUserList.size()
								+ "-");
					}

					String roomMember = "";

					for (int i = 0; i < roomtotalList.get(index).roomInUserList.size(); i++) { // 룸안에 유저의 수만큼
						roomMember += (roomtotalList.get(index).roomInUserList.get(i).user.getIdName() + "%");
					}

					for (int i = 0; i < waitUserList.size(); i++) {
						// 방들어가는 사람에게는 바로 채팅화면으로
						// thisName = 대기실 인원중 내 ID
						if (waitUserList.get(i).user.getIdName().compareTo(thisName) == 0) {
							waitUserList.get(i).pw.println(Protocol.ENTERROOM_OK1 + "|" + user.getIdName());
							waitUserList.get(i).pw.flush();
						} else { // 채팅방들어가면 대기방에서 제외되므로 새로고침
							waitUserList.get(i).pw.println(Protocol.ROOMMAKE_OK + "|" + roomListMessage); // 룸리스트 새로고침
							waitUserList.get(i).pw.flush();
						}
					}

					System.out.println(path + "\\roomFolder\\" + priRoom.getrID() + "\\ChattingLog.txt");
					File TextTest = new File(path + "\\roomFolder\\" + priRoom.getrID() + "\\ChattingLog.txt");
					FileReader ReaderTest = new FileReader(TextTest);
					BufferedReader BufReaderTest = new BufferedReader(ReaderTest);
					List<String> LinesTest = new ArrayList<String>();
					String LineTest = "";
					try {
						while ((LineTest = BufReaderTest.readLine()) != null) {
							LinesTest.add(LineTest);
						}
						BufReaderTest.close();

						System.out.println("포문 시작?");
						for (int i = 0; i < LinesTest.size(); i++) {
							System.out.println(LinesTest.get(i));
						}
						System.out.println("포문 끝?");
					} catch (Exception e) {

					}

					// ----------------------------------------파일
					// 보류--------------------------------------
					String folder = path + "\\roomFolder\\" + priRoom.getrID() + "\\";
					System.out.println(folder);
					// 폴더명으로 파일객체 생성
					File file = new File(folder);

					// 폴더라면 폴더가 가진 파일객체를 리스트로 받는다.
					File[] list = file.listFiles();

					String fileList = "";
					// 리스트에서 파일을 하나씩 꺼낸다
					for (File f : list) {
						// 파일일 경우만 출력
						if (f.isFile()) {
							fileList += (f.getName() + "%");
						}
						System.out.println();
					}
					System.out.println("FileList : " + fileList);

					for (int i = 0; i < roomtotalList.get(index).roomInUserList.size(); i++) {
						if (!(roomtotalList.get(index).roomInUserList.get(i).user.getIdName() == user.getIdName())) {
							roomtotalList.get(index).roomInUserList.get(i).pw.println(Protocol.CHATTINGSENDMESSAGE_OK
									+ "|" + user.getIdName() + "|" + "님이 입장하셨습니다.!");
							roomtotalList.get(index).roomInUserList.get(i).pw.flush();
						}
					}
					pw.println(Protocol.ENTERROOM_USERLISTSEND + "|" + LinesTest + "|" + roomMember + "|"
							+ user.getIdName() + "|" + fileList);
					pw.flush();

					waitUserList.remove(this); // 대기방에서 나가고
					System.out.println("방입장동작 부분  -->>[대기실 인원수 ]" + waitUserList.size());
					// ----------------------------------------파일
					// 보류--------------------------------------

					String userline = ""; // 채팅창에

					for (int i = 0; i < waitUserList.size(); i++) {
						userline += (waitUserList.get(i).user.getIdName() + ":" + "");
					}
					for (int i = 0; i < waitUserList.size(); i++) {
						waitUserList.get(i).pw.println(
								Protocol.EXITWAITROOM + "|" + thisName + "|님이 " + roomid + "방에 입장하였습니다.|" + userline);

						waitUserList.get(i).pw.flush();
					}

					// 채팅방 나가 버튼
				} else if (line[0].compareTo(Protocol.EXITCHATTINGROOM) == 0) {

					for (int i = 0; i < roomtotalList.size(); i++) {// 전체방 리스트
						// 전체방리스트아이디와 현재룸아이디가 같을때
						if (roomtotalList.get(i).getrID() == priRoom.getrID()) {
							System.out.println("tsete");
							roomtotalList.get(i).roomInUserList.remove(this); // 방에 유저 빼고
							System.out.println(roomtotalList.get(i).roomInUserList.size());
							priRoom = new Room();// 현재룸을 비워주고

						}
					}

					String roomListMessage = "";

					System.out.println(roomListMessage);

					// waitUserList.add(this); // 대기방에서 추가
					if (roomtotalList.size() > 0) {// 방이 하나라도 있을 때
						roomListMessage = "";
						for (int i = 0; i < roomtotalList.size(); i++) {
							roomListMessage += (roomtotalList.get(i).getrID() + "%" + roomtotalList.get(i).getTitle()
									+ "%" + roomtotalList.get(i).getUserCount() + "%"
									+ roomtotalList.get(i).getMasterName() + "%" + roomtotalList.get(i).getSubject()
									+ "%" + roomtotalList.get(i).roomInUserList.size() + "-");
						}
					} else {
						roomListMessage = "-";
					}

					waitUserList.add(this);

					for (int i = 0; i < waitUserList.size(); i++) {
						waitUserList.get(i).pw.println(Protocol.ROOMMAKE_OK + "|" + roomListMessage); // 룸리스트 새로고침
						waitUserList.get(i).pw.flush();
					}

					System.out.println("방퇴실동작 부분  -->>[대기실 인원수 ]" + waitUserList.size());
					String userline = ""; // 채팅창에
					for (int i = 0; i < waitUserList.size(); i++) {
						userline += (waitUserList.get(i).user.getIdName() + ":");
					}
					for (int i = 0; i < waitUserList.size(); i++) {
						waitUserList.get(i).pw.println(
								Protocol.EXITWAITROOM + "|" + user.getIdName() + "|님이 대기실에에 입장하였습니다.|" + userline);
						waitUserList.get(i).pw.flush();
					}

					// 채팅방에서 메세지 보내기
				} else if (line[0].compareTo(Protocol.CHATTINGSENDMESSAGE) == 0) {
					// 전체방중에 내가 들어가있는 방의 참가한사람의 수
					int roomUserSize = roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.size();

					if (line.length == 2) {
						String contents[] = line[1].split("%");
						String message = contents[0];
						String id = contents[1];
						for (int i = 0; i < roomUserSize; i++) {
							System.out.println("id : "
									+ roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).user
											.getIdName()
									+ "sendid : " + id);
							if (roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).user.getIdName()
									.equals(id)) {
								System.out.println(line.length);
								roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).pw
										.println(Protocol.CHATTINGSENDMESSAGE_MASTER_OK + "|" + user.getIdName() + "|"
												+ message);
								String log = Protocol.CHATTINGSENDMESSAGE_MASTER_OK + "|" + user.getIdName() + "|"
										+ message;
								roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).pw.flush();
							} else {
								System.out.println(line.length);
								roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).pw.println(
										Protocol.CHATTINGSENDMESSAGE_OK + "|" + user.getIdName() + "|" + message);
								String log = Protocol.CHATTINGSENDMESSAGE_OK + "|" + user.getIdName() + "|" + message;
								roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).pw.flush();
							}

						}
						System.out.println("현재 작업 경로: " + path);

						String Path = path + "\\roomFolder\\" + priRoom.getrID() + "\\ChattingLog.txt";
						System.out.println("[" + user.getIdName() + "] : " + line[1]);
						fw = new BufferedWriter(new FileWriter(Path, true));
						fw.write("[" + user.getIdName() + "] : " + line[1] + "\n");
						fw.flush();
					}

				} else if (line[0].compareTo(Protocol.CHATTINGSCROLLBARDOWN) == 0) {
					int roomUserSize = roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.size();

					for (int i = 0; i < roomUserSize; i++) {
						roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).pw
								.println(Protocol.CHATTINGSCROLLBARDOWN + "|" + "message");
						roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).pw.flush();
					}
				} else if (line[0].compareTo(Protocol.CHATTINGFILESEND_SYN) == 0) // FIle전송 싱크
				{
					fileName = line[1];
					System.out.println(fileName);
					pw.println(Protocol.CHATTINGFILESEND_SYNACK + "|" + "Message");
					pw.flush();

				} else if (line[0].compareTo(Protocol.DISMANTINGROOM) == 0) {

					String userPath = path + "\\userFolder\\" + this.user.getIdName() + "\\Roomlist.txt";

					for (int i = 0; i < roomtotalList.size(); i++) {// 전체방 리스트
						// 전체방리스트아이디와 현재룸아이디가 같을때
						if (roomtotalList.get(i).getrID() == priRoom.getrID()) {

							// roomtotalList.get(i).roomInUserList.size() == 1 <- 내가 마지막일때
							if (priRoom.getMasterName().equals(this.user.getIdName())) { // 내가 방장일때
								System.out.println("나올때 내가 방장일때");
								// 방 지우지말고 리스트 유지해야되므로 주석처리
								pw.println(Protocol.DISMANTINGROOMMASTER + "|" + "모임을 해체했습니다.");
								pw.flush();

								String updateRoomlist = Files.readString(Paths.get(userPath));
								System.out.println();

								fw = new BufferedWriter(new FileWriter(userPath, false));
								fw.write(updateRoomlist.replace(priRoom.getrID() + "%", ""));
								fw.flush();
								fw.close();
								roomtotalList.remove(priRoom);
								System.out.println(roomtotalList);

								priRoom.roomInUserList.remove(this);
								System.out.println("this=" + this.toString());

								if (priRoom.roomInUserList.size() != 0) {
									for (int j = 0; j < priRoom.roomInUserList.size(); j++) {
										System.out.println("priRoom.userlist = " + priRoom.roomInUserList.size());
										String Path = path + "\\userFolder\\"
												+ priRoom.roomInUserList.get(i).user.getIdName() + "\\Roomlist.txt";
										String updateClientRoomlist = Files.readString(Paths.get(Path));
										fw = new BufferedWriter(new FileWriter(Path, false));
										fw.write(updateClientRoomlist.replace(priRoom.getrID() + "%", ""));
										fw.flush();
										fw.close();

										waitUserList.add(priRoom.roomInUserList.get(j));

										priRoom.roomInUserList.get(j).pw
												.println(Protocol.DISMANTINGROOM + "|" + "모임이 해체되었습니다.");
										priRoom.roomInUserList.get(j).pw.flush();
										roomtotalList.remove(priRoom);
									}
								}
								priRoom = new Room();

							} else if (!priRoom.getMasterName().equals(this.user.getIdName())) {

								priRoom.roomInUserList.remove(this);
								waitUserList.add(this);
								String Path = path + "\\userFolder\\" + this.user.getIdName() + "\\Roomlist.txt";
								String updateClientRoomlist = Files.readString(Paths.get(Path));
								fw = new BufferedWriter(new FileWriter(Path, false));
								fw.write(updateClientRoomlist.replace(priRoom.getrID() + "%", ""));
								fw.flush();
								fw.close();
								pw.println(Protocol.DISMANTINGROOMUSER + "|" + "모임을 탈퇴하였습니다.");
								pw.flush();

							}
						} else {
							System.out.println("권한이 없습니다.");
						}
					}

					String roomListMessage = "";

					System.out.println(roomListMessage);

					waitUserList.add(this); // 대기방에서 추가
					if (roomtotalList.size() > 0) {// 방이 하나라도 있을 때
						roomListMessage = "";
						for (int i = 0; i < roomtotalList.size(); i++) {
							roomListMessage += (roomtotalList.get(i).getrID() + "%" + roomtotalList.get(i).getTitle()
									+ "%" + roomtotalList.get(i).getUserCount() + "%"
									+ roomtotalList.get(i).getMasterName() + "%" + roomtotalList.get(i).getSubject()
									+ "%" + roomtotalList.get(i).roomInUserList.size() + "-");
						}
					} else {
						roomListMessage = "-";
					}

					for (int i = 0; i < waitUserList.size(); i++) {
						waitUserList.get(i).pw.println(Protocol.ROOMMAKE_OK + "|" + roomListMessage); // 룸리스트 새로고침
						waitUserList.get(i).pw.flush();
					}

					System.out.println("방퇴실동작 부분  -->>[대기실 인원수 ]" + waitUserList.size());
					String userline = ""; // 채팅창에
					for (int i = 0; i < waitUserList.size(); i++) {
						userline += (waitUserList.get(i).user.getIdName() + ":");
					}
					for (int i = 0; i < waitUserList.size(); i++) {
						waitUserList.get(i).pw.println(
								Protocol.EXITWAITROOM + "|" + user.getIdName() + "|님이 대기실에에 입장하였습니다.|" + userline);
						waitUserList.get(i).pw.flush();
					}

				} else if (line[0].compareTo(Protocol.CHATTINGFILESEND_FILE) == 0) {// 파일전송3

					System.out.println("총 보낸 Size : " + line[1]);

					long filesize = Long.parseLong(line[1]);

					// InputStream-> 통로, 한번 읽은것은 다시 되돌아 읽을 수 없음.
					InputStream is = socket.getInputStream();

					// 저장할 파일출력스트림 객체 생성
					String filepath = path + "\\roomFolder\\" + priRoom.getrID() + "\\" + fileName;
					// FileOutputStream-> 데이터를 파일에 바이트 스트림으로 저장하기 위해 사용한다.
					FileOutputStream fos = new FileOutputStream(filepath);

					System.out.println("파일 다운로드 시작 !!!");

					// 보내온 파일 내용을 파일에 저장
					byte[] b = new byte[104857600];

					int n = 0;
					while ((n = is.read(b, 0, b.length)) > 0) {
						fos.write(b, 0, n);
						System.out.println("N:" + n);
						System.out.println(n + "bytes 다운로드 !!!");
						n += n;
						if (n >= filesize)
							break;
					}

					fos.close();
					System.out.println("파일 다운로드 끝 !!!");

					String folder = path + "\\roomFolder\\" + priRoom.getrID() + "\\";
					// 폴더명으로 파일객체 생성
					File file = new File(folder);

					// 폴더라면 폴더가 가진 파일객체를 리스트로 받는다.
					File[] list = file.listFiles();

					String fileList = "";
					// 리스트에서 파일을 하나씩 꺼낸다
					for (File f : list) {
						// 파일일 경우만 출력
						if (f.isFile()) {
							fileList += (f.getName() + "%");
						}
					}

					int roomUserSize = roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.size();

					for (int i = 0; i < roomUserSize; i++) {
						roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).pw
								.println(Protocol.CHATTINGFILESEND_FILEACK + "|" + fileList); // 채팅방
																								// 사람들에게
																								// 파일 내용
						roomtotalList.get(roomtotalList.indexOf(priRoom)).roomInUserList.get(i).pw.flush();
					}

				} else if (line[0].compareTo(Protocol.ENTERLOGIN_USERINFOMATION_CHECK) == 0) {
					String[] update = line[1].split("%");
					if (user.getPassword().equals(update[0])) {
						pw.println(Protocol.ENTERLOGIN_USERINFOMATION_CHECK + "|" + update[1]);
						pw.flush();
					} else {
						pw.println(Protocol.ENTERLOGIN_USERINFOMATION_CHECK_NOT + "|" + update[1]);
						pw.flush();
					}

				} else if (line[0].compareTo(Protocol.CHATTINGFILEDOWNLOAD_SYN) == 0) // 파일 다운로드 보냄
				{
					String folder = path + "\\roomFolder\\" + priRoom.getrID() + "\\";
					// 폴더명으로 파일객체 생성
					File file = new File(folder);

					// 폴더라면 폴더가 가진 파일객체를 리스트로 받는다.
					File[] list = file.listFiles();

					File selectedFile = new File(folder);
					// 리스트에서 파일을 하나씩 꺼낸다
					for (File f : list) {
						// 파일일 경우만 출력
						if (f.isFile()) {
							if (f.getName().compareTo(line[1]) == 0) // 파일이 있으면
							{
								selectedFile = f;
							}
						}
					}

					System.out.println("받은 파일 명" + selectedFile.getName() + "/" + selectedFile.length());

					pw.println(Protocol.CHATTINGFILEDOWNLOAD_SEND + "|" + selectedFile.length());
					pw.flush();

					OutputStream os = socket.getOutputStream();

					System.out.println("파일 보내기 시작 !!!");
					// 보낼 파일의 입력 스트림 객체 생성
					String fileRouth = folder + selectedFile.getName();
					FileInputStream fis = new FileInputStream(fileRouth);

					long filesize = selectedFile.length();

					// 파일의 내용을 보낸다
					byte[] b = new byte[104857600];
					int n;
					while ((n = fis.read(b, 0, b.length)) > 0) {
						os.write(b, 0, n);
						System.out.println(n + "bytes 보냄 !!!");
						n += n;
						if (n >= filesize)
							break;
					}
				} else if (line[0].compareTo(Protocol.UPDATE_NAME) == 0) { // 이름수정

					System.out.println("이름 수정");

					String updateSql = "update usercontent set name=? where IDNAME=?";

					pstmt = conn.prepareStatement(updateSql);

					pstmt.setString(1, line[1]);
					pstmt.setString(2, user.getIdName());
					pstmt.executeUpdate();

				} else if (line[0].compareTo(Protocol.UPDATE_IDNAME) == 0) { // 아이디 수정
					System.out.println("아이디 수정");

					String updateSql = "update usercontent set IDNAME=? where priNumber=?";

					pstmt = conn.prepareStatement(updateSql);

					pstmt.setString(1, line[1]);
					pstmt.setInt(2, user.getPryNumber());
					pstmt.executeUpdate();
				} else if (line[0].compareTo(Protocol.UPDATE_PASSWORD) == 0) { // 패스워드 수정
					System.out.println("패스워드 수정");

					String updateSql = "update usercontent set PASSWORD=? where priNumber=?";
					user.setPassword(line[1]);
					pstmt = conn.prepareStatement(updateSql);

					pstmt.setString(1, line[1]);
					pstmt.setInt(2, user.getPryNumber());
					pstmt.executeUpdate();
				} else if (line[0].compareTo(Protocol.UPDATE_MAIL) == 0) { // 패스워드 수정
					System.out.println("이메일 수정");

					String updateSql = "update usercontent set EMAIL=? where priNumber=?";

					pstmt = conn.prepareStatement(updateSql);

					pstmt.setString(1, line[1]);
					pstmt.setInt(2, user.getPryNumber());
					pstmt.executeUpdate();
				} else if (line[0].compareTo(Protocol.UPDATE_BIRTH) == 0) { // 패스워드 수정
					System.out.println("생일 수정");

					String updateSql = "update usercontent set AGE=? where priNumber=?";

					pstmt = conn.prepareStatement(updateSql);

					pstmt.setString(1, line[1]);
					pstmt.setInt(2, user.getPryNumber());
					pstmt.executeUpdate();
				}

			} // while

			br.close();
			pw.close();
			socket.close();

		} catch (IOException io) {
			io.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
