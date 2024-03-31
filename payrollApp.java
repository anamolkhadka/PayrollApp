package HW2_visitor;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

///Expert Employee interface
interface Employee {
    void accept(Visitor visitor);

    ArrayList<String> payroll();

    double calculatePeriodPay();
}

/// Concrete Full-time employee class
class FullTimeEmployee implements Employee {

    private String name;
    private double grossIncome;
    private double healthcareDeduction;
    private double deduction401k;
    private double taxWithholdingRate;
    private double periodPay;
    private ArrayList<String> payrollList = new ArrayList<>();

    /// Constructor for setting employee information.
    public FullTimeEmployee(String name, double grossIncome, double healthcareDeduction, double deduction401k,
            double taxWithholdingRate) {
        this.name = name;
        this.grossIncome = grossIncome;
        this.healthcareDeduction = healthcareDeduction;
        this.deduction401k = deduction401k;
        this.taxWithholdingRate = taxWithholdingRate / 100;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }

    @Override
    public double calculatePeriodPay() {
        /// Calculating period pay for the full-time employees
        return (grossIncome - healthcareDeduction - deduction401k) * (1 - taxWithholdingRate);
    }

    @Override
    public ArrayList<String> payroll() {
        payrollList.clear(); // Clear the list before adding new payroll information to avoid duplicates.
        periodPay = calculatePeriodPay();
        /// Creating payroll information list for each employee.
        payrollList.add(name);
        payrollList.add(String.valueOf(grossIncome));
        payrollList.add(String.valueOf(healthcareDeduction));
        payrollList.add(String.valueOf(deduction401k));
        payrollList.add(String.valueOf(taxWithholdingRate));
        payrollList.add(String.valueOf(periodPay));

        return payrollList;

    }

}

/// Concrete Part-time employee class
class PartTimeEmployee implements Employee {

    private String name;
    private double hourlyrate;
    private double hours;
    private double taxWithholdingRate;
    private double periodPay;
    private ArrayList<String> payrollList = new ArrayList<>();

    /// Constructor for setting employee information.
    public PartTimeEmployee(String name, double hourlyrate, double hours, double taxWithholdingRate) {
        this.name = name;
        this.hourlyrate = hourlyrate;
        this.hours = hours;
        this.taxWithholdingRate = taxWithholdingRate / 100;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }

    @Override
    public double calculatePeriodPay() {
        /// Calculating period pay for the part-time employees
        return (hourlyrate * hours) * (1 - taxWithholdingRate);
    }

    @Override
    public ArrayList<String> payroll() {
        payrollList.clear(); // Clear the list before adding new payroll information to avoid duplicates.
        periodPay = calculatePeriodPay();
        /// Creating payroll information list for each employee.
        payrollList.add(name);
        payrollList.add(String.valueOf(hourlyrate));
        payrollList.add(String.valueOf(hours));
        payrollList.add(String.valueOf(taxWithholdingRate));
        payrollList.add(String.valueOf(periodPay));

        return payrollList;

    }

}

/// Concrete Contract employee class
class ContractEmployee implements Employee {

    private String name;
    private double contractTotal;
    private int contractPeriod; /// Computed in months
    private int lengthOfInterval; /// Monthly so default 1
    private double periodPay;
    private ArrayList<String> payrollList = new ArrayList<>();

    /// Constructor for setting employee information.
    public ContractEmployee(String name, double contractTotal, int contractPeriod, int lengthOfInterval) {
        this.name = name;
        this.contractTotal = contractTotal;
        this.contractPeriod = contractPeriod;
        this.lengthOfInterval = lengthOfInterval;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }

    @Override
    public double calculatePeriodPay() {
        /// Calculating period pay for the contract employees
        return (contractTotal / (contractPeriod / lengthOfInterval));
    }

    @Override
    public ArrayList<String> payroll() {
        payrollList.clear(); // Clear the list before adding new payroll information to avoid duplicates.
        periodPay = calculatePeriodPay();
        /// Creating payroll information list for each employee.
        payrollList.add(name);
        payrollList.add(String.valueOf(contractTotal));
        payrollList.add(String.valueOf(contractPeriod));
        payrollList.add(String.valueOf(lengthOfInterval));
        payrollList.add(String.valueOf(periodPay));

        return payrollList;

    }

}

/// Payroll Controller class responsbile for handling payroll visitor classes.
/// Controller, iterator, and expert Patterns.
class payrollController {
    private ArrayList<Employee> employeeColllection = new ArrayList<>();

    public payrollController(ArrayList<Employee> employeeCollection) {
        this.employeeColllection = employeeCollection;
    }

    /// Method to use the range visitor and display payroll range.
    public void showPayrollRanges() {
        rangeVisitor rangevisitor = new rangeVisitor();
        /// Iterator to iterate through collection
        Iterator<Employee> iterator = employeeColllection.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            employee.accept(rangevisitor);

        }

