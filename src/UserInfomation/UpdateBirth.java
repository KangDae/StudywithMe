package UserInfomation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

import Resource.R;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UpdateBirth extends R{
	
	public JComboBox comboBox_Year, comboBox_Moonth, comboBox_Day;
	public JButton btn_cancle, btn_Update;	
	public UpdateBirth() {
		initialize();
	}

	public void start() {
		this.setVisible(true);
	}
	public void frameDown() {
		this.setVisible(false);
	}
	private void initialize() {
		this.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		this.getContentPane().setBackground(new Color(135, 206, 250));
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(R.image);
		lblNewLabel.setBounds(28, 92, 324, 150);
		this.getContentPane().add(lblNewLabel);
		
		comboBox_Year = new JComboBox<String>(R.ageYear);
		comboBox_Year.setBounds(28, 348, 83, 23);
		getContentPane().add(comboBox_Year);
		
		JLabel lblNewLabel_1 = new JLabel("년");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(123, 352, 41, 15);
		getContentPane().add(lblNewLabel_1);
		
		comboBox_Moonth = new JComboBox<String>(R.ageMonth);
		comboBox_Moonth.setBounds(145, 348, 58, 23);
		getContentPane().add(comboBox_Moonth);
		
		JLabel lblNewLabel_1_1 = new JLabel("월");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(215, 349, 41, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		comboBox_Day = new JComboBox<String>(R.ageDay);
		comboBox_Day.setBounds(242, 348, 58, 23);
		getContentPane().add(comboBox_Day);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("일");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(312, 349, 41, 15);
		getContentPane().add(lblNewLabel_1_1_1);
		
		btn_cancle = new JButton("취소");
		btn_cancle.setBackground(new Color(255, 255, 255));
		btn_cancle.setBounds(28, 516, 125, 35);
		getContentPane().add(btn_cancle);
		
		btn_Update = new JButton("수정");
		btn_Update.setBackground(new Color(255, 255, 255));
		btn_Update.setBounds(247, 516, 125, 35);
		getContentPane().add(btn_Update);
	}
}
