import java.io.Serializable;

public class Conta implements Serializable{
	private int numero;
	private String senha;
	private double saldo;
	private boolean status;
	private Cliente cliente;

	private String log = "";

	public Conta(Cliente cliente, String senha, int num){
		this.numero = num;
		this.cliente = cliente;
		this.senha = senha;
		this.saldo = 0;
		this.status = true;	
	}
	
	public int getCodigo() {
		return this.numero;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public String saque(double valor) {
		if(saldo == 0) {
			return "Saldo insuficiente!";
		}else {
			this.saldo -= valor;
			return "Saque realizado!";
		}
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public int numero() {
		return this.numero;
	}
	public String getNome(){
		String aux = this.cliente.getNome();
		return aux;
	}
	public String exibeDados() {
		String aux;
		aux = this.cliente.exibirDadosCliente();
		aux += "[2] - Saldo: " + this.saldo + "\n";
	    aux += "[3] - Senha: " + this.senha + "\n";
		return aux;
	}

}
