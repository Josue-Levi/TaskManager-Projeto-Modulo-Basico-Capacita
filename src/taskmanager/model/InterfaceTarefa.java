package taskmanager.model;

public interface InterfaceTarefa {

    int getId();
    void setId(int id);

    String getTitulo();
    void setTitulo(String titulo);

    String getDescricao();
    void setDescricao(String descricao);

    String toString();

}
