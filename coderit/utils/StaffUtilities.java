package utils;

import java.time.LocalDate;

public class StaffUtilities {

	//costanti
	public static final String DIRIGENTE = "Dirigente";
	public static final String MANAGER = "Manager";
	public static final String TECNICO = "Tecnico";
	public static final int NESSUNO = 0;		//per indicare chi non ha un riporto (dirigenti o alcuni manager)
	public static final LocalDate OGGI = LocalDate.now();
	public static final LocalDate INIZIO = LocalDate.of(2000, 01, 01);
	
	//metodo di utilità che calcola gli anni che separano una data nel passato dalla data di oggi
	public static int calcolaAnni(LocalDate data) {
		int anni = StaffUtilities.OGGI.getYear() - data.getYear();
		int deltaMesi = StaffUtilities.OGGI.getMonthValue() - data.getYear();
		if (deltaMesi < 0) {
			anni--;
		} 
		else if (deltaMesi == 0) {
			if ((StaffUtilities.OGGI.getDayOfMonth() - data.getDayOfMonth()) < 0) {
				anni--;
			}
		}
		return anni;
	}

}
