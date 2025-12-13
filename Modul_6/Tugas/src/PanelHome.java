import javax.swing.*;
import java.awt.*;

public class PanelHome extends JPanel {
    private MainFrame mainFrame;
    private JTextField fieldJudul;
    private JTextField fieldTotal;

    public PanelHome(MainFrame frame) {
        this.mainFrame = frame;
        setLayout(new GridBagLayout());
        setBackground(StyleTheme.BG_COLOR);

        initComponent();
    }

    private void initComponent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Aplikasi Split Bill", SwingConstants.CENTER);
        title.setFont(StyleTheme.FONT_TITLE);

        fieldJudul = new JTextField(20);
        StyleTheme.styleField(fieldJudul);
        fieldJudul.setBorder(BorderFactory.createTitledBorder("Nama Acara"));

        fieldTotal = new JTextField(20);
        StyleTheme.styleField(fieldTotal);
        fieldTotal.setBorder(BorderFactory.createTitledBorder("Total Tagihan (Rp)"));

        JButton btnRata = new JButton("Mode: Bagi Rata");
        StyleTheme.styleButton(btnRata, StyleTheme.PRIMARY);

        JButton btnPorsi = new JButton("Mode: Sesuai Porsi");
        StyleTheme.styleButton(btnPorsi, StyleTheme.SUCCESS);

        btnRata.addActionListener(e -> prosesLanjut(true));
        btnPorsi.addActionListener(e -> prosesLanjut(false));

        gbc.gridx = 0;
        gbc.gridy = 0; add(title, gbc);
        gbc.gridy = 1; add(fieldJudul, gbc);
        gbc.gridy = 2; add(fieldTotal, gbc);
        gbc.gridy = 3; add(btnRata, gbc);
        gbc.gridy = 4; add(btnPorsi, gbc);
    }

    private void prosesLanjut(boolean isBagiRata) {
        String judul = fieldJudul.getText();
        String totalStr = fieldTotal.getText();

        if (judul.isEmpty() || totalStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mohon isi semua data!");
            return;
        }

        try {
            double total = Double.parseDouble(totalStr);
            mainFrame.bukaDashboard(judul, total, isBagiRata);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total harus angka!");
        }
    }
}