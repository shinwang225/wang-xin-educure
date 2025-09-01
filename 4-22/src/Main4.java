
import java.io.FileReader;
import com.google.gson.Gson;

public class Main4 {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();

            FileReader reader = new FileReader("excersise.json");
            Employee employee = gson.fromJson(reader, Employee.class);
            reader.close();

            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Salary: " + (int)employee.getSalary());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
