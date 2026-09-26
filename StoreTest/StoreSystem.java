import java.util.*;

/**
 * Controls the main store operations.
 * StoreSystem manages clients, products,
 * and wishlist operations.
 */
public class StoreSystem {

    private List<Client> clients;
    private List<Product> products;
    private int nextClientID;
    private int nextProductID;

    /**
     * Creates an empty StoreSystem.
     */
    public StoreSystem() {
        clients = new ArrayList<Client>();
        products = new ArrayList<Product>();

        nextClientID = 1;
        nextProductID = 1;
    }

    /**
     * Creates and adds a new Client.
     *
     * @param name the client's name
     * @param address the client's address
     * @return the newly created Client
     */
    public Client addClient(String name, String address) {

        Client client =
                new Client(generateClientID(), name, address);

        clients.add(client);

        return client;
    }

    /**
     * Generates a unique client ID.
     *
     * @return the next client ID
     */
    public int generateClientID() {
        return nextClientID++;
    }

    /**
     * Creates and adds a new Product.
     *
     * @param name the product name
     * @param quantityInStock the quantity in stock
     * @param salePrice the sale price
     * @return the newly created Product
     */
    public Product addProduct(String name,
                              int quantityInStock,
                              double salePrice) {

        Product product =
                new Product(generateProductID(),
                        name,
                        quantityInStock,
                        salePrice);

        products.add(product);

        return product;
    }

    /**
     * Generates a unique product ID.
     *
     * @return the next product ID
     */
    public int generateProductID() {
        return nextProductID++;
    }

    /**
     * Adds a Product to a Client's wishlist.
     *
     * @param clientID the client ID
     * @param productID the product ID
     * @param quantity the desired quantity
     * @return true if successful, otherwise false
     */
    public boolean addToWishlist(int clientID,
                                 int productID,
                                 int quantity) {

        Client client = findClient(clientID);
        Product product = findProduct(productID);

        if (client == null || product == null) {
            return false;
        }

        return client.addWishlistItem(product, quantity);
    }

    /**
     * Finds a Client using its ID.
     *
     * @param clientID the client ID
     * @return the Client if found, otherwise null
     */
    public Client findClient(int clientID) {

        for (Client client : clients) {

            if (client.getClientID() == clientID) {
                return client;
            }
        }

        return null;
    }

    /**
     * Finds a Product using its ID.
     *
     * @param productID the product ID
     * @return the Product if found, otherwise null
     */
    public Product findProduct(int productID) {

        for (Product product : products) {

            if (product.getProductID() == productID) {
                return product;
            }
        }

        return null;
    }

    /**
     * Returns all clients in the system.
     *
     * @return list of Clients
     */
    public List<Client> getAllClients() {
        return clients;
    }

    /**
     * Returns all products in the system.
     *
     * @return list of Products
     */
    public List<Product> getAllProducts() {
        return products;
    }

    /**
     * Returns the wishlist belonging to a client.
     *
     * @param clientID the client ID
     * @return the client's wishlist, or null if not found
     */
    public List<WishlistItem> getWishlistItems(int clientID) {

        Client client = findClient(clientID);

        if (client == null) {
            return null;
        }

        return client.getWishlistItems();
    }
}
