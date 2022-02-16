package TitleTest;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DTO.Protocol;
import Function.Email.SendMail_update;
import Resource.R;
import Server.Client_network;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*
 * 		아이디 찾기 프레임입니다.
 */

public class FrameSearchID extends R {
	
	public JComboBox<String> comboBox_Day, comboBox_Moonth, comboBox_Email, comboBox_Year;
	public JTextField textField_Name, textField_ID, textField_Email, textField_auth, textField_EmailCheck;
	public JPasswordField passwordField_PW;
	public FrameSearchID() {

		initialize();
//		this.setUndecorated(true);
	}

	
	public void start() {
		this.setVisible(true);
	}

	
	private void initialize() {
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(135, 206, 235));

		
		accemble.LabelWithMe.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		accemble.LabelWithMe.setBounds(27, 46, 332, 101);
		this.getContentPane().add(accemble.LabelWithMe);

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

		comboBox_Email = new JComboBox<String>(R.email);
		comboBox_Email.setBounds(178, 19, 105, 23);
		layout_Email.add(comboBox_Email);

		accemble.searchi_btn_Send = new JButton("전송");
		accemble.searchi_btn_Send.setBackground(Color.WHITE);
		accemble.searchi_btn_Send.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		accemble.searchi_btn_Send.setBounds(286, 18, 67, 23);
		layout_Email.add(accemble.searchi_btn_Send);

		JLabel lblNewLabel_Email_1 = new JLabel("email 인증");
		lblNewLabel_Email_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_Email_1.setBounds(27, 360, 91, 15);
		this.getContentPane().add(lblNewLabel_Email_1);

		textField_EmailCheck = new JTextField();
		textField_EmailCheck.setBounds(111, 360, 169, 21);
		this.getContentPane().add(textField_EmailCheck);
		textField_EmailCheck.setColumns(10);

		accemble.searchi_btn_Auth = new JButton("인증");
		accemble.searchi_btn_Auth.setBackground(Color.WHITE);
		accemble.searchi_btn_Auth.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		accemble.searchi_btn_Auth.setBounds(292, 359, 67, 23);
		this.getContentPane().add(accemble.searchi_btn_Auth);

		accemble.searchi_btn_Confilrm = new JButton("확인");
		accemble.searchi_btn_Confilrm.setBackground(Color.WHITE);

		accemble.searchi_btn_Confilrm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		accemble.searchi_btn_Confilrm.setBounds(45, 423, 82, 39);
		this.getContentPane().add(accemble.searchi_btn_Confilrm);

		accemble.searchi_btn_Cancle = new JButton("취소");
		accemble.searchi_btn_Cancle.setBackground(Color.WHITE);
		accemble.searchi_btn_Cancle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		accemble.searchi_btn_Cancle.setBounds(254, 423, 82, 39);
		this.getContentPane().add(accemble.searchi_btn_Cancle);

		accemble.searchi_btn_Exit = new JButton("종료");
		accemble.searchi_btn_Exit.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		accemble.searchi_btn_Exit.setBackground(Color.WHITE);
		accemble.searchi_btn_Exit.setBounds(302, 522, 75, 29);
		getContentPane().add(accemble.searchi_btn_Exit);
		
	}

	public void frameDown() {
		this.setVisible(false);
	}
}
