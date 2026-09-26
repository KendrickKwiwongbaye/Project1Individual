import java.util.*;

/**
 * Driver used to test the Client class.
 */
public class ClientTest {

    public static void main(String[] args) {

        Client c1 =
                new Client(1, "Client 1", "100 Main Street");

        Product p1 =
                new Product(1, "P1", 10, 1.00);

        Product p2 =
                new Product(2, "P2", 20, 2.00);

        System.out.println("Client Test");
        System.out.println("-----------");

        System.out.println(c1.getDetails());
        System.out.println("should show Client ID 1 and Client 1");

        System.out.println(c1.findWishlistItem(1));
        System.out.println("should be null");

        c1.addWishlistItem(p1, 5);

        WishlistItem item =
                c1.findWishlistItem(1);

        System.out.println(item.getProduct().getDetails());
        System.out.println("should show P1");

        System.out.println(item.getQuantity());
        System.out.println("should be 5");

        c1.addWishlistItem(p1, 7);

        System.out.println(
                c1.findWishlistItem(1).getQuantity());

        System.out.println("should now be 7");

        c1.addWishlistItem(p2, 3);

        List<WishlistItem> wishlist =
                c1.getWishlistItems();

        System.out.println(wishlist.size());
        System.out.println("should be 2");
    }
}
