import java.util.*;
abstract class Task {

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

    public String isDoneString(){
        return this.getIsDone() ? "✓" : "✗";
    }

    abstract String getType();

}

class ToDo extends Task {
    public ToDo(String name) {
        super(name);
    }

    public String getType(){
        return "T";
    }

    public String toString(){
        return String.format("[%s][%s] %s",
                this.getType(),this.isDoneString(),this.getName());
    }
}

class Deadline extends Task {
    String deadlineDate;
    public Deadline(String name, String deadlineDate){
        super(name);
        this.deadlineDate = deadlineDate;
    }
    public String getType(){
        return "D";
    }

    public String getDeadlineDate(){
        return this.deadlineDate;
    }

    public String toString(){
        return String.format("[%s][%s] %s (by: %s)",
                this.getType(),this.isDoneString(),
                this.getName(), this.getDeadlineDate() );
    }
}

class Event extends Task {
    String eventTime;
    public Event(String name, String eventTime){
        super(name);
        this.eventTime = eventTime;
    }
    public String getType(){
        return "E";
    }

    public String getEventTime(){
        return this.eventTime;
    }

    public String toString(){
        return String.format("[%s][%s] %s (at: %s)",
                this.getType(),this.isDoneString(),
                this.getName(), this.getEventTime() );
    }
}


public class Duke {

    public static void printReply(String content){
        String horizontal_line = "_".repeat(20);
        System.out.println(horizontal_line);
        System.out.println(content);
        System.out.println(horizontal_line);
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greetings = "Hello! I'm Duke\n"
                + "What can I do for you?";

        System.out.println("Hello from\n" + logo);


        Scanner scanner = new Scanner(System.in);

        List<Task> taskList = new ArrayList<Task>();
        printReply(greetings);
        String horizontal_line = "_".repeat(20);
        while(true) {
            String prompt = scanner.nextLine();  // Read user input
            String[] arr = prompt.split(" ");
            if(prompt.equals("bye")) {
                printReply("Bye. Hope to see you again soon");
                return;
            } else if (prompt.equals("list")) {
                System.out.println(horizontal_line);
                int counter = 1;
                for (Task task : taskList) {
                    System.out.printf("%d.%s\n", counter, task.toString());
                    counter++;
                }
                System.out.println(horizontal_line);
            } else if (arr[0].equals("done")) {
                int taskNumber = Integer.parseInt(arr[1]);
                taskList.get(taskNumber-1).setIsDone(true);
                String reply = "Nice! I've marked this task as done:"
                        + taskList.get(taskNumber-1).toString();
                printReply(reply);
            } else if (arr[0].equals("todo")) {
                Task newTask = new ToDo(prompt.substring(5));
                taskList.add(newTask);
                String reply = String.format("Got it. I've added this task: \n%s\nNow you have %d tasks in the list.",
                        newTask.toString(), taskList.size());
                printReply(reply);
            } else if (arr[0].equals("deadline")) {
                String[] partition = prompt.split("/");
                Task newTask = new Deadline(partition[0].substring(9), partition[1].substring(3));
                taskList.add(newTask);
                String reply = String.format("Got it. I've added this task: \n%s\nNow you have %d tasks in the list.",
                        newTask.toString(), taskList.size());
                printReply(reply);
            } else if (arr[0].equals("event")) {
                String[] partition = prompt.split("/");
                Task newTask = new Event(partition[0].substring(6), partition[1].substring(3));
                taskList.add(newTask);
                String reply = String.format("Got it. I've added this task: \n%s\nNow you have %d tasks in the list.",
                        newTask.toString(), taskList.size());
                printReply(reply);
            }

        }

    }
}
