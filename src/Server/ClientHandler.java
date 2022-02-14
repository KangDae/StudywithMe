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

public class ClientHandler extends R implements Runnable {
	BufferedReader br;
	PrintWriter pw;
	Socket socket;

	public ClientHandler() {
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
					String userlist = "";
					for (int i = 0; i < text.length; i++) {
						userlist += (text[i] + "\n");
					}
					frameCenter.textArea_Waituser.setText(userlist);

				} else if (line[0].compareTo(Protocol.ENTERLOGIN_NO) == 0) // 로그인 실패
				{
					JOptionPane.showMessageDialog(this, line[1]);
					System.out.println("로그인실패");
				} else if (line[0].compareTo(Protocol.EXITWAITROOM) == 0) // 로그아웃 [대기실 -> 로그인페이지]
				{
					frameCenter.Center_textArea_Chatting.append(line[1] + line[2] + '\n');

					String text[] = line[3].split(":");
					String userlist = "";
					for (int i = 0; i < text.length; i++) {
						userlist += (text[i] + "\n");
					}
					frameCenter.textArea_Waituser.setText(userlist);

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

				} else if (line[0].compareTo(Protocol.ROOMMAKE_OK) == 0) // 방만들어짐
				{

					String roomList[] = line[1].split("-"); // 방 갯수
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
					frameChattingRoom.Chatting_textArea_chatting.setText("");
					frameChattingRoom.Chatting_textarea_Inuserlist.setText("");
				//	frameCenter.frameDown(); // 대기방 화면 끄고

				} else if (line[0].compareTo(Protocol.ROOMMAKE_OK1) == 0) // 방만들어짐 (만든 당사자) // 입장
				{
					System.out.println("방장 입장화면 변환");
					frameMakeRoom.frameDown(); // 대기방 화면 끄고

					frameChattingRoom.Chatting_textArea_chatting.setText("");
					frameChattingRoom.setVisible(true);
					frameChattingRoom.Chatting_textarea_Inuserlist.setText(line[1] + "\n");

				} else if (line[0].compareTo(Protocol.ENTERROOM_OK1) == 0) // 방입장 입장하는 당사자
				{
					System.out.println("입장화면 변환");
					frameCenter.frameDown();

					frameChattingRoom.Chatting_textArea_chatting.setText("");
					frameChattingRoom.Chatting_textarea_Inuserlist.setText("");
					frameChattingRoom.setVisible(true);
//					System.out.println(line[2]);
//					String roomMember[] = line[2].split("%");//룸에 들어온사람들
//					frameChattingRoom.partList.append(line[1]); //자기 추가해주고
//					for (int i = 0; i < roomMember.length; i++) {
//						frameChattingRoom.partList.append(roomMember[i] + "\n");
//					}

				}else if(line[0].compareTo(Protocol.DISMANTINGROOM)==0){
					
					JOptionPane.showMessageDialog(R.btn_Confirm, "강퇴되었습니다.");
					
					frameChattingRoom.frameDown();
					frameCenter.start();
					
					
					
				}else if(line[0].compareTo(Protocol.DISMANTINGROOMMASTER)==0){
					
					JOptionPane.showMessageDialog(R.btn_Confirm, "모임을 해체했습니다.");
					
					frameChattingRoom.frameDown();
					frameCenter.start();
					
					
					
				}else if (line[0].compareTo(Protocol.CHATTINGSENDMESSAGE_OK) == 0) {
					frameChattingRoom.Chatting_textArea_chatting.append("[" + line[1] + "] :" + line[2] + "\n");
				}  else if (line[0].compareTo(Protocol.CHATTINGFILESEND_SYNACK) == 0) {

					pw.println(Protocol.CHATTINGFILESEND_FILE + "|" + frameChattingRoom.file.length());
					pw.flush();

					OutputStream os = socket.getOutputStream();

					System.out.println("파일 보내기 시작 !!!");
					// 보낼 파일의 입력 스트림 객체 생성
					FileInputStream fis = new FileInputStream(frameChattingRoom.file.getAbsoluteFile());

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

					frameChattingRoom.model.removeAllElements();
					for (int i = 0; i < fileList.length; i++) {
						frameChattingRoom.model.addElement(fileList[i]);
					}

				} else if (line[0].compareTo(Protocol.ENTERROOM_USERLISTSEND) == 0) {
				     
				   System.out.println("enter room");
					String roomMember[] = line[1].split("%");// 룸에 들어온사람들
					String lineList = "";
					for (int i = 0; i < roomMember.length; i++) {
						lineList += (roomMember[i] + "\n");
					}

					frameChattingRoom.Chatting_textarea_Inuserlist.setText(lineList);
					frameChattingRoom.Chatting_textArea_chatting.append(line[2] + "\n");

					if (line.length == 4) {
						String fileList[] = line[3].split("%");
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
