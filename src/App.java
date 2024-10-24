import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String nomeArquivo = "casoc30.txt"; // edita isso aq pra testar os arquivos
        char[][] matriz = null;

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String var1;
            String[] linha = br.readLine().split(" ");

            int x = Integer.parseInt(linha[0]);
            int y = Integer.parseInt(linha[0]);
            matriz= new char[x][y];
            int x1 = 0;

            while ((linha = br.readLine().split(" ")) != null) {
                for (int y2 = 0; y2 < y; y2++) {
                    var1 = linha[y2];
                    matriz[x1][y2] = var1.charAt(0);
                }
                x1++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } 

        






        String s = Integer.toBinaryString(0xf);
        System.out.println(s);
        System.out.println(s.charAt(0));
    }
}
