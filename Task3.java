public class Task3 extends Task {
    public Task3(int ID, int start, int deadline, int duration) {
        super(ID, start, deadline, duration);
    }

    // Figure out new priority.
    @Override
    public int compareTo(Task t2) {
        //System.out.println("Using Task1 compareTo");
        return deadline-t2.deadline;
     }
}