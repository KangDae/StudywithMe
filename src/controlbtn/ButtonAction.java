//package controlbtn;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
//import Resource.R;
//import TitleTest.FrameCenter;
//import TitleTest.FrameIDSearch;
//import TitleTest.FrameLogin;
//import TitleTest.FrameSearchPW;
//import TitleTest.FrameSignup;
//import TitleTest.FrameStart;
//
//public class ButtonAction implements R, ActionListener, Runnable{
//	private FrameStart frameStart; // 시작화면
//	private FrameLogin frameLogin;
//	private FrameCenter frameCenter;
//	private FrameSignup frameSignup;
//	private FrameSearchPW frameSearchPw;
//	private FrameIDSearch frameIdSearch;
//	
//	private boolean condition_Email = false;
//	private boolean condition_ID    = false;
//	
//	private final String SCRET      = "><^^ㅗ";
//	private String  scretNumber     = "><^^ㅗ";
//	
//	private JButton btn_Confirm     = new JButton("확인");
//	
//	public ButtonAction(){
//		frameStart = new FrameStart();
//		frameLogin = new FrameLogin();
//		frameCenter = new FrameCenter();
//		frameSignup = new FrameSignup();
//		frameSearchPw = new FrameSearchPW();
//		frameIdSearch = new FrameIDSearch();
//	}
//	
//	public void event(){
//		// 시작 프레임 버튼 구현
//		
//		frameStart.btnSignUp.addActionListener(this);
//		frameStart.loginBtn.addActionListener(this);
//		
//		// 회원가입 프레임 버튼 구현
//		
//		frameSignup.btn_IDCheck.addActionListener(this);
//		frameSignup.btn_EmailSend.addActionListener(this);
//		frameSignup.btn_SignUpCheck.addActionListener(this);
//		frameSignup.btn_SignUpCancle.addActionListener(this);
//		
//		// 
//		
//		
//		
//		
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		// 시작 프레임 부분 버튼 액션리스너
//		if(e.getSource() == frameStart.loginBtn) {
//			
//			frameLogin.start();
//			frameStart.setVisible(false);
//		
//		} else if (e.getSource() == frameStart.btnSignUp) {
//			
//			frameSignup.start();
//			frameStart.setVisible(false);
//		}
//		 
//		 
//		// 회원가입 프레임 부분 버튼 액션리스너
//		else if(e.getSource() == frameSignup.btn_SignUpCheck) {
//			
//			
//		
//		
//	}
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
//}
