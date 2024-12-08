

public class MatrixOperations {

    private final char[][] A;
    private final char[][] B;
    private char[][] C;

    public MatrixOperations(char[][] A, char[][] B) {
        this.A = A;
        this.B = B;
    }

    public char[][] getC() {
        return C;
    }

    // метод для виведення матриці
    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // метод для виконання множення матриць
    public void multiplyMatrices() {
        try {
            if (A[0].length != B.length) {
                throw new IllegalArgumentException("Помилка: кількість стовпців A не дорівнює кількості рядків B.");
            }

            int rowsA = A.length;
            int colsB = B[0].length;
            C = new char[rowsA][colsB];

            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    int sum = 0;
                    for (int k = 0; k < A[0].length; k++) {
                        sum += (A[i][k] - '0') * (B[k][j] - '0');
                    }
                    C[i][j] = (char) ('0' + (sum % 10));
                }
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неочікувана помилка!");
        }
    }

    // метод для обчислення середнього значення елементів кожного рядка матриці C
    public double[] calculateRowAverages() {
        if (C == null) {
            System.err.println("Помилка: матриця C не ініціалізована. Спершу виконайте множення.");
            return null;
        }

        double[] averages = new double[C.length];
        for (int i = 0; i < C.length; i++) {
            double sum = 0;
            for (int j = 0; j < C[i].length; j++) {
                sum += C[i][j] - '0';
            }
            averages[i] = sum / C[i].length;
        }
        return averages;
    }

    public void printRowAverages() {
        double[] averages = calculateRowAverages();
        if (averages == null) return;

        System.out.println("\nСереднє значення елементів кожного рядка матриці C:");
        for (int i = 0; i < averages.length; i++) {
            System.out.printf("Середнє значення рядка %d: %.2f%n", i + 1, averages[i]);
        }
    }
}