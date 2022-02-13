package apps;

import data.Dipendente;
import data.ListaDipendenti;
import utils.StaffUtilities;

public class Applicazione {
	private static Dipendente[] dipendenti = ListaDipendenti.getInstance().getDipendenti();		//popolo l'istanza con i dati reali
	
	//metodo di servizio che dato l'id dipendente restituisce un oggetto dipendente
	private static Dipendente cercaDipendente(int idDip) {
		Dipendente risultato = null;
		for (Dipendente dip : dipendenti) {
			if (dip.getId() == idDip) {
				risultato = dip;
			}
		}
		return risultato;	//se non trova nessun dipendente con quell'id, restituisce null
	}
	
	//metodo di servizio che dato l'id dipendente calcola lo stipendio di quel dipendente
	private static double calcolaStipendio(int idDip) {
		Dipendente dip = cercaDipendente(idDip);
		try {
			switch (dip.getRuolo()) {
			case StaffUtilities.TECNICO: {
				int anniAnzianita = StaffUtilities.calcolaAnni(dip.getDataAssunzione());
				if (anniAnzianita < 10) {
					return 1500D;
				}
				else {
					return 1600D;
				}
			}
			case StaffUtilities.MANAGER: {
				return 2000D + 0.05 * sommaSalariDeiRiporti(idDip);
			}
			case StaffUtilities.DIRIGENTE: {
				return 2500D + 0.1 * sommaSalariDeiNonDirigenti();
			}
			default: {
				System.out.println("Comportamento non previsto");
				return 0.0;
			}
			}
		} catch (NullPointerException exc) {
			System.out.println("Attenzione, il dipendente con id = " + idDip + "non esiste.");
		}
		return 0.0;		//se il dipendente con quell'id non è stato trovato, viene restituito un salario a 0 che non interferisce con i calcoli
	}

	//metodo di servizio che calcola la somma dei salari dei dipendenti che riportano al manager che ha l'id passato come parametro
	//serve per il calcolo del bonus dei manager
	private static double sommaSalariDeiRiporti(int idDip) {
		double sommaStipendi = 0.0;
		//scorro tutto l'array dipendenti e verifico quali dipendenti hanno quel manager come riporto
		for (Dipendente dip : dipendenti) {
			if ((dip.getIdRiporto()) == idDip) {
				//se il salario del dipendente è già stato calcolato ne uso il valore tramite getSalario, altrimenti lo calcolo 
				//rilanciando ricorsivamente il metodo calcolaStipendio
				sommaStipendi += ((dip.getSalario() == 0) ? calcolaStipendio(dip.getId()) : dip.getSalario()); 
			}
		}
		return sommaStipendi;
	}
	
	/* metodo di servizio che calcola la somma dei salari dei dipendenti TECNICI o MANAGER (li ho chiamati ruoli NON DIRIGENTI per 
	garantire una leggibilità del codice nel caso in futuro dovessero essere aggiunti ulteriori ruoli intermedi */
	private static double sommaSalariDeiNonDirigenti() {
		double sommaStipendi = 0.0;
		for (Dipendente dip : dipendenti) {
			switch (dip.getRuolo()) {
			case StaffUtilities.TECNICO, StaffUtilities.MANAGER: {
				sommaStipendi += ((dip.getSalario() == 0.0) ? calcolaStipendio(dip.getId()) : dip.getSalario()); 
				break;
			}
			case StaffUtilities.DIRIGENTE: {
				continue;
			}
			default: {
				System.out.println("Comportamento non previsto");
			};
			}			//end switch
		}
		return sommaStipendi;		
	}
	
	//metodo di servizio che calcola lo stipendio di tutti i dipendenti
	private static void calcolaStipendioDipendenti() {
		for (Dipendente dip : dipendenti) {
			dip.setSalario(calcolaStipendio(dip.getId()));
		}
	}
	
	//metodo pubblico per la stampa degli stipendi di tutti i dipendenti
	public void stampaStipendiDipendenti() {
		calcolaStipendioDipendenti();
		for (Dipendente dip : dipendenti) {
			System.out.println("Stipendio di " + dip.getNome() + " " + dip.getCognome() + ": " + dip.getSalario() + " €");
		}
	}
	
	//metodo pubblico per la stampa del totale degli stipendi dell'azienda
	public void stampaTotaleStipendiAzienda() {
		double totale = 0.0;
		for (Dipendente dip : dipendenti) {
			totale += dip.getSalario();
		}
		System.out.println("Totale stipendi azienda: " + Double.toString(totale) + " €");
	}
}
