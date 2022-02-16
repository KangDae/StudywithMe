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
import javax.swing.ListSelectionModel;

import DTO.Protocol;
import Resource.R;
import Server.Client_network;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
/*
 * 		방만들기 이후 입장해서 보이게되는 화면의
 * 		프레임입니다.
 */
public class FrameChattingRoom extends R{
	public File file, folder;
	public JTextField chatting_textField_message;
	PrintWriter pw;
	BufferedReader br;
	public JButton chatting_btn_Dismantling, chatting_btn_MessageSend, chatting_btn_FileTab, chatting_btn_ExitButton;
	public DefaultListModel<String> model;
	public JList<String> list;
	public JTextArea Chatting_textArea_chatting, Chatting_textarea_Inuserlist;
	public JScrollPane scrollpnae;

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
		
		
		Chatting_textArea_chatting = new JTextArea();	
		Chatting_textArea_chatting.setEditable(false);
		Chatting_textArea_chatting.setCaretPosition(Chatting_textArea_chatting.getDocument().getLength());
		//Chatting_textArea_chatting.setBounds(12, 10, 355, 417);
		
		
		
		 
		scrollpnae = new JScrollPane(Chatting_textArea_chatting);
		scrollpnae.setBounds(12, 10, 355, 417);
		

		
		scrollpnae.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpnae.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_Chatting.add(scrollpnae);
		
		chatting_textField_message = new JTextField();
		chatting_textField_message.setBounds(12, 437, 260, 30);
		panel_Chatting.add(chatting_textField_message);
		chatting_textField_message.setColumns(10);
		
		chatting_btn_MessageSend = new JButton("전송");
		chatting_btn_MessageSend.setBackground(new Color(255, 255, 255));
		chatting_btn_MessageSend.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		chatting_btn_MessageSend.setBounds(291, 437, 76, 30);
		panel_Chatting.add(chatting_btn_MessageSend);
		
		chatting_btn_ExitButton = new JButton("나가기");
		chatting_btn_ExitButton.setBackground(new Color(255, 255, 255));
		chatting_btn_ExitButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		chatting_btn_ExitButton.setBounds(255, 477, 112, 39);
		panel_Chatting.add(chatting_btn_ExitButton);
		
		chatting_btn_FileTab = new JButton("파일");
		chatting_btn_FileTab.setBackground(new Color(255, 255, 255));
		chatting_btn_FileTab.setBounds(12, 477, 97, 39);
		panel_Chatting.add(chatting_btn_FileTab);
		
		JPanel panel_ParticipantList = new JPanel();
		panel_ParticipantList.setBackground(new Color(135, 206, 250));
		tabbedPane_Chatting.addTab("참가자", null, panel_ParticipantList, null);
		panel_ParticipantList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 39, 326, 171);
		panel_ParticipantList.add(scrollPane);
		
		Chatting_textarea_Inuserlist = new JTextArea();
		Chatting_textarea_Inuserlist.setEditable(false);
		scrollPane.setViewportView(Chatting_textarea_Inuserlist);
		
		chatting_btn_Dismantling = new JButton("모임해체");
		chatting_btn_Dismantling.setBounds(226, 479, 126, 37);
		panel_ParticipantList.add(chatting_btn_Dismantling);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 265, 330, 171);
		panel_ParticipantList.add(scrollPane_1);
		
		list = new JList<String>(new DefaultListModel<String>());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		model = (DefaultListModel<String>) list.getModel();
		
		scrollPane_1.setViewportView(list);
		
		JLabel lbl_user = new JLabel("참가자");
		lbl_user.setBounds(26, 10, 103, 19);
		panel_ParticipantList.add(lbl_user);
		
		JLabel lbl_FileList = new JLabel("공유파일 목록");
		lbl_FileList.setBounds(26, 236, 103, 19);
		panel_ParticipantList.add(lbl_FileList);
	}
	public void frameDown() {
		this.setVisible(false);
	}

	public void listUpload() {
		String fileName = folder.getName();
		String fileExtention = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		File[] contents = folder.listFiles();

		if (contents != null) {
			for (int i = 0; i < contents.length; i++) {
				contents[i].getName();
				model.addElement(file.getName());
				System.out.println(contents[i].getName());
			}
		} else {
			System.out.println("파일이 없습니다.");
		}

	}
	public void openDialog() {

		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		} else if (result != JFileChooser.APPROVE_OPTION) {
			
		}
	}
	public void fileSave() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
	}

	public void fileDelete() {
		model.remove(list.getSelectedIndex());

	}
}
