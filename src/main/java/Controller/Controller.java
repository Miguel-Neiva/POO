package Controller;

import java.io.IOException;
import java.util.Scanner;

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
                    Controller.houseController(housename);
                    break;
                case 6:
                    long days = ReaderWriter.getLong("Please insert number of days:");
                    simulation.simulate(days);
                    View.printer(simulation.toString());
                    ReaderWriter.pressEnterToContinue();
                    break;
                case 7:
                    user_input.close();
                    System.exit(0);
                    break;
            }
        }
    }

    public static void houseController(String houseName) {
        View.MenuHouse();
        int input = ReaderWriter.getInt("Please choose an option: ");
        while (input != 6) {
            if (input == 1) {
            } else if (input == 2) {

            }
            View.MenuHouse();
            input = ReaderWriter.getInt("Please choose an option: ");
        }
    }
}
