package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

public class DateTOString extends JFrame {
    private static final long serialVersionUID = 1L;

    public DateTOString() {
        setTitle("Expiry Date Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        Container c = getContentPane();
        c.setLayout(null);

        // Font settings
        Font fo2 = new Font("Arial", Font.PLAIN, 14);
        Font fo3 = new Font("Arial", Font.BOLD, 14);

        // Issue Date components
        JLabel issueDateL = new JLabel("Issue Date:");
        issueDateL.setBounds(100, 200, 200, 20);
        issueDateL.setFont(fo2);

        JDateChooser issueDateT = new JDateChooser();
        issueDateT.setBounds(230, 200, 260, 28);
        issueDateT.setFont(fo3);
        issueDateT.setForeground(Color.blue);
        c.add(issueDateL);
        c.add(issueDateT);

        // Due Date components
        JLabel dueDateL = new JLabel("Due Date:");
        dueDateL.setBounds(100, 240, 200, 20);
        dueDateL.setFont(fo2);

        JDateChooser dueDateT = new JDateChooser();
        dueDateT.setBounds(230, 240, 260, 28);
        dueDateT.setFont(fo3);
        dueDateT.setForeground(Color.blue);
        c.add(dueDateL);
        c.add(dueDateT);

        // Save Dates to File
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        issueDateT.addPropertyChangeListener("date", e -> saveDatesToFile(issueDateT.getDate(), dueDateT.getDate()));
        dueDateT.addPropertyChangeListener("date", e -> saveDatesToFile(issueDateT.getDate(), dueDateT.getDate()));
    }

    private void saveDatesToFile(Date issueDate, Date dueDate) {
        if (issueDate != null && dueDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String issueDateStr = dateFormat.format(issueDate);
            String dueDateStr = dateFormat.format(dueDate);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("dates.txt"))) {
                writer.write("Issue Date: " + issueDateStr);
                writer.newLine();
                
                writer.write("Due Date: " + dueDateStr);
                writer.newLine();
                writer.flush();
                System.out.println("Dates saved to file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DateTOString frame = new DateTOString();
        frame.setVisible(true);
    }
}
