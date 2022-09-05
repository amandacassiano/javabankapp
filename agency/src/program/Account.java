package program;

import utilities.Utils;

public class Account {

	private static int contador = 1;
	// definir um contador para que sempre que uma conta for criada, seja atribuido
	// um novo numero para ela

	private int numeroConta;
	private User user;
	private Double saldo = 0.0;

	public Account(User user) {
		this.numeroConta = contador;
		this.user = user;
		contador += 1;
	}
//definindo metodos gettes e setters e contrutores
	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public User getUsuario() {
		return user;
	}

	public void setUsuario(User user) {
		this.user = user;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
//definindo os parametros para string
	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() +
		        "\nNome: " + this.user.getNome() +
		        "\nCPF: " + this.user.getCPF() +
		        "\nEmail: " + this.user.getEmail() +
		        "\nSaldo: " + Utils.doubletoString(this.getSaldo()) +
		        "\n";
	}//implementar novos metodos de depositar, transferencia e etc
	
	public void depositar (Double value) {
		if (value > 0) {
			setSaldo(getSaldo() + value);
			System.out.println("Depósito realizado com sucesso!");
		}else {
			System.out.println("Depósito não foi possível.");
		}
	}
	public void sacar ( Double value ) {
		if (value > 0 && this.getSaldo() >= value) {
			setSaldo(getSaldo() - value);
			System.out.println("Saque realizado com sucesso!");
		}else {
			System.out.println("Saque não foi possível.");
		}
	}
	
	public void transferencia (Account contaParaDeposito, Double value){
		if (value > 0 && this.getSaldo() >= value) { 
		setSaldo(getSaldo() - value);
		
		contaParaDeposito.saldo = contaParaDeposito.getSaldo() + value;
		System.out.println("Transferência realizada com sucesso!");
		}else {
			System.out.println("Tranferência não foi possível.");
		}
	}

}
