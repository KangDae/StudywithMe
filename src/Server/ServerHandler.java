package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import DTO.Protocol;
import DTO.Room;
import DTO.User;

public class ServerHandler extends Thread{
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	private User user;
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	private ArrayList<ServerHandler> allUserList; // 전체 사용자
	private ArrayList<ServerHandler> waitUserList;// 대기실 사용자
	private ArrayList<Room> roomtotalLsit;  // 전체 방 리스트
	
	private Room priRoom;
	private String fileName;
	
	public ServerHandler(Socket socket, ArrayList<ServerHandler> allUserList, ArrayList<ServerHandler> waitUserList,
			ArrayList<Room> roomtotalList, Connection conn) throws IOException {
		this.user = new User();
		this.priRoom = new Room();
		this.socket = socket;
		this.allUserList = allUserList;
		this.waitUserList = waitUserList;
		this.roomtotalLsit = roomtotalList;
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
			while(true) {
				line = br.readLine().split("\\|");
				if(line == null) {
					break;
				}
				if(line[0].compareTo(Protocol.REGISTER) == 0) {
					String userContent[] = line[1].split("%");
//					
//					String sql = "Insert into UserContent values(nextval(num), ?, ?, ?, ?, ?)";
//					pstmt = conn.prepareStatement(sql);
//					pstmt.setString(1, userContent[0]);
					for(int i=0; i<userContent.length;i++) {
						System.out.println(userContent[i]);
						System.out.println(i);
					}
					
				} else if (line[0].compareTo(Protocol.ENTERLOGIN) == 0) {
					System.out.println("서버 부분");
					pw.println(Protocol.ENTERLOGIN + "|" + "확인했습니다.");
					pw.flush();
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("이거냐");
		}
	}
	

}
