package TitleTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class FramePassWordCheck extends JFrame{
	private JPasswordField passwordField_Check;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		new FramePassWordCheck().setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public FramePassWordCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setUndecorated(true);
		this.getContentPane().setBackground(new Color(135, 206, 250));
		this.setBounds(100, 100, 345, 208);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		passwordField_Check = new JPasswordField();
		passwordField_Check.setBounds(123, 107, 194, 21);
		passwordField_Check.setEchoChar('*');
		this.getContentPane().add(passwordField_Check);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 72, 194, 21);
		passwordField.setEchoChar('*');
		this.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("비밀번호 : ");
		lblNewLabel.setBounds(45, 75, 78, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호(확인) : ");
		lblNewLabel_1.setBounds(12, 110, 99, 15);
		this.getContentPane().add(lblNewLabel_1);
	}
}
