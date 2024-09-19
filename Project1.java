package practice;

import java.util.HashMap;
import java.util.Map;

class Project {
    int empNo;
    String empName;
    String joinDate;
    char designationCode;
    String department;
    int basic;
    int hra;
    int it;

    public Project(int empNo, String empName, String joinDate, char designationCode, String department, int basic, int hra, int it) {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
        this.designationCode = designationCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }

    public int calculateSalary(int da) {
        return basic + hra + da - it;
    }
}

public class Project1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Project1 <employee_id>");
            return;
        }

        int empId = Integer.parseInt(args[0]);

        Project[] employees = {
            new Project(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000),
            new Project(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000),
            new Project(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000),
            new Project(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000),
            new Project(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000),
            new Project(1006, "Suman", "01/01/2000", 'e', "Manufacturing", 23000, 9000, 4400),
            new Project(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000)
        };

        Map<Character, String> designationMap = new HashMap<>();
        designationMap.put('e', "Engineer");
        designationMap.put('c', "Consultant");
        designationMap.put('k', "Clerk");
        designationMap.put('r', "Receptionist");
        designationMap.put('m', "Manager");

        Map<Character, Integer> daMap = new HashMap<>();
        daMap.put('e', 20000);
        daMap.put('c', 32000);
        daMap.put('k', 12000);
        daMap.put('r', 15000);
        daMap.put('m', 40000);

        Project employee = null;
        for (Project emp : employees) {
            if (emp.empNo == empId) {
                employee = emp;
                break;
            }
        }

        if (employee == null) {
            System.out.println("There is no employee with empid : " + empId);
        } else {
            String designation = designationMap.get(employee.designationCode);
            int da = daMap.get(employee.designationCode);
            int salary = employee.calculateSalary(da);
            System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");
            System.out.printf("%d\t%s\t%s\t%s\t%d%n", employee.empNo, employee.empName, employee.department, designation, salary);
        }
    }
}
