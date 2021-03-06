#!/usr/bin/env bash

##########################################################################################
## Do something after maven build.
##
## Include the following content:
## - Change directory
## - Delete some temporary files or directories
## - Create a output directory
## - Move files
##########################################################################################

workspace=$(pwd)
echo $workspace
target="$workspace/target/kotoumi-manage.jar"
script="$workspace/server-start.sh"
rm -rf tmp/
mkdir -p tmp/
cp $target tmp/kotoumi-manage.jar
cp $script tmp/
rm -rf output/
mv tmp output

