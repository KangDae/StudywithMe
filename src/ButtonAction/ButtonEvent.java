package ButtonAction;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DTO.Protocol;
import FunctionTest.Email.SendMail_update;
import Resource.R;
import Server.Client_network;

public class ButtonEvent extends ButtonAccemble implements ActionListener, MouseListener, ListSelectionListener {
	PrintWriter pw;
	BufferedReader br;
	String pLine = "";
	String subject = "모두";
	String update = "";
	String myIdname = "";

	public ButtonEvent() {
		pw = Client_network.pw;
		br = Client_network.br;
		event();
	}

	public void event() {

		// ================== 시작 프레임 부분 ======================
		start_btn_loginBtn.addActionListener(this); // 로그인
		start_btn_SingUp.addActionListener(this); // 회원가입
		btnExit.addActionListener(this); // 종료.
		// ================== 회원가입 프레임 부분 ======================
		signup_btn_IDCheck.addActionListener(this); // 아이디중복확인
		signup_btn_EmailSend.addActionListener(this);// 이메일 인증보내기
		signup_btn_Auth.addActionListener(this); // 이메일 인증
		signup_btn_Cancle.addActionListener(this); // 회원가입 취소
		signup_btn_Check.addActionListener(this); // 회원가입 확인
		// ================== 로그인 프레임 부분 ======================
		StudyWithMe.addMouseListener(this); // 홈으로
		login_btn_Login.addActionListener(this); // 로그인 확인
		login_btn_SearchID.addActionListener(this); // 로그인->아이디찾기
		login_btn_SearchPW.addActionListener(this); // 로그인->비밀번호찾기
		login_btn_Exit.addActionListener(this); // 로그인->종료
		// ================== 아이디 찾기 부분 ======================
		searchi_btn_Send.addActionListener(this); // 아이디찾기 이메일보내기
		searchi_btn_Auth.addActionListener(this); // 아이디찾기 이메일인증
		searchi_btn_Cancle.addActionListener(this); // 아이디찾기 취소
		searchi_btn_Exit.addActionListener(this); // 아이디찾기 종료
		searchi_btn_Confilrm.addActionListener(this);// 아이디찾기 확인
		// ================== 비밀번호 찾기 부분 ======================
		searchp_btn_Send.addActionListener(this); // 비밀번호찾기 이메일보내기
		searchp_btn_Confirm.addActionListener(this); // 비밀번호찾기 확인
		searchp_btn_Auth.addActionListener(this); // 비밀번호찾기 이메일인증
		searchp_btn_pwCancle.addActionListener(this);// 비밀번호찾기 취소
		searchp_btn_pwExit.addActionListener(this); // 비밀번호찾기 종료
		searchp_btn_Reset.addActionListener(this); // 비밀번호찾기 재설정
		// ================== 재설정 부분 ===========================
		reset_btn_pwCheck.addActionListener(this); // 재설정 비밀번호확인
		reset_btn_Cancle.addActionListener(this); // 재설정 취소
		reset_btn_Reset.addActionListener(this); // 재설정 재설정하기
		// ================== 센터 부분 =============================
		frameCenter.Center_button_SearchRoom.addActionListener(this); // 매인창 방검색
		frameCenter.Center_btn_update.addActionListener(this); // 매인창 내정보수정
		frameCenter.Center_btn_Logout.addActionListener(this); // 매인창 로그아웃
		frameCenter.Center_btn_Send.addActionListener(this); // 매인창 채팅전송
		frameCenter.Center_comboBox_List.addActionListener(this); // 매인창 룸필터
		frameCenter.Center_button_MakeRoom.addActionListener(this); // 매인창 방만들기
		// ===============> 내정보 수정하는 부분(in Center)<===============
		frameCenter.btn_updateID.addActionListener(this); // 아이디수정
		frameCenter.btn_updateName.addActionListener(this); // 이름수정
		frameCenter.btn_updatePW.addActionListener(this); // 비밀번호 수정
		frameCenter.btn_updateEmail.addActionListener(this); // 이메일 수정
		frameCenter.btn_updateBirth.addActionListener(this); // 생일 수정
		// ================== 이메일 update (수정부분) =============================
		frameUpdateName.btn_cencle.addActionListener(this); // 이름수정 취소
		frameUpdateName.btn_update.addActionListener(this); // 이름수정 업데이트
		// ================== 이메일 update (수정부분) =============================
		frameUpdateIdname.btn_cencle.addActionListener(this); // 아이디수정 취소
		frameUpdateIdname.btn_check.addActionListener(this); // 아이디수정 재설정
		frameUpdateIdname.btn_change.addActionListener(this); // 아이디 변경하기
		// ================== 비밀번호 update (수정부분) =============================
		frameUpdatePassword.btn_cencle.addActionListener(this); // 비번수정 취소
		frameUpdatePassword.btn_check.addActionListener(this); // 비번수정 확인
		frameUpdatePassword.btn_update.addActionListener(this); // 비번수정
		// ================== 이메일 update (수정부분) =============================
		frameUpdateEmail.btn_cencle.addActionListener(this); // 이메일 수정 취소
		frameUpdateEmail.btn_Send.addActionListener(this); // 이메일 보내기
		frameUpdateEmail.btn_Auth.addActionListener(this); // 이메일 인증
		frameUpdateEmail.btn_Confilrm.addActionListener(this); // 이메일 수정
		// ================== 생일 update (수정부분) =============================
		frameUpdateBirth.btn_cancle.addActionListener(this); // 생일 취소
		frameUpdateBirth.btn_Update.addActionListener(this); // 생일 수정
		// ================== 비밀번호 재확인 (수정부분) =============================
		frameUserPasswordCheck.btn_cencle.addActionListener(this); // 아이디수정
		frameUserPasswordCheck.btn_compleate.addActionListener(this); // 아이디수정
		// ================== 방만들기 부분 =============================
		frameMakeRoom.roomMake_btn_Cancle.addActionListener(this); // 방만들기 취소
		frameMakeRoom.roomMake_btn_RoomMaker.addActionListener(this); // 방만들기 확인
		// ================== 대화방 부분 =============================
		frameChattingRoom.chatting_btn_MessageSend.addActionListener(this); // 대화방 메시지보내기
		frameChattingRoom.chatting_btn_ExitButton.addActionListener(this); // 대화방 나가기
		frameChattingRoom.chatting_btn_FileTab.addActionListener(this); // 대화방 파일탭
		frameChattingRoom.chatting_btn_Dismantling.addActionListener(this); // 대화방 모임해체
		frameChattingRoom.list.addListSelectionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ================== 시작 프레임 부분 ======================
		// ==> 로그인 으로가는 버튼 기능 구현 <==
		if (e.getSource().equals(start_btn_loginBtn)) {
			frameStart.frameDown();
			frameLogin.start();
		} // ==> 회원가입 으로가는 버튼 기능 구현 <==
		else if (e.getSource().equals(start_btn_SingUp)) {

			frameStart.frameDown();
			frameSignup.start();
			frameSignup.comboBox_Year.setSelectedIndex(19);
			frameSignup.comboBox_Moonth.setSelectedIndex(0);
			frameSignup.comboBox_Day.setSelectedIndex(5);

		} // ==> Exit버튼 기능 구현 <==
		else if (e.getSource().equals(btnExit)) {
			System.exit(0);
		}
		// =================== 회원가입 프레임 부분 ====================
		// ==> 아이드 중복체크 기능구현 <==
		else if (e.getSource().equals(signup_btn_IDCheck)) {
			/*
			 * 데이터의 유효성검사
			 */
			if (frameSignup.textField_ID.getText().length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "아이디를 입력하세요");
			} else if (frameSignup.textField_ID.getText().length() < 8) {
				JOptionPane.showMessageDialog(btn_Confirm, "아이디는 8글자 이상으로 입력해주세요");
			} else {
				pw.println(Protocol.IDSEARCHCHECK + "|" + frameSignup.textField_ID.getText());
				pw.flush();
			}
		}
		// ==> 인증번호 보내기 기능 구현 <==
		else if (e.getSource().equals(signup_btn_EmailSend)) {
			if (frameSignup.textField_Email.getText().length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "이메일을 입력해주세요");
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 전송되었습니다.");
				String emailStr = frameSignup.textField_Email.getText() + '@'
						+ (String) frameSignup.comboBox_Email.getSelectedItem();
				scretNumber = String.valueOf(SendMail_update.SendMail(emailStr));
				System.out.println(scretNumber);
			}
		}
		// ==> 인증확인 기능 구현 <==
		else if (e.getSource().equals(signup_btn_Auth)) {
			if (frameSignup.textField_auth.getText().equals(scretNumber)) {
				JOptionPane.showMessageDialog(btn_Confirm, "인증되었습니다.");
				condition_Email = true;
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 틀렸습니다.");
			}
		}
		// ==> 취소버튼 구현 <==
		else if (e.getSource().equals(signup_btn_Cancle)) {
			frameSignup.textField_Name.setText("");
			frameSignup.textField_ID.setText("");
			frameSignup.passwordField_PW.setText("");
			frameSignup.comboBox_Year.setSelectedIndex(19);
			frameSignup.comboBox_Moonth.setSelectedIndex(0);
			frameSignup.comboBox_Day.setSelectedIndex(5);
			frameSignup.textField_Email.setText("");
			frameSignup.comboBox_Email.setSelectedIndex(0);
			frameSignup.textField_auth.setText("");

			frameSignup.frameDown();
			frameStart.start();
			/*
			 * 혹시라도 Email과 ID중복을 확인했을수 있기때문에 초기화 해줌
			 */
			condition_Email = false;
			condition_ID = false;
			scretNumber = SCRET;
		}
		// ==> 확인버튼 구현 <==
		else if (e.getSource().equals(signup_btn_Check)) {
			String name = frameSignup.textField_Name.getText();
			String id = frameSignup.textField_ID.getText();
			String password = frameSignup.passwordField_PW.getText();
			String ageYear = (String) frameSignup.comboBox_Year.getSelectedItem();
			String ageMonnth = (String) frameSignup.comboBox_Moonth.getSelectedItem();
			String ageDay = (String) frameSignup.comboBox_Day.getSelectedItem();
			String email1 = frameSignup.textField_Email.getText();
			String email2 = (String) frameSignup.comboBox_Email.getSelectedItem();
			String emailCheck = frameSignup.textField_auth.getText();

			if (name.length() == 0 || id.length() == 0 || password.length() == 0 || email1.length() == 0
					|| emailCheck.length() == 0 || emailCheck.length() == 0) { //
				JOptionPane.showMessageDialog(btn_Confirm, "빈칸을 입력해 주세요");
			} else if (condition_Email && condition_ID) {
				String line = "";
				line += (id + "%" + password + "%" + name + "%" + ageYear + ageMonnth + ageDay + "%" + email1 + "@"
						+ email2);
				pw.println(Protocol.REGISTER + "|" + line);
				pw.flush();

				JOptionPane.showMessageDialog(btn_Confirm, "회원가입 완료!");
				/*
				 * 회원 가입 이후 버튼의 텍스트필드 초기화
				 */
				frameSignup.textField_Name.setText("");
				frameSignup.textField_ID.setText("");
				frameSignup.passwordField_PW.setText("");
				frameSignup.comboBox_Year.setSelectedIndex(0);
				frameSignup.comboBox_Moonth.setSelectedIndex(0);
				frameSignup.comboBox_Day.setSelectedIndex(0);
				frameSignup.textField_Email.setText("");
				frameSignup.comboBox_Email.setSelectedIndex(0);
				frameSignup.textField_auth.setText("");

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
		// =================== 로그인 프레임 부분 ====================
		// ==> 로그인 버튼 구현 <==
		else if (e.getSource().equals(login_btn_Login)) {
			String ID = frameLogin.textField_ID.getText();
			String PW = frameLogin.passwordField_PW.getText();

			if (ID.length() == 0 || PW.length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "빈칸을 입력해주세요.");
			} else {
				String line = ID + "%" + PW;
				myIdname = ID;
				pw.println(Protocol.ENTERLOGIN + "|" + line);
				pw.flush();

				frameLogin.textField_ID.setText("");
				frameLogin.passwordField_PW.setText("");
			}
			/*
			 * client부분에서 받아 setVisible
			 */
		}
		// ==> 아이디 찾기 버튼 구현 <==
		else if (e.getSource().equals(login_btn_SearchID)) {
			frameLogin.textField_ID.setText("");
			frameLogin.passwordField_PW.setText("");

			frameSearchID.comboBox_Year.setSelectedIndex(19);
			frameSearchID.comboBox_Moonth.setSelectedIndex(0);
			frameSearchID.comboBox_Day.setSelectedIndex(5);

			frameLogin.frameDown();
			frameSearchID.start();
		}
		// ==> 비밀번호 찾기 버튼 구현 <==
		else if (e.getSource().equals(login_btn_SearchPW)) {
			frameLogin.textField_ID.setText("");
			frameLogin.passwordField_PW.setText("");

			frameLogin.frameDown();
			frameSearchPW.start();
		}
		// ==> 종료 버튼 구현 <==
		else if (e.getSource().equals(login_btn_Exit)) {
			frameLogin.textField_ID.setText("");
			frameLogin.passwordField_PW.setText("");

			System.exit(0);
		}
		// =================== 아이디찾기 프레임 부분 ====================
		// ==> 보내기 버튼 구현 <==
		else if (e.getSource().equals(searchi_btn_Send)) {
			if (frameSearchID.textField_Email.getText().length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "이메일을 입력해주세요");
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 전송되었습니다.");
				String emailStr = frameSearchID.textField_Email.getText() + '@'
						+ (String) frameSearchID.comboBox_Email.getSelectedItem();
				scretNumber = String.valueOf(SendMail_update.SendMail(emailStr));
				System.out.println(scretNumber); // 테스트 이후 지울예정
			}
		}
		// ==> 인증 버튼 구현 <==
		else if (e.getSource().equals(searchi_btn_Auth)) {
			if (!frameSearchID.textField_EmailCheck.getText().equals(scretNumber)) {
				JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 틀렸습니다.");
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, "인증되었습니다.");
				condition_Email = true;
			}
		}
		// ==> 아이디 찾기 취소 버튼 구현 <==
		else if (e.getSource().equals(searchi_btn_Cancle)) {
			frameSearchID.textField_Email.setText("");
			frameSearchID.textField_EmailCheck.setText("");
			frameSearchID.textField_Name.setText("");
			frameSearchID.comboBox_Year.setSelectedIndex(19);
			frameSearchID.comboBox_Moonth.setSelectedIndex(1);
			frameSearchID.comboBox_Day.setSelectedIndex(5);
			frameSearchID.comboBox_Email.setSelectedIndex(0);

			frameSearchID.frameDown();
			frameLogin.setVisible(true);

			condition_Email = false;
			scretNumber = SCRET;
		}
		// ==> 아이디 찾기 나기기 버튼 구현 <==
		else if (e.getSource().equals(searchi_btn_Exit)) {
			System.exit(0);
		}
		// ==> 아이디 확인 버튼 <==
		else if (e.getSource().equals(searchi_btn_Confilrm)) {
			String name = frameSearchID.textField_Name.getText();
			String year = (String) frameSearchID.comboBox_Year.getSelectedItem();
			String moonth = (String) frameSearchID.comboBox_Moonth.getSelectedItem();
			String day = (String) frameSearchID.comboBox_Day.getSelectedItem();
			String email = frameSearchID.textField_Email.getText();
			String email_auth = frameSearchID.textField_EmailCheck.getText();
			if (name.length() == 0 || year.length() == 0 || moonth.length() == 0 || day.length() == 0
					|| email.length() == 0 || email_auth.length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "빈칸을 입력해주세요");
			} else if (!condition_Email) { // 인증번호 체크 안했을때
				JOptionPane.showMessageDialog(btn_Confirm, "이메일 인증을 해주세요.");
			} else if (condition_Email) {
				String line = "";
				line += name + "%" + year + moonth + day + "%" + email + '@'
						+ frameSearchID.comboBox_Email.getSelectedItem();
				System.out.println(line);

				pw.println(Protocol.IDSEARCH + "|" + line);
				pw.flush();

				frameSearchID.textField_Email.setText("");
				frameSearchID.textField_EmailCheck.setText("");
				frameSearchID.textField_Name.setText("");
				frameSearchID.comboBox_Year.setSelectedIndex(19);
				frameSearchID.comboBox_Moonth.setSelectedIndex(1);
				frameSearchID.comboBox_Day.setSelectedIndex(5);
				frameSearchID.comboBox_Email.setSelectedIndex(0);

				condition_Email = false;
				scretNumber = SCRET;
			}
		}
		// =================== 패스워드찾기 프레임 부분 ====================
		// ==> 전송 버튼 기능 구현 <==
		else if (e.getSource().equals(searchp_btn_Send)) {
			// 이메일칸이 비어있을 경우 이밴트 발생
			if (frameSearchPW.textField_Email.getText().length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "이메일을 입력해주세요");
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 전송되었습니다.");
				String emailStr = frameSearchPW.textField_Email.getText() + '@'
						+ (String) frameSearchPW.comboBox_Email.getSelectedItem();
				scretNumber = String.valueOf(SendMail_update.SendMail(emailStr));
				System.out.println(scretNumber);
			}
		}
		// ==>확인버튼 기능 구현 <==
		else if (e.getSource().equals(searchp_btn_Confirm)) {
			if (condition_PW == false) {
				JOptionPane.showMessageDialog(btn_Confirm, "비밀번호를 변경해주세요");
			} else if (!condition_Email) {
				JOptionPane.showMessageDialog(btn_Confirm, "이메일 인증을 해주세요");
			}
		}
		// ==> 이메일 인증 기능 구현 <==
		else if (e.getSource().equals(searchp_btn_Auth)) {
			if (frameSearchPW.textField_auth.getText().equals(scretNumber)) {
				JOptionPane.showMessageDialog(btn_Confirm, "인증되었습니다.");
				condition_Email = true;
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 틀렸습니다.");
			}
		}
		// ==> 취소버튼 기능 구현 <==
		else if (e.getSource().equals(searchp_btn_pwCancle)) {
			frameSearchPW.textField_Name.setText("");
			frameSearchPW.textField_ID.setText("");
			frameSearchPW.textField_Email.setText("");
			frameSearchPW.textField_auth.setText("");
			frameSearchPW.comboBox_Email.setSelectedIndex(0);

			frameSearchPW.frameDown();
			frameLogin.start();

			scretNumber = SCRET;
			condition_Email = false;
		}
		// ==> 재설정버튼 기능 구현 <==
		else if (e.getSource().equals(searchp_btn_Reset)) {
			/*
			 * 재설정 버튼은 위에 모든 조건에 충족할시 비밀번호를 초기화 or 교체 할수 있는 기능 구현
			 */
			String name = frameSearchPW.textField_Name.getText();
			String id = frameSearchPW.textField_ID.getText();
			pLine = name + "%" + id;
			if (name.length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "이름을 입력해주세요.");
			} else if (id.length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "아이디를 입력해주세요.");
			} else if (id.length() > 8) {
				JOptionPane.showMessageDialog(btn_Confirm, "올바른 아이디를 입력해주세요.");
			} else if (condition_Email == false) {
				JOptionPane.showMessageDialog(btn_Confirm, "이메일을 인증해주세요.");
			} else {
				frameSearchPW.textField_Name.setText("");
				frameSearchPW.textField_ID.setText("");
				frameSearchPW.textField_Email.setText("");
				frameSearchPW.comboBox_Email.setSelectedIndex(0);
				frameSearchPW.textField_auth.setText("");
				framePassWordCheck.start();
			}
		}
		// ==> 종료 버튼 기능 구현 <==
		else if (e.getSource().equals(searchp_btn_pwExit)) {
			System.exit(0);
		}
		// =================== 리셋 프레임 부분 ====================
		// ==> 비밀번호 확인 기능 구현 <==
		else if (e.getSource().equals(reset_btn_pwCheck)) {
			String pw1 = framePassWordCheck.passwordField_pw1.getText();
			String pw2 = framePassWordCheck.passwordField_pw2.getText();
			if (!pw1.equals(pw2)) {
				JOptionPane.showMessageDialog(btn_Confirm, "두 패스워드가 일치하지 않습니다.");
			} else if (pw1.length() < 8) {
				JOptionPane.showMessageDialog(btn_Confirm, "패스워드는 8자리 이상이여야합니다.");
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, " 사용가능 !");
				framePassWordCheck.newPassworld2 = pw1;
				condition_PW = true;
			}
		}
		// ==> 취소 버튼 <==
		else if (e.getSource().equals(reset_btn_Cancle)) {
			framePassWordCheck.passwordField_pw1.setText("");
			framePassWordCheck.passwordField_pw2.setText("");

			pLine = "";
			condition_PW = false;
			condition_Email = false;
			newPassword = "";
			scretNumber = SCRET;

			framePassWordCheck.frameDown();
		}
		// ==> 재설정 버튼 <==
		else if (e.getSource().equals(reset_btn_Reset)) {
			if (condition_PW == false) {
				JOptionPane.showMessageDialog(btn_Confirm, "비밀번호 확인을 해주세요");
			} else {
				newPassword = framePassWordCheck.newPassworld2;
				String line = "";
				line += (pLine + "%" + newPassword);
				/*
				 * 서버 부분 구현 이름과 아이디가 일치하며 (현재 있는 아이디일경우) 비밀번호를 set 해주고. 그렇지 않을경우 옵션팬으로 안된다고
				 * 알려준다.
				 */
				pw.println(Protocol.PWSEARCH + "|" + line);
				pw.flush();
				System.out.println(line);

				framePassWordCheck.passwordField_pw1.setText("");
				framePassWordCheck.passwordField_pw2.setText("");

				condition_PW = false;
				condition_Email = false;
				newPassword = "";
				scretNumber = SCRET;

				JOptionPane.showMessageDialog(btn_Confirm, "비밀번호를 재설정했습니다.");
				framePassWordCheck.frameDown();
				frameSearchPW.frameDown();
				frameLogin.start();
			}
		}
		// ==================== 센터 프레임 부분 ====================
		// ==> 방(이름으로) 검색 버튼 <==**********미구현
		else if (e.getSource().equals(frameCenter.Center_button_SearchRoom)) {

		}
		// ==> 회원탈퇴 버튼 <== *************미구현
		else if (e.getSource().equals(frameCenter.Center_btn_update)) {

		}
		// ==> 로그아웃 버튼 <==
		else if (e.getSource().equals(frameCenter.Center_btn_Logout)) {

			frameCenter.frameDown();
			frameLogin.start();

			pw.println(Protocol.EXITWAITROOM + "|" + "message");
			pw.flush();

		}
		// ==> 대기실 채팅 기능 <==
		else if (e.getSource().equals(frameCenter.Center_btn_Send)) {
			String line = frameCenter.Center_textField_Message.getText();
			if (frameCenter.Center_textField_Message.getText().length() != 0) {
				pw.println(Protocol.SENDMESSAGE + "|" + line);
				pw.flush();
				frameCenter.Center_textField_Message.setText("");
			}
		}
		// ==> 방 필터 기능 <==
		else if (e.getSource().equals(frameCenter.Center_comboBox_List)) {
			subject = (String) frameCenter.Center_comboBox_List.getSelectedItem();
			pw.println(Protocol.ROOMSORT + "|" + subject);
			pw.flush();
		}
		// ==> 방 만들기 기능 <==
		else if (e.getSource().equals(frameCenter.Center_button_MakeRoom)) {
			frameMakeRoom.start();
			frameCenter.frameDown();
		}
		// ================== 수정 부분(in Center) ==================
		// ==> 이름 수정 <==
		else if (e.getSource().equals(frameCenter.btn_updateName)) {
			update = "이름";
			frameCenter.frameDown();
			frameUserPasswordCheck.start();
		}
		// ==> 아이디 수정 <==
		else if (e.getSource().equals(frameCenter.btn_updateID)) {
			update = "아이디";
			frameCenter.frameDown();
			frameUserPasswordCheck.start();
		}
		// ==> 비밀번호 수정 <==
		else if (e.getSource().equals(frameCenter.btn_updatePW)) {
			update = "비밀번호";
			frameCenter.frameDown();
			frameUserPasswordCheck.start();
		}
		// ==> 이메일 수정 <==
		else if (e.getSource().equals(frameCenter.btn_updateEmail)) {
			update = "이메일";
			frameCenter.frameDown();
			frameUserPasswordCheck.start();
		}
		// ==> 생년월일 수정 <==
		else if (e.getSource().equals(frameCenter.btn_updateBirth)) {
			
			update = "생년월일";
			frameCenter.frameDown();
			frameUserPasswordCheck.start();
			
			frameUpdateBirth.comboBox_Year.setSelectedItem(19);
			frameUpdateBirth.comboBox_Moonth.setSelectedItem(0);
			frameUpdateBirth.comboBox_Day.setSelectedItem(5);

		}
		// ==> 비밀번호 확인 확인 구현 <==
		else if (e.getSource().equals(frameUserPasswordCheck.btn_compleate)) {
			String password = frameUserPasswordCheck.passwordField.getText();
			pw.println(Protocol.ENTERLOGIN_USERINFOMATION_CHECK + "|" + password + "%" + update);
			pw.flush();

			frameUserPasswordCheck.passwordField.setText("");

		} // ==> 비밀번호 확인 취소 구현 <==
		else if (e.getSource().equals(frameUserPasswordCheck.btn_cencle)) {
			frameUserPasswordCheck.frameDown();
			frameCenter.start();

			frameUserPasswordCheck.passwordField.setText("");

		}
		// =============== 이름 업데이트 ==============
		// ==> 이름 수정 취소 구현 <==
		else if (e.getSource().equals(frameUpdateName.btn_cencle)) {
			frameUpdateName.textField_Name.setText("");

			frameUpdateName.frameDown();
			frameCenter.start();
		}
		// ==> 이름 수정 확인 구현 <== 
		else if (e.getSource().equals(frameUpdateName.btn_update)) {
			pw.println(Protocol.UPDATE_NAME + "|" + frameUpdateName.textField_Name.getText());
			pw.flush();
			
			frameCenter.lbl_userName.setText(frameUpdateName.textField_Name.getText());
			frameUpdateName.textField_Name.setText("");
			
			frameUpdateName.frameDown();
			frameCenter.start();
		}
		// =============== 아이디 업데이트 ==============
		// ==> 아이디 변경 취소 구현 <==
		else if (e.getSource().equals(frameUpdateIdname.btn_cencle)) {
			frameUpdateIdname.frameDown();
			frameCenter.start();

			frameUpdateIdname.textField_id.setText("");
			R.condition_ID = false;
		}
		// ==> 아이디 변경 중복확인 구현 <==
		else if (e.getSource().equals(frameUpdateIdname.btn_check)) {
			if (frameUpdateIdname.textField_id.getText().length() == 0) {
				JOptionPane.showMessageDialog(R.btn_Confirm, "변경하실 아이디를 입력해주세요.");
			} else if (frameUpdateIdname.textField_id.getText().length() < 6) {
				JOptionPane.showMessageDialog(R.btn_Confirm, "변경하실 아이디를 6글자이상 입력해주세요.");
			} else {
				pw.println(Protocol.IDSEARCHCHECK + "|" + frameUpdateIdname.textField_id.getText());
				pw.flush();
			}

		}
		// ==> 아이디 변경 구현 <== 
		else if (e.getSource().equals(frameUpdateIdname.btn_change)) {
			if (frameUpdateIdname.textField_id.getText().length() == 0) {
				JOptionPane.showMessageDialog(R.btn_Confirm, "아이디를 입력해주세요.");
			} else if (R.condition_ID == false) {
				JOptionPane.showMessageDialog(R.btn_Confirm, "아이디를 중복확인을 해주세요.");
			} else {
				pw.println(Protocol.UPDATE_IDNAME + "|" + frameUpdateIdname.textField_id.getText());
				pw.flush();
				
				frameCenter.lbl_userId.setText(frameUpdateIdname.textField_id.getText());
				
				frameUpdateIdname.textField_id.setText("");
				R.condition_ID = false;
				
				frameUpdateIdname.frameDown();
				frameCenter.start();
			}
		}
		// =============== 패스워드 업데이트 ==============
		// ==> 패스워드 취소 구현 <==
		else if (e.getSource().equals(frameUpdatePassword.btn_cencle)) {
			frameUpdatePassword.passwordField.setText("");
			frameUpdatePassword.passwordField_cehck.setText("");
			R.condition_PW = false;
			frameUpdatePassword.frameDown();
			frameCenter.start();
		}
		// ==> 패스워드 확인 구현 <==
		else if (e.getSource().equals(frameUpdatePassword.btn_check)) {
			String pw1 = frameUpdatePassword.passwordField.getText();
			String pw2 = frameUpdatePassword.passwordField_cehck.getText();
			if (!pw1.equals(pw2)) {
				JOptionPane.showMessageDialog(btn_Confirm, "두 패스워드가 일치하지 않습니다.");
			} else if (pw1.length() < 8) {
				JOptionPane.showMessageDialog(btn_Confirm, "패스워드는 8자리 이상이여야합니다.");
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, " 사용가능 !");
				framePassWordCheck.newPassworld2 = pw1;
				condition_PW = true;
			}
		}
		// ==> 패스워드 업데이트 구현 <==
		else if (e.getSource().equals(frameUpdatePassword.btn_update)) {
			if (condition_PW == false) {
				JOptionPane.showMessageDialog(R.btn_Confirm, "비밀번호 확인을 해주세요.");
			} else {
				pw.println(Protocol.UPDATE_PASSWORD + "|" + framePassWordCheck.newPassworld2);
				pw.flush();
				
				frameCenter.lbl_userpw.setText(framePassWordCheck.newPassworld2);
				
				frameUpdatePassword.passwordField.setText("");
				frameUpdatePassword.passwordField_cehck.setText("");

				framePassWordCheck.newPassworld2 = "";
				condition_PW = false;

				frameUpdatePassword.frameDown();
				frameCenter.start();
			}
		}
		// =============== 이메일 업데이트 ==============
		// ==> 이메일 취소 구현 <==
		else if (e.getSource().equals(frameUpdateEmail.btn_cencle)) {
			frameUpdateEmail.comboBox.setSelectedItem(0);
			frameUpdateEmail.textField_email.setText("");
			frameUpdateEmail.textField_Auth.setText("");

			R.condition_Email = false;
			R.scretNumber = R.SCRET;

			frameUpdateEmail.frameDown();
			frameCenter.start();
		}
		// ==> 이메일 보내기 구현 <==
		else if (e.getSource().equals(frameUpdateEmail.btn_Send)) {
			if (frameUpdateEmail.textField_email.getText().length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "이메일을 입력해주세요");
			} else {
				JOptionPane.showMessageDialog(btn_Confirm, "인증번호가 전송되었습니다.");
				String emailStr = frameUpdateEmail.textField_email.getText() + '@'
						+ (String) frameUpdateEmail.comboBox.getSelectedItem();
				scretNumber = String.valueOf(SendMail_update.SendMail(emailStr));
				System.out.println(scretNumber);
			}
		}
		// ==> 이메일 인증 구현 <==
		else if (e.getSource().equals(frameUpdateEmail.btn_Auth)) {
			if (frameUpdateEmail.textField_Auth.getText().equals(scretNumber)) {
				JOptionPane.showMessageDialog(R.btn_Confirm, "이메일 인증이 완료되었습니다.");
				R.condition_Email = true;
			} else {
				JOptionPane.showMessageDialog(R.btn_Confirm, "인증번호가 올바르지 않습니다.");
			}
		}
		// ==> 이메일 수정 구현 <==
		else if (e.getSource().equals(frameUpdateEmail.btn_Confilrm)) {
			if (R.condition_Email == true) {
				String emailStr = frameUpdateEmail.textField_email.getText() + '@'
						+ (String) frameUpdateEmail.comboBox.getSelectedItem();
				
				pw.println(Protocol.UPDATE_MAIL + "|" + emailStr);
				pw.flush();
				
				frameCenter.lbl_userEmail.setText(emailStr);
				
				frameUpdateEmail.comboBox.setSelectedItem(0);
				frameUpdateEmail.textField_email.setText("");
				frameUpdateEmail.textField_Auth.setText("");

				R.condition_Email = false;
				R.scretNumber = R.SCRET;

				frameUpdateEmail.frameDown();
				frameCenter.start();
			}
		}
		// =============== 생일 업데이트 ==============
		// ==> 생일 취소 구현 <==
		else if (e.getSource().equals(frameUpdateBirth.btn_cancle)) {
			frameUpdateBirth.comboBox_Year.setSelectedItem(19);
			frameUpdateBirth.comboBox_Moonth.setSelectedItem(0);
			frameUpdateBirth.comboBox_Day.setSelectedItem(5);

			frameUpdateBirth.frameDown();
			frameCenter.start();
		}
		// ==> 생일 수정 구현 <==
		else if (e.getSource().equals(frameUpdateBirth.btn_Update)) {
			String year = (String) frameUpdateBirth.comboBox_Year.getSelectedItem();
			String moonth = (String) frameUpdateBirth.comboBox_Moonth.getSelectedItem();
			String day = (String) frameUpdateBirth.comboBox_Day.getSelectedItem();
			String line = year + moonth + day;
			System.out.println(line);
			pw.println(Protocol.UPDATE_BIRTH + "|" + line);
			pw.flush();
			
			frameCenter.lbl_userBirth.setText(line);
			
			frameUpdateBirth.comboBox_Year.setSelectedItem(19);
			frameUpdateBirth.comboBox_Moonth.setSelectedItem(0);
			frameUpdateBirth.comboBox_Day.setSelectedItem(5);
			
			frameUserPasswordCheck.frameDown();
			frameCenter.start();

		}

		// ================== 방 만들기 부분 ==================
		// ==> 방만들기 취소 <==
		else if (e.getSource().equals(frameMakeRoom.roomMake_btn_Cancle)) {
			frameCenter.start();
			frameMakeRoom.frameDown();
		}
		// ==> 방만들기 확인 <==
		else if (e.getSource().equals(frameMakeRoom.roomMake_btn_RoomMaker)) {
			String title = frameMakeRoom.roomMake_textField_RoomName.getText();
			int sipnerCount = (int) frameMakeRoom.roomMake_spinner_userMax.getValue();
			String userCount = String.valueOf(sipnerCount);
			String subject = (String) frameMakeRoom.roomMake_comboBox_RoomTopic.getSelectedItem();
			if (title.length() == 0) {
				JOptionPane.showMessageDialog(btn_Confirm, "제목을 입력해주세요");
			} else {

				String line = "";
				line = title + "%" + userCount + "%" + subject;
				pw.println(Protocol.ROOMMAKE + "|" + line);
				pw.flush();

				frameChattingRoom.start();
				frameMakeRoom.frameDown();

				frameMakeRoom.roomMake_textField_RoomName.setText("");
				frameMakeRoom.roomMake_spinner_userMax.setValue(4);
				frameMakeRoom.roomMake_comboBox_RoomTopic.setSelectedItem(0);
			}
		}
		// ================== 채팅방 부분 ==================
		// ==> 파일탭 <== *********세부 프레임 미구현
		else if (e.getSource().equals(frameChattingRoom.chatting_btn_FileTab)) {
			frameChattingRoom.openDialog();
			pw.println(Protocol.CHATTINGFILESEND_SYN + "|" + frameChattingRoom.file.getName());
			pw.flush();
		}
		// ==> 방나가기 <==
		else if (e.getSource().equals(frameChattingRoom.chatting_btn_ExitButton)) {

			pw.println(Protocol.EXITCHATTINGROOM + "|" + "Message");
			pw.flush();

			frameCenter.start();
			frameChattingRoom.frameDown();

		}
		// ==> 채팅방 메세지 보내기 <==
		else if (e.getSource().equals(frameChattingRoom.chatting_btn_MessageSend)) {
			String message = frameChattingRoom.chatting_textField_message.getText();
	
			frameChattingRoom.chatting_chattingPanel.setLayout(new BorderLayout());
			frameChattingRoom.vertical.add(Box.createVerticalStrut(5));
			frameChattingRoom.chatting_chattingPanel.add(frameChattingRoom.vertical, BorderLayout.PAGE_START);
			frameChattingRoom.chatting_chattingPanel.repaint();
			pw.println(Protocol.CHATTINGSENDMESSAGE + "|" + message + "%" + myIdname); // 메세지를																									// 보냄
			pw.flush();
			frameChattingRoom.chatting_textField_message.setText("");
			pw.println(Protocol.CHATTINGSCROLLBARDOWN + "|" + "message");
			pw.flush();

		}
		// ==> 방해체 <==
		else if (e.getSource().equals(frameChattingRoom.chatting_btn_Dismantling)) {
			pw.println(Protocol.DISMANTINGROOM + "|" + "message");
			pw.flush();

		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		System.out.println("Listlistioner");
		for (int i = 0; i < frameChattingRoom.model.getSize(); i++) {
			if (frameChattingRoom.list.isSelectedIndex(i)) {
				frameChattingRoom.fileSave();
				pw.println(Protocol.CHATTINGFILEDOWNLOAD_SYN + "|" + frameChattingRoom.list.getSelectedValue());
				pw.flush();
			}
		}
	}

	// ==> 마우스가 눌릴경우 <==
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		frameLogin.textField_ID.setText("");
		frameLogin.passwordField_PW.setText("");

		frameLogin.frameDown();
		frameStart.setVisible(true);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// ==> 마우스가 라벨 안에서 들어갔을때 <==
	@Override
	public void mouseEntered(MouseEvent e) {
		StudyWithMe.setIcon(image2);

	}

	// ==> 마우스가 라벨 안에서 나왓을때 <==
	@Override
	public void mouseExited(MouseEvent e) {
		StudyWithMe.setIcon(image);

	}

}
