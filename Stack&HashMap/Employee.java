public class Employee {
    private int empid;

    private String name;
    private double salary;
    private int departmentno;

    public Employee() {
    }

    public Employee(int empid, String name, double salary, int departmentno) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
        this.departmentno = departmentno;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", departmentno=" + departmentno +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartmentno() {
        return departmentno;
    }

    public void setDepartmentno(int departmentno) {
        this.departmentno = departmentno;
    }
}