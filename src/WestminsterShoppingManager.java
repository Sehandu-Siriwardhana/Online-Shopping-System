import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WestminsterShoppingManager implements ShoppingManager {
    public static List<Product> productList = new ArrayList<>();


    @Override
    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product added successfully!");
    }

    @Override
    public void deleteProduct(String productId) {
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                productList.remove(product);
                System.out.println("Product deleted successfully!");
                return;
            }
        }
        System.out.println("Product not found with ID: " + productId);
    }

    @Override
    public void printProductList() {
        Collections.sort(productList);
        System.out.println("Product List:");
        for (Product product : productList) {
            System.out.println("Product Name: "+product.getProductName()+" "+product);
        }
    }

    @Override
    public void saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : productList) {
                writer.write(product.getId() + "," + product.getPrice() + "," + product.getAvailableItems());
                writer.newLine();
            }
            System.out.println("Products saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line contains the whole product info in a single string
                System.out.println(line);
            }
            System.out.println("Products loaded from file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProductList() {
        return productList;
    }
}

