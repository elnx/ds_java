import java.util.*;
public class EventSimulator {
    //create an event simulator
    //tellers determine how many customers can be serviced at the same time
    //arrivalLine is the input stream, sorted by arrival time
	int tellers;
	ArrayList<Customer> arrivalLine;
    public EventSimulator(int tellers, ArrayList<Customer> arrivalLine) {
		this.tellers = tellers;
		this.arrivalLine = arrivalLine;
	}
    //set the arrival line
    public void setArrivalLine(ArrayList<Customer> arrivalLine) {
		this.arrivalLine = arrivalLine;
	}
    //start simulation
    public void simulate() {
		int size = this.arrivalLine.size();
		if (size == 0)
			return;
		BinaryHeap line = new BinaryHeap(this.tellers);
		int leave = 0;
		int min = 0;
		for (int i = 0, tick = 0; i < size; ++tick) {
			if (line.isFull()) {
				while (min == tick && i < size) {
					try {
						line.deleteMin();
					} catch (Exception e) {
					}
					leave = this.arrivalLine.get(i).arrival == tick ? this.arrivalLine.get(i).arrival + this.arrivalLine.get(i).service : this.arrivalLine.get(i).service + tick;
					line.insert(leave);
					try {
						min = line.findMin(); //update the earliest leave time
					} catch (Exception e) {
					}
					this.alarm(tick, this.arrivalLine.get(i).arrival, leave);
					++i;
				}
			} else {
				leave = this.arrivalLine.get(i).arrival == tick ? this.arrivalLine.get(i).arrival + this.arrivalLine.get(i).service : this.arrivalLine.get(i).service + tick;
				line.insert(leave);
				try {
					min = line.findMin(); //update the earliest leave time
				} catch (Exception e) {
				}
				this.alarm(tick, this.arrivalLine.get(i).arrival, leave);
				++i;
			}
		}
		return;
	}
	public void alarm(int tick, int arrival, int leave) {
		System.out.printf(
			"Tick %d: process customer who arrival at tick %d and leave at tick %d\n", 
			tick,
			arrival,
			leave
		);
		
	}
}
