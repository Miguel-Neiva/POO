package EnergySeller;

import SmartDevice.SmartDevice;
import org.apache.groovy.util.concurrent.concurrentlinkedhashmap.EntryWeigher;

import java.util.*;
import java.util.random.RandomGenerator;

public class EnergySeller {
    private String energySeller;
    private Map<String,Double> sellers; // -> EnergySeller and the price of the Kw
    // Empty Constructor
    public EnergySeller () {
        this.energySeller = " ";
        this.sellers = new HashMap<>();
    }

    @Override
    public String toString() {
        return "EnergySeller{" +
                "energySeller='" + energySeller + '\'' +
                ", sellers=" + sellers +
                '}';
    }

    public EnergySeller(String energySeller, Map<String,Double> sellers) {
        this.energySeller = energySeller;
        this.sellers = new HashMap<>(sellers);
    }

    public EnergySeller(EnergySeller seller) {
        this.energySeller = seller.getEnergySeller();
        this.sellers = seller.getSellers();
    }
    public Map<String, Double> getSellers() {
        Map<String,Double> devices = new HashMap<>();
        for(Map.Entry<String,Double> dev : this.sellers.entrySet()) {
            if(dev.getValue() != null) devices.put(dev.getKey(), dev.getValue());
        }
        return sellers;
    }

    public Double getSellerConsumption(String s) {
        if(!this.sellers.containsKey(s)) {
            List<String> sellers = new ArrayList<String>();
            this.sellers.put(s,sellerPrice());
            return this.sellers.get(s);
        }
        return this.sellers.get(s);
    }

    public Double sellerPrice () {
        Random price = new Random();
        double number;
        number= price.nextDouble(6);
        return number;
    }
    public String getEnergySeller() {
        return energySeller;
    }

    public void setEnergySeller(String energySeller) {
        this.energySeller = energySeller;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnergySeller that = (EnergySeller) o;
        return Objects.equals(energySeller, that.energySeller) &&  Objects.equals(sellers, that.sellers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(energySeller,sellers);
    }

    public EnergySeller clone() {
        return new EnergySeller(this);
    }

}
