package Frames;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import DTO.Protocol;
import Resource.R;
import Server.Client_network;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;

/*
 * 		방목록등 전반적인 모든부분을
 * 		보여주는 프레임입니다.
 */
public class FrameCenter extends R {
	public FrameCenter() {
		initialize();
//		this.setUndecorated(true);
	}

	public JTextField Center_textField_Message;
	public JPanel Center_centerPane, panel_in_noticeBoard;
	public JComboBox<String> Center_comboBox_List;
	public JTextArea Center_textArea_Chatting, textArea_Waituser;
	public PanelRoomList[] panelRoomList;
	public JLabel lbl_userName, lbl_userId, lbl_userEmail, lbl_userBirth;
	

	public JButton Center_button_MakeRoom, Center_button_SearchRoom, Center_btn_update, Center_btn_Logout, Center_btn_Send
	, btn_updateName, btn_updateID, btn_updatePW, btn_updateEmail, btn_updateBirth,btn_Write;
	BufferedReader br;
	PrintWriter pw;
	public JPasswordField lbl_userpw;
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
		br = Client_network.br;
		pw = Client_network.pw;
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		panelRoomList = new PanelRoomList[100];

		JTabbedPane tabbedPane_FriendsPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_FriendsPanel.setBackground(new Color(135, 206, 250));
		tabbedPane_FriendsPanel.setBounds(0, 0, 384, 561);
		this.getContentPane().add(tabbedPane_FriendsPanel);

