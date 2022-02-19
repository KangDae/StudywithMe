package Server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DTO.Protocol;
import Resource.R;

import shareDisplay.Display_Server;
import shareDisplay.Display_Client;

public class ClientHandler extends R implements Runnable {
	
	BufferedReader br;
	PrintWriter pw;
	Socket socket;
	
	
	Display_Server displayServer;
	Display_Client displyClient;
	
	

	public ClientHandler() {
		br = Client_network.br;
		pw = Client_network.pw;
		socket = Client_network.socket;
	}

	@Override
	public void run() {
		// 받는쪽
		String line[] = null;
		String ip ="";
		while (true) {
			try {
				line = br.readLine().split("\\|");
				if (line == null) {
					br.close();
					pw.close();
					socket.close();

					System.exit(0);
				} else if (line[0].compareTo(Protocol.IDSEARCHCHECK_OK) == 0) { // 회원가입 ID 중복 안됨
					JOptionPane.showMessageDialog(this, "사용가능");
					R.condition_ID = true;
				} else if (line[0].compareTo(Protocol.IDSEARCHCHECK_NO) == 0) { // 회원가입 ID 중복 됨
					JOptionPane.showMessageDialog(this, "사용 불가능");
					R.condition_ID = false;
				} else if (line[0].compareTo(Protocol.IDSEARCH_OK) == 0) { // ID 찾기 기존에 있음
					JOptionPane.showMessageDialog(this, line[1]);
					frameSearchID.frameDown();
					frameLogin.start();
				} else if (line[0].compareTo(Protocol.IDSEARCH_NO) == 0) { // ID가 없음
					JOptionPane.showMessageDialog(this, line[1]);
					frameSearchID.frameDown();
					frameStart.start();
					;
				} else if (line[0].compareTo(Protocol.PWRESET_OK) == 0) { // PW 재설정창 확인
					JOptionPane.showMessageDialog(this, line[1]);
					System.out.println("재설정 버튼");
					frameSearchPW.frameDown();
					frameLogin.start();
				} else if (line[0].compareTo(Protocol.PWRESET_NO) == 0) // PW가 없음
				{
					JOptionPane.showMessageDialog(this, line[1]);
					frameSearchPW.frameDown();
					frameLogin.start();
				} else if (line[0].compareTo(Protocol.PWSEARCH_OK) == 0) // PW 찾기 기존에 있음
				{
					JOptionPane.showMessageDialog(this, line[1]);
					framePassWordCheck.start();
				} else if (line[0].compareTo(Protocol.PWSEARCH_NO) == 0) // PW가 없음
				{
					JOptionPane.showMessageDialog(this, line[1]);
					frameSearchPW.start();
					framePassWordCheck.frameDown();
					frameLogin.frameDown();
				} else if (line[0].compareTo(Protocol.ENTERLOGIN_OK) == 0) // 로그인 성공
				{

					frameLogin.frameDown();
					frameCenter.start();
					frameCenter.Center_textArea_Chatting.append(line[1] + line[2] + '\n');

					String text[] = line[3].split(":");
					frameCenter.containWaitpanelClear(); // 룸 프레임에 컨테이너를 비워주고
					for (int i = 0; i < text.length; i++) {
						frameCenter.waitUserPanel[i].init();
						frameCenter.waitUserPanel[i].labelArray[1].setText(text[i]);
					}
					pw.println(Protocol.MYFRIENDS_LIST + "|" + "message");
					pw.flush();

				} else if (line[0].compareTo(Protocol.ENTERLOGIN_OK_USERINFOMATION) == 0) {
					String[] userinfo = line[1].split("%");
					for (int i = 0; i < userinfo.length; i++) {
						System.out.println(userinfo[i]);
					}
					frameCenter.lbl_userName.setText(userinfo[0]);
					frameCenter.lbl_userId.setText(userinfo[1]);
					frameCenter.lbl_userpw.setText(userinfo[2]);
					frameCenter.lbl_userEmail.setText(userinfo[3]);
					frameCenter.lbl_userBirth.setText(userinfo[4]);

				} else if (line[0].compareTo(Protocol.ENTERLOGIN_NO) == 0) // 로그인 실패
				{
					JOptionPane.showMessageDialog(this, line[1]);
					System.out.println("로그인실패");
				} else if (line[0].compareTo(Protocol.EXITWAITROOM) == 0) // 로그아웃 [대기실 -> 로그인페이지]
				{
					frameCenter.Center_textArea_Chatting.append(line[1] + line[2] + '\n');

					String text[] = line[3].split(":");
					String userlist = "";
					frameCenter.containWaitpanelClear(); // 룸 프레임에 컨테이너를 비워주고
					for (int i = 0; i < text.length; i++) {
						frameCenter.waitUserPanel[i].init();
						frameCenter.waitUserPanel[i].labelArray[1].setText(text[i]);
					}
					pw.println(Protocol.MYFRIENDS_LIST + "|" + "message");
					pw.flush();

				} else if (line[0].compareTo(Protocol.SENDMESSAGE_ACK) == 0) { // 서버로 메세지 받음 [대기실]
					frameCenter.Center_textArea_Chatting.append("[" + line[1] + "] :" + line[2] + '\n');
				} else if (line[0].compareTo(Protocol.ROOMSORT) == 0) { // 방정렬

					System.out.println(line[0] + "엔터프레임 라인0");

					if (line.length == 1) {
						System.out.println("비어있습니다.");
						frameCenter.repaint();
						frameCenter.containPanelClear();
					} else {

						String roomList[] = line[1].split("-"); // 방세부

						String roomListDetail[];

						frameCenter.containPanelClear(); // 룸 프레임에 컨테이너를 비워주고
						for (int i = 0; i < roomList.length; i++) {
							System.out.println(roomList[i].toString() + "룸리스트i 투스트링부분");
							roomListDetail = roomList[i].split("%");
							System.out.println(roomListDetail.length);

							frameCenter.panelRoomList[i].init(); // 방리스트를 받은거로 다시 생성해주고
							String userNumber = "";

							userNumber += (roomListDetail[5] + "/" + roomListDetail[2]);
							frameCenter.panelRoomList[i].labelArray[1].setText(roomListDetail[0]); // 방번호
							frameCenter.panelRoomList[i].labelArray[3].setText(roomListDetail[4]); // 방주제
							frameCenter.panelRoomList[i].labelArray[5].setText(userNumber); // 인원수
							frameCenter.panelRoomList[i].labelArray[7].setText(roomListDetail[1]); // 방제목
							frameCenter.panelRoomList[i].labelArray[8].setText("개설자 : " + roomListDetail[3]); // 개설자

							System.out.println("userNumber : " + userNumber);
						}
					}

				} else if (line[0].compareTo(Protocol.SearchRoom) == 0) {
					// 방 검색 실패했을때
					if (line.length == 1) {
						JOptionPane.showMessageDialog(btn_Confirm, "검색을 실패하였습니다.");
						frameCenter.repaint();
						frameCenter.containPanelClear();
					}
					// 방 검색 성공했을때
					else {
						JOptionPane.showMessageDialog(btn_Confirm, "검색을 성공하였습니다.");
						String roomList[] = line[1].split("-"); // 방세부
						String roomListDetail[];

						frameCenter.containPanelClear(); // 룸 프레임에 컨테이너를 비워주고
						for (int i = 0; i < roomList.length; i++) {
							roomListDetail = roomList[i].split("%");
							System.out.println(roomListDetail.length);

							frameCenter.panelRoomList[i].init(); // 방리스트를 받은거로 다시 생성해주고
							String userNumber = "";

							userNumber += (roomListDetail[5] + "/" + roomListDetail[2]);
							frameCenter.panelRoomList[i].labelArray[1].setText(roomListDetail[0]); // 방번호
							frameCenter.panelRoomList[i].labelArray[3].setText(roomListDetail[4]); // 방주제
							frameCenter.panelRoomList[i].labelArray[5].setText(userNumber); // 인원수
							frameCenter.panelRoomList[i].labelArray[7].setText(roomListDetail[1]); // 방제목
							frameCenter.panelRoomList[i].labelArray[8].setText("개설자 : " + roomListDetail[3]); // 개설자

							System.out.println("userNumber : " + userNumber);
						}
					}
				}

				else if (line[0].compareTo(Protocol.ROOMMAKE_OK) == 0) // 방만들어짐
				{

					String roomList[] = line[1].split("-"); // 방 갯수
					String roomfirst[] = line[1].split("%");
					
					for (int i = 0; i < roomList.length; i++) {
						System.out.print(roomList[i] + "/");
					}

					String roomListDetail[]; // 방세부
					System.out.println("RoomList size : " + roomList.length);

					frameCenter.containPanelClear(); // 룸 프레임에 컨테이너를 비워주고
					for (int i = 0; i < roomList.length; i++) {

						frameCenter.panelRoomList[i].init(); // 방리스트를 받은거로 다시 생성해주고
						roomListDetail = roomList[i].split("%");
						String userNumber = "";

						userNumber += (roomListDetail[5] + "/" + roomListDetail[2]);
						frameCenter.panelRoomList[i].labelArray[1].setText(roomListDetail[0]); // 방번호
						frameCenter.panelRoomList[i].labelArray[3].setText(roomListDetail[4]); // 방주제
						frameCenter.panelRoomList[i].labelArray[5].setText(userNumber); // 인원수
						frameCenter.panelRoomList[i].labelArray[7].setText(roomListDetail[1]); // 방제목
						frameCenter.panelRoomList[i].labelArray[8].setText("개설자 : " + roomListDetail[3]); // 개설자

						System.out.println("userNumber : " + userNumber);

					}
					frameChattingRoom.chatting_chattingPanel.removeAll();
					frameChattingRoom.chatting_chattingPanel.repaint();
					frameChattingRoom.Chatting_textarea_Inuserlist.setText("");
					frameChattingRoom.btn_ShareDisplay.setEnabled(true);
					frameChattingRoom.ExplainSharer.setText("");
					
					frameChattingRoom.Chatting_textarea_Inuserlist.setText(roomfirst[3]);// 방장 추가

					// frameCenter.frameDown(); // 대기방 화면 끄고

				} else if (line[0].compareTo(Protocol.ROOMMAKE_OK1) == 0) // 방만들어짐 (만든 당사자) // 입장
				{
					System.out.println("방장 입장화면 변환");
					frameMakeRoom.frameDown(); // 대기방 화면 끄고
					System.out.println("RoomMaker: " + line[1]);
					frameChattingRoom.vertical.removeAll();
					frameChattingRoom.setVisible(true);
					frameChattingRoom.Chatting_textarea_Inuserlist.setText(line[1]);

				} else if (line[0].compareTo(Protocol.ENTERROOM_OK1) == 0) // 방입장 입장하는 당사자
				{
					System.out.println("입장화면 변환");
					frameCenter.frameDown();

					frameChattingRoom.vertical.removeAll();
					frameChattingRoom.Chatting_textarea_Inuserlist.setText("");
					frameChattingRoom.setVisible(true);

//					String roomMember[] = line[2].split("%");//룸에 들어온사람들
//					frameChattingRoom.Chatting_textarea_Inuserlist.append(line[1]); //자기 추가해주고
//					for (int i = 0; i < roomMember.length; i++) {
//						frameChattingRoom.Chatting_textarea_Inuserlist.append(roomMember[i] + "\n");
//					}

				} else if (line[0].compareTo(Protocol.CHATTINGSENDMESSAGE_MASTER_OK) == 0) {
					if (line.length == 3) {
						String message = line[2];
						JPanel panel = frameChattingRoom.formatLabel(message);
						JPanel right = new JPanel(new BorderLayout());
						right.add(panel, BorderLayout.LINE_END);
						frameChattingRoom.vertical.add(right);
						frameChattingRoom.chatting_chattingPanel.repaint();
					}
				} else if (line[0].compareTo(Protocol.CHATTINGSENDMESSAGE_OK) == 0) {
					if (line.length == 3) {
						String message = "[" + line[1] + "] :" + line[2];
						JPanel p2 = frameChattingRoom.formatLabel(message);
						JPanel left = new JPanel(new BorderLayout());
						left.add(p2, BorderLayout.LINE_START);
						frameChattingRoom.vertical.add(left);
						frameChattingRoom.chatting_chattingPanel.repaint();
					}
				} else if (line[0].compareTo(Protocol.CHATTINGSCROLLBARDOWN) == 0) {
					try {

						Thread.sleep(500);
						frameChattingRoom.scroll_chatting.getVerticalScrollBar()
								.setValue(frameChattingRoom.scroll_chatting.getVerticalScrollBar().getMaximum());

					} catch (Exception e) {
						System.out.println(e);
					}

				} else if (line[0].compareTo(Protocol.CHATTINGFILESEND_SYNACK) == 0) {

					pw.println(Protocol.CHATTINGFILESEND_FILE + "|" + frameChattingRoom.file.length());
					pw.flush();

					OutputStream os = socket.getOutputStream();

					System.out.println("파일 보내기 시작 !!!");
					// 보낼 파일의 입력 스트림 객체 생성
					FileInputStream fis = new FileInputStream(frameChattingRoom.file.getAbsoluteFile());

					// 파일의 내용을 보낸다

					byte[] b = new byte[104857600];

					int n;
					while ((n = fis.read(b, 0, b.length)) > 0) {
						os.write(b, 0, n);
						System.out.println(n + "bytes 보냄 !!!");
					}

					// 소켓에서 보낼 출력 스트림을 구한다.
				} else if (line[0].compareTo(Protocol.CHATTINGFILESEND_FILEACK) == 0) {

					String[] fileList = line[1].split("%");

					frameChattingRoom.model.removeAllElements();
					for (int i = 0; i < fileList.length; i++) {
						frameChattingRoom.model.addElement(fileList[i]);
					}

				} else if (line[0].compareTo(Protocol.ENTERROOM_USERLISTSEND) == 0) {

					System.out.println("enter room");
					String LinesTest[] = line[1].split(", ");
					String roomMember[] = line[2].split("%");// 룸에 들어온사람들
					String LinesTest1 = "";
					String lineList = "";

					for (int i = 0; i < LinesTest.length; i++) {
						LinesTest1 += (LinesTest[i] + "-\n");
					}

					for (int i = 0; i < roomMember.length; i++) {
						lineList += (roomMember[i] + "\n");
					}

					String testNew[] = LinesTest1.replace("[", "").replace("]", "").replace(" ", "").split("-");
					LinesTest1 = "";
					for (int i = 0; i < testNew.length - 1; i++) {
						testNew[i] = testNew[i].substring(testNew[i].indexOf(":") + 1);
						LinesTest1 += (testNew[i] + "%");
					}
					int j = 0;
					String text[] = LinesTest1.split("%");
					String ids[] = new String[text.length / 2];
					String messages[] = new String[text.length / 2];
					for (int i = 0; i < text.length; i++) {
						if (i == 0 || i % 2 == 1) {
							ids[j] = text[i];
						} else {
							messages[j] = text[i];
							j++;
						}
					}
					for (int i = 0; i < messages.length - 1; i++) {
						if (line[3].equals(ids[i])) {

							JPanel panel = frameChattingRoom.formatLabel(messages[i]);
							JPanel right = new JPanel(new BorderLayout());
							right.add(panel, BorderLayout.LINE_END);
							frameChattingRoom.vertical.add(right);
							frameChattingRoom.chatting_chattingPanel.repaint();
						} else {
							String message = "[" + ids[i] + "] :" + messages[i];
							JPanel p2 = frameChattingRoom.formatLabel(messages[i]);
							JPanel left = new JPanel(new BorderLayout());
							left.add(p2, BorderLayout.LINE_START);
							frameChattingRoom.vertical.add(left);
							frameChattingRoom.chatting_chattingPanel.repaint();
						}
					}
					frameChattingRoom.Chatting_textarea_Inuserlist.setText(lineList);
					String message = "[" + "환영합니다" + line[3] + "회원님" + "]";
					JPanel p2 = frameChattingRoom.formatLabel(message);
					JPanel left = new JPanel(new BorderLayout());
					left.add(p2, BorderLayout.LINE_START);
					frameChattingRoom.vertical.add(left);
					frameChattingRoom.chatting_chattingPanel.repaint();

					try {
						frameChattingRoom.chatting_chattingPanel.setLayout(new BorderLayout());
						frameChattingRoom.vertical.add(Box.createVerticalStrut(5));
						frameChattingRoom.vertical.setBackground(new Color(173, 216, 230));
						frameChattingRoom.chatting_chattingPanel.add(frameChattingRoom.vertical,
								BorderLayout.PAGE_START);
						frameChattingRoom.chatting_chattingPanel.repaint();
						Thread.sleep(500);
						frameChattingRoom.scroll_chatting.getVerticalScrollBar()
								.setValue(frameChattingRoom.scroll_chatting.getVerticalScrollBar().getMaximum());

					} catch (Exception e) {
						System.out.println(e);
					}

					if (line.length == 4) {
						String fileList[] = line[5].split("%");
						frameChattingRoom.model.removeAllElements();
						for (int i = 0; i < fileList.length; i++) {
							frameChattingRoom.model.addElement(fileList[i]);
						}
					}

				} else if (line[0].compareTo(Protocol.CHATTINGFILEDOWNLOAD_SEND) == 0) { // 파일을 받음
					String path = frameChattingRoom.file.getAbsolutePath();

					FileOutputStream fos = new FileOutputStream(path);
					InputStream is = socket.getInputStream();

					System.out.println("파일 다운로드 시작 !!!");

					// 보내온 파일 내용을 파일에 저장

					byte[] b = new byte[104857600];

					int n = 0;
					long filesize = Long.parseLong(line[1]);

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

				} else if (line[0].compareTo(Protocol.ENTERLOGIN_USERINFOMATION_CHECK) == 0) { // 비밀번호가 맞았을때
					if (line[1].equals("이름")) {
						frameUserPasswordCheck.frameDown();
						frameUpdateName.start();
					} else if (line[1].equals("아이디")) {
						frameUserPasswordCheck.frameDown();
						frameUpdateIdname.start();
					} else if (line[1].equals("비밀번호")) {
						frameUserPasswordCheck.frameDown();
						frameUpdatePassword.start();
					} else if (line[1].equals("이메일")) {
						frameUserPasswordCheck.frameDown();
						frameUpdateEmail.start();
					} else if (line[1].equals("생년월일")) {
						frameUserPasswordCheck.frameDown();
						frameUpdateBirth.start();
					}
				} else if (line[0].compareTo(Protocol.ENTERLOGIN_USERINFOMATION_CHECK_NOT) == 0) { // 비밀번호가 틀렸을때
					JOptionPane.showMessageDialog(R.btn_Confirm, "비밀번호가 틀렸습니다.");

				} else if (line[0].compareTo(Protocol.DISMANTINGROOM) == 0) {

					JOptionPane.showMessageDialog(R.btn_Confirm, "강퇴되었습니다.");

					frameChattingRoom.frameDown();
					frameCenter.start();

				} else if (line[0].compareTo(Protocol.DISMANTINGROOMMASTER) == 0) {

					JOptionPane.showMessageDialog(R.btn_Confirm, "모임을 해체했습니다.");

					frameChattingRoom.frameDown();
					frameCenter.start();
				} else if (line[0].compareTo(Protocol.DISMANTINGROOMUSER) == 0) {

					JOptionPane.showMessageDialog(R.btn_Confirm, "모임을 탈퇴했습니다.");

					frameChattingRoom.frameDown();
					frameCenter.start();

				} else if (line[0].compareTo(Protocol.ADDFRIENDS_ASK) == 0) {
					String[] userContents = line[1].split("%");
					if (userContents.length == 2) {
						int result = JOptionPane.showConfirmDialog(null, userContents[0] + "님께서 친구추가 요청을 하였습니다.");
						if (result == JOptionPane.YES_OPTION) {
							pw.println(Protocol.ADDFRIENDS_ANSWER + "|" + userContents[0] + "%" + userContents[1] + "%"
									+ "OK");
							pw.flush();
						} else {
							pw.println(Protocol.ADDFRIENDS_ANSWER + "|" + userContents[0] + "%" + userContents[1] + "%"
									+ "NO");
							pw.flush();
						}
					} else {
						JOptionPane.showMessageDialog(R.btn_Confirm, "자기자신은 누구보다 친한 친구입니다.");
					}

				} else if (line[0].compareTo(Protocol.ADDFRIENDS_ALREADY) == 0) {
					JOptionPane.showMessageDialog(R.btn_Confirm, "이미 친구로 등록되어있습니다. !");
				} else if (line[0].compareTo(Protocol.ADDFRIENDS_NO) == 0) {
					JOptionPane.showMessageDialog(R.btn_Confirm, line[1] + "친구요청이 거절되었습니다.");
				} else if (line[0].compareTo(Protocol.MYFRIENDS_LIST) == 0) {
					if (line.length == 1) {
						System.out.println("비어있습니다.");
						frameCenter.repaint();
						frameCenter.containFriendsClear();
					} else {

						String friendsList[] = line[1].split("-"); // 방세부

						String friendsOnLie[];

						frameCenter.containFriendsClear(); // 룸 프레임에 컨테이너를 비워주고
						for (int i = 0; i < friendsList.length; i++) {
							friendsOnLie = friendsList[i].split("%");
							System.out.println(friendsOnLie.length);
							if (friendsOnLie[0] != "") {
								frameCenter.friendsPanel[i].init(); // 방리스트를 받은거로 다시 생성해주고
								String userNumber = "";

								frameCenter.friendsPanel[i].labelArray[1].setText(friendsOnLie[0]);
								frameCenter.friendsPanel[i].labelArray[2].setText(friendsOnLie[1]);
							}
						}
					}
				} else if (line[0].compareTo(Protocol.MYFRIENDS_LIST_RESET) == 0) {
					pw.println(Protocol.MYFRIENDS_LIST + "|" + "message");
					pw.flush();

				} else if (line[0].compareTo(Protocol.ENTERNOTICEBOARD) ==0) {
					
					
					
					String NoticeList[] = line[1].split("\\*"); // 게시판 갯수
					
					
					for (int i = 0; i < NoticeList.length; i++) {
						System.out.print(NoticeList[i] + "/");
					}

					String NoticeListDetail[]; // 게시판 세부
					System.out.println("NoticeList size : " + NoticeList.length);

					frameCenter.containNoticePanelClear(); // 룸 프레임에 컨테이너를 비워주고
					for (int i = 0; i < NoticeList.length; i++) {

						frameCenter.noticeboardList[i].init(); // 방리스트를 받은거로 다시 생성해주고
						NoticeListDetail = NoticeList[i].split("%");

						
						frameCenter.noticeboardList[i].labelArray[1].setText(NoticeListDetail[0]);// 게시판 번호
						frameCenter.noticeboardList[i].labelArray[3].setText(NoticeListDetail[1]); // 게시판 제목
						frameCenter.noticeboardList[i].labelArray[5].setText(NoticeListDetail[2]); // 게시판 게시자
						frameCenter.noticeboardList[i].labelArray[7].setText(NoticeListDetail[3]); // 게시판 날짜

						

					}
				
					// frameCenter.frameDown(); // 대기방 화면 끄고
					
				} else if (line[0].compareTo(Protocol.WRITENOTICEBOARD_MASTER)==0) {
					
					
					System.out.println("게시자 입장화면 변환");
					noticewrite.framedown(); // 대기방 화면 끄고
					System.out.println("NoticeMaker: " + line[1]);

					noticeview.start();
					noticeview.Title_Textfield.setText(line[1]);
					noticeview.Text_Content.setText(line[2]);
					noticeview.lblNewLabel_3.setText(line[3]);
					
					
				} else if(line[0].compareTo(Protocol.ENTERNOTICEBOARD_SERVER)==0) {
					System.out.println(line[1]);
					
					noticeview.start();
					noticeview.Title_Textfield.setText(line[2]);
					noticeview.lblNewLabel_3.setText(line[3]);
					noticeview.Text_Content.setText(line[4]);
					
				} else if(line[0].compareTo(Protocol.EDITSHAREUI)==0) {
					System.out.println("line 길이는 "+line.length);
					System.out.println("line[1]="+line[1]);
					System.out.println("line[2]="+line[2]);
					
					ip =line[2];
					
					frameChattingRoom.ExplainSharer.setText(line[1]+"님이 화면 공유 중입니다.");
					frameChattingRoom.btn_ShareDisplay.setEnabled(false);
//					frameChattingRoom.btn_Shutdown.setEnabled(false);
					
					
				} else if(line[0].compareTo(Protocol.STOPSHARE)==0) {
					
					System.out.println("STOPSHARE Client");
					displayServer.server.close();
					
					frameChattingRoom.ExplainSharer.setText("");
					frameChattingRoom.btn_ShareDisplay.setEnabled(true);
					
				} else if(line[0].compareTo(Protocol.SHAREDISPLAY)==0) {
					
					frameChattingRoom.ExplainSharer.setText(line[1]+"님이 화면 공유 중입니다.");
					frameChattingRoom.btn_ShareDisplay.setEnabled(false);
					displayServer = new Display_Server();
					displayServer.Start();
					
				} else if(line[0].compareTo(Protocol.WATCHDISPLAY)==0) {
					
					displyClient = new Display_Client();
					displyClient.start(ip);
					
				} else if(line[0].compareTo(Protocol.STOPWATCH)==0) {
					
					displyClient.stop();
				}

			} catch (IOException io) {
				io.printStackTrace();
			}

		} // while
	}
}
