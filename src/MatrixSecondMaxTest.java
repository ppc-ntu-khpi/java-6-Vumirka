package matrix;

import java.util.OptionalInt;

/**
 * Тестовий клас для перевірки коректності {@link MatrixSecondMax}.
 * Метод {@code main} містить лише виклики основного класу та виведення результатів.
 */
public class MatrixSecondMaxTest {

    public static void main(String[] args) {

        // ── Тест 1: звичайна матриця з різними числами ───────────────────────
        int[][] matrix1 = {
            {3, 7,  1},
            {9, 2, 15},
            {6, 4,  8}
        };
        printTestResult("Тест 1 — звичайна матриця 3x3", matrix1, 9);

        // ── Тест 2: матриця з від'ємними числами ─────────────────────────────
        int[][] matrix2 = {
            {-5, -1, -8},
            {-3, -2, -7}
        };
        printTestResult("Тест 2 — від'ємні числа 2x3", matrix2, -2);

        // ── Тест 3: матриця з дублікатами ────────────────────────────────────
        int[][] matrix3 = {
            {5, 5, 3},
            {3, 9, 9},
            {1, 1, 7}
        };
        printTestResult("Тест 3 — є дублікати 3x3", matrix3, 7);

        // ── Тест 4: матриця 1x2 (мінімально допустима) ───────────────────────
        int[][] matrix4 = {{42, 17}};
        printTestResult("Тест 4 — рядок з двох елементів 1x2", matrix4, 17);

        // ── Тест 5: матриця з одним унікальним значенням (очікуємо empty) ─────
        int[][] matrix5 = {
            {7, 7},
            {7, 7}
        };
        System.out.println("══ Тест 5 — усі елементи однакові (очікуємо: empty) ══");
        System.out.println("Матриця:\n" + MatrixSecondMax.matrixToString(matrix5));
        OptionalInt result5 = MatrixSecondMax.findSecondMax(matrix5);
        System.out.println("Результат: " + (result5.isPresent() ? result5.getAsInt() : "empty"));
        System.out.println("Тест " + (result5.isEmpty() ? "✓ ПРОЙДЕНО" : "✗ ПРОВАЛЕНО") + "\n");

        // ── Тест 6: велика матриця 4x5 ───────────────────────────────────────
        int[][] matrix6 = {
            {10, 22,  3, 41,  5},
            {16,  7, 88,  9, 10},
            {11, 12, 13, 14, 15},
            {88, 19, 20, 21, 22}
        };
        printTestResult("Тест 6 — матриця 4x5 (макс=88, друге=41)", matrix6, 41);
    }

    /**
     * Виводить результат одного тесту та порівнює з очікуваним значенням.
     */
    private static void printTestResult(String label, int[][] matrix, int expected) {
        System.out.println("══ " + label + " ══");
        System.out.println("Матриця:\n" + MatrixSecondMax.matrixToString(matrix));
        OptionalInt result = MatrixSecondMax.findSecondMax(matrix);
        int actual = result.orElse(Integer.MIN_VALUE);
        System.out.println("Очікується: " + expected + "  |  Отримано: " + actual);
        System.out.println("Тест " + (actual == expected ? "✓ ПРОЙДЕНО" : "✗ ПРОВАЛЕНО") + "\n");
    }
}
