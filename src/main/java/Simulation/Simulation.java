package Simulation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import House.Bill;

import EnergySeller.EnergySeller;
import House.House;

public class Simulation {
    /* Class Variables */
    private List<EnergySeller> sellers;
    private Map<String,House> houses;
    private List<Bill> bills; // Structure with nif and respective houses;
    LocalDate currentDate;

    public Simulation (List<EnergySeller> providers, List<House> houses) {
        this.sellers = new ArrayList<>();
        for(EnergySeller e : providers) this.sellers.add(e.clone());
        this.houses = new HashMap<>();
        for(House h : houses) this.houses.put(h.getNif(), h.clone());
    }

    /* Getters/Setters */

    /* Class Methods */
    public List<Bill> simulate( LocalDate jumpTo)
    {
        List<Bill> bills = new ArrayList<>();
        long daysDifference = ChronoUnit.DAYS.between(this.currentDate, jumpTo);

        for (House house : houses.values())
        {
            Bill houseBill = new Bill();

            houseBill.setNumDevices(house.getTotalDevices());
            houseBill.setHouseOwner(house.getNif());
            houseBill.setStartDate(this.currentDate);
            houseBill.setEmissionDate(jumpTo);
            houseBill.setTotalCost(house.calculateBill(daysDifference));

            bills.add(houseBill);
        }
        return bills;
    }
        /* Common Methods */
        @Override
        public String toString()
        {
            StringBuilder result = new StringBuilder();

            result.append("Providers: \n");
            for (EnergySeller e : this.sellers)
            {
                result.append(e.getEnergySeller())
                        .append(" ")
                        .append(e.RandomTax() + e.RandomPriceKw())
                        .append("\n");
            }

            result.append("\nHouses:\n");
            for (House h : this.houses.values())
            {
                result.append(h.getOwnerName()).append(" ").append(h.getNif())
                        .append(" ").append(h.getSeller()
                                .getEnergySeller()).append(h.getSeller().RandomPriceKw() + h.getSeller().RandomTax()).append(" \n   Rooms:\n");

                }
            return result.toString();
        }
/**
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
**/
    }

