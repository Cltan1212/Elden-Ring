package game.utils;



import java.util.Scanner;

public class MenuToDisplayClass {
    public char menuToDisplayClass() {
        Scanner sel = new Scanner(System.in);
        System.out.println("Select your role: ");
        System.out.println("b: Bandit");
        System.out.println("s: Samurai");
        System.out.println("w: Wretch");

        System.out.println("Select one: ");
        String choiceString = sel.nextLine();
        char choiceChar = choiceString.charAt(0);  // convert user input to character

        return choiceChar;
    }

}
