FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/movieDB
ENV MYSQL_DATABASE=movieDB
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ADD ./target/MovieCruiserAuthentication-0.0.1-SNAPSHOT.jar /usr/src/MovieCruiserAuthentication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "MovieCruiserAuthentication-0.0.1-SNAPSHOT.jar"]
