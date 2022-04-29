package Casa;



import SmartDevice.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
/** Mudar tudo
 /**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Casa {

    private String morada;
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices

    /**
     * Constructor for objects of class CasaInteligente
     *
     */
    public Casa() {
        // initialise instance variables
        this.morada = "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public Casa(String morada) {
        // initialise instance variables
        this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }


    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).setOn();
    }

    public boolean existsDevice(String id)
    {
        return this.devices.containsKey(id);
    }

    public void addDevice(SmartDevice s)
    {
        this.devices.put(s.getId(), s);
    }

    public SmartDevice getDevice(String s)
    {
        return this.devices.get(s);
    }

    public void setOn(String s, boolean b)
    {
        SmartDevice dev = getDevice(s);
        dev.setOn();
    }

    public void setAllOn(String id)
    {
        this.devices.values().forEach(device -> device.setOn());
    }
   /** Funções da casa  Neiva deixa te de Merdas */
    // Map<String, List<String>>
    public void addRoom(String s)
    {
        List<String> rooms = new ArrayList<String>();
        this.locations.put(s, rooms);
    }

    public boolean hasRoom(String s)
    {
        return this.locations.containsKey(s);
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

}
