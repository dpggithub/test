#!/bin/bash

# shellcheck disable=SC2006
# shellcheck disable=SC2009
pid=`ps -ef | grep "demo-app-0.0.1-SNAPSHOT.jar" | grep -v "grep" | awk '{print $2}'`

for id in $pid

do

kill -9 "$id"

echo "killed $id"

done

nohup java -jar -server /project/watchdog/demo-app-0.0.1-SNAPSHOT.jar &

# shellcheck disable=SC2046
echo $(date "+%Y-%m-%d %H:%M:%S") "process has been restarted!"