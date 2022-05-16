package EnergySeller;

import SmartDevice.SmartDevice;
import org.apache.groovy.util.concurrent.concurrentlinkedhashmap.EntryWeigher;

import java.util.*;
import java.util.random.RandomGenerator;

public class EnergySeller {
    private String energySeller;
    private Double priceKw; // -> EnergySeller and the price of the Kw
    Random rand = new Random();

    private Double tax=0.10;


    // Empty Constructor
    public EnergySeller () {
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
        this.priceKw = sellerPrice();
        this.tax=sellerTax();
    }

    public EnergySeller(EnergySeller seller) {
        this.energySeller = seller.getEnergySeller();
        this.priceKw=seller.getPriceKw();
        this.tax=seller.getTax();
    }

    public Double getTax() {
        return tax;
    }

    public Double getPriceKw() {
        return priceKw;
    }

    public Double sellerPrice () {
        Random price = new Random();
        double number;
        number= price.nextDouble(6);
        return number;
    }

    public Double sellerTax () {
        Random price = new Random();
        double number;
        number= price.nextDouble(3);
        return number;
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

}