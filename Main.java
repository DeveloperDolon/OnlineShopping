import java.util.*;

public class Main {
    private List<Products> products;
    private static ProcessingForShopping processingForShopping = new ProcessingForShopping();
    private void setProducts() {
        products = Arrays.asList(
                new DigitalProduct("Computer games", 500),
                new DigitalProduct("PhotoShop" , 1003),
                new NonDigitalProduct("Java Book", 345, 10, 5 ),
                new NonDigitalProduct("Mobile", 10600, 2, 3)
        );
    }
    public static void start() {
        Main main = new Main();
        main.setProducts();
        Scanner input = new Scanner(System.in);

        System.out.println(">>>>>>>> Dolon Roy Shopping System <<<<<<<<");
        System.out.println("Options : ");
        System.out.println("1 - See Product list");
        System.out.println("2 - See Cart list");
        System.out.println("3 - See Wish list");
        System.out.println("4 - Exit");
        int choice = input.nextInt();

       switch (choice) {
           case 1:
               processingForShopping.seeProductList(main.products);
               start();
               break;
           case 2:
               processingForShopping.seeCartList();
               start();
               break;
           case 3:
               processingForShopping.seeWishList();
               start();
               break;
           case 4:
               System.out.println("Program finished!");
               break;
           default:
               System.out.println("Your input number is invalid!");
               start();
               break;
       }
    }
    public static void main(String[] args) {
       start();
    }
}