all: Main.class
Main.class: EventSimulator.class BinaryHeap.class Customer.class
	javac Main.java
EventSimulator.class: EventSimulator.java
	javac EventSimulator.java
BinaryHeap.class: BinaryHeap.java
	javac BinaryHeap.java
Customer.class: Customer.java
	javac Customer.java
test:
	java Main
clean:
	rm -rf *.class
