package View;

public class View {
    public static void mainMenu() {
        StringBuilder sb = new StringBuilder("---------------Menu--------------");
        sb.append("\n(1) - Houses");
        sb.append("\n(2) - Devices");
        sb.append("\n(3) - LoadDatabase");
        sb.append("\n(4) - SaveDatabase");
        sb.append("\n(5) - View database");
        sb.append("\n(6) - Quit");
        System.out.println(sb);
    }
    /** Prints an object */
    public static void printer(Object o){System.out.println(o);}

    /**Prints questions related to the House */
    public static void controlHouse(int i) {
        if(i == 1) System.out.print("Choose your Room: ");
        else if(i == 2) System.out.print("Choose a Device in the Room: ");
        else if(i == 3) System.out.print("Choose the Room you want to remove: ");
        else if(i == 4) System.out.print("Add a Room: ");
    }

    public static void controlDevice(int i){
        if(i == 1) System.out.print("Choose your Device: ");
        else if(i==2) System.out.print("Choose the Volume in the Speaker: ");
        else if(i==3) System.out.print("Choose the Tonality in the Bulb: ");
        else if(i == 5) System.out.print("Choose the Camera Resolution ");
        else if(i == 6) System.out.print("Choose the Device you want to remove: ");
        else if(i == 7) System.out.print("Add a Device: ");


    }

    public static void askDatabase(int i) {
        if (i == 1) {
            System.out.println("Do you want to load our custom database or an external/Professor database?");
            System.out.print("[custom/external] ");
        } else if (i == 2) System.out.print("Is the file binary [y/n]: ");
        else System.out.print("Write filepath: ");

    }
    /** Prints exceptions */
    public static void exceptionPrinter(Exception e) {
        System.out.println(e.getMessage());
    }
    public static void noDatabase() {
        System.out.println("No Database loaded please load one.\n");
    }

}
