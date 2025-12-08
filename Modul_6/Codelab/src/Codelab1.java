import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Codelab1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Validation");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter PIN (6 digits only):");
        frame.add(label);

        JPasswordField passwordField = new JPasswordField(10);
        frame.add(passwordField);

        JButton button = new JButton("Validate");
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField.getPassword());

                if (password.length() != 6) {
                    JOptionPane.showMessageDialog(frame,
                            "PIN must be exactly 6 characters long!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if (!password.matches("\\d+")) {
                    JOptionPane.showMessageDialog(frame,
                            "PIN must contain digits only (no letters or symbols)!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(frame,
                            "Correct PIN!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}