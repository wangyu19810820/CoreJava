package chapter02;

import java.io.*;

public class ExternalizableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee employee = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("src/main/java/chapter02/employee.dat"));
        o.writeObject(employee);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/java/chapter02/employee.dat"));
        Employee newEmployee = (Employee)in.readObject();
        in.close();

        System.out.println(newEmployee);
    }
}
