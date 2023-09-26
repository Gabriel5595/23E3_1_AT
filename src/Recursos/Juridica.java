package Recursos;
import java.util.List;
import Excecoes.NaoNuloException;
import Excecoes.NaoVazioException;

public class Juridica extends Cliente{
    //Atributos
    //cpf é encapsulado. Sendo assim Getters e Setters são criados e estes atributos são definidos como private. (Questão6)
    private String cnpj;

    //Getters e Setters
    //Validações de exceções são adicionadas a cpf. (Questão6)
    public String getCnpj() {
        return cnpj;
    }
    public void setCpf(String cnpj) throws NaoNuloException, NaoVazioException {
        if(cnpj ==null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (cnpj == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.cnpj = cnpj;
    }

    //Construtor
    //Construtor apresentando também atributos herdados da classe Cliente (Questão6)
    public Juridica(String nome, String telefone, String email, List<ContratoAluguel> listaContratos, String cnpj) throws NaoNuloException, NaoVazioException {
        super(nome, telefone, email, listaContratos);
        setCpf(cnpj);
    }

    @Override
    public float calcularValorTotalContratos(String cnpjSelecionado, List<Cliente> listaClientes, List<ContratoAluguel> listaContratos) {
        float valorTotal = 0;
        int contratosTotais = 0;

        for(ContratoAluguel contrato : listaContratos) {
            
            if (((Fisica) contrato.cliente).getCpf().equals(cnpjSelecionado)) {
                valorTotal += contrato.imovel.valorAluguel;
                contratosTotais ++;
            } else {
                System.out.println("Nenhum contrato encontrado para o CNPJ " + cnpjSelecionado);
            }
            
        }

        
        if (contratosTotais >= 5) {
            return valorTotal * 0.9f;
        } else if (contratosTotais >= 3 && contratosTotais < 5) {
            return valorTotal * 0.95f;
        } else {
            return valorTotal;
        }
    }
}
