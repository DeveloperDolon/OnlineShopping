import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProcessingForShopping {
    private static CartAndWishList cartAndWishList;
    private CustomerInformation customerInformation;
    private CreditCard creditCard;
    private final Scanner input = new Scanner(System.in);
    public static int ForTakingPersonInformation = 1;

    public ProcessingForShopping() {
        cartAndWishList = new CartAndWishList();;
    }

    public void informationInput() {
        System.out.print("Enter your name : ");
        String name = input.nextLine();
        System.out.print("Enter your email address : ");
        String email = input.nextLine();
        System.out.print("Enter your address : ");
        String address = input.nextLine();
        System.out.print("Enter your credit care name : ");
        String cardName = input.nextLine();
        creditCard = new CreditCard(cardName);
        customerInformation = new CustomerInformation(name, email, address, creditCard);
    }
    public void seeProductList(List<Products> products) {
        if (ForTakingPersonInformation == 1) {
            informationInput();
            ForTakingPersonInformation++;
        }

        System.out.println("All product list : ");
        int index = 0;
        for (Products product : products) {
            System.out.println("Name : " + product.getName() + ", Price : " + product.getPrice() + " Number of product is : " + index);

            if (index == (products.size() - 1)) {
                System.out.println("Go to Main Menu : " + products.size());
            }

            index++;
        }


        int ind;
        do {
            System.out.print("Enter index number of product to add cart and wishlist : ");
            ind = input.nextInt();
            if (ind == products.size()) {
                System.out.println("");
            }else if (ind < products.size() && ind >= 0) {
                processForAddingProduct(products.get(ind));
            }else {
                System.out.println("Your index number is invalid.");
            }

        }while (!(ind <= products.size() && ind >= 0));

    }
    private void processForAddingProduct(Products product) {
        System.out.print("Do you have any coupon for discount on this product! " +
                "\ntype (yes) to input coupon or type no for nothing : ");

        String condition = input.next();
        if (condition.equalsIgnoreCase("Yes")) {
            System.out.print("Now enter your coupon code : ");
            String st = input.nextLine();
            product.setCoupon(st);
        }else {
            System.out.println("You had no discount.");
        }

        int choice;
        do{
            System.out.print("Type 1 for add wish list or type 2 for add cart list : ");
            choice = input.nextInt();
            if (choice == 1){
                cartAndWishList.addToWishList(product);
            }else if (choice == 2){
                cartAndWishList.addToCartList(product);
            }else {
                System.out.println("Sorry your input is invalid.");
            }
        }while(choice != 1 && choice != 2);
        System.out.println(product.getName() + " is added to " + ((choice == 1) ? "wish list" : "cart list"));
    }
    public void seeCartList() {
        if(cartAndWishList.getCartList().size() > 0) {
            System.out.println("Your cart list is : ");
            for (Products product: cartAndWishList.getCartList()) {
                System.out.println(product.getName());
            }

            System.out.println("Options : ");
            System.out.println("1 - Order now");
            System.out.println("2 - exit");
            System.out.print("Choice : " );
            int a = input.nextInt();

            if (a == 1) {
                OrderingProcess orderingProcess = new OrderingProcess(cartAndWishList.getCartList(), creditCard);
                orderingProcess.makePayment();
                cartAndWishList.resetCartList();
            } else {
                System.out.println("Exited");
            }
        }else {
            System.out.println("Your cart list is empty!!");
        }
    }
    public void seeWishList() {
        if (cartAndWishList.getWishList().size() > 0){
            System.out.println("Your wish list is : ");
            for (Products product : cartAndWishList.getWishList()) {
                System.out.println(product.getName());
            }
        }else {
            System.out.println("Your wish list is empty!!");
        }
    }
}
