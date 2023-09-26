package Excecoes;

//Mensagem padrão:
//"O campo não pode estar vazio. Por favor, insira um valor."
public class NaoVazioException extends Exception {
    public NaoVazioException(String mensagem){
        super(mensagem);
    }
}
