import java.util.*;//sheesh
public class Tasks {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10, 10));

        Set<Integer> duplicateNumbers = new HashSet<>();
        int sum = 0;
        double average;

        try {
            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                if (number < 0) {
                    throw new IllegalArgumentException("Negative number found: " + number);
                }

                if (duplicateNumbers.contains(number)) {
                    iterator.remove();
                } else {
                    duplicateNumbers.add(number);
                }
            }

            for (Integer unique : numbers) {
                sum += unique;
            }

            if (numbers.size() == 0) {
                throw new ArithmeticException("Cannot calculate average of empty list");
            }

            average = (double) sum / numbers.size();

            System.out.println("Sum of list without duplicates: " + sum);
            System.out.println("Average of list without duplicates: " + average);
            System.out.println("The list without duplicates: " + numbers);
        } catch (IndexOutOfBoundsException | IllegalArgumentException | ArithmeticException ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        } finally {
            System.out.println("Process complete.");
        }
    }
}
