package Bai_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManager {
    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product added successfully!");
    }

    public void editProduct(int id, String newName, double newPrice) {
        for (Product product : productList) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    public void deleteProduct(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product);
                System.out.println("Product deleted successfully!");
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Product List:");
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }

    public void searchProductByName(String name) {
        boolean found = false;
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found with name containing '" + name + "'.");
        }
    }

    public void sortProductsByPriceAscending() {
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Products sorted by price in ascending order.");
    }

    public void sortProductsByPriceDescending() {
        Collections.sort(productList, (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        System.out.println("Products sorted by price in descending order.");
    }
}
