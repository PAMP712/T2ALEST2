
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String nomeArquivo = "caso40_5a.txt"; // edita isso aq pra testar os arquivos
        char[][] matriz = null;

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String[] linha = br.readLine().split(" ");
            String linha2;
            int x = Integer.parseInt(linha[0]);
            int y = Integer.parseInt(linha[0]);
            matriz= new char[x][y];
            int x1 = 0;

            
            while ((linha2 = br.readLine()) != null) {
                int y1=0;
                for (int y2 = 0; y2 < y*2; y2= y2 + 2) {
                    matriz[x1][y1] = linha2.charAt(y2);
                    y1++;
                }
                x1++;
            }
            System.out.println(x + " " + y);
            for(int x3 = 0 ; x3<matriz.length; x3++){
                for(int y3 = 0; y3<matriz.length; y3++ ){
                    System.out.print(matriz[x3][y3]);
                }
                System.out.println();
            }
        
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } 
        
        






        //String s = Integer.toBinaryString(0xf); ideia de como trabalhar com binario
        //System.out.println(s);
        //System.out.println(s.charAt(0));
    }
}