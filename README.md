# Projet de tests Selenium
Ce projet automatise certaines fonctionnalitées sur la plateforme OrangeHRM.
Elle intervient dans le cadre de la formation de Test automatisé mis en place par Qalibab.

# Préréquis
Java 17.0.8
Installation des Driver : Chrome, Firefox, Edge
Selenium
TestNg
Surefire

# Structure du projet

src/test : Contient tout les tests du projet
pom.xml : Contient les configurations du projet
target/surefire-reports : Contient les différents rapports de tests généré 

# Description détaillé du projet

La mise en place du projet nécessite d'appliquer les notions apprises lors de la formations tel que :
Webdriver
Selecteurs
les dépendances
les bonnes pratiques
les rapports de tests

Pour se projet nous avons créer 2 classes de tests qui englobents les points suivants : 
    
    1- CasPratique1.java qui contient les méthodes suivantes :
        . ouvrirNavigateur : Cette méthode permet de lancer le navigateur et ouvrir la page de connexion de OrangeHRM (elle s'exécute au début de chaque Test de notre class)
        . loginOrangeHrmValide : Cette méthode permet d'exécuté la fonctionnalité connexion dans le cas ou nous avons des accès valides.
        . ajouterEmploye : Cette méthode permet d'exécuté la fonctionnalitée de création de compte employé en partant de la page de connexion à la page d'affichage d'information personnel.
        . fermerNavigateur : Cette méthode permet de fermer le navigateur s'il est ouvert et s'exécute à la fin de chaque test de la classe.
    
    2- AuthentificationInvalide.java qui contient les méthodes suivantes :
        . ouvrirNavigateur : Cette méthode permet de lancer le navigateur et ouvrir la page de connexion de OrangeHRM (elle s'exécute au début de chaque Test de notre class)
        . loginOrangeHrmInvalide : Cette méthode permet d'exécuté la fonctionnalité connexion dans le cas ou nous avons des accès invalides.
        . fermerNavigateur : Cette méthode permet de fermer le navigateur s'il est ouvert et s'exécute à la fin de chaque test de la classe.


# Exéctions
Exécution de tout les tests du projet : mvn clean test

