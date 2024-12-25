import Universite.Etudiant;
import Universite.Promotion;
import org.omg.CORBA.ORB;

public class Client {
    public static void main(String[] args) {
        try {
            // Initialisation de l'ORB
            ORB orb = ORB.init(args, null);

            // Obtenir une référence à l'objet Promotion
            Promotion promotion = ...; // Obtenir l'objet à partir du nom

            // Ajouter un étudiant
            promotion.ajouter_un_etudiant("Doe", "John", 12345);

            // Rechercher l'étudiant et ajouter des épreuves
            Etudiant etudiant = promotion.rechercher_un_etudiant(12345);
            etudiant.Ajouter_une_epreuve("Mathématiques", 16, 0.5);
            etudiant.Ajouter_une_epreuve("Physique", 14, 0.5);

            // Afficher les résultats
            System.out.println("Moyenne de l'étudiant : " + etudiant.Calculer_la_moyenne());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
