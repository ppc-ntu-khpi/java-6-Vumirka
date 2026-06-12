package matrix;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Утиліта для знаходження другого за величиною унікального числа
 * у двовимірній матриці розміром N x M.
 *
 * <p>Алгоритм:</p>
 * <ol>
 *   <li>Матриця «розгортається» у плоский масив через {@link Arrays#stream}.</li>
 *   <li>З потоку видаляються дублікати ({@code distinct()}).</li>
 *   <li>Масив сортується за зростанням і береться другий з кінця елемент.</li>
 * </ol>
 *
 * <p>Вхідні дані: двовимірний масив цілих чисел {@code int[][] matrix}
 * розміром не менше 1 x 2 (необхідно мінімум два різних значення).</p>
 *
 * <p>Вихідні дані: {@link OptionalInt} — другий за величиною унікальний елемент
 * або {@code empty}, якщо матриця містить менше двох різних значень.</p>
 *
 * @author Student
 * @version 1.0
 */
public class MatrixSecondMax {

    private MatrixSecondMax() {
        // утилітний клас — створення екземплярів заборонено
    }

    /**
     * Знаходить друге за величиною унікальне число у матриці.
     *
     * @param matrix двовимірний масив цілих чисел (не {@code null}, не порожній)
     * @return {@code OptionalInt} із другим максимумом,
     *         або {@code OptionalInt.empty()} якщо унікальних значень менше двох
     * @throws IllegalArgumentException якщо {@code matrix} дорівнює {@code null}
     *                                  або не містить жодного рядка
     */
    public static OptionalInt findSecondMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матриця не може бути null або порожньою.");
        }

        // Розгортаємо 2D масив у відсортований масив унікальних значень
        int[] sorted = Arrays.stream(matrix)       // Stream<int[]> по рядках
                .flatMapToInt(Arrays::stream)       // IntStream усіх елементів
                .distinct()                         // лише унікальні
                .sorted()                           // за зростанням
                .toArray();

        // Потрібно мінімум 2 різних значення
        if (sorted.length < 2) {
            return OptionalInt.empty();
        }

        // Другий з кінця — другий максимум
        return OptionalInt.of(sorted[sorted.length - 2]);
    }

    /**
     * Повертає рядкове представлення матриці для виводу.
     *
     * @param matrix двовимірний масив цілих чисел
     * @return форматований рядок
     */
    public static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(matrix)
                .map(Arrays::toString)
                .forEach(row -> sb.append("  ").append(row).append("\n"));
        return sb.toString();
    }
}
