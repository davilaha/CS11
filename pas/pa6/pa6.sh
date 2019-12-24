#!/bin/bash
# cmps011-pt.s17 grading
# usage: pa6.sh
# (run within your pa6 directory to test your code)

SRCDIR=https://raw.githubusercontent.com/4u6u57/cmps011-pt.s17.grading/master/pa6
EXE="pa6-check.sh"
SCRIPT=$(mktemp)

curl $SRCDIR/$EXE > $SCRIPT
chmod +x $SCRIPT
$SCRIPT
rm -f $SCRIPT

