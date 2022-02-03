package TitleTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DTO.Protocol;
import Resource.R;
import Server.Client;

public class PanelRoomList extends JPanel implements ActionListener{
	public static String labelName[] = { "방 번호: ", "     ", "방 주제 : ", "     ", "인원 수 : ", "     "
			, "방 제목 : ", "     ", "     " };
	public JLabel labelArray[];
	private JButton enterButton;
	
	private BufferedReader br;
	private PrintWriter pw;
	
	public PanelRoomList(BufferedReader br, PrintWriter pw) {
		this.br = br;
		this.pw = pw;
	}
	public void init() {
		br = Client.br;
		pw = Client.pw;
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
			String count[] = labelArray[5].getText().split("/");
			if(count[0].compareTo(count[1]) == 0) {
				JOptionPane.showMessageDialog(this, "인원수 초과로 들어갈 수 없습니다.");
			} else {
				String line = "";
				line += (Protocol.ENTERROOM + "|" + labelArray[1].getText());
				pw.println(line);
				pw.flush();
			}
		}
		
	}
	
}
