package EnergySeller;

import java.util.*;

public class EnergySeller {
    private String energySeller;
    private Double priceKw = 0.20; // -> EnergySeller and the price of the Kw
    Random rand = new Random();

    private Double tax = 0.10;


    // Empty Constructor
    public EnergySeller() {
        this.energySeller = " ";
        this.priceKw = (0.0);
        this.tax = (0.0);
    }

    @Override
    public String toString() {
        return "EnergySeller{" +
                "energySeller='" + energySeller + '\'' +
                ", priceKw=" + priceKw + ", tax=" + tax +
                '}';
    }

    public EnergySeller(String energySeller) {
        this.energySeller = energySeller;

    }

    public EnergySeller(EnergySeller seller) {
        this.energySeller = seller.getEnergySeller();

    }

    public Double getTax() {
        return this.tax;
    }

    public Double getPriceKw() {
        return priceKw;
    }


    public String getEnergySeller() {
        return energySeller;
    }

    public void setEnergySeller(String energySeller) {
        this.energySeller = energySeller;
    }


    public EnergySeller clone() {
        return new EnergySeller(this);
    }

    public double RandomTax(EnergySeller seller) {
        int r = new Random().nextInt(3);
        switch (r) {
            case 0:
                this.tax = seller.tax + 0.06;
            case 1:
                this.tax = seller.tax + 0.02;
            case 2:
                this.tax = seller.tax + 0.04;
            default:
                this.tax = seller.tax;
        }
        return seller.getTax();
    }

    public double RandomPriceKw(EnergySeller seller) {
        int r = new Random().nextInt(3);
        switch (r) {
            case 0:
                this.priceKw = seller.priceKw + 0.07;
            case 1:
                this.priceKw = seller.priceKw + 0.02;
            case 2:
                this.priceKw = seller.priceKw + 0.04;
            default:
                this.priceKw = seller.priceKw;
        }
        return seller.getPriceKw();
    }

}