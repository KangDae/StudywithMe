package Action;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DO.Room;

public class MainServer {
	private ServerSocket ss; 
	private ArrayList<MainHandler> allUserList; //전체 사용자
	private ArrayList<MainHandler> WaitUserList;//대기실 사용자
	private ArrayList<Room> roomtotalList;//전체방리스트
	/*
	 *  MariaDB
	 *  테스트용IP
	 *  MariaDB연동 Port
	 *  Database Name = userInfo
	 */
	String protocol =  "jdbc:mariadb://";
	String ip = "127.0.0.1";
	String port = "3306";
	String db ="userinfo";
	/*
	 *  DB커넥트
	 *  MariaDB driver MariaDB lil
	 *  URL = 
	 *  DB user
	 *  DB Password
	 */
	private Connection conn;
	private String driver = "org.mariadb.jdbc.Driver";
	private String url = String.format("%s%s:%s/%s", protocol,ip,port,db);
	private String user = "root";
	private String password = "7540";
	/*
	 *  class. forname. driver
	 *  conn = url, user, password
	 *  사용할 포트번호
	 *  서버가 실행되면 Handler를 생성해주고 쓰레드는 계속 사용되며
	 *  Client의 이밴트를 처리해준다.
	 *  마지막으로 userList에 Handler를 추가해준다 
	 *  여기서의 user리스트는 현재 접속중인 user
	 *  Thread를 사용중인 프로세스의 개수를 의미한다.
	 */
	public MainServer() {//생성자

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

			ss = new ServerSocket(9500);
			System.out.println("서버실행");

			allUserList = new ArrayList<MainHandler>();  //전체 사용자
			WaitUserList = new ArrayList<MainHandler>(); //대기실 사용자
			roomtotalList = new ArrayList<Room>(); //전체 방 리스트
			while (true) {
				Socket socket = ss.accept();
				MainHandler handler = new MainHandler(socket, allUserList, WaitUserList, roomtotalList, conn);// 스레드 생성
				handler.start();// 스레드 시작
				allUserList.add(handler);
			} // while
		} catch (IOException io) {
			io.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MainServer();
	}
}
