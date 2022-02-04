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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/*
 * 		프로그램 시작시 제일먼저
 * 		보이는 프레임 입니다.
 */
public class FrameStart extends JFrame implements R{
	public FrameStart() {
		
	}
	/**
	 * Create the application.
	 * @return 
	 */
	public void start() {
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 401, 280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel MainLabel = new JLabel("Study With Me!");
		MainLabel.setBounds(47, 18, 286, 54);
		MainLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		panel.add(MainLabel);
		
		JButton loginBtn = new JButton("로그인 하기");
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		loginBtn.setBounds(124, 117, 122, 32);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameLogin.start();
			}
		});
		panel.add(loginBtn);
		
		JButton btnSingUp = new JButton("회 원 가 입");
		btnSingUp.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnSingUp.setBounds(124, 159, 122, 32);
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameSignup.start();
			}
		});
		panel.add(btnSingUp);
	}
	public void frameDown() {
		setVisible(false);
	}


}
