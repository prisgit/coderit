package data;
import java.time.LocalDate;

import utils.StaffUtilities;
/*pattern Singleton:
 	1.variabile privata e statica dello stesso tipo della classe
	2.costruttore privato che dichiara ed inizializza la variabile d'istanza "dipendenti"
	3.un metodo statico pubblico che restituisca il reference all'unica istanza */

public class ListaDipendenti {
	//variabili d'istanza
	private Dipendente[] dipendenti;
	
	//altre variabili
	private static ListaDipendenti listaDipendenti;
	
	//costruttori
	private ListaDipendenti() {
		dipendenti = new Dipendente[] {
			new Dipendente(1, "Anna", "Arnoldi", StaffUtilities.DIRIGENTE),						
			new Dipendente(2, "Beniamino", "Brumotti", StaffUtilities.DIRIGENTE),				
			new Dipendente(3, "Emilia", "Eberini", StaffUtilities.MANAGER),						
			new Dipendente(4, "Carla", "Cattaneo", StaffUtilities.MANAGER, 3),
			new Dipendente(5, "Dario", "Dionigi", StaffUtilities.MANAGER),							
			new Dipendente(6, "Franco", "Fastoni", StaffUtilities.TECNICO, 4, LocalDate.of(2017,1,1)),
			new Dipendente(7, "Giorgia", "Grigioni", StaffUtilities.TECNICO, 4, LocalDate.of(2020,1,1)),
			new Dipendente(8, "Hector", "Hernandez", StaffUtilities.TECNICO, 4, LocalDate.of(2020, 1,1)),
			new Dipendente(9, "Ivana", "Iudice", StaffUtilities.TECNICO, 5, LocalDate.of(2010,1,1)),
			new Dipendente(10, "Ludovico", "Landini", StaffUtilities.TECNICO, 5, LocalDate.of(2008, 1,1)),
			new Dipendente(11, "Maria", "Maiolica", StaffUtilities.TECNICO, 5, LocalDate.of(2015, 1,1))
		};
	}

	//altri metodi
	public static ListaDipendenti getInstance() {
    	if (listaDipendenti == null) {
    		listaDipendenti = new ListaDipendenti();
    	}
    	return listaDipendenti;
    }

	//getters & setters
	public Dipendente[] getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(Dipendente[] dipendenti) {
		this.dipendenti = dipendenti;
	}
		
}
