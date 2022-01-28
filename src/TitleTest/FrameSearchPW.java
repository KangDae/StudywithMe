package TitleTest;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Resource.R;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * 		비밀번호 찾기 프레임입니다.
 */
public class FrameSearchPW extends JFrame implements R{
	public FrameSearchPW() {
	}
	private JTextField textField_Name;
	private JTextField textField_Email;
	private JTextField textField_EmailCheck;
	private JTextField textField_ID;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public void start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setVisible(true);
		this.setBounds(100, 100, 405, 506);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_SearchPassword = new JLabel("비밀번호 찾기");
		lblNewLabel_SearchPassword.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_SearchPassword.setBounds(83, 20, 225, 53);
		this.getContentPane().add(lblNewLabel_SearchPassword);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(96, 83, 116, 21);
		this.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_Name = new JLabel("이  름 :");
		lblNewLabel_Name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Name.setBounds(27, 83, 57, 15);
		this.getContentPane().add(lblNewLabel_Name);
		// 생년월일 Factory 시작 
		Border border_DateOfBird = BorderFactory.createTitledBorder("생년월일");
		
		// 전화번호 Factory 시작 
		Border border_PhoneNumber = BorderFactory.createTitledBorder("전화번호");
		
		Border border_Email = BorderFactory.createTitledBorder("Email");
		JPanel layout_Email = new JPanel();
		layout_Email.setBorder(border_Email);
		layout_Email.setLayout(null);
		layout_Email.setBounds(12, 169, 365, 53);
		this.getContentPane().add(layout_Email);
		
		JLabel lblNewLabel_AtSign = new JLabel("@");
		lblNewLabel_AtSign.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_AtSign.setBounds(150, 26, 29, 15);
		layout_Email.add(lblNewLabel_AtSign);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(4);
		textField_Email.setBounds(59, 20, 79, 21);
		layout_Email.add(textField_Email);
		
		JLabel lblNewLabel_Email = new JLabel("email");
		lblNewLabel_Email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email.setBounds(12, 23, 57, 15);
		layout_Email.add(lblNewLabel_Email);
		
		JComboBox comboBox_Email = new JComboBox<String>(R.email);
		comboBox_Email.setBounds(178, 19, 105, 23);
		layout_Email.add(comboBox_Email);
		
		JButton btn_Send = new JButton("전송");
		btn_Send.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Send.setBounds(286, 18, 67, 23);
		layout_Email.add(btn_Send);
		
		JLabel lblNewLabel_Email_1 = new JLabel("email 인증");
		lblNewLabel_Email_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email_1.setBounds(27, 244, 91, 15);
		this.getContentPane().add(lblNewLabel_Email_1);
		
		textField_EmailCheck = new JTextField();
		textField_EmailCheck.setBounds(111, 244, 169, 21);
		this.getContentPane().add(textField_EmailCheck);
		textField_EmailCheck.setColumns(10);
		
		JButton btn_EmailConfirm = new JButton("전송");
		btn_EmailConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_EmailConfirm.setBounds(292, 243, 67, 23);
		this.getContentPane().add(btn_EmailConfirm);
		
		JButton btn_pwSearchConfirm = new JButton("확인");
		btn_pwSearchConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn_pwSearchConfirm.setBounds(27, 383, 116, 53);
		this.getContentPane().add(btn_pwSearchConfirm);
		
		JButton btn_pwCancle = new JButton("취소");
		btn_pwCancle.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn_pwCancle.setBounds(242, 383, 116, 53);
		this.getContentPane().add(btn_pwCancle);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(96, 127, 116, 21);
		this.getContentPane().add(textField_ID);
		
		JLabel lblNewLabel_ID = new JLabel("아이디:");
		lblNewLabel_ID.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_ID.setBounds(27, 130, 57, 15);
		this.getContentPane().add(lblNewLabel_ID);
		
		JButton btn_Send_1_1_1 = new JButton("재설정");
		btn_Send_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Send_1_1_1.setBounds(268, 275, 91, 29);
		this.getContentPane().add(btn_Send_1_1_1);
	}
	private void frameDown() {
		this.setVisible(false);
	}
}
