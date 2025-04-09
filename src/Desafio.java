import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        // Leitura de dados
        Scanner scanner = new Scanner (System.in);

        // Entrada com o nome do usuário
        System.out.print("Digite o nome do cliente: ");
        String cliente = scanner.nextLine();

        // Saldo em conta começa com 0
        double saldo = 0;

        while (true) {

            // Menu de opções
            System.out.println("""
                
                [OPERAÇÕES]
                
                1 -> CONSULTAR
                2 -> DESPOSITAR
                3 -> SACAR
                4 -> SAIR
                """);
            System.out.print("Digite a opção ==> ");
            int menu = scanner.nextInt();

            // Condições do menu
            if (menu == 1) {
                // Aqui imprime os dados do usuário
                System.out.println(String.format("""
                
                ******************************
                       DADOS DO CLIENTE
                       
                Cliente: %s
                Tipo de conta: Corrente
                Saldo: %.2f
                ******************************
                """, cliente, saldo));
            } else if (menu == 2) {
                // Aqui o usuário vai adicionar um valor em conta
                System.out.println();
                System.out.print("Digite o valor: R$");
                double valor = scanner.nextDouble();
                saldo += valor;
                System.out.println();
                System.out.println(String.format("Valor depositado: R$%.2f", valor));
            } else if (menu == 3) {
                // Aqui o usuário vai retirar um valor em conta com algumas condições
                if (saldo == 0) {
                    // Conta zerada
                    System.out.println();
                    System.out.println("Conta zerada!");
                } else {
                    // Sacar o valor aqui
                    System.out.println();
                    System.out.print("Digite o valor: R$");
                    double valor = scanner.nextDouble();
                    if (valor > saldo) {
                        // Se o valor for maior que o saldo em conta, saldo insuficiente
                        System.out.println();
                        System.out.println("Saldo insuficiente...");
                    } else {
                        // Senão, o valor é sacado
                        System.out.println();
                        System.out.println(String.format("Valor sacado: R$%.2f", valor));
                        saldo -= valor;
                    }
                }
            } else if (menu == 4) {
                // Parar a aplicação
                System.out.println();
                System.out.println("Finalizando o programa...");
                break;
            } else {
                // Caso digite algo errado...
                System.out.println();
                System.out.println("Opção inválida!");
            }

        }

        // Fechamento da leitura de dados (boa prática)
        scanner.close();
    }
}
