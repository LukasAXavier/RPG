import personagens.*;
import monstros.*;
import itens.Item;
import java.util.Scanner;
import java.util.Random;

public class Jogo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Personagem jogador = escolherPersonagem(scanner);
        Item pocao = new Item("Poção de Cura", 20);

        System.out.println("\nVocê começa sua aventura!");

        boolean enfrentouBoss = false;
        int contadorMonstros = 0;  // Inicializa em zero, só aumenta após o primeiro combate

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
                        aumentarAtributosMonstro(goblin, contadorMonstros);
                    }
                    
                    if (iniciarBatalha(jogador, goblin)) {
                        jogador.subirNivel();
                        contadorMonstros++;  // Incrementa após o primeiro combate
                    }
                    break;
                case "direita":
                    System.out.println("\nVocê encontra uma poção de cura!");
                    pocao.usar(jogador);
                    break;
                case "frente":
                    System.out.println("\nVocê sente uma presença ameaçadora à frente. Parece que há um Boss nesta direção.");
                    System.out.println("Deseja enfrentar o Boss ou fugir? (enfrentar/fugir)");
                    String escolha = scanner.nextLine().toLowerCase();

                    if (escolha.equals("enfrentar")) {
                        enfrentouBoss = iniciarBatalha(jogador, new Boss());
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

        scanner.close();
    }

    public static Personagem escolherPersonagem(Scanner scanner) {
        System.out.println("******************************");
        System.out.println("Escolha seu personagem:");
        System.out.println("1 - Arcanista");
        System.out.println("2 - Caçador de Demônios");
        System.out.println("3 - Necromante");
        System.out.println("******************************");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                return new Arcanista();
            case 2:
                return new CacadorDeDemonios();
            case 3:
                return new Necromante();
            default:
                System.out.println("\nEscolha inválida! Você será o Arcanista por padrão.");
                return new Arcanista();
        }
    }

    public static boolean iniciarBatalha(Personagem jogador, Personagem inimigo) {
        System.out.println("\nInício da batalha com " + inimigo.getNome() + "!");
        Scanner scanner = new Scanner(System.in);

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
                    jogador.usarHabilidade(inimigo);
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

            if (inimigo.getVida() > 0 && !acao.equals("status")) {
                inimigo.atacar(jogador);
            }
        }

        return jogador.getVida() > 0;
    }

    public static void aumentarAtributosMonstro(Monstro monstro, int contador) {
        double aumento = Math.pow(1.07, contador);  // Aumenta 7% a cada encontro adicional
        monstro.setVida((int)(monstro.getVida() * aumento));
        monstro.setAtaque((int)(monstro.getAtaque() * aumento));
        monstro.setDefesa((int)(monstro.getDefesa() * aumento));

        System.out.printf("\nO %s está mais forte! Vida: %.0f, Ataque: %.0f, Defesa: %.0f\n",
                monstro.getNome(), (double) monstro.getVida(), (double) monstro.getAtaque(), (double) monstro.getDefesa());
    }
}
