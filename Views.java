/*
  ### CLASSE Views ###

  VOCE DEVE CHAMAR O VALOR DESEJADO DESSA FORMA: System.out.print(Views.NOME) ou Views.NOME()
  SE FOR UM METODO.

*/

import java.util.Scanner;
public class Views
{

  public static Scanner SC = new Scanner(System.in);

  public static String CABECALHO = "------------- Banco 2.0 -------------\n";
  public static String BANCO_VERSAO = "v0.4";
  public static String Views_VERSAO = "v0.1";

  public static String MENU_PRINCIPAL()
  {
    String MENU = "";
    MENU += Views.CABECALHO;
    MENU += "Menu\n";
    MENU += "[1] - Criar Conta\n";
    MENU += "[2] - Acessar Conta\n";
    /*MENU += "[2] - Exibir Conta\n";
    MENU += "[3] - Deposito\n";
    MENU += "[4] - Saque\n";
    MENU += "[5] - Saldo\n";*/
    MENU += "Opção: ";
    return MENU;
  }

  public static String [] CRIAR_CONTA()
  {

      String [] values = new String[5];
      String tmp = null;
      boolean check = true;

      //System.out.print("Boa escolha! xD\n");
      System.out.print("Insira as seguintes informacoes:\n");
      System.out.print("Nome: ");
      values[0] = Views.SC.next();

      /*System.out.print("CPF: ");
      values[1] = Views.SC.next();

      System.out.print("Telefone: ");
      values[2] = Views.SC.next();

      System.out.print("Email: ");
      values[3] = Views.SC.next();*/

      /* AQUI VERIFICAMOS A CONFIRMACAO DE SENHA DO USUARIO.
        SE ESSE USUARIO ERRAR A CONFIRMACAO DE SENHA, VOLTAMOS A SOLICITAR A SENHA*/
      while(check)
      {
        System.out.print("Senha: ");
        values[1] = Views.SC.next();

        System.out.print("Por favor, confirme a senha: ");
        tmp = Views.SC.next();

        if(!values[1].equals(tmp)){
          System.out.print("As senhas nao sao iguais! Digite novamente!");
        }else{
          check = false;
        }
      }
      return values;
  }

  public static void BYE()
  {
    System.out.print("Obrigado por usar o SEU Banco. Ate logo!\n");
  }
}
