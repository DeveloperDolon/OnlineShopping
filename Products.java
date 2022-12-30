public abstract class Products {
    public static final String DISCOUNT_1DL = "DCL-127KL";
    public static final String DISCOUNT_2DL = "DCL-23K2D";
    private String name;
    private int price;

    public Products(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public int priceForThisOne(){
        return 0;
    }
    public String getName() {
        return name;
    }
    public void setCoupon(String coupon) {

    }

    public int getPrice() {
        return price;
    }
}

class NonDigitalProduct extends Products {
    private String coupon = "";
    private int weight;
    private int length;
    private final int shippingRate = 5;
    public NonDigitalProduct(String name, int price, int weight, int length) {
        super(name, price);
        this.weight = weight;
        this.length = length;
    }
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
    @Override
    public int priceForThisOne(){
        int discount = 0;
        if (this.coupon.equals(DISCOUNT_1DL)) {
            discount = 10;
        }else if (this.coupon.equals(DISCOUNT_2DL)) {
            discount = 5;
        }
        int math = 0;
        if (discount > 0) {
            math = (super.getPrice() + this.getShippingCharge()) / 10;
        }

        return (super.getPrice() + this.getShippingCharge()) - math;
    }

    private int getShippingCharge() {
        return (weight * length) * shippingRate;
    }

    @Override
    public String toString() {
        return "Product{name: " + super.getName() + ", price: " + (super.getPrice() + getShippingCharge());
    }
}

class DigitalProduct extends Products{
    private String coupon = "";
    public DigitalProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public int priceForThisOne() {
        int discount = 0;
        if (this.coupon.equals(DISCOUNT_1DL)) {
            discount = 10;
        }else if (this.coupon.equals(DISCOUNT_2DL)) {
            discount = 5;
        }

        int sum = 0;
        if (discount > 0) {
            sum = super.getPrice() / discount;
        }

        return super.getPrice() - sum;
    }
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
    @Override
    public String toString() {
        return "Product{name: " + super.getName() + ", price: " + super.getPrice();
    }
}
