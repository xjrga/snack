#!/bin/bash

if test -f errors.txt
then
rm errors.txt
fi

count=`ls -1 snack_lpsolve_*.lp 2>/dev/null | wc -l`
if [ $count != 0 ]
then

for model in `ls snack_lpsolve_*.lp`; do
if !(lp_solve -piv1 -s1 -S3 $model 1>>temp.txt 2>&1)
then
	echo "-----------------------------------------------------------------" >> errors.txt
        echo "`date`" >> errors.txt
        echo $model >> errors.txt
	cat temp.txt >> errors.txt
	echo "-----------------------------------------------------------------" >> errors.txt
else
	cat temp.txt > $model.sol
        rm temp.txt
fi
done

if test -f temp.txt
then
rm temp.txt
fi

fi


