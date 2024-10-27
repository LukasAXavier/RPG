package habilidades;

import personagens.Personagem;

// Classe que representa uma habilidade que um personagem pode usar
public class Habilidade {
    private String nome;    // Nome da habilidade
    private int dano;       // Dano causado pela habilidade

    // Construtor para inicializar o nome e o dano da habilidade
    public Habilidade(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    // Getters para nome e dano
    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    // Método para usar a habilidade em um alvo
    public void usar(Personagem usuario, Personagem alvo) {
        System.out.println(usuario.getNome() + " usa " + nome + ", causando " + dano + " de dano!");
        alvo.receberDano(dano);
    }
}
