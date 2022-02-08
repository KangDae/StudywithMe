
package TitleTest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import ButtonAction.ButtonAccemble;
import DTO.Protocol;
import FunctionTest.Email.SendMail_update;
import Resource.R;
import Server.Client;

import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Color;

/*
 *  		회원가입 프레임 입니다.
 *  		졸업
 */
public class FrameSignup extends R {
	public JComboBox<String> comboBox_Day, comboBox_Moonth, comboBox_Email, comboBox_Year;
	public JTextField textField_Name, textField_ID, textField_Email, textField_auth, textField_EmailCheck;
	public JPasswordField passwordField_PW;
	public FrameSignup() {
//		this.setUndecorated(true);	
		initialize();
	}

	public void start() {
		this.setVisible(true);
	}

	private void initialize() {

		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		getContentPane().setBackground(new Color(135, 206, 235));
		JLabel lblNewLabel_SignUp = new JLabel(image);
		lblNewLabel_SignUp.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_SignUp.setBounds(45, 32, 301, 101);
		this.getContentPane().add(lblNewLabel_SignUp);
		// 이름 필드
		JLabel lblNewLabel_Name = new JLabel("이  름 :");
		lblNewLabel_Name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Name.setBounds(27, 165, 57, 15);
		this.getContentPane().add(lblNewLabel_Name);

		textField_Name = new JTextField();
		textField_Name.setBounds(96, 165, 116, 21);
		this.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		// 아이디 필드
		JLabel lblNewLabel_ID = new JLabel("아이디 :");
		lblNewLabel_ID.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_ID.setBounds(27, 206, 57, 15);
		this.getContentPane().add(lblNewLabel_ID);

		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(96, 206, 116, 21);
		this.getContentPane().add(textField_ID);

		accemble.signup_btn_IDCheck = new JButton("중복");
		accemble.signup_btn_IDCheck.setBackground(Color.WHITE);
		accemble.signup_btn_IDCheck.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		accemble.signup_btn_IDCheck.setBounds(222, 200, 72, 27);
		getContentPane().add(accemble.signup_btn_IDCheck);
		// 패스워드 필드
		JLabel lblNewLabel_PW = new JLabel("비밀번호 :");
		lblNewLabel_PW.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_PW.setBounds(12, 250, 72, 15);
		this.getContentPane().add(lblNewLabel_PW);

		passwordField_PW = new JPasswordField();
		passwordField_PW.setBounds(96, 247, 116, 21);
		this.getContentPane().add(passwordField_PW);
		/*
		 * 생년월일 Factory 시작
		 */
		Border border_DateOfBird = BorderFactory.createTitledBorder("생년월일");
		JPanel layout_DateOfBird = new JPanel();
		layout_DateOfBird.setBackground(new Color(135, 206, 235));
		layout_DateOfBird.setBorder(border_DateOfBird);
		layout_DateOfBird.setLayout(null);
		layout_DateOfBird.setBounds(12, 281, 350, 50);
		this.getContentPane().add(layout_DateOfBird);
		
		comboBox_Year = new JComboBox<String>(R.ageYear);
		comboBox_Year.setBounds(12, 19, 87, 23);
		layout_DateOfBird.add(comboBox_Year);

		comboBox_Moonth = new JComboBox<String>(R.ageMonth);
		comboBox_Moonth.setBounds(144, 19, 61, 23);
		layout_DateOfBird.add(comboBox_Moonth);

		JLabel lblNewLabel_Year = new JLabel("년도");
		lblNewLabel_Year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Year.setBounds(101, 20, 48, 15);
		layout_DateOfBird.add(lblNewLabel_Year);

		comboBox_Day = new JComboBox<String>(R.ageDay);
		comboBox_Day.setBackground(new Color(255, 255, 255));
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
		 * 이메일 Factory시작
		 */
		Border border_Email = BorderFactory.createTitledBorder("Email");
		JPanel layout_Email = new JPanel();
		layout_Email.setBackground(new Color(135, 206, 235));
		layout_Email.setBorder(border_Email);
		layout_Email.setLayout(null);
		layout_Email.setBounds(12, 341, 365, 53);
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

		comboBox_Email = new JComboBox<String>(R.email);
		comboBox_Email.setBounds(160, 19, 105, 23);
		layout_Email.add(comboBox_Email);

		accemble.signup_btn_EmailSend = new JButton("전송");
		accemble.signup_btn_EmailSend.setBackground(Color.WHITE);
		accemble.signup_btn_EmailSend.setBounds(277, 20, 76, 22);
		layout_Email.add(accemble.signup_btn_EmailSend);
		accemble.signup_btn_EmailSend.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		JLabel lblNewLabel_Email_1 = new JLabel("email 인증");
		lblNewLabel_Email_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email_1.setBounds(27, 416, 91, 15);
		this.getContentPane().add(lblNewLabel_Email_1);
		/*
		 * 이메일 인증 이밴트
		 */
		accemble.signup_btn_Auth = new JButton("인증");
		accemble.signup_btn_Auth.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		accemble.signup_btn_Auth.setBackground(Color.WHITE);
		accemble.signup_btn_Auth.setBounds(292, 415, 76, 22);
		getContentPane().add(accemble.signup_btn_Auth);

		textField_auth = new JTextField();
		textField_auth.setBounds(111, 416, 169, 21);
		this.getContentPane().add(textField_auth);
		textField_auth.setColumns(10);
		
		/*
		 * 막단 확인, 취소
		 * 
		 */
		accemble.signup_btn_Check = new JButton("확인");
		accemble.signup_btn_Check.setBackground(Color.WHITE);
		accemble.signup_btn_Check.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		accemble.signup_btn_Check.setBounds(246, 507, 116, 40);
		getContentPane().add(accemble.signup_btn_Check);

		accemble.signup_btn_Cancle = new JButton("취소");
		accemble.signup_btn_Cancle.setBackground(Color.WHITE);
		accemble.signup_btn_Cancle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		accemble.signup_btn_Cancle.setBounds(27, 507, 116, 40);
		getContentPane().add(accemble.signup_btn_Cancle);
		

		

	}
	public void frameDown() {
		this.setVisible(false);
	}
}