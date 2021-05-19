public class Main {
   public static void main(String[] args) {
      wAdjacency<String> Graph = new wAdjacency<String>();
      
      String[] nodes = {"A", "B", "C", "D", "E", "F"};
      
      addToGraph(nodes, Graph);
      
      Graph.connect("A", "B", 5.0);
      Graph.connect("A", "D", 4.0);
      Graph.connect("A", "C", 3.0);
      Graph.connect("C", "B", 1.0);
      Graph.connect("E", "B", 2.0);
      Graph.connect("E", "C", 3.0);
      Graph.connect("B", "E", 1.0);      
      
      System.out.println(Graph.connected("A", "B")); 
      
      System.out.println(Graph.dijkstrasPath("D", "F"));
      
   }
   
   public static void addToGraph(String[] nodes, wAdjacency<String> Graph) {
      for (String node: nodes) {
         Graph.add(node);
      }
   }
}