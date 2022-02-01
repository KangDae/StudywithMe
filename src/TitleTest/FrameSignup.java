package TitleTest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DTO.Protocol;
import FunctionTest.Email.SendMail_update;
import Resource.R;

import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*
 *  		회원가입 프레임 입니다.
 */
public class FrameSignup extends R {
	/**
	 * 직렬화
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField_Name;
	private JTextField textField_ID;
	private JPasswordField passwordField_PW;
	private JTextField textField_Email;
	private JTextField textField_auth;

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

		JButton btn_IDCheck = new JButton("중복");
		btn_IDCheck.setBackground(Color.WHITE);
		btn_IDCheck.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_IDCheck.setBounds(222, 200, 72, 27);
		getContentPane().add(btn_IDCheck);
		// 패스워드 필드
		JLabel lblNewLabel_PW = new JLabel("비밀번호 :");
		lblNewLabel_PW.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_PW.setBounds(12, 250, 72, 15);
		this.getContentPane().add(lblNewLabel_PW);

		passwordField_PW = new JPasswordField();
		passwordField_PW.setEchoChar('*');
		passwordField_PW.setBounds(96, 247, 116, 21);
		this.getContentPane().add(passwordField_PW);
		/*
		 * 생년월일 Factory 시작
		 */
		Border border_DateOfBird = BorderFactory.createTitledBorder("생년월일");
		JPanel layout_DateOfBird = new JPanel();
		layout_DateOfBird.setForeground(new Color(0, 206, 209));
		layout_DateOfBird.setBackground(new Color(135, 206, 235));
		layout_DateOfBird.setBorder(border_DateOfBird);
		layout_DateOfBird.setLayout(null);
		layout_DateOfBird.setBounds(12, 281, 350, 50);
		this.getContentPane().add(layout_DateOfBird);

		JComboBox comboBox_Year = new JComboBox<String>(R.ageYear);
		comboBox_Year.setBackground(new Color(255, 255, 255));
		comboBox_Year.setBounds(12, 19, 87, 23);
		layout_DateOfBird.add(comboBox_Year);

		JComboBox comboBox_Moonth = new JComboBox<String>(R.ageMonth);
		comboBox_Moonth.setBackground(new Color(255, 255, 255));
		comboBox_Moonth.setBounds(144, 19, 61, 23);
		layout_DateOfBird.add(comboBox_Moonth);

		JLabel lblNewLabel_Year = new JLabel("년도");
		lblNewLabel_Year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Year.setBounds(101, 20, 48, 15);
		layout_DateOfBird.add(lblNewLabel_Year);

		JComboBox comboBox_Day = new JComboBox<String>(R.ageDay);
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
		 * 전화번호 Factory 시작
		 */
		Border border_PhoneNumber = BorderFactory.createTitledBorder("전화번호");
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

		JComboBox comboBox_Email = new JComboBox<String>(R.email);
		comboBox_Email.setBounds(160, 19, 105, 23);
		layout_Email.add(comboBox_Email);

		JButton btn_EmailSend = new JButton("전송");
		btn_EmailSend.setBackground(Color.WHITE);
		btn_EmailSend.setBounds(277, 20, 76, 22);
		layout_Email.add(btn_EmailSend);
		btn_EmailSend.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		JLabel lblNewLabel_Email_1 = new JLabel("email 인증");
		lblNewLabel_Email_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email_1.setBounds(27, 416, 91, 15);
		this.getContentPane().add(lblNewLabel_Email_1);
		/*
		 * 이메일 인증 이밴트
		 */
		JButton btn_Auth = new JButton("인증");
		btn_Auth.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_Auth.setBackground(Color.WHITE);
		btn_Auth.setBounds(292, 415, 76, 22);
		getContentPane().add(btn_Auth);

		textField_auth = new JTextField();
		textField_auth.setBounds(111, 416, 169, 21);
		this.getContentPane().add(textField_auth);
		textField_auth.setColumns(10);
		
		/*
		 * 막단 확인, 취소
		 * 
		 */
		JButton btn_SignUpCheck = new JButton("확인");
		btn_SignUpCheck.setBackground(Color.WHITE);
		btn_SignUpCheck.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_SignUpCheck.setBounds(27, 507, 116, 40);
		getContentPane().add(btn_SignUpCheck);

		JButton btn_SignUpCancle = new JButton("취소");
		btn_SignUpCancle.setBackground(Color.WHITE);
		btn_SignUpCancle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_SignUpCancle.setBounds(246, 507, 116, 40);
		getContentPane().add(btn_SignUpCancle);
		
