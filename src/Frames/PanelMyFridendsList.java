package Frames;

import java.awt.Color;
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
import Server.Client_network;

public class PanelMyFridendsList extends JPanel implements ActionListener {
	public static String labelName[] = { "아 이 디: ", "        ", "    " };
	public JLabel labelArray[];
	private JButton enterButton;

	private BufferedReader br;
	private PrintWriter pw;

	public PanelMyFridendsList(BufferedReader br, PrintWriter pw) {
		this.br = br;
		this.pw = pw;
		this.setBackground(new Color(0, 191, 255));
	}

	public void init() {
		br = Client_network.br;
		pw = Client_network.pw;
		this.setLayout(new GridLayout(1, 4, 1, 1));
		labelArray = new JLabel[labelName.length];

		for (int i = 0; i < labelName.length; i++) {
			labelArray[i] = new JLabel(labelName[i]);
			this.add(labelArray[i]);
		}
		enterButton = new JButton("친구 삭제");
		this.add(enterButton);
		enterButton.addActionListener(this);
		this.setBackground(new Color(135, 206, 250));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton) {
			pw.println(Protocol.MYFRIENDS_DELETE + "|" + labelArray[1].getText());
			pw.flush();
		}
	}

}
