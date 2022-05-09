package SmartDevice;

import java.util.Objects;

public class SmartBulb extends SmartDevice{
    private double dimension;
    private double consumption;
    private Tonality ton;

    enum Tonality {
        Neutral,
        Warm,
        Cold
    }
    public SmartBulb() {
        super();
        this.consumption = 0;
        this.consumption = 0;
        this.ton= Tonality.Neutral;
    }
    public SmartBulb(String id, State state, Double dimension, double consumption, Tonality ton) {
        super();
        this.dimension = dimension;
        this.consumption = consumption;
        this.ton = ton;
    }

    public SmartBulb(SmartBulb bulb) {
        super();
        this.dimension = bulb.getDimension();
        this.consumption = bulb.getConsumption();
        this.ton = bulb.getTon();
    }

    public double getDimension() {
        return dimension;
    }

    public Tonality getTon() {
        return ton;
    }

    public void setTon(Tonality ton) {
        this.ton = ton;
    }

    public double getConsumption() {
        return consumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartBulb smartBulb = (SmartBulb) o;
        return Double.compare(smartBulb.dimension, dimension) == 0 && Double.compare(smartBulb.consumption, consumption) == 0 && ton == smartBulb.ton;
    }



    /** The number that represents a position */
    public Integer representedBy() {
        return 2;
    }
}