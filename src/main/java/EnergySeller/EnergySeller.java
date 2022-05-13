package EnergySeller;

import SmartDevice.SmartDevice;
import org.apache.groovy.util.concurrent.concurrentlinkedhashmap.EntryWeigher;

import java.util.*;
import java.util.random.RandomGenerator;

public class EnergySeller {
    private String energySeller;
    private Double kwDay;
    private Map<String,Double> sellers;

    public EnergySeller () {
        this.energySeller = " ";
        this.kwDay = 0.0;
        this.sellers = new HashMap<>();
    }

    public EnergySeller(String energySeller, Double kwDay, Map<String,Double> sellers) {
        this.energySeller = energySeller;
        this.kwDay = kwDay;
        this.sellers = new HashMap<>(sellers);
    }

    public EnergySeller(EnergySeller seller) {
        this.energySeller = seller.getEnergySeller();
        this.kwDay= seller.getKwDay();
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

    public Double getKwDay() {
        return kwDay;
    }

    public void setKwDay(Double kwDay) {
        this.kwDay = kwDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnergySeller that = (EnergySeller) o;
        return Objects.equals(energySeller, that.energySeller) && Objects.equals(kwDay, that.kwDay) && Objects.equals(sellers, that.sellers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(energySeller, kwDay, sellers);
    }

    public EnergySeller clone() {
        return new EnergySeller(this);
    }

}
