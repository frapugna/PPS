package domainClasses;

/*
 * delete this class before running the real application, it is a sort of tutorial about the use of the Dealer class
 */

public class TmpMain {

	public static void main(String[] args) {
		Dealer d = new Dealer();
		AbstractCardData c; 
		while(true) {
			c = d.drawCard();
			System.out.println(c.name);
			
			if(c instanceof MinionData) {	//use the "instanceof"(getClass doesn't work) to check before downcasts
				System.out.println("Minion found, exiting execution");
				MinionData m = (MinionData) c;
				System.out.println("Minion data is going to be displayed:"+"hp = "+m.hp+" Name = "+m.name);
				break;
			}
			
		}
			
		
	}

}
