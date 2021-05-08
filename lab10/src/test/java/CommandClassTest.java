import com.lab10.Commands.CommunicationObjects.Command;

import java.util.Scanner;

public class CommandClassTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Command command = new Command(scanner.nextLine());

        System.out.println(command);
    }
}
