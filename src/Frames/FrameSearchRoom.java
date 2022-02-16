package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Resource.R;

public class FrameSearchRoom extends R{
	public JTextField searchRoom_textField;
	public JButton searchRoom_btn, searchRoom_btn_Cancle;
	
	public FrameSearchRoom() {
		initialize();
	}
	public void start() {
		this.setVisible(true);
	}

	private void initialize() {
		this.setBounds(100, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_SearchRoom = new JPanel();
		panel_SearchRoom.setBackground(new Color(135, 206, 250));
		this.getContentPane().add(panel_SearchRoom, BorderLayout.CENTER);
		panel_SearchRoom.setLayout(null);

		JLabel lbl_RoomName = new JLabel("방 검색 : ");
		lbl_RoomName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName.setBounds(34, 262, 77, 21);
		panel_SearchRoom.add(lbl_RoomName);

		searchRoom_textField = new JTextField();
		searchRoom_textField.setBounds(100, 259, 180, 28);
		panel_SearchRoom.add(searchRoom_textField);
		searchRoom_textField.setColumns(20);
		
		searchRoom_btn = new JButton("검색");
		searchRoom_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		searchRoom_btn.setBounds(283, 259, 77, 29);
		panel_SearchRoom.add(searchRoom_btn);
		
		searchRoom_btn_Cancle = new JButton("취소");
		searchRoom_btn_Cancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		searchRoom_btn_Cancle.setBounds(283, 295, 77, 29);
		panel_SearchRoom.add(searchRoom_btn_Cancle);
		
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(34, 10, 308, 160);
		panel_SearchRoom.add(lblNewLabel);
		
	}
	
	public void frameDown() {
		this.setVisible(false);
	}
}