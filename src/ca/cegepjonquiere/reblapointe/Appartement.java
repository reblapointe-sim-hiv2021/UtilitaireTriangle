package ca.cegepjonquiere.reblapointe;

public class Appartement {
    private int nbChambres;
    private int nbSallesDeBain;
    private double loyer;

    public static final double TAUX_DAUGMENTATION_MAXIMUM = 0.05;

    public Appartement() {
    }



    public Appartement(int nbChambres, int nbSallesDeBain, double loyer) {
        this.nbChambres = nbChambres;
        this.nbSallesDeBain = nbSallesDeBain;
        this.loyer = loyer;
    }

    public int getNbChambres() {
        return nbChambres;
    }

    /**
     * Set le nombre de chambres
     * @param nbChambres
     */
    public void setNbChambres(int nbChambres) {
        this.nbChambres = nbChambres;
    }

    public int getNbSallesDeBain() {
        return nbSallesDeBain;
    }

    public void setNbSallesDeBain(int nbSallesDeBain) {
        this.nbSallesDeBain = nbSallesDeBain;
    }
    
    public double getLoyer() {
        return loyer;
    }

    public void setLoyer(double loyer) {
        this.loyer = loyer;
    }

    public void ecrireAnnonce(){
        System.out.println("Appartement disponible, " + nbChambres + " chambre(s) et " + nbSallesDeBain +
                " salle(s) de bain. Loyer de " + Math.round(loyer) + "$ par mois.");
    }
}
