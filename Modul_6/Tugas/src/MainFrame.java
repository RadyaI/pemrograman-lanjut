import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainContainer;
    private PanelHome panelHome;
    private PanelDashboard panelDashboard;

    void main() {
        initUI();
    }

    private void initUI() {
        setTitle("Tugas Split Bill GUI");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        panelHome = new PanelHome(this);
        panelDashboard = new PanelDashboard(this);

        mainContainer.add(panelHome, "HOME");
        mainContainer.add(panelDashboard, "DASHBOARD");

        add(mainContainer);
        setVisible(true);
    }

    public void bukaDashboard(String judul, double total, boolean isRata) {
        panelDashboard.setupData(judul, total, isRata);
        cardLayout.show(mainContainer, "DASHBOARD");
    }

    public void kembaliKeHome() {
        cardLayout.show(mainContainer, "HOME");
    }
}