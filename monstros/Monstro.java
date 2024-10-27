package monstros;

import personagens.Personagem;

// Classe que representa monstros inimigos no jogo
public class Monstro extends Personagem {

    // Construtor que inicializa o monstro com vida e ataque
    public Monstro(String nome, int vida, int ataque) {
        super(nome, vida, 1, ataque);  // Nível fixo como 1
    }

    // Implementação do ataque para o monstro
    @Override
    public void atacar(Personagem alvo) {
        System.out.println(nome + " ataca ferozmente " + alvo.getNome());
        alvo.receberDano(ataque);
    }
}
