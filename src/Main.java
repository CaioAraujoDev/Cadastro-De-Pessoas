import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomep;
        int idadep, cpfp, decidir, opcao;

        Scanner entUsua = new Scanner(System.in);
        List<Pessoas> cpessoa = new ArrayList<>();

        System.out.println("\nCadastro de Pessoas\n");
        System.out.println("Para criar seu cadastro insira as informações abaixo: ");

        System.out.println("\nNoma da pessoa: ");
        nomep = Verificacao.lerString(entUsua);
        System.out.println("Idade da pessoa: ");
        idadep = Verificacao.lerInt(entUsua);
        cpfp = idadep * 734;
        Pessoas p = new Pessoas(nomep, idadep, cpfp);
        cpessoa.add(p);

        while (true) {
            System.out.println("\nO que você deseja fazer agora? \n 1 - Adicionar uma nova Pessoa \n 2 - Alterar uma Pessoa \n 3 - Mostrar informações de todas as Pessoas \n 4 - Sair");
            decidir = entUsua.nextInt();
            switch (decidir){
                case 1:
                    System.out.println("Noma da pessoa: ");
                    entUsua.nextLine();
                    nomep = Verificacao.lerString(entUsua);
                    System.out.println("Idade da pessoa: ");
                    idadep = Verificacao.lerInt(entUsua);
                    cpfp = idadep * 734;
                    Pessoas p2 = new Pessoas(nomep, idadep, cpfp);
                    cpessoa.add(p2);
                    break;
                case 2:
                    System.out.println("Para alterar um valor por favor insira o CPF da pessoa\nCaso não tenha, digite 0 e escolha a 3º opção para mostrar as informações das pessoas");
                    decidir = entUsua.nextInt();
                    if (decidir == 0){break;}
                    boolean encontrado = false;
                    boolean alterar = true;
                    for(Pessoas cp : cpessoa){
                        if(cp.getCpf() == decidir){
                            while (alterar) {
                                System.out.println("O que deseja alterar: \n 1 - Nome \n 2 - Idade");
                                decidir = entUsua.nextInt();
                                switch (decidir){
                                    case 1:
                                        System.out.println("Digite o novo nome:");
                                        entUsua.nextLine();
                                        nomep = Verificacao.lerString(entUsua);
                                        cp.setNome(nomep);
                                        alterar = false;
                                        encontrado = true;
                                        break;
                                    case 2:
                                        System.out.println("Digite a nova idade:");
                                        entUsua.nextLine();
                                        idadep = Verificacao.lerInt(entUsua);
                                        cp.setIdade(idadep);
                                        alterar = false;
                                        encontrado = true;
                                        break;
                                    default:
                                        System.out.println("Numero invalido, tente novamente");
                                        break;
                                }
                            }
                        }
                    }
                    if(!encontrado){
                        System.out.println("CPF não encontrado, tente novamente");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Pessoas cadastradas:");
                    for(int i = 0; i < cpessoa.size(); i++){
                        Pessoas p3 = cpessoa.get(i);

                        System.out.println("\n" + (i + 1) +"º Pessoa:");
                        System.out.println("Nome: " + p3.getNome());
                        System.out.println("Idade: " + p3.getIdade());
                        System.out.println("CPF: " + p3.getCpf());
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opção invalida, tente novamente");
                    break;

            }
        }
    }
}