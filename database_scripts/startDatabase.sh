#!/bin/sh

java -cp '../libraries/hsqldb-2.7.4.jar' org.hsqldb.server.Server --database.0 file:../database/snack --dbname.0 database

