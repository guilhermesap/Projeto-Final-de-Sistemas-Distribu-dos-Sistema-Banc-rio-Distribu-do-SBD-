
public class Conta {
	private String Nome, email;
	private int cpf, telefone;
	
	public void CriarConta(String [] aux) {
		this.Nome = aux[0];
		this.cpf = Integer.parseInt(aux[1]);
		this.telefone = Integer.parseInt(aux[2]);
		this.email = aux[3];
	}
	public void exibirConta() {
		System.out.print("Que otimo, voce ja eh nosso cliente!\n");
	    System.out.print("Informe os seguintes dados para acessar sua conta.\n\n");
	    System.out.printf("Nome: %s\n", this.Nome);
	    System.out.printf("CPF: %d\n", this.cpf);
	    System.out.printf("Email: %s\n", this.email);
	    System.out.printf("Telefone: %d", this.telefone);
	}
	
}
