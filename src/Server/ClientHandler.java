package Server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import DTO.Protocol;

public class ClientHandler extends Thread{
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
		String line[] = null;
		while(true) {
			try {
				line = br.readLine().split("\\|");
				System.out.println(line[0]);
				if (line == null) {
					br.close();
					pw.close();
					socket.close();

					System.exit(0);
				} else if(line[0].equals(Protocol.ENTERLOGIN)) {
					System.out.println("여기 받아짐");
				}
			} catch(Exception e) {
				
			}
			
		}
	}
}
