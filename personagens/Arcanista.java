package personagens;

// Classe que representa o Arcanista, um personagem com habilidades mágicas
public class Arcanista extends Personagem {

    public Arcanista(String nome) {
        super(nome, 72, 1, 13);  // Inicializa o Arcanista com vida, nível e ataque
    }

    // Implementação do ataque para o Arcanista
    @Override
    public void atacar(Personagem alvo) {
        System.out.println(nome + " lança um feitiço para atacar " + alvo.getNome());
        alvo.receberDano(ataque);
    }

    // Habilidade especial do Arcanista: Feitiço Poderoso
    public void feitiçoPoderoso(Personagem alvo) {
        int dano = ataque + 20;
        System.out.println(nome + " usa um feitiço poderoso, causando " + dano + " de dano ao " + alvo.getNome());
        alvo.receberDano(dano);
    }
}
