package itens;

import personagens.Personagem;

public class Item {
    private String nome;
    private int cura;

    public Item(String nome, int cura) {
        this.nome = nome;
        this.cura = cura;
    }

    public void usar(Personagem personagem) {
        System.out.println(personagem.getNome() + " usa " + nome + " e recupera " + cura + " pontos de vida.");
        personagem.receberDano(-cura);  // cura o personagem
    }

    public String getNome() {
        return nome;
    }
}
