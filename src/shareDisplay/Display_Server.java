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
	
	
	public  Display_Server() {
		 System.out.println("화면 공유 서버 실행");

	        ServerSocket server = null;
	        int connectCount=0;
	       
	        try {
	            server = new ServerSocket(12345);

	            while(true) {
	                // 클라이언트가 접속해 오기를 기다립니다.
	                Socket connectedClientSocket = server.accept();

	                InetAddress ia = connectedClientSocket.getInetAddress();
	                int port = connectedClientSocket.getLocalPort();// 접속에 사용된 서버측 PORT
	                String ip = ia.getHostAddress(); // 접속된 원격 Client IP
	               
	                ++connectCount;  //접속자수 카운트
	                System.out.print(connectCount);
	                System.out.print(" 접속-Local Port: "+ port);
	                System.out.println(" Client IP: " + ip);
	               
	               
	                // -------------------------------------------
	                // 스레드 관련 부분
	                // -------------------------------------------
	                //Handler 클래스로 client 소켓 전송
	                ThreadServerHandler handler = new ThreadServerHandler(connectedClientSocket);
	                //스레드 시작, run()호출
	                handler.start(); // start() --> run() 호출
	                // -------------------------------------------
	               
	            }
	        } catch(IOException ioe) {
	            System.err.println("Exception generated...");
	        } finally {
	            try {
	                server.close();
	            } catch(IOException ignored) {}
	        }
	    }
	}
	

   

// 클라이언트로 데이터를 전송할 스레드 클래스
class ThreadServerHandler extends Thread {
    //멤버변수
    private Socket connectedClientSocket;
    final int w = Toolkit.getDefaultToolkit().getScreenSize().width,
			h = Toolkit.getDefaultToolkit().getScreenSize().height;


    //생성자
    public ThreadServerHandler(Socket connectedClientSocket) {
     //Client와 통신할 객체를 초기값으로 받아 할당합니다.
        this.connectedClientSocket = connectedClientSocket; 
    }

    public void run() {
        try {
            //클라이언트로 내용을 출력 할 객체 생성       
            BufferedImage image; //스크린샷이 저장될 버퍼공간

        	Robot r = new Robot(); //스크린샷을 찍는 로봇클래스
        	


        	BufferedOutputStream bout = new BufferedOutputStream(connectedClientSocket.getOutputStream());
        	

        	//아웃풋스트림을 버퍼아웃풋으로

        	for(int i=0; i<100; i++) {

        	//image.getGraphics().drawImage(r.createScreenCapture(new Rectangle(0,0,w,h)).getScaledInstance(1280, 720, Image.SCALE_SMOOTH), 0, 0, null);

        	image = r.createScreenCapture(new Rectangle(0, 0, w, h));

        	//스크린샷을 찍어서 image에 저장해

        	ImageIO.write(image, "bmp", bout);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌

        	bout.flush();   //버퍼에 쓰인 이미지를 서버로 보냄

        	}

        } catch(IOException ignored) {
        } catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                connectedClientSocket.close(); // 클라이언트 접속 종료
            } catch(IOException ignored) {}
        }
    }
}