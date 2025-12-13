import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class StyleTheme {
    public static final Color PRIMARY   = new Color(59, 130, 246);
    public static final Color DANGER    = new Color(239, 68, 68);
    public static final Color SUCCESS   = new Color(16, 185, 129);
    public static final Color BG_COLOR  = new Color(243, 244, 246);
    public static final Color WHITE     = Color.WHITE;
    public static final Color TEXT_DARK = new Color(31, 41, 55);

    public static final Font FONT_TITLE  = new Font("Segoe UI", Font.BOLD, 26);
    public static final Font FONT_HEADER = new Font("Segoe UI", Font.BOLD, 16);
    public static final Font FONT_NORMAL = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONT_BOLD   = new Font("Segoe UI", Font.BOLD, 14);

    public static void styleButton(JButton btn, Color bgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(WHITE);
        btn.setFont(FONT_BOLD);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor);
            }
        });
    }

    public static void styleField(JTextField tf) {
        tf.setFont(FONT_NORMAL);
        tf.setBackground(WHITE);
        tf.setForeground(TEXT_DARK);
        tf.setBorder(new CompoundBorder(
                new LineBorder(new Color(209, 213, 219), 1),
                new EmptyBorder(8, 10, 8, 10)
        ));
    }

    public static void setupTable(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.setFont(FONT_HEADER);
        header.setBackground(PRIMARY);
        header.setForeground(WHITE);
        header.setOpaque(true);
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        table.setRowHeight(35);
        table.setFont(FONT_NORMAL);
        table.setGridColor(new Color(229, 231, 235));
        table.setShowVerticalLines(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setHorizontalAlignment(JLabel.CENTER);

                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? WHITE : new Color(249, 250, 251));
                    c.setForeground(TEXT_DARK);
                } else {
                    c.setBackground(new Color(219, 234, 254));
                    c.setForeground(PRIMARY);
                }
                return c;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
}