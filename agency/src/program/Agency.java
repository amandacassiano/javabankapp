package program;

import java.util.ArrayList;
import java.util.Scanner;

public class Agency {
	
	static Scanner input = new Scanner(System.in);
	
	static ArrayList<Account> accounts;
	
	public static void main (String [] args) {
		accounts = new ArrayList<Account>();
		operacoes();
	}

	private static void operacoes() {
		System.out.println("-----------------------------------------------");
		System.out.println("--------------------Welcome--------------------");
		System.out.println("-----------------------------------------------");
		System.out.println("********Select your choosen operation**********");
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");
		System.out.println("| 1 - Create Account      |");
		System.out.println("| 2 - Deposit    	  |");
		System.out.println("| 3 - Withdraw 		  |");
		System.out.println("| 4 - Transfer  	  |");
		System.out.println("| 5 - List 	     	  |");
		System.out.println("| 6 - Finish 		  |");
		
		int operacao =  input.nextInt();
		
		switch (operacao) {
		case 1: {
			criarConta();
			break;
		}
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6:
			System.out.println("Thank you for choosing our agency.");
			System.exit(0);
			
		default:
			System.out.println("Invalid Option!");
			operacoes();
			break;
		}
		
		
	}
	

	public static void criarConta() {
		
		System.out.println("\nNome: ");
		String nome = input.next();
		
		System.out.println("\nCPF:");
		String cpf = input.next();
		
		System.out.println("\nEmail:");
		String email = input.next();
		
		User user = new User (nome, cpf, email);
		
		Account contabancaria = new Account(user);
		
		accounts.add(contabancaria);
		System.out.println("Your account was created with success!!!");
		
		operacoes();
	}
// se tiver alguma conta com o numero que o usuario está pesquisando, ele vai retornar essa conta.
	private static Account encontrarConta (int numeroConta) {
		Account contabancaria = null;
		if (accounts.size() > 0) {
			for (Account c: accounts) {
				if (c.getNumeroConta() == numeroConta);
				contabancaria = c;
			}
		}
		return contabancaria;
	}
	public static void depositar() {
		System.out.println("Account Number:");
		int numeroConta = input.nextInt();
		
		Account contabancaria = encontrarConta(numeroConta);
		
		if (contabancaria != null) {
			System.out.println("How much do you want to deposit?");
			Double valueDeposito = input.nextDouble();
			contabancaria.depositar(valueDeposito);
	}else{
		System.out.println("Account not found!");	
		 }
		operacoes();
	}
	public static void sacar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Account contabancaria = encontrarConta(numeroConta);
		
		if (contabancaria != null) {
			System.out.println("How much do you want to withdraw?");
			Double valorSaque = input.nextDouble();
			contabancaria.sacar(valorSaque);
			System.out.println("Success!");
		}else {
			System.out.println(" Account not found!");
		}
		operacoes();
	}
	private static void transferir() {
		System.out.println("Sender account number: ");
		int numeroContaRemetente = input.nextInt();
		
		Account contaRemetente = encontrarConta (numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Recipient account number: ");
			int numeroContaDestinatario = input.nextInt();
			
			Account contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if (contaDestinatario != null) {
				System.out.println("Transfer value");
				Double value = input.nextDouble();
				
				contaRemetente.transferencia(contaDestinatario, value);
				
			}else {
				System.out.println("--- Account for deposit not found ---");
			}
		}else {
			System.out.println(" Account for transfer not found");
		}
			
			operacoes();	
	}
	 public static void listar() {
		 if (accounts.size() > 0) {
			 for (Account contabancaria: accounts ) {
				 System.out.println(contabancaria);
			 }
		 }else {
				 System.out.println("No registered accounts! ");
			 }
		 operacoes();
		 }
}
	 

