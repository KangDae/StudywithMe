package TitleTest;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import FunctionTest.Email.SendMail_update;
import Resource.R;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*
 * 		아이디 찾기 프레임입니다.
 */

public class FrameIDSearch extends R {
	public FrameIDSearch() {

		initialize();
//		this.setUndecorated(true);
	}

	private JTextField textField_Name;
	private JTextField textField_Email;
	private JTextField textField_EmailCheck;

	/**
	 * Create the application.
	 */
	public void start() {
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(135, 206, 235));

		JLabel lblNewLabel_SignUp = new JLabel(image);
		lblNewLabel_SignUp.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_SignUp.setBounds(27, 46, 332, 101);
		this.getContentPane().add(lblNewLabel_SignUp);

		textField_Name = new JTextField();
		textField_Name.setBounds(96, 187, 116, 21);
		this.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);

		JLabel lblNewLabel_Name = new JLabel("이  름 :");
		lblNewLabel_Name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Name.setBounds(27, 187, 57, 15);
		this.getContentPane().add(lblNewLabel_Name);
		// 생년월일 Factory 시작
		Border border_DateOfBird = BorderFactory.createTitledBorder("생년월일");
		JPanel layout_DateOfBird = new JPanel();
		layout_DateOfBird.setBackground(new Color(135, 206, 235));
		layout_DateOfBird.setBorder(border_DateOfBird);
		layout_DateOfBird.setLayout(null);
		layout_DateOfBird.setBounds(12, 293, 365, 50);
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

		Border border_Email = BorderFactory.createTitledBorder("Email");
		JPanel layout_Email = new JPanel();
		layout_Email.setBackground(new Color(135, 206, 235));
		layout_Email.setBorder(border_Email);
		layout_Email.setLayout(null);
		layout_Email.setBounds(12, 218, 365, 53);
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
		btn_Send.setBackground(Color.WHITE);
		btn_Send.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Send.setBounds(286, 18, 67, 23);
		layout_Email.add(btn_Send);

		JLabel lblNewLabel_Email_1 = new JLabel("email 인증");
		lblNewLabel_Email_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email_1.setBounds(27, 360, 91, 15);
		this.getContentPane().add(lblNewLabel_Email_1);

		textField_EmailCheck = new JTextField();
		textField_EmailCheck.setBounds(111, 360, 169, 21);
		this.getContentPane().add(textField_EmailCheck);
		textField_EmailCheck.setColumns(10);

		JButton btn_Auth = new JButton("인증");
		btn_Auth.setBackground(Color.WHITE);
		btn_Auth.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Auth.setBounds(292, 359, 67, 23);
		this.getContentPane().add(btn_Auth);

		JButton btn_idSearchConfirm = new JButton("확인");
		btn_idSearchConfirm.setBackground(Color.WHITE);

		btn_idSearchConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_idSearchConfirm.setBounds(45, 423, 82, 39);
		this.getContentPane().add(btn_idSearchConfirm);

		JButton btn_Cancle = new JButton("취소");
		btn_Cancle.setBackground(Color.WHITE);
		btn_Cancle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Cancle.setBounds(254, 423, 82, 39);
		this.getContentPane().add(btn_Cancle);

		JButton btn_Exit = new JButton("종료");

		btn_Exit.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Exit.setBackground(Color.WHITE);
		btn_Exit.setBounds(302, 522, 75, 29);
		getContentPane().add(btn_Exit);
		
		btn_Send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField_Email.getText().length() == 0) {
					JOptionPane.showMessageDialog(btn_Confirm, "이메일을 입력해주세요");
				} else { 
					JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 전송되었습니다.");
					String emailStr = textField_Email.getText() + '@' + (String) comboBox_Email.getSelectedItem();
					scretNumber = String.valueOf(SendMail_update.SendMail(emailStr));
					System.out.println(scretNumber);
				}

			}
		});
		btn_Auth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 인증번호 확인
				 */
				if (!textField_EmailCheck.getText().equals(scretNumber)) {
					JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 틀렸습니다.");
				} else {
					JOptionPane.showMessageDialog(btn_Confirm, "인증되었습니다.");
					condition_Email = true;
				}
			}
		});
		btn_idSearchConfirm.addActionListener(new ActionListener() {
			/*
			 * 아이디 찾기
			 * 확인 버튼 클릭시 
			 * 이밴트 발생
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField_Name.getText();
				String year = (String) comboBox_Year.getSelectedItem();
				String moonth = (String) comboBox_Moonth.getSelectedItem();
				String day = (String) comboBox_Day.getSelectedItem();
				String email = textField_Email.getText();
				String email_auth = textField_EmailCheck.getText();
				if (name.length() == 0 || year.length() == 0 || moonth.length() == 0 || day.length() == 0
						|| email.length() == 0 || email_auth.length() == 0) {
					JOptionPane.showMessageDialog(btn_Confirm, "빈칸을 입력해주세요");
				} else if (condition_Email) {
					String line = "";
					line += name + "%" + year + moonth + day + "%" + email + '@' + comboBox_Email.getSelectedItem();
					System.out.println(line);

//					pw.println("")
//					pw.flush();

					textField_Email.setText("");
					textField_EmailCheck.setText("");
					textField_Name.setText("");
					comboBox_Year.setSelectedIndex(0);
					comboBox_Moonth.setSelectedIndex(0);
					comboBox_Day.setSelectedIndex(0);

				}

			}
		});
		btn_Cancle.addActionListener(new ActionListener() {
			/*
			 * 취소 => login창으로 돌아간다.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameLogin.setVisible(true);

				condition_Email = false;
				scretNumber = SCRET;
			}
		});
		btn_Exit.addActionListener(new ActionListener() {
			/*
			 * 종료 버튼
			 */
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void frameDown() {
		this.setVisible(false);
	}
}
