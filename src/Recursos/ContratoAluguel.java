package Recursos;

import java.time.LocalDate;
import java.time.Period;

import Excecoes.DataInvalidaException;
import Excecoes.NaoNuloException;


public class ContratoAluguel {
    //Atributos
    //Atributos criados. (Questão7)
    public Imovel imovel;
    public Cliente cliente;
    public LocalDate dataInicio;
    public LocalDate dataTermino;

    // DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // String dataInicioStr = dataInicio.format(formatador);
    // String dataTerminoStr = dataTermino.format(formatador);
    

    //Construtos
    //Nenhum Get ou Set foi criado. (Questão7)
    //Todas as validações foram inseridas diretamente no construtor. (Questão7)
    public ContratoAluguel(Imovel imovel, Cliente cliente, LocalDate dataInicio, LocalDate dataTermino) throws NaoNuloException, DataInvalidaException {
        if (imovel == null || cliente == null || dataInicio == null || dataTermino == null) {
            throw new NaoNuloException("O valor inserido não pode ser nulo. Por favor, insira outro valor.");
        }
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.imovel = imovel;
        this.cliente = cliente;
    }

    //Metodos
    //Metodos calcularValorContrato() e contratoVencido() criados. (Questão8)
    public float calcularValorContrato() {
        Period periodo = Period.between(dataInicio, dataTermino);
        return imovel.getValorAluguel() * periodo.toTotalMonths();
    }

    public boolean contratoVencido() {
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.isAfter(dataTermino);
    }

    @Override
    public String toString() {
        return imovel.getRegistro() + ", " + 
        imovel.getNome() + ", " + 
        imovel.getEndereco().getLogradouro() + ", " + 
        imovel.getEndereco().getTipoLogradouro() + ", " + 
        imovel.getEndereco().getNumero() + ", " + 
        imovel.getEndereco().getComplemento() + ", " + 
        imovel.getEndereco().getCidade() + ", " +
        imovel.getEndereco().getEstado() + ", " +
        imovel.getEndereco().getCep() + ", " +  
        imovel.getValorAluguel() + ", " + 
        cliente.getNome() + ", " + 
        cliente.getTelefone() + ", " + 
        dataInicio + ", " + 
        dataTermino + ", " + 
        (contratoVencido() ? "Sim" : "Não");
        
        // String formatoCSV = String.format(
        //     "%d,%s,%s,%.2f,%s,%s,%s,%s,%s",
        //     imovel.getRegistro(),
        //     imovel.getNome(),
        //     imovel.endereco,
        //     imovel.valorAluguel,
        //     cliente.getNome(),
        //     cliente.getTelefone(),
        //     dataInicioStr,
        //     dataTerminoStr,
        //     contratoVencido() ? "Sim" : "Não"
        // );

        // return formatoCSV;
    }
}
