import java.util.Scanner;

public class Verificacao {
    public static String lerString(Scanner entUsua){
        String validar = entUsua.nextLine();
        while(validar == null){
            System.out.println("Nome nulo invalido, tente novamente");
            System.out.println("Noma da pessoa: ");
            validar = entUsua.nextLine();
        }
        return validar;
    }
    public static int lerInt(Scanner entUsua){
        int valid = entUsua.nextInt();
        while(valid < 0){
            System.out.println("Idade negativa invalida, tente novamente");
            System.out.println("Idade da pessoa: ");
            valid = entUsua.nextInt();
        }

        return valid;
    }
}
