#include "Universite.hh"
#include <iostream>

int main(int argc, char* argv[]) {
    try {
        CORBA::ORB_var orb = CORBA::ORB_init(argc, argv);

        // Obtenir une référence à l'objet Promotion
        CORBA::Object_var obj = orb->string_to_object("corbaloc:://localhost:12345/Promotion");
        Universite::Promotion_var promotion = Universite::Promotion::_narrow(obj);

        // Ajouter un étudiant
        promotion->ajouter_un_etudiant("Smith", "Alice", 54321);

        // Rechercher l'étudiant et ajouter des épreuves
        Universite::Etudiant_var etudiant = promotion->rechercher_un_etudiant(54321);
        etudiant->Ajouter_une_epreuve("Biologie", 18, 0.4);
        etudiant->Ajouter_une_epreuve("Chimie", 15, 0.6);

        // Afficher la moyenne
        std::cout << "Moyenne de l'étudiant : " << etudiant->Calculer_la_moyenne() << std::endl;

    } catch (const CORBA::Exception& ex) {
        std::cerr << "Exception CORBA : " << ex << std::endl;
    }
    return 0;
}
