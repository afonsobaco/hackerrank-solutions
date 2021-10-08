import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

class Student{
    private int id; 
    private String name; 
    private double cgpa;
    
    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID() {return id;}
    public String getName() {return name;} 
    public double getCGPA(){return cgpa;}
    
}

class Priorities{
    
    Comparator<Student> comparator = new Comparator<Student>(){
        @Override
        public int compare(Student a, Student b){
            if(a.getCGPA() != b.getCGPA()){
                return Double.compare(b.getCGPA(), a.getCGPA());
            } else if(a.getName() != b.getName()){
                return a.getName().compareTo(b.getName());
            }else{
                return a.getID() - b.getID();
            }
        }
    };
    
    public List<Student> getStudents(List<String> events){
        PriorityQueue<Student> students = new PriorityQueue(1, comparator);
        for(String event : events){
            if(event.startsWith("ENTER")){
                String[] s = event.split(" ");
                students.add(new Student(Integer.parseInt(s[3]), s[1], Double.parseDouble(s[2]) ));
            }else{
                students.poll();   
            }
           
        }
        List<Student> result = new ArrayList<Student>();
        while(!students.isEmpty()) {
            result.add(students.poll());
        }
        return result;
    }    
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
