import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read employee details.
            System.out.print("Enter your name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter your hourly wage: ");
            double hourlyWage = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter hours worked: ");
            int hoursWorked = Integer.parseInt(scanner.nextLine().trim());

            // Validate the inputs.
            if (name.isEmpty() || !Double.isFinite(hourlyWage)
                    || hourlyWage < 0 || hoursWorked < 0) {
                System.out.println("Error: Enter a name and nonnegative numbers.");
                return;
            }

            // Calculate salary and the flat 20% tax.
            double grossSalary = hourlyWage * hoursWorked;
            double tax = grossSalary * 0.20;
            double netSalary = grossSalary - tax;

            // Display the payroll summary.
            System.out.println("\nPayroll Summary for " + name);
            System.out.println("-----------------------------------");
            System.out.println("Hours Worked: " + hoursWorked);
            System.out.printf("Hourly Wage: $%.2f%n", hourlyWage);
            System.out.printf("Gross Salary: $%.2f%n", grossSalary);
            System.out.printf("Taxes Deducted: $%.2f%n", tax);
            System.out.printf("Net Salary: $%.2f%n", netSalary);
        } catch (NumberFormatException e) {
            System.out.println("Error: Enter a numeric wage and whole-number hours.");
        }
    }
}