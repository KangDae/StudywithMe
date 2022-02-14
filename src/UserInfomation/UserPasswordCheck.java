package UserInfomation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

import Resource.R;
import javax.swing.JButton;

public class UserPasswordCheck extends R{

	public JPasswordField passwordField;
	public JButton btn_compleate, btn_cencle;
	private JLabel lblNewLabel_2;
	/**
	 * Create the application.
	 */
	public UserPasswordCheck() {
		initialize();
	}

	public void start() {
		this.setVisible(true);
	}
	public void frameDown() {
		this.setVisible(false);
	}
	private void initialize() {
		this.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		this.getContentPane().setBackground(new Color(135, 206, 250));
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(R.image);
		lblNewLabel.setBounds(27, 109, 324, 150);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(47, 343, 95, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(140, 343, 182, 21);
		this.getContentPane().add(passwordField);
		
		btn_compleate = new JButton("확인");
		btn_compleate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_compleate.setBackground(new Color(255, 255, 255));
		btn_compleate.setBounds(268, 522, 104, 25);
		this.getContentPane().add(btn_compleate);
		
		btn_cencle = new JButton("취소");
		btn_cencle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_cencle.setBackground(Color.WHITE);
		btn_cencle.setBounds(12, 522, 104, 29);
		getContentPane().add(btn_cencle);
		
		lblNewLabel_2 = new JLabel("본인 인증을 위해서 비밀번호를 확인합니다.");
		lblNewLabel_2.setBounds(76, 379, 275, 42);
		getContentPane().add(lblNewLabel_2);
	}
}
