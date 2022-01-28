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
import controlbtn.ButtonAction;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
/*
 * 		프로그램 시작시 제일먼저
 * 		보이는 프레임 입니다.
 */
public class FrameStart extends JFrame implements R{
	public FrameStart() {
		start();
	}
	public JButton loginBtn = new JButton("로그인 하기");
	public JButton btnSignUp = new JButton("회 원 가 입");
	
	public void start() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setVisible(true);
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(181, 227, 216));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel MainLabel = new JLabel("Study With Me!");
		MainLabel.setBounds(51, 67, 286, 54);
		MainLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		panel.add(MainLabel);
		loginBtn.setForeground(new Color(0, 128, 128));
		loginBtn.setBackground(new Color(72, 209, 204));
		
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		loginBtn.setBounds(124, 335, 122, 32);
		panel.add(loginBtn);
		btnSignUp.setBackground(new Color(72, 209, 204));
		btnSignUp.setForeground(new Color(0, 128, 128));
		
		
		btnSignUp.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnSignUp.setBounds(124, 395, 122, 32);
		panel.add(btnSignUp);
		
		JButton btnSignUp_1 = new JButton("종    료");
		btnSignUp_1.setForeground(new Color(0, 128, 128));
		btnSignUp_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnSignUp_1.setBackground(new Color(72, 209, 204));
		btnSignUp_1.setBounds(124, 487, 122, 32);
		panel.add(btnSignUp_1);
		
		ButtonAction.event();
	}
	public void frameDown() {
		setVisible(false);
	}
}
