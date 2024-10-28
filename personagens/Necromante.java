package personagens;

public class Necromante extends Personagem {

    public Necromante() {
        super("Necromante", 42, 9, 6, 1);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println("\n" + getNome() + " conjura uma maldição em " + alvo.getNome() + "!");
        alvo.receberDano(ataque);
    }

    @Override
    public void usarHabilidade(Personagem alvo) {
        int danoHabilidade = ataque * 2;
        System.out.println("\n" + getNome() + " invoca um espírito sombrio para atacar " + alvo.getNome() + ", causando " + danoHabilidade + " de dano!");
        alvo.receberDano(danoHabilidade);
    }
}
