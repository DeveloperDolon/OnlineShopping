import java.util.ArrayList;
import java.util.List;

public class CartAndWishList {
    private List<Products> wishList = new ArrayList<>();
    private List<Products> cartList = new ArrayList<>();

    public void addToWishList(Products product) {
        wishList.add(product);
    }
    public void addToCartList(Products product) {
        cartList.add(product);
    }
    public void resetCartList() {
        cartList = new ArrayList<>();
    }
    public void resetWishList() {
        wishList = new ArrayList<>();
    }

    public List<Products> getWishList() {
        return wishList;
    }

    public List<Products> getCartList() {
        return cartList;
    }
}
