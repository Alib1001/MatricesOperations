import org.alib.matrices.Matrix;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testTransposeMatrix() {
        Matrix matrix = new Matrix(2, 3);
        int[][] transposed = matrix.transposeMatrix();
        assertEquals(transposed.length, matrix.matrix[0].length);
        assertEquals(transposed[0].length, matrix.matrix.length);
    }



    @Test
    public void testIsSquareMatrix() throws Exception {
        Matrix squareMatrix = new Matrix(4, 4);
        Method isSquareMatrixMethod = Matrix.class.getDeclaredMethod("isSquareMatrix");
        isSquareMatrixMethod.setAccessible(true);
        boolean squareMatrixResult = (boolean) isSquareMatrixMethod.invoke(squareMatrix);
        assertTrue(squareMatrixResult);

        Matrix nonSquareMatrix = new Matrix(3, 4);
        boolean nonSquareMatrixResult = (boolean) isSquareMatrixMethod.invoke(nonSquareMatrix);
        assertFalse(nonSquareMatrixResult);
    }


    @Test
    public void testFindMinor() throws Exception {
        Matrix matrix = new Matrix(3, 3);
        matrix.setMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Method findMinorMethod = Matrix.class.getDeclaredMethod("findMinor", int.class, int.class);
        findMinorMethod.setAccessible(true);
        int minor = (int) findMinorMethod.invoke(matrix, 1, 1);
        assertNotNull(minor);
    }

    //TODO: write test for getCofactor and findDeterminants using reflection


}

