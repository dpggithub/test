#!/bin/bash

# shellcheck disable=SC2009
ps -ef | grep "demo-app-0.0.1-SNAPSHOT.jar" | grep -v "grep"

# shellcheck disable=SC2181
if [ "$?" -eq 0 ]

then

# sleep

# shellcheck disable=SC2046
echo $(date "+%Y-%m-%d %H:%M:%S") "process already started!"

else

nohup java -jar -server /project/watchdog/demo-app-0.0.1-SNAPSHOT.jar &

# shellcheck disable=SC2046
echo $(date "+%Y-%m-%d %H:%M:%S") "process has been started!"

fi