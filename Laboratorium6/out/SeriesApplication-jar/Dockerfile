FROM eclipse-temurin:17.0.6_10-jre

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:series-app
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV CHARACTER_APP_URL=http://localhost:8081

EXPOSE 8080

COPY SeriesApplication-0.0.1-SNAPSHOT.jar /opt/series-app/SeriesApplication-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/opt/series-app/SeriesApplication-0.0.1-SNAPSHOT.jar"]
