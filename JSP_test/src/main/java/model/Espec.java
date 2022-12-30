package model;

public class Espec {
	private String idespecs;
	private String nome_espec;

	public Espec() {
		super();
	}
	
	public Espec(String idespecs, String nome_espec) {
		super();
		this.idespecs = idespecs;
		this.nome_espec = nome_espec;
	}

	public String getidespecs() {
		return idespecs;
	}
	public void setidespecs(String idespecs) {
		this.idespecs = idespecs;
	}
	public String getnome_espec() {
		return nome_espec;
	}
	public void setnome_espec(String nome_espec) {
		this.nome_espec = nome_espec;
	}
}
