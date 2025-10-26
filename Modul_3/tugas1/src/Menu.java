import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public MenuItem getMenuItem(int index) {
        if(index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public void displayMenu() {
        System.out.println("=== Daftar Menu ===");
        for(int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.println((i+1) + ". " + item.getName() + " - " + item.getPrice());
        }
    }

    public int size() {
        return items.size();
    }
}
