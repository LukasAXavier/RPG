package personagens;

// Classe abstrata que define atributos e métodos básicos para qualquer personagem
public abstract class Personagem {
    protected String nome;  // Nome do personagem
    protected int vida;     // Quantidade de vida do personagem
    protected int nivel;    // Nível do personagem
    protected int ataque;   // Força de ataque do personagem

    // Construtor para inicializar os atributos do personagem
    public Personagem(String nome, int vida, int nivel, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.nivel = nivel;
        this.ataque = ataque;
    }

    // Método abstrato de ataque, a ser implementado pelas subclasses
    public abstract void atacar(Personagem alvo);

    // Exibe o status atual do personagem
    public void exibirStatus() {
        System.out.println(nome + " - Vida: " + vida + ", Nível: " + nivel);
    }

    // Método para aplicar dano ao personagem
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }

    // Getter para o nome do personagem
    public String getNome() {
        return nome;
    }

    // Getter para a vida do personagem
    public int getVida() {
        return vida;
    }
}
