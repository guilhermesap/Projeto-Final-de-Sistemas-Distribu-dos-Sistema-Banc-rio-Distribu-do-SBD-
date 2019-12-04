import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMIBanco {		//SERVIDOR
	public static void main(String[] args) {
		BancoImplementacao banco;
		Registry registry;

		try {
			// Criar Registry
			registry = LocateRegistry.createRegistry(2002);
			banco = new BancoImplementacao();
			
			registry.rebind("Banco", banco);
			
			System.out.println("Servidor em execucao");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
