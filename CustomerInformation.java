import java.util.UUID;

class CreditCard{
    private final String CardNumber;
    private final String uuId;
    private int balance;
    public CreditCard(String CardNumber, String uuID) {
        this.CardNumber = CardNumber;
        this.uuId = uuID;
    }
    public CreditCard(String CardNumber) {
        this.CardNumber = CardNumber;
        UUID uuid = java.util.UUID.randomUUID();
        uuId = uuid.toString();
        // balance setting
        int min = 1000;
        int max = 5000;
        balance = (int)(Math.random() * (max - min) + min);
    }

    public int getBalance() {
        return balance;
    }

    public void transaction(int amount) {
        if (amount > this.balance) {
            System.out.println("Sorry Insufficient balance.");
        }
        this.balance = this.balance - amount;
        System.out.println("Your transaction is complete, your transaction amount is " + amount + "\nNow your balance is : " + getBalance());
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getUuId() {
        return uuId;
    }
}
public class CustomerInformation {
    private final String name;
    private final String address;
    private final String email;
    private final CreditCard creditCard;
    public CustomerInformation(String name, String address, String email, CreditCard creditCard) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.creditCard = creditCard;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
