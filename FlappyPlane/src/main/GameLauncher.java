package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class GameLauncher {

	private JFrame frame;
	private JTextField getName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameLauncher window = new GameLauncher();
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
	public GameLauncher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Flappy Plane");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		getName = new JTextField();
		getName.setBounds(164, 90, 138, 26);
		frame.getContentPane().add(getName);
		getName.setColumns(10);
		
		JButton btnName = new JButton("Enter");
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartMenu s = new StartMenu();
				s.frame.setVisible(true);
			}
		});
		btnName.setBounds(192, 126, 85, 21);
		frame.getContentPane().add(btnName);
		
		JLabel lblNewLabel = new JLabel("Enter your name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(61, 92, 105, 20);
		frame.getContentPane().add(lblNewLabel);
	}
}
