
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws IOException {// le os arquivos e coloca os dados em uma matriz
        String nomeArquivo = "caso250_5a.txt"; 
        char[][] matriz = null;
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String[] linha = br.readLine().split(" "); // le somente a primeira linha para pegar o tamanho da matriz
            String linha2;
            int x = Integer.parseInt(linha[0]);
            int y = Integer.parseInt(linha[0]);
            matriz= new char[x][y]; //instancia a matraiz com o tamanho passado 
            int x1 = 0;
            
            while ((linha2 = br.readLine()) != null) { // insere os elementos nas matrizes evitei usar outro for para isso 
                if (linha2.trim().isEmpty()) {
                    continue;
                }
                int y1=0;
                for (int y2 = 0; y2 < y*2; y2= y2 + 2) {
                    matriz[x1][y1] = linha2.charAt(y2);
                    y1++;
                }
                x1++;
            }
            start(matriz);
        
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } 
    }

    public static void start(char [][] matriz){    // Focada nas regioes e no labirinto como um todo
        Set<String> check = new HashSet<>();
        ArrayList<Caminho> caminhos = new ArrayList<>(); // cria um array de todos os caminhos do labirinto 

        for(int x = 0; x<matriz.length;x++){
            for(int y = 0; y<matriz.length; y++){
                if(!check.contains(x + "," + y)){ // verifica se a celula ja foi visitada
                    Caminho c = new Caminho(); // cria um novo caminho que sera percorrido
                    caminhos.add(c);    //Adiciona o caminho ao array de caminhos
                    verificaCelula(matriz, x, y, c, check); // marca a celula inicial
                }
            }
        }
        for(int i =0; i<caminhos.size();i++){
            System.out.println("Regiao: " + (i+1) + " " + caminhos.get(i).contaEntidades());
        }
        System.out.println("Numero de regioes: " + caminhos.size());  
    }
    public static void verificaCelula(char[][] matriz, int x, int y, Caminho caminho, Set<String> check){ //Focada na célula
        if(check.contains(x + "," + y)){ //verificacao para evitar loops
            return;
        }
        else{
            check.add(x + "," + y); // marca a celula visitada
            char var = matriz[x][y];
            if(var=='A'|| var =='B' ||var == 'C' ||var== 'D' || var== 'E' || var== 'F'){//Verifica se e entidade e add ao caminho
                caminho.adicionaEntidade(var); // Adiciona a entidade ao Array do objeto caminho que esta sendo percorrido
            }
            int d = Character.digit(var, 16);
            String hexa = String.format("%4s", Integer.toBinaryString(d)) // converte o char para uma string Hexadecimal
                            .replace(' ', '0');
            if(hexa.charAt(0)=='0')// cima
            {
                if(x>0)
                verificaCelula(matriz, x-1, y, caminho, check); // chamada recursiva de metodo 
            }
            if(hexa.charAt(1)=='0') // direita
            {
                if(y<matriz.length-1)
                verificaCelula(matriz, x, y+1, caminho, check); // chamada recursiva de metodo 
            }
            if(hexa.charAt(2)=='0') // baixo
            {
                if(x<matriz.length-1)
                verificaCelula(matriz, x+1, y, caminho, check); // chamada recursiva de metodo 
            }
            if(hexa.charAt(3)=='0') // esquerda
            {
                if(y>0)
                verificaCelula(matriz, x, y-1, caminho, check); // chamada recursiva de metodo 
            }
        }
    }  
}
