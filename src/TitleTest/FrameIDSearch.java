package TitleTest;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Resource.R;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * 		아이디 찾기 프레임입니다.
 */
public class FrameIDSearch extends JFrame implements R{
	public FrameIDSearch() {
	}
//	public FrameIDSearch() {
//		initialize();
//	}
	private JTextField textField_Name;
	private JTextField textField_FirstPhone;
	private JTextField textField_LastPhone;
	private JTextField textField_Email;
	private JTextField textField_EmailCheck;
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
		this.setVisible(true);
		this.setBounds(100, 100, 405, 523);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_SignUp = new JLabel("아이디 찾기");
		lblNewLabel_SignUp.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_SignUp.setBounds(111, 20, 225, 53);
		this.getContentPane().add(lblNewLabel_SignUp);
		
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
		JPanel layout_DateOfBird = new JPanel();
		layout_DateOfBird.setBorder(border_DateOfBird);
		layout_DateOfBird.setLayout(null);
		layout_DateOfBird.setBounds(12, 189, 365, 50);
		this.getContentPane().add(layout_DateOfBird);
		
		JComboBox comboBox_Year = new JComboBox<String>(R.ageYear);
		comboBox_Year.setBounds(12, 19, 87, 23);
		layout_DateOfBird.add(comboBox_Year);
		
		JComboBox comboBox_Moonth = new JComboBox<String>(R.ageMonth);
		comboBox_Moonth.setBounds(144, 19, 61, 23);
		layout_DateOfBird.add(comboBox_Moonth);
		
		JLabel lblNewLabel_Year = new JLabel("년도");
		lblNewLabel_Year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Year.setBounds(101, 20, 48, 15);
		layout_DateOfBird.add(lblNewLabel_Year);
		
		JComboBox comboBox_Day = new JComboBox<String>(R.ageDay);
		comboBox_Day.setBounds(241, 19, 72, 23);
		layout_DateOfBird.add(comboBox_Day);
		
		JLabel lblNewLabel_Moonth = new JLabel("월");
		lblNewLabel_Moonth.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Moonth.setBounds(217, 20, 48, 15);
		layout_DateOfBird.add(lblNewLabel_Moonth);
		
		JLabel lblNewLabel_Day = new JLabel("일");
		lblNewLabel_Day.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Day.setBounds(317, 20, 48, 15);
		layout_DateOfBird.add(lblNewLabel_Day);
		
		// 전화번호 Factory 시작 
		Border border_PhoneNumber = BorderFactory.createTitledBorder("전화번호");
		JPanel layout_PhoneNumber = new JPanel();
		layout_PhoneNumber.setBorder(border_PhoneNumber);
		layout_PhoneNumber.setLayout(null);
		layout_PhoneNumber.setBounds(12, 259, 365, 53);
		this.getContentPane().add(layout_PhoneNumber);
		
		JComboBox comboBox_SmallPhoneNumber = new JComboBox<String>(R.tel);
		comboBox_SmallPhoneNumber.setBounds(45, 19, 54, 23);
		layout_PhoneNumber.add(comboBox_SmallPhoneNumber);
		
		JLabel lblNewLabel_Bar = new JLabel(" - ");
		lblNewLabel_Bar.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_Bar.setBounds(117, 18, 48, 15);
		layout_PhoneNumber.add(lblNewLabel_Bar);
		
		JLabel lblNewLabel_Bar2 = new JLabel(" - ");
		lblNewLabel_Bar2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_Bar2.setBounds(217, 18, 29, 15);
		layout_PhoneNumber.add(lblNewLabel_Bar2);
		
		textField_FirstPhone = new JTextField();
		textField_FirstPhone.setBounds(145, 20, 60, 21);
		layout_PhoneNumber.add(textField_FirstPhone);
		textField_FirstPhone.setColumns(4);
		
		textField_LastPhone = new JTextField();
		textField_LastPhone.setColumns(4);
		textField_LastPhone.setBounds(243, 20, 60, 21);
		layout_PhoneNumber.add(textField_LastPhone);
		
		Border border_Email = BorderFactory.createTitledBorder("Email");
		JPanel layout_Email = new JPanel();
		layout_Email.setBorder(border_Email);
		layout_Email.setLayout(null);
		layout_Email.setBounds(12, 114, 365, 53);
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
		lblNewLabel_Email_1.setBounds(27, 333, 91, 15);
		this.getContentPane().add(lblNewLabel_Email_1);
		
		textField_EmailCheck = new JTextField();
		textField_EmailCheck.setBounds(111, 333, 169, 21);
		this.getContentPane().add(textField_EmailCheck);
		textField_EmailCheck.setColumns(10);
		
		JButton btn_EmailConfirm = new JButton("확인");
		btn_EmailConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_EmailConfirm.setBounds(292, 332, 67, 23);
		this.getContentPane().add(btn_EmailConfirm);
		
		JButton btn_idSearchConfirm = new JButton("확인");
		btn_idSearchConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_idSearchConfirm.setBounds(45, 423, 82, 39);
		this.getContentPane().add(btn_idSearchConfirm);
		
		JButton btn_Cancle = new JButton("취소");
		btn_Cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameStart.start();
			}
		});
		btn_Cancle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Cancle.setBounds(254, 423, 82, 39);
		this.getContentPane().add(btn_Cancle);
	}
	private void frameDown() {
		this.setVisible(false);
	}
}
