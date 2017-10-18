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
		for (int i = 0, int tick = 0; i < size; ++tick) {
			if (line.isFull()) {
				if (line.findMin() == tick) {
					line.deleteMin();
					leave = this.arrivalLine[i].arrival + this.arrivalLine[i].serivce;
					line.insert(leave);
					this.alarm(tick, this.arrivalLine[i].arrival, leave);
				}
			} else {
				leave = this.arrivalLine[i].arrival + this.arrivalLine[i].serivce;
				line.insert(leave);
				this.alarm(tick, this.arrivalLine[i].arrival, leave);
			}
		}
		return;
	}
	public void alarm(int tick, int arrival, int leave) {
		System.out.printf(
			"Tick %d: process customer who arrival at tick %d and leave at tick %d", 
			tick,
			arrival,
			leave
		);
		
	}
}
