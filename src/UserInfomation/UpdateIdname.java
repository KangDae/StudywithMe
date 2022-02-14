package UserInfomation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

import Resource.R;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UpdateIdname extends R{
	public JButton btn_check, btn_cencle, btn_change;
	public JTextField textField_id;
	/**
	 * Create the application.
	 */
	public UpdateIdname() {
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
		lblNewLabel.setBounds(26, 120, 324, 150);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(26, 324, 95, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		btn_check = new JButton("중복확인");
		btn_check.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_check.setBackground(new Color(255, 255, 255));
		btn_check.setBounds(247, 324, 103, 21);
		this.getContentPane().add(btn_check);
		
		btn_cencle = new JButton("취소");
		btn_cencle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_cencle.setBackground(Color.WHITE);
		btn_cencle.setBounds(12, 522, 109, 29);
		getContentPane().add(btn_cencle);
		
		textField_id = new JTextField();
		textField_id.setBounds(84, 324, 151, 21);
		getContentPane().add(textField_id);
		textField_id.setColumns(10);
		
		btn_change = new JButton("변경");
		btn_change.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_change.setBackground(Color.WHITE);
		btn_change.setBounds(263, 522, 109, 29);
		getContentPane().add(btn_change);
	}
}
