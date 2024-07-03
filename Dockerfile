# Usa la imagen base de Tomcat
FROM tomcat:latest

# Copia el archivo WAR de tu aplicación al directorio de despliegue de Tomcat
COPY target/pacolibrary-web-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar Tomcat
CMD ["catalina.sh", "run"]