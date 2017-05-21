#!bin/bash

current_time=$(date "+%Y-%m-%d:%H-%M-%S")

es_host=http://localhost:9200
index=$1

if [ -z "$2" ]
	then
		output_dir="./"
	else
		output_dir=$(echo $2 | sed 's/\/$//g')
		mkdir -p $output_dir
fi

file_name=$index-$current_time.json

elasticdump --input=$es_host/$index --output=$output_dir/$file_name --type=data;

echo "Dump taken to file: $output_dir/$file_name"
