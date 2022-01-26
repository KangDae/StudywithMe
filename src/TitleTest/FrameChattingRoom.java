package TitleTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
/*
 * 		방만들기 이후 입장해서 보이게되는 화면의
 * 		프레임입니다.
 */
public class FrameChattingRoom {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChattingRoom window = new FrameChattingRoom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//defwfswfsfsfs
		});
	}

	/**
	 * Create the application.
	 */
	public FrameChattingRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane_Chatting = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Chatting.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		frame.getContentPane().add(tabbedPane_Chatting, BorderLayout.CENTER);
		
		JPanel panel_Chatting = new JPanel();
		panel_Chatting.setBackground(Color.LIGHT_GRAY);
		panel_Chatting.setForeground(Color.LIGHT_GRAY);
		tabbedPane_Chatting.addTab("채팅", null, panel_Chatting, null);
		panel_Chatting.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setBounds(12, 10, 355, 417);
		panel_Chatting.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(12, 437, 260, 30);
		panel_Chatting.add(textField);
		textField.setColumns(10);
		
		JButton btn_MessageSend = new JButton("전송");
		btn_MessageSend.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_MessageSend.setBounds(291, 437, 76, 30);
		panel_Chatting.add(btn_MessageSend);
		
		JButton btn_ExitButton = new JButton("나가기");
		btn_ExitButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_ExitButton.setBounds(255, 477, 112, 39);
		panel_Chatting.add(btn_ExitButton);
		
		JButton btn_FileTab = new JButton("파일");
		btn_FileTab.setBounds(12, 477, 97, 39);
		panel_Chatting.add(btn_FileTab);
		
		JPanel panel_ParticipantList = new JPanel();
		tabbedPane_Chatting.addTab("참가자", null, panel_ParticipantList, null);
		panel_ParticipantList.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea_1.setBounds(12, 10, 355, 437);
		panel_ParticipantList.add(textArea_1);
	}
}
