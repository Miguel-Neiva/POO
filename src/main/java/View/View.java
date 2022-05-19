package View;

public class View {
    public static void mainMenu() {
        StringBuilder sb = new StringBuilder("---------------Menu--------------");
        sb.append("\n(1) - Select a House");
        sb.append("\n(2) - Devices");
        sb.append("\n(3) - LoadDatabase");
        sb.append("\n(4) - SaveDatabase");
        sb.append("\n(5) - View database");
        sb.append("\n(6) - Simulate");
        sb.append("\n(7) - Quit");
        System.out.println(sb);
    }

    /** Prints questions related to the House */
    public static void MenuHouse() {
        StringBuilder sb = new StringBuilder("---------------House Menu--------------");
        sb.append("\n(1) - Add a device");
        sb.append("\n(2) - Add a Room");
        sb.append("\n(3) - Change House seller");
        sb.append("\n(4) - Turn on Device");
        sb.append("\n(5) - Turn off Device");
        sb.append("\n(6) - Back");
        System.out.println(sb);
    }

    public static void MenuSimulation(){
        StringBuilder sb = new StringBuilder("---------------Simulation Menu--------------");
        sb.append("\n(1) - Simulate one House");  // get Bill
        sb.append("\n(2) - Simulate all Houses"); //get associated Bill
        sb.append("\n(3) - Select the time to simulate in Days");
        sb.append("\n(4) - House with most Consumption"); // Highest Bill
        sb.append("\n(5) - Change energy seller");
        sb.append("\n(6) - Back");
        System.out.println(sb);
    }

    /** Prints an object */
    public static void printer(Object o) {
        System.out.println(o);
    }

    /** Prints questions related to the House */
    public static void controlHouse(int i) {
        if (i == 1)
            System.out.print("Choose your Room: ");
        else if (i == 2)
            System.out.print("Choose a Device in the Room: ");
        else if (i == 3)
            System.out.print("Choose the Room you want to remove: ");
        else if (i == 4)
            System.out.print("Add a Room: ");
    }

    public static void controlDevice(int i) {
        if (i == 1)
            System.out.print("Choose your Device: ");
        else if (i == 2)
            System.out.print("Choose the Volume in the Speaker: ");
        else if (i == 3)
            System.out.print("Choose the Tonality in the Bulb: ");
        else if (i == 5)
            System.out.print("Choose the Camera Resolution ");
        else if (i == 6)
            System.out.print("Choose the Device you want to remove: ");
        else if (i == 7)
            System.out.print("Add a Device: ");

    }

    public static void askDatabase(int i) {
        if (i == 1) {
            System.out.println("Do you want to load our custom database or an external/Professor database?");
            System.out.print("[custom/external] ");
        } else if (i == 2)
            System.out.print("Is the file binary [y/n]: ");
        else
            System.out.print("Write filepath: ");

    }

    /** Prints exceptions */
    public static void exceptionPrinter(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void noDatabase() {
        System.out.println("No Database loaded please load one.\n");
    }

    public static void chooseaOption() {
        System.out.print("Please choose an option: ");
    }

}
