import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nome = "Leonardo Pereira";
        String tipoDeConta = "Poupança";
        double saldo = 400.00;
        Scanner scan = new Scanner(System.in);
        int opcao  = 0;

        dadosCliente(nome, tipoDeConta, saldo);
        operacoes();
        while (opcao != 4){
            opcao = scan.nextInt();
            switch (opcao){
                case 1:
                    consultaSaldo(saldo);
                    break;
                case 2:
                    saldo = recebeValor(saldo);
                    break;
                case 3:
                    saldo = transfereValor(saldo);
                    break;
                case 4:
                    System.out.println("Obrigado pela preferência!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    operacoes();
                    break;
            }
        }

    }

    public static void dadosCliente(String nome,String tipoDeConta,double saldo){
        DecimalFormat deci = new DecimalFormat("0.00");
        System.out.println("*********************************");
        System.out.println("Nome:          "+nome);
        System.out.println("Tipo de Conta: "+tipoDeConta);
        System.out.println("Saldo inicial: R$ "+ deci.format(saldo));
        System.out.println("*********************************");
    }

    public static void operacoes(){
        System.out.println("Operações \n");
        System.out.println("1- Consultar Saldos");
        System.out.println("2- Receber valor");
        System.out.println("3- Transferir valor");
        System.out.println("0- Sair");
    }

    private static void consultaSaldo(double saldo) {
        DecimalFormat deci = new DecimalFormat("0.00");
        System.out.println("O saldo atual é RS: "+deci.format(saldo));
    }
    private static double recebeValor(double saldo) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat deci = new DecimalFormat("0.00");
        System.out.println("Informe o valor a receber: ");
        double valorRecebido = scan.nextDouble();
        System.out.println("Saldo atualizado R$: "+deci.format(valorRecebido+saldo));
        return valorRecebido+saldo;
    }
    private static double transfereValor(double saldo) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat deci = new DecimalFormat("0.00");
        double valorTransferido;
        do {
            System.out.println("Informe o valor que deseja transferir: ");
            valorTransferido = scan.nextDouble();
            if (valorTransferido > saldo){
                System.out.println("Valor inválido! Saldo insuficiente.");
            } else if (valorTransferido < 0){
                System.out.println("Valor inválido! Impossível transferir valor negativo.");
            }
        }while (valorTransferido > saldo || valorTransferido < 0);

        System.out.println("Saldo atualizado R$: "+deci.format(saldo-valorTransferido));
        return saldo-valorTransferido;
    }
}