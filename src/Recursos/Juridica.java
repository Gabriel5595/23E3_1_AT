package Recursos;

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
    public Juridica(String nome, String telefone, String email, String cnpj) throws NaoNuloException, NaoVazioException {
        super(nome, telefone, email);
        setCpf(cnpj);
    }
}
