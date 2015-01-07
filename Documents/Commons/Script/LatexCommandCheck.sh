#!/bin/bash
# Questo script restituisce le stringhe contenenti comandi latex in cui sono presenti spazi prima o dopo il comando

if [ -z $1 ]
then
	exit 1
fi

egrep "\\ [[:alpha:]]*{[[:alpha:]]*[[:space:]]?[[:alpha:]]*}" $1
