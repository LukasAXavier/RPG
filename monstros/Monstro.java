package monstros;

import personagens.Personagem;

public class Monstro extends Personagem {

    public Monstro(String nome, int vida, int ataque) {
        super(nome, vida, ataque, 2, 1);  // Monstros com 2 de defesa inicial
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca ferozmente " + alvo.getNome() + "!");
        alvo.receberDano(ataque);
    }

    @Override
    public void usarHabilidade(Personagem alvo) {
        // Monstros normais não têm habilidades especiais, então este método não faz nada.
        System.out.println(getNome() + " tenta usar uma habilidade, mas falha.");
    }
}
