package Gabriele_Sanna_test;
// Creare una classe utente e una admin l'utente da i suoi dati e poi puoi usare biblioteca, 
// l'admin dopo aver dato i suoi dati + 1 di controllo 
// ( a scelta vostra) può modificare ed eliminare gli utenti e usare biblioteca
import java.util.UUID;

public class User {
    private String id = UUID.randomUUID().toString();
    String nome;
    String password;
    Boolean log = false;
    Boolean admin;

    public User(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public User(String nome, String password, boolean admin) {
        this.nome = nome;
        this.password = password;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void stampa(int i) {
        System.out.println(i+" username: " + nome);
    }

    public boolean checkPass(String pass) {
        return this.password.equals(pass);
    }
    public Boolean getLog() {
        return log;
    }
    public void setLog(Boolean log) {
        this.log = log;
    }
    public void logIn() {
        this.log = true;
    }

    public void logOut() {
        this.log = false;
    }
    public Boolean isLog(){

        return true;
    }
    
}
