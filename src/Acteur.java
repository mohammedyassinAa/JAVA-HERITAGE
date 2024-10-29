public class Acteur extends Artiste{
	public String genre;
	public int nbrFilmes;
	
	public Acteur(int idArtiste, String genre ) {
		super(idArtiste);
		this.genre = genre;
	}
	
}
