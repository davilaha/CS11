#! /bin/bash
#--------------------------------------
# RunLawn
#--------------------------------------
echo "compiling Lawn.java"
javac Lawn.java >& Lawn-errs
echo "running Lawn.class"
java Lawn < Lawn-in > Lawn-out
echo "deleting Lawn.class"
rm Lawn.class
