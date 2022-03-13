package inherentance;

public class Manager extends Employee{
    private double bonus;
    public Manager(){
        super();
        bonus = 0;
    }
    public void setBonus(double b){
        bonus = b;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.rank();

    }
}
