# A Makefile for GCD.c

GCD: GCD.o
	gcc -o GCD GCD.o

GCD.o: GCD.c
	gcc -c -std=c99 GCD.c

clean:
	rm -f GCD.o

spotless:
	rm -f GCD.o GCD

submit: Makefile GCD.c
	submit cmps011-pt.s17 lab8 Makefile GCD.c
