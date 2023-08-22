# Usa la imagen de Tomcat 9.0.78-jdk17-temurin-jammy como base
FROM tomcat:9.0.78-jdk17-temurin-jammy

# Copia el archivo WAR de tu aplicación al directorio webapps de Tomcat
COPY target/ConsultorioOdontologico-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Puerto que expondrá la aplicación web
EXPOSE 8080

# Comando para ejecutar Tomcat (iniciará la aplicación web automáticamente)
CMD ["catalina.sh", "run"]

