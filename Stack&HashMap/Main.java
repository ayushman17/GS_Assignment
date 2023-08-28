// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Stack<T>{
    private T[]a;
    public Stack(T[] a){
        this.a =a;
    }
    //private int [] a= new int[10];
    private int index =-1;
    public Stack(){}
    public void push (T element){
        if(!isFull())
            a[++index]=element;
        else
            throw new RuntimeException("Stack OverFlow");
    }
    public T pop(){
        if(!isEmplty())
            return a[index--];
        throw new RuntimeException("Stack UnderFlow");
    }
    private boolean isFull(){
        return index ==9;
    }
    private boolean isEmplty(){
        return index ==-1;
    }
}

public class Main {
    public static void main(String[] args) {
//        Stack <Integer> s= new Stack<Integer>(new Integer[10]);
//        for(int i=1;i<=10;i++)
//            s.push(i);
//        for (int i=1;i<=10;i++)
//            System.out.println(s.pop());
//
//        Stack <Double> ds= new Stack<Double>(new Double[10]);
//        for(int i=1;i<=10;i++)
//            ds.push(i*2.5);
//        for (int i=1;i<=10;i++)
//            System.out.println(ds.pop());
//
//        Stack <String> ss= new Stack<String>(new String[10]);
//        for(int i=1;i<=10;i++)
//            ss.push(i+"Hello");
//        for (int i=1;i<=10;i++)
//            System.out.println(ss.pop());
//        ArrayList<String> slist =new ArrayList<>();// capacity 10 initially;
//        slist.add("HII");
//        System.out.println(slist.size());
//        System.out.println(slist.);
//        System.out.println("tqt"=="tqt");
        HashMap <Employee,Address> map = new HashMap<>();
        map.put(new Employee(101,"Ajay",1000,10),new Address("a","aa","assa","assssa"));
        map.put(new Employee(102,"Ajaaaay",10300,20),new Address("ab","aa","aa","aaff"));
        map.put(new Employee(103,"ram",10060,30),new Address("abb","aaa","aqqa","aqqa"));

//        Iterator<Map.Entry<Employee, Address>> mapIterator = map.entrySet().iterator();
//        while(mapIterator.hasNext()){
//            Map.Entry mapElement = mapIterator.next();
//            System.out.println("Employee : "+mapElement.getKey()+"\nAddress : "+mapElement.getValue());
//            System.out.println("---------------------------");
//        }
//
//        Set<Map.Entry<Employee,Address>> entry = map.entrySet();
//        for(Map.Entry<Employee,Address> e:entry){
//            System.out.println(e.getKey()+ "              "+e.getValue());
//        }
        //map.entrySet().forEach(System.out::println);
//        map.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });

                Iterator<Map.Entry<Employee, Address>> mapIterator = map.entrySet().iterator();
        while(mapIterator.hasNext()){
            Map.Entry mapElement = mapIterator.next();
            System.out.println("Employee : "+mapElement.getKey()+"\nAddress : "+mapElement.getValue());
            System.out.println("---------------------------");
        }
//                Set<Map.Entry<Employee,Address>> entry = map.entrySet();
//        for(Map.Entry<Employee,Address> e:entry){
//            System.out.println(e.getKey()+ "              "+e.getValue());
//        }
        //map.forEach((k, v) -> System.out.println((k + ":" + v)));

    }
}