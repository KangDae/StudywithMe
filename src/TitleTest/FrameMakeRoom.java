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

public class FrameMakeRoom implements R{

	private JFrame frame;
	private JTextField textField_RoomName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMakeRoom window = new FrameMakeRoom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameMakeRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_MakeRoom = new JPanel();
		frame.getContentPane().add(panel_MakeRoom, BorderLayout.CENTER);
		panel_MakeRoom.setLayout(null);
		
		JLabel lbl_RoomName = new JLabel("방 제목 : ");
		lbl_RoomName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName.setBounds(34, 36, 77, 21);
		panel_MakeRoom.add(lbl_RoomName);
		
		textField_RoomName = new JTextField();
		textField_RoomName.setBounds(101, 39, 116, 21);
		panel_MakeRoom.add(textField_RoomName);
		textField_RoomName.setColumns(10);
		
		JLabel lbl_RoomName_1 = new JLabel("비밀번호 : ");
		lbl_RoomName_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName_1.setBounds(23, 67, 77, 21);
		panel_MakeRoom.add(lbl_RoomName_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(101, 70, 116, 21);
		panel_MakeRoom.add(passwordField);
		
		JLabel lbl_RoomName_1_1 = new JLabel("방 주제 : ");
		lbl_RoomName_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName_1_1.setBounds(34, 98, 77, 21);
		panel_MakeRoom.add(lbl_RoomName_1_1);
		//R.roomTopic
		JComboBox comboBox_RoomTopic = new JComboBox<String>();
		comboBox_RoomTopic.setBounds(101, 101, 116, 23);
		panel_MakeRoom.add(comboBox_RoomTopic);
		
		JLabel lbl_RoomName_1_1_1 = new JLabel("허용인원 : ");
		lbl_RoomName_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName_1_1_1.setBounds(23, 129, 77, 21);
		panel_MakeRoom.add(lbl_RoomName_1_1_1);
		
		JSpinner spinner_userMax = new JSpinner();
		spinner_userMax.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_userMax.setBounds(101, 132, 45, 22);
		panel_MakeRoom.add(spinner_userMax);
		
		JButton btn_RoomMaker = new JButton("방생성");
		btn_RoomMaker.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_RoomMaker.setBounds(245, 38, 97, 40);
		panel_MakeRoom.add(btn_RoomMaker);
		
		JButton btn_Cancle = new JButton("취소");
		btn_Cancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_Cancle.setBounds(295, 222, 77, 29);
		panel_MakeRoom.add(btn_Cancle);
	}
}
