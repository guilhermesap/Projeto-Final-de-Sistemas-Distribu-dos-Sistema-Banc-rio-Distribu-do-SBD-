import java.rmi.RemoteException;

public class Cliente {
	private String Nome, email;
	private int cpf, telefone;
	
	public void CriarCliente(String Dados[]) {

		this.Nome = Dados[0];
		//this.cpf = Integer.parseInt(Dados[1]);
		//this.telefone = Integer.parseInt(Dados[2]);
		//this.email = Dados[3];
		//this.Nome = nome;
	}
	
	public String exibirDadosCliente() {	    
	    String Dados = "";
	    //Dados += Views.CABECALHO;
	    Dados += "Dados Cliente\n";
	    Dados += "[1] - Nome: ";
	    Dados += this.Nome;
	    Dados += "\n";
	    //Dados += "\n[2] - Exibir Contas\n";
	    //Dados += "[3] - Deposito\n";
	    //Dados += "[4] - Saque\n";
	    //Dados += "Opção: ";
	    return Dados;
	}
	
	public String getNome() {
		return this.Nome;
	}
		
}
