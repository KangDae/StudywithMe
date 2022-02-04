package TitleTest;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DTO.Protocol;
import Resource.R;
import Server.Client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*
 * 		시작 화면에서 로그인 클릭시 
 * 		보이게 되는 프레임입니다.
 */
public class FrameLogin extends R {
	
	public JTextField textField_ID;
	public JPasswordField passwordField_PW;
	public FrameLogin() {
//		this.setUndecorated(true);
		initialize();
	}

	public void start() {
		this.setVisible(true);
	}

	private void initialize() {

		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(135, 206, 235));

		accemble.StudyWithMe.setToolTipText("Home 으로 갑니다.");
		accemble.StudyWithMe.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		accemble.StudyWithMe.setBounds(45, 81, 303, 111);
		getContentPane().add(accemble.StudyWithMe);

		textField_ID = new JTextField();
		textField_ID.setBounds(129, 244, 203, 21);
		getContentPane().add(textField_ID);
		textField_ID.setColumns(10);

		passwordField_PW = new JPasswordField();
		passwordField_PW.setBounds(129, 275, 203, 21);
		passwordField_PW.setEchoChar('*');
		getContentPane().add(passwordField_PW);

		accemble.login_btn_Login = new JButton("로그인");
		accemble.login_btn_Login.setBackground(new Color(255, 255, 255));
		accemble.login_btn_Login.setBounds(56, 316, 276, 30);
		getContentPane().add(accemble.login_btn_Login);

		accemble.login_btn_SearchID = new JButton("아이디 찾기");
		accemble.login_btn_SearchID.setBackground(new Color(255, 255, 255));
		accemble.login_btn_SearchID.setBounds(56, 356, 115, 30);
		getContentPane().add(accemble.login_btn_SearchID);

		accemble.login_btn_SearchPW = new JButton("비밀번호 찾기");
		accemble.login_btn_SearchPW.setBackground(new Color(255, 255, 255));
		accemble.login_btn_SearchPW.setBounds(207, 356, 125, 30);
		getContentPane().add(accemble.login_btn_SearchPW);

		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(183, 364, 57, 15);
		getContentPane().add(lblNewLabel_1);

		accemble.login_btn_Exit = new JButton("종료");
		accemble.login_btn_Exit.setBackground(Color.WHITE);
		accemble.login_btn_Exit.setBounds(260, 489, 72, 43);
		getContentPane().add(accemble.login_btn_Exit);

		JLabel lblNewLabel = new JLabel(" 아 이 디 :");
		lblNewLabel.setBounds(59, 244, 75, 21);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("비밀번호 : ");
		lblNewLabel_2.setBounds(59, 275, 75, 21);
		getContentPane().add(lblNewLabel_2);
		
	}

	public void frameDown() {
		this.setVisible(false);
	}
}
