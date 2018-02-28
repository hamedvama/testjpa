# A la découverte de la notion de Servlet

## Les objectifs de ce travail pratique sont les suivants :

- Comprendre les mécanismes des Servlet
- Réaliser une application  Web en utilisant Combinant JPA et les Servlet
- Comprendre les principes d’une architecture Rest
- Comprendre les bénéfices d’un framework comme Jersey


### Pour l'installation

- cloner le porjet
- l'ouvrir avec un editeur eclipse par exemple
- lancer le serveur; dans eclipse: clic droit sur le projet -> run as -> build -> dans goal saisir tomcat7:run


### Pour le test ( de l'API et les services)

- Tester directement l'API en utilisant le jpatest.java qui contient des instruction pour peupler la base et voir les premier resulats

- Utiliser Postman par exemple pour envoyer les requetes http (get,post...) ; par exemple pour persister une Personne on utilise le path suivant 'http://localhost:8080/rest/helloPerson/createPerson' et en construisant un fichier json

