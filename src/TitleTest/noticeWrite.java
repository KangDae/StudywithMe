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
	
	
	
	public JTextField textField;
	public JTextArea textArea;
	
	public JButton btn_Write; //작성 버튼
	
	public JButton btn_Cancle; //취소 버튼



	/**
	 * Create the application.
	 */
	public noticeWrite() {
		initialize();
	}
	
	public void start() {
		this.setVisible(true);
	}
	
	public void framedown() {
		this.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setBackground(new Color(135, 206, 250));
		this.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(92, 27, 226, 21);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(40, 93, 294, 360);
		this.getContentPane().add(textArea);
		
		btn_Write = new JButton("작성");
		btn_Write.setBounds(263, 516, 97, 23);
		this.getContentPane().add(btn_Write);
		
		btn_Cancle = new JButton("취소");
		btn_Cancle.setBounds(12, 516, 97, 23);
		this.getContentPane().add(btn_Cancle);
		
		JLabel lblNewLabel = new JLabel("내용");
		lblNewLabel.setBounds(40, 76, 57, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("제목");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 28, 57, 18);
		this.getContentPane().add(lblNewLabel_1);
		
	}
}
