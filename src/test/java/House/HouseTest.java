package House;

import SmartDevice.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseTest {
    enum State {
        OFF,
        ON
    }

    @Test
    public void existsDevice() {
        SmartSpeaker a = new SmartSpeaker("132131", SmartDevice.State.OFF,80,"Sic","LG");
        SmartSpeaker b = new SmartSpeaker("833133", SmartDevice.State.ON,30,"Tvi","Sony");
        List<SmartSpeaker> devices = new ArrayList<>();
        devices.add(a);
        devices.add(b);
        //assertTrue(,"Device not founded");
    }

    @Test
    public void getDeviceTest(){
        SmartSpeaker a = new SmartSpeaker("132131", SmartDevice.State.OFF,80,"Sic","LG");
        SmartSpeaker b = new SmartSpeaker("833133", SmartDevice.State.ON,30,"Tvi","Sony");
        Map<String,SmartDevice> devices = new HashMap<>();
        Map<String,List<String>> locations = new HashMap<>();
        devices.put("miguel",a);
        devices.put("Ana",b);
        House c = new House("miguel","2324423",devices,locations);
        Map<String,SmartDevice> temp =  c.getDevices();
        temp.remove("2324423");
        //System.out.println(c);
        System.out.println(temp.get("miguel").toString());
    }

    @Test
    public void setAllOnTest(){
        SmartSpeaker a = new SmartSpeaker("132131", SmartDevice.State.OFF,80,"Sic","LG");
        SmartSpeaker b = new SmartSpeaker("833133", SmartDevice.State.ON,30,"Tvi","Sony");
        SmartSpeaker c = new SmartSpeaker("833133", SmartDevice.State.OFF,30,"RTP","Amélia");
        Map<String,SmartDevice> devices = new HashMap<>();
        Map<String,List<String>> locations = new HashMap<>();
        devices.put(a.getId(),a);
        devices.put(b.getId(),b);
        House d = new House("miguel","2324423",devices,locations);
        d.setAllOn(d.getLocations().get());

    }
}