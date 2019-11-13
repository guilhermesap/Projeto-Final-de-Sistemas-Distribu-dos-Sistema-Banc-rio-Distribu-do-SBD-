import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMIBanco {
	public static void main(String[] args) {
		BancoImplementacao banco;
		Registry registry;

		try {
			// Criar Registry
			registry = LocateRegistry.createRegistry(2002);

			//registry = LocateRegistry.getRegistry(2000);
			banco = new BancoImplementacao();
			registry.rebind("Banco", banco);

			System.out.println("Servidor em execução");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
