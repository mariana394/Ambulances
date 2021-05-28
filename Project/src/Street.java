
public class Street {
	
	//each one will work as a counter and we will synchronize both 

	private int inService,attending;

	public Street(){
		inService=0;
		attending=0;
	}
	
	
	
	//Adding the ambulance in the street
	
	public int getInService() {
		return inService;
	}



	public void setInService(int inService) {
		this.inService = inService;
	}



	public synchronized void inServiceStreet(int idP) {
		inService++;
		
		//System.out.println("***Free ambulances "+getFree());
		
		

	}
	
	//Substracting the ambulances that have been assigned to an accident
	
	public synchronized void attendingAccident(int idP) {
		attending++;
		System.out.println("***Free ambulances "+getFree());

	}

	
	
	public synchronized int getFree() {
		return inService-attending;
		
	}
	
}
