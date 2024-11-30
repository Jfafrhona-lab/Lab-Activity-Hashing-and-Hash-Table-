import java.util.Hashtable;
import java.util.Scanner;

public class ProductPriceManager {
    public static void main(String[] args) {
        // Create a hash table to store product names and prices
        Hashtable<String, Double> productPrices = new Hashtable<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Product Price Manager ---");
            System.out.println("1. Add or Update Product Price");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product Price");
            System.out.println("4. Remove Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double productPrice = scanner.nextDouble();
                    productPrices.put(productName, productPrice);
                    System.out.println("Product added/updated successfully!");
                    break;

                case 2:
                    System.out.println("\nAll Products and Prices:");
                    productPrices.forEach((key, value) -> 
                        System.out.println("Product: " + key + " - Price: $" + value));
                    break;

                case 3:
                    System.out.print("Enter Product Name to search: ");
                    String searchProduct = scanner.nextLine();
                    if (productPrices.containsKey(searchProduct)) {
                        System.out.println("Price of " + searchProduct + ": $" + productPrices.get(searchProduct));
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product Name to remove: ");
                    String removeProduct = scanner.nextLine();
                    if (productPrices.remove(removeProduct) != null) {
                        System.out.println("Product removed successfully!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
          }
        }
    }