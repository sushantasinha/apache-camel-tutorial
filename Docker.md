# Docker

Install docker desktop
docker --version

Docker registry: https://hub.docker.com/

Find an image(sample): https://hub.docker.com/u/in28min

docker pull pulls an image or a repository from a registry.
docker run runs a command in a new container.
They don't work the same, however, if you use docker run with an image that you haven't pulled yet, docker run will call docker pull:

> docker pull in28min/todo-web-application-h2:0.0.1-SNAPSHOT
hostport:containerport (5000:5000)

```
docker run -p 5000:5000 in28min/todo-web-application-h2:0.0.1-SNAPSHOT
```


```
docker run -d -p 5000:5000 in28min/todo-web-application-h2:0.0.1-SNAPSHOT

```

-d: detached mode means container will run at background, that means console will not hold 

docker logs <log id> -> log details

List of running containers:
docker container ls

List of running and non-running containers:
docker container ls -a

can launch multiple containers from same image


docker container stop <id>

List of images:
docker images


```
            Docker Client 
                  ¦
                  ¦
            Docker Daemon
            ¦     ¦     ¦
            ¦     ¦     ¦
   Containers   Local   Image Repository
                Images

```

When install,  docker desktop, it installed both docker client and daemon
Docker daemon manage images etc...

single image can have multiple tag

docker/tag in28Min/abc:1:0:0-RELEASE in28Min/abc:latest

docker pull in28min/todo-web-application-h2
Will pull image with "latest" tag. THis is manually added taf, does not mean it is latest... 
as user can tag old version as latest tag as well

docker search mysql -> search image in reg.
If in "docker search mysql" if official is OK then it is official image, which we should use.

docker image history -> history of image <image id>

history of inspect <image id> -> details of image

docker image remove -> remove from local not from remote




```
docker run -p 5000:5000 in28min/todo-web-application-h2:0.0.1-SNAPSHOT
```

is shortcut of


```
docker container run -p 5000:5000 in28min/todo-web-application-h2:0.0.1-SNAPSHOT
```


docker container pause <id> ->  to pause the container 

docker container unpause <id> -> unpause

docker container inspect <id> -> inspect docker container

docker container prune -> clear out stopped container
so only running docker containers will be available also for "docker container ls -a"

docker container stop ib1 -> 3 digit of ID 
docker container logs -f 1b1 
 
// docker container stop will do graceful shutdown 
i.e. will give sometime to container to shutdown the stuffs properly

docker container kill <id> -> immediately stop (NO graceful shutdown)


docker run -p 5000:5000 -d --restart=always in28min/todo-web-application-h2:0.0.1-SNAPSHOT
container will be automatically started, when docker desktop will restart
--restart=always (default is no)

docker events: will hold the console and keep on showing what are the events are happening
like, if we run docker container stop command, it will show list of events happening now

docker top -> top process running on the specific container 

docker stats -> CPU, memory etc. details
 


docker run -d -p 5000:5000 -m 512m in28min/todo-web-application-h2:0.0.1-SNAPSHOT

can use this for CPU:
--cpu-quota 50000

docker system df: what are the resources are managed by docker daemon

DOcker COmpose: allow us to defining and run multi-container docker app 

As we rae using docker desktop, the docker compose is already installed 

copy docker-conpose.yaml to a local directory and then run 
docker compose up 



 







































 