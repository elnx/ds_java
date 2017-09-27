all: Main.class
	java Main
DLNode.class:
	javac DLNode.java
MyDeque.class:
	javac MyDeque.java
QueueAdaptor.class: MyDeque.class
	javac MyQueue.java
	javac QueueAdaptor.java
StackAdaptor.class: MyDeque.class
	javac MyStack.java
	javac StackAdaptor.java
Main.class: QueueAdaptor.class StackAdaptor.class
	javac Main.java
