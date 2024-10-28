package monstros;

import personagens.Personagem;

public class Monstro extends Personagem {
    private int nivelMonstro;  // Nível do monstro

    public Monstro(String nome, int vida, int ataque) {
        super(nome, vida, ataque, 2, 1);  // Monstros com 2 de defesa inicial
        this.nivelMonstro = 1;  // Inicia com nível 1
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca ferozmente " + alvo.getNome() + "!");
        alvo.receberDano(ataque);
    }

    @Override
    public void usarHabilidade(Personagem alvo) {
        System.out.println(getNome() + " tenta usar uma habilidade, mas falha.");
    }

    public int getNivelMonstro() {
        return nivelMonstro;
    }

    public void aumentarNivel() {
        nivelMonstro++;
        setVida((int) (getVida() * 1.07));  // Aumenta a vida em 7%
        setAtaque((int) (getAtaque() * 1.07));  // Aumenta o ataque em 7%
        setDefesa((int) (getDefesa() * 1.07));  // Aumenta a defesa em 7%
    }
}
