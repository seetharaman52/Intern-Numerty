import java.util.*;

class Employee{
    private long emp_no;
    private String emp_name;
    private float emp_salary;

    Employee(long emp_no, String emp_name, float emp_salary){
        this.emp_no = emp_no;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
    }
    // Getters
    public long getEmp_no(){
        return emp_no;
    }
    public float getSalary(){
        return emp_salary;
    }
    public String getName(){
        return emp_name;
    }
    public String toString(){
        return "Employee No: "+emp_no+" Name: "+emp_name+" Salary: "+emp_salary;
    }

    // Setters
    public void setEmp_no(long emp_no){
        this.emp_no = emp_no;
    }
    public void setSalary(float emp_salary){
        this.emp_salary = emp_salary;
    }
    public void setName(String emp_name){
        this.emp_name = emp_name;
    }
}

public class emp{
    public static void main(String[] args){
        ArrayList<Employee> empList = new ArrayList<Employee>();
        Scanner sc = new Scanner(System.in);
        int ch;
        do{
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch(ch) {
                case 1:
                    try{
                        System.out.print("Enter Employee No: ");
                        long emp_no = sc.nextLong();
                        System.out.print("Enter Employee Name: ");
                        String emp_name = sc.next();
                        System.out.print("Enter Employee Salary: ");
                        float emp_salary = sc.nextFloat();
                        empList.add(new Employee(emp_no, emp_name, emp_salary));
                        System.out.println("Employee added successfully!\n");
                        break;
                    }catch(Exception e){
                        System.err.println("\nError: Invalid input\n");
                        sc.nextLine();
                        break;
                    }
                case 2:
                    System.out.println("\nEmployee List:");
                    System.out.printf("----------------------------------------------------------------------%n");
                    System.out.printf("|                        Employee Data table                         |%n");
                    System.out.printf("----------------------------------------------------------------------%n");
                    System.out.printf("| %-20s | %-20s | %-20s |%n", "Emp No", "Name", "Salary");
                    System.out.printf("----------------------------------------------------------------------%n");
                    for (Employee e : empList) {
                        System.out.printf("| %-20d | %-20s | %-20.2f |%n", e.getEmp_no(), e.getName(), e.getSalary());
                    }
                    System.out.printf("----------------------------------------------------------------------%n");
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter Employee No to search: ");
                    long search_no = sc.nextLong();
                    boolean yes = false;
                    System.out.println("\nEmployee Details:");
                    System.out.printf("----------------------------------------------------------------------%n");
                    System.out.printf("|                        Employee Data table                         |%n");
                    System.out.printf("----------------------------------------------------------------------%n");
                    System.out.printf("| %-20s | %-20s | %-20s |%n", "Emp No", "Name", "Salary");
                    System.out.printf("----------------------------------------------------------------------%n");
                    for(Employee e: empList){
                        if(e.getEmp_no() == search_no){
                            System.out.printf("| %-20d | %-20s | %-20.2f |%n", e.getEmp_no(), e.getName(), e.getSalary());
                            yes = true;
                            System.out.printf("----------------------------------------------------------------------%n");
                            break;
                        }
                    }
                    if(!yes){ System.out.println("Employee not found"); };
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter Employee No to update: ");
                    long update_no = sc.nextLong();
                    boolean found = false;
                    for(Employee e: empList){
                        if(e.getEmp_no() == update_no){
                            System.out.print("Enter new Employee No: ");
                            long emp_no_update = sc.nextLong();
                            System.out.print("Enter new Employee Name: ");
                            String emp_name_update = sc.next();
                            System.out.print("Enter new Employee Salary: ");
                            float emp_salary_update = sc.nextFloat();
                            e.setEmp_no(emp_no_update);
                            e.setName(emp_name_update);
                            e.setSalary(emp_salary_update);
                            System.out.println("Employee updated successfully!");
                            found = true;
                            break;
                        }
                    }
                    if(!found){ System.out.println("Employee not found"); };
                    break;
                case 5:
                    System.out.print("Enter Employee No to delete: ");
                    long delete_no = sc.nextLong();
                    boolean deleted = false;
                    for(Employee e: empList){
                        if(e.getEmp_no() == delete_no){
                            empList.remove(e);
                            deleted = true;
                            System.out.println("Employee deleted successfully!");
                            break;
                        }
                    }
                    if(!deleted){ System.out.println("Employee not found"); };
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(ch!=6);
    }
}