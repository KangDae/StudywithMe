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

public class Handler extends Thread{
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	private User user;
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	private ArrayList<Handler> allUserList; // 전체 사용자
	private ArrayList<Handler> waitUserList;// 대기실 사용자
	private ArrayList<Room> roomtotalLsit;  // 전체 방 리스트
	
	private Room priRoom;
	private String fileName;
	
	public Handler(Socket socket, ArrayList<Handler> allUserList, ArrayList<Handler> waitUserList,
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
					System.out.println(line[1]);
					
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
