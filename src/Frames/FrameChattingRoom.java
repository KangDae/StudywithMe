package Frames;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Resource.R;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.SystemColor;
/*
 * 		방만들기 이후 입장해서 보이게되는 화면의
 * 		프레임입니다.
 */
public class FrameChattingRoom extends R{
	public File file, folder;
	public JTextField chatting_textField_message;
	public JLabel lbl_Active;
	public JPanel chatting_chattingPanel;
	PrintWriter pw;
	BufferedReader br;
	public JButton chatting_btn_Dismantling, chatting_btn_MessageSend, chatting_btn_FileTab, chatting_btn_ExitButton;
	public DefaultListModel<String> model;
	public JList<String> list;
	public JTextArea Chatting_textarea_Inuserlist;
	public JScrollPane scroll_chatting;
	public Box vertical = Box.createVerticalBox();
	public JButton btn_ShareDisplay;
    public JButton btn_ShowDisplay;
	Boolean typing;

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
		//Chatting_textArea_chatting.setBounds(12, 10, 355, 417);
		
		
		
		 
		scroll_chatting = new JScrollPane();
		scroll_chatting.setBounds(12, 25, 355, 402);
		

		
		scroll_chatting.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll_chatting.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_Chatting.add(scroll_chatting);
		Timer t = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!typing) {
					lbl_Active.setText("Active Now");
				}
			}
		});
		t.setInitialDelay(0);
		vertical.setBackground(new Color(173, 216, 230));
		chatting_chattingPanel = new JPanel();
		chatting_chattingPanel.setBackground(SystemColor.menu);
		scroll_chatting.setViewportView(chatting_chattingPanel);
		
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
		
		lbl_Active = new JLabel("Active");
		lbl_Active.setBounds(12, 10, 57, 15);
		panel_Chatting.add(lbl_Active);
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		tabbedPane_Chatting.addTab("화면 공유", null, panel, null);
		panel.setLayout(null);
		
		btn_ShareDisplay = new JButton("화면 공유");
		btn_ShareDisplay.setBounds(124, 160, 97, 23);
		panel.add(btn_ShareDisplay);
		
		btn_ShowDisplay = new JButton("보기");
		btn_ShowDisplay.setBounds(124, 331, 97, 23);
		panel.add(btn_ShowDisplay);
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
	public void containPanelClear() {
		chatting_chattingPanel.removeAll();
	}
	public static JPanel formatLabel(String message){
        JPanel chattingPanel = new JPanel();
        chattingPanel.setLayout(new BoxLayout(chattingPanel, BoxLayout.Y_AXIS));
        
        JLabel chattingLabel = new JLabel("<html><p style = \"width : 100px\">" + message + "</p></html>");
        chattingLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        chattingLabel.setBackground(new Color(135, 206, 235));
        chattingLabel.setOpaque(true);
        chattingLabel.setBorder(new EmptyBorder(15,15,15,50));
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel timeLabel = new JLabel();
        timeLabel.setText(sdf.format(cal.getTime()));
        
        chattingPanel.add(chattingLabel);
        chattingPanel.add(timeLabel);
        return chattingPanel;
    }
}
