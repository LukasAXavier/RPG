import java.util.Random;
import java.util.Scanner;
import monstros.Monstro;
import personagens.*;
// negger negger neggers niggas
// Classe principal que controla o jogo e a interação com o jogador
public class Jogo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean pocaoDisponivel = false;  // Controla se o jogador encontrou uma poção

        // Introdução ao jogo com uma narrativa
        System.out.println("Bem-vindo ao RPG de Texto inspirado no Diablo!");
        System.out.println("Você é um aventureiro em uma terra amaldiçoada, enfrentando monstros sombrios para salvar seu reino.");
        System.out.println("Escolha seu herói para iniciar sua jornada.");

        // Escolha de personagem com narrativa explicativa
        System.out.println("\nEscolha seu personagem:");
        System.out.println("1 - Necromante: Um mestre das artes sombrias que invoca mortos para lutar.");
        System.out.println("2 - Arcanista: Um mago poderoso que controla os elementos.");
        System.out.println("3 - Caçador de Demônios: Um guerreiro ágil com habilidades de longo alcance.");

        // Leitura da escolha do jogador e criação do personagem
        int escolha = scanner.nextInt();
        scanner.nextLine();

        // Variável para armazenar o personagem do jogador
        Personagem jogador;
        switch (escolha) {
            case 1 : jogador = new Necromante("Malthael");
            case 2 : jogador = new Arcanista("Tyrael");
            case 3 : jogador = new CacadorDeDemonios("Valla");
            default : jogador = new Necromante("Malthael");
        }

        // Criação do inimigo Goblin com narrativa
        Monstro goblin = new Monstro("Goblin", 38, 5);
        System.out.println("\nAo iniciar sua jornada, você encontra um " + goblin.getNome() + " ameaçador bloqueando seu caminho!");

        // Loop do jogo onde o jogador escolhe ações
        while (jogador.getVida() > 0 && goblin.getVida() > 0) {
            System.out.println("\nO que você deseja fazer?");
            System.out.println("Escolha uma ação: atacar, habilidade, status, explorar, usar item, sair");

            String acao = scanner.nextLine().toLowerCase();

            switch (acao) {
                case "atacar" : jogador.atacar(goblin);
                case "habilidade" : {
                    if (jogador instanceof Necromante) {
                        ((Necromante) jogador).invocarEsqueleto(goblin);
                    } else if (jogador instanceof Arcanista) {
                        ((Arcanista) jogador).feitiçoPoderoso(goblin);
                    } else if (jogador instanceof CacadorDeDemonios) {
                        ((CacadorDeDemonios) jogador).flechaExplosiva(goblin);
                    }
                }
                case "status" : {
                    jogador.exibirStatus();
                    goblin.exibirStatus();
                }
                case "explorar" : {
                    System.out.println("\nVocê explora a área ao redor...");

                    if (random.nextInt(100) < 50) {  // 50% de chance de encontrar uma poção
                        System.out.println("Você encontrou uma poção de cura!");
                        pocaoDisponivel = true;
                    } else {
                        System.out.println("Não encontrou nada útil.");
                    }

                    // Chance de evitar o ataque do Goblin após explorar
                    if (random.nextInt(100) < 50) {  // 50% de chance de não ser atacado
                        System.out.println("Você foi rápido e conseguiu evitar o ataque do Goblin!");
                    } else {
                        System.out.println("O Goblin aproveita sua distração e ataca!");
                        goblin.atacar(jogador);
                    }
                }
                case "usar item" : {
                    if (pocaoDisponivel) {
                        System.out.println("Você usa a poção e recupera 20 pontos de vida.");
                        jogador.receberDano(-20);  // Cura 20 pontos de vida
                        pocaoDisponivel = false;   // A poção é usada
                    } else {
                        System.out.println("Você não tem itens para usar.");
                    }
                }
                case "sair" : {
                    System.out.println("Você decide abandonar a jornada. O reino permanece em perigo.");
                    return;
                }
                default : System.out.println("Ação inválida. Tente novamente.");
            }

            // Caso o jogador tenha escolhido atacar ou usar habilidade, o Goblin contra-ataca
            if (goblin.getVida() > 0 && !acao.equals("explorar")) {
                goblin.atacar(jogador);
            }
        }

        // Resultado final com narrativa
        if (jogador.getVida() <= 0) {
            System.out.println("\nVocê foi derrotado nas sombras... O reino chora sua perda.");
        } else if (goblin.getVida() <= 0) {
            System.out.println("\nParabéns! Você derrotou o " + goblin.getNome() + " e deu um passo à frente em sua jornada para salvar o reino!");
        }

        scanner.close();
    }
}
