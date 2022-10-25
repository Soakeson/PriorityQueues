public class Task implements Comparable<Task> {
    public int ID;
    public int start;
    public int deadline;
    public int duration;
    public Task() {
        this.ID = 0;
        this.start = 0;
        this.deadline = 0;
        this.duration = 0;
    }

    public Task(int ID, int start, int deadline, int duration) {
        this.ID = ID;
        this.start = start;
        this.deadline = deadline;
        this.duration = duration;
    }

    public String toString() {
        return "Task " + ID;
    }

    public String toStringL() {
        return "Task " + ID + "[" + start + "-" + deadline + "] " + duration;
    }

    // Comparing two different objects that implement Task priortize deadline.
    public int compareTo(Task t2) {
        if (deadline < t2.deadline) return -1;
        if (deadline > t2.deadline) return 1;
        else return 0;
    }

}
