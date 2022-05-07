package View;

public class View {
    public static void mainMenu() {
        StringBuilder sb = new StringBuilder("---------------Menu--------------");
        sb.append("\n(1) - House");
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
    public static void checkHouse(int i) {
        if(i == 1) System.out.print("Choose your Room: ");
        else if(i == 2) System.out.print("Choose you Device: ");
        else if(i == 3) System.out.print("Choose the Volume in the Speaker: ");
        else  if(i == 4) System.out.print("Choose the Tonality in the Bulb: ");
        else if(i == 5) System.out.print("Choose the Camera Resolution ");
        else if(i == 6) System.out.print("Choose the Room you want to remove: ");
        else if(i == 7) System.out.print("Choose the Device you want to remove: ");
        else if(i == 8) System.out.print("Choose the Camera Resolution ");
    }



}
