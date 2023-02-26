import org.alib.matrices.MatricesOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatricesOperationsTest {

    @Test
    public void testFindSum() {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        int[][] expectedResult = {{6, 8}, {10, 12}};
        int[][] result = MatricesOperations.findSum(matrix1, matrix2);
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testFindDiff() {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        int[][] expectedResult = {{-4, -4}, {-4, -4}};
        int[][] result = MatricesOperations.findDiff(matrix1, matrix2);
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testMultiplyByNumber() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int number = 2;
        int[][] expectedResult = {{2, 4}, {6, 8}};
        int[][] result = MatricesOperations.multiplyByNumber(matrix, number);
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testMultiplyByNumbers() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[] numbers = {2, 3};
        int[][] expectedResult = {{6, 12}, {18, 24}};
        int[][] result = MatricesOperations.multiplyByNumbers(matrix, numbers);
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testMultiplyMatrices() {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        int[][] expectedResult = {{19, 22}, {43, 50}};
        int[][] result = MatricesOperations.multiplyMatrices(matrix1, matrix2);
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test

    public void testExponentiateMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int power = 2;
        int[][] expectedResult = {{7, 10}, {15, 22}};
        int[][] result = MatricesOperations.exponentiateMatrix(matrix, power);
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testExponentiateMatrixInvalid() {
        int[][] matrix = {{1, 2, 2,3}, {4, 5, 6}, {7, 8, 9}};
        int power = 2;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> MatricesOperations.exponentiateMatrix(matrix, power));
    }

    @Test
    public void testFindSumInvalid() {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6, 7}, {8, 9, 10}};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> MatricesOperations.findSum(matrix1, matrix2));
    }

    @Test
    public void testFindDiffInvalid() {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6, 7}, {8, 9, 10}};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> MatricesOperations.findDiff(matrix1, matrix2));
    }

}