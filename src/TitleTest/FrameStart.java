package TitleTest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

import Resource.R;
import Server.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/*
 * 		프로그램 시작시 제일먼저
 * 		보이는 프레임 입니다.
 * 		공통적으로 start()함수는
 * 		setVisible(true)를 구현했고
 * 		extends R 에 모든 프레임을 생성자로
 * 		초기화해주어서 바로 불러올수 있게 구현함.
 */
public class FrameStart extends R{
	/**
	 * Create the application.
	 * @return 
	 */
	public Client client;
	public JButton loginBtn, btnSingUp, btnExit;
	
	public FrameStart(){
		initialize();
//		this.setUndecorated(true);
	}
	public void start() {
		this.setVisible(true);	
	}

	private void initialize() {
		client = new Client();
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(135, 206, 235));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel MainLabel = new JLabel(image);
		MainLabel.setSize(300, 200);
		MainLabel.setBounds(45, 49, 286, 140);
		MainLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		panel.add(MainLabel);
		
		loginBtn = new JButton("로그인 하기");
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		loginBtn.setBounds(134, 333, 122, 32);
		panel.add(loginBtn);
		
		btnSingUp = new JButton("회 원 가 입");
		btnSingUp.setBackground(Color.WHITE);
		btnSingUp.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnSingUp.setBounds(134, 406, 122, 32);
		panel.add(btnSingUp);
		
		btnExit = new JButton("종료");
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(288, 519, 84, 32);
		panel.add(btnExit);
		
		
		
		
		// ==> 로그인 버튼 기능 구현 <==
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameLogin.start();
			}
		});
		// ==> 회원가입 버튼 기능 구현 <==
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameSignup.start(); 
			}
		});
		// ==>  Exit버튼 기능 구현 <==
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
	}
	public void frameDown() {
		setVisible(false);
	}
}
