import java.util.Arrays;
import java.util.Set;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salaries) {
        final int maxSalary = Arrays.stream(salaries).max().getAsInt();
        final int minSalary = Arrays.stream(salaries).min().getAsInt();
        final Set<Integer> exclude = Set.of(minSalary, maxSalary);
        int sumSalary = 0;
        for (int salary : salaries) {
            if (!exclude.contains(salary)) sumSalary += salary;
        }
        return (double) sumSalary / (salaries.length - 2);
    }
}
