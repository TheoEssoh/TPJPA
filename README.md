Jean-Théodore ESSOH et Sylvanus KONAN

TP première partie du backend.
##Prerequis
- mysql version 8.0.22
- maven

- commencer le projet par créer une base de données dans votre serveur de BD.
  ensuite configurez votre fichier persistence.xml pour vous connecter.
  
 

- Ensuite lancer jetty.
  - pour voir les informations entrées au formulaire sans les inserer en BD lancer
  - "http://localhost:8080/myform.html" dans votre navigateur puis entrer les informations demandées et envoyer.
 
- pour inserer des informations du formulaire dans la base de données KanbanBoard
  - lancer "http://localhost:8080/insert.html" puis entrez les infos démandées puis clicquez sur save.
    si les champs des dates sont vide, la date du jour actuel sera utilisée. 
    Pour le champs boards ça sera 0 si le champs est vide.
    (si vous inserer les informations plusieurs fois assurez-vous que le mail du user soit unique)