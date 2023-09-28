import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Recursos.Cliente;
import Recursos.ContratoAluguel;
import Recursos.Imovel;
import Recursos.Fisica;
import Recursos.Juridica;
import Recursos.Endereco;

public class App {
    public static void main(String[] args) throws Exception {
        //Listas foram criadas para as classes Imovel, Cliente e ContratoAluguel. (Questão13)
        List<Imovel> listaImoveis = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        List<ContratoAluguel> listaContratosCompleta = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Sair");
            System.out.println("2. Adicionar Cliente");
            System.out.println("3. Adicionar Imóvel");
            System.out.println("4. Adicionar Contrato de Aluguel");
            System.out.println("5. Buscar Cliente e Contratos");
            System.out.println("6. Buscar Imóvel e Contratos Vigentes");
            System.out.println("7. Exportar Contratos em CSV");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();
            
            switch (escolha) {
                //Opção para encerrar o programa. (Questão14)
                case 1:
                    System.out.println("\nEncerrando o programa.");
                    return;
                
                //Opção para adicionar cliente (Questão15)
                case 2:
                    System.out.println("\nO cliente é Pessoa Física ou Pessoa Jurídica?");
                    System.out.println("1. Pessoa Física.");
                    System.out.println("2. Pessoa Jurídica.");
                    int FisOuJuri = scanner.nextInt();
                    scanner.nextLine();

                    //Seleciona se o cliente é Pessoa Física ou Jurídica e cria a classe de acordo. (Questão15)
                    if(FisOuJuri == 1) {
                        System.out.println("Digite o nome do cliente COMPLETO: ");
                        String nomeFis = scanner.nextLine();
                        System.out.println("Digite o telefone do cliente: ");
                        String telefoneFis = scanner.next();
                        System.out.println("Digite o e-mail do cliente: ");
                        String emailFis = scanner.next();
                        System.out.println("Digite o CPF do cliente (Utilize o formato 00000000000, sem pontos ou traços): ");
                        String cpf = scanner.next();
                        Cliente clienteFisico = new Fisica(nomeFis, telefoneFis, emailFis, cpf);
                        listaClientes.add(clienteFisico);
                        System.out.println("\nCliente adicionado com sucesso!");
                        break;
                    } else if (FisOuJuri == 2) {
                        System.out.println("Digite o nome do cliente COMPLETO: ");
                        String nomeJuri = scanner.nextLine();
                        System.out.println("Digite o telefone do cliente: ");
                        String telefoneJuri = scanner.next();
                        System.out.println("Digite o e-mail do cliente");
                        String emailJuri = scanner.next();
                        System.out.println("Digite o CNPJ (Utilize o formato 00000000000000, sem pontos ou traços): ");
                        String cnpj = scanner.next();
                        Cliente clienteJuridico = new Juridica(nomeJuri, telefoneJuri, emailJuri, cnpj);
                        listaClientes.add(clienteJuridico);
                        System.out.println("\nCliente adicionado com sucesso!");
                        break;
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                    }

                //Opção para adicionar imóvel.(Questão16)
                case 3:
                    System.out.println("\nDigite o registro do imóvel: ");
                    String registro = scanner.nextLine();
                    System.out.println("Digite o nome do imóvel: ");
                    String nome = scanner.nextLine();
                    
                    System.out.println("Digite o logradouro do endereço: ");
                    String logradouro = scanner.nextLine();
                    System.out.println("Digite o tipo do logradouro do endereço: ");
                    String tipoLogradouro = scanner.next();
                    System.out.println("Digite o número do endereço: ");
                    String numero = scanner.next();
                    System.out.println("Digite o complemento do endereço (Caso não tenha, escreva 'Sem complemento'): ");
                    String complemento = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Digite a cidade do endereço: ");
                    String cidade = scanner.nextLine();
                    System.out.println("Digite o Estado do endereço (UF): ");
                    String estado = scanner.next();
                    System.out.println("Digite o CEP do endereço: ");
                    String cep = scanner.next();
                    
                    System.out.println("O imóvel é COMERCIAL ou RESIDENCIAL?");
                    String tipo = scanner.next();
                    System.out.println("Digite o valor do aluguel");
                    float valorAluguel = scanner.nextFloat();
                    
                    Endereco endereco = new Endereco(logradouro, tipoLogradouro, numero, complemento, cidade, estado, cep);
                    Imovel imovelNovo = new Imovel(registro, nome, endereco, tipo, valorAluguel);
                    
                    listaImoveis.add(imovelNovo);

                    System.out.println("\nImóvel adicionado com sucesso!");
                        
                    break;
                
                //Opção para adicionar um contrato de aluguel. (Questão17)
                case 4:
                    System.out.println("\nÉ necessário que já haja um imóvel e cliente cadastrados para que o contrato seja criado.");
                    
                    //Pesquisa cliente na lista
                    System.out.println("Digite o CPF ou CNPJ do cliente já cadastrado: ");
                    String clienteInformado = scanner.next();

                    Cliente clienteSelecionado = null;
                    for(Cliente cliente : listaClientes) {
                        if (((cliente instanceof Fisica && ((Fisica) cliente).getCpf().equals(clienteInformado)) || (cliente instanceof Juridica && ((Juridica) cliente).getCnpj().equals(clienteInformado)))) {
                            clienteSelecionado = cliente;
                            System.out.println("O cliente com ID " + clienteInformado + " foi encontrado.");
                        }
                    }
                    if (clienteSelecionado == null) {
                        System.out.println("\nO cliente com ID " + clienteInformado + " não foi encontrado.");
                        break;
                    }

                    //Pesquisa imovel na lista
                    System.out.println("Digite o registro do imóvel já cadastrado: ");
                    String imovelInformado = scanner.next();

                    Imovel imovelSelecionado = null;
                    for (Imovel imovel : listaImoveis) {
                        if (imovel.getRegistro().equals(imovelInformado)) {
                            imovelSelecionado = imovel;
                        }
                    }
                    if (imovelSelecionado ==null) {
                        System.out.println("\nO imóvel com registro " + imovelInformado + " não foi encontrado.");
                        break;
                    }

                    System.out.println("Digite a data de início do contrato (formato DD/MM/YYYY): ");
                    String dataInicioStr = scanner.next();
                    
                    System.out.println("Digite a data de fim do contrato (formato DD/MM/YYYY): ");
                    String dataTerminoStr = scanner.next();
                    
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatador);
                    LocalDate dataTermino = LocalDate.parse(dataTerminoStr, formatador);
                    
                    ContratoAluguel contratoAluguel = new ContratoAluguel(imovelSelecionado, clienteSelecionado, dataInicio, dataTermino);
                    listaContratosCompleta.add(contratoAluguel);
                    clienteSelecionado.getListaContratos().add(contratoAluguel);
                    imovelSelecionado.getListaContratos().add(contratoAluguel);
                    System.out.println("\nContrato adicionado com sucesso!");
                    break;

                //Apresentar contratos de um cliente. (Questão18)
                case 5:
                    System.out.println("\nDigite o CPF ou CNPJ do cliente: ");
                    String cpfOuCnpj = scanner.next();
                    System.out.println("Contratos para CPF/CNPJ " + cpfOuCnpj + ":");

                    float valorTotal = 0;

                    for (Cliente cliente : listaClientes) {
                        if ((cliente instanceof Fisica && ((Fisica) cliente).getCpf().equals(cpfOuCnpj))) {
                            valorTotal = cliente.calcularValorTotalContratos();
                        } else if ((cliente instanceof Juridica && ((Juridica) cliente).getCnpj().equals(cpfOuCnpj))) {
                            valorTotal = cliente.calcularValorTotalContratos();
                        }
                    }

                    for (ContratoAluguel contrato : listaContratosCompleta) {
                        Cliente cliente = contrato.cliente;
                        if((cliente instanceof Fisica && ((Fisica) cliente).getCpf().equals(cpfOuCnpj)) ||
                        (cliente instanceof Juridica && ((Juridica) cliente).getCnpj().equals(cpfOuCnpj))) {
                            System.out.print(contrato.imovel.getRegistro() + ", " + contrato.imovel.getNome() + ", " + contrato.dataInicio + ", " + contrato.dataTermino + ", " + valorTotal + "\n");
                        }
                    }
                    break;
                
                //Apresentar contratos de imovel. (Questão19)
                case 6:
                    System.out.println("\nDigite o registro do imóvel: ");
                    String registroPesquisado2 = scanner.next();

                    System.out.println("Contratos registro do imóvel " + registroPesquisado2 + ":");
                    for(ContratoAluguel contrato : listaContratosCompleta) {
                        if(contrato.imovel.getRegistro().equals(registroPesquisado2) && !contrato.contratoVencido()) {
                            System.out.println(contrato.toString());
                        }
                    }
                    break;
                
                //Exportar arquivo
                case 7:
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("contratos.csv"))) {
                        for (ContratoAluguel contrato : listaContratosCompleta) {
                            writer.write(contrato.toString());
                            writer.newLine();
                        }
                        System.out.println("\nContratos exportados para o arquivo contratos.csv.");
                    } catch (IOException e) {
                        System.err.println("\nErro ao exportar contratos para CSV: " + e.getMessage());
                    }
                    break;
                
                case 8:
                    System.out.println(listaContratosCompleta.toString());
                    break;
                
                case 9:
                    System.out.println(listaClientes.toString());
                    break;
                
                case 10:
                    System.out.println(listaImoveis.toString());
                    break;
            }

            scanner.close();
        }
    }
}
