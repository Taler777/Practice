// заполнить массив улиткой числами от 0 до n по возрастанию
public class FillMatrixLikeSnail {
    public int size = 5;
    public int[][] matrix = new int[size][size];

    public static void main(String[] args) {
        FillMatrixLikeSnail m3 = new FillMatrixLikeSnail();
        m3.fillMatrix();
    }

    public void fillMatrix() {
        int count = 0;
        int m; // количество проходов
        if (size % 2 == 0) m = size / 2;
        else m = size / 2 + 1;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < size - i; j++) { // вправо
                matrix[i][j] = count;
                count++;
            }

            for (int j = i + 1; j < size - i; j++) { // вниз
                matrix[j][size - i - 1] = count;
                count++;
            }

            for (int j = size - i - 2; j >= i; j--) { // влево
                matrix[size - i - 1][j] = count;
                count++;
            }

            for (int j = size - i - 2; j > i; j--) { //наверх
                matrix[j][i] = count;
                count++;
            }
        }
        printMatrix(matrix);
    }

    public void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
