import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Conta> contas = new ArrayList<>();

		
		
		int opcao = 0;

		do {
			System.out.println("Menu do Banco Digital");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Cadastrar conta");
			System.out.println("3 - Imprimir extrato");
			System.out.println("4 - Sair");

			System.out.println("Opção: ");

			opcao = input.nextInt();

			switch (opcao) {
				case 1:
					System.out.println("Cadastro de cliente");
					System.out.println("Digite seu nome completo: ");
					String nome = input.next();

					System.out.println("Digite seu CPF: ");
					String cpf = input.next();

					System.out.println("Verifique suas informações e digite 1 para confirmar: ");
					System.out.println("Nome: " + nome);
					System.out.println("CPF: " + cpf);
					int confirmacao = input.nextInt();

					if (confirmacao == 1) {
						Cliente cliente = new Cliente(nome, cpf);
						System.out.println("Cliente Cadastrado!");
						clientes.add(cliente);
					}

					else {
						System.out.println("Operação cancelada");
					}
					break;
				case 2:
					System.out.println("Cadastrar conta");
					System.out.println("Selecione uma conta: ");
					System.out.println("1 - Conta Corrente");
					System.out.println("2 - Conta Poupança");
					System.out.println("4 - Voltar");
					int tipoConta = input.nextInt();
					if (tipoConta == 1) {
						System.out.println("Digite sua agencia: ");
						int agencia = input.nextInt();
						System.out.println("Digite sua conta: ");
						int conta = input.nextInt();
						System.out.println("Selecione um Cliente");

						if (clientes.size() > 0) {
							for (int i = 0; i < clientes.size(); i++) {
								System.out.println((i) + " - " + clientes.get(i).getNome());
							}

							int cliente = input.nextInt();
							// criar conta
							ContaCorrente contaCorrente = new ContaCorrente(clientes.get(cliente), agencia, conta);
							contas.add(contaCorrente);
							System.out.println("Criado Conta Corrente Cadastrada!");
						}

						else {
							System.out.println("Nenhum cliente cadastrado");
						}

						break;

					}

					else if (tipoConta == 2) {
						System.out.println("Digite sua agencia: ");
						int agencia = input.nextInt();
						System.out.println("Digite sua conta: ");
						int conta = input.nextInt();
						System.out.println("Selecione um Cliente");
						if (clientes.size() > 0) {
							for (int i = 0; i < clientes.size(); i++) {
								System.out.println((i) + " - " + clientes.get(i).getNome());
							}
							int cliente = input.nextInt();
							// criar conta
							ContaPoupanca contaPoupanca = new ContaPoupanca(clientes.get(cliente), agencia, conta);
							contas.add(contaPoupanca);
							System.out.println("Criado Conta Poupança Cadastrada!");

						}

						else {
							System.out.println("Nenhum cliente cadastrado");
						}
						break;

					}
				case 3:
					if (contas.size() > 0) {
						System.out.println("Selecione uma conta");
						for (int i = 0; i < contas.size(); i++) {
							System.out.println((i) + " - " + contas.get(i).getNumero());
						}
						int conta = input.nextInt();
						contas.get(conta).imprimirExtrato();
					} else {
						System.out.println("Nenhuma conta cadastrada");
					}
					break;

				case 4:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida, tente novamente");
					break;

			}
		} while (opcao != 4);
		System.out.println("Saindo...");

	}

}
