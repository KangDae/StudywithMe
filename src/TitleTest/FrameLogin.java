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
/*
 * 		시작 화면에서 로그인 클릭시 
 * 		보이게 되는 프레임입니다.
 */
public class FrameLogin extends JFrame implements R{
	public FrameLogin() {
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
		this.setBounds(100, 100, 426, 271);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_GoBack = new JLabel("Study With Me !");
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
		lblNewLabel_GoBack.setBounds(100, 0, 247, 66);
		getContentPane().add(lblNewLabel_GoBack);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(62, 76, 194, 21);
		getContentPane().add(textField_ID);
		textField_ID.setColumns(10);
		
		passwordField_PW = new JPasswordField();
		passwordField_PW.setBounds(62, 107, 194, 21);
		getContentPane().add(passwordField_PW);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameCenter.start();
			}
		});
		btnNewButton.setBounds(268, 76, 97, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_SearchID = new JButton("아이디 찾기");
		btnNewButton_SearchID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameIdSearch.start();
			}
		});
		btnNewButton_SearchID.setBounds(59, 155, 115, 30);
		getContentPane().add(btnNewButton_SearchID);
		
		JButton btnNewButton_SearchID_1 = new JButton("비밀번호 찾기");
		btnNewButton_SearchID_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDown();
				frameSearchPw.start();
			}
		});
		btnNewButton_SearchID_1.setBounds(210, 155, 125, 30);
		getContentPane().add(btnNewButton_SearchID_1);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(186, 163, 57, 15);
		getContentPane().add(lblNewLabel_1);
	}
	private void frameDown() {
		this.setVisible(false);
	}
}
