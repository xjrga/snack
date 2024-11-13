#!/bin/sh

#dot -Tpng -o x.png x.gv 
name=`echo "$1" | cut -d'.' -f1`
img=$name.png

dot -Tpng -o $img $1
#gpicview $img
