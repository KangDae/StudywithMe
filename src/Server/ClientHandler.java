package Server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import DTO.Protocol;
import Resource.R;

public class ClientHandler extends R implements Runnable{
	BufferedReader br;
	PrintWriter pw;
	Socket socket;
	public ClientHandler(){
		br = Client_network.br;
		pw = Client_network.pw;
		socket = Client_network.socket;
	}
	@Override
	public void run() {
		// 받는쪽
		String line[] = null;
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
					condition_Id = true;
					
				} else if (line[0].compareTo(Protocol.IDSEARCHCHECK_NO) == 0) { // 회원가입 ID 중복 됨
					JOptionPane.showMessageDialog(this, "사용 불가능");
					condition_Id = false;
				} else if (line[0].compareTo(Protocol.IDSEARCH_OK) == 0) { // ID 찾기 기존에 있음
					JOptionPane.showMessageDialog(this, line[1]);
					searchF.setVisible(false);
					this.setVisible(true);
				} else if (line[0].compareTo(Protocol.IDSEARCH_NO) == 0) { // ID가 없음
					JOptionPane.showMessageDialog(this, line[1]);
					searchF.setVisible(false);
					this.setVisible(true);
				} else if (line[0].compareTo(Protocol.PWRESET_OK) == 0) { // PW 재설정창 확인
					JOptionPane.showMessageDialog(this, line[1]);
					System.out.println("재설정 버튼");
					searchpwF.setVisible(false);
					this.setVisible(false);
				} else if (line[0].compareTo(Protocol.PWRESET_NO) == 0) // PW가 없음
				{
					JOptionPane.showMessageDialog(this, line[1]);
					searchpwF.setVisible(false);
					this.setVisible(true);
				} else if (line[0].compareTo(Protocol.PWSEARCH_OK) == 0) // PW 찾기 기존에 있음
				{
					JOptionPane.showMessageDialog(this, line[1]);
					newpasswordF.setVisible(true);
					// this.setVisible(true);
				} else if (line[0].compareTo(Protocol.PWSEARCH_NO) == 0) // PW가 없음
				{
					JOptionPane.showMessageDialog(this, line[1]);
					searchpwF.setVisible(true);
					newpasswordF.setVisible(false);
					this.setVisible(false);
				} else if (line[0].compareTo(Protocol.ENTERLOGIN_OK) == 0) // 로그인 성공
				{
					this.setVisible(false);
					RoomF.setVisible(true);
					RoomF.chatarea.append(line[1] + line[2] + '\n');

					String text[] = line[3].split(":");
					String userlist = "";
					for (int i = 0; i < text.length; i++) {
						userlist += (text[i] + "\n");
					}
					RoomF.usertxt.setText(userlist);

				} else if (line[0].compareTo(Protocol.ENTERLOGIN_NO) == 0) // 로그인 실패
				{
					JOptionPane.showMessageDialog(this, line[1]);
					System.out.println("로그인실패");
				} else if (line[0].compareTo(Protocol.EXITWAITROOM) == 0) // 로그아웃 [대기실 -> 로그인페이지]
				{
					RoomF.chatarea.append(line[1] + line[2] + '\n');

					String text[] = line[3].split(":");
					String userlist = "";
					for (int i = 0; i < text.length; i++) {
						userlist += (text[i] + "\n");
					}
					RoomF.usertxt.setText(userlist);

				} else if (line[0].compareTo(Protocol.SENDMESSAGE_ACK) == 0){ // 서버로 메세지 받음 [대기실]
				
					RoomF.chatarea.append("[" + line[1] + "] :" + line[2] + '\n');


				} else if (line[0].compareTo(Protocol.ROOMSORT) == 0) { //방정렬

					System.out.println(line[0] + "엔터프레임 라인0");
					

					if (line.length == 1) {
						System.out.println("비어있습니다.");
						RoomF.repaint();
						RoomF.containPanelClear();
				    }else {

						String roomList[] = line[1].split("-"); // 방세부

						String roomListDetail[];

						RoomF.containPanelClear(); // 룸 프레임에 컨테이너를 비워주고
						for (int i = 0; i < roomList.length; i++) {
							System.out.println(roomList[i].toString() + "룸리스트i 투스트링부분");
							roomListDetail = roomList[i].split("%");
							System.out.println(roomListDetail.length);

							RoomF.dp[i].init(); // 방리스트를 받은거로 다시 생성해주고
							String userNumber = "";
							if (roomListDetail.length == 8) // 공개방
							{
								userNumber += (roomListDetail[7] + "/" + roomListDetail[3]);
								RoomF.dp[i].labelArray[1].setText(roomListDetail[0]); // 방번호
								RoomF.dp[i].labelArray[3].setText(roomListDetail[5]); // 방주제
								RoomF.dp[i].labelArray[5].setText(userNumber); // 인원수
								RoomF.dp[i].labelArray[7].setText(roomListDetail[1]); // 방제목
								RoomF.dp[i].labelArray[8].setText("개설자 : " + roomListDetail[4]); // 개설자
							}
							System.out.println("userNumber : " + userNumber);
						}
					}

				} else if (line[0].compareTo(Protocol.ROOMMAKE_OK) == 0) // 방만들어짐
				{

					String roomList[] = line[1].split("-"); // 방 갯수
					for (int i = 0; i < roomList.length; i++) {
						System.out.print(roomList[i] + "/");
					}

					String roomListDetail[]; // 방세부
					System.out.println("RoomList size : " + roomList.length);

					RoomF.containPanelClear(); // 룸 프레임에 컨테이너를 비워주고
					for (int i = 0; i < roomList.length; i++) {

						RoomF.dp[i].init(); // 방리스트를 받은거로 다시 생성해주고
						roomListDetail = roomList[i].split("%");
						String userNumber = "";

						if (roomListDetail.length == 8) // 비공개방
						{
							userNumber += (roomListDetail[7] + "/" + roomListDetail[3]);

							RoomF.dp[i].labelArray[1].setText(roomListDetail[0]); // 방번호
							RoomF.dp[i].labelArray[3].setText(roomListDetail[5]); // 방주제
							RoomF.dp[i].labelArray[5].setText(userNumber); // 인원수
							RoomF.dp[i].labelArray[7].setText(roomListDetail[1]); // 방제목
							RoomF.dp[i].labelArray[8].setText("개설자 : " + roomListDetail[4]); // 개설자
						} else if (roomListDetail.length == 7) // 공개방
						{
							userNumber += (roomListDetail[6] + "/" + roomListDetail[2]);
							RoomF.dp[i].labelArray[1].setText(roomListDetail[0]); // 방번호
							RoomF.dp[i].labelArray[3].setText(roomListDetail[5]); // 방주제
							RoomF.dp[i].labelArray[5].setText(userNumber); // 인원수
							RoomF.dp[i].labelArray[7].setText(roomListDetail[1]); // 방제목
							RoomF.dp[i].labelArray[8].setText("개설자 : " + roomListDetail[3]); // 개설자
						}
						System.out.println("userNumber : " + userNumber);

					}
					chattingF.area.setText("");
					chattingF.area1.setText("");
					rMakeF.setVisible(false); // 대기방 화면 끄고

				} else if (line[0].compareTo(Protocol.ROOMMAKE_OK1) == 0) // 방만들어짐 (만든 당사자) // 입장
				{
					System.out.println("방장 입장화면 변환");
					rMakeF.setVisible(false); // 대기방 화면 끄고

					chattingF.area.setText("");
					chattingF.setVisible(true);
					chattingF.partList.setText(line[1] + "\n");

				} else if (line[0].compareTo(Protocol.ENTERROOM_OK1) == 0) // 방입장 입장하는 당사자
				{
					System.out.println("입장화면 변환");
					RoomF.setVisible(false);
					chattingF.area1.setText("");
					chattingF.area.setText("");
					chattingF.setVisible(true);
//					System.out.println(line[2]);
//					String roomMember[] = line[2].split("%");//룸에 들어온사람들
//					chattingF.partList.append(line[1]); //자기 추가해주고
//					for (int i = 0; i < roomMember.length; i++) {
//						chattingF.partList.append(roomMember[i] + "\n");
//					}

				} else if (line[0].compareTo(Protocol.ENTERROOM_USERLISTSEND) == 0) // 채팅방 리스트 새로고침
				{

					String roomMember[] = line[1].split("%");// 룸에 들어온사람들
					String lineList = "";
					for (int i = 0; i < roomMember.length; i++) {
						lineList += (roomMember[i] + "\n");
					}

					chattingF.partList.setText(lineList);
					chattingF.area1.append(line[2] + "\n");

					if (line.length == 4) {
						String fileList[] = line[3].split("%");
						chattingF.model.removeAllElements();
						for (int i = 0; i < fileList.length; i++) {
							chattingF.model.addElement(fileList[i]);
						}
					}

				} else if (line[0].compareTo(Protocol.CHATTINGSENDMESSAGE_OK) == 0) {
					chattingF.area1.append("[" + line[1] + "] :" + line[2] + "\n");
				} else if (line[0].compareTo(Protocol.CHATTINGFILESEND_SYNACK) == 0) {

					pw.println(Protocol.CHATTINGFILESEND_FILE + "|" + chattingF.file.length());
					pw.flush();

					OutputStream os = socket.getOutputStream();

					System.out.println("파일 보내기 시작 !!!");
					// 보낼 파일의 입력 스트림 객체 생성
					FileInputStream fis = new FileInputStream(chattingF.file.getAbsoluteFile());

					// 파일의 내용을 보낸다

					byte[] b = new byte[471000];

					int n;
					while ((n = fis.read(b, 0, b.length)) > 0) {
						os.write(b, 0, n);
						System.out.println(n + "bytes 보냄 !!!");
					}

					// 소켓에서 보낼 출력 스트림을 구한다.
				} else if (line[0].compareTo(Protocol.CHATTINGFILESEND_FILEACK) == 0) {

					String[] fileList = line[1].split("%");

					chattingF.model.removeAllElements();
					for (int i = 0; i < fileList.length; i++) {
						chattingF.model.addElement(fileList[i]);
					}

				} else if (line[0].compareTo(Protocol.CHATTINGFILEDOWNLOAD_SEND) == 0) { // 파일을 받음
					String path = chattingF.file.getAbsolutePath();

					FileOutputStream fos = new FileOutputStream(path);
					InputStream is = socket.getInputStream();

					System.out.println("파일 다운로드 시작 !!!");

					// 보내온 파일 내용을 파일에 저장

					byte[] b = new byte[471000];

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
				}

			} catch (IOException io) {
				io.printStackTrace();
			}

		} // while
	}
}
