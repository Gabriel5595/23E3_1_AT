package Excecoes;

//Mensagem padrão:
//"O valor inserido não pode ser negativo. Por favor, insira outro valor."
public class NaoNegativoException extends Exception {
    public NaoNegativoException(String mensagem){
        super(mensagem);
    }
}
