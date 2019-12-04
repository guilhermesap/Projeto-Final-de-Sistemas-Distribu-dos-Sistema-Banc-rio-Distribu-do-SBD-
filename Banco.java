import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Banco extends Remote{
	public boolean acessarConta(String Dados[]) throws RemoteException;
	public boolean abrirConta(String Dados[]) throws RemoteException;	//OK
	public String exibirConta(String nome) throws RemoteException;
	public String menu() throws RemoteException;
	public boolean existeConta(String nome) throws RemoteException;
	public String depositar(String nome, Double valor) throws RemoteException;
	public String saque(String nome, Double valor) throws RemoteException;
	public double saldo(String nome) throws RemoteException;
	public String todasContas() throws RemoteException;
	public String transferir(String remetente, String destino, Double valor) throws RemoteException;
	public int getCodigo(String nome) throws RemoteException;
	public String getNome(int cod) throws RemoteException;
	public String listar() throws RemoteException;
}