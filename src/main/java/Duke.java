import java.util.*;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greetings = "Hello! I'm Duke\n"
                + "What can I do for you?";
        String horizontal_line = "_".repeat(20);
        System.out.println("Hello from\n" + logo);

        System.out.println(horizontal_line);
        System.out.println(greetings);
        System.out.println(horizontal_line);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String prompt = scanner.nextLine();  // Read user input
            if(prompt.equals("bye")) {
                System.out.println(horizontal_line);
                System.out.println("Bye. Hope to see you again soon");
                System.out.println(horizontal_line);
                return;
            } else {
                System.out.println(horizontal_line);
                System.out.println(prompt);
                System.out.println(horizontal_line);

            }

        }

    }
}
