package Testes;
import Recursos.Endereco;
import Excecoes.NaoNuloException;
import Excecoes.NaoVazioException;

public class EnderecoTeste {
    public static void main(String[] args) throws Exception {
        try {
            Endereco endereco = new Endereco("Luiz Beltrão", "Rua", "520", "Sem Complemento", "Rio de Janeiro", "RJ", "21321-230");

            System.out.println(endereco);
        } catch (NaoNuloException ex) {
            System.out.println(ex.getMessage());
        } catch (NaoVazioException ex) {
            System.out.println(ex.getMessage());
        }
    }
}