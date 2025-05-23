import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Sol31 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numStudents = Integer.parseInt(in.nextLine());
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < numStudents; i++) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            studentList.add(new Student(id, fname, cgpa));
        }

        // Sort the list using Comparator
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                if (Double.compare(b.getCgpa(), a.getCgpa()) != 0) {
                    return Double.compare(b.getCgpa(), a.getCgpa()); // Descending CGPA
                } else if (!a.getFname().equals(b.getFname())) {
                    return a.getFname().compareTo(b.getFname()); // Ascending name
                } else {
                    return Integer.compare(a.getId(), b.getId()); // Ascending ID
                }
            }
        });

        // Print only first names
        for (Student s : studentList) {
            System.out.println(s.getFname());
        }
    }
}
