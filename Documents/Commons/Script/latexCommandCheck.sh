#!/bin/bash
# Questo script restituisce le stringhe contenenti comandi latex in cui sono presenti spazi prima o dopo il comando
egrep "\\ [[:alpha:]]*{[[:alpha:]]*[[:space:]]?[[:alpha:]]*}" $1
