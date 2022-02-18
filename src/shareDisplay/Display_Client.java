package shareDisplay;

import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class Display_Client extends JFrame {

	public JFrame frame;
	ThreadClientHandler handler;

	
//창
	public Display_Client() {
		
		
		
		
		frame = new JFrame("Client"); // 창 생성

		frame.setBounds(0, 0, 1366, 768);// 창 위치,크기 조절
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null); // 레이아웃 없게 함.	
		frame.setVisible(true);	
		
	}
	
	public void start(String ip) {
		
		System.out.println(ip);
        handler = new ThreadClientHandler(ip,frame);		
		handler.start();		
	}
	
	public void stop() {
		handler.interrupt();
	}


//클라이언트의 기능들을 때려 박아놓은 창고

	class ThreadClientHandler extends Thread {
		   Socket socket = null;
		   String ip = "";
		   JFrame frame;
			final int w = Toolkit.getDefaultToolkit().getScreenSize().width,
					  h = Toolkit.getDefaultToolkit().getScreenSize().height;

		public ThreadClientHandler(String ip, JFrame frame) {		
		
		 this.ip =ip;
		 this.frame = frame;
		}

		public void run() {
			try {

				socket = new Socket(ip, 12345);

				// 위에 텍스트상자에서 받아온 아이피로 접속

				System.out.println("접속완료 - 클라이언트");

				// BufferedImage image = new BufferedImage(1280, 720,
				// BufferedImage.TYPE_3BYTE_BGR);

				BufferedInputStream bin;

				// 소켓의 입력스트림을 버퍼스트림으로

				while (true) {
					bin = new BufferedInputStream(socket.getInputStream());
					if(frame.getGraphics() !=null ) {
					frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0,
							0, w, h, frame);
					}else if(frame.getGraphics() == null) {
						
					  socket.close();	
					  break;	
					}
				}

			} catch (Exception e) {

				e.printStackTrace(); // 오류 처리

				System.out.println("접속실패 - 클라이언트");
			}
		}

	}
}
