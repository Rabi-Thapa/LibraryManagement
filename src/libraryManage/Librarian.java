package libraryManage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class Librarian {
	Scanner s = new Scanner(System.in);
	private int bookid;
	private int userid;
	private String username;
	private String bookname;
	private String author;
	private String genre;
	private int quantity;

	Date issueDate;
	Date dueDate;
	boolean returnBook;

	String fileName = "books.txt";

	public Librarian() {
		JFrame frame = new JFrame("Librarian Section");
		frame.setBounds(340, 140, 600, 520);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1, p2, p3;
		Color c1, c2;
		c1 = new Color(172, 202, 187);
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setBackground(c1);
		p1.setBounds(0, 50, 600, 60);
		frame.add(p1);

		JLabel l = new JLabel("Librarian Section");
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setForeground(Color.black);
		l.setFont(new Font("Consolas", Font.BOLD, 28));
		p1.add(l);

		c2 = new Color(109, 136, 202);

		p2 = new JPanel(null);
		p2.setBackground(c2);
		p2.setBounds(0, 140, 280, 350);
		frame.add(p2);

		p3 = new JPanel(null);
		p3.setBackground(c2);
		p3.setBounds(300, 140, 280, 350);
		frame.add(p3);

		JButton backBtn = new JButton("<Back");
		backBtn.setBounds(10, 10, 100, 30);
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		frame.add(backBtn);

		JButton addBooksBtn = new JButton("Add Books");
		addBooksBtn.setFont(new Font("Consolas", Font.BOLD, 16));
		addBooksBtn.setBounds(70, 20, 140, 40);
		addBooksBtn.setBackground(Color.white);
		addBooksBtn.setForeground(Color.black);
		addBooksBtn.setFocusable(false);
		p2.add(addBooksBtn);

		JButton viewBooksBtn = new JButton("View Books");
		viewBooksBtn.setFont(new Font("Consolas", Font.BOLD, 16));
		viewBooksBtn.setBounds(70, 80, 140, 40);
		viewBooksBtn.setBackground(Color.white);
		viewBooksBtn.setForeground(Color.black);
		viewBooksBtn.setFocusable(false);
		p2.add(viewBooksBtn);

		JButton issueBookBtn = new JButton("Issue Book");
		issueBookBtn.setFont(new Font("Consolas", Font.BOLD, 16));
		issueBookBtn.setBounds(70, 140, 140, 40);
		issueBookBtn.setBackground(Color.white);
		issueBookBtn.setForeground(Color.black);
		issueBookBtn.setFocusable(false);
		p2.add(issueBookBtn);

		JButton viewIssuedBookBtn = new JButton("View Issue Book");
		viewIssuedBookBtn.setFont(new Font("Consolas", Font.BOLD, 14));
		viewIssuedBookBtn.setBounds(70, 20, 160, 40);
		viewIssuedBookBtn.setBackground(Color.white);
		viewIssuedBookBtn.setForeground(Color.black);
		viewIssuedBookBtn.setFocusable(false);
		p3.add(viewIssuedBookBtn);

		JButton returnBookBtn = new JButton("Return Book");
		returnBookBtn.setFont(new Font("Consolas", Font.BOLD, 16));
		returnBookBtn.setBounds(70, 80, 160, 40);
		returnBookBtn.setBackground(Color.white);
		returnBookBtn.setForeground(Color.black);
		returnBookBtn.setFocusable(false);
		p3.add(returnBookBtn);

		ActionListener buttonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String libBtnClick = e.getActionCommand();
				switch (libBtnClick) {
				case "Add Books":
					addBooks();
					break;
				case "View Books":
					showBooks();
					break;
				case "Issue Book":
					issueBook();
					break;

				case "View Issue Book":
					viewIssuedBook();
					break;

				case "Return Book":
					returnBook();
					break;

				case "<Back":
					frame.setVisible(false);
					break;
				}
			}
		};
		addBooksBtn.addActionListener(buttonListener);
		viewBooksBtn.addActionListener(buttonListener);
		issueBookBtn.addActionListener(buttonListener);
		backBtn.addActionListener(buttonListener);
		viewIssuedBookBtn.addActionListener(buttonListener);
		returnBookBtn.addActionListener(buttonListener);
	}

	void addBooks() {
		Font fo1, fo2, fo3;
		fo1 = new Font("Consolas", Font.BOLD, 28);
		fo2 = new Font("Verdana", Font.BOLD, 16);
		fo3 = new Font("Consolas", Font.BOLD, 16);

		JFrame fr = new JFrame("Add books");
		fr.setBounds(340, 140, 600, 350);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);

		Container c = fr.getContentPane();
		c.setLayout(null);

		JLabel lblAddBooks = new JLabel("Add Books");
		lblAddBooks.setFont(fo1);
		lblAddBooks.setBounds(220, 25, 300, 40);
		fr.add(lblAddBooks);

		JLabel booknameL = new JLabel("Book Name :");
		booknameL.setBounds(100, 80, 200, 28);
		booknameL.setFont(fo2);

		JTextField booknameT = new JTextField();
		booknameT.setBounds(230, 80, 260, 28);
		booknameT.setFont(fo3);
		booknameT.setForeground(Color.blue);
		c.add(booknameL);
		c.add(booknameT);

		JLabel authorL = new JLabel("Author :");
		authorL.setBounds(100, 120, 200, 28);
		authorL.setFont(fo2);

		JTextField authorT = new JTextField();
		authorT.setBounds(230, 120, 260, 28);
		authorT.setFont(fo3);
		authorT.setForeground(Color.blue);
		c.add(authorL);
		c.add(authorT);

		JLabel genreL = new JLabel("Genre :");
		genreL.setBounds(100, 160, 200, 28);
		genreL.setFont(fo2);

		JTextField genreT = new JTextField();
		genreT.setBounds(230, 160, 260, 28);
		genreT.setFont(fo3);
		genreT.setForeground(Color.blue);
		c.add(genreL);
		c.add(genreT);

		JLabel quantityL = new JLabel("Quantity :");
		quantityL.setBounds(100, 200, 200, 28);
		quantityL.setFont(fo2);

		JTextField quantityT = new JTextField();
		quantityT.setBounds(230, 200, 260, 28);
		quantityT.setFont(fo3);
		quantityT.setForeground(Color.blue);
		c.add(quantityL);
		c.add(quantityT);

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

		ActionListener backBtnListen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fr.setVisible(false);
			}
		};
		backBtn.addActionListener(backBtnListen);

		ActionListener addBookListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookname = booknameT.getText();
				String author = authorT.getText();
				String genre = genreT.getText();
				String qtyText = quantityT.getText();

				if (bookname.isEmpty() || author.isEmpty() || qtyText.isEmpty()) {
					JOptionPane.showMessageDialog(c, "Please fill in all the fields. You may leave Genre");
					return;
				}

				int quantity;
				try {
					quantity = Integer.parseInt(qtyText);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(c, "Invalid quantity. Please enter a valid integer value.");
					return;
				}

				int bookid = 0;
				try (Scanner readFile = new Scanner(new File(fileName))) {
					while (readFile.hasNextLine()) {
						String line = readFile.nextLine();

						if (line.isEmpty()) {
							continue;
						}

						StringTokenizer token = new StringTokenizer(line, "%");
						if (token.hasMoreTokens()) {
							int id = Integer.parseInt(token.nextToken());
							if (id > bookid) {
								bookid = id;
							}
						}
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				bookid++;

				try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

					writer.write(bookid + "%" + bookname + "%" + author + "%" + genre + "%" + quantity);
					writer.newLine();
					JOptionPane.showMessageDialog(c, "New Book has been added successfully.");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(c, "An error occurred while adding the book.");
					ex.printStackTrace();
				}

				booknameT.setText("");
				authorT.setText("");
				genreT.setText("");
				quantityT.setText("");
			}
		};

		submitBtn.addActionListener(addBookListener);

	}

	void showBooks() {
		JFrame frame2 = new JFrame("BOOKS DETAILS");
		frame2.setBounds(340, 140, 600, 350);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(new BorderLayout());

		String[] columnNames = { "ID", "BOOK NAME", "AUTHOR", "GENRE", "QTY" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);

		JTable table = new JTable();
		table.setModel(model);
		Font tableFont = new Font("Arial", Font.BOLD, 16);
		table.setFont(tableFont);
		table.setForeground(Color.blue);
		table.setRowHeight(25);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);

		JScrollPane scroll = new JScrollPane(table);

		frame2.add(scroll);
		frame2.setVisible(true);
		
	
		JButton backBtn = new JButton("<Back");
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		frame2.add(backBtn, BorderLayout.SOUTH);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.add(backBtn);
		frame2.add(buttonPanel, BorderLayout.NORTH);

		ActionListener backBtnListen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
			}
		};
		backBtn.addActionListener(backBtnListen);

		File file = new File("books.txt");
		try (Scanner readFile = new Scanner(file)) {
			while (readFile.hasNextLine()) {
				String line = readFile.nextLine();
				if (line.isEmpty()) {
					continue;
				}
				StringTokenizer token = new StringTokenizer(line, "%");
				if (token.hasMoreTokens()) {
					bookid = Integer.parseInt(token.nextToken());
					bookname = token.nextToken();
					author = token.nextToken();
					genre = token.nextToken();
					quantity = Integer.parseInt(token.nextToken());
					model.addRow(new Object[] { bookid, bookname, author, genre, quantity });
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void issueBook() {
		boolean isBookReturned = false;

		JFrame fr3 = new JFrame("ISSUE BOOK");
		fr3.setBounds(340, 140, 600, 400);
		fr3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr3.setVisible(true);

		Font fo1, fo2, fo3;
		fo1 = new Font("Consolas", Font.BOLD, 24);
		fo2 = new Font("Verdana", Font.BOLD, 14);
		fo3 = new Font("Consolas", Font.BOLD, 16);

		Container c = fr3.getContentPane();
		c.setLayout(null);

		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setFont(fo1);
		lblIssueBook.setBounds(220, 25, 300, 40);
		fr3.add(lblIssueBook);

		JLabel bookidL = new JLabel("Book ID :");
		bookidL.setBounds(100, 80, 200, 20);
		bookidL.setFont(fo2);

		JTextField bookidT = new JTextField();
		bookidT.setBounds(230, 80, 260, 28);
		bookidT.setFont(fo3);
		bookidT.setForeground(Color.blue);
		c.add(bookidL);
		c.add(bookidT);

		JLabel useridL = new JLabel("User ID:");
		useridL.setBounds(100, 120, 200, 20);
		useridL.setFont(fo2);

		JTextField useridT = new JTextField();
		useridT.setBounds(230, 120, 260, 28);
		useridT.setFont(fo3);
		useridT.setForeground(Color.blue);
		c.add(useridL);
		c.add(useridT);

		JLabel usernameL = new JLabel("User Name:");
		usernameL.setBounds(100, 160, 200, 20);
		usernameL.setFont(fo2);

		JTextField usernameT = new JTextField();
		usernameT.setBounds(230, 160, 260, 28);
		usernameT.setFont(fo3);
		usernameT.setForeground(Color.blue);
		c.add(usernameL);
		c.add(usernameT);

		JLabel issueDateL = new JLabel("Issue Date:");
		issueDateL.setBounds(100, 200, 200, 20);
		issueDateL.setFont(fo2);

		JDateChooser issueDateT = new JDateChooser();
		issueDateT.setBounds(230, 200, 260, 28);
		issueDateT.setFont(fo3);
		issueDateT.setForeground(Color.blue);
		c.add(issueDateL);
		c.add(issueDateT);

		JLabel dueDateL = new JLabel("Due Date:");
		dueDateL.setBounds(100, 240, 200, 20);
		dueDateL.setFont(fo2);

		JDateChooser dueDateT = new JDateChooser();
		dueDateT.setBounds(230, 240, 260, 28);
		dueDateT.setFont(fo3);
		dueDateT.setForeground(Color.blue);
		c.add(dueDateL);
		c.add(dueDateT);

		JButton issueBookBtn = new JButton("issueBook");
		issueBookBtn.setBounds(230, 280, 120, 40);
		issueBookBtn.setBackground(Color.blue);
		issueBookBtn.setForeground(Color.white);
		issueBookBtn.setFocusable(false);
		c.add(issueBookBtn);

		JButton backBtn = new JButton("<Back");
		backBtn.setBounds(10, 10, 100, 30);
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		c.add(backBtn);

		ActionListener backBtnListen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fr3.setVisible(false);
			}
		};
		backBtn.addActionListener(backBtnListen);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		PropertyChangeListener dateChangeListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					issueDate = issueDateT.getDate();
					dueDate = dueDateT.getDate();

				}
			}
		};
		issueDateT.addPropertyChangeListener(dateChangeListener);
		dueDateT.addPropertyChangeListener(dateChangeListener);

		ActionListener issueBookListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookidText = bookidT.getText();
				String useridText = useridT.getText();
				username = usernameT.getText();

				if (bookidText.isEmpty() || useridText.isEmpty() || username.isEmpty()) {
					return;
				}

				try {
					bookid = Integer.parseInt(bookidText);
					userid = Integer.parseInt(useridText);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				}

				bookname = "";

				int bid = 0;
				int bquantity=0;
				String bname = null;
				String bauthor = null;
				String bgenre = null;

				boolean bookfind = false;

				try (Scanner readFile = new Scanner(new File("books.txt"))) {
					while (readFile.hasNextLine()) {
						String line = readFile.nextLine();
						if (line.isEmpty()) {
							continue;
						}

						StringTokenizer token = new StringTokenizer(line, "%");

						bid = Integer.parseInt(token.nextToken());
						bname = token.nextToken();
						bauthor = token.nextToken();
						bgenre = token.nextToken();
						bquantity = Integer.parseInt(token.nextToken());

						if (bookid == bid) {
							bookname = bname;
							bookfind = true;
							break;
						}
					}
					if (!bookfind) {
						JOptionPane.showMessageDialog(c, "Book is Not available");
					}
				} catch (IOException ie) {
					ie.printStackTrace();
				}

				if (bookfind) {
					try (BufferedWriter writer = new BufferedWriter(new FileWriter("issuedBooks.txt", true))) {
						String formattedIssueDate = dateFormat.format(issueDate);
						String formattedDueDate = dateFormat.format(dueDate);

						writer.write(bookid + "%" + bookname + "%" + userid + "%" + username + "%" + formattedIssueDate
								+ "%" + formattedDueDate + "%" + isBookReturned);
						writer.newLine();

					} catch (IOException ie) {
						ie.printStackTrace();
					}
				}

				if (bookfind) {
					try (Scanner readFile = new Scanner(new File("books.txt"));
							BufferedWriter writer = new BufferedWriter(new FileWriter("tempBooks.txt"))) {
						while (readFile.hasNextLine()) {
							String line = readFile.nextLine();

							if (line.isEmpty()) {
								continue;
							}

							StringTokenizer token = new StringTokenizer(line, "%");
							bid = Integer.parseInt(token.nextToken());
							bname = token.nextToken();
							bauthor = token.nextToken();
							bgenre = token.nextToken();
							int originalQuantity = Integer.parseInt(token.nextToken());

							if (bookid == bid) {
								--originalQuantity;
							}
							writer.write(bid + "%" + bname + "%" + bauthor + "%" + bgenre + "%" + originalQuantity);
							writer.newLine();
						}
					} catch (IOException ie) {
						ie.printStackTrace();
					}

					File originalFile = new File("books.txt");
					if (originalFile.exists()) {
						originalFile.delete();
					}

					File tempFile = new File("tempBooks.txt");
					if (tempFile.renameTo(originalFile)) {
						JOptionPane.showMessageDialog(c, "Books Quantity updated successfully.");
					} else {
						JOptionPane.showMessageDialog(c, "Failed to update books quantity.");
					}
				}
				bookidT.setText("");
				useridT.setText("");
				usernameT.setText("");
				issueDateT.setDate(null);
				dueDateT.setDate(null);
			}
		};

		issueBookBtn.addActionListener(issueBookListener);

	}

	void returnBook() {
		Font fo1, fo2, fo3;
		fo1 = new Font("Consolas", Font.BOLD, 30);
		fo2 = new Font("Verdana", Font.BOLD, 16);
		fo3 = new Font("Consolas", Font.BOLD, 16);

		JFrame fr5 = new JFrame();
		fr5.setBounds(340, 140, 600, 400);
		fr5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr5.setVisible(true);

		Container c = fr5.getContentPane();
		c.setLayout(null);

		JLabel labelReturnBook = new JLabel("Return Book");
		labelReturnBook.setFont(fo1);
		labelReturnBook.setBounds(180, 25, 300, 40);
		fr5.add(labelReturnBook);

		JLabel bookidL = new JLabel("Book Id: ");
		bookidL.setBounds(100, 100, 200, 28);
		bookidL.setFont(fo2);

		JTextField bookidT = new JTextField();
		bookidT.setBounds(230, 100, 260, 28);
		bookidT.setFont(fo3);
		bookidT.setForeground(Color.blue);
		c.add(bookidL);
		c.add(bookidT);

		JLabel useridL = new JLabel("User Id: ");
		useridL.setBounds(100, 140, 200, 28);
		useridL.setFont(fo2);

		JTextField useridT = new JTextField();
		useridT.setBounds(230, 140, 260, 28);
		useridT.setFont(fo3);
		useridT.setForeground(Color.blue);
		c.add(useridL);
		c.add(useridT);

		JButton returnBtn = new JButton("Return");
		returnBtn.setBounds(230, 180, 120, 40);
		returnBtn.setBackground(Color.blue);
		returnBtn.setForeground(Color.white);
		returnBtn.setFocusable(false);
		c.add(returnBtn);

		JButton backBtn = new JButton("<Back");
		backBtn.setBounds(10, 10, 100, 30);
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		c.add(backBtn);

		ActionListener returnBookListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookidText = bookidT.getText();
				String useridText = useridT.getText();

				if (bookidText.isEmpty() || useridText.isEmpty()) {
					JOptionPane.showMessageDialog(c, "BookID and UserID are empty");
					return;

				}

				try {
					bookid = Integer.parseInt(bookidText);
					userid = Integer.parseInt(useridText);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				}

				String bauthor;
				String bgenre;
				int originalQuantity;

				int bid = 0;
				String bname;
				int uid = 0;
				String uname=null;
				String isDate = null;
				String duDate = null;
				boolean isBReturn;

				boolean bookfind = false;

				try (Scanner readFile = new Scanner(new File("issuedBooks.txt"))) {
					while (readFile.hasNextLine()) {
						String line = readFile.nextLine();
						if (line.isEmpty()) {
							continue;
						}
						StringTokenizer token = new StringTokenizer(line, "%");

						bid = Integer.parseInt(token.nextToken());
						bname = token.nextToken();
						uid = Integer.parseInt(token.nextToken());
//						isDate= token.nextToken();
//						duDate= token.nextToken();
//						isBReturn= Boolean.parseBoolean(token.nextToken());

						if ((bookid == bid) && (userid == uid)) {
							bookfind = true;
						}
					}
					if (!bookfind) {
						JOptionPane.showMessageDialog(c, "Book Id and User Id do not match");
					}
				} catch (IOException ie) {
					ie.printStackTrace();
				}

				if (bookfind) {
					try (Scanner readFile = new Scanner(new File("issuedBooks.txt"));
							BufferedWriter writer = new BufferedWriter(new FileWriter("tempIssuedBooks.txt"))) {
						while (readFile.hasNextLine()) {
							String line = readFile.nextLine();
							if (line.isEmpty()) {
								continue;
							}
							StringTokenizer token = new StringTokenizer(line, "%");
							bid = Integer.parseInt(token.nextToken());
							bname = token.nextToken();
							uid = Integer.parseInt(token.nextToken());
							uname= token.nextToken();
							isDate = token.nextToken();
							duDate = token.nextToken();
							isBReturn = Boolean.parseBoolean(token.nextToken());
							if ((bookid == bid) && (userid == uid)) {
								isBReturn = true;
							}
							writer.write(bid + "%" + bname + "%" + uid + "%" +uname+"%"+ isDate + "%" + duDate + "%" + isBReturn);
							writer.newLine();

						}
					} catch (IOException ie) {
						ie.printStackTrace();
					}
					File originalFile = new File("issuedBooks.txt");
					if (originalFile.exists()) {
						originalFile.delete();
					}
					File tempFile = new File("tempIssuedBooks.txt");
					if (tempFile.renameTo(originalFile)) {
						JOptionPane.showMessageDialog(c, "Book is returned successfully True.");
					} else {
						JOptionPane.showMessageDialog(c, "Failed to return quantity.");
					}
				}

				if (bookfind) {
					try (Scanner readFile = new Scanner(new File("books.txt"));
							BufferedWriter writer = new BufferedWriter(new FileWriter("tempBooks.txt"))) {
						while (readFile.hasNextLine()) {
							String line = readFile.nextLine();
							if (line.isEmpty()) {
								continue;
							}
							StringTokenizer token = new StringTokenizer(line, "%");

							bid = Integer.parseInt(token.nextToken());
							bname = token.nextToken();
							bauthor = token.nextToken();
							bgenre = token.nextToken();
							originalQuantity = Integer.parseInt(token.nextToken());
							if (bookid == bid) {
								++originalQuantity;
							}
							writer.write(bid + "%" + bname + "%" + bauthor + "%" + bgenre + "%" + originalQuantity);
							writer.newLine();
						}
					} catch (IOException ie) {
						ie.printStackTrace();
					}
					File originalFile = new File("books.txt");
					if (originalFile.exists()) {
						originalFile.delete();
					}
					File tempFile = new File("tempBooks.txt");
					if (tempFile.renameTo(originalFile)) {
						JOptionPane.showMessageDialog(c, "Books Quantiry is updated successfully.");
					} else {
						JOptionPane.showMessageDialog(c, "Failed to update books quantity.");
					}
				}
				bookidT.setText("");
				useridT.setText("");
			}
		};
		returnBtn.addActionListener(returnBookListener);

	}

	void viewIssuedBook() {
		JFrame fr4 = new JFrame("VIEW ISSUED BOOK");
		fr4.setBounds(240, 140, 800, 400);
		fr4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr4.setLayout(new BorderLayout());

		String[] columnNames = { "Book Id", "Book Name", "User Id", "User Name", "Issued Date", "Due Date",
				"Return Book" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);

		JTable table = new JTable(model);
		Font tableFont = new Font("Arial", Font.BOLD, 12);
		table.setFont(tableFont);
		table.setForeground(Color.blue);
		table.setRowHeight(25);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);

		JScrollPane scroll = new JScrollPane(table);
		fr4.add(scroll);
		fr4.setVisible(true);

		JButton backBtn = new JButton("<Back");
		backBtn.setBackground(Color.green);
		backBtn.setForeground(Color.black);
		backBtn.setFocusable(false);
		fr4.add(backBtn, BorderLayout.SOUTH);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.add(backBtn);
		fr4.add(buttonPanel, BorderLayout.NORTH);

		ActionListener backBtnListen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fr4.setVisible(false);
			}
		};
		backBtn.addActionListener(backBtnListen);

		File file = new File("issuedBooks.txt");
		try (Scanner readFile = new Scanner(file)) {
			while (readFile.hasNextLine()) {
				String line = readFile.nextLine();
				if (line.isEmpty()) {
					continue;
				}

				StringTokenizer token = new StringTokenizer(line, "%");
				if (token.hasMoreTokens()) {
					bookid = Integer.parseInt(token.nextToken());
					bookname = token.nextToken();
					userid = Integer.parseInt(token.nextToken());
					username = token.nextToken();
					String isDate = token.nextToken();
					String duDate = token.nextToken();
					String rtnBook = token.nextToken();

					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
						issueDate = sdf.parse(isDate);
						dueDate = sdf.parse(duDate);
						returnBook = Boolean.parseBoolean(rtnBook);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					model.addRow(new Object[] { bookid, bookname, userid, username, issueDate, dueDate, returnBook });
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Librarian();

	}
}
