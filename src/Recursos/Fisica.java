package Recursos;

import Excecoes.NaoNuloException;
import Excecoes.NaoVazioException;

public class Fisica extends Cliente{
    //Atributos
    //cpf é encapsulado. Sendo assim Getters e Setters são criados e estes atributos são definidos como private. (Questão6)
    private String cpf;

    //Getters e Setters
    //Validações de exceções são adicionadas a cpf. (Questão6)
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) throws NaoNuloException, NaoVazioException {
        if(cpf ==null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (cpf == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.cpf = cpf;
    }

    //Construtor
    //Construtor apresentando também atributos herdados da classe Cliente (Questão6)
    public Fisica(String nome, String telefone, String email, String cpf) throws NaoNuloException, NaoVazioException {
        super(nome, telefone, email);
        setCpf(cpf);
    }
}
