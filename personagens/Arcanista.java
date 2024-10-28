package personagens;

public class Arcanista extends Personagem {

    public Arcanista() {
        super("Arcanista", 40, 10, 5, 1);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println("\n" + getNome() + " lança uma bola de fogo em " + alvo.getNome() + "!");
        alvo.receberDano(ataque);
    }

    @Override
    public void usarHabilidade(Personagem alvo) {
        int danoHabilidade = ataque * 2;
        System.out.println("\n" + getNome() + " usa uma poderosa magia de fogo em " + alvo.getNome() + ", causando " + danoHabilidade + " de dano!");
        alvo.receberDano(danoHabilidade);
    }
}
