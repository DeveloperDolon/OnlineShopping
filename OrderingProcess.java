
import java.util.List;
import java.util.Scanner;

public class OrderingProcess {
    private CreditCard creditCard;
    private List<Products> products;
    private final Scanner input = new Scanner(System.in);
    public OrderingProcess(List<Products> products, CreditCard creditCard) {
        this.products = products;
        this.creditCard = creditCard;
    }
    private int totalAmount() {
        int total = 0;
        for (Products product : products) {
            total += product.priceForThisOne();
        }
        return total;
    }
    public void makePayment() {
        if (totalAmount() > creditCard.getBalance()) {
            System.out.println("Sorry brother your hava insufficient balance.");
        }else if (totalAmount() <= creditCard.getBalance()) {
            System.out.println("Your balance is : " + creditCard.getBalance());
            creditCard.transaction(totalAmount());
            System.out.println("Your order is successful.");
        }
    }
}
