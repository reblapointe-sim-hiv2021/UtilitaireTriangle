package ca.cegepjonquiere.reblapointe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Exercice sur les appartements
        Appartement apt = new Appartement(2,1,650);
        Appartement loft = new Appartement();
        loft.setLoyer(500);
        loft.setNbChambres(1);
        loft.setNbSallesDeBain(1);

        apt.ecrireAnnonce();
        loft.ecrireAnnonce();

        // Exercice sur les triangles
	    Triangle desArpenteurs = new Triangle(3, 4, 5);
	    System.out.println(desArpenteurs.description());

	    Triangle iso = Triangle.aPartirDeACA(Math.toRadians(25), 100, Math.toRadians(25));
        System.out.println(iso.description());

        Triangle iso2 = iso;
        iso2.setCoteA(108);
        System.out.println(iso2.description());

        Triangle equi = Triangle.aPartirDeAAC(Math.toRadians(60), Math.toRadians(60), 10);
        System.out.println(equi.description());

        Triangle rec = Triangle.aPartirDeCAC(1, Math.toRadians(90), 1);
        System.out.println(rec.description());

        // Lecture d'un triangle de l'utilisateur
        Scanner s = new Scanner(System.in);
        System.out.println("Entrez le premier côté");
        double a = s.nextDouble();

        System.out.println("Entrez le deuxième côté");
        double b = s.nextDouble();

        System.out.println("Entrez le troisième côté");
        double c = s.nextDouble();

        Triangle triangleUsager = new Triangle(a, b, c);
        System.out.println("Votre triangle : " + triangleUsager.description());
    }
}



/*
----- Répondez aux questions suivantes à propos de la classe Triangle... -------

1. Quel est son nom?

2. Quelle est son accessibilité?

3. De quelle classe dépend-elle?

4. Quel est le numéro de la première ligne du corps de Triangle?

5. Quel est la numéro de la dernière ligne du corps de Triangle?

6. Quels sont les noms des attributs d'objets (non statique)?

7. Quels sont les types des attributs d'objets (non statique)?

8. Quelle est l'accessibilité des attributs d'objets (non statique)?

9. Quels sont les nom des attributs de classe (statique)?

10. Quels sont les noms de toutes les méthodes d'objets (non statique)?

11. Quels sont les noms de toutes les méthodes de classe (statique)?

12. Quel est le numéro où se trouve la signature de la méthode "description"?

13. Quelle est la dernière ligne du corps de la méthode "description"?

14. Quelle est la signature des constructeurs?

15. Parmi les méthodes, donnez le nom de tous les mutateurs?

16. Parmi les méthodes donnez le nom de tous les accesseurs?

17. Rédigez la documentation complète de "périmètre"
    Ses paramètres explicites :
    Son type de retour :
    Les exceptions qu'elle lance (s'il y a lieu) :
    Une description courte de son rôle :

18. Rédigez la documentation complète de "aPartirDeACA"
    Ses paramètres explicites :
    Son type de retour :
    Les exceptions qu'elle lance (s'il y a lieu) :
    Une description courte de son rôle :

19. Donnez la signature d'une méthode surchargée :

20. Deux méthodes devraient être dans une autre classe. Elles n'ont pas rapport aux triangles, lesquelles?

23. Ajoutez la méthode "public double plusGrandCote()". Elle retourne la longueur du plus grand côté entre coteA, coteB
    et coteC

24. Combien de méthodes de Triangle différentes sont-elles appelées dans le main?

25. Combien d'objets de type Triangle sont-ils créés pendant l'exécution du main?

26. Combien de variables de type Triangle sont-elles déclarées dans main?

27. Combien de fois main appelle-t-elle un constructeur de Triangle?

----- Défis (facultatif) ------

A. La classe Triangle contient des méthodes statiques. Selon vous, pourquoi est-ce que j'ai choisi de mettre ces
   méthodes statiques?

B. La classe Triangle contient des méthodes privées. Selon vous, pourquoi est-ce que j'ai choisi de mettre ces méthodes
   privées?

C. Modifiez la méthode "public boolean estEgal(Triangle t)"  pour qu'elle retourne vrai si le triangle est une
   permutation des côtés de t.

D. Ajoutez la méthode "public boolean estSemblable(Triangle t)" qui retourne vrai si le triangle est égal à t ou une
   homotétie de t.

E. Modifiez la classe Triangle pour qu'en tout temps, coteC soit le plus long côté. Pour ce faire, programmez et
   utilisez la méthode "private void arranger()" qui effectue une permutation des côtés a, b et/ou c afin de mettre le
   plus long côté dans c.

----- Au prochain cours (vendredi) : Programmation de tests automatisés. ------

*/