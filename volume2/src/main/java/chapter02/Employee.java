package chapter02;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.*;

public class Employee implements Externalizable
{
   public static final int NAME_SIZE = 40;
   public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;

   private String name;
   private double salary;
   private LocalDate hireDay;

   public Employee() {}

   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      hireDay = LocalDate.of(year, month, day);
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public LocalDate getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public String toString()
   {
      return getClass().getName() 
         + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
   }

   @Override
   public void writeExternal(ObjectOutput out) throws IOException {
      out.writeUTF(name);
      out.writeDouble(salary);
      out.writeLong(hireDay.toEpochDay());
   }

   @Override
   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      name = in.readUTF();
      salary = in.readDouble();
      hireDay = LocalDate.ofEpochDay(in.readLong());
   }
}
