package model;

public class JavaBeans {
	private String idPaciente;
	private String nomePaciente;
	private String nmCarteira;
	private String PlanSaude;
	private String especi;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idPaciente, String nomePaciente, String nmCarteira, String PlanSaude, String especi) {
		super();
		this.idPaciente = idPaciente;
		this.nomePaciente = nomePaciente;
		this.nmCarteira = nmCarteira;
		this.PlanSaude = PlanSaude;
		this.especi = especi;
	}

	public String getidPaciente() {
		return idPaciente;
	}
	public void setidPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getnomePaciente() {
		return nomePaciente;
	}
	public void setnomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getnmCarteira() {
		return nmCarteira;
	}
	public void setnmCarteira(String nmCarteira) {
		this.nmCarteira = nmCarteira;
	}
	public String getPlanSaude() {
		return PlanSaude;
	}
	public void setPlanSaude(String PlanSaude) {
		this.PlanSaude = PlanSaude;
	}
	public String getespeci() {
		return especi;
	}
	public void setespeci(String especi) {
		this.especi = especi;
	}
}
