import java.util.ArrayList;

public class caminhov1 {
    private int id;
    private ArrayList<Character> entidades;

    public caminhov1(int id){
        entidades = new ArrayList();
        this.id = id;
    }
    public void adicionaEntidade(char e){
        entidades.add(e);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Character> getEntidades() {
        return this.entidades;
    }

    public void setEntidades(ArrayList<Character> entidades) {
        this.entidades = entidades;
    }

}
