public class Task2 extends Task {
    public Task2(int ID, int start, int deadline, int duration) {
        super(ID, start, deadline, duration);
    }

    // Start time is priority
    @Override
    public int compareTo(Task t2) {
        //System.out.println("Using Task2 compareTo");
        return start - t2.start;
     }
}
