package TitleTest;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Resource.R;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/*
 * 		시작 화면에서 로그인 클릭시 
 * 		보이게 되는 프레임입니다.
 */
public class FrameLogin extends JFrame implements R{
	public FrameLogin() {
//		this.setUndecorated(true);
//		initialize();
	}
	
	private JTextField tfId;
	private JTextField textField_1;
	private JButton btnLogin;
	private JTextField textField_ID;
	private JPasswordField passwordField_PW;


	public void start(){
		initialize();
	}
	private void initialize() {
		
		this.setVisible(true);
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(135, 206 ,235));
		JLabel lblNewLabel_GoBack = new JLabel(R.image);
		lblNewLabel_GoBack.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				FrameLogin.this.setVisible(false);
				frameStart.start();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		lblNewLabel_GoBack.setToolTipText("Home 으로 갑니다.");
		lblNewLabel_GoBack.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_GoBack.setBounds(45, 81, 303, 111);
		getContentPane().add(lblNewLabel_GoBack);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(129, 244, 203, 21);
		getContentPane().add(textField_ID);
		textField_ID.setColumns(10);
		
		passwordField_PW = new JPasswordField();
		passwordField_PW.setBounds(129, 275, 203, 21);
		passwordField_PW.setEchoChar('*');
		getContentPane().add(passwordField_PW);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameCenter.start();
			}
		});
		btnNewButton.setBounds(56, 316, 276, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_SearchID = new JButton("아이디 찾기");
		btnNewButton_SearchID.setBackground(new Color(255, 255, 255));
		btnNewButton_SearchID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameIdSearch.start();
			}
		});
		btnNewButton_SearchID.setBounds(56, 356, 115, 30);
		getContentPane().add(btnNewButton_SearchID);
		
		JButton btnNewButton_SearchID_1 = new JButton("비밀번호 찾기");
		btnNewButton_SearchID_1.setBackground(new Color(255, 255, 255));
		btnNewButton_SearchID_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameSearchPw.start();
			}
		});
		btnNewButton_SearchID_1.setBounds(207, 356, 125, 30);
		getContentPane().add(btnNewButton_SearchID_1);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(183, 364, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JButton btn_login_End = new JButton("종료");
		btn_login_End.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btn_login_End.setBackground(Color.WHITE);
		btn_login_End.setBounds(260, 489, 72, 43);
		getContentPane().add(btn_login_End);
		
		JLabel lblNewLabel = new JLabel(" 아 이 디 :");
		lblNewLabel.setBounds(59, 244, 75, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호 : ");
		lblNewLabel_2.setBounds(59, 275, 75, 21);
		getContentPane().add(lblNewLabel_2);
	}
	private void frameDown() {
		this.setVisible(false);
	}
}
