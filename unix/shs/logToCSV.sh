#!/usr/bin/env bash
# This program should take an fileIn as first parameter
# It takes the input log file that has the same format as access_log and maps it to a csv format
# the csv format is:
# Client, Time, Type, Path, Status, Size
#
# The program should not create a csv file.
# This can be done by piping the output to a file.
# example: './logToCSV access_log > output.csv'
# It could take some time to convert all of access_log. Consider using a small subset for testing.


fileName=$1

if [ -z "$fileName" ]
then
	echo "Please supply a valid filename!"
	exit 1
fi

cd "$(dirname "$0")"
cd ../data/apacheLog

out=""
while read p; do
    newLine=$(echo $p | sed 's/\[//g;s/"//g' | awk '{print $1, $4, $6, $9, $10}' | sed 's/ /, /g' )
    # output="$output\n$newLine"
    out="$out
    $newLine"
done < $fileName

echo "$out"
