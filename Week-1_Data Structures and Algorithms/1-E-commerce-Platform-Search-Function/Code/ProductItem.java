// Class representing a product item in the e-commerce application
public class ProductItem {

    // Private fields representing product details
    private int productId;
    private String productName;
    private String productCategory;

    // Constructor to initialize ProductItem object
    public ProductItem(int productId, String productName, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
    }

    // Getter for product ID
    public int getProductId() {
        return productId;
    }

    // Getter for product name
    public String getProductName() {
        return productName;
    }

    // Getter for product category
    public String getProductCategory() {
        return productCategory;
    }

    // Main method for basic testing
    public static void main(String[] args) {
        ProductItem sampleProduct = new ProductItem(1, "Laptop", "Electronics");
        System.out.println("Product ID: " + sampleProduct.getProductId());
        System.out.println("Product Name: " + sampleProduct.getProductName());
        System.out.println("Product Category: " + sampleProduct.getProductCategory());
    }
}
