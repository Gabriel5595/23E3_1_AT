package Recursos;

import java.util.List;

public interface Contabil {
    public float calcularValorTotalContratos(String IDselecionado, List<Cliente> listaClientes, List<ContratoAluguel> listaContratos);
}
