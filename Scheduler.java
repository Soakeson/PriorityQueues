import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

public class Scheduler {
    public void makeSchedule(String string, ArrayList<Task> tasks) {
        System.out.println(string);
        LeftistHeap<Task> queue = new LeftistHeap<>();
        int time = 1;
        int position = 1;
        queue.insert(tasks.get(0));
        while (!queue.isEmpty()) {
            for (int i = position; i < tasks.size(); i++) {
                if (tasks.get(i).start == time) {
                    queue.insert(tasks.get(i));
                    position++;
                } else {
                    break;
                }
            }
            Task priority = queue.deleteMin();
            priority.duration--;
            if (priority.duration > 0) {
                queue.insert(priority);
            } else {
                if (priority.deadline >= time) {
                    System.out.println(priority);
                } else {
                    System.out.println(priority + "**LATE " + (time - priority.deadline));
                }

            }
            time++;
        }        
    }
}
