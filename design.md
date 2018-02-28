Les elements cl�s de la conception :

--- une architecture en couches
---  dans ce tp nous avons opt� pour le choix d'une architecture en couches permettant de mieux structurer le code afin d'obtenir 
une architecture flexible et coherante , les differentes couches mises en couches sont:

- une couche domain : definissant le modele donn�es persistantes

 - une couche DAO:permettant d'interroger la base de donn�es pour faire les requetes (create, select , delete et update),
 nous avons creer une interface DAOGeneric par modele de donn�es et une implementation de cette derni�re,le DAO a pour objectif
 la s�paration des donn�es et de leurs traitements .Le choix d'un DA0 par entit� de modele est le choix le plus courant pour permettre
 une s�paration des differentes entit�s et traitemens d'entit�s ce qui va permetre par la suite d'etre flexible � tout nouveau changement
  
  pour definir nos requetes , nous avons envisager differents cas : utilisation de l'api criteria, 
  et l'utilisation du language de requete JPQL( mise den place des requetes nom�es)
  
  
  - une couche Service : cette couche est dedi� � la creation d'un web service JERSEY qui est une implementation de JAX-RS
  le cas le plus frequent est de creer egalement au niveau de cette couche des interfaces qui pourraientt etre 
  implement�es en REST,SOA ... .MAIS dans notre cas nous avons creer directement une implementation REST car on est sur que dans le cadre de ce tp
  nou serons pas confronter � un autre type d'implementation de service(d'ou l'usage uniquement d'un service rest sans passage par des interfaces)
  
  Dans cette couche nous avons creer un service par entit� de modele de donn�es , en definissant les methodes CRUD
  qui feront appel aux DAO pour communiquer avec la base de donn�es
  
  
  
  � la fin de ce tp nous nous retrouvons avec un backend java complet.
  

	