package TitleTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;

import Resource.R;

public class CenterInUpdate extends R{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CenterInUpdate window = new CenterInUpdate();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CenterInUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(59, 38, 250, 108);
		getContentPane().add(lblNewLabel);
		setBounds(100, 100, 400, 600);
	}
}
