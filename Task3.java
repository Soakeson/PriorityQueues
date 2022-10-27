public class Task3 extends Task {
    public Task3(int ID, int start, int deadline, int duration) {
        super(ID, start, deadline, duration);
    }

    
    @Override
    public int compareTo(Task t2) {
        //System.out.println("Using Task3 compareTo");
        if ((deadline - start) % duration < (t2.deadline - t2.start) % t2.duration) return -1;
        if ((deadline - start) % duration > (t2.deadline - t2.start) % t2.duration) return 1;
        else return 0;
     }
}