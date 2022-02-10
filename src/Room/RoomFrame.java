package Room;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import CoControl.CoprocessFrame;
import Room.RoomMake;

/**
 * @author ����
 * @category ���� ����
 *
 */
public class RoomFrame extends JFrame {
	public JButton makeB, exitB, sendB, enterB;
	public JComboBox<String> sortCB;
	public JPanel upP, chatP, chatP1, listP, list1P, list2P, roomP, roomP1, sumP, centerPanel;
	private JPanel[] sortrm;
	public JTextArea chatarea, usertxt;
	public JTextField chattxt, tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8;
	private JLabel la1, la2, la3, la4, la5, la6;
	private String[] com = { "모두", "경영", "마케팅", "고객관리", "개발", "디자인" };
	private JList<String> entlist, frlist;
	private EtchedBorder eb;
	private JList<DetailPanel> list;
	private DefaultListModel<DetailPanel> model;
	public DefaultListModel<String> userWaitModel;
	public DetailPanel[] dp;
	RoomMake rmake;

	private BufferedReader br;
	private PrintWriter pw;

	public RoomFrame(BufferedReader br, PrintWriter pw) {

		this.br = br;
		this.pw = pw;

		// ��ܹ�ư
//		rmake = new RoomMake();
		dp = new DetailPanel[100];
		upP = new JPanel(new FlowLayout());
		la6 = new JLabel("정렬 :  ");
		sortCB = new JComboBox<String>(com);
		sortCB.setPreferredSize(new Dimension(200, 30));
		makeB = new JButton("방만들기");
		makeB.setPreferredSize(new Dimension(400, 30));
		exitB = new JButton("exit");
		exitB.setPreferredSize(new Dimension(200, 30));
		upP.add(la6);
		upP.add(sortCB);
		upP.add(makeB);
		upP.add(exitB);

		// ä�ù� ���
		roomP = new JPanel(new BorderLayout());
		la4 = new JLabel("채팅방 목록");
		la4.setFont(new Font("돋움", Font.PLAIN, 20));

		centerPanel = new JPanel(new GridLayout(100, 2, 10, 10)); // 100��
		for (int i = 0; i < 100; i++) {
			dp[i] = new DetailPanel(br, pw);
			centerPanel.add(dp[i]);
		}
		JScrollPane scrollRoomList = new JScrollPane(centerPanel);
		scrollRoomList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollRoomList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollRoomList.getVerticalScrollBar().setValue(scrollRoomList.getVerticalScrollBar().getMaximum());
		
		
		roomP.add("Center", scrollRoomList);
		roomP.add("North", la4);

		// ����� ä�ø��
		chatP = new JPanel(new BorderLayout());
		la1 = new JLabel("대기자 채팅방 ");
		la1.setFont(new Font("돋움", Font.PLAIN, 15));
		chatarea = new JTextArea();
		chatarea.setEditable(false);
		JScrollPane scroll = new JScrollPane(chatarea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(400, 250));
		scroll.getVerticalScrollBar().setValue(scrollRoomList.getVerticalScrollBar().getMaximum());
		
		
		chatP1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		chattxt = new JTextField(30);
		sendB = new JButton("보내기");

		chatP1.add(chattxt);
		chatP1.add(sendB);

		chatP.add("Center", scroll);
		chatP.add("South", chatP1);
		chatP.add("North", la1);

		// ä�ô���� ���
		listP = new JPanel(new GridLayout(2, 1, 20, 20));

		list1P = new JPanel(new BorderLayout());
		la2 = new JLabel("대기실 인원");
		la2.setFont(new Font("돋움", Font.PLAIN, 15));

		usertxt = new JTextArea();
		usertxt.setEditable(false);

		JScrollPane scroll1 = new JScrollPane(usertxt);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		list1P.add("North", la2);
		list1P.add("Center", scroll1);

		list2P = new JPanel(new BorderLayout());
		list2P.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		la3 = new JLabel("친구목록");
		la3.setFont(new Font("돋움", Font.PLAIN, 15));
		frlist = new JList<String>(new DefaultListModel<String>());
		JScrollPane scroll2 = new JScrollPane(frlist);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		list2P.add("North", la3);
		list2P.add("Center", scroll2);

		listP.add(list1P);
		listP.add(list2P);

		// ����ڸ�� +�����ä��
		sumP = new JPanel(new BorderLayout());

		sumP.add("Center", listP);
		sumP.add("South", chatP);

		// ����
		Container contentPane = this.getContentPane();
		contentPane.add("East", sumP);
		contentPane.add("North", upP);
		contentPane.add("Center", roomP);

		setBounds(400, 200, 1000, 800);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


	}// ������

	public void containPanelClear() {

		centerPanel.removeAll();
		for (int i = 0; i < 100; i++) {
			dp[i] = new DetailPanel(br, pw);
			centerPanel.add(dp[i]);
		}

	}

}