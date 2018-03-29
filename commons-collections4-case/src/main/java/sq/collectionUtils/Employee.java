package sq.collectionUtils;

/**
 * @Author: sq
 * @Description:
 * @Date: Created in 2018/3/29
 **/
public class Employee {
    private String name;
    private double salary;

    public Employee() {
    }


    public Employee(String name, double salary) {
        super();
        this.name = name;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "(姓名："+this.name+",薪水："+this.salary+")";
    }

}
