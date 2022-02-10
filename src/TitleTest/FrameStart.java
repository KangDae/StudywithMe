package TitleTest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

import Resource.R;
import Server.Client_network;

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
	public Client_network client;
//	public JButton start_btn_loginBtn, start_btn_SingUp, btnExit;
	
	public FrameStart(){
		initialize();
//		this.setUndecorated(true);
	}
	public void start() {
		this.setVisible(true);	
	}

	private void initialize() {
		client = new Client_network();
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
		
		accemble.start_btn_loginBtn = new JButton("로그인 하기");
		accemble.start_btn_loginBtn.setBackground(new Color(255, 255, 255));
		accemble.start_btn_loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		accemble.start_btn_loginBtn.setBounds(134, 333, 122, 32);
		panel.add(accemble.start_btn_loginBtn);
		
		accemble.start_btn_SingUp = new JButton("회 원 가 입");
		accemble.start_btn_SingUp.setBackground(Color.WHITE);
		accemble.start_btn_SingUp.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		accemble.start_btn_SingUp.setBounds(134, 406, 122, 32);
		panel.add(accemble.start_btn_SingUp);
		
		accemble.btnExit = new JButton("종료");
		accemble.btnExit.setForeground(new Color(0, 0, 0));
		accemble.btnExit.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		accemble.btnExit.setBackground(Color.WHITE);
		accemble.btnExit.setBounds(288, 519, 84, 32);
		panel.add(accemble.btnExit);
		
	}
	public void frameDown() {
		setVisible(false);
	}
}
