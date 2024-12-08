public class Main {
    public static void main(String[] args) {

        char[][] A = {
                {'1', '2', '3'},
                {'4', '5', '6'}
        };
        char[][] B = {
                {'7', '8'},
                {'9', '1'},
                {'2', '3'}
        };

        MatrixOperations operations = new MatrixOperations(A, B);

        System.out.println("Матриця A:");
        MatrixOperations.printMatrix(A);

        System.out.println("\nМатриця B:");
        MatrixOperations.printMatrix(B);

        operations.multiplyMatrices();

        System.out.println("\nМатриця C (результат множення A і B):");
        MatrixOperations.printMatrix(operations.getC());

        operations.printRowAverages();
    }
}