		// ==> 아이드 중복체크 기능구현 <==
		btn_IDCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 데이터의 유효성검사
				 */
				if(textField_ID.getText().length() == 0) {
					JOptionPane.showMessageDialog(btn_Confirm, "아이디를 입력하세요");
				} else if(textField_ID.getText().length()<8) {
					JOptionPane.showMessageDialog(btn_Confirm, "아이디는 8글자 이상으로 입력해주세요");
				} else {
					/*
					 * 조건에 부합한지 마지막확인
					 * db에 중복되는 아이디가 있을경우 
					 * Client부분에서 처리
					 */
					pw.println(Protocol.IDSEARCHCHECK + "|" + textField_ID.getText());
					pw.flush();
				}
					
			}
		});
		// ==> 인증번호 보내기 기능 구현 <==
		btn_EmailSend.addActionListener(new ActionListener() {
			/*
			 * 이메일 인증 전송 버튼
			 */
			public void actionPerformed(ActionEvent e) {
				// 이메일칸이 비어있을 경우 이밴트 발생
				if(textField_Email.getText().length() == 0) {
					JOptionPane.showMessageDialog(btn_Confirm, "이메일을 입력해주세요");
				} else {
					JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 전송되었습니다.");
					String emailStr = textField_Email.getText() + '@' + 
					( String ) comboBox_Email.getSelectedItem();
					scretNumber = String.valueOf(SendMail_update.SendMail(emailStr));
					System.out.println(scretNumber);
				}
			}
		});
		// ==> 인증 버튼 기능 구현 <== 
		btn_Auth.addActionListener(new ActionListener() {
			/*
			 * 이메일 인증 버튼 이밴트 기능 구현 
			 * =============> 인증 버튼 구현 <===============
			 */
			public void actionPerformed(ActionEvent e) {
				if(textField_auth.getText().equals(scretNumber)) {
					JOptionPane.showMessageDialog(btn_Confirm, "인증되었습니다.");
					condition_Email = true;
				} else {
					JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 틀렸습니다.");
				}
			}
		});
		btn_SignUpCancle.addActionListener(new ActionListener() {
			/*
			 * 취소를 누를시 현재창을 setVisible하고 frame의 처음시작점으로 돌아감. =============> 취소 버튼 구현
			 * <===============
			 */
			public void actionPerformed(ActionEvent e) {
				FrameSignup.this.setVisible(false);
				frameStart.start();
				/*
				 * 혹시라도 Email과 ID중복을 확인했을수 있기때문에
				 * 초기화 해줌
				 */
				condition_Email = false;
				condition_ID = false;
				scretNumber = SCRET;
			}
		});
		btn_SignUpCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 확인 누를시 버튼 이벤트 =============> 취소 버튼 구현 <===============
				 */
				String name = textField_Name.getText();
				String id = textField_ID.getText();
				String password = passwordField_PW.getText();
				String ageYear = (String) comboBox_Year.getSelectedItem();
				String ageMonnth = (String) comboBox_Moonth.getSelectedItem();
				String ageDay = (String) comboBox_Day.getSelectedItem();
				String email1 = textField_Email.getText();
				String email2 = (String) comboBox_Email.getSelectedItem();
//		        String emailCheck = textField_EmailCertification.getText();

				if (name.length() == 0 || id.length() == 0 || password.length() == 0 || email1.length() == 0) {// || emailCheck.length==0																					// emailCheck.length()==0
					JOptionPane.showMessageDialog(btn_Confirm, "빈칸을 입력해 주세요");
				} else if (condition_Email && condition_ID) {
					String line = "";
					line += (id + "%" + password + "%" + name + "%" + ageYear + "%" + ageMonnth + "%" + ageDay + "%" + email1
							+ "@" + email2);
					System.out.println(line);
		            pw.println(Protocol.REGISTER + "|" + line);
		            pw.flush();
					
					JOptionPane.showMessageDialog(btn_Confirm, "회원가입 완료!");
					/*
					 * 회원 가입 이후 버튼의
					 * 텍스트필드 초기화
					 */
					textField_Name.setText("");
					textField_ID.setText("");
					passwordField_PW.setText("");
					comboBox_Year.setSelectedIndex(0);
					comboBox_Moonth.setSelectedIndex(0);
					comboBox_Day.setSelectedIndex(0);
					textField_Email.setText("");
					comboBox_Email.setSelectedIndex(0);
					textField_auth.setText("");
					/*
					 * 인증받았던 값을 모두 false로 초기화 해준다.
					 */
					condition_Email = false;
					condition_ID = false;
					scretNumber = SCRET;
				// 아이디 중복확인을 하지않고 이메일 인증만 했을 경우
				} else if (!condition_ID && condition_Email) {
					JOptionPane.showMessageDialog(btn_Confirm, "ID 중복확인 해주세요");
				// 이메일 인증만하고 중복확인을 하지 않았을경우
				} else if (!condition_Email && condition_ID) {
					JOptionPane.showMessageDialog(btn_Confirm, "이메일 인증을 해주세요");
				// 둘다 안했을 경우
				} else if (!condition_ID && !condition_Email) {
					JOptionPane.showMessageDialog(btn_Confirm, "ID중복, 이메일 인증을 해주세요");
				}

			}

		});
		

	}
}
