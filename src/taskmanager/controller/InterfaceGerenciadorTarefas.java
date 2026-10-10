package taskmanager.controller;

import taskmanager.model.Tarefa;

public interface InterfaceGerenciadorTarefas<T> {
    void adicionarTarefa(T tarefa);
    void listarTarefa();
    void removerTarefa(int id);
    void concluirTarefa(int id);
    boolean existeID(int id);
}
