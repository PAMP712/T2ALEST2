import java.util.ArrayList;

public class Caminho {
    private int id;
    private ArrayList<Character> entidades;

    public Caminho(int id){
        entidades = new ArrayList<>();
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
