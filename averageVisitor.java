package HW2_visitor;

/// Visitor pattern - Concrete Visitor to calculate averages.
public class averageVisitor implements Visitor {

    private static double sumFullTimePayroll = 0.0;
    private static int countFullTimeEmployee = 0;
    private static double sumPartTimePayroll = 0.0;
    private static int countPartTimeEmployee = 0;
    private static double sumContractPayroll = 0.0;
    private static int countContractEmployee = 0;

    @Override
    public void visit(FullTimeEmployee fullTimeEmployee) {
        double salary = fullTimeEmployee.calculatePeriodPay();
        sumFullTimePayroll = sumFullTimePayroll + salary;
        countFullTimeEmployee++;
    }

    @Override
    public void visit(PartTimeEmployee partTimeEmployee) {
        double salary = partTimeEmployee.calculatePeriodPay();
        sumPartTimePayroll = sumPartTimePayroll + salary;
        countPartTimeEmployee++;

    }

    @Override
    public void visit(ContractEmployee contractEmployee) {
        double salary = contractEmployee.calculatePeriodPay();
        sumContractPayroll = sumContractPayroll + salary;
        countContractEmployee++;

    }

    public double getAverageFullTimeEmployee() {
        return sumFullTimePayroll / countFullTimeEmployee;
    }

    public double getAveragePartTimeEmployee() {
        return sumPartTimePayroll / countPartTimeEmployee;
    }

    public double getAverageContractEmployee() {
        return sumContractPayroll / countContractEmployee;
    }

}
