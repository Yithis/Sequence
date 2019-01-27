import java.util.Arrays;
import java.util.stream.Stream;

public class Linear implements Sequence {

    private int[] values;
    private int[] coefficients;

    private static class Matrix {
        private int[][] matrix;
        private int size;

        private Matrix(int size) {
            this.size = size;
            matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                matrix[i][i] = 1;
            }
        }

        Matrix(int[] initialize) {
            this.size = initialize.length;
            matrix = new int[size][size];
            matrix[0] = Arrays.copyOf(initialize, initialize.length);
            for (int i = 1; i < size; i++) {
                matrix[i][i-1] = 1;
            }
        }

        private static Matrix multiplay(Matrix a, Matrix b){
            Matrix res = new Matrix(a.size);
            for (int i = 0; i < a.size; i++) {
                for (int j = 0; j < a.size; j++) {
                    int value = 0;
                    for (int k = 0; k < a.size; k++) {
                        value += a.matrix[i][k] * b.matrix[k][j];
                    }
                    res.matrix[i][j] = value;
                }
            }
            return res;
        }

        static Matrix power(Matrix a, int pow) {
            if (pow == 0) {
                return new Matrix(a.size);
            }

            Matrix res = new Matrix(a.size);
            Matrix b = new Matrix(a.matrix[0]);

            while (pow != 0) {
                if (pow % 2 == 1) {
                    res = multiplay(res, b);
                }

                b = multiplay(b, b);
                pow /= 2;
            }

            return res;
        }


    }

    Linear(int[] values, int[] coefficients){
        this.values = Arrays.copyOf(values, values.length);
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }

    private void shiftValues(int shift) {
        Matrix a = Matrix.power(new Matrix(coefficients), shift);
        int[] temp = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                temp[i] += a.matrix[i][j] * values[j];
            }
        }
        values = temp;
    }

    Linear(int[] values, int[] coefficients, int shift){
        this.values = Arrays.copyOf(values, values.length);
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);

        shiftValues(shift);
    }



    @Override
    public Integer get() {
        int res = values[values.length-1];

        int temp = 0;
        for (int i = 0; i < coefficients.length; i++) {
            temp += coefficients[i] * values[i];
        }
        for (int i = values.length - 1; i > 0; i--) {
            values[i] = values[i-1];
        }
        values[0] = temp;

        return res;
    }

    @Override
    public Stream<Integer> getStream() {
        return Stream.generate(this);
    }
}
