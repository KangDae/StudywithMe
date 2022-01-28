package TitleTest;



import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Resource.R;

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
import java.awt.event.ActionEvent;
/*
 * 		방목록등 전반적인 모든부분을
 * 		보여주는 프레임입니다.
 */
public class FrameCenter extends JFrame implements R{
	public FrameCenter() {
//		initialize();
//		this.setUndecorated(true);
	}

	private JFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public void start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setVisible(true);
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane_FriendsPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_FriendsPanel.setBounds(0, 0, 384, 561);
		this.getContentPane().add(tabbedPane_FriendsPanel);
		
		JTabbedPane tabbedPane_Freinds = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Freinds.setToolTipText("친구목록");
		tabbedPane_Freinds.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 191, 255)));
		tabbedPane_Freinds.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tabbedPane_FriendsPanel.addTab("친구", null, tabbedPane_Freinds, null);
		
		JPanel panel_Myinfomation = new JPanel();
		panel_Myinfomation.setForeground(new Color(255, 255, 255));
		panel_Myinfomation.setBackground(new Color(135, 206, 250));
		tabbedPane_Freinds.addTab("내 정보", null, panel_Myinfomation, null);
		tabbedPane_Freinds.setBackgroundAt(0, new Color(128, 128, 128));
		
		JPanel panel_MyFriends = new JPanel();
		panel_MyFriends.setBackground(new Color(135, 206, 250));
		tabbedPane_Freinds.addTab("New tab", null, panel_MyFriends, null);
		tabbedPane_FriendsPanel.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane_FriendsPanel.setBackgroundAt(0, Color.CYAN);
		
		JTabbedPane tabbedPane_Option = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_FriendsPanel.addTab("방 참가", null, tabbedPane_Option, null);
		
		JPanel panel_Waitting = new JPanel();
		panel_Waitting.setBackground(new Color(135, 206, 250));
		tabbedPane_Option.addTab("대기자 채팅방", null, panel_Waitting, null);
		panel_Waitting.setLayout(null);
		
		JButton btnNewButton = new JButton("전송");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton.setBounds(289, 464, 73, 29);
		panel_Waitting.add(btnNewButton);
		
		JScrollPane scrollPane_ChattBord = new JScrollPane();
		scrollPane_ChattBord.setBounds(12, 10, 350, 444);
		panel_Waitting.add(scrollPane_ChattBord);
		
		JTextArea textArea_Chatting = new JTextArea();
		textArea_Chatting.setText("안녕하세여");
		textArea_Chatting.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		scrollPane_ChattBord.setViewportView(textArea_Chatting);
		
		textField = new JTextField();
		textField.setFont(new Font("Gulim", Font.PLAIN, 12));
		textField.setBounds(12, 464, 265, 28);
		panel_Waitting.add(textField);
		textField.setColumns(10);

		
		JPanel panel_RoomJoin = new JPanel();
		panel_RoomJoin.setBackground(new Color(135, 206, 250));
		tabbedPane_Option.addTab("방 참가하기", null, panel_RoomJoin, null);
		panel_RoomJoin.setLayout(null);
		
		JScrollPane scrollPane_ChattBord_1 = new JScrollPane();
		scrollPane_ChattBord_1.setBounds(12, 49, 350, 444);
		panel_RoomJoin.add(scrollPane_ChattBord_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_ChattBord_1.setViewportView(textArea);
		
		JButton button_SearchRoom = new JButton("방 검색");
		button_SearchRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_SearchRoom.setBackground(new Color(255, 255, 255));
		button_SearchRoom.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button_SearchRoom.setBounds(15, 10, 88, 29);
		panel_RoomJoin.add(button_SearchRoom);
		
		JButton button_MakeRoom = new JButton("방 생성");
		button_MakeRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMakeRoom.start();
				frameDown();
			}
		});
		button_MakeRoom.setBackground(new Color(255, 255, 255));
		button_MakeRoom.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button_MakeRoom.setBounds(115, 10, 88, 29);
		panel_RoomJoin.add(button_MakeRoom);
		
		JComboBox comboBox_List = new JComboBox();
		comboBox_List.setBackground(new Color(255, 255, 255));
		comboBox_List.setBounds(274, 10, 88, 29);
		panel_RoomJoin.add(comboBox_List);
		
		JLabel Label_Filter = new JLabel("필터 : ");
		Label_Filter.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Label_Filter.setBounds(229, 14, 57, 25);
		panel_RoomJoin.add(Label_Filter);
		tabbedPane_FriendsPanel.setBackgroundAt(1, new Color(0, 206, 209));
		
		JTabbedPane tabbedPane_Cahtting = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_FriendsPanel.addTab("스터디윗미!", null, tabbedPane_Cahtting, null);
		
		JPanel panel_Developer = new JPanel();
		panel_Developer.setBackground(new Color(135, 206, 250));
		tabbedPane_Cahtting.addTab("Developer", null, panel_Developer, null);
		panel_Developer.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(R.image);
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
	private void frameDown() {
		this.setVisible(false);
	}
}
