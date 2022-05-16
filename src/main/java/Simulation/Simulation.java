package Simulation;

import java.time.LocalDateTime;
import java.util.Random;

import EnergySeller.EnergySeller;
import House.House;

public class Simulation {

    public enum Free {
        On,
        Off
    }

    public void InitHouse(House house,EnergySeller seller){
        Object[] devArray = house.getDevices().values().toArray();
        int r = new Random().nextInt(10);
        for(int i =0; i<r;i++ ){
            house.setDeviceOn( (String) devArray[new Random().nextInt(devArray.length)]);
        }
        house.setSeller(seller);
    }

    public double Calc(House house,EnergySeller seller){

        // falta o tempo

        InitHouse(house, seller);
        int num = house.getDevicesOn();
        double frac = seller.RandomPriceKw(seller)*seller.RandomTax(seller);

        return num * frac;
    }

}
