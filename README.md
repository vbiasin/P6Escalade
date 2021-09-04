# P6Escalade
Projet 6 du parcours de développeur d'application JAVA d'OC


#Prérequis :
Avoir un client muni de JAVA 15 et d'un JDK. 
Avoir un IDE (IntelliJ, Eclipse, NetBeans...) installé sur le client. 
Savoir monter un serveur SQL et créer une BDD SQL (des scripts sont fournis dans le livrable sur Open Classrooms)


# Exécuter l'application (IDE).
Cloner le projet depuis GitHub dans votre IDE en utilisant le lien https:
https://github.com/vbiasin/P6Escalade.git
Configurer le fichier "application.properties":
spring.datasource.url = jdbc:mysql://192.168.1.62:3306/p6escalade?serverTimezone=UTC (URL de votre BDD)
spring.datasource.username= <votreUtilisateur>
spring.datasource.password= <motDePasseUtilisateur>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
Vous pouvez exécuter l'application dans votre IDE.


# Exécuter l'application (CMD).
Extraire le fichier OCP6Escalade-1.0-SNAPSHOT.war du livrable dans le répertoire de son choix. 
Ouvrir une console en se placant dans le dossier contenant le fichier ci-dessus et exécuter la commande suivante:
java -jar OCP6Escalade-1.0-SNAPSHOT.war


#Recompiler le projet:
Ouvrir l'explorateur de fichiers Choisir un dossier dans lequel cloner le répertoire, clic droit GIT bash here Dans cette console: 
git clone https://github.com/vbiasin/P6Escalade.git
Lancer une invite de commandes et saisir mvn package
  
  
