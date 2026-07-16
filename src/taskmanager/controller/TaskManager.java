package taskmanager.controller;

import java.util.ArrayList;

import taskmanager.exceptions.TarefaNaoEncontradaException;
import taskmanager.model.Tarefa;

public class TaskManager implements InterfaceGerenciadorTarefas {

    private ArrayList<Tarefa> tarefas;

    public TaskManager(){
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public void listarTarefa(){
        if(tarefas.isEmpty()){
            System.out.println("Nenhuma tarefa cadastrada.");
        }else {
            for(Tarefa tarefa : tarefas){
                System.out.println(tarefa);
            }
        }
    }

    public void removerTarefa(int id){
        boolean encontrou = false;
        for (int i = 0; i<tarefas.size(); i++){
            if(tarefas.get(i).getId() == id){
                tarefas.remove(i);
                encontrou = true;
                break;
            }
        }
        if(!encontrou){
            throw new TarefaNaoEncontradaException("Tarefa com ID:"+ id +" não foi encontrada.");
        }
    }

    public void concluirTarefa(int id){
        boolean encontrou = false;
        for (int i = 0; i<tarefas.size(); i++){
            if(tarefas.get(i).getId() == id){
                tarefas.get(i).setStatus(true);
                encontrou = true;
                break;
            }
        }
        if(!encontrou){
            throw new TarefaNaoEncontradaException("Tarefa com ID:"+ id +" não foi encontrada.");
        }

    }

    public boolean existeID (int id){
        for (int i = 0; i<tarefas.size(); i++){
            if(tarefas.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
}
