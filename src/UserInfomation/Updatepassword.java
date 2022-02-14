package UserInfomation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

import Resource.R;
import javax.swing.JButton;

public class Updatepassword extends R{

	public JPasswordField passwordField, passwordField_cehck;
	public JButton btn_check, btn_cencle, btn_update;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Create the application.
	 */
	public Updatepassword() {
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
		lblNewLabel.setBounds(27, 88, 324, 150);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(40, 321, 95, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(127, 321, 130, 21);
		this.getContentPane().add(passwordField);
		
		btn_check = new JButton("확인");
		btn_check.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_check.setBackground(new Color(255, 255, 255));
		btn_check.setBounds(279, 321, 72, 21);
		this.getContentPane().add(btn_check);
		
		btn_cencle = new JButton("취소");
		btn_cencle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_cencle.setBackground(Color.WHITE);
		btn_cencle.setBounds(12, 522, 95, 29);
		getContentPane().add(btn_cencle);
		
		btn_update = new JButton("변경");
		btn_update.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_update.setBackground(Color.WHITE);
		btn_update.setBounds(277, 522, 95, 29);
		getContentPane().add(btn_update);
		
		lblNewLabel_2 = new JLabel("비밀번호 확인: ");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 358, 123, 15);
		getContentPane().add(lblNewLabel_2);
		
		passwordField_cehck = new JPasswordField();
		passwordField_cehck.setEchoChar('*');
		passwordField_cehck.setBounds(127, 358, 130, 21);
		getContentPane().add(passwordField_cehck);
		
		lblNewLabel_3 = new JLabel("비밀번호를 입력하고 확인버튼을 눌러주세요");
		lblNewLabel_3.setBounds(60, 402, 324, 29);
		getContentPane().add(lblNewLabel_3);
	}
}
