public class Clothing extends Product {
    private int size;
    private String color;

    public Clothing(String productId, String productName, int availableItems, double price, int size, String color) {
        super(productId, productName, availableItems, price);
        this.size = size;
        this.color = color;
    }

    // Getters and setters for Clothing specific attributes
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String productCatergory(){
        return "Clothing";
    }

    // Add any other methods or attributes as needed

    @Override
    public String toString() {
        return "Clothing: " +
                "size:'" + size + '\'' +
                ", color:'" + color + '\'' ;
    }
}
