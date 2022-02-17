package shareDisplay;

import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Display_Client {

	final int w = Toolkit.getDefaultToolkit().getScreenSize().width,
			h = Toolkit.getDefaultToolkit().getScreenSize().height;

//툴킷으로 컴퓨터의 해상도를 받아옴 (화면 캡쳐에 필요)

	JFrame frame;
//창


//메인에서 호출시킨 생성자부분

	public Display_Client() {

		frame = new JFrame("Client"); // 창 생성

		frame.setBounds(0, 0, 1920, 1080);// 창 위치,크기 조절
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(null); // 레이아웃 없게 함.

		frame.setVisible(true);

		client_work();

//JFrame 윈도우창 초기화
	}

//클라이언트의 기능들을 때려 박아놓은 창고

	public synchronized void client_work() {
		Socket socket = null;

		System.out.println("클라이언트 준비완료");// 일단 소켓생성

		try {

			socket = new Socket("127.0.0.1", 12345);

			// 위에 텍스트상자에서 받아온 아이피로 접속

			System.out.println("접속완료 - 클라이언트");

			// BufferedImage image = new BufferedImage(1280, 720,
			// BufferedImage.TYPE_3BYTE_BGR);

			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());

			// 소켓의 입력스트림을 버퍼스트림으로

			for (int i=0; i<100; i++) {

				frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, w, h, frame);

				// 이미지를 받아오는 동시에 화면에 그림

			}

		} catch (Exception e) {

			e.printStackTrace(); // 오류 처리

			System.out.println("접속실패 - 클라이언트");
		}

	}

}