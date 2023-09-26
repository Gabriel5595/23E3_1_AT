package Testes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Recursos.Cliente;
import Recursos.ContratoAluguel;
import Recursos.Imovel;
import Recursos.Fisica;
import Recursos.Juridica;
import Recursos.Endereco;

public class ContratoAluguelTeste {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<Imovel> listaImoveis = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        List<ContratoAluguel> listaContratos = new ArrayList<>();
        
        Cliente cliente1 = new Fisica("Gabriel", "971313618", "gribeirocarvalho@hotmail.com", null, "01339471140");
        listaClientes.add(cliente1);
        Cliente cliente2 = new Juridica("Bar do Zé", "38336112", "BarDoZe@hotmail.com", null, "012345678987654");
        listaClientes.add(cliente2);


        Endereco endereco = new Endereco("Luiz Beltrão", "Rua", "520", "Sem Complemento", "Rio de Janeiro", "RJ", "21321-230");

        Imovel imovel1 = new Imovel("001", "Casa Branca", endereco, "RESIDENCIAL", 1000, listaContratos);
        listaImoveis.add(imovel1);
        Imovel imovel2 = new Imovel("002", "Casa Branca", endereco, "RESIDENCIAL", 1000, listaContratos);
        listaImoveis.add(imovel2);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse("09/10/2023", formatador);
        LocalDate dataTermino = LocalDate.parse("09/10/2024", formatador);

        ContratoAluguel contratoAluguel1 = new ContratoAluguel(imovel1, cliente1, dataInicio, dataTermino);
        listaContratos.add(contratoAluguel1);
        ContratoAluguel contratoAluguel2 = new ContratoAluguel(imovel2, cliente1, dataInicio, dataTermino);
        listaContratos.add(contratoAluguel2);

        float valorTotal = cliente1.calcularValorTotalContratos("01339471140", listaClientes, listaContratos);

        System.out.println(valorTotal);

        scanner.close();
    }

}
