package TitleTest;

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
	private JPasswordField passwordField_pw2;
	private JPasswordField passwordField_pw1;
	private JLabel lbl_StudyWithMe;
	private JButton btn_Reset;
	private JButton btn_Cancle;
	private JButton btn_pwCheck;
	private String newPassworld2 = "";

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
		
		btn_Reset = new JButton("재설정");
		btn_Reset.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_Reset.setBounds(264, 246, 99, 29);
		getContentPane().add(btn_Reset);
		
		btn_Cancle = new JButton("취소");
		btn_Cancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_Cancle.setBounds(58, 246, 99, 29);
		getContentPane().add(btn_Cancle);
		
		btn_pwCheck = new JButton("확인");
		btn_pwCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_pwCheck.setBounds(308, 166, 70, 21);
		getContentPane().add(btn_pwCheck);
		// ==> 확인 버튼 <==
		btn_pwCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw1 = passwordField_pw1.getText();
				String pw2 = passwordField_pw2.getText();
				if(!pw1.equals(pw2)) {
					JOptionPane.showMessageDialog(btn_Confirm, "두 패스워드가 일치하지 않습니다.");
				}
				if(pw1.length()<8) {
					JOptionPane.showMessageDialog(btn_Confirm, "패스워드는 8자리 이상이여야합니다.");
				}
				else {
					JOptionPane.showMessageDialog(btn_Confirm, " 사용가능 !");
					newPassworld2 = pw1;
					condition_PW = true;
				}
			}
		});
		// ==> 취소 버튼 <==
		btn_Cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
			}
		});
		// ==> 재설정 버튼 <==
		btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(condition_PW == false) {
					JOptionPane.showMessageDialog(btn_Confirm, "비밀번호 확인을 해주세요");
				} else {
					newPassword = newPassworld2;
					JOptionPane.showMessageDialog(btn_Confirm, "재설정할 비밀번호를 입력했습니다.");
					frameDown();
				}
				
			}
		});
	}
	public void frameDown() {
		this.setVisible(false);
	}
}
