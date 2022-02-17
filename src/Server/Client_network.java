package Server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_network {
	public static BufferedReader br;
	public static PrintWriter pw;
	public static BufferedInputStream bin;
	public static Socket socket; 
	
	public Client_network(){
		network();
	}
	public void network() {
		try {
			socket = new Socket("127.0.0.1",9500);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			bin = new BufferedInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}
		Runnable client = new ClientHandler();
		Thread startThread = new Thread(client);
		startThread.start();
		
	}
		
	
}
