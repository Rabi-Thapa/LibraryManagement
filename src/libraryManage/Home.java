package libraryManage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home {
	Home()
	{
		JFrame frame= new JFrame("Library Management");
		frame.setBounds(340, 140, 600, 520);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1, panel2;
		panel1= new JPanel();
		panel1.setLayout(new BorderLayout());
		Color c1= new Color(100,115,212);
		panel1.setBounds(40, 30, 510, 90);
		panel1.setBackground(c1);
		frame.add(panel1);
		
		
		JLabel label = new JLabel("Library Management System");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(Color.white);
		label.setFont(new Font("Consolas", Font.BOLD, 27));
		panel1.add(label);
		
		Color c2= new Color(0,109,114);
		
		panel2= new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(c2);
		panel2.setBounds(40, 140, 510, 310);
		frame.add(panel2);
		
		JButton adminBtn= new JButton ("Admin");
		adminBtn.setFont(new Font("Consolas",Font.BOLD, 16));
		adminBtn.setBounds(180, 20, 140, 50);
		adminBtn.setBackground(Color.darkGray);
		adminBtn.setForeground(Color.white);
		adminBtn.setFocusable(false);
		panel2.add(adminBtn);
		
		JButton librarianBtn= new JButton("Librarian");
		librarianBtn.setFont(new Font("Consolas",Font.BOLD, 16));
		librarianBtn.setBounds(180, 90, 140, 50);
		librarianBtn.setBackground(Color.darkGray);
		librarianBtn.setForeground(Color.white);
		librarianBtn.setFocusable(false);
		panel2.add(librarianBtn);
		
		ActionListener loginBtnListener= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String clickedBtn= e.getActionCommand();
				switch(clickedBtn) {
				case"Admin":
					new Admin();
					break;
				case"Librarian":
					new Librarian();
					break;
				}
			}
		};
		adminBtn.addActionListener(loginBtnListener);
		librarianBtn.addActionListener(loginBtnListener);
		
	}
	
	public static void main(String [] args) {
		new Home();
	}

}
