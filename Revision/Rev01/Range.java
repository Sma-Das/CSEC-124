import java.util.*;

interface Range extends Iterable<Integer> {
  int size();
  
  int get(int index);
  
  Iterator<Integer> iterator();
  
}
   