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

import DTO.Protocol;
import Resource.R;
import Server.Client;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
/*
 * 		방만들기 이후 입장해서 보이게되는 화면의
 * 		프레임입니다.
 */
public class FrameChattingRoom extends R{

	private JTextField textField;
	PrintWriter pw;
	BufferedReader br;

	public FrameChattingRoom(){
		initialize();
//		this.setUndecorated(true);
	}
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
		pw = Client.pw;
		br = Client.br;
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane_Chatting = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Chatting.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		this.getContentPane().add(tabbedPane_Chatting, BorderLayout.CENTER);
		
		JPanel panel_Chatting = new JPanel();
		panel_Chatting.setBackground(new Color(135, 206, 250));
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
		btn_MessageSend.setBackground(new Color(255, 255, 255));
		btn_MessageSend.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_MessageSend.setBounds(291, 437, 76, 30);
		panel_Chatting.add(btn_MessageSend);
		
		JButton btn_ExitButton = new JButton("나가기");
		btn_ExitButton.setBackground(new Color(255, 255, 255));
		btn_ExitButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_ExitButton.setBounds(255, 477, 112, 39);
		panel_Chatting.add(btn_ExitButton);
		
		JButton btn_FileTab = new JButton("파일");
		btn_FileTab.setBackground(new Color(255, 255, 255));
		btn_FileTab.setBounds(12, 477, 97, 39);
		panel_Chatting.add(btn_FileTab);
		
		JPanel panel_ParticipantList = new JPanel();
		panel_ParticipantList.setBackground(new Color(135, 206, 250));
		tabbedPane_Chatting.addTab("참가자", null, panel_ParticipantList, null);
		panel_ParticipantList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 42, 326, 447);
		panel_ParticipantList.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		
		// ==> 파일 버튼 <==
		btn_FileTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		// ==> 나가기 버튼 <==
		btn_ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCenter.start();
				frameDown();
			}
		});
		// ==> 전송 버튼 <==
		btn_MessageSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String line = textField.getText();
				pw.println(Protocol.SENDMESSAGE + "|" + line);
				pw.flush();
				textField.setText("");
			}
		});
	}
	private void frameDown() {
		this.setVisible(false);
	}
}
