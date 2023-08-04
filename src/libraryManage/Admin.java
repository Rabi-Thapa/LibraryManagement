package libraryManage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Admin {
	Scanner s = new Scanner(System.in);

	private int id;
	private String name;
	private String password;
	boolean admin;

	Admin() {
		JFrame frame = new JFrame("Admin Menu");
		frame.setBounds(340, 140, 600, 520);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1, p2;
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setBackground(new Color(239, 218, 220));
		p1.setBounds(0, 50, 600, 60);

		JLabel l;
		l = new JLabel("Admin Section");
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setForeground(Color.black);
		l.setFont(new Font("Consolas", Font.BOLD, 30));
		p1.add(l);
		frame.add(p1);

		// p1= new JPanel(null);
		// p1.setBackground(Color.darkGray);
		// p1.setBounds(0, 140, 280, 600);
		// frame.add(p1);
		//
		// p2= new JPanel();
		// p2.setBackground(Color.darkGray);
		// p2.setBounds(300, 140, 280, 600);
		// frame.add(p2);

		p2 = new JPanel(null);
		p2.setBackground(new Color(109, 136, 202));
		p2.setBounds(40, 140, 510, 310);
		frame.add(p2);

		JButton createAccountBtn = new JButton("Create Account");
		createAccountBtn.setFont(new Font("Consolas", Font.BOLD, 14));
		createAccountBtn.setBounds(180, 20, 160, 50);
		createAccountBtn.setBackground(Color.white);
		createAccountBtn.setForeground(Color.black);
		createAccountBtn.setFocusable(false);
		p2.add(createAccountBtn);

		JButton viewLibrarianBtn = new JButton("View Librarian");
		viewLibrarianBtn.setFont(new Font("Consolas", Font.BOLD, 14));
		viewLibrarianBtn.setBounds(180, 90, 160, 50);
		viewLibrarianBtn.setBackground(Color.white);
		viewLibrarianBtn.setForeground(Color.black);
		viewLibrarianBtn.setFocusable(false);
		p2.add(viewLibrarianBtn);

		JButton deleteLibrarianBtn = new JButton("Delete Librarian");
		deleteLibrarianBtn.setFont(new Font("Consolas", Font.BOLD, 12));
		deleteLibrarianBtn.setBounds(180, 160, 160, 50);
		deleteLibrarianBtn.setBackground(Color.white);
		deleteLibrarianBtn.setForeground(Color.black);
		deleteLibrarianBtn.setFocusable(false);
		p2.add(deleteLibrarianBtn);

		JButton backBtn = new JButton("<Back");
		backBtn.setBounds(10, 10, 100, 30);
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		frame.add(backBtn);

		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String buttonClick = e.getActionCommand();
				switch (buttonClick) {
					case "Create Account":
						addLibrarian();
						break;
					case "View Librarian":
						showUser();
						break;

					case "Delete Librarian":
						deleteAdmin();
						break;

					case "<Back":
						frame.setVisible(false);
						break;
				}
			}
		};
		createAccountBtn.addActionListener(buttonListener);
		viewLibrarianBtn.addActionListener(buttonListener);
		deleteLibrarianBtn.addActionListener(buttonListener);
		backBtn.addActionListener(buttonListener);
	}

	public Admin(int id, String username, String password, boolean admin) {
		this.id = id;
		this.name = username;
		this.password = password;
		this.admin = admin;
	}

	String fileName = "user.txt";
	Collection<Admin> userlist = new ArrayList<>();
	Iterator<Admin> iterator;

	void addLibrarian() {
		Font font1, font2, font3;
		font1 = new Font("Consolas", Font.BOLD, 30);
		font2 = new Font("Verdana", Font.BOLD, 16);
		font3 = new Font("Consolas", Font.BOLD, 16);

		JFrame frame = new JFrame("Add Librarian");
		frame.setBounds(340, 140, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Container c = frame.getContentPane();
		c.setLayout(null);

		JLabel labelCreateAccount = new JLabel("Add Librarian");
		labelCreateAccount.setFont(font1);
		labelCreateAccount.setBounds(180, 25, 300, 40);
		frame.add(labelCreateAccount);

		JLabel idL = new JLabel("id :");
		idL.setBounds(100, 80, 200, 28);
		idL.setFont(font2);

		JTextField idT = new JTextField();
		idT.setBounds(230, 80, 260, 28);
		idT.setFont(font3);
		idT.setForeground(Color.blue);
		c.add(idL);
		c.add(idT);

		JLabel usernameL = new JLabel("User Name:");
		usernameL.setBounds(100, 120, 200, 28);
		usernameL.setFont(font2);

		JTextField usernameT = new JTextField();
		usernameT.setBounds(230, 120, 260, 28);
		usernameT.setFont(font3);
		usernameT.setForeground(Color.blue);
		c.add(usernameL);
		c.add(usernameT);

		JLabel passwordL = new JLabel("Password :");
		passwordL.setBounds(100, 160, 200, 28);
		passwordL.setFont(font2);

		JTextField passwordT = new JPasswordField();
		passwordT.setBounds(230, 160, 260, 28);
		passwordT.setFont(font3);
		passwordT.setForeground(Color.blue);
		c.add(passwordL);
		c.add(passwordT);

		JRadioButton adminBtn, userBtn;

		adminBtn = new JRadioButton("Admin");
		adminBtn.setBounds(230, 200, 100, 28);
		adminBtn.setFont(font2);
		c.add(adminBtn);

		userBtn = new JRadioButton("Librarian");
		userBtn.setBounds(350, 200, 140, 28);
		userBtn.setFont(font2);
		c.add(userBtn);

		ButtonGroup group = new ButtonGroup();
		group.add(adminBtn);
		group.add(userBtn);

		JButton submitBtn = new JButton("Submit");
		submitBtn.setBounds(230, 240, 120, 40);
		submitBtn.setBackground(Color.blue);
		submitBtn.setForeground(Color.white);
		submitBtn.setFocusable(false);
		c.add(submitBtn);

		JButton backBtn = new JButton("<Back");
		backBtn.setBounds(10, 10, 100, 30);
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		c.add(backBtn);

		ActionListener createAccountListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userIdText = idT.getText();
				name = usernameT.getText();
				password = passwordT.getText();
				if (adminBtn.isSelected()) {
					admin = true;
				} else if (userBtn.isSelected()) {
					admin = false;
				}

				if (userIdText.isEmpty() || name.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(c, "Please fill in all the field.");
				}

				try {
					id = Integer.parseInt(userIdText);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(c, "Invalid userid. Please enter a integer value for id.");
					return;
				}

				try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
					writer.write(id + "%" + name + "%" + password + "%" + admin);
					writer.newLine();
					JOptionPane.showMessageDialog(c, "A new user has been created successfully");

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(c, "An error occurred while creating a new user.");
					ex.printStackTrace();
				}

				idT.setText("");
				usernameT.setText("");
				passwordT.setText("");
				group.clearSelection();
			}

		};
		submitBtn.addActionListener(createAccountListener);

		ActionListener backBtnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		};
		backBtn.addActionListener(backBtnListener);
	}

	@Override
	public String toString() {
		return "User [userid=" + id + ", username=" + name + ", password=" + password + ", admin=" + admin + "]";
	}

	void showUser() {
		JFrame frame2 = new JFrame("USER DETAILS");
		frame2.setBounds(340, 140, 600, 350);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(new BorderLayout());

		String[] columnNames = { "ID", "USERNAME", "PASSWORD", "ADMIN" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);

		JTable table = new JTable();
		table.setModel(model);
		Font tableFont = new Font("Arial", Font.BOLD, 16);
		table.setFont(tableFont);
		table.setForeground(Color.darkGray);
		table.setRowHeight(25);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);

		JScrollPane scroll = new JScrollPane(table);
		// scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		JButton backBtn = new JButton("<Back");
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		frame2.add(backBtn, BorderLayout.SOUTH);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.add(backBtn);
		frame2.add(buttonPanel, BorderLayout.NORTH);

		frame2.add(scroll);
		frame2.setVisible(true);

		ActionListener backBtnListen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
			}
		};
		backBtn.addActionListener(backBtnListen);

		try {
			File file = new File(fileName);
			try (Scanner readFile = new Scanner(file)) {
				while (readFile.hasNextLine()) {
					StringTokenizer token = null;
					token = new StringTokenizer(readFile.nextLine(), "%");
					id = Integer.parseInt(token.nextToken());
					name = token.nextToken();
					password = token.nextToken();
					admin = Boolean.parseBoolean(token.nextToken());
					model.addRow(new Object[] { id, name, password, admin });
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void deleteAdmin() {
		JFrame frame3 = new JFrame("Delete Record");
		frame3.setBounds(340, 140, 600, 300);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setVisible(true);

		Font fo1, fo2, fo3;
		fo1 = new Font("Consolas", Font.BOLD, 30);
		fo2 = new Font("Verdana", Font.BOLD, 16);
		fo3 = new Font("Consolas", Font.BOLD, 16);

		Container c = frame3.getContentPane();
		c.setLayout(null);

		JLabel lblRemvLibrarian = new JLabel("Remove Admin");
		lblRemvLibrarian.setFont(fo1);
		lblRemvLibrarian.setBounds(200, 25, 300, 40);
		frame3.add(lblRemvLibrarian);

		JLabel adminidL = new JLabel("Id: ");
		adminidL.setBounds(100, 90, 200, 28);
		adminidL.setFont(fo2);

		JTextField adminidT = new JTextField();
		adminidT.setBounds(230, 90, 260, 28);
		adminidT.setFont(fo3);
		adminidT.setForeground(Color.blue);
		c.add(adminidL);
		c.add(adminidT);

		JLabel passwordL = new JLabel("Password: ");
		passwordL.setBounds(100, 140, 200, 28);
		passwordL.setFont(fo2);

		JTextField passwordT = new JTextField();
		passwordT.setBounds(230, 140, 260, 28);
		passwordT.setFont(fo3);
		passwordT.setForeground(Color.blue);
		c.add(passwordL);
		c.add(passwordT);

		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(230, 190, 120, 40);
		deleteBtn.setBackground(Color.blue);
		deleteBtn.setForeground(Color.white);
		deleteBtn.setFocusable(false);
		c.add(deleteBtn);

		JButton backBtn = new JButton("<Back");
		backBtn.setBounds(10, 10, 100, 30);
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		c.add(backBtn);

		ActionListener backBtnListen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame3.setVisible(false);
			}
		};
		backBtn.addActionListener(backBtnListen);

		ActionListener deleteAdminListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String adminidText = adminidT.getText();
				String pass = passwordT.getText();

				if (adminidText.isEmpty() || pass.isEmpty()) {
					JOptionPane.showMessageDialog(c, "Please Fill up the empty Fields");
					return;
				}
				try {
					id = Integer.parseInt(adminidText);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(c, "Please enter a valid id.");
					nfe.printStackTrace();
				}

				boolean found = false;

				try (Scanner readFile = new Scanner(new File("user.txt"))) {
					while (readFile.hasNextLine()) {
						String line = readFile.nextLine();
						if (line.isEmpty()) {
							continue;
						}
						StringTokenizer token = new StringTokenizer(line, "%");

						int userId = Integer.parseInt(token.nextToken()); // Use a local variable
						String userName = token.nextToken(); // Use a local variable
						String userPassword = token.nextToken(); // Use a local variable
						boolean userAdmin = Boolean.parseBoolean(token.nextToken()); // Use a local variable

						Admin admins = new Admin(userId, userName, userPassword, userAdmin);
						userlist.add(admins);
					}

					Iterator<Admin> iterator = userlist.iterator();
					while (iterator.hasNext()) {
						Admin admins = iterator.next();
						if ((admins.id == id) && admins.password.equals(pass)) {
							iterator.remove();
							JOptionPane.showMessageDialog(c, admins + "\n This account has been deleted successfully.");

							found = true;
						}
					}
					if (!found) {
						JOptionPane.showMessageDialog(c, "Record not found");
					} else {
						try (PrintWriter writer = new PrintWriter(fileName)) {
							for (Admin user : userlist) {
								writer.println(user.id + "%" + user.name + "%" + user.password + "%" + user.admin);
							}
						} catch (IOException ee) {
							ee.printStackTrace();
						}
					}
				} catch (IOException ie) {
					ie.printStackTrace();
				}
				adminidT.setText("");
				passwordT.setText("");
			}
		};
		deleteBtn.addActionListener(deleteAdminListener);

	}

	void search() {
		boolean found = false;
		File file = new File(fileName);
		try (Scanner readFile = new Scanner(file)) {
			StringTokenizer token = null;

			while (readFile.hasNextLine()) {
				token = new StringTokenizer(readFile.nextLine(), "%");
				id = Integer.parseInt(token.nextToken());
				name = token.nextToken();
				password = token.nextToken();
				admin = Boolean.parseBoolean(token.nextToken());

				Admin user = new Admin(id, name, password, admin);
				userlist.add(user);
			}

			System.out.println("Enter userid to search");
			int a = s.nextInt();
			iterator = userlist.iterator();
			while (iterator.hasNext()) {
				Admin user = iterator.next();
				if (user.id == a) {
					System.out.println(user);
					found = true;
				}
			}
			if (!found) {
				System.out.println("Record Not Found");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Admin();
	}
}
