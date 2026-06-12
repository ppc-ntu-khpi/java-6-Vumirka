import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {

        // Тест 1 — звичайна матриця
        int[][] matrix1 = {
            {3, 7,  1},
            {9, 2, 15},
            {6, 4,  8}
        };
        System.out.println("Матриця 1:");
        printMatrix(matrix1);
        System.out.println("Друге за величиною: " + findSecondMax(matrix1) + "\n");

        // Тест 2 — є дублікати
        int[][] matrix2 = {
            {5, 5, 3},
            {3, 9, 9},
            {1, 1, 7}
        };
        System.out.println("Матриця 2 (з дублікатами):");
        printMatrix(matrix2);
        System.out.println("Друге за величиною: " + findSecondMax(matrix2) + "\n");

        // Тест 3 — усі однакові (очікуємо empty)
        int[][] matrix3 = {
            {7, 7},
            {7, 7}
        };
        System.out.println("Матриця 3 (всі однакові):");
        printMatrix(matrix3);
        OptionalInt result = findSecondMaxOptional(matrix3);
        System.out.println("Друге за величиною: " + 
            (result.isPresent() ? result.getAsInt() : "відсутнє (всі числа однакові)"));
    }

    /**
     * Знаходить друге за величиною унікальне число у матриці N x M.
     * Використовує Arrays.stream без явних циклів.
     *
     * @param matrix двовимірний масив цілих чисел
     * @return друге за величиною унікальне число
     */
    static int findSecondMax(int[][] matrix) {
        int[] sorted = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .distinct()
                .sorted()
                .toArray();
        return sorted[sorted.length - 2];
    }

    /**
     * Те саме, але повертає OptionalInt — безпечно для матриць
     * де менше двох унікальних значень.
     */
    static OptionalInt findSecondMaxOptional(int[][] matrix) {
        int[] sorted = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .distinct()
                .sorted()
                .toArray();
        if (sorted.length < 2) return OptionalInt.empty();
        return OptionalInt.of(sorted[sorted.length - 2]);
    }

    /** Виводить матрицю рядок за рядком через Arrays.toString */
    static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
              .map(Arrays::toString)
              .forEach(System.out::println);
    }
}