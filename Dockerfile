FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER ismaelcabanas@gmail.com

# You can use JAVA_OPTS to customize your jvm flags (check gradle application plugin, it creates the script that this container runs)
#ENV JAVA_OPTS -Xmx512M

EXPOSE 8100

CMD ["/opt/despensa-app/bin/despensa-app"]

COPY ./Dockerfile /Dockerfile
ADD ./build/install/despensa-app /opt/despensa-app
