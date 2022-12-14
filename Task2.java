public class Task2 extends Task {
    public Task2(int ID, int start, int deadline, int duration) {
        super(ID, start, deadline, duration);
    }

    // Start time is priority ties decided by deadline
    @Override
    public int compareTo(Task t2) {
        //System.out.println("Using Task2 compareTo");
        if (start < t2.start) return -1;
        if (start > t2.start) return 1;
        // If there is a tie decide by deadline
        if (deadline < t2.deadline) return -1;
        if (deadline > t2.deadline) return 1;
        else return 0;
     }
}
