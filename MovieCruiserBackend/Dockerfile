FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=movieDB
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/movieDB
ADD ./target/MovieCruiserBackend-0.0.1-SNAPSHOT.jar /usr/src/MovieCruiserBackend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "MovieCruiserBackend-0.0.1-SNAPSHOT.jar"]
