import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class BancoImplementacao extends UnicastRemoteObject implements Banco{
	private static final long serialVersionUID = -2924000165294588367L;
	
	protected BancoImplementacao() throws RemoteException {
		super();
	}
	@Override
	public void abrirConta() throws RemoteException{
		String[] Dados;
		Dados = Views.CRIAR_CONTA();
		Conta contaCliente = new Conta();
		contaCliente.CriarConta(Dados);
		contaCliente.exibirConta();
	}

}
