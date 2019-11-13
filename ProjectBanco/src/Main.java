import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Main { //ClienteCalculadora
	public static void main(String[] args) {
		Banco banco;
		Registry registry;
		//BigDecimal resposta;
		try {
			registry = LocateRegistry.getRegistry("127.0.0.1", 2002);
			banco = (Banco) registry.lookup("Banco");

			//resposta = calculadora.adicao(BigDecimal.valueOf(2.1), BigDecimal.valueOf(1.1));
			banco.abrirConta();
			
			//System.out.println(resposta);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

