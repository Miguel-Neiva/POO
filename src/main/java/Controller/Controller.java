package Controller;

import java.io.IOException;
import java.util.Scanner;

import House.House;
import Simulation.Simulation;
import View.ReaderWriter;
import View.View;

public class Controller {

    public static DataBase loadDatabase() {
        DataBase dataBase = null;
        Scanner user_input = new Scanner(System.in);
        /* database load code */
        View.askDatabase(1);
        String dataAnswer = user_input.nextLine();
        if (dataAnswer.equals("custom")) {

            try {
                dataBase = new DataBase("database/CustomDatabase", true);
            } catch (IOException | ClassNotFoundException e) {
                View.exceptionPrinter(e);
                dataBase = loadDatabase();
            }
        } else if (dataAnswer.equals("external")) {
            View.askDatabase(2);
            dataAnswer = user_input.nextLine();
            boolean binary = dataAnswer.equals("y");
            View.askDatabase(3);
            String filepath = user_input.nextLine();

            try {
                dataBase = new DataBase("database/" + filepath, binary);
            } catch (IOException | ClassNotFoundException e) {
                View.exceptionPrinter(e);
                dataBase = loadDatabase();
            }
        } else {
            dataBase = loadDatabase();
        }

        return dataBase;
    }

    public static void run() {
        Scanner user_input = new Scanner(System.in);

        DataBase dataBase = Controller.loadDatabase();
        Simulation simulation = new Simulation(dataBase);
        while (true) {
            View.mainMenu();
            View.chooseaOption();
            int option = user_input.nextInt();
            switch (option) {
                case 1:
                    View.printer(dataBase.housesTostring());
                    String housename = ReaderWriter.getString("Please insert house owner's name: ");
                    while (!dataBase.houseExists(housename)) {
                        housename = ReaderWriter.getString("Please insert house owner's name: ");
                    }
                    Controller.houseController(housename, dataBase);
                    break;
                case 3:
                    dataBase = Controller.loadDatabase();
                    break;
                case 6:
                    SimulationController(dataBase, simulation);
                    break;
                case 7:
                    user_input.close();
                    System.exit(0);
                    break;
            }
        }
    }

    public static void houseController(String houseName, DataBase dataBase) {
        View.MenuHouse();
        int input = ReaderWriter.getInt("Please choose an option: ");
        while (input != 6) {
            if (input == 1) {
                House house = dataBase.getHouse(houseName);
                ReaderWriter.printString(house.getLocations().toString());
                String room = ReaderWriter.getString("Please insert the room in wich you want to add the device: ");
                while (!house.hasRoom(room)) {
                    ReaderWriter.getString(house.getLocations().toString());
                    room = ReaderWriter.getString("Please insert the room in wich you want to add the device: ");
                    Controller.deviceController(room, dataBase);
                }
                // String id = ReaderWriter.getString("Please insert smartdevice id");
                Controller.deviceController(room, dataBase);
            } else if (input == 2) {
                String room = ReaderWriter.getString("Please insert room name: ");
                dataBase.addRoom(houseName, room);
            } else if (input == 3) {
                ReaderWriter.printString(dataBase.sellersToString());
                String seller = ReaderWriter.getString("Please insert seller name: ");
                while (!dataBase.sellerExists(seller)) {
                    seller = ReaderWriter.getString("Please insert seller name: ");
                }
                dataBase.changeSeller(houseName, seller);
                ReaderWriter.printString("Seller Changed!");
                ReaderWriter.pressEnterToContinue();
            } else if (input == 4) {
                dataBase.devicesToString(houseName);
                int deviceId = ReaderWriter.getInt("Please insert device id:");
                dataBase.setOnDevice(houseName, deviceId);

            } else if (input == 5) {
                dataBase.devicesToString(houseName);
                int deviceIdOff = ReaderWriter.getInt("Please insert device id: ");
                while (dataBase.deviceExists(houseName, deviceIdOff)) {
                    deviceIdOff = ReaderWriter.getInt("Please insert device id: ");
                }
                dataBase.setOffDevice(houseName, deviceIdOff);

            }
            View.MenuHouse();
            input = ReaderWriter.getInt("Please choose an option: ");
        }
    }

    public static void deviceController(String room, DataBase dataBase) {
        View.MenuDevices();
        int input = ReaderWriter.getInt("Please choose an option: ");
        while (input != 4) {
            if (input == 1) {
                /**
                 * TODO: para teres os id so tens que fazer dataBase.getidCount() e dps tens
                 * que dar um dataBase.setidCount(idcount + 1) para somar um ao anterior
                 */
                String dev = ReaderWriter.getString(
                        "Please select the Volume,Channel,Speakerbrand,Consumption as the following example\n");
                System.out.println("40,RFM,Marshall,4.91");
                // SmartSpeaker dev = new SmartSpeaker()
            }
        }

    }

    public static void SimulationController(DataBase dataBase, Simulation s) {
        View.MenuSimulation();
        int input = ReaderWriter.getInt("Please choose an option: ");
        while (input != 6) {
            if (input == 1) {
                ReaderWriter.printString(dataBase.housesTostring());
                String houseOwner = ReaderWriter.getString("Please insert house owner's name: ");
                while (!dataBase.houseExists(houseOwner)) {
                    houseOwner = ReaderWriter.getString("Please insert house owner's name: ");
                }
                long days = ReaderWriter.getLong("Please insert the days:");
                s.simulateOne(days, houseOwner);
            } else if (input == 2) {
                long days = ReaderWriter.getLong("Please insert number of days:");
                s.simulate(days);
                View.printer(s.toString());
                ReaderWriter.pressEnterToContinue();
            } else if (input == 3) {
                // TODO: nao percebi
            } else if (input == 4) {

                ReaderWriter.printString("-------------Bill with most consumption------------\n" + s.mostConsumption());
                ReaderWriter.pressEnterToContinue();
            }
            // TODO: o 5 nao ta no menu da casa? tambem nao percebi
            View.MenuSimulation();
            input = ReaderWriter.getInt("Please choose an option: ");
        }
    }
}
