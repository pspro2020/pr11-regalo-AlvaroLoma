package regalo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class HermanoMayor implements Runnable {
	
	private Monton monton;
	
	

	public HermanoMayor(Monton monton) {
		super();
		this.monton = monton;
	}



	@Override
	public void run() {
	
		
		try {
			System.out.printf("Soy %s y estoy esperando a que se llene el monton a las %s \n"
					,this.getClass().getSimpleName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
			monton.llenar();
			System.out.printf("Soy %s, se ha llenado el monton a las %s me voy para la tienda\n",
					this.getClass().getSimpleName(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		} catch (InterruptedException e) {
			return;
		}
		
	}
	

	


	
}
