package TitleTest;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DTO.Protocol;
import FunctionTest.Email.SendMail_update;
import Resource.R;
import Server.Client;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*
 * 		비밀번호 찾기 프레임입니다.
 */

public class FrameSearchPW extends R {
	
	
	PrintWriter pw = null;
	public FrameSearchPW() {
//		this.setUndecorated(true);
		initialize();
	}

	private JTextField textField_Name;
	private JTextField textField_Email;
	private JTextField textField_auth;
	private JTextField textField_ID;

	JButton btn_pwExit, btn_Reset;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pw = Client.pw;
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(135, 206, 235));

		JLabel lblNewLabel_SearchPassword = new JLabel(image);
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

		JComboBox comboBox_Email = new JComboBox<String>(R.email);
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

		textField_auth = new JTextField();
		textField_auth.setBounds(111, 341, 169, 21);
		this.getContentPane().add(textField_auth);
		textField_auth.setColumns(10);

		JButton btn_EmailConfirm = new JButton("인증");
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

		btn_Reset = new JButton("재설정");
		btn_Reset.setBackground(new Color(255, 255, 255));
		btn_Reset.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Reset.setBounds(27, 382, 332, 29);
		this.getContentPane().add(btn_Reset);

		btn_pwExit = new JButton("종료");
		btn_pwExit.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_pwExit.setBackground(Color.WHITE);
		btn_pwExit.setBounds(292, 514, 80, 37);
		getContentPane().add(btn_pwExit);

		// ==> 전송버튼 기능 구현 <==
		btn_Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이메일칸이 비어있을 경우 이밴트 발생
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
		// ==>확인버튼 기능 구현 <==
		/*
		 * 확인 버튼 클릭시 로그인창으로
		 * 
		 */
		btn_pwSearchConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = frameSearchPw.textField_Name.getText();
				String id = frameSearchPw.textField_ID.getText();
				String email1 = frameSearchPw.textField_Email.getText();
				String email2 = (String) comboBox_Email.getSelectedItem();
//		        String emailCheck =  textField_EmailCertification.getText();
				
				if (name.length() == 0 || id.length() == 0 || email1.length() == 0) {
					// emailCheck.length() ==0
					JOptionPane.showMessageDialog(btn_Confirm, "빈칸을 입력해 주세요");
				} else if(condition_PW == false) {
					JOptionPane.showMessageDialog(btn_Confirm, "비밀번호를 변경해주세요");
				} else if (condition_Email) {
					String line = "";
					line += (name + "%" + id + "%" + newPassword);
					/*
					 *  서버 부분 구현 
					 *  이름과 아이디가 일치하며 (현재 있는 아이디일경우)
					 *  비밀번호를 set 해주고. 그렇지 않을경우 옵션팬으로
					 *  안된다고 알려준다.
					 */
					pw.println(Protocol.PWSEARCH + "|" + line);
					
					System.out.println(line);
					textField_Name.setText("");
					textField_ID.setText("");
					textField_Email.setText("");
					comboBox_Email.setSelectedIndex(0);
					
					condition_PW = false;
					condition_Email = false;
					frameDown();
					frameLogin.start();
				} else if (!condition_Email) {
					JOptionPane.showMessageDialog(btn_Confirm, "이메일 인증을 해주세요");
				}

			}

		});
		// ==> 이메일 인증 기능 구현 <==
		btn_EmailConfirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (textField_auth.getText().equals(scretNumber)) {
					JOptionPane.showMessageDialog(btn_Confirm, "인증되었습니다.");
					condition_Email = true;
				} else {
					JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 틀렸습니다.");
				}
			}
		});
		// ==> 취소버튼 기능 구현 <==
		btn_pwCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameLogin.start();

				scretNumber = SCRET;
				condition_Email = false;
			}
		});
		// ==> 재설정버튼 기능 구현 <==
		/*
		 * 재설정 버튼은 위에 모든 조건에 충족할시 비밀번호를 초기화 or 교체 할수 있는 기능 구현
		 */
		btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_Name.getText();
				String id = textField_ID.getText();
				String line = name + "%" + id;

				if(condition_Email==false) {
					JOptionPane.showMessageDialog(btn_Confirm, "이메일을 인증해주세요.");
				} else {
					framePassWordCheck.start();
				}
				
			}
		});
		// ==> 종료버튼 기능 구현 <==
		btn_pwExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void frameDown() {
		this.setVisible(false);
	}
}
