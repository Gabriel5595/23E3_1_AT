package Recursos;
import java.util.ArrayList;
import java.util.List;
import Excecoes.NaoNuloException;
import Excecoes.NaoVazioException;

abstract public class Cliente implements Contabil {
    //Atributos
    //nome, telefone e email são encapsulados. Sendo assim Getters e Setters são criados e estes atributos são definidos como private. (Questão4)
    //List não é encapsulado d é definido como public. (Questão4)
    private String nome;
    private String telefone;
    private String email;
    protected List<ContratoAluguel> listaContratos;

    //Getters e Setters
    //Validações de exceções são adicionadas a nome, telefone e email. (Questão4)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws NaoNuloException, NaoVazioException {
        if(nome ==null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (nome == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.nome = nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) throws NaoNuloException, NaoVazioException {
        if(telefone ==null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (telefone == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws NaoNuloException, NaoVazioException {
        if(email ==null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        } else if (email == "") {
            throw new NaoVazioException("O campo não pode estar vazio. Por favor, insira um valor.");
        }
        this.email = email;
    }

    public List<ContratoAluguel> getListaContratos() {
        return listaContratos;
    }
    public void setListaContratos(List<ContratoAluguel> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public Cliente(String nome, String telefone, String email) throws NaoNuloException, NaoVazioException {
        setEmail(email);
        setNome(nome);
        setTelefone(telefone);
        listaContratos = new ArrayList<>();
    }

    public float calcularValorTotalContratos() {
        float valorTotal = 0;
        int contratosTotais = 0;

        for(ContratoAluguel contrato : listaContratos) {
            if (!contrato.contratoVencido()){
                valorTotal += contrato.calcularValorContrato();
                contratosTotais ++;
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
    
    @Override
    public String toString() {
        return "\nCliente [nome=" + nome + 
                ", telefone=" + telefone + 
                ", email=" + email + 
                ", listaContratos=" + listaContratos + "]";
    }

    
}
