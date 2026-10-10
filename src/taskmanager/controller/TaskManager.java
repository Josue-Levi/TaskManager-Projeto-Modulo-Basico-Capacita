package taskmanager.controller;

import java.util.ArrayList;
import java.util.List;
import taskmanager.exceptions.TarefaNaoEncontradaException;
import taskmanager.model.Tarefa;

public class TaskManager<T extends Tarefa> implements InterfaceGerenciadorTarefas<T> {

    private List<T> tarefas;

    public TaskManager(){
        this.tarefas = new ArrayList<>();
    }

    @Override
    public void adicionarTarefa(T tarefa){
        tarefas.add(tarefa);
    }

    @Override
    public void listarTarefa(){
        if(tarefas.isEmpty()){
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for(T tarefa : tarefas){
                System.out.println(tarefa);
            }
        }
    }

    @Override
    public void removerTarefa(int id){
        boolean encontrou = tarefas.removeIf(t -> t.getId() == id);
        if(!encontrou){
            throw new TarefaNaoEncontradaException("Tarefa com ID:"+ id +" não foi encontrada.");
        }
    }

    @Override
    public void concluirTarefa(int id){
        boolean encontrou = false;
        for (T tarefa : tarefas){
            if(tarefa.getId() == id){
                tarefa.setStatus(true);
                encontrou = true;
                break;
            }
        }
        if(!encontrou){
            throw new TarefaNaoEncontradaException("Tarefa com ID:"+ id +" não foi encontrada.");
        }
    }

    @Override
    public boolean existeID(int id){
        return tarefas.stream().anyMatch(t -> t.getId() == id);
    }
}