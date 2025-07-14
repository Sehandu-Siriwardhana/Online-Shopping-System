import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Westminster Shopping Manager Menu -----");
            System.out.println("1. Add a new product");
            System.out.println("2. Delete a product");
            System.out.println("3. Print product list");
            System.out.println("4. Save product list to file");
            System.out.println("5. Load product list from file");
            System.out.println("6. GUI");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter the type of product Electronic or Clothing (enter e or c)");
                    String type = scanner.nextLine();
                    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter number of products: ");
                    int numberOfItems = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();

                    if(type.equalsIgnoreCase("e")){
                        scanner.nextLine();
                        System.out.println("Enter brand: ");
                        String brand = scanner.nextLine();
                        System.out.println("Enter warranty (months): ");
                        int warranty = scanner.nextInt();
                        WestminsterShoppingManager.productList.add(new Electronics(productId,productName,numberOfItems,productPrice,brand,warranty));
                    }
                    if(type.equalsIgnoreCase("c")){
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter colour: ");
                        String color = scanner.nextLine();
                        System.out.println("Enter size: ");
                        int size = scanner.nextInt();
                        WestminsterShoppingManager.productList.add(new Clothing(productId,productName,numberOfItems,productPrice,size,color));
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to delete: ");
                    String deleteProductId = scanner.nextLine();
                    shoppingManager.deleteProduct(deleteProductId);
                    break;
                case 3:
                    shoppingManager.printProductList();
                    break;
                case 4:
                    System.out.print("Enter file name to save: ");
                    String saveFileName = scanner.nextLine();
                    shoppingManager.saveToFile(saveFileName);
                    break;
                case 5:
                    System.out.print("Enter file name to load: ");
                    String loadFileName = scanner.nextLine();
                    shoppingManager.readFromFile(loadFileName);
                    break;
                case 6:
                    System.out.print("GUI");
                    ShopGUI g1 =new ShopGUI();
                    g1.updateTableData();
                    break;
                case 0:
                    System.out.println("Exiting Westminster Shopping Manager. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}


