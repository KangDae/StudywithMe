package TitleTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Resource.R;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameMakeRoom extends JFrame implements R{

	private JTextField textField_RoomName;
	private JPasswordField passwordField;
	public FrameMakeRoom(){
//		initialize();
//		this.setUndecorated(true);
	}

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
		
		JPanel panel_MakeRoom = new JPanel();
		panel_MakeRoom.setBackground(new Color(135, 206, 250));
		this.getContentPane().add(panel_MakeRoom, BorderLayout.CENTER);
		panel_MakeRoom.setLayout(null);
		
		JLabel lbl_RoomName = new JLabel("방 제목 : ");
		lbl_RoomName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName.setBounds(34, 256, 77, 21);
		panel_MakeRoom.add(lbl_RoomName);
		
		textField_RoomName = new JTextField();
		textField_RoomName.setBounds(101, 259, 116, 21);
		panel_MakeRoom.add(textField_RoomName);
		textField_RoomName.setColumns(10);
		
		JLabel lbl_RoomName_1 = new JLabel("비밀번호 : ");
		lbl_RoomName_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName_1.setBounds(23, 287, 77, 21);
		panel_MakeRoom.add(lbl_RoomName_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(101, 290, 116, 21);
		passwordField.setEchoChar('*');
		panel_MakeRoom.add(passwordField);
		
		JLabel lbl_RoomName_1_1 = new JLabel("방 주제 : ");
		lbl_RoomName_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName_1_1.setBounds(34, 318, 77, 21);
		panel_MakeRoom.add(lbl_RoomName_1_1);
		//R.roomTopic
		JComboBox comboBox_RoomTopic = new JComboBox<String>();
		comboBox_RoomTopic.setBounds(101, 321, 116, 23);
		panel_MakeRoom.add(comboBox_RoomTopic);
		
		JLabel lbl_RoomName_1_1_1 = new JLabel("허용인원 : ");
		lbl_RoomName_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName_1_1_1.setBounds(23, 349, 77, 21);
		panel_MakeRoom.add(lbl_RoomName_1_1_1);
		
		JSpinner spinner_userMax = new JSpinner();
		spinner_userMax.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_userMax.setBounds(101, 352, 45, 22);
		panel_MakeRoom.add(spinner_userMax);
		
		JButton btn_RoomMaker = new JButton("방생성");
		btn_RoomMaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameChattingRoom.start();
				frameDown();
			}
		});
		btn_RoomMaker.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_RoomMaker.setBounds(245, 258, 97, 40);
		panel_MakeRoom.add(btn_RoomMaker);
		
		JButton btn_Cancle = new JButton("취소");
		btn_Cancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_Cancle.setBounds(283, 460, 77, 29);
		panel_MakeRoom.add(btn_Cancle);
		
		JLabel lblNewLabel = new JLabel(R.image);
		lblNewLabel.setBounds(34, 83, 308, 104);
		panel_MakeRoom.add(lblNewLabel);
	}
	private void frameDown() {
		this.setVisible(false);
	}
}
