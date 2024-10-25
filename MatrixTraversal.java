import java.util.HashSet;
import java.util.Set;

public class MatrixTraversal {
    public static void main(String[] args) {
        // Exemplo de matriz de caracteres
        char[][] charMatrix = {
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'}
        };

        // Conjunto para armazenar as coordenadas dos caracteres visitados
        Set<String> visited = new HashSet<>();

        // Caminhar e marcar um caractere como visitado (exemplo: posição 1,1)
        markVisited(1, 1, visited);

        // Exibe o estado da matriz (marcando os visitados com '*')
        printMatrixWithVisited(charMatrix, visited);
    }

    // Função para marcar uma célula como visitada
    public static void markVisited(int row, int col, Set<String> visited) {
        visited.add(row + "," + col); // Usa a string "row,col" para identificar a célula
    }

    // Função para verificar se uma célula já foi visitada
    public static boolean isVisited(int row, int col, Set<String> visited) {
        return visited.contains(row + "," + col);
    }

    // Função para imprimir a matriz com os caracteres visitados marcados com '*'
    public static void printMatrixWithVisited(char[][] matrix, Set<String> visited) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isVisited(i, j, visited)) {
                    System.out.print(matrix[i][j] + "* "); // Marca com '*' se já foi visitado
                } else {
                    System.out.print(matrix[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}