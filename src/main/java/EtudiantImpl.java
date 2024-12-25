import Contrat.EtudiantPOA;
public class EtudiantImpl extends EtudiantPOA {
    private String nom;
    private String prenom;
    private long numero;
    private ArrayList<Epreuve> epreuves = new ArrayList<>();
    private ArrayList<Livre> livres = new ArrayList<>();

    // Constructeur
    public EtudiantImpl(String nom, String prenom, long numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }

    // Ajouter une épreuve
    public void Ajouter_une_epreuve(String nom, double note, double coefficient) {
        epreuves.add(new Epreuve(nom, note, coefficient));
    }

    // Liste des épreuves
    public String[] Liste_des_epreuves() {
        return epreuves.stream().map(Epreuve::getNom).toArray(String[]::new);
    }

    // Calculer la moyenne
    public double Calculer_la_moyenne() {
        double total = 0, sommeCoefficients = 0;
        for (Epreuve e : epreuves) {
            total += e.getNote() * e.getCoefficient();
            sommeCoefficients += e.getCoefficient();
        }
        return sommeCoefficients > 0 ? total / sommeCoefficients : 0;
    }

    // Emprunter un livre
    public void Emprunter_un_livre(String nom, String auteur, String collection, String datePublication) {
        livres.add(new Livre(nom, auteur, collection, datePublication));
    }
}
