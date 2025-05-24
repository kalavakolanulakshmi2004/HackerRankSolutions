import java.util.*;
import java.io.*;

class Student3 {
    private int id;
    private String name;
    private double cgpa;

    public Student3(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student3> getStudents(List<String> events) {
        PriorityQueue<Student3> queue = new PriorityQueue<>(new Comparator<Student3>() {
            public int compare(Student3 a, Student3 b) {
                if (Double.compare(b.getCGPA(), a.getCGPA()) != 0) {
                    return Double.compare(b.getCGPA(), a.getCGPA());
                } else if (!a.getName().equals(b.getName())) {
                    return a.getName().compareTo(b.getName());
                } else {
                    return Integer.compare(a.getID(), b.getID());
                }
            }
        });

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                queue.add(new Student3(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                queue.poll();
            }
        }

        List<Student3> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}

public class Sol56 {
    private static final Scanner scan = new Scanner(System.in);
    private static final Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student3> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student3 st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
