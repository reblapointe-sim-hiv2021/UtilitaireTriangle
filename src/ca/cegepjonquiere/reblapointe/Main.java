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

        Triangle iso2;
        iso2 = iso;
        iso2.setCoteA(108);
        System.out.println(iso2.description());

        Triangle equilateral = Triangle.aPartirDeAAC(Math.toRadians(60), Math.toRadians(60), 10);
        System.out.println(equilateral.description());

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
Triangle

2. Quelle est son accessibilité?
public

3. De quelle classe dépend-elle?
java.text.DecimalFormat, java.lang.Math

4. Quels sont les noms, types et accessibilités des attributs d'objets (non statique)?
coteA, coteB, coteC, tous des double, tous private

5. Quels sont les noms, types et accessibilités des attributs de classe (statique)?
PRECISION, type double, accessibilité private

6. Quels sont les noms de toutes les méthodes de classe (statique)?
aPartirDeACA, AAC et CAC

7. Quel est le numéro de ligne où se trouve la signature de la méthode "description"?
148

8. Quelle est la dernière ligne du corps de la méthode "description"?
150, 157 ou 158

9. Quelle est la signature des constructeurs?
 public Triangle()
 public Triangle(double coteA, double coteB, double coteC)

10. Parmi les méthodes, donnez le nom de tous les mutateurs?
setCoteA, setCoteB et setCoteC. setCotes

11. Parmi les méthodes donnez le nom de tous les accesseurs?
getCoteA, getCoteB, getCoteC. estValide(), estEquilateral, ..., aire, perimetre

12. Rédigez la documentation complète de "périmètre"
    Ses paramètres explicites : Aucun
    Son type de retour : double
    Une description courte de son rôle : retourner le périmètre du triangle

13. Rédigez la documentation complète de "aPartirDeACA"
    Ses paramètres explicites : double angleA, double coteC, double angleB.
                                Deux angles et leur côté adjacent
    Son type de retour : Triangle
    Une description courte de son rôle : Crée un nouveau triangle
    avec les angles données (en radian) et leur côté adjacent

14. Donnez la signature d'une méthode surchargée.
private boolean estValide()

15. Deux méthodes devraient être dans une autre classe. Elles n'ont pas rapport aux triangles, lesquelles?
    aPeuPres et formatDouble

16. Combien d'objets de type Triangle sont-ils créés pendant l'exécution du main?
5 : L.19, L.22, L.30, L.33, L47

17. Combien de variables de type Triangle sont-elles déclarées dans main?
6 : desArpenteurs, iso, iso2, equilateral, rec, triangleUsager

18. Combien de fois main appelle-t-elle un constructeur de Triangle?
2 appels directs au constructeur dans le main. L.19, L.47

19.	Programmez la fonction
    double hauteurA() // Retourne la hauteur au-dessus du cote a

 base * hauteur / 2 = aire


----- Défis (facultatif) ------

A. La classe Triangle contient des méthodes statiques. Selon vous, pourquoi est-ce que j'ai choisi de mettre ces
   méthodes statiques?

B. La classe Triangle contient des méthodes privées. Selon vous, pourquoi est-ce que j'ai choisi de mettre ces méthodes
   privées?

C. Modifiez la méthode "public boolean estEgal(Triangle t)"  pour qu'elle retourne vrai si le triangle est une
   permutation des côtés de t.

D. Ajoutez la méthode "public boolean estSemblable(Triangle t)" qui retourne vrai si le triangle est égal à t ou une
   homothétie de t.

*/