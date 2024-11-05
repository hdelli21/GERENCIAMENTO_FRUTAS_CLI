import java.util.HashSet; // Guarda as frutas sem repetir
import java.util.InputMismatchException; // Cuida dos erros de entrada
import java.util.Scanner; // Lê as escolhas do usuário

public class GerenciamentoFrutas { // Programa de gerenciamento de frutas
    public static void main(String[] args) { // Início do programa
        Scanner scanner = new Scanner(System.in); // Para ler o que o usuário digita
        HashSet<String> frutas = new HashSet<>(); // Onde guardamos as frutas

        while (true) { // Loop para o menu
            try {
                // Opções para o usuário escolher
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Adicionar uma fruta");
                System.out.println("2. Listar todas as frutas");
                System.out.println("3. Remover uma fruta");
                System.out.println("4. Verificar presença de uma fruta");
                System.out.println("5. Sair");
                System.out.print("Opção: ");

                int opcao = scanner.nextInt(); // Guarda a escolha do usuário
                scanner.nextLine(); // Limpa a entrada

                switch (opcao) {
                    case 1: // Adiciona uma fruta nova
                        System.out.print("Digite o nome da fruta: ");
                        String novaFruta = scanner.nextLine().trim(); // Lê a fruta
                        if (frutas.add(novaFruta)) { // Se for nova, adiciona
                            System.out.println(novaFruta + " adicionada!");
                        } else {
                            System.out.println(novaFruta + " já está na lista.");
                        }
                        break;

                    case 2: // Mostra todas as frutas
                        if (frutas.isEmpty()) {
                            System.out.println("Nenhuma fruta cadastrada.");
                        } else {
                            System.out.println("Frutas: " + frutas);
                        }
                        break;

                    case 3: // Tira uma fruta da lista
                        System.out.print("Digite o nome da fruta a remover: ");
                        String frutaRemover = scanner.nextLine().trim(); // Lê o nome
                        if (frutas.remove(frutaRemover)) { // Remove se estiver lá
                            System.out.println(frutaRemover + " foi removida.");
                        } else {
                            System.out.println(frutaRemover + " não foi encontrada.");
                        }
                        break;

                    case 4: // Vê se a fruta já está cadastrada
                        System.out.print("Digite o nome da fruta: ");
                        String frutaVerificar = scanner.nextLine().trim();
                        if (frutas.contains(frutaVerificar)) {
                            System.out.println(frutaVerificar + " já está na lista.");
                        } else {
                            System.out.println(frutaVerificar + " não foi encontrada.");
                        }
                        break;

                    case 5: // Sai do programa
                        System.out.println("Encerrando...");
                        scanner.close(); // Fecha o scanner
                        return; // Termina tudo

                    default: // Opção errada
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) { // Captura entradas erradas
                System.out.println("Digite um número válido!");
                scanner.nextLine(); // Limpa a entrada inválida
            }
        }
    }
}
