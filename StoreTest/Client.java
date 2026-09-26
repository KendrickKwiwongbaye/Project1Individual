import java.util.*;

/**
 * Represents a client in the store system.
 */
public class Client {

    private int clientID;
    private String name;
    private String address;
    private List<WishlistItem> wishlistItems;

    /**
     * Creates a Client.
     *
     * @param clientID the unique client ID
     * @param name the client's name
     * @param address the client's address
     */
    public Client(int clientID, String name, String address) {
        this.clientID = clientID;
        this.name = name;
        this.address = address;
        wishlistItems = new ArrayList<WishlistItem>();
    }

    /**
     * Returns the client ID.
     *
     * @return the client ID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Searches the client's wishlist for a product.
     *
     * @param productID the product ID
     * @return the WishlistItem if found, otherwise null
     */
    public WishlistItem findWishlistItem(int productID) {

        for (WishlistItem item : wishlistItems) {

            if (item.getProduct().getProductID() == productID) {
                return item;
            }
        }

        return null;
    }

    /**
     * Adds a product to the client's wishlist.
     * If the product already exists, the quantity is updated.
     *
     * @param product the product being added
     * @param quantity the desired quantity
     * @return true when the operation is completed
     */
    public boolean addWishlistItem(Product product, int quantity) {

        WishlistItem item =
                findWishlistItem(product.getProductID());

        if (item == null) {
            wishlistItems.add(
                    new WishlistItem(product, quantity));
        } else {
            item.setQuantity(quantity);
        }

        return true;
    }

    /**
     * Returns all wishlist items belonging to the client.
     *
     * @return the client's wishlist
     */
    public List<WishlistItem> getWishlistItems() {
        return wishlistItems;
    }

    /**
     * Returns the client's stored information.
     *
     * @return client details
     */
    public String getDetails() {
        return "Client ID: " + clientID
                + ", Name: " + name
                + ", Address: " + address;
    }
}
