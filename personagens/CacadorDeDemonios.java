package personagens;

// Classe que representa o Caçador de Demônios, um personagem com habilidades de longo alcance
public class CacadorDeDemonios extends Personagem {

    public CacadorDeDemonios(String nome) {
        super(nome, 120, 1, 40);  // Inicializa o Caçador de Demônios com vida, nível e ataque
    }

    // Implementação do ataque para o Caçador de Demônios
    @Override
    public void atacar(Personagem alvo) {
        System.out.println(nome + " dispara uma flecha em " + alvo.getNome());
        alvo.receberDano(ataque);
    }

    // Habilidade especial do Caçador de Demônios: Flecha Explosiva
    public void flechaExplosiva(Personagem alvo) {
        int dano = ataque + 15;
        System.out.println(nome + " lança uma flecha explosiva que causa " + dano + " de dano ao " + alvo.getNome());
        alvo.receberDano(dano);
    }
}
