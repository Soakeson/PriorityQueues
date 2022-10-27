import java.util.ArrayList;

public class Scheduler {
    public void makeSchedule(String priorityLabel, ArrayList<Task> tasks) {
        LeftistHeap<Task> queue = new LeftistHeap<>();
        int time = 1, currPos = 1;
        queue.insert(tasks.get(0)); // Insert the first item so the loop can start
        System.out.println(priorityLabel);

        while (!queue.isEmpty()) {
            for (int i = currPos; i < tasks.size(); i++) { // Insert tasks until the start time is greater than the current time
                if (tasks.get(i).start == time) {
                    queue.insert(tasks.get(i));
                    currPos++;
                } else {
                    break;
                }
            }
            Task priority = queue.deleteMin();
            priority.duration--; // Subtract from the duration, the task has been worked on
            if (priority.duration > 0) { // If task is not complete put it back in the queue
                queue.insert(priority);
            } else { // If the task has been complete
                if (priority.deadline >= time) { // Completed on time
                    System.out.println(priority);
                } else { // Late
                    System.out.println(priority + " **LATE by " + (time - priority.deadline) + " min");
                }
            }
            time++; // Update time every loop
        }        
    }    
}
