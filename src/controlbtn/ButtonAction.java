package controlbtn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Resource.R;

public class ButtonAction implements R, ActionListener, Runnable{
	
	private boolean condition_Email = false;
	private boolean condition_ID    = false;
	
	private final String SCRET      = "><^^ㅗ";
	private String  scretNumber     = "><^^ㅗ";
	
	private JButton btn_Confirm     = new JButton("확인");
	
	
	public void event(){
		// 시작 프레임 버튼 구현
		
		frameStart.btnSignUp.addActionListener(this);
		frameStart.loginBtn.addActionListener(this);
		
		// 회원가입 프레임 버튼 구현
		
		frameSignup.btn_IDCheck.addActionListener(this);
		frameSignup.btn_EmailSend.addActionListener(this);
		frameSignup.btn_SignUpCheck.addActionListener(this);
		frameSignup.btn_SignUpCancle.addActionListener(this);
		
		// 
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 시작 프레임 부분 버튼 액션리스너
		if(e.getSource() == frameStart.loginBtn) {
			
			frameLogin.start();
			frameStart.setVisible(false);
		
		} else if (e.getSource() == frameStart.btnSignUp) {
			
			frameSignup.start();
			frameStart.setVisible(false);
		}
		 
		 
		// 회원가입 프레임 부분 버튼 액션리스너
		else if(e.getSource() == frameSignup.btn_SignUpCheck) {
			
			String name       = frameSignup.textField_Name.getText();
			String id         = frameSignup.textField_ID.getText();
			String pw         = frameSignup.passwordField_PW.getText();
			String ageYear    = ( String ) frameSignup.comboBox_Year.getSelectedItem();
			String ageMonnth  = ( String ) frameSignup.comboBox_Moonth.getSelectedItem();
			String ageDay     = ( String ) frameSignup.comboBox_Day.getSelectedItem();
			String tell1      = ( String ) frameSignup.comboBox_SmallPhoneNumber.getSelectedItem();
			String tell2      = frameSignup.textField_FirstPhone.getText();
			String tell3      = frameSignup.textField_LastPhone.getText();
			String email1     = frameSignup.textField_Email.getText();
			String email2     = ( String ) frameSignup.comboBox_Email.getSelectedItem();
			String emailCheck = frameSignup.textField_EmailCertification.getText();
			
			if( name.length()==0 || id.length()==0 || pw.length()==0 || tell2.length()==0 ||
				tell3.length()==0 || email1.length()==0 || emailCheck.length()==0){
				JOptionPane.showMessageDialog(btn_Confirm, "빈칸을 입력해 주세요");
			} else if ( condition_Email && condition_ID ) {
				String line = "";
				line += ( id+ "%" +pw+ "%" +name+ "%" +ageYear+ "%" +ageMonnth+ "%" +ageDay+ "%" +email1+"@"+email2)
						+ "%" +tell1+tell2+tell3;
				System.out.println(line);
//				pw.println(Protocol.RESISTER + "|" + line);
				JOptionPane.showMessageDialog(btn_Confirm, "회원가입 완료!");
				frameSignup.textField_Name.setText("");
				frameSignup.textField_ID.setText("");
				frameSignup.passwordField_PW.setText("");
				frameSignup.comboBox_Year.setSelectedIndex(0);
				frameSignup.comboBox_Moonth.setSelectedIndex(0);
				frameSignup.comboBox_Day.setSelectedIndex(0);
				frameSignup.comboBox_SmallPhoneNumber.setSelectedIndex(0);
				frameSignup.textField_FirstPhone.setText("");
				frameSignup.textField_LastPhone.setText("");
				frameSignup.textField_Email.setText("");
				frameSignup.comboBox_Email.setSelectedIndex(0);
				frameSignup.textField_EmailCertification.setText("");
				
				condition_Email = false;
				condition_ID    = false;
				scretNumber     = SCRET;
			} else if ( !condition_ID    && condition_Email) {
				JOptionPane.showMessageDialog(btn_Confirm, "ID 중복확인 해주세요");
			} else if ( !condition_Email && condition_ID   ) {
				JOptionPane.showMessageDialog(btn_Confirm, "이메일 인증을 해주세요");
			} else if ( !condition_ID    && condition_Email) {
				JOptionPane.showMessageDialog(btn_Confirm, "ID중복, 이메일 인증을 해주세요");
			}
			
		} else if (e.getSource() == frameSignup.btn_SignUpCancle ) {
			frameStart.start();
			frameSignup.setVisible(false);
		}
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
