package Recursos;

//Criação e TipoImovelEnum do tipo enum(Questão1)
enum TipoImovelEnum {
    COMERCIAL("Comercial"),
    RESIDENCIAL("Residêncial");

    private final String descricao;

    TipoImovelEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String toString() {
        return getDescricao();
    }
}

