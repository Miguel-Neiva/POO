package House;

import Exceptions.DeviceDoesNotExistException;
import Exceptions.RoomDoesNotExistException;
import SmartDevice.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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
       // assertEquals("Device not founded");
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
        SmartSpeaker c = new SmartSpeaker("833134", SmartDevice.State.OFF,30,"RTP","Amélia");
        Map<String,SmartDevice> devices = new HashMap<>();
        Map<String,List<String>> locations = new HashMap<>();
        List<String> id = new ArrayList<>();
        id.add("132131");
        id.add("833133");
        id.add("833134");
        devices.put(a.getId(),a);
        devices.put(b.getId(),b);
        devices.put(c.getId(),c);
        locations.put("Casa",id);
        House d = new House("miguel","2324423",devices,locations);
        d.setAllOn("Casa");
        System.out.println(d.getDevices().get("833133").getState().toString());
        for(int i=0;i<4;i++){
            SmartDevice co= d.getDevices().get(i);
            if(co != null) {
                assertEquals(d.getDevices().get(i).getState(), SmartDevice.State.OFF);
                System.out.println(d.getDevices().get(i).getState());
            }
        }

    }
    @Test
    public void hasRoomTest() throws RoomDoesNotExistException {
        SmartCamera a = new SmartCamera("132131", SmartDevice.State.OFF,new SmartCamera.CameraResolution(20,30) ,20);
        //SmartCamera b = new SmartCamera("833133", SmartDevice.State.ON,30,"Tvi","Sony");
        //SmartCamera c = new SmartCamera("833134", SmartDevice.State.OFF,30,"RTP","Amélia");
        Map<String,SmartDevice> devices = new HashMap<>();
        Map<String,List<String>> locations = new HashMap<>();
        List<String> id = new ArrayList<>();
        id.add("132131");
        devices.put(a.getId(),a);
        locations.put("Casa",id);
        House d = new House("miguel","2324423",devices,locations);
        assertTrue(d.hasRoom("Casa"));
    }

    @Test
    public void setOffOneDevice () throws DeviceDoesNotExistException {
        SmartSpeaker a = new SmartSpeaker("132131", SmartDevice.State.OFF,80,"Sic","LG");
        SmartSpeaker b = new SmartSpeaker("833133", SmartDevice.State.ON,30,"Tvi","Sony");
        SmartSpeaker c = new SmartSpeaker("833134", SmartDevice.State.OFF,30,"RTP","Amélia");
        Map<String,SmartDevice> devices = new HashMap<>();
        Map<String,List<String>> locations = new HashMap<>();
        List<String> id = new ArrayList<>();
        id.add("132131");
        id.add("833133");
        id.add("833134");
        devices.put(a.getId(),a);
        devices.put(b.getId(),b);
        devices.put(c.getId(),c);
        locations.put("Casa",id);
        House d = new House("miguel","2324423",devices,locations);
        d.setOffOneDevice("833133");
        System.out.println(d.getDevices().get("833133").getState().toString());
        }
}