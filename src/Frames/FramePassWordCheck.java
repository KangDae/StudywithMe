package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPasswordField;

import DTO.Protocol;
import Resource.R;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePassWordCheck extends R{
	public JPasswordField passwordField_pw1, passwordField_pw2;
	private JLabel lbl_StudyWithMe;
	public String newPassworld2 = "";

	/**
	 * Create the application.
	 */
	public FramePassWordCheck() {
		initialize();
	}
	public void start() {
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.getContentPane().setBackground(new Color(135, 206, 250));
		this.setBounds(100, 100, 450, 350);
		this.getContentPane().setLayout(null);
		
		passwordField_pw2 = new JPasswordField();
		passwordField_pw2.setBounds(144, 200, 152, 21);
		passwordField_pw2.setEchoChar('*');
		this.getContentPane().add(passwordField_pw2);
		
		
		passwordField_pw1 = new JPasswordField();
		passwordField_pw1.setBounds(144, 165, 152, 21);
		passwordField_pw1.setEchoChar('*');
		this.getContentPane().add(passwordField_pw1);
		
		JLabel lblNewLabel = new JLabel("비밀번호 : ");
		lblNewLabel.setBounds(66, 168, 78, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호(확인) : ");
		lblNewLabel_1.setBounds(33, 203, 99, 15);
		this.getContentPane().add(lblNewLabel_1);
		//image
		lbl_StudyWithMe = new JLabel(image);
		lbl_StudyWithMe.setBounds(33, 21, 365, 118);
		getContentPane().add(lbl_StudyWithMe);
		
		accemble.reset_btn_Reset = new JButton("재설정");
		accemble.reset_btn_Reset.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		accemble.reset_btn_Reset.setBounds(264, 246, 99, 29);
		getContentPane().add(accemble.reset_btn_Reset);
		
		accemble.reset_btn_Cancle = new JButton("취소");
		accemble.reset_btn_Cancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		accemble.reset_btn_Cancle.setBounds(58, 246, 99, 29);
		getContentPane().add(accemble.reset_btn_Cancle);
		
		accemble.reset_btn_pwCheck = new JButton("확인");
		accemble.reset_btn_pwCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		accemble.reset_btn_pwCheck.setBounds(308, 166, 70, 21);
		getContentPane().add(accemble.reset_btn_pwCheck);

		
	}
	public void frameDown() {
		this.setVisible(false);
	}
}
