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
import java.awt.Color;
/*
 * 		비밀번호 찾기 프레임입니다.
 */
public class FrameSearchPW extends JFrame implements R{
	public FrameSearchPW() {
//		this.setUndecorated(true);
//		initialize();
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
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(135, 206 ,235));
		
		JLabel lblNewLabel_SearchPassword = new JLabel(R.image);
		lblNewLabel_SearchPassword.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_SearchPassword.setBounds(31, 32, 328, 107);
		this.getContentPane().add(lblNewLabel_SearchPassword);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(96, 180, 116, 21);
		this.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_Name = new JLabel("이  름 :");
		lblNewLabel_Name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Name.setBounds(27, 180, 57, 15);
		this.getContentPane().add(lblNewLabel_Name);
		// 생년월일 Factory 시작 
		Border border_DateOfBird = BorderFactory.createTitledBorder("생년월일");
		
		// 전화번호 Factory 시작 
		Border border_PhoneNumber = BorderFactory.createTitledBorder("전화번호");
		
		Border border_Email = BorderFactory.createTitledBorder("Email");
		JPanel layout_Email = new JPanel();
		layout_Email.setBackground(new Color(135, 206, 235));
		layout_Email.setBorder(border_Email);
		layout_Email.setLayout(null);
		layout_Email.setBounds(12, 266, 365, 53);
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
		
		JComboBox comboBox_Email = new JComboBox<String>();
		comboBox_Email.setBounds(178, 19, 105, 23);
		layout_Email.add(comboBox_Email);
		
		JButton btn_Send = new JButton("전송");
		btn_Send.setBackground(new Color(255, 255, 255));
		btn_Send.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Send.setBounds(286, 18, 67, 23);
		layout_Email.add(btn_Send);
		
		JLabel lblNewLabel_Email_1 = new JLabel("email 인증");
		lblNewLabel_Email_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email_1.setBounds(27, 341, 91, 15);
		this.getContentPane().add(lblNewLabel_Email_1);
		
		textField_EmailCheck = new JTextField();
		textField_EmailCheck.setBounds(111, 341, 169, 21);
		this.getContentPane().add(textField_EmailCheck);
		textField_EmailCheck.setColumns(10);
		
		JButton btn_EmailConfirm = new JButton("전송");
		btn_EmailConfirm.setBackground(new Color(255, 255, 255));
		btn_EmailConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_EmailConfirm.setBounds(292, 340, 67, 23);
		this.getContentPane().add(btn_EmailConfirm);
		
		JButton btn_pwSearchConfirm = new JButton("확인");
		btn_pwSearchConfirm.setBackground(new Color(255, 255, 255));
		btn_pwSearchConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_pwSearchConfirm.setBounds(31, 435, 80, 29);
		this.getContentPane().add(btn_pwSearchConfirm);
		
		JButton btn_pwCancle = new JButton("취소");
		btn_pwCancle.setBackground(new Color(255, 255, 255));
		btn_pwCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameLogin.start();
			}
		});
		btn_pwCancle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_pwCancle.setBounds(268, 435, 91, 29);
		this.getContentPane().add(btn_pwCancle);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(96, 224, 116, 21);
		this.getContentPane().add(textField_ID);
		
		JLabel lblNewLabel_ID = new JLabel("아이디:");
		lblNewLabel_ID.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_ID.setBounds(27, 227, 57, 15);
		this.getContentPane().add(lblNewLabel_ID);
		
		JButton btn_Send_1_1_1 = new JButton("재설정");
		btn_Send_1_1_1.setBackground(new Color(255, 255, 255));
		btn_Send_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Send_1_1_1.setBounds(27, 382, 332, 29);
		this.getContentPane().add(btn_Send_1_1_1);
		
		JButton btn_pwCancle_1 = new JButton("종료");
		btn_pwCancle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_pwCancle_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_pwCancle_1.setBackground(Color.WHITE);
		btn_pwCancle_1.setBounds(292, 514, 80, 37);
		getContentPane().add(btn_pwCancle_1);
	}
	private void frameDown() {
		this.setVisible(false);
	}
}
