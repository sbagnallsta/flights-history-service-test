# shared-resources

docker-image-tag.sh is a bash script for setting the version number of a container - it does this by logging in to docker hub, getting the tags for a container and incrementing the minor version or setting the major version. 
The script expects four arguements and can take an optional fifth; a docker login username, a docker login password, a project title (the name of the project in docker), a major version number, and an optional tag of 'latest'.