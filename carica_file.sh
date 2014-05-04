#!/bin/bash

# upload the file $1 in the online repo
# in $2 there is the commit
# You must run thi script in the local repo folder

git add $1
git commit -m "$2"
git push -u origin master
