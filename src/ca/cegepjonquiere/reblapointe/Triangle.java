package ca.cegepjonquiere.reblapointe;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Triangle {

    private static final double PRECISION = 0.001;

    private double coteA;
    private double coteB;
    private double coteC;

    public Triangle(){
        coteA = 1;
        coteB = 1;
        coteC = 1;
    }

    public Triangle(double coteA, double coteB, double coteC) {
        if (!estValide(coteA, coteB, coteC))
            throw new IllegalArgumentException();
        this.coteA = coteA;
        this.coteB = coteB;
        this.coteC = coteC;
    }

    // Deux angles et le côté entre les deux sont connus. En radians.
    public static Triangle aPartirDeACA(double angleA, double coteC, double angleB){
        double angleC = PI - angleA - angleB;
        return new Triangle (coteC * sin(angleA) / sin(angleC),
                coteC * sin(angleB) / sin(angleC),
                coteC);
    }

    // Deux angles et un côté qui n'est pas entre les deux est connu. En radians.
    public static Triangle aPartirDeAAC(double angleA, double angleC, double coteC){
        double angleB = PI - angleA - angleC;
        return new Triangle (coteC* sin(angleA) / sin(angleC),
                coteC* sin(angleB) / sin(angleC),
                coteC);
    }
    // Deux côté et l'angle entre les deux est connu. En radians.
    public static Triangle aPartirDeCAC(double coteB, double angleA, double coteC){
        double coteA = sqrt(coteB * coteB + coteC * coteC - 2 * coteB * coteC * cos(angleA));
        return new Triangle (coteA, coteB, coteC);
    }

    public double aire(){
        double p = perimetre() / 2;
        return sqrt(p * (p - coteA) * (p - coteB) * (p - coteC));
    }
    
    public double perimetre(){
        return coteA + coteB + coteC;
    }

    private boolean estValide(double coteA, double coteB, double coteC){
        return (coteA < coteB + coteC) && (coteB < coteA + coteC) && (coteC < coteA + coteB);
    }

    private boolean estValide(){
        return estValide(this.coteA, this.coteB, this.coteC);
    }

    public void setCotes(double coteA, double coteB, double coteC) {
        if (!estValide(coteA, coteB, coteC))
            throw new IllegalArgumentException();
        this.coteA = coteA;
        this.coteB = coteB;
        this.coteC = coteC;
    }

    private boolean aPeuPres(double x, double y){
        return (x > y - PRECISION) && (x < y + PRECISION);
    }

    public boolean estEquilateral(){
        return aPeuPres(coteA, coteB) && aPeuPres(coteA, coteC);
    }

    public boolean estIsocele(){
        return aPeuPres(coteA, coteB) || aPeuPres(coteA, coteC) || aPeuPres(coteB, coteC);
    }

    public boolean estRectangle(){
        return aPeuPres(angleA(), PI / 2) || aPeuPres(angleB(), PI / 2) || aPeuPres(angleC(), PI / 2);
    }

    public boolean estScalene(){
        return !estIsocele();
    }
    
    public boolean estEgalA(Triangle triangle) {
        return aPeuPres(triangle.coteA, coteA) && aPeuPres(triangle.coteB, coteB) && aPeuPres(triangle.coteC, coteC);
    }

    // En radians.
    public double angleA(){
        return acos((coteB * coteB + coteC * coteC - coteA * coteA) / (2 * coteB * coteC));
    }

    // En radians.
    public double angleB(){
        return acos((coteA * coteA + coteC * coteC - coteB*coteB) / (2 * coteA * coteC));
    }

    // En radians.
    public double angleC(){
        return acos((coteA * coteA + coteB * coteB - coteC * coteC) / (2 * coteA * coteB));
    }

    public double getCoteA() {
        return coteA;
    }

    public void setCoteA(double coteA) {
        if (!estValide(coteA, this.coteB, this.coteC))
            throw new IllegalArgumentException();
        this.coteA = coteA;
    }

    public double getCoteB() {
        return coteB;
    }

    public void setCoteB(double coteB) {
        if (!estValide(this.coteA, coteB, this.coteC))
            throw new IllegalArgumentException();
        this.coteB = coteB;
    }

    public double getCoteC() {
        return coteC;
    }

    public void setCoteC(double coteC) {
        if (!estValide(this.coteA, this.coteB, coteC))
            throw new IllegalArgumentException();
        this.coteC = coteC;
    }

    private String formatDouble(double x){
        return new DecimalFormat("#.##").format(x);
    }

    public String description() {
        final int PAD = 15;
        return  "{a = " + String.format("%1$-" + PAD + "s", formatDouble(coteA)) +
                 "b = " + String.format("%1$-" + PAD + "s", formatDouble(coteB)) +
                 "c = " + String.format("%1$-" + PAD + "s", formatDouble(coteC) + "}") + "\n" +
                "{A = " + String.format("%1$-" + PAD + "s", formatDouble(angleA()) + " (" + formatDouble(Math.toDegrees(angleA())) + "°)") +
                 "B = " + String.format("%1$-" + PAD + "s", formatDouble(angleB()) + " (" + formatDouble(Math.toDegrees(angleB())) + "°)") +
                 "C = " + String.format("%1$-" + PAD + "s", formatDouble(angleC()) + " (" + formatDouble(Math.toDegrees(angleC())) + "°)}") +
                "\naire = " + formatDouble(aire()) + "   perimetre = " + formatDouble(perimetre()) + "\n" +
                (estEquilateral() ? "équilatéral" : estIsocele() ? "isocèle" : "scalène") + (estRectangle() ? " rectangle" : "") + "\n";
    }
}
