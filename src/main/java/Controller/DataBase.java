package Controller;

import EnergySeller.EnergySeller;
import House.House;
import SmartDevice.SmartDevice;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataBase implements Serializable {
    List<House> house;
    List<EnergySeller> seller;
    // Constructors

    /**
     * The "empty" constructor creates a new database whit no info.
     */
    public DataBase() {
        this.house = new ArrayList<>();
    }

    /**
     * The "parametric" constructor creates a database, given another the parameters.
     */
    public DataBase(List<House> house, List<EnergySeller> seller) {

        this.house = new ArrayList<>(house);
        this.seller = new ArrayList<>(seller);
    }

    /**
     * The "copy paste" constructor creates a database, given another database.
     */
    public DataBase(DataBase dataBase) {

        this.house = new ArrayList<>(dataBase.house);
        this.seller = new ArrayList<>(dataBase.seller);

    }


    /**
     * Loads a Database on a binary file
     */

    public DataBase(String filepath, boolean binary) throws IOException, ClassNotFoundException {
       /* if (binary) {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filepath));
            DataBase temp = new DataBase((DataBase) is.readObject());
            DataBase temp2 = new DataBase((DataBase) is.readObject());
            this.seller = temp.getSeller();
            this.house = temp2.getHouse();
            is.close();
        } */

        seller = new ArrayList<>();


        File file = new File(filepath);
        Scanner readFile = new Scanner(file);
        String line;
        House house = null;
        Map<String,List<String>> temp = null;
        while (readFile.hasNextLine()) {
            line = readFile.nextLine();
            String[] linhaPartida = line.split(":");
            switch (linhaPartida[0]) {
                case "Fornecedor":
                    this.seller.add(new EnergySeller(linhaPartida[1]));
                    break;
                case "Casa":
                    if (house != null) this.house.add(house);
                    String[] nextComma = linhaPartida[1].split(",");
                    House newHouse = new House();
                    newHouse.setOwnerName(nextComma[0]);
                    newHouse.setNif(nextComma[1]);
                    this.seller.stream().filter(e -> e.getEnergySeller().equals(nextComma[2])).findAny().ifPresent(seller -> newHouse.setSeller(seller));
                    house = new House(newHouse);
                case "Divisao":
                    if(temp !=null && house != null) {
                        house.setLocations(temp);
                        }
                case "SmartBulb":

                    }

        }
    }

 /*
    public List<House>  getHouse(){
        return house.stream().collect(Collectors.toList(House::getDevices, House :: clone));
    }

    public void setTeams(List<House> house) {
        this.house = house.stream().collect(Collectors.toList(House::getDevices, House::clone));
    }
/*
    public List<EnergySeller>  getSeller(){
        return seller.stream().collect(Collectors.toList(EnergySeller::getEnergySeller, EnergySeller :: clone));
    }

    public void setTeams(List<EnergySeller> seller) {
        this.seller = seller.stream().collect(Collectors.toList(EnergySeller::getEnergySeller, EnergySeller :: clone));
    }
 */

}