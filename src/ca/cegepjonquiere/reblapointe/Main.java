package ca.cegepjonquiere.reblapointe;

import java.util.Scanner;
import java.util.regex.*;

public class Main extends Appartement {

    public static void main(String[] args) {

    // CODE POSTAL ********************************************************
        Pattern patronCodePostal = Pattern.compile("\\b([a-z]|[0-9])+@[a-z]([a-z]|[0-9])*\\.[a-z]([a-z]|[0-9])*\\b", Pattern.CASE_INSENSITIVE);
        Scanner in = new Scanner(System.in);
        System.out.println("Entrez un code postal");
        String entree = in.nextLine();
        Matcher matche = patronCodePostal.matcher(entree);

        if(matche.find())
            System.out.println("Merci! Code postal entré : " + matche.group());
        else
            System.out.println("Ceci n'est pas un code postal.");


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