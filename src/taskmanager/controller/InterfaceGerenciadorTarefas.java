package taskmanager.controller;

import taskmanager.model.Tarefa;

public interface InterfaceGerenciadorTarefas {
    void adicionarTarefa(Tarefa tarefa);
    void listarTarefa();
    void removerTarefa(int id);
    void concluirTarefa(int id);
    boolean existeID(int id);
}
