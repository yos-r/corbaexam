import Contrat.PromotionPOA;
import java.util.ArrayList;
import java.util.HashMap;

class PromotionImpl extends PromotionPOA {
    private HashMap<Long, EtudiantImpl> etudiants = new HashMap<>();

    public void ajouter_un_etudiant(String nom, String prenom, long numero) {
        etudiants.put(numero, new EtudiantImpl(nom, prenom, numero));
    }

    public Etudiant rechercher_un_etudiant(long numero) {
        return etudiants.get(numero);
    }

    public double calculer_moyenne_de_la_promotion() {
        return etudiants.values().stream()
            .mapToDouble(EtudiantImpl::Calculer_la_moyenne)
            .average()
            .orElse(0);
    }
}