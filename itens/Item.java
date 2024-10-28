package itens;

import personagens.Personagem;

public class Item {
    private String nome;
    private int valor;
    private String tipo;

    public Item(String nome, int valor, String tipo) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }

    public void usar(Personagem jogador) {
        if (tipo.equals("cura")) {
            jogador.setVida(jogador.getVida() + valor);
            System.out.println(jogador.getNome() + " recuperou " + valor + " de HP e agora tem " + jogador.getVida() + " HP.");
        } else if (tipo.equals("xp")) {
            jogador.subirNivel();
            System.out.println(jogador.getNome() + " usou a " + nome + " e aumentou seu nível!");
        }
    }
}
