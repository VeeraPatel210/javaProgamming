
import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String toString() {
        return id + " " + name + " " + password;
    }
}

 class SaveLoad {
    public static void main(String[] args) throws Exception {
        Student[] students = {
                new Student(1, "Veera", "abc123"),
                new Student(2, "Riya", "xyz456")
        };

        ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("students.dat"));
        out.writeObject(students);
        out.close();

        ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("students.dat"));
        Student[] loaded = (Student[]) in.readObject();
        in.close();

        for (Student s : loaded)
            System.out.println(s);
    }
}
