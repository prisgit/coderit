package data;
import java.time.LocalDate;

import utils.StaffUtilities;

public class Dipendente {	
	//variabili d'istanza
	private int id;
	private String nome;
	private String cognome;
	private String ruolo;
	private int idRiporto;
	private LocalDate dataAssunzione;
	private double salario;

	//costruttore completo	
	public Dipendente(int id, String nome, String cognome, String ruolo, int idRiporto, LocalDate dataAssunzione) {
		setId(id);
		setNome(nome);
		setCognome(cognome);
		setRuolo(ruolo);
		setIdRiporto(idRiporto);
		setDataAssunzione(dataAssunzione);	
	}
	
	//costruttore mancante della data di assunzione (da usare per alcuni manager)
	//il valore della data di assunzione non è rilevante trattandosi di dirigenti e manager. Però, se in futuro dovessero cambiare 
	//le modalità di calcolo degli stipendi, bisogna tenerne conto e modificare questa parte
	public Dipendente(int id, String nome, String cognome, String ruolo, int idRiporto) {
		this(id, nome, cognome, ruolo, idRiporto, StaffUtilities.INIZIO);	
	}
	
	//costruttore mancante di due parametri (da usare per dirigenti e alcuni manager)
	//il valore della data di assunzione non è rilevante trattandosi di dirigenti e manager. Però, se in futuro dovessero cambiare 
	//le modalità di calcolo degli stipendi, bisogna tenerne conto e modificare questa parte
	public Dipendente(int id, String nome, String cognome, String ruolo) {
		this(id, nome, cognome, ruolo, StaffUtilities.NESSUNO, StaffUtilities.INIZIO);	
	}
	
	//getters&setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getIdRiporto() {
		return idRiporto;
	}

	public void setIdRiporto(int idRiporto) {
		this.idRiporto = idRiporto;
	}

	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
