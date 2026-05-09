public class User {
    private String username;
    private Cart myCart;

    public User(String username) {
        this.username = username;
        this.myCart = new Cart();
    }

    public static void main(String[] args) {
        // 1. Setup User
        User customer = new User("Alex123");
        System.out.println("Welcome, " + customer.username + "!");

        // 2. Create products
        Product laptop = new Product("Gaming Laptop", 1200.00);
        Product mouse = new Product("Wireless Mouse", 25.50);
        Product keyboard = new Product("Mechanical Keyboard", 80.00);

        // 3. Add products to the user's cart
        customer.myCart.addProduct(laptop);
        customer.myCart.addProduct(mouse);
        customer.myCart.addProduct(keyboard);

        // 4. Checkout
        System.out.println();
        customer.myCart.showItems();
        double finalBill = customer.myCart.calculateTotal();
        System.out.println("Total Amount Due: $" + finalBill);
    }
}