import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Codelab2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Library Book List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        String[][] data = {
                {"1", "Naruto", "Masashi Kishimoto", "1999"},
                {"2", "One Piece", "Eiichiro Oda", "1997"},
                {"3", "Attack on Titan", "Hajime Isayama", "2009"},
                {"4", "Demon Slayer", "Koyoharu Gotouge", "2016"},
                {"5", "Jujutsu Kaisen", "Gege Akutami", "2018"}
        };
        String[] columns = {"Book ID", "Title", "Author", "Year"};

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        final int[] nextId = {6};

        JTextField idField = new JTextField(20);
        idField.setText(String.valueOf(nextId[0]));
        idField.setEnabled(false); // supaya user tidak bisa edit

        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField yearField = new JTextField(20);

        panel.add(new JLabel("Book ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Year:"));
        panel.add(yearField);

        JButton addButton = new JButton("Add Book");
        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(addButton);

        frame.add(panel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String year = yearField.getText();

                if (title.isEmpty() || author.isEmpty() || year.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "All fields must be filled (except ID)!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    model.addRow(new Object[]{
                            idField.getText(),
                            title,
                            author,
                            year
                    });

                    nextId[0]++;
                    idField.setText(String.valueOf(nextId[0]));

                    titleField.setText("");
                    authorField.setText("");
                    yearField.setText("");
                }
            }
        });

        frame.setVisible(true);
    }
}
