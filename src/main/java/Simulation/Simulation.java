package Simulation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Controller.DataBase;
import House.Bill;
import House.House;

public class Simulation {
    /* Class Variables */
    private DataBase database;
    private List<Bill> bills; // Structure with nif and respective houses;
    private LocalDate currentDate;

    public Simulation(DataBase database) {
        this.database = database;
        this.bills = new ArrayList<>();
        currentDate = LocalDate.now();
    }

    /* Getters/Setters */

    /* Class Methods */
    public void simulate(long days) {
        List<House> houses = database.getHouses();
        // long daysDifference = ChronoUnit.DAYS.between(this.currentDate, jumpTo);

        for (House house : houses) {

            bills.add(
                    new Bill(house.calculateBill(days), house.calculateBill(days), this.currentDate.plusDays(days),
                            this.currentDate,
                            house.getOwnerName()));

        }
        this.currentDate = this.currentDate.plusDays(days);
    }

    /* Common Methods */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Bill bill : bills) {
            result.append(bill.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * public enum Free {
     * On,
     * Off
     * }
     * 
     * public void InitHouse(House house,EnergySeller seller){
     * Object[] devArray = house.getDevices().values().toArray();
     * int r = new Random().nextInt(10);
     * for(int i =0; i<r;i++ ){
     * house.setDeviceOn( (String) devArray[new Random().nextInt(devArray.length)]);
     * }
     * house.setSeller(seller);
     * }
     * 
     * public double Calc(House house,EnergySeller seller){
     * 
     * // falta o tempo
     * 
     * InitHouse(house, seller);
     * int num = house.getDevicesOn();
     * double frac = seller.RandomPriceKw(seller)*seller.RandomTax(seller);
     * 
     * return num * frac;
     * }
     **/
}
