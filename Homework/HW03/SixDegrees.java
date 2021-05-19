public class SixDegrees {
   


/**

CSEC.124.601 HW03

@author Sma Das
@author Haithem Darwish
@author Pragun Khanna
@author Wissam El Labban


*/
   public static void main(String[] args) {
      AdjacencyGraph films = new AdjacencyGraph<String>();
      
      String[] films1 = {"The Godfather", "Marlon Brando" , "Al Pacino" , "James Caan"};
      String[] films2 = {"Serpico", "Al Pacino", "John Randolph", "Jack Kehoe"};
      String[] films3 = {"Midnight run", "Jack Kehoe", "John Ashton", "Charles Grodin"};
      String[] films4 = {"Gone Baby Gone", "Morgan Freeman", "John Ashton", "Casey Affleck"};
      String[] [] allFilms = {films1, films2, films3, films4};
      
      for (String[] film: allFilms) {
         connectStrings(film, films); // Add movies and actors
      }
      
      // System.out.println(films.connected("The Godfather", "Al Pacino"));
      // System.out.println(films.connected("Serpico", "Al Pacino")); // Check connected
      
      System.out.println(films.BFS("Al Pacino", "Jack Kehoe"));
      
      System.out.println(films);
      System.out.println("Testing");    
   }
   
   public static void connectStrings(String[] vertices, AdjacencyGraph films) {
      String movie = vertices[0];
      films.add(movie);
      for(int i=1; i < vertices.length; i++){
         films.add(vertices[i]);
         films.connectUndirected(movie, vertices[i]); // Add the actor to the movie
      }  
   }  
}