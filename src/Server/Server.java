package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Room;

public class Server {
	/*
	 * 		서버소켓 생성
	 * 		모든유저 리스트
	 * 		대기룸에 있는유저
	 * 		방 리스트
	 */
	private ServerSocket serverSocket;
	private ArrayList<Handler> allUserList;
	private ArrayList<Handler> waitUserList;
	private ArrayList<Room> roomtotalList;
	/*
	 * 		protocol, ip, port, db
	 */
	String protocol = "jdbc:mariadb://";
	String ip = "127.0.0.1";
	String port = "3306";
	String db = "userinfo";
	/*
	 * 		mariaDB와 연동, driver org.Driver
	 * 		protocol url, id, pw
	 */
	private Connection conn;
	private String driver = "org.mariadb.jdbc.Driver";
	private String url = String.format("%s%s:%s/%s", protocol, ip, port, db);
	private String user = "root";
	private String password = "1234";
	
	public Server() {
		try {
			Class.forName(driver);
			//		db연동 Connect
			conn = DriverManager.getConnection(url, user, password);
			//		서버 포트지정
			serverSocket = new ServerSocket(9500);
			//		서버 실행알림 println
			System.out.println("서버 실행");
			/*
			 * 		각 리스트에 담아준다.
			 * 		룸 리스트 저장
			 */
			allUserList = new ArrayList<Handler>();
			waitUserList = new ArrayList<Handler>();
//			roomtotalList = new ArrayList<RoomT>();
			
			while(true) {
				/*
				 * 		소켓 
				 */
				Socket socket = serverSocket.accept();
				Handler handler = new Handler(socket, allUserList, waitUserList, roomtotalList, conn);
//				handler.start();
				allUserList.add(handler);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}
