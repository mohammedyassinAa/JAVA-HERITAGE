
import java.util.ArrayList;
import java.util.List;

public class GestionArtistes {

    public static void main(String[] args) {
        // Créer des listes d'acteurs et de guitaristes
        List<Acteur> listeActeurs = new ArrayList<>();
        List<Guitarist> listeGuitaristes = new ArrayList<>();


        // Appeler la méthode lesArtistes
        List<Artiste> artistesRetournés = lesArtistes(listeGuitaristes, listeActeurs);

        // Traitements
        for (Artiste artiste : artistesRetournés) {
            if (artiste instanceof Acteur) {  // Vérifiez si l'artiste est un acteur
                Acteur acteur = (Acteur) artiste; // Cast vers Acteur
                acteur.nbrFilmes -= 2;  // Diminuer le nombre de films de 2
            } else if (artiste instanceof Guitarist) {  // Vérifiez si l'artiste est un guitariste
                Guitarist guitariste = (Guitarist) artiste; // Cast vers Guitarist
                guitariste.nbrMorceaux += 3;  // Augmenter le nombre de morceaux de 3
            }
        }

    public static List<Artiste> lesArtistes(List<Guitarist> l_gt, List<Acteur> l_ac) {
        // Déclaration de la liste qu'on doit retourner
        List<Artiste> returnedArtists = new ArrayList<Artiste>();

        for (Acteur a : l_ac) {
            if (a.nbrFilmes > 20)
                returnedArtists.add(a);
        }

        for (Guitarist g : l_gt) {
            if (g.anneDebu < 1998)
                returnedArtists.add(g);
        }

        return returnedArtists;
    }
    
    
}
    
    
    
    
    