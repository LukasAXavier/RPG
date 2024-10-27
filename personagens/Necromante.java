package personagens;

import habilidades.InvocarEsqueleto;

public class Necromante extends Personagem {

    public Necromante(String nome) {
        super(nome, 52, 1, 12);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(nome + " usa magia sombria para atacar " + alvo.getNome());
        alvo.receberDano(ataque);
    }

    public void invocarEsqueleto(Personagem alvo) {
        InvocarEsqueleto habilidade = new InvocarEsqueleto();
        habilidade.usar(this, alvo);  // Usa a habilidade no alvo
    }
}
