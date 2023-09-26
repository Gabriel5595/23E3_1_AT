package Recursos;
import java.util.List;
import Excecoes.NaoNuloException;
import Excecoes.NaoVazioException;
import Excecoes.NaoNegativoException;

public class Imovel {
    //Atributos
    //nome e registro são encapsulados. Sendo assim Getters e Setters são criados e estes atributos são definidos como private. (Questão3)
    private String registro;
    private String nome;
    public Endereco endereco;
    public TipoImovelEnum tipo;
    public float valorAluguel;
    public List<ContratoAluguel> listaContratos;

    //Getters e Setters
    //Validações de exceções são adicionadas a nome, telefone e email. (Questão3)
    public String getRegistro() {
        return registro;
    }
    public void setRegistro(String registro) throws NaoNuloException, NaoVazioException {
        if (registro == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (registro == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.registro = registro;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws NaoNuloException, NaoVazioException {
        if (registro == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (registro == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.nome = nome;
    }

    //Construtor
    //Como endereco e valorAluguel não estão encapsulados, as validações de exceções são adicionadas diretamente no construtor. (Questão3)
    public Imovel(String registro, String nome, Endereco endereco, String tipo, float valorAluguel, List<ContratoAluguel> listaContratos) throws NaoNuloException, NaoVazioException, NaoNegativoException {
        if (endereco == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (valorAluguel < 0) {
            throw new NaoNegativoException("O valor inserido não pode ser negativo. Por favor, insira outro valor.");
        }
        setRegistro(registro);
        setNome(nome);
        this.endereco = endereco;
        this.tipo = TipoImovelEnum.valueOf(tipo);
        this.valorAluguel = valorAluguel;
        this.listaContratos = listaContratos;
    }
    
    @Override
    public String toString() {
        return "Imovel [registro=" + registro + ", nome=" + nome + ", endereco=" + endereco + ", tipo=" + tipo
                + ", valorAluguel=" + valorAluguel + ", listaContratos=" + listaContratos + "]";
    }
}
