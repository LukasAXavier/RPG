package personagens;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int nivel;

    public Personagem(String nome, int vida, int ataque, int defesa, int nivel) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = nivel;
    }

    public abstract void atacar(Personagem alvo);
    public abstract void usarHabilidade(Personagem alvo);

    public void defender() {
        System.out.println("\n" + nome + " assume uma postura defensiva, reduzindo o dano recebido.");
        defesa += 5;  // Aumenta a defesa temporariamente
    }

    public void receberDano(int dano) {
        int danoFinal = Math.max(dano - defesa, 0);
        this.vida = Math.max(this.vida - danoFinal, 0);  // Garante que a vida não fique negativa
        System.out.println(nome + " foi atingido e perdeu " + danoFinal + " HP e agora está com " + vida + " HP.");
        if (this.vida <= 0) {
            System.out.println(nome + " foi derrotado.");
        }
        defesa = 0;  // Reseta a defesa após cada turno
    }

    public void exibirStatus() {
        System.out.println(nome + " - Vida: " + vida + ", Ataque: " + ataque + ", Defesa: " + defesa + ", Nível: " + nivel);
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public String getNome() {
        return nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void subirNivel() {
        nivel++;
        vida *= 2;
        ataque *= 2;
        defesa *= 2;
        System.out.println("\n" + nome + " subiu para o nível " + nivel + "! Vida, ataque e defesa foram dobrados.");
    }
}
