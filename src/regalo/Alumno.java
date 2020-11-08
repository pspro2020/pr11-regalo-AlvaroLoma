package regalo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Alumno implements Runnable {
	
	private Monton monton;

	public Alumno(Monton monton) {
		
		this.monton = monton;
	}

	@Override
	public void run() {
		int dinero=0;
		
		 try {
			dinero=getDinero();
			System.out.printf("Soy el alumno %s y añado al monton %d € a las %s \n", Thread.currentThread().getName()
					,dinero,DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
			monton.añadirAlMonton(dinero);
			
		} catch (InterruptedException e) {
			return;
		}
		
	}

	private int getDinero() throws InterruptedException {
		TimeUnit.SECONDS.sleep(new Random().nextInt(8)+3);
		return new Random().nextInt(3)+2;
		
	}

}
