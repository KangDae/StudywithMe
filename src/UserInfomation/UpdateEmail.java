package UserInfomation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

import Resource.R;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class UpdateEmail extends R{
	public JButton btn_Send, btn_cencle, btn_Confilrm, btn_Auth;
	public JComboBox comboBox;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	public JTextField textField_email, textField_Auth;
	/**
	 * Create the application.
	 */
	public UpdateEmail() {
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
		lblNewLabel.setBounds(28, 103, 324, 150);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이메일 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 328, 95, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		btn_Send = new JButton("전송");
		btn_Send.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_Send.setBackground(new Color(255, 255, 255));
		btn_Send.setBounds(300, 325, 72, 21);
		this.getContentPane().add(btn_Send);
		
		btn_cencle = new JButton("취소");
		btn_cencle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_cencle.setBackground(Color.WHITE);
		btn_cencle.setBounds(244, 511, 128, 29);
		getContentPane().add(btn_cencle);
		
		comboBox = new JComboBox<String>(R.email);
		comboBox.setBounds(184, 327, 104, 23);
		getContentPane().add(comboBox);
		
		lblNewLabel_2 = new JLabel("@");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(166, 328, 27, 15);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("인증번호 : ");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(106, 369, 95, 15);
		getContentPane().add(lblNewLabel_3);
		
		btn_Auth = new JButton("인증");
		btn_Auth.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_Auth.setBackground(Color.WHITE);
		btn_Auth.setBounds(300, 366, 72, 21);
		getContentPane().add(btn_Auth);
		
		btn_Confilrm = new JButton("확인");
		btn_Confilrm.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_Confilrm.setBackground(Color.WHITE);
		btn_Confilrm.setBounds(12, 511, 128, 29);
		getContentPane().add(btn_Confilrm);
		
		textField_email = new JTextField();
		textField_email.setBounds(68, 328, 95, 21);
		getContentPane().add(textField_email);
		textField_email.setColumns(10);
		
		textField_Auth = new JTextField();
		textField_Auth.setColumns(10);
		textField_Auth.setBounds(184, 369, 95, 21);
		getContentPane().add(textField_Auth);
	}
}
