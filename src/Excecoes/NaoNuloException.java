package Excecoes;

//Mensagem padrão:
//"O valor inserido não pode ser nulo. Por favor, insira outro valor."
public class NaoNuloException extends Exception {
    public NaoNuloException(String mensagem){
        super(mensagem);
    }
}
