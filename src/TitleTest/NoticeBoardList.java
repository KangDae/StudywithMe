package TitleTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

import DTO.Protocol;

import Server.Client_network;

public class NoticeBoardList extends JPanel implements ActionListener{
	public static String labelName[] = { "번호: ", "     ", "제목 : ", "     ", "작성자 : ", "     ", "작성일 : ", "     ", "     " };
	
	
	public JLabel labelArray[];
	private JButton enterButton;
	
	private BufferedReader br;
	private PrintWriter pw;
	
	public NoticeBoardList(BufferedReader br, PrintWriter pw) {
		this.br = br;
		this.pw = pw;
	}
	public void init() {
		br = Client_network.br;
		pw = Client_network.pw;
		this.setLayout(new GridLayout(5, 2, 1, 1));
		labelArray = new JLabel[labelName.length];
		
		for(int i=0; i<labelName.length; i++) {
			labelArray[i] = new JLabel(labelName[i]);
			this.add(labelArray[i]);
		}
		enterButton = new JButton("입 장");
		this.add(enterButton);
		enterButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("입장버튼");
		if(e.getSource() == enterButton) {		
				String line = "";
				line += (Protocol.ENTERNOTICEBOARD_SERVER + "|" + labelArray[1].getText());
				pw.println(line);
				pw.flush();
		}
		
	}
	
}
