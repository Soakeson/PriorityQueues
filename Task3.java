public class Task3 extends Task {
    public Task3(int ID, int start, int deadline, int duration) {
        super(ID, start, deadline, duration);
    }

    // Figure out priority for this one.
    @Override
    public int compareTo(Task t2) {
        //System.out.println("Using Task3 compareTo");
        if (duration < t2.duration) return -1;
        if (duration > t2.duration) return 1;
        if (deadline < t2.deadline) return -1;
        if (deadline > t2.deadline) return 1;
        else return 0;
     }
}