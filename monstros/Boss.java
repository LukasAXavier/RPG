package monstros;

import personagens.Personagem;

public class Boss extends Personagem {

    public Boss() {
        super("Senhor das Sombras", 100, 15, 5, 5);  // Vida alta, ataque e defesa fortes
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " lança um ataque devastador contra " + alvo.getNome() + "!");
        alvo.receberDano(ataque);
    }

    @Override
    public void usarHabilidade(Personagem alvo) {
        // Podemos fazer com que o Boss tenha uma habilidade especial de ataque mais forte
        int danoHabilidade = ataque * 2;
        System.out.println(getNome() + " usa uma habilidade devastadora em " + alvo.getNome() + ", causando " + danoHabilidade + " de dano!");
        alvo.receberDano(danoHabilidade);
    }
}
