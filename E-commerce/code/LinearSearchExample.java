

import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    Product(int id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }
}

public class LinearSearchExample {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "T-shirt", "Clothing"),
            new Product(203, "Headphones", "Electronics"),
            new Product(305, "Shoes", "Footwear"),
            new Product(120, "Coffee Mug", "Kitchen")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID to search: ");
        int searchId = sc.nextInt();
        sc.close();

        boolean found = false;
        for (Product p : products) {
            if (p.productId == searchId) {
                System.out.println("Product found: " + p.productName + " (" + p.category + ")");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }
}