all: Main.class
DLNode.class: DLNode.java
	javac DLNode.java
MyDeque.class: MyDeque.java
	javac MyDeque.java
QueueAdaptor.class: MyDeque.class QueueAdaptor.java MyQueue.java
	javac MyQueue.java
	javac QueueAdaptor.java
StackAdaptor.class: MyDeque.class StackAdaptor.java MyStack.java
	javac MyStack.java
	javac StackAdaptor.java
Main.class: QueueAdaptor.class StackAdaptor.class Main.java
	javac Main.java
test:
	java Main
clean:
	rm -rf *.class
