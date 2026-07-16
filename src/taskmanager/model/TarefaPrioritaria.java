package taskmanager.model;

public class TarefaPrioritaria extends Tarefa {

    private int nivelPrioridade;

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }
    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public TarefaPrioritaria(int id, String titulo, String descricao, int nivelPrioridade) {
        super(id, titulo, descricao);
        this.nivelPrioridade = nivelPrioridade;
    }

    @Override
    public String toString() {
        String textoPrioridade = switch (this.nivelPrioridade) {
            case 3 -> "Alta";
            case 2 -> "Média";
            case 1 -> "Baixa";
            default -> "Indefinida";
        };
        return super.toString() +
                "\nPrioridade: " + textoPrioridade;
    }
}
