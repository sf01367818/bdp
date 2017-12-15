#!/bin/bash

APP_PATH=`dirname $0`

remoteHost=`hostname`
remotePort=19998
#JAVA_OPTS="-Djava.rmi.server.hostname=${remoteHost} -Dcom.sun.management.jmxremote.port=${remotePort}  -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"

java -classpath ${APP_PATH}/../marathon-provider.jar com.sf.bdp.marathon.MarathonProvider > /dev/null 2>&1 & 