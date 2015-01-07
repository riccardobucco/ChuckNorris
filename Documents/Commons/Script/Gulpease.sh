#!/bin/bash

#Questo script restituisce l'indice gulpease del file passato come parametro

if [ -z $1 ]
then
	exit 1
fi

PAROLE=$(wc -w < $1)
LETTERE=$(wc -c < $1)
FRASI=$(grep -o '\.' $1 | wc -w)


echo "$((89+((300*FRASI-10*LETTERE)/PAROLE)))"
