package regalo;

public class Main {

	public static void main(String[] args) {

		Monton monton=new Monton(10);
		HermanoMayor hermano= new HermanoMayor(monton);
		Thread hiloHermano= new Thread(hermano);
		Thread[] alumnos= new Thread[5];
		
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i]= new Thread(new Alumno(monton));
		}
		hiloHermano.start();
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i].start();
		}
		
		try {
			hiloHermano.join();
			for (int i = 0; i < alumnos.length; i++) {
				alumnos[i].interrupt();
			}
		System.out.println("fin del programa");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		

	}

}
