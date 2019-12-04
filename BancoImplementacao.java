import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class BancoImplementacao extends UnicastRemoteObject implements Banco{
	private static final long serialVersionUID = -2924000165294588367L;
	
	List<Conta> listConta = new ArrayList<Conta>();
	int contContas = 0;
	
	protected BancoImplementacao() throws RemoteException {
		super();
	}
	
	public void msg(String msg) {
		System.out.println(msg);
	}
	
	@Override
	public String menu() throws RemoteException{
		return Views.MENU_PRINCIPAL();
	}
	
	@Override
	public boolean abrirConta(String Dados[]) throws RemoteException{
		msg("Conta sendo criada");
		if(listConta.isEmpty()){
			contContas += 1;
			abrir(Dados);
			msg("Nova conta criada: " + Dados[0]);
			return true;
		}else {
			for(int i=0; i<listConta.size(); i++ ) {
				if(listConta.get(i).getNome().equals(Dados[0])) {
					msg("Conta não criada: " + Dados[0]);
					return false;
				}else{
					if(i==listConta.size()-1) {
						contContas += 1;
						abrir(Dados);
						msg("Nova conta criada: " + Dados[0]);
						return true;
					}
				}
			}
		}
		return true;
	}
	
	public void abrir(String Dados[]) throws RemoteException{
		Cliente cliente = new Cliente();
		cliente.CriarCliente(Dados);
		Conta contaCliente = new Conta(cliente, Dados[1], contContas);
		listConta.add(contaCliente);
	}
	
	@Override	
	public boolean acessarConta(String Dados[]) throws RemoteException{
		msg("Conta sendo acessada: " + Dados[0]);
		if(listConta.isEmpty())
			return false;
		else {
			for(int i=0; i<listConta.size(); i++ ) {
				if(listConta.get(i).getCodigo() == Integer.parseInt(Dados[0])) {
					if(listConta.get(i).getSenha().equals(Dados[1])) {
						return true;
					}else {
						return false;
					}
				}else{
					if(i == listConta.size()-1)  return false;
				}
			}
			return false;
		}
	}
	
	@Override
	public String exibirConta(String nome) throws RemoteException{
		if(listConta.isEmpty()) {
			return "Conta inexistente!";
		}else {
			for(int i=0; i<listConta.size(); i++ ) {
				if(listConta.get(i).getNome().equals(nome)) {
					msg("Dados da conta : " + nome + " sendo acessados.");
					return listConta.get(i).exibeDados();
				}else{
					return "Conta inexistente!";
				}
			}
		}
		return null;
	}
	
	public String todasContas() throws RemoteException{
		String aux = "";
		for(int i=0; i<listConta.size(); i++ ) {
			aux += this.listConta.get(i).exibeDados() + "\n";
		}
		return aux;
	}
	
	@Override
	public boolean existeConta(String nome) throws RemoteException{
		if(listConta.isEmpty()) {
			return false;
		}else {
			for(int i=0; i<listConta.size(); i++) {
				if(listConta.get(i).getNome().equals(nome)) {
					return true;
				}else{
					if(i == listConta.size()-1)
						return false;
				}
			}
		}
		return false;		
	}
	
	@Override
	public String depositar(String nome, Double valor) throws RemoteException{
		for(int i=0; i<listConta.size(); i++ ) {
			if(listConta.get(i).getNome().equals(nome)) {
				listConta.get(i).depositar(valor);
				msg("Deposito na conta: " + nome + " realizado.");
				msg("Valor: " + valor);
				return "Deposito realizado com sucesso!";
			}
		}
		return "";
	}
	
	@Override
	public String saque(String nome, Double valor) throws RemoteException{
		for(int i=0; i<listConta.size(); i++ ) {
			if(listConta.get(i).getNome().equals(nome)) {
				msg("Saque da conta: " + nome + " realizado.");
				msg("Valor: " + valor);
				return listConta.get(i).saque(valor);
			}
		}
		return "";
	}
	
	@Override
	public double saldo(String nome) throws RemoteException{
		for(int i=0; i<listConta.size(); i++ ) {
			if(listConta.get(i).getNome().equals(nome)) {
				msg("Saldo de " + nome + " sendo consultado.");
				return listConta.get(i).getSaldo();
			}
		}
		return 0;
	}
	
	@Override
	public String transferir(String remetente, String destino, Double valor) throws RemoteException{
		if((saldo(remetente)-valor) <= 0) return "Saldo Insuficiente";
		else {
			depositar(destino, valor);
			saque(remetente, valor);
			msg("Transferencia de: " + remetente);
			msg("Para: " + destino + ", valor: " + valor);
			msg("Realizada!");
			return "Trasnferencia realizada com sucesso";
		}
	}
	
	public int getCodigo(String nome) throws RemoteException{
		for(int i=0; i<listConta.size(); i++ ) {
			if(listConta.get(i).getNome().equals(nome)) {
				return listConta.get(i).getCodigo();
			}
		}
		return 0;
	}
	
	public String getNome(int cod) throws RemoteException{
		for(int i=0; i<listConta.size(); i++ ) {
			if(listConta.get(i).getCodigo() == cod) {
				return listConta.get(i).getNome();
			}
		}return "";
	}
	
	public String listar() {
		String aux = "";
		for(int i=0; i<listConta.size(); i++ ) {
			aux += listConta.get(i).getNome() + "\n";
			aux += listConta.get(i).getCodigo()+ "\n\n";
		}return aux;
	}
}
