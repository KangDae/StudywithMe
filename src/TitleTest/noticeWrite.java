package TitleTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Resource.R;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class noticeWrite extends R {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public JFrame frame;
	public JTextField textField;
	public JTextArea textArea;



	/**
	 * Create the application.
	 */
	public noticeWrite() {
		initialize();
	}
	
	public void start() {
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(92, 27, 226, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(40, 93, 294, 360);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("작성");
		btnNewButton.setBounds(263, 516, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(12, 516, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("내용");
		lblNewLabel.setBounds(40, 76, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("제목");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 28, 57, 18);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
