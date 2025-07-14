public interface ShoppingManager {
    void addProduct(Product product);

    void deleteProduct(String productId);

    void printProductList();

    void saveToFile(String fileName);

    void readFromFile(String fileName);
}