        /// Display the min and max payroll range for each type of employees.
        System.out.println("Min Full Time Payroll: " + rangevisitor.getMinFullTimePayroll());
        System.out.println("Max Full Time Payroll: " + rangevisitor.getMaxFullTimePayroll());
        System.out.println("Min Part Time Payroll: " + rangevisitor.getMinPartTimePayroll());
        System.out.println("Max Part Time Payroll: " + rangevisitor.getMaxPartTimePayroll());
        System.out.println("Min Contract Payroll: " + rangevisitor.getMinContractPayroll());
        System.out.println("Max Contract Payroll: " + rangevisitor.getMaxContractPayroll());

    }

    /// Method to use the average visitor to display the averages.
    public void showPayrollAverages() {
        averageVisitor averagevisitor = new averageVisitor();
        /// Iterator to iterate through collection
        Iterator<Employee> iterator = employeeColllection.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            employee.accept(averagevisitor);

        }

        /// Display the averages for each type of employees.
        System.out.println("Average Full-Time Payroll: " + averagevisitor.getAverageFullTimeEmployee());
        System.out.println("Average Part-Time Payroll: " + averagevisitor.getAveragePartTimeEmployee());
        System.out.println("Average Contract  Payroll: " + averagevisitor.getAverageContractEmployee());

    }

    /// Method to show payroll for each employee using expert pattern.
    public void showPayroll() {
        /// Iterator to iterate through collection
        int employeeCount = 0;
        Iterator<Employee> iterator = employeeColllection.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            employeeCount++;
            System.out.println(employeeCount);
            System.out.println(employee.payroll()); /// Delegation by employee object to concrete employee classes.
        }
    }
}

/// Main application class
public class payrollApp {
    public static void main(String[] args) {
        ArrayList<Employee> employeeColllection = new ArrayList<>();
        int selectedPayrollOption;
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        /// Creating employee instances and adding to collection.
        /// 3 Full-time employees.
        Employee employee_f1 = new FullTimeEmployee("Anamol Khadka", 100000.0, 5000.0, 5000.0, 10.0);
        Employee employee_f2 = new FullTimeEmployee("Nguyen Thanh", 80000.0, 5000.0, 5000.0, 8.0);
        Employee employee_f3 = new FullTimeEmployee("Gaurie Sharma", 60000.0, 5000.0, 5000.0, 6.0);
        employeeColllection.add(employee_f1);
        employeeColllection.add(employee_f2);
        employeeColllection.add(employee_f3);

        /// 3 Part-time employees.
        Employee employee_f4 = new PartTimeEmployee("Naveen Reddy", 25.5, 80, 10.0);
        Employee employee_f5 = new PartTimeEmployee("Vinay Are", 15.5, 60, 8.0);
        Employee employee_f6 = new PartTimeEmployee("Ameen Mahouch", 12.5, 80, 6.0);
        employeeColllection.add(employee_f4);
        employeeColllection.add(employee_f5);
        employeeColllection.add(employee_f6);

        /// 3 Contract employees.
        Employee employee_f7 = new ContractEmployee("Somnath Jadav", 100000.0, 24, 1);
        Employee employee_f8 = new ContractEmployee("Harshit Pandey", 500000.0, 24, 1);
        Employee employee_f9 = new ContractEmployee("Rohit Raut", 10000.0, 12, 1);
        employeeColllection.add(employee_f7);
        employeeColllection.add(employee_f8);
        employeeColllection.add(employee_f9);

        /// Initializing the payroll controller.
        payrollController controller = new payrollController(employeeColllection);

        /// User input and payroll options.
        System.out.println("********** Welcome to the Payroll Application ***********");
        System.out.println("\nPlease select from the following option: ");
        System.out.println("\n\n");
        System.out.println("1. Show Payroll for each employees. ");
        System.out.println("2. Show Payroll Averages for all types of employees. ");
        System.out.println("3. Show Payroll ranges. (Min and Max)");
        System.out.println("4. Exit from the program.");
        System.out.println("Valid inputs are 1,2,3 or 4.");

        /// Prompt for the user input.
        System.out.println("\nEnter your choice: ");
        selectedPayrollOption = scanner.nextInt();

        while (selectedPayrollOption != 4) {
            if (selectedPayrollOption == 1) {
                // Show payroll for each employees.
                controller.showPayroll();

            } else if (selectedPayrollOption == 2) {
                /// Show payroll averages.
                controller.showPayrollAverages();

            } else if (selectedPayrollOption == 3) {
                /// Show payroll ranges.
                controller.showPayrollRanges();

            } else {
                System.out.println("Invalid choice. Please re-enter from one of the options 1-4.");

            }

            System.out.println("\nEnter your choice: ");
            selectedPayrollOption = scanner.nextInt();

        }
        scanner.close();

    }
}