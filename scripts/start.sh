#!/bin/bash
echo "[$NOW] > $JAR 실행" >> $START_LOG
nohup noup java -jar /home/ubuntu/t_our/tour-0.0.1-SNAPSHOT.jar &
