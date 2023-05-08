import java.util.*;
class Task {

    String name;
    boolean isDone;
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public String getName() {
        return name;
    }

    public void setIsDone(boolean newIsDone) {
        this.isDone = newIsDone;
    }
}
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

        List<Task> taskList = new ArrayList<Task>();
        while(true) {
            String prompt = scanner.nextLine();  // Read user input
            String[] arr = prompt.split(" ");
            if(prompt.equals("bye")) {
                System.out.println(horizontal_line);
                System.out.println("Bye. Hope to see you again soon");
                System.out.println(horizontal_line);
                return;
            } else if (prompt.equals("list")) {
                System.out.println(horizontal_line);
                int counter = 1;
                for (Task task : taskList) {
                    String taskState = "✗";
                    if (task.getIsDone()){
                        taskState = "✓";
                    }
                    System.out.printf("%d.[%s] %s\n", counter,taskState, task.getName());
                    counter++;
                }
                System.out.println(horizontal_line);
            } else if (arr[0].equals("done")) {
                int taskNumber = Integer.parseInt(arr[1]);
                taskList.get(taskNumber-1).setIsDone(true);
                System.out.println(horizontal_line);
                System.out.println("Nice! I've marked this task as done:");
                System.out.printf("[✓] %s\n", taskList.get(taskNumber-1).getName());
                System.out.println(horizontal_line);
            } else {
                taskList.add(new Task(prompt));
                System.out.println(horizontal_line);
                System.out.printf("added: %s\n", prompt);
                System.out.println(horizontal_line);


            }

        }

    }
}
