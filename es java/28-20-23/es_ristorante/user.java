package es_ristorante;

public class user {
    String nome;
    String password;
    String[] arrayRuoli = {"chef","chefCapo","magazziniere"};
    String ruolo;
    //costructor
    public user(String nome, String password ,String ruolo) {
        this.nome = nome;
        this.password = password;
        this.ruolo = assignedRuolo(ruolo);
    }
    public String assignedRuolo(String ruolo){
       for (int i = 0; i < arrayRuoli.length; i++) {
        System.out.println(arrayRuoli[i]);
         if(arrayRuoli[i].equals(ruolo)){
            System.out.println("ruolo assegnato");
          return ruolo;
        }else{
            System.out.println("ruolo non esistente");
        }
       }
        return "unsigned";
    }
    public String Cosasei (){
        return ruolo;//getRuolo
    }
    public void stampa(){
        System.out.println(nome + " " + Cosasei());
    }
}
