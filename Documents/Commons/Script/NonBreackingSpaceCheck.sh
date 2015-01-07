#!/bin/bash
# stampa su shell le righe contenenti numeri separati da uno spazio normale

if [ -z $1 ]
then
	exit 1
fi

grep "[0-9] [0-9]" $1
