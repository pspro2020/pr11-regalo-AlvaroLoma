package regalo;

import java.util.concurrent.CountDownLatch;

public class Monton {
	
	private final CountDownLatch monton;

	public Monton(int monton) {
		
		this.monton = new CountDownLatch(monton);
	}

	public void llenar() throws InterruptedException {
		monton.await();
		
	}

	public void añadirAlMonton(int money) {
		for (int i = 0; i <money; i++) {
			monton.countDown();
		}
		
	}

}
