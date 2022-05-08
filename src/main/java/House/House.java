package House;



import Exceptions.DeviceDoesNotExistException;
import Exceptions.RoomDoesNotExistException;
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
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices

    /**
     * Constructor for objects of class CasaInteligente
     
     */
    public House() {
        // initialise instance variables
        this.ownerName= "";
        this.nif= "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public House(String name, String nif) {
        // initialise instance variables
        this.ownerName=name;
        this.nif=nif;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public House (House c) {
        this.ownerName=c.getOwnerName();
        this.nif=c.getNif();
        this.devices = c.getDevices();
        this.locations=c.getLocations();
    }

    public House clone(){
        return new House(this);
    }

    public House (String ownerName, String nif, Map<String, SmartDevice> devices, Map<String, List<String>> locations) {
        this.ownerName = ownerName;
        this.nif = nif;
        this.devices = devices;
        this.locations = locations;
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
    public Map<String, SmartDevice> getDevices() {
        Map<String,SmartDevice> devices = new HashMap<>();
        for(Map.Entry<String,SmartDevice> dev : this.devices.entrySet()) {
            if(dev.getValue() != null) devices.put(dev.getKey(), dev.getValue());
        }
        return devices;
    }
    public Map<String,List<String>> getLocations(){
     Map<String,List<String>> locations = new HashMap<>();
     locations.putAll(this.locations);
     return locations;
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
   /* public SmartDevice getDeviceById(String s)
    {
        this.devices.get(s);
    }
*/
    /** Function that receives a House location and set all the device.s to On **/
    public void setAllOn(String roomId)
    {
        for (String deviceId : this.locations.get(roomId))
        {
            SmartDevice dev = this.devices.get(deviceId);
            if (dev != null) dev.setOn();
        }
    }

    public void setAllOff(String roomId)
    {
        for(String deviceId: this.locations.get(roomId))
        {
            SmartDevice dev = this.devices.get(deviceId);
            if(dev != null) dev.setOff();
        }
    }

    /** Function that adds a location to the house **/
    public void addRoom(String s)
    {
        List<String> rooms = new ArrayList<String>();
        this.locations.put(s, rooms);
    }

    public boolean hasRoom (String s) throws RoomDoesNotExistException
    {
        if (!this.locations.containsKey(s)) throw new RoomDoesNotExistException ("Room was not founded");
        else return this.locations.containsKey(s) ;
    }

    public void addToRoom (String s1, String s2)
    {
        List<String> location = this.locations.get(s1);
        location.add(s2);
    }

    public boolean roomHasDevice (String s1, String s2)
    {
        List<String> location = this.locations.get(s1);
        return location.contains(s2);
    }



    public void setOffOneDevice(String s) throws DeviceDoesNotExistException {
        for (Map.entry(): this.locations.entrySet())
        {
            for(List<String> str : this.locations.values()) {
                if(str.equals(s)) { this.locations.get(dev).stream().findFirst().
                }

            }
        }
    }
}
