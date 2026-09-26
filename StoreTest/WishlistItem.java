/**
 * Represents a product and quantity stored
 * in a client's wishlist.
 */
public class WishlistItem {

    private Product product;
    private int quantity;

    /**
     * Creates a WishlistItem.
     *
     * @param product the product in the wishlist
     * @param quantity the desired quantity
     */
    public WishlistItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Changes the quantity of the wishlist item.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the product in the wishlist item.
     *
     * @return the Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the desired quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
