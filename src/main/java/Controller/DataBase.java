package Controller;

import EnergySeller.EnergySeller;
import House.House;
import SmartDevice.*;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;

public class DataBase implements Serializable {
    List<House> houses;
    List<EnergySeller> sellers;
    // Constructors

    /**
     * The "empty" constructor creates a new database whit no info.
     */
    public DataBase() {
        this.houses = new ArrayList<>();
    }

    /**
     * The "parametric" constructor creates a database, given another the parameters.
     */
    public DataBase(List<House> house, List<EnergySeller> seller) {

        this.houses = new ArrayList<>(houses);
        this.sellers = new ArrayList<>(sellers);
    }

    /**
     * The "copy paste" constructor creates a database, given another database.
     */
    public DataBase(DataBase dataBase) {

        this.houses = new ArrayList<>(dataBase.houses);
        this.sellers = new ArrayList<>(dataBase.sellers);

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

        this.sellers = new ArrayList<>();
        this.houses = new ArrayList<>();

        File file = new File(filepath);
        Scanner readFile = new Scanner(file);
        String line;
        House house = null;
        Map<String,List<Integer>> div = null;
        Map<Integer,SmartDevice> devices = null;
        String divName = null;
        int idCount = 1;
        while (readFile.hasNextLine()) {
            line = readFile.nextLine();
            String[] linhaPartida = line.split(":");
            System.out.println(linhaPartida[0]);
            switch (linhaPartida[0]) {
                case "Fornecedor":
                    sellers.add(new EnergySeller(linhaPartida[1]));
                    break;
                case "Casa":
                    if (house != null) {
                        house.setLocations(new HashMap<>(div));
                        house.setDevices(new HashMap<>(devices));
                        this.houses.add(new House(house));
                    }
                    div = new HashMap<>();
                    devices = new HashMap<>();
                    String[] nextComma = linhaPartida[1].split(",");
                    House newHouse = new House();
                    newHouse.setOwnerName(nextComma[0]);
                    newHouse.setNif(nextComma[1]);
                    this.sellers.stream().filter(e -> e.getEnergySeller().equals(nextComma[2])).findAny().ifPresent(seller -> newHouse.setSeller(seller));
                    house = new House(newHouse);
                    break;
                case "Divisao":
                    div.put(linhaPartida[1],new ArrayList<>());
                    divName = linhaPartida[1];
                    break;
                case "SmartBulb":
                    String[] nextCommaBulb = linhaPartida[1].split(",");
                    div.get(divName).add(idCount);
                    SmartBulb.Tonality ton;
                    if(nextCommaBulb[2].equals("Neutral")) ton = SmartBulb.Tonality.Neutral;
                        else if(nextCommaBulb[2].equals("Cold")) ton = SmartBulb.Tonality.Cold;
                    else ton = SmartBulb.Tonality.Warm;
                    devices.put(idCount,new SmartBulb(idCount,SmartDevice.State.OFF,Double.parseDouble(nextCommaBulb[1]), Double.parseDouble(nextCommaBulb[2]),ton));
                            idCount++;
                            break;
                case "SmartCamera":
                    String[] nextCommaCamera = linhaPartida[1].split(",");
                    div.get(divName).add(idCount);
                    String[] cameraResolution = nextCommaCamera[0].split("x");
                    int cameraHeight = Integer.parseInt(cameraResolution[0].substring(1));
                    int cameraWidth = Integer.parseInt(cameraResolution[1].substring(0,cameraResolution[1].length()-1));
                    //System.out.println(cameraWidth);
                    devices.put(idCount,new SmartCamera(idCount, SmartDevice.State.OFF, new SmartCamera.CameraResolution(cameraHeight,cameraWidth),Integer.parseInt(nextCommaCamera[1]),Double.parseDouble(nextCommaCamera[2])));
                    idCount++;
                    break;
                case "SmartSpeaker" :
                    String[] nextCommaSpeaker = linhaPartida[1].split(",");
                    div.get(divName).add(idCount);
                    //String marca = nextCommaSpeaker[1];
                   // System.out.println(marca);
                    devices.put(idCount, new SmartSpeaker(idCount,SmartDevice.State.OFF,Integer.parseInt(nextCommaSpeaker[0]),nextCommaSpeaker[1],nextCommaSpeaker[2],Double.parseDouble(nextCommaSpeaker[3])));
                    idCount++;
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