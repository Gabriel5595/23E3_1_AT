package Excecoes;

//Mensagem padrão:
//"O formato para data está inválido. Por favor, insira datas no formado DD/MM/YYYY."
public class DataInvalidaException extends Exception {
    public DataInvalidaException(String mensagem){
        super(mensagem);
    }
}