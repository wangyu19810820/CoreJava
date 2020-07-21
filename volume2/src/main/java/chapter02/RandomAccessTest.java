package chapter02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;

public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        var staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1998, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try(var out = new DataOutputStream(new FileOutputStream("src/main/java/chapter02/employee.dat"))) {
            for(Employee e : staff) {
                writeData(out, e);
            }
        }

        try (var in = new RandomAccessFile("src/main/java/chapter02/employee.dat", "r")) {
            int n = (int)(in.length() / Employee.RECORD_SIZE);
            var newStaff = new Employee[n];
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }

            for(Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    private static Employee readData(RandomAccessFile in) throws IOException {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m, d);
    }

    private static void writeData(DataOutputStream out, Employee e) throws IOException {
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());
        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }
}
