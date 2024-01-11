This is a backend side for Counter app.
This application is function to count the number of name start with "M" or "m" and show the list of names.
To run build and ru this application, there are two approach.
First approach is by runing command "mvn clean install", then go to target folder and deploy the .jar file as java application.

The second approach is using docker command.
Build an image by run command "docker build -t counterapp-1.0:latest ."
The create container by run command "docker container create --name counterapp-1.0 -p 8080:8080 counterapp-1.0"
To check tif this process is done, run command "docker ps -a". If you can find counterapp-1.0 in the list, the you can proceed to next step. If not, retry previous steps.
Then run the docker by command "docker run counterapp-1.0"
