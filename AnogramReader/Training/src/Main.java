public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Вывод исходной матрицы
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        Main main = new Main();

        // Транспонирование и вывод
        int[][] transposedMatrix = main.transpose(matrix);
        System.out.println("\nТранспонированная матрица:");
        printMatrix(transposedMatrix);

        // Умножение и вывод
        int[][] multipliedMatrix = main.multiply(matrix2, matrix);
        System.out.println("\nРезультат умножения матриц:");
        printMatrix(multipliedMatrix);

        // Сумма главной диагонали
        int mainDiagonalSum = main.sumMainDiagonal(matrix);
        System.out.println("\nСумма главной диагонали: " + mainDiagonalSum);

        // Сумма побочной диагонали
        int secondaryDiagonalSum = main.sumSecondaryDiagonal(matrix);
        System.out.println("Сумма побочной диагонали: " + secondaryDiagonalSum);

        System.out.println("\nДиагонали матрицы:");
        printMainDiagonal(matrix);
        printSecondaryDiagonal(matrix);

    }

    // Метод для печати матрицы
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Транспонирование матрицы
    int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // Умножение матриц
    int[][] multiply(int[][] a, int[][] b) {
        int m = a.length;
        int n = a[0].length;
        int k = b[0].length;
        int[][] c = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    c[i][j] += a[i][l] * b[l][j];
                }
            }
        }
        return c;
    }

    int sumMainDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][n - 1 - i];
        }
        return sum;
    }

    static void printMainDiagonal(int[][] matrix) {
        System.out.println("Главная диагональ: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][i] + "");
        }
        System.out.println();
    }

    static void printSecondaryDiagonal(int[][] matrix) {
        System.out.print("Побочная диагональ: ");
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][n - 1 - i] + " ");
        }
        System.out.println();
    }
}