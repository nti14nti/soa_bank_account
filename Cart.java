import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product p) {
        items.add(p);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public void showItems() {
        System.out.println("--- Your Cart ---");
        for (Product p : items) {
            System.out.println("- " + p.getName() + ": $" + p.getPrice());
        }
    }
}