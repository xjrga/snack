#!/bin/bash

#glpsol -m $1.mod --wcpxlp $1.lp --wglp $1.glp --wfreemps $1.freemps --wmps $1.fixedmps --xcheck -o $1.sol 
#glpsol --model $1.mod --data $1.dat -o $1.sol --wcpxlp $1.lp --xcheck
#glpsol --model $1 --wcpxlp $1.lp --xcheck -o $1.sol
glpsol -m $1.mod -o $1.sol
