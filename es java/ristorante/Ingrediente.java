package ristorante;

import java.util.UUID;

public class Ingrediente {
    private UUID id = UUID.randomUUID();
    String nome;
  
    public Ingrediente(String nome) {
        this.nome=nome; 
        }
    public UUID getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
