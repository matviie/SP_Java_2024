import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyTests {

    @Test
    void testMultiplyMatrices_ValidInput() {

        char[][] A = {
                {'1', '2', '3'},
                {'4', '5', '6'}
        };
        char[][] B = {
                {'3', '4'},
                {'2', '5'},
                {'1', '6'}
        };
        char[][] expectedC = {
                {'0', '2'},  // 10 32
                {'8', '7'}   // 28 77
        };

        MatrixOperations matrixOperations = new MatrixOperations(A, B);
        matrixOperations.multiplyMatrices();

        assertArrayEquals(expectedC, matrixOperations.getC());
    }

    @Test
    void testCalculateRowAverages() {

        char[][] matrixA = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
        char[][] matrixB = {
                {'1', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        };
        MatrixOperations operation = new MatrixOperations(matrixA, matrixB);
        operation.multiplyMatrices();

        double[] rowAverages = operation.calculateRowAverages();

        double[] expectedAverages = {2.0, 5.0, 8.0};
        Assertions.assertArrayEquals(expectedAverages, rowAverages, 0.001);
    }

    @Test
    void testIllegalArgumentException() {

        char[][] matrixA = {
                {'1', '2', '3'},
                {'4', '5', '6'}
        };
        char[][] matrixB = {
                {'1', '2', '3'},
                {'4', '5', '6'}
        };
        MatrixOperations operation = new MatrixOperations(matrixA, matrixB);

        operation.multiplyMatrices();

        assertNull(operation.getC(), "Expected matrix C to be null due to incompatible matrix dimensions.");
    }
}