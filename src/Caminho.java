import java.util.ArrayList;

public class Caminho {
    private ArrayList<Character> entidades;

    public Caminho(){
        entidades = new ArrayList<>();
    }
    public void adicionaEntidade(char e){ // adiciona as entidades que aparecem no caminho
        entidades.add(e);
    }
    public ArrayList<Character> getEntidades() {
        return this.entidades;
    }
    public void setEntidades(ArrayList<Character> entidades) {
        this.entidades = entidades;
    }
    
    public String contaEntidades(){ // retorna uma String com todas as entidades do caminho 
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        for(char var : entidades){
            if(var == 'A'){
                a = a+1;
            }
            else if(var == 'B'){
                b = b+1;
            }
            else if(var == 'C'){
                c = c+1;
            }
            else if(var == 'D'){
                d = d+1;
            }
            else if(var == 'E'){
                e = e+1;
            }
            else if(var == 'F'){
                f = f+1;
            }
        }
        return "\n"+"A" + "= " + a + "\n" + "B" + "= " + b + "\n" + "C" + "= " + c + "\n" + "D" + "= " + d + "\n" + "E" + "= " + e + "\n" + "F" + "= " + f;
    }
}