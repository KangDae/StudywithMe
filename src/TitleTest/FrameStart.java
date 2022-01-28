package TitleTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import Resource.R;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.SystemColor;
/*
 * 		프로그램 시작시 제일먼저
 * 		보이는 프레임 입니다.
 */
public class FrameStart extends JFrame implements R{

	
	
	
	/**
	 * Create the application.
	 * @return 
	 */
	public FrameStart(){
		initialize();
	}
	public void start() {
		initialize();
		this.setVisible(true);
//		this.setUndecorated(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(135, 206, 235));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel MainLabel = new JLabel(R.image);
		MainLabel.setSize(300, 200);
		MainLabel.setBounds(45, 49, 286, 140);
		MainLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		panel.add(MainLabel);
		
		JButton loginBtn = new JButton("로그인 하기");
		
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		loginBtn.setBounds(134, 333, 122, 32);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameLogin.start();
			}
		});
		panel.add(loginBtn);
		
		JButton btnSingUp = new JButton("회 원 가 입");
		btnSingUp.setBackground(Color.WHITE);
		
		btnSingUp.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnSingUp.setBounds(134, 406, 122, 32);
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameSignup.start();
			}
		});
		panel.add(btnSingUp);
		
		JButton loginBtn_1 = new JButton("종료");
		loginBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		loginBtn_1.setForeground(new Color(0, 0, 0));
		loginBtn_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		loginBtn_1.setBackground(Color.WHITE);
		loginBtn_1.setBounds(288, 519, 84, 32);
		panel.add(loginBtn_1);
	}
	public void frameDown() {
		setVisible(false);
	}
}
