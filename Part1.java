import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class Part1 {
public static void main(String[] args) {
    // built-in data 
    // array
    int [] numbers  = {1,2,3};

    // LinkedList
    LinkedList<String> list = new LinkedList<>();
    list.add("item1");

    // Stack
    Stack<Integer> stack = new Stack<>();
    stack.push(1);

    // Queue
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    queue.offer(2);

    // HashMap
    HashMap<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1,"one");
    hashMap.put(2, "two");
    System.out.println(hashMap.get(2));

    // Tree map
    TreeMap<Integer,String> map= new TreeMap<>();
    map.put(1,"new value");

    // array list
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);

    // set
    HashSet<Integer> set = new HashSet<>();
    set.add(1);

}
    
}