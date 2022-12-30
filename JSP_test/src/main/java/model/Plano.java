package model;

public class Plano {
	private String idplan;
	private String nome_plan;

	public Plano() {
		super();
	}
	
	public Plano(String idplan, String nome_plan) {
		super();
		this.idplan = idplan;
		this.nome_plan = nome_plan;
	}

	public String getidplan() {
		return idplan;
	}
	public void setidplan(String idplan) {
		this.idplan = idplan;
	}
	public String getnome_plan() {
		return nome_plan;
	}
	public void nome_plan(String nome_plan) {
		this.nome_plan = nome_plan;
	}
}
