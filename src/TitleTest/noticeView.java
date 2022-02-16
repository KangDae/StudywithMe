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

public class noticeView extends R {

	public  JFrame frame;
	public  JTextField Title_Textfield; //제목입력
	public  JTextArea Text_Content; //내용입력
	public  JButton check_Btn;  //확인버튼
	
	public JLabel lblNewLabel; //제목 라벨
	
	public JLabel lblNewLabel_1; //내용 라벨
	

	
	public noticeView() {
		initialize();
	}
	
	public void start() {
		this.setVisible(true);
	}
	
	public void frameDown() {
		this.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		Title_Textfield = new JTextField();
		Title_Textfield.setBounds(92, 27, 226, 21);
		frame.getContentPane().add(Title_Textfield);
		Title_Textfield.setColumns(10);
		
		Text_Content = new JTextArea();
		Text_Content.setBounds(40, 93, 294, 360);
		frame.getContentPane().add(Text_Content);
				
		check_Btn = new JButton("확인");
		check_Btn.setBounds(137, 497, 97, 23);
		frame.getContentPane().add(check_Btn);
		
		lblNewLabel = new JLabel("내용");
		lblNewLabel.setBounds(40, 76, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("제목");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 28, 57, 18);
		
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
