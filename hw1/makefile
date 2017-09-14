SHELL = /bin/zsh
1: 1-1
	@for i (10 100 1000 10000 100000 1000000 10000000) {(echo $$i; time ./1-1 $$i.in) &>$$i.out} 
2: 1-2
	@for i (10 100 1000 10000 100000 1000000 10000000) {(echo $$i; time ./1-2 $$i.in) &>$$i.out} 
p: Permute.java
	javac Permute.java
data:
	python gen.py
clean:
	rm -rf 1-1 1-2
	rm -rf *.class
	rm -rf *.in
	rm -rf *.out
