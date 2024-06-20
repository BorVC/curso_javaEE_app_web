package model;

public class Resultado {

	private String url;
	private String categoria;
	private String titulo;
	
	public Resultado(String url, String categoria, String titulo) {
		super();
		this.url = url;
		this.categoria = categoria;
		this.titulo = titulo;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
