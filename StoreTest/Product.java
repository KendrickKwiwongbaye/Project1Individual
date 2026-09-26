/**
 * Represents a product in the store system.
 */
public class Product {

    private int productID;
    private String name;
    private int quantityInStock;
    private double salePrice;

    /**
     * Creates a Product.
     *
     * @param productID the unique product ID
     * @param name the product name
     * @param quantityInStock the quantity in stock
     * @param salePrice the sale price
     */
    public Product(int productID, String name,
                   int quantityInStock, double salePrice) {
        this.productID = productID;
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.salePrice = salePrice;
    }

    /**
     * Returns the product ID.
     *
     * @return the product ID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Returns the product information.
     *
     * @return product details
     */
    public String getDetails() {
        return "Product ID: " + productID
                + ", Name: " + name
                + ", Quantity In Stock: " + quantityInStock
                + ", Sale Price: $" + salePrice;
    }
}
