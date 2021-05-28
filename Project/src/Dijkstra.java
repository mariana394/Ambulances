
public class Dijkstra {
	
	//#of vertex
			static final int V  = 9;
			static int idA=0;
			static int[] distancias;
			static int distanceW=0,ambulanceId=0, accident=0;
			
			
	public static void fillArray(int ambulances) {
		distancias=new int[ambulances];
		 
		for(int j=0;j<ambulances;j++) {
			distancias[j]=0;
			
		}
	}
			
		
	public Dijkstra(int[][] graph, int accidentCoor, int ambulanceCoor) {
		
	}
	
	//Function for finding the minimun distance between 2 vertes: between the vertex 
	//where the ambulance is in and the accident
	
	private static int minDistance(int[] dist, boolean[] verticeYaProcesado){
	   // Initialize min value
	   int min = Integer.MAX_VALUE; int min_index=0;
	 
	   for (int v = 0; v < V; v++)
	     if (verticeYaProcesado[v] == false && dist[v] <= min) {
	         min = dist[v];
	         min_index = v;
	      }
	 
	   return min_index;
	}
	
	//Function for printing the answer of the minimun distance of the ambulance
	private static void printSolution(int[] dist, int n,int ambulanceCoor, int accidentCoor){
	
	   int distancia=0;
	   for (int i = 0; i < V; i++) {
		   if(i==ambulanceCoor) {
			   distancia=dist[i];
			  infoAmbulance(distancia,ambulanceCoor);
			  
		   }
		 
	   }
	   
	      System.out.println( "Source (Ambulance Location): "+ambulanceCoor+" Destination (Accident Location): "+accidentCoor+ " Distance: " + distancia);
	      //return distancia;
	}
	
	//Applying the dijkstra algorithm
	public static void dijkstra(int[][] grafo, int src,int ambulanceCoor){
		
	     accident=src;
		int[] dist = new int[V];     
	    // dist[i] saves the shortes distance from the src to the vertex i
	 
	 
	     boolean[] verticeYaProcesado = new boolean[V]; 
	     //True if the verte has been already checked
	 
	     // Initialize all distances as INFINITE and stpSet[] as false
	     for (int i = 0; i < V; i++) {
	        dist[i] = Integer.MAX_VALUE;
	        verticeYaProcesado[i] = false;
	     }
	     // The distance from a vertex to itself is always 0
	     dist[src] = 0;
	 
	     //Shortest path for all the vertex
	     for (int count = 0; count < V-1; count++){

	       //Toma el vertice con la distancia minima del cojunto de vertices aun no procesados
	       //En la primera iteracion siempre se devuelve src
	       int u = minDistance(dist, verticeYaProcesado);
	 
	       // vertex will turn true because it has already been visited
	       verticeYaProcesado[u] = true;
	 
	       // Update dist value of the adjacent vertices of the picked vertex.
	       for (int v = 0; v < V; v++)

	         //Se actualiza la dist[v] solo si no esta en verticeYaProcesado, hay un
	         //arco desde u a v y el peso total del camino desde src hasta v a traves de u es 
	         // mas pequeno que el valor actual de dist[v]
	         if (!verticeYaProcesado[v] && grafo[u][v] > 0 && dist[u] != Integer.MAX_VALUE 
	                                       && dist[u]+grafo[u][v] < dist[v])
	            dist[v] = dist[u] + grafo[u][v];
	     }
	 
	     // se imprime el arreglo con las distancias
	     printSolution(dist, V,ambulanceCoor,src);
	}
	
	//Function for knowing the ambulance information
	public static void infoAmbulance(int distancia, int idA) {
		

		distancias[idA]=distancia;
		
	    //System.out.println( "distancia "+ distancias[idA]+" ambulancia "+idA);
	    
		//printS(distancias,idA);
	}
	//Function for knowing which ambulance is going to be the one to go and attend the accident

	public static void whichAmbulance(){
		/*for(int i=0;i<distancias.length;i++) {
		    System.out.println( "............................... "+i+" distancia ganadora "+distancias[i]);

		}*/
		 distanceW=distancias[0];
		for(int i=0;i<distancias.length;i++) {
		    System.out.println( "------------------------------------------------------------------------ Ambulance = "+i+" Distance(seconds) = "+distancias[i]+" Shortest Path= "+distanceW);

			if(distanceW>distancias[i]) {
				
				distanceW=distancias[i];
				ambulanceId=i;
			}
			
		/*	if(distanceW==distancias[i]) {
			    System.out.println( "hola" + distanceW+"soy igual "+distancias[i] );

			}*/
		}
	   // System.out.println( "distancia ganadora "+distanceW+" aID "+ambulanceId );
	}
	
	//Function for getting the information of the ambulance that is going to go to attend the accident
	
	public static void infoAttend() {
		//cambiar el alor de ese
		
	//	distancias[ambulanceId]=-1;
	    System.out.println( "------Ambulance attending the accident in location "+accident+" is ambulanceID: "+ambulanceId +" it will take "+distanceW+" seconds to arrive------ ");

		
	}
	
	public static void backToService() {
		distancias[ambulanceId]=0;
	    System.out.println( "Free");
	}
	
	
}
