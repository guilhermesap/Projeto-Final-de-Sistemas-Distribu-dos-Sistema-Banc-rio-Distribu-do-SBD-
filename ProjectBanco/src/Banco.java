import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Banco extends Remote{
	public void abrirConta() throws RemoteException;
	//public int fecharConta(int id) throws RemoteException;
	//public int consulta() throws RemoteException;

}