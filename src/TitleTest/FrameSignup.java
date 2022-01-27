package TitleTest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Resource.R;

import javax.swing.BorderFactory;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 *  		회원가입 프레임 입니다.
 */
public class FrameSignup extends JFrame implements R{
	public FrameSignup() {
//		initialize();
	}
	
	public JTextField textField_Name;
	public JTextField textField_ID;
	public JPasswordField passwordField_PW;
	public JTextField textField_FirstPhone;
	public JTextField textField_LastPhone;
	public JTextField textField_Email;
	public JTextField textField_EmailCertification;
	
	public JComboBox comboBox_Year = new JComboBox<String>(R.ageYear);
	public JComboBox comboBox_Moonth = new JComboBox<String>(R.ageMonth);
	public JComboBox comboBox_Day = new JComboBox<String>(R.ageDay);
	public JComboBox comboBox_SmallPhoneNumber = new JComboBox<String>(R.tel);
	public JComboBox comboBox_Email = new JComboBox<String>(R.email);
	
	public JButton btn_IDCheck = new JButton("중복");
	public JButton btn_EmailSend = new JButton("전송");
	public JButton btn_SignUpCheck = new JButton("확인");
	public JButton btn_SignUpCancle = new JButton("취소");

	public void start() {
		initialize();
	}

	private void initialize() {
		FrameSignup.this.setVisible(true);
		this.setBounds(100, 100, 405, 632);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel_SignUp = new JLabel("회원가입");
		lblNewLabel_SignUp.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_SignUp.setBounds(160, 20, 143, 53);
		this.getContentPane().add(lblNewLabel_SignUp);
		// 이름 필드
		JLabel lblNewLabel_Name = new JLabel("이  름 :");
		lblNewLabel_Name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Name.setBounds(27, 83, 57, 15);
		this.getContentPane().add(lblNewLabel_Name);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(96, 83, 116, 21);
		this.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		// 아이디 필드
		JLabel lblNewLabel_ID = new JLabel("아이디 :");
		lblNewLabel_ID.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_ID.setBounds(27, 124, 57, 15);
		this.getContentPane().add(lblNewLabel_ID);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(96, 124, 116, 21);
		this.getContentPane().add(textField_ID);
		
		
		btn_IDCheck.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_IDCheck.setBounds(222, 118, 72, 27);
		getContentPane().add(btn_IDCheck);
		// 패스워드 필드
		JLabel lblNewLabel_PW = new JLabel("비밀번호 :");
		lblNewLabel_PW.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_PW.setBounds(12, 168, 72, 15);
		this.getContentPane().add(lblNewLabel_PW);
		
		passwordField_PW = new JPasswordField();
		passwordField_PW.setEchoChar('*');
		passwordField_PW.setBounds(96, 165, 116, 21);
		this.getContentPane().add(passwordField_PW);
		/*
		 * 생년월일 Factory 시작 
		 */
		Border border_DateOfBird = BorderFactory.createTitledBorder("생년월일");
		JPanel layout_DateOfBird = new JPanel();
		layout_DateOfBird.setBorder(border_DateOfBird);
		layout_DateOfBird.setLayout(null);
		layout_DateOfBird.setBounds(12, 199, 350, 50);
		this.getContentPane().add(layout_DateOfBird);
		
//		JComboBox comboBox_Year = new JComboBox<String>(R.ageYear);
		comboBox_Year.setBounds(12, 19, 87, 23);
		layout_DateOfBird.add(comboBox_Year);
		
		
//		JComboBox comboBox_Moonth = new JComboBox<String>(R.ageMonth);
		comboBox_Moonth.setBounds(144, 19, 61, 23);
		layout_DateOfBird.add(comboBox_Moonth);
		
		JLabel lblNewLabel_Year = new JLabel("년도");
		lblNewLabel_Year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Year.setBounds(101, 20, 48, 15);
		layout_DateOfBird.add(lblNewLabel_Year);
		
//		JComboBox comboBox_Day = new JComboBox<String>(R.ageDay);
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
		/*
		 *  전화번호 Factory 시작 
		 */
		Border border_PhoneNumber = BorderFactory.createTitledBorder("전화번호");
		JPanel layout_PhoneNumber = new JPanel();
		layout_PhoneNumber.setBorder(border_PhoneNumber);
		layout_PhoneNumber.setLayout(null);
		layout_PhoneNumber.setBounds(12, 259, 350, 53);
		this.getContentPane().add(layout_PhoneNumber);
		
		
//		JComboBox comboBox_SmallPhoneNumber = new JComboBox<String>(R.tel);
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
		/*
		 * 이메일 Factory시작
		 */
		Border border_Email = BorderFactory.createTitledBorder("Email");
		JPanel layout_Email = new JPanel();
		layout_Email.setBorder(border_Email);
		layout_Email.setLayout(null);
		layout_Email.setBounds(12, 333, 365, 53);
		this.getContentPane().add(layout_Email);
		
		JLabel lblNewLabel_AtSign = new JLabel("@");
		lblNewLabel_AtSign.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_AtSign.setBounds(137, 26, 29, 15);
		layout_Email.add(lblNewLabel_AtSign);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(4);
		textField_Email.setBounds(59, 20, 76, 21);
		layout_Email.add(textField_Email);
		
		JLabel lblNewLabel_Email = new JLabel("email");
		lblNewLabel_Email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email.setBounds(12, 23, 57, 15);
		layout_Email.add(lblNewLabel_Email);
		
		
//		JComboBox comboBox_Email = new JComboBox<String>(R.email);
		comboBox_Email.setBounds(160, 19, 105, 23);
		layout_Email.add(comboBox_Email);
		
		btn_EmailSend.setBounds(277, 20, 76, 22);
		layout_Email.add(btn_EmailSend);
		btn_EmailSend.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		/*
		 *  이메일 인증
		 */
		JLabel lblNewLabel_Email_1 = new JLabel("email 인증");
		lblNewLabel_Email_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email_1.setBounds(27, 412, 91, 15);
		this.getContentPane().add(lblNewLabel_Email_1);
		
		textField_EmailCertification = new JTextField();
		textField_EmailCertification.setBounds(111, 412, 169, 21);
		this.getContentPane().add(textField_EmailCertification);
		textField_EmailCertification.setColumns(10);
		/*
		 * 막단 확인, 취소
		 */
		
		btn_SignUpCheck.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_SignUpCheck.setBounds(27, 507, 116, 40);
		getContentPane().add(btn_SignUpCheck);
		
		btn_SignUpCancle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_SignUpCancle.setBounds(246, 507, 116, 40);
		getContentPane().add(btn_SignUpCancle);
		
		
		
		
	}
}

