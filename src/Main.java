import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        CoffeMaker coffeMaker = new CoffeMaker(400,540,120,9,550);
        boolean bool = true;
        while (bool){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = scanner.nextLine();
            coffeMaker.action(command);
            if (command.contains("exit") ) {
               break;
            }

        }

    }


}
