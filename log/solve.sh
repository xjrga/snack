#!/bin/bash

if test -f errors.txt
then
rm errors.txt
fi

for model in `ls snack_lpsolve_*.lp`; do
if !(lp_solve -S3 $model 1>>temp.txt 2>&1)
then
	echo "-----------------------------------------------------------------" >> errors.txt
        echo "`date`" >> errors.txt         
        echo $model >> errors.txt
	cat temp.txt >> errors.txt  
	echo "-----------------------------------------------------------------" >> errors.txt	
else
	cat temp.txt >> $model.sol 
        rm temp.txt
fi	
done

for model in `ls snack_glpk_*.lp`; do
if !(glpsol --lp $model -o $model.sol 1>>temp2.txt 2>&1)
then
	echo "-----------------------------------------------------------------" >> errors.txt
        echo "`date`" >> errors.txt
        echo $model >> errors.txt
	cat temp2.txt >> errors.txt  
	echo "-----------------------------------------------------------------" >> errors.txt
	rm temp2.txt
fi	
done

if test -f temp.txt
then
rm temp.txt
fi

if test -f temp2.txt
then
rm temp2.txt
fi
