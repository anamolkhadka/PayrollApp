package HW2_visitor;

///Visitor Pattern - Concrete visitor for calculating ranges
public class rangeVisitor implements Visitor {

    private static double minFullTimePayroll = Double.POSITIVE_INFINITY;
    private static double maxFullTimePayroll = Double.NEGATIVE_INFINITY;
    private static double minPartTimePayroll = Double.POSITIVE_INFINITY;
    private static double maxPartTimePayroll = Double.NEGATIVE_INFINITY;
    private static double minContractPayroll = Double.POSITIVE_INFINITY;
    private static double maxContractPayroll = Double.NEGATIVE_INFINITY;

    @Override
    public void visit(FullTimeEmployee fullTimeEmployee) {
        double salary = fullTimeEmployee.calculatePeriodPay();
        minFullTimePayroll = Math.min(minFullTimePayroll, salary);
        maxFullTimePayroll = Math.max(maxFullTimePayroll, salary);

    }

    @Override
    public void visit(PartTimeEmployee partTimeEmployee) {
        double salary = partTimeEmployee.calculatePeriodPay();
        minPartTimePayroll = Math.min(minPartTimePayroll, salary);
        maxPartTimePayroll = Math.max(maxPartTimePayroll, salary);

    }

    @Override
    public void visit(ContractEmployee contractEmployee) {
        double salary = contractEmployee.calculatePeriodPay();
        minContractPayroll = Math.min(minContractPayroll, salary);
        maxContractPayroll = Math.max(maxContractPayroll, salary);

    }

    public double getMinFullTimePayroll() {
        return minFullTimePayroll;
    }

    public double getMaxFullTimePayroll() {
        return maxFullTimePayroll;
    }

    public double getMinPartTimePayroll() {
        return minPartTimePayroll;
    }

    public double getMaxPartTimePayroll() {
        return maxPartTimePayroll;
    }

    public double getMinContractPayroll() {
        return minContractPayroll;
    }

    public double getMaxContractPayroll() {
        return maxContractPayroll;
    }

}
