package son.dev.recyclerviewapp.model;

public class Product {
    public String thumbnail;
    public String name;
    public int quantity;

    public double price;

    public Product(String thumbnail, String name, int quantity, double price) {
        this.thumbnail = thumbnail;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
