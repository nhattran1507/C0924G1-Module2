package Bai_16;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {
    private final String filePath;
    public ProductFileManager(String filePath) {
        this.filePath = filePath;
    }
    public List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            products = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file" + e.getMessage());
        }
        return products;
    }
    public void writeProducts(List<Product> products) {
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("Error writing file" + e.getMessage());
        }
    }
}
