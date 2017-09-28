#!/bin/bash.

# set major version
version=$4

# get token to be able to talk to Docker Hub.
token=$(curl -s -H "Content-Type: application/json" -X POST -d '{"username": "'$1'", "password": "'$2'"}' https://hub.docker.com/v2/users/login/ | jq -r .token);

# get all tags created for confluence-service repository.
result=$(curl -s -H "Authorization: JWT ${token}" https://hub.docker.com/v2/repositories/statravel/$3/tags/?page_size=10000);

tagsCount=`echo "$result" | jq -r '.count'`;

tags=`echo "$result" | jq -r '.results|.[].name'`;

# check if there are tags created.
if [ ${tagsCount} = "0" ]; then

  echo "1";

else

  declare -a intTags;
  regex1='^[0-9]+$';
  regex2='^[0-9]+\.[0-9]+$';

  for tag in ${tags} ; do

    # check if the tag is a number
    if [[ $tag =~ $regex1 ]] ; then

      if [[ $5 = "latest" ]] ; then
        intTags[${#intTags[@]}]=$tag
      else
        intTags[${#intTags[@]}]=$tag.1
      fi

    elif [[ $tag =~ $regex2 ]] ; then

      majorVersion=${tag%.*}
      minorVersion=${tag#*.}

      if [[ $5 = "latest" ]] ; then

        intTags[${#intTags[@]}]=$tag

      elif [[ $majorVersion = $version ]] ; then

        minorVersion=$((minorVersion + 1))
        intTags[${#intTags[@]}]=$majorVersion.$minorVersion

      elif [[ $majorVersion < $version ]] ; then

        minorVersion=0
        intTags[${#intTags[@]}]=$version.$minorVersion

      elif [[ $majorVersion > $version ]] ; then

        echo "Version error; Docker major version greater then provided version"
        exit 3

      fi

    else

      continue;

    fi
  done

  IFS=$'\n'

  # echo the last tag.
  echo "${intTags[*]}" | sort -nr | head -n1

fi
