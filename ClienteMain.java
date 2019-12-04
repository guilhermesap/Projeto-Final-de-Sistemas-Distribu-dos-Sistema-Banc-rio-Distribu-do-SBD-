import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;



public class ClienteMain { //Cliente Main
	
	public static void main(String[] args) {
		Banco banco;
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("127.0.0.1", 2002);
			banco = (Banco) registry.lookup("Banco");
			principal(banco);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void principal(Banco banco) throws RemoteException {
		Scanner ler = new Scanner(System.in);
		System.out.println(banco.menu());
		int n = ler.nextInt();
		while(n!=0) {
			switch(n) {
				case 1:{	//Abrir conta
					String[] Dados;
					Dados = Views.CRIAR_CONTA();
					boolean result = banco.abrirConta(Dados);
					if(result == true) {
						System.out.println("Codigo da conta: " + banco.getCodigo(Dados[0]));
						System.out.println("Conta criada com sucesso!");
					}
					else System.out.println("\nConta já existe!\n");
					break;
				}
				case 2:{	//Acessar Conta
					String [] Dados = new String[2];
				    System.out.print("Código da Conta: ");
				    Dados[0] = Views.SC.next();
				    System.out.print("Senha: ");
				    Dados[1] = Views.SC.next();
				    if(banco.acessarConta(Dados)) 
				    	acessarConta(Dados, banco);
				    else System.out.println("Usuario ou Senha incorretos!");
				    break;
				}
				case 3:
					System.out.println(banco.listar());
					//Views.BYE();
					break;
			}
			System.out.println(banco.menu());
			n = ler.nextInt();
		}
	}
	
	public static void acessarConta(String Dados[], Banco banco) throws RemoteException {
		//Dados[0] Nome, Dados[1] Senha
		Scanner ler = new Scanner(System.in);
		menuConta();
		Dados[0] = banco.getNome(Integer.parseInt(Dados[0]));
		int n = ler.nextInt();
		while(n!=0){
			switch(n){
				case 1:{	//Exibir dados da conta
					System.out.println(banco.exibirConta(Dados[0]));
					break;
				}
				case 2:{	//Depositar
					if(banco.existeConta(Dados[0])) {
						System.out.print("\nDigite o valor: ");
						Double valor = ler.nextDouble();
						System.out.println(banco.depositar(Dados[0], valor));
					}else {
						System.out.println("Conta inexistente!");
					}
					break;
				}
				case 3:{	//Saque
					if(banco.existeConta(Dados[0])) {
						System.out.print("\nDigite o valor: ");
						Double valor = ler.nextDouble();
						System.out.println(banco.saque(Dados[0], valor));
					}else {
						System.out.println("Conta inexistente!");
					}
					break;
				}
				case 4:{	//Consultar Saldo
					if(banco.existeConta(Dados[0])){
						System.out.print("Saldo: ");
						System.out.println(banco.saldo(Dados[0]));
					}else {
						System.out.println("Conta inexistente!");
					}
					break;
				}
				case 5:{
					System.out.print("Digite o nome do Favorecido: ");
					String favorecido = ler.next();
					if(banco.existeConta(favorecido)){
						System.out.print("Digite o valor: ");
						double valor = ler.nextDouble();
						System.out.println("\n"+banco.transferir(Dados[0], favorecido, valor)+"\n");
					}else {
						System.out.println("\nConta inexistente!\n");
					}
					break;
				}
				case 6:{
					principal(banco);
				}
			}
			menuConta();
			n = ler.nextInt();
		}
	}
		
	public static void menuConta() {
		String MENU = "";
	   //MENU += Views.CABECALHO;
	    MENU += "\nBem-Vindo(a) a sua conta Banco 2.0!\n\nOperacoes:\n";
	    MENU += "[1] - Exibir Dados da Conta\n";
	    MENU += "[2] - Deposito\n";
	    MENU += "[3] - Saque\n";
	    MENU += "[4] - Consultar Saldo\n";
	    MENU += "[5] - Transferir\n";
	    MENU += "[6] - Sair do sistema\n:";
	    System.out.print(MENU);
	}
}

