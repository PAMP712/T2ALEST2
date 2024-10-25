
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
    public void start(char [][] matriz){    // Focada nas regioes e no labirnto como um todo
        Set<String> check = new HashSet<>();
        ArrayList<Caminho> caminhos = new ArrayList<>();

        for(int x = 0; x<matriz.length;x++){
            for(int y = 0; y<matriz.length; y++){
                if(!check.contains(x + "," + y)){
                    Caminho c = new Caminho();
                    caminhos.add(c);
                }
            }
        }
        System.out.println("Numero de regioes: " + caminhos.size());
        for(int i =0; i<caminhos.size();i++){
            System.out.println("Regiao: " + i+1 + " " + caminhos.get(i).contaEntidades());
        }
    }
    public void verificaCelula(char[][] matriz, int x, int y, Caminho caminho, Set<String> check){ //Focada na célula
        if(check.contains(x + "," + y)){ //verificacao para evitar loops
            return;
        }
        else{
            check.add(x + "," + y); // marca a celula visitada
            char var = matriz[x][y];
            if(var=='A'|| var =='B' ||var == 'C' ||var== 'D' || var== 'E' || var== 'F'){//Verifica se e entidade e add ao caminho
                caminho.adicionaEntidade(var);
            }
            int d = Character.digit(var, 16);
            String hexa = String.format("%4s", Integer.toBinaryString(d))
                            .replace(' ', '0');
            if(hexa.charAt(0)=='0') 
                verificaCelula(matriz, x-1, y, caminho, check);
            if(hexa.charAt(1)=='0')
                verificaCelula(matriz, x, y+1, caminho, check);;
            if(hexa.charAt(2)=='0')
                verificaCelula(matriz, x+1, y, caminho, check);
            if(hexa.charAt(3)=='0')
                verificaCelula(matriz, x, y-1, caminho, check);
        }

    }
    
    
}
