all: Main.class
Main.class: Main.java Huffman.java Tree.java
	javac Main.java
test: Main.class
	java Main test.in
clean:
	rm -rf *.class
web:
	chmod +x app.py
	./app.py
