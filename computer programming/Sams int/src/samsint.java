import java.awt.AWTException;
import java.io.IOException;
import java.util.Random;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class samsint{
	public static void main(String[] args) throws InterruptedException,
			AWTException, IOException {		
		Random randomizer = new Random();
		Robot r = new Robot();
		boolean b = true;
		Runtime.getRuntime().exec("notepad");
		Thread.sleep(2000);
		// while(b){
		for (long i = 0; i < 10000000; i++){
			
			
			if (randomizer.nextInt(2) == 0) {
				r.keyPress(KeyEvent.VK_0);
				Thread.sleep(8);
				r.keyPress(KeyEvent.VK_LEFT);
				Thread.sleep(8);
			}
			if (randomizer.nextInt(2) == 1) {
				r.keyPress(KeyEvent.VK_1);
				Thread.sleep(8);
				r.keyPress(KeyEvent.VK_LEFT);
				Thread.sleep(8);
			}
			
			
		}
	}

	
		
	}


