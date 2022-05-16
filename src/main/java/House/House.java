package House;



import EnergySeller.EnergySeller;
import Exceptions.DeviceDoesNotExistException;
import SmartDevice.*;

import java.util.*;
import java.util.List;

/** Mudar tudo
 /**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class House {

    private String ownerName;
    private String nif;
    private EnergySeller seller;
    private Map<Integer, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<Integer>> locations; // Espaço -> Lista codigo dos devices

    /**
     * Constructor for objects of class CasaInteligente
     *
     */
    public House() {
        // initialise instance variables
        this.ownerName= "";
        this.nif= "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public House(String name, String nif,EnergySeller seller) {
        // initialise instance variables
        this.ownerName=name;
        this.nif=nif;
        this.seller = new EnergySeller(seller);
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public House (House c) {
        this.ownerName=c.getOwnerName();
        this.nif=c.getNif();
        this.seller=c.getSeller();
        this.devices = c.getDevices();
        this.locations=c.getLocations();
    }

    public EnergySeller getSeller() {
        return seller;
    }

    public House clone(){
        return new House(this);
    }

    public House (String ownerName, String nif, Map<Integer, SmartDevice> devices, Map<String, List<Integer>> locations) {
        this.ownerName = ownerName;
        this.nif = nif;
        this.devices = devices;
        this.locations = locations;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setSeller(EnergySeller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "ownerName='" + ownerName + '\'' +
                ", nif='" + nif + '\'' +
                ", devices=" + devices +
                ", locations=" + locations +
                '}';
    }

    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).setOn();
    }
    public Map<Integer, SmartDevice> getDevices() {
        Map<Integer,SmartDevice> devices = new HashMap<>();
        for(Map.Entry<Integer,SmartDevice> dev : this.devices.entrySet()) {
            if(dev.getValue() != null) devices.put(dev.getKey(), dev.getValue().clone());
        }
        return devices;
    }

    public int getTotalDevices () {
        return getDevices().values().size();
    }

    public Map<String,List<Integer>> getLocations(){
     Map<String,List<Integer>> locations = new HashMap<>(this.locations);
     return locations;
    }

    public  void setLocations(Map<String,List<Integer>> loc){
        this.locations = new HashMap<>();
        for(Map.Entry<String,List<Integer>>  dev : loc.entrySet()) {
            this.locations.put(dev.getKey(), dev.getValue());
        }
    }
    public  void setDevices(Map<Integer,SmartDevice> loc){
        this.devices = new HashMap<>();
        for(Map.Entry<Integer,SmartDevice>  dev : loc.entrySet()) {
            this.devices.put(dev.getKey(), dev.getValue().clone());
        }
    }


    public String getOwnerName() {
        return ownerName;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public boolean existsDevice(String id)
    {
        return this.devices.containsKey(id);
    }

    public void addDevice(SmartDevice s)
    {
        this.devices.put(s.getId(), s);
    }
    /** Function that receives a Id and gives the device **/
    public SmartDevice getDeviceById(String s)
    {
        return this.devices.get(s);
    }


    public void setAllOn(String roomId)
    {
        for (Integer deviceId : this.locations.get(roomId))
        {
            SmartDevice dev = this.devices.get(deviceId);
            if (dev != null) dev.setOn();
        }
    }

    /** Function that adds a location to the house **/
    public void addRoom(String s)
    {
        List<Integer> rooms = new ArrayList<>();
        this.locations.put(s, rooms);
    }

    public boolean hasRoom(String s)
    {
        return this.locations.containsKey(s);
    }

    public void addToRoom (String s1, Integer s2)
    {
        List<Integer> location = this.locations.get(s1);
        location.add(s2);
    }

    public boolean roomHasDevice (String s1, int s2)
    {
        List<Integer> location = this.locations.get(s1);
        return location.contains(s2);
    }

    public void setOffOneDevice(int s) throws DeviceDoesNotExistException {
        for (Map.Entry<String,List<Integer>> entry : this.locations.entrySet())
        {
            if(entry.getValue().contains(s))
            {
               // String dev = entry.getValue().stream().filter(d -> d.equals(s)).findAny().orElse(null);
                this.devices.get(s).setOff();
                break;
            }
            else throw new DeviceDoesNotExistException("Device does not exist");
        }
    }

    public void setOnOneDevice(String s) throws DeviceDoesNotExistException {
        for (Map.Entry<String,List<Integer>> entry : this.locations.entrySet())
        {
            if(entry.getValue().contains(s))
            {
                //String dev = entry.getValue().stream().filter(d -> d.equals(s)).findAny().orElse(null);
                this.devices.get(s).setOff();
                break;
            }
            else throw new DeviceDoesNotExistException("Device does not exist");
        }
    }
}
