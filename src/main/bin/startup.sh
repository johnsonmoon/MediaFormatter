#!/bin/bash

echo "Starting media formatter..."

num=`ps -ef | grep java | grep formatter | wc -l`
if [ ${num} -eq 0 ] ; then 
	nohup ./jre/bin/java -classpath "./lib/*;%CLASSPATH%" xuyihao.formatter.ui.window.main.MainWindow >> start.log 2>&1 &
else	
	echo "media formatter has already started."
fi

echo "Media formatter started."
exit 0