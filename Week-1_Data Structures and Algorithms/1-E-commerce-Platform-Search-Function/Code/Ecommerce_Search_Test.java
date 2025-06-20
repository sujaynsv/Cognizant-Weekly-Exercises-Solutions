import java.util.Arrays;
import java.util.Comparator;

// Main class to test Ecommerce search functionality
public class Ecommerce_Search_Test {
    public static void main(String[] args) {

        // Initialize product catalog
        Product[] productCatalog = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Shirt", "Clothing"),
                new Product(3, "Book", "Books"),
                new Product(4, "Phone", "Electronics"),
                new Product(5, "Shoes", "Footwear")
        };

        // Product name to search
        String searchKeyword = "Phone";

        // Perform Linear Search
        int linearSearchResult = SearchAlgorithms.linearSearch(productCatalog, searchKeyword);
        System.out.println("Linear Search: '" + searchKeyword + "' found at index: " + linearSearchResult);

        // Sort products alphabetically by name for Binary Search
        Arrays.sort(productCatalog, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        // Perform Binary Search
        int binarySearchResult = SearchAlgorithms.binarySearch(productCatalog, searchKeyword);
        System.out.println("Binary Search: '" + searchKeyword + "' found at index: " + binarySearchResult);

        // Display the sorted product list
        System.out.println("\nSorted Product List:");
        for (Product product : productCatalog) {
            System.out.println(product.getProductName());
        }
    }
}
