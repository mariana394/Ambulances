/*Mariana Favarony Avila
 * A01704671
 * Final Project Programming Languages
 */

import java.util.Random;

public class Main {

	public volatile static int ambulanceCoor=0;

	
	public static void main (String args[]) throws InterruptedException {
		
		Random r= new Random();
		int prueba=0;
		int accidents;
		

		//# of Ambulances
			//int ambulances=0;
				int ambulances=r.nextInt(8);
				System.out.println("Pool of ambulances: "+ambulances);
				
		
		//# of accidents random 
				//accidents=2;
				 accidents=r.nextInt(5);

					System.out.println("Number of accidents: "+accidents);

				int accidentCoor=r.nextInt(8)+1;
				//int accidentCoor=2;
				//System.out.println(accidentCoor);
				
				
		//Fill in array of accidents
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
		 
		//accidentCoor=r.nextInt(8)+1;
		
		boolean flag=false;
		Street s=new Street();

		Ambulance a[]=new Ambulance[ambulances];
		Thread t[]=new Thread[a.length];
		Dijkstra dijkstra= new Dijkstra(graph,accidentCoor,ambulanceCoor);

		 dijkstra.fillArray(ambulances);
		 
		 if(accidents==0) {
				System.out.println("------------------------NO ACCIDENTS TO BE ATTENDED-------------");

		 }
		 
		 
		for(int z=0;z<accidents;z++) {
			 if(ambulances==0) {
					System.out.println("------------------------NO AMBULANCES IN SERVICE-------------");
					break;
			 }
			
			accidentCoor=r.nextInt(8)+1;


				for(int i=0;i<ambulances;i++) {	
					
					
					if((ambulances-z)>0) {
					//start threads
					a[i]=new Ambulance(i,s,ambulances,accidentCoor);
					t[i]=new Thread(a[i]);
					t[i].start();
					t[i].join();
					//break;
					}
					
					
					
					
					//
					//t[i].stop();
					//t[i].join();
						
						
					}
				if((ambulances-z)<=0) {
					System.out.println("------------------------ACCIDENT IN LOCATION: "+accidentCoor+ " IS WAITING TO BE ASSIGNED AN AMBULANCE-------------");
				}
				}
			

				

		
		
	}

}
