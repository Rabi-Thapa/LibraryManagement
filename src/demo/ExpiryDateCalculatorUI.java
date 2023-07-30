package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

public class ExpiryDateCalculatorUI extends JFrame {
    private static final long serialVersionUID = 1L;

    public ExpiryDateCalculatorUI() {
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

        // Calculate Days Remaining
        JLabel daysRemainingL = new JLabel("Days Remaining:");
        daysRemainingL.setBounds(100, 280, 200, 20);
        daysRemainingL.setFont(fo2);
        c.add(daysRemainingL);

        JLabel daysRemainingValueL = new JLabel("");
        daysRemainingValueL.setBounds(230, 280, 260, 28);
        daysRemainingValueL.setFont(fo3);
        daysRemainingValueL.setForeground(Color.blue);
        c.add(daysRemainingValueL);

        // Listener for date changes
        issueDateT.addPropertyChangeListener("date", e -> calculateDaysRemaining(issueDateT.getDate(), dueDateT.getDate(), daysRemainingValueL));
        dueDateT.addPropertyChangeListener("date", e -> calculateDaysRemaining(issueDateT.getDate(), dueDateT.getDate(), daysRemainingValueL));
    }

    private void calculateDaysRemaining(java.util.Date issueDate, java.util.Date dueDate, JLabel daysRemainingValueL) {
        if (issueDate != null && dueDate != null) {
            LocalDate issueLocalDate = issueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dueLocalDate = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long daysRemaining = ChronoUnit.DAYS.between(LocalDate.now(), dueLocalDate);
            daysRemainingValueL.setText(String.valueOf(daysRemaining));
        } else {
            daysRemainingValueL.setText("");
        }
    }

    public static void main(String[] args) {
        ExpiryDateCalculatorUI frame = new ExpiryDateCalculatorUI();
        frame.setVisible(true);
    }
}