		JTabbedPane tabbedPane_Freinds = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Freinds.setBackground(new Color(135, 206, 250));
		tabbedPane_Freinds.setToolTipText("친구목록");
		tabbedPane_Freinds.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 191, 255)));
		tabbedPane_Freinds.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tabbedPane_FriendsPanel.addTab("친구", null, tabbedPane_Freinds, null);

		JPanel panel_Myinfomation = new JPanel();
		panel_Myinfomation.setForeground(new Color(255, 255, 255));
		panel_Myinfomation.setBackground(new Color(135, 206, 250));
		tabbedPane_Freinds.addTab("내 정보", null, panel_Myinfomation, null);
		panel_Myinfomation.setLayout(null);

		JLabel lbl_Name = new JLabel("이 름 : ");
		lbl_Name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_Name.setBounds(38, 190, 57, 15);
		panel_Myinfomation.add(lbl_Name);

		JLabel lbl_ID = new JLabel("아이디 : ");
		lbl_ID.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_ID.setBounds(26, 234, 58, 15);
		panel_Myinfomation.add(lbl_ID);

		JLabel lbl_pw = new JLabel("패스워드 : ");
		lbl_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_pw.setBounds(12, 278, 83, 15);
		panel_Myinfomation.add(lbl_pw);

		JLabel lbl_email = new JLabel("이메일 : ");
		lbl_email.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_email.setBounds(24, 321, 71, 15);
		panel_Myinfomation.add(lbl_email);

		Center_btn_update = new JButton("회원탈퇴");
		Center_btn_update.setBackground(Color.WHITE);
		Center_btn_update.setForeground(Color.BLACK);
		Center_btn_update.setBounds(262, 451, 98, 34);
		panel_Myinfomation.add(Center_btn_update);

		JLabel lbl_StudyWithMe = new JLabel(image);
		lbl_StudyWithMe.setBounds(38, 26, 294, 153);

	    panel_Myinfomation.add(lbl_StudyWithMe);


		Center_btn_Logout = new JButton("로그아웃");
		Center_btn_Logout.setForeground(Color.BLACK);
		Center_btn_Logout.setBackground(Color.WHITE);
		Center_btn_Logout.setBounds(26, 451, 98, 34);
		panel_Myinfomation.add(Center_btn_Logout);
		
		lbl_userName = new JLabel("");
		lbl_userName.setBounds(96, 193, 116, 15);
		panel_Myinfomation.add(lbl_userName);
		
		lbl_userId = new JLabel("");
		lbl_userId.setBounds(96, 237, 116, 15);
		panel_Myinfomation.add(lbl_userId);
		
		lbl_userEmail = new JLabel("");
		lbl_userEmail.setBounds(96, 324, 116, 15);
		panel_Myinfomation.add(lbl_userEmail);
		
		btn_updateName = new JButton(">>");
		btn_updateName.setBackground(Color.WHITE);
		btn_updateName.setForeground(Color.BLACK);
		btn_updateName.setBounds(224, 189, 57, 23);
		panel_Myinfomation.add(btn_updateName);
		
		btn_updateID = new JButton(">>");
		btn_updateID.setForeground(Color.BLACK);
		btn_updateID.setBackground(Color.WHITE);
		btn_updateID.setBounds(224, 233, 57, 23);
		panel_Myinfomation.add(btn_updateID);
		
		btn_updatePW = new JButton(">>");
		btn_updatePW.setForeground(Color.BLACK);
		btn_updatePW.setBackground(Color.WHITE);
		btn_updatePW.setBounds(224, 277, 57, 23);
		panel_Myinfomation.add(btn_updatePW);
		
		btn_updateEmail = new JButton(">>");
		btn_updateEmail.setForeground(Color.BLACK);
		btn_updateEmail.setBackground(Color.WHITE);
		btn_updateEmail.setBounds(224, 320, 57, 23);
		panel_Myinfomation.add(btn_updateEmail);
		
		JLabel lbl_birth = new JLabel("생 일 : ");
		lbl_birth.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_birth.setBounds(26, 366, 71, 15);
		panel_Myinfomation.add(lbl_birth);
		
		lbl_userBirth = new JLabel("");
		lbl_userBirth.setBounds(98, 369, 116, 15);
		panel_Myinfomation.add(lbl_userBirth);
		
		btn_updateBirth = new JButton(">>");
		btn_updateBirth.setForeground(Color.BLACK);
		btn_updateBirth.setBackground(Color.WHITE);
		btn_updateBirth.setBounds(226, 365, 57, 23);
		panel_Myinfomation.add(btn_updateBirth);
		
		lbl_userpw = new JPasswordField();
		lbl_userpw.setEchoChar('*');
		lbl_userpw.setEditable(false);
		lbl_userpw.setBounds(88, 278, 124, 21);
		panel_Myinfomation.add(lbl_userpw);
		tabbedPane_Freinds.setBackgroundAt(0, new Color(128, 128, 128));

		JPanel panel_MyFriends = new JPanel();
		panel_MyFriends.setBackground(new Color(135, 206, 250));
		tabbedPane_Freinds.addTab("친구", null, panel_MyFriends, null);
		tabbedPane_FriendsPanel.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane_FriendsPanel.setBackgroundAt(0, Color.CYAN);

		JTabbedPane tabbedPane_Option = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Option.setBackground(new Color(135, 206, 250));
		tabbedPane_FriendsPanel.addTab("방 참가", null, tabbedPane_Option, null);

		JPanel panel_RoomJoin = new JPanel();
		panel_RoomJoin.setBackground(new Color(135, 206, 250));
		tabbedPane_Option.addTab("방 참가하기", null, panel_RoomJoin, null);
		panel_RoomJoin.setLayout(null);

		Center_centerPane = new JPanel(new GridLayout(100, 2, 10, 10));

		JScrollPane scrollPane_RoomList = new JScrollPane(Center_centerPane);
		scrollPane_RoomList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_RoomList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_RoomList.getVerticalScrollBar().setValue(scrollPane_RoomList.getVerticalScrollBar().getMaximum());
		scrollPane_RoomList.setBounds(12, 49, 350, 444);
		panel_RoomJoin.add(scrollPane_RoomList);

		Center_button_SearchRoom = new JButton("방 검색");
		Center_button_SearchRoom.setBackground(new Color(255, 255, 255));
		Center_button_SearchRoom.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Center_button_SearchRoom.setBounds(15, 10, 88, 29);
		panel_RoomJoin.add(Center_button_SearchRoom);

		Center_button_MakeRoom = new JButton("방 생성");
		Center_button_MakeRoom.setBackground(new Color(255, 255, 255));
		Center_button_MakeRoom.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Center_button_MakeRoom.setBounds(115, 10, 88, 29);
		panel_RoomJoin.add(Center_button_MakeRoom);
	 
		Center_comboBox_List = new JComboBox<String>(roomTopicFilter);
		Center_comboBox_List.setBackground(new Color(255, 255, 255));
		Center_comboBox_List.setBounds(274, 10, 88, 29);
		panel_RoomJoin.add(Center_comboBox_List);

		JLabel Label_Filter = new JLabel("필터 : ");
		Label_Filter.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Label_Filter.setBounds(229, 14, 57, 25);
		panel_RoomJoin.add(Label_Filter);

		JPanel panel_noticeBoard = new JPanel();
		panel_noticeBoard.setBackground(new Color(135, 206, 250));
		tabbedPane_Option.addTab("자유 게시판", null, panel_noticeBoard, null);
		panel_noticeBoard.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 157, 350, 336);
		panel_noticeBoard.add(scrollPane_1);

		panel_in_noticeBoard = new JPanel();
		scrollPane_1.setViewportView(panel_in_noticeBoard);
		
		btn_Write = new JButton("작성");
		btn_Write.setBounds(12, 124, 97, 23);
		panel_noticeBoard.add(btn_Write);
		
		
		

		JLabel lbl_studywithMe_Board = new JLabel(image);
		lbl_studywithMe_Board.setBounds(25, 21, 326, 116);
		panel_noticeBoard.add(lbl_studywithMe_Board);
		
		
		JPanel panel_Waitting = new JPanel();
		panel_Waitting.setBackground(new Color(135, 206, 250));
		tabbedPane_Option.addTab("대기자 채팅방", null, panel_Waitting, null);
		panel_Waitting.setLayout(null);

		Center_btn_Send = new JButton("전송");
		Center_btn_Send.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Center_btn_Send.setBounds(289, 464, 73, 29);
		panel_Waitting.add(Center_btn_Send);

		JScrollPane scrollPane_ChattBord = new JScrollPane();
		scrollPane_ChattBord.setBounds(12, 10, 350, 444);
		panel_Waitting.add(scrollPane_ChattBord);

		Center_textArea_Chatting = new JTextArea();
		Center_textArea_Chatting.setEditable(false);
		Center_textArea_Chatting.setLineWrap(true);
		Center_textArea_Chatting.setWrapStyleWord(true);
		Center_textArea_Chatting.setText("안녕하세여\n");
		Center_textArea_Chatting.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		scrollPane_ChattBord.setViewportView(Center_textArea_Chatting);

		Center_textField_Message = new JTextField();
		Center_textField_Message.setFont(new Font("Gulim", Font.PLAIN, 12));
		Center_textField_Message.setBounds(12, 464, 265, 28);
		panel_Waitting.add(Center_textField_Message);
		Center_textField_Message.setColumns(10);

		JPanel panel_Waituser = new JPanel();
		tabbedPane_Option.addTab("대기실 인원", null, panel_Waituser, null);
		panel_Waituser.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 5, 350, 488);
		panel_Waituser.add(scrollPane);

		textArea_Waituser = new JTextArea();
		textArea_Waituser.setEditable(false);
		scrollPane.setViewportView(textArea_Waituser);

		for (int i = 0; i < 100; i++) {
			panelRoomList[i] = new PanelRoomList(br, pw);
			Center_centerPane.add(panelRoomList[i]);
		}
		tabbedPane_FriendsPanel.setBackgroundAt(1, new Color(135, 206, 250));

		JTabbedPane tabbedPane_Cahtting = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_FriendsPanel.addTab("스터디윗미!", null, tabbedPane_Cahtting, null);

		JPanel panel_Developer = new JPanel();
		panel_Developer.setBackground(new Color(135, 206, 250));
		tabbedPane_Cahtting.addTab("Developer", null, panel_Developer, null);
		panel_Developer.setLayout(null);

		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 40, 310, 128);
		panel_Developer.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("조장 : 우효진");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 203, 254, 36);
		panel_Developer.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("팀원1 : 강대준");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(53, 249, 254, 36);
		panel_Developer.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("팀원2 : 강유진");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(53, 295, 254, 36);
		panel_Developer.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("팀원3 : 김강규");
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(53, 341, 254, 36);
		panel_Developer.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("팀원4 : 박규영");
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(53, 387, 254, 36);
		panel_Developer.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("팀원5 : 배광민");
		lblNewLabel_1_5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(53, 433, 254, 36);
		panel_Developer.add(lblNewLabel_1_5);
		tabbedPane_FriendsPanel.setBackgroundAt(2, new Color(0, 191, 255));


	}
	public void containPanelClear() {

		Center_centerPane.removeAll();
		for (int i = 0; i < 100; i++) {
			panelRoomList[i] = new PanelRoomList(br, pw);
			Center_centerPane.add(panelRoomList[i]);
		}

	}

	
	public void frameDown() {
		this.setVisible(false);
	}
}
