package UserInfomation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

import Resource.R;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UpdateName extends R{
	public JButton btn_cencle, btn_update;
	public JTextField textField_Name;
	private JLabel lblNewLabel_2;
	/**
	 * Create the application.
	 */
	public UpdateName() {
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
		lblNewLabel.setBounds(27, 79, 324, 150);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(27, 308, 116, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		btn_cencle = new JButton("취소");
		btn_cencle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_cencle.setBackground(Color.WHITE);
		btn_cencle.setBounds(12, 522, 99, 29);
		getContentPane().add(btn_cencle);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(92, 308, 142, 21);
		getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		btn_update = new JButton("변경");
		btn_update.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_update.setBackground(Color.WHITE);
		btn_update.setBounds(273, 522, 99, 29);
		getContentPane().add(btn_update);
		
		lblNewLabel_2 = new JLabel("변경하실 이름을 입력하고 변경을 눌러주세요.");
		lblNewLabel_2.setBounds(27, 360, 318, 15);
		getContentPane().add(lblNewLabel_2);
	}
}
