package Controller;

import Exceptions.IncorrectLineException;
import View.View;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Controller {

        public static DataBase loadDatabase() {
            DataBase dataBase = null;
            Scanner User_input = new Scanner(System.in);
            /*database load code */
            View.askDatabase(1);
            String dataAnswer = User_input.nextLine();
            if(dataAnswer.equals("custom")) {

                try {
                    dataBase = new DataBase("database/CustomDatabase",true);
                } catch (IOException | ClassNotFoundException e ) {
                    View.exceptionPrinter(e);
                }
            }
            else if(dataAnswer.equals("external")) {
                View.askDatabase(2);
                dataAnswer = User_input.nextLine();
                boolean binary = dataAnswer.equals("y");
                View.askDatabase(3);
                String filepath = User_input.nextLine();

                try {
                    dataBase = new DataBase("database/" + filepath,binary);
                } catch (IOException | ClassNotFoundException e) {
                    View.exceptionPrinter(e);
                }
            }
            return dataBase;
        }

    public static void run() {
        Scanner User_input = new Scanner(System.in);


        DataBase dataBase = Controller.loadDatabase();

        while(true) {
            View.mainMenu();
            int option = User_input.nextInt();
            switch (option) {
                case 1:
                    if (dataBase != null) {

                    }
            }
        }
        }
}
