import java.util.*;
import java.util.Random;

public class Ambulance implements Runnable {
	
	//Graph of the street
	
	 int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
             {4, 0, 8, 0, 0, 0, 0, 11, 0},
             {0, 8, 0, 7, 0, 4, 0, 0, 2},
             {0, 0, 7, 0, 9, 14, 0, 0, 0},
             {0, 0, 0, 9, 0, 10, 0, 0, 0},
             {0, 0, 4, 0, 10, 0, 2, 0, 0},
             {0, 0, 0, 14, 0, 2, 0, 1, 6},
             {8, 11, 0, 0, 0, 0, 1, 0, 7},
             {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };
	 
	 
	 //Variables
		private Street street; 
		private int accidentCoor, ambulanceCoor,ambulances;
		//id ambulance
		private int idP;
		//time for the accident to appear and simulate that theres a need for ambulance which will be determined as random in the constructor
		private int waitingTime;
		//time from the source to the destination
		private int routeTime;
		//
		private boolean inService, attending;
		
		
		//Calculating the distance form the point of the ambulance to the accident	
		Dijkstra dijkstra= new Dijkstra(graph,accidentCoor,ambulanceCoor);

		//Constructor
		public Ambulance(int idP, Street street, int ambulances, int accidentCoor) {
			this.idP=idP;
			this.street=street;
			this.accidentCoor=accidentCoor;
			
			this.ambulances=ambulances;
			
			Random r= new Random();
			
			//Ambulance Coordinate
			ambulanceCoor=r.nextInt(8)+1;
			//Time for it to appear in service
			waitingTime=r.nextInt(20)+1;
			//time to the accident
			
			inService=true;
			
			
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//Time to appear in service
			System.out.println("Ambulance "+idP+" will be in service in "+waitingTime+" seconds.");
			Thread.sleep(waitingTime = 1000);
			
			if(inService) {
				System.out.println("Ambulance "+idP+" is in service");
				street.inServiceStreet(idP);
				
				
				//Dijkstra
				System.out.println("ACCIDENT LOCATION: "+accidentCoor);
				
				

				dijkstra.dijkstra(graph, accidentCoor,idP);

				Thread.sleep(routeTime= 1000);
				dijkstra.whichAmbulance();
				
				if(idP==ambulances-1) {

					dijkstra.infoAttend();
					street.attendingAccident(idP);
					

					street.setInService(0);
					//			
					//Thread.sleep(routeTime * 1000);

					//crea un nuevo accidente en secuencia y llama al dijkstra
					
					//dijkstra.dijkstra(graph, accidentCoor,idP);

				}
			}
			
			


			
			
		}catch(InterruptedException e) {
			System.out.println("InterruptedException Occurred");
		}
		
	}

}
