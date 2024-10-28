package personagens;

public class CacadorDeDemonios extends Personagem {

    public CacadorDeDemonios() {
        super("Caçador de Demônios", 45, 12, 4, 1);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println("\n" + getNome() + " dispara uma flecha em " + alvo.getNome() + "!");
        alvo.receberDano(ataque);
    }

    @Override
    public void usarHabilidade(Personagem alvo) {
        int danoHabilidade = ataque * 2;
        System.out.println("\n" + getNome() + " usa uma flecha explosiva em " + alvo.getNome() + ", causando " + danoHabilidade + " de dano!");
        alvo.receberDano(danoHabilidade);
    }
}
