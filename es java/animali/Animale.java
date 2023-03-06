package animali;

public class Animale {
    private String nome;
    private int anni;
    public Animale(String nome, int anni){
        this.nome = nome;
        this.anni = anni;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public int getAnni() {
        return anni;
    }
    public void setAnni(int anni) {
        this.anni = anni;
    }
}
