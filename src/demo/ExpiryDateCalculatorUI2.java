package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

public class ExpiryDateCalculatorUI2 extends JFrame {
    private static final long serialVersionUID = 1L;

    public ExpiryDateCalculatorUI2() {
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

        // Get Dates as Strings
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        JLabel datesAsStringL = new JLabel("Dates as Strings:");
        datesAsStringL.setBounds(100, 280, 200, 20);
        datesAsStringL.setFont(fo2);
        c.add(datesAsStringL);

        JLabel datesAsStringValueL = new JLabel("");
        datesAsStringValueL.setBounds(230, 280, 260, 28);
        datesAsStringValueL.setFont(fo3);
        datesAsStringValueL.setForeground(Color.blue);
        c.add(datesAsStringValueL);

        issueDateT.addPropertyChangeListener("date", e -> {
            Date selectedDate = issueDateT.getDate();
            if (selectedDate != null) {
                String dateString = dateFormat.format(selectedDate);
                datesAsStringValueL.setText(dateString);
            } else {
                datesAsStringValueL.setText("");
            }
        });

        dueDateT.addPropertyChangeListener("date", e -> {
            Date selectedDate = dueDateT.getDate();
            if (selectedDate != null) {
                String dateString = dateFormat.format(selectedDate);
                datesAsStringValueL.setText(dateString);
            } else {
                datesAsStringValueL.setText("");
            }
        });
    }

    public static void main(String[] args) {
        ExpiryDateCalculatorUI frame = new ExpiryDateCalculatorUI();
        frame.setVisible(true);
    }
}

