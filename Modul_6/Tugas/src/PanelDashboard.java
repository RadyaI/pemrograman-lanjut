import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelDashboard extends JPanel {
    private MainFrame mainFrame;
    private DefaultTableModel tableModel;
    private JTable table;
    private JLabel labelInfo;

    private double totalTagihan;
    private String namaAcara;

    public PanelDashboard(MainFrame frame) {
        this.mainFrame = frame;
        setLayout(new BorderLayout());
        setBackground(StyleTheme.WHITE);

        initHeader();
        initTable();
        initButtons();
    }

    public void setupData(String judul, double total, boolean isBagiRata) {
        this.namaAcara = judul;
        this.totalTagihan = total;

        tableModel.setRowCount(0);

        if (isBagiRata) {
            String input = JOptionPane.showInputDialog(this, "Masukkan Jumlah Orang:");
            if (input != null && !input.isEmpty()) {
                try {
                    int qty = Integer.parseInt(input);
                    double perOrang = total / qty;
                    for (int i = 1; i <= qty; i++) {
                        tableModel.addRow(new Object[]{"Orang " + i, String.format("%.0f", perOrang)});
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Input salah!");
                }
            }
        }
        updateStatus();
    }

    private void initHeader() {
        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBackground(StyleTheme.PRIMARY);
        header.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel("Daftar Peserta", SwingConstants.CENTER);
        title.setFont(StyleTheme.FONT_TITLE);
        title.setForeground(Color.WHITE);

        labelInfo = new JLabel("Waiting...", SwingConstants.CENTER);
        labelInfo.setForeground(Color.WHITE);
        labelInfo.setFont(StyleTheme.FONT_BOLD);

        header.add(title);
        header.add(labelInfo);
        add(header, BorderLayout.NORTH);
    }

    private void initTable() {
        String[] col = {"Nama Peserta", "Nominal (Rp)"};

        tableModel = new DefaultTableModel(col, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);

        StyleTheme.setupTable(table);

        JScrollPane sp = new JScrollPane(table);
        sp.setBorder(BorderFactory.createEmptyBorder()); 
        sp.getViewport().setBackground(Color.WHITE);

        add(sp, BorderLayout.CENTER);
    }

    private void initButtons() {
        JPanel panelBtn = new JPanel();

        JButton btnAdd = new JButton("Tambah (+)");
        JButton btnEdit = new JButton("Edit");
        JButton btnDel = new JButton("Hapus");
        JButton btnBack = new JButton("Kembali");

        StyleTheme.styleButton(btnAdd, StyleTheme.SUCCESS);
        StyleTheme.styleButton(btnEdit, StyleTheme.PRIMARY);
        StyleTheme.styleButton(btnDel, StyleTheme.DANGER);
        StyleTheme.styleButton(btnBack, Color.GRAY);

        btnAdd.addActionListener(e -> {
            String nama = JOptionPane.showInputDialog("Nama:");
            String nominal = JOptionPane.showInputDialog("Nominal:");
            if (nama != null && nominal != null) {
                tableModel.addRow(new Object[]{nama, nominal});
                updateStatus();
            }
        });

        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                String oldN = (String) tableModel.getValueAt(row, 0);
                String oldNom = (String) tableModel.getValueAt(row, 1);
                String newN = JOptionPane.showInputDialog("Edit Nama:", oldN);
                String newNom = JOptionPane.showInputDialog("Edit Nominal:", oldNom);
                if (newN != null) {
                    tableModel.setValueAt(newN, row, 0);
                    tableModel.setValueAt(newNom, row, 1);
                    updateStatus();
                }
            }
        });

        btnDel.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                tableModel.removeRow(row);
                updateStatus();
            }
        });

        btnBack.addActionListener(e -> mainFrame.kembaliKeHome());

        panelBtn.add(btnAdd);
        panelBtn.add(btnEdit);
        panelBtn.add(btnDel);
        panelBtn.add(btnBack);

        add(panelBtn, BorderLayout.SOUTH);
    }

    private void updateStatus() {
        double totalTabel = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            try {
                String s = tableModel.getValueAt(i, 1).toString();
                totalTabel += Double.parseDouble(s);
            } catch (Exception e) {}
        }

        double sisa = totalTagihan - totalTabel;
        String statText = (sisa == 0) ? "PAS (LUNAS)" : (sisa > 0 ? "Kurang: " + sisa : "Lebih: " + Math.abs(sisa));
        labelInfo.setText(String.format("Acara: %s | Tagihan: %.0f | %s", namaAcara, totalTagihan, statText));
    }
}