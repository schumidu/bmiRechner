package bmiRechner;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Argument angeben");
		}else if(args.length > 1) {
			System.out.println("Zu viele Argumente angebeben");
		}
		if(args[0].equals("-gui")) {
			GUI g = new GUI();
			
		}else if(args[0].equals("-console")){
			new Console().run();
		}
	}
	
}
