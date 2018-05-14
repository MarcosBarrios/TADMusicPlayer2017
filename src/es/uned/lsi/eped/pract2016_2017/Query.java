package es.uned.lsi.eped.pract2016_2017;

public class Query implements QueryIF {

	private String titulo;
	private String autor;
	private String genero;
	private String album;
	private int minAnno, maxAnno;
	private int minDuracion, maxDuracion;
	
	public Query (String t, String a, String g, String al,
					int minAnno, int maxAnno, int minDuracion,
					int maxDuracion){
		this.titulo = t;
		this.autor = a;
		this.genero = g;
		this.album = al;
		this.minAnno = minAnno;
		this.maxAnno = maxAnno;
		this.minDuracion = minDuracion;
		this.maxDuracion = maxDuracion;
	}
	
	public String getTitle() {
		return titulo;
	}

	public String getAuthor() {
		return autor;
	}

	public String getGenre() {
		return genero;
	}

	public String getAlbum() {
		return album;
	}

	public int getMin_year() {
		return minAnno;
	}

	@Override
	public int getMax_year() {
		return maxAnno;
	}

	@Override
	public int getMin_duration() {
		return minDuracion;
	}

	@Override
	public int getMax_duration() {
		return maxDuracion;
	}
}
