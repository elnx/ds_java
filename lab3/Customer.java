public class Customer {
    int arrival;
    int service;
    // create a Customer
    public Customer (int arrival, int service) {
        this.arrival = arrival;
        this.service = service;
    }
    // get the arrival time
    public int getArrival() {
        return this.arrival;
    }
    // set the arrival time
    public void setArrival (int arrival) {
        this.arrival = arrival;
    }
    // get the service time
    public int getService() {
        return this.service;
    }
    // set the service time
    public void setService(int service) {
        this.service = service;
    }
}
