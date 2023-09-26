package Recursos;
import Excecoes.NaoNuloException;
import Excecoes.NaoVazioException;

public class Endereco {
    //Atributos
    //Todos os atributos são emcapsulados. Sendo assim Getters e Setters são criados e estes atributos são definidos como private. (Questão2)
    private String logradouro;
    private String tipoLogradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    
    //Getters e Setters
    //Validações de exceções são adicionadas a todos os atributos. (Questão2)
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) throws NaoNuloException, NaoVazioException {
        if (logradouro == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (logradouro == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.logradouro = logradouro;
    }
    
    public String getTipoLogradouro() {
        return tipoLogradouro;
    }
    public void setTipoLogradouro(String tipoLogradouro) throws NaoNuloException, NaoVazioException {
        if (tipoLogradouro == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (tipoLogradouro == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.tipoLogradouro = tipoLogradouro;
    }
    
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) throws NaoNuloException, NaoVazioException {
        if (numero == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (numero == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.numero = numero;
    }
    
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) throws NaoNuloException, NaoVazioException {
        if (complemento == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (complemento == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.complemento = complemento;
    }
    
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) throws NaoNuloException, NaoVazioException {
        if (cidade == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (cidade == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) throws NaoNuloException, NaoVazioException {
        if (estado == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (estado == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.estado = estado;
    }
    
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) throws NaoNuloException, NaoVazioException {
        if (cep == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (cep == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.cep = cep;
    }

    public Endereco(String logradouro, String tipoLogradouro, String numero, String complemento, String cidade,
            String estado, String cep) throws NaoNuloException, NaoVazioException {
        setLogradouro(logradouro);;
        setTipoLogradouro(tipoLogradouro);
        setNumero(numero);
        setComplemento(complemento);
        setCidade(cidade);
        setEstado(estado);
        setCep(cep);
    }
    
    @Override
    public String toString() {
        return "Logradouro: " + logradouro + "\nTipo: " + tipoLogradouro + "\nNúmero: " + numero
                + "\nComplemento: " + complemento + "\nCidade: " + cidade + "\nEstado: " + estado + "\nCEP: " + cep;
    }
}
