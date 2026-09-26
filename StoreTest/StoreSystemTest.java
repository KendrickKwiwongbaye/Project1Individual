import java.util.*;

/**
 * Driver used to test the StoreSystem class.
 */
public class StoreSystemTest {

    public static void main(String[] args) {

        StoreSystem store = new StoreSystem();

        System.out.println("StoreSystem Test");
        System.out.println("----------------");

        Client c1 =
                store.addClient("C1", "100 Main Street");

        Client c2 =
                store.addClient("C2", "200 Main Street");

        Client c3 =
                store.addClient("C3", "300 Main Street");

        System.out.println(c1.getDetails());
        System.out.println("should show Client ID 1");

        System.out.println(c2.getDetails());
        System.out.println("should show Client ID 2");

        System.out.println(c3.getDetails());
        System.out.println("should show Client ID 3");

        Product p1 =
                store.addProduct("P1", 10, 1.00);

        Product p2 =
                store.addProduct("P2", 20, 2.00);

        Product p3 =
                store.addProduct("P3", 30, 3.00);

        Product p4 =
                store.addProduct("P4", 40, 4.00);

        Product p5 =
                store.addProduct("P5", 50, 5.00);

        System.out.println();
        System.out.println("All Products");

        for (Product product : store.getAllProducts()) {
            System.out.println(product.getDetails());
        }

        System.out.println("should display 5 products");

        System.out.println();
        System.out.println("Add products to C1 wishlist");

        System.out.println(store.addToWishlist(1, 1, 5));
        System.out.println("should be true");

        System.out.println(store.addToWishlist(1, 3, 5));
        System.out.println("should be true");

        System.out.println(store.addToWishlist(1, 5, 5));
        System.out.println("should be true");

        System.out.println();
        System.out.println("C1 Wishlist");

        List<WishlistItem> c1Wishlist =
                store.getWishlistItems(1);

        for (WishlistItem item : c1Wishlist) {

            System.out.println(
                    item.getProduct().getDetails()
                            + ", Wishlist Quantity: "
                            + item.getQuantity());
        }

        System.out.println();
        System.out.println("Update P1 quantity");

        store.addToWishlist(1, 1, 7);

        System.out.println(
                c1.findWishlistItem(1).getQuantity());

        System.out.println("should now be 7");

        System.out.println();
        System.out.println("Find Client");

        System.out.println(
                store.findClient(2).getDetails());

        System.out.println("should show C2");

        System.out.println();
        System.out.println("Find Product");

        System.out.println(
                store.findProduct(4).getDetails());

        System.out.println("should show P4");

        System.out.println();
        System.out.println("Invalid Client");

        System.out.println(
                store.addToWishlist(99, 1, 5));

        System.out.println("should be false");

        System.out.println();
        System.out.println("Invalid Product");

        System.out.println(
                store.addToWishlist(1, 99, 5));

        System.out.println("should be false");
    }
}
