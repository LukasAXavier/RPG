import personagens.*;
import monstros.*;
import itens.Item;
import java.util.Scanner;
import java.util.Random;

public class Jogo {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            Personagem jogador = escolherPersonagem(scanner);
            Item pocaoCura = new Item("Poção de Cura", 20, "cura");
            Item pocaoXP = new Item("Poção de XP", 0, "xp");

            System.out.println("\nVocê começa sua aventura!");

            boolean enfrentouBoss = false;
            int contadorMonstros = 0;

            while (jogador.getVida() > 0 && !enfrentouBoss) {
                System.out.println("\n******************************");
                System.out.println("Escolha uma direção para explorar:");
                System.out.println("Esquerda");
                System.out.println("Direita");
                System.out.println("Frente");
                System.out.println("******************************");
                String direcao = scanner.nextLine().toLowerCase();

                switch (direcao) {
                    case "esquerda":
                        System.out.println("\nVocê encontra um monstro!");
                        Monstro goblin = new Monstro("Goblin", 25, 8);

                        if (contadorMonstros > 0) {
                            goblin.aumentarNivel();
                        }

                        System.out.printf("Você encontrou um %s nível %d!\n", goblin.getNome(), goblin.getNivelMonstro());

                        if (iniciarBatalha(jogador, goblin, scanner)) {
                            jogador.subirNivel();
                            contadorMonstros++;
                        }
                        break;

                    case "direita":
                        System.out.println("\nVocê encontra uma poção!");
                        if (random.nextBoolean()) {
                            System.out.println("Você encontrou uma Poção de Cura.");
                            pocaoCura.usar(jogador);
                        } else {
                            System.out.println("Você encontrou uma Poção de XP!");
                            pocaoXP.usar(jogador);
                        }
                        break;

                    case "frente":
                        System.out.println("\nVocê sente uma presença ameaçadora à frente. Parece que há um Boss nesta direção.");
                        System.out.println("Deseja enfrentar o Boss ou fugir? (enfrentar/fugir)");
                        String escolha = scanner.nextLine().toLowerCase();

                        if (escolha.equals("enfrentar")) {
                            enfrentouBoss = iniciarBatalha(jogador, new Boss(), scanner);
                            if (enfrentouBoss) {
                                jogador.subirNivel();
                            }
                        } else {
                            System.out.println("\nVocê escolheu fugir e evitar o confronto com o Boss por enquanto.");
                        }
                        break;

                    default:
                        System.out.println("\nDireção inválida. Tente novamente.");
                        break;
                }
            }

            if (jogador.getVida() <= 0) {
                System.out.println("\nVocê foi derrotado... Fim de jogo.");
            } else if (enfrentouBoss) {
                System.out.println("\nParabéns! Você completou sua aventura e derrotou o Boss!");
            }
        }
    }


    /**
     * Método para escolher o personagem do jogador.
     * Aplica o tratamento de exceções para garantir que a entrada seja válida (exemplo de Tratamento de Exceções).
     */
    public static Personagem escolherPersonagem(Scanner scanner) {
        try {
            System.out.println("******************************");
            System.out.println("Escolha seu personagem:");
            System.out.println("1 - Arcanista");
            System.out.println("2 - Caçador de Demônios");
            System.out.println("3 - Necromante");
            System.out.println("******************************");
            int escolha = Integer.parseInt(scanner.nextLine());  // Tratamento de Exceção: NumberFormatException

            // Exemplo de Polimorfismo: Retornamos diferentes tipos de Personagem dependendo da escolha
            switch (escolha) {
                case 1:
                    return new Arcanista();
                case 2:
                    return new CacadorDeDemonios();
                case 3:
                    return new Necromante();
                default:
                    System.out.println("Escolha inválida! Você será o Arcanista por padrão.");
                    return new Arcanista();
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Você será o Arcanista por padrão.");
            return new Arcanista();
        }
    }

    /**
     * Método que inicia uma batalha entre o jogador e um inimigo.
     * @param jogador O personagem do jogador
     * @param inimigo O inimigo (pode ser Monstro ou Boss)
     * @param scanner Scanner para capturar entradas do jogador
     * @return true se o jogador vencer, false se perder
     */
    public static boolean iniciarBatalha(Personagem jogador, Personagem inimigo, Scanner scanner) {
        System.out.println("\nInício da batalha com " + inimigo.getNome() + "!");

        while (jogador.getVida() > 0 && inimigo.getVida() > 0) {
            System.out.println("\n******************************");
            System.out.println("Escolha sua ação:");
            System.out.println("Atacar");
            System.out.println("Defender");
            System.out.println("Usar Habilidade");
            System.out.println("Status");
            System.out.println("******************************");
            String acao = scanner.nextLine().toLowerCase();

            switch (acao) {
                case "atacar":
                    jogador.atacar(inimigo);
                    if (inimigo.getVida() > 0) {
                        System.out.println("\n" + inimigo.getNome() + " ainda tem " + inimigo.getVida() + " HP.");
                    }
                    break;
                case "defender":
                    jogador.defender();
                    break;
                case "usar habilidade":
                    jogador.usarHabilidade(inimigo);  // Exemplo de Polimorfismo, pois cada Personagem tem uma habilidade única
                    if (inimigo.getVida() > 0) {
                        System.out.println("\n" + inimigo.getNome() + " ainda tem " + inimigo.getVida() + " HP.");
                    }
                    break;
                case "status":
                    jogador.exibirStatus();
                    inimigo.exibirStatus();
                    continue;
                default:
                    System.out.println("\nAção inválida.");
                    break;
            }

            // Inimigo só ataca se ainda estiver vivo e o jogador não tiver escolhido ver status
            if (inimigo.getVida() > 0 && !acao.equals("status")) {
                inimigo.atacar(jogador);
            }
        }

        return jogador.getVida() > 0;
    }
}
