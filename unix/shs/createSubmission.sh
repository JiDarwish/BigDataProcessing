#!/usr/bin/env bash
# The Unix assignment is almost over, time to create a submission.
# You could create a zip folder by hand. Just place the '.sh' files in there, but where's the fun in that.
# Let's create a script that does this for us.
# This script should take an output name as first parameter
# If called in a directory it should recursively find all the .sh files and add them to a zip
# So the zip should only contain .sh files and no folders.

# if [ $1 ]; then
#   output=$1  
#   echo "The name of the archive is:$1"
# else
#   output='output.zip'  
#   echo "Using default name for the archive:${output}"
# fi

# # Finds all files with extension .sh in current folder
# # pwd - full path of the current folder
# # -j removes the full path the found script files
# scriptFiles=$(find $(pwd) -type f -iname "*.sh" -print0 | xargs -0 zip -j ${output})


if [ $1 ]; then
  output=$1  
  echo "The name of the archive is:$1"
else
  output='output.zip'  
  echo "Using default name for the archive:${output}"
fi

# Finds all files with extension .sh in current folder
# pwd - full path of the current folder
# -j removes the full path the found script files
scriptFiles=$(find $(pwd) -type f -iname "*.sh" -print0 | xargs -0 zip -j ${output})