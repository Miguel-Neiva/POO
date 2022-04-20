package SmartDevice;


import java.io.Serializable;


public abstract class SmartDevice implements Comparable<SmartDevice>, Serializable {
    private String id;
    private State state;


    enum State {
        OFF,
        ON
    }

    /** The "empty" constructor creates a (useless) Device, with no information whatsoever.  */
    public SmartDevice () {
        this.state = State.OFF;
        this.id = "No Device given";
    }


    public SmartDevice (String id) {
        this.state = State.OFF;
    }
    /** The "Sub-Standard" constructor creates a (useful) device,
     * given all it's attributes and its subbed off status. */
    public SmartDevice (String id, State state) {
        this.id = id;
        this.state = state;
    }

    public SmartDevice (SmartDevice device) {
        this.state = device.getState();
        this.id = device.getId();
    }

    public String getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public void setOn() {
        this.state = State.ON; }

    public void setOff() {
        this.state = State.OFF;}

    public void setState() {
        this.state = state;
    }
    /** Basic equals method - Same id implies same device */
    public boolean equals(Object obj){
        if (this == obj) return true;

        if ((obj == null)) return false;

        SmartDevice p = (SmartDevice) obj;
        return this.id.equals(p.getId());
    }
    /** The number that represents a position */
    public abstract Integer representedBy();

    public int compareTo(SmartDevice otherDevices) {
        return Integer.compare(representedBy(), otherDevices.representedBy());
    }


}
