import java.util.Arrays;
import java.util.Comparator;

// Utility class containing search algorithms for ProductItem
public class ProductSearchUtils {

    /**
     * Performs linear search to find a product by name.
     * 
     * @param productCatalog Array of ProductItem objects
     * @param searchName     Product name to search for
     * @return Index of the product if found, otherwise -1
     */
    public static int linearSearch(ProductItem[] productCatalog, String searchName) {
        for (int index = 0; index < productCatalog.length; index++) {
            if (productCatalog[index].getProductName().equalsIgnoreCase(searchName)) {
                return index; // Product found at this index
            }
        }
        return -1; // Product not found
    }

    /**
     * Performs binary search to find a product by name.
     * 
     * NOTE: Product array must be sorted by product name before calling this.
     * 
     * @param productCatalog Array of sorted ProductItem objects
     * @param searchName     Product name to search for
     * @return Index of the product if found, otherwise -1
     */
    public static int binarySearch(ProductItem[] productCatalog, String searchName) {
        int left = 0;
        int right = productCatalog.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = productCatalog[mid].getProductName().compareToIgnoreCase(searchName);

            if (comparison == 0) {
                return mid; // Product found
            } else if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Product not found
    }

    // Simple main method to test the search utilities
    public static void main(String[] args) {
        ProductItem[] productCatalog = {
                new ProductItem(1, "Laptop", "Electronics"),
                new ProductItem(2, "Phone", "Electronics"),
                new ProductItem(3, "Shoes", "Apparel"),
                new ProductItem(4, "Book", "Education")
        };

        String searchKeyword = "Phone";

        // Test Linear Search
        int linearResult = linearSearch(productCatalog, searchKeyword);
        System.out.println("Linear Search: '" + searchKeyword + "' found at index: " + linearResult);

        // Sort the product catalog for Binary Search
        Arrays.sort(productCatalog, Comparator.comparing(ProductItem::getProductName, String.CASE_INSENSITIVE_ORDER));

        // Test Binary Search
        int binaryResult = binarySearch(productCatalog, searchKeyword);
        System.out.println("Binary Search: '" + searchKeyword + "' found at index: " + binaryResult);
    }
}
