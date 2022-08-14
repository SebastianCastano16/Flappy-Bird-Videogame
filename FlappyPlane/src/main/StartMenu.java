package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenu {

	JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu window = new StartMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StartMenu() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame("Flappy Plane");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Flappy Plane");
		
		
		
		JLabel lblNewLabel = new JLabel("Welcome to FlappyPlane");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(115, 37, 188, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GamePanel gamePanel = new GamePanel();
				window.add(gamePanel);
				window.pack();
				
				window.setLocationRelativeTo(null);
				window.setVisible(true);
				
				gamePanel.startGameThread();
			}
		});
		btnStartGame.setBounds(125, 99, 148, 37);
		frame.getContentPane().add(btnStartGame);
		
		JButton btnNewButton = new JButton("Quit Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		btnNewButton.setBounds(125, 143, 148, 37);
		frame.getContentPane().add(btnNewButton);
	}

}
