package shareDisplay;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Display_Server {

	ThreadServerHandler thread;
	public ServerSocket server;

	public Display_Server() throws IOException {
		this.server =new ServerSocket(12345);

	}

	public void Start() {
		thread = new ThreadServerHandler(server);

		thread.start();

	}

	public void Stop() {

		System.out.println("STOP THREAD");
		thread.interrupt();
	}

}

// 클라이언트로 데이터를 전송할 스레드 클래스
class ThreadServerHandler extends Thread {

	// 멤버변수
	Socket socket;
	public DisplayHandler display;
	public ServerSocket serversocket;

	// 생성자
	public ThreadServerHandler(ServerSocket serversocket) {
      this.serversocket = serversocket;
	}

	public void run() {
		try {
			System.out.println("화면 공유 서버 시작");
			// int connectCount = 0;
			

			while (true) {
				socket = serversocket.accept();
				
				
				
				display = new DisplayHandler(socket);
				display.start();

				if (Thread.interrupted()) {
					System.out.println("요거 실행 중지됨");
					display.interrupt();
					socket.close();
					break;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class DisplayHandler extends Thread {

	Socket socket;
	final int w = Toolkit.getDefaultToolkit().getScreenSize().width,
			h = Toolkit.getDefaultToolkit().getScreenSize().height;

	DisplayHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		
		try {
			Robot r = new Robot();		
			BufferedImage image; // 스크린샷이 저장될 버퍼공간
			BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());

			while (true) {
				
				image = r.createScreenCapture(new Rectangle(0, 0, w, h));
				// 스크린샷을 찍어서 image에 저장해
				if(socket.isClosed()==false && socket.isBound() ==true) {
				ImageIO.write(image, "bmp", bout);// 그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				bout.flush(); // 버퍼에 쓰인 이미지를 서버로 보냄
				}

				if (Thread.interrupted()) {
					bout.close();
					socket.close();
					break;
				}
			}

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}

	}

}
