package taskmanager.app;

import java.util.Scanner;
import java.util.InputMismatchException;
import taskmanager.controller.TaskManager;
import taskmanager.exceptions.TarefaNaoEncontradaException;
import taskmanager.model.Tarefa;
import taskmanager.model.TarefaPrioritaria;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        int opcao = 0;
        int id;
        boolean existeID;

        do {
            try{System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
                System.out.println("[1] - Criar nova tarefa");
                System.out.println("[2] - Listar tarefas");
                System.out.println("[3] - Marcar tarefa como concluída");
                System.out.println("[4] - Remover tarefa");
                System.out.println("[5] - Sair");
                System.out.print("Escolha uma opcao: ");
                opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("\nCriando uma nova tarefa...");

                        //tipo de tarefa
                        int tipoTarefa;
                        do {
                            System.out.println("[1] - Tarefa Normal \n[2] - Tarefa com Prioridade");
                            tipoTarefa = input.nextInt();

                            if(tipoTarefa != 1 && tipoTarefa != 2) {
                                System.out.println("Erro: Informe um tipo de tarefa válido");
                            }
                        } while (tipoTarefa != 1 && tipoTarefa != 2);

                        //Id da tarefa
                        do {
                            System.out.print("Informe o ID da tarefa: ");
                            id = input.nextInt();

                            existeID = taskManager.existeID(id);

                            if(id <= 0){
                                System.out.println("Erro: Informe um ID válido.");
                            } else if (existeID){
                                System.out.println("Erro: Existe uma tarefa cadastrada com este ID:"+ id +". Escolha outro.");
                            }
                        }while (id <= 0 || existeID);

                        input.nextLine();

                        //titulo da tarefa
                        String titulo;
                        do{
                            System.out.print("Informe o titulo da tarefa: ");
                            titulo = input.nextLine();

                            if(titulo.trim().isEmpty()){
                                System.out.println("Erro: Titulo é obrigatorio.");
                            }
                        }while(titulo.trim().isEmpty());

                        //descrição da tarefa
                        System.out.print("Informe a descriçao da tarefa: ");
                        String descricao = input.nextLine();

                        //verifição do tipo da tarefa
                        if (tipoTarefa == 1) {

                            //Instanciação da tarefa normal.
                            Tarefa tarefa = new Tarefa(id, titulo, descricao);
                            taskManager.adicionarTarefa(tarefa);
                        } else if (tipoTarefa == 2) {
                            int nivelPrioridade;
                            do{
                                System.out.print("Informe o nivel de Prioridade da tarefa: ");
                                System.out.println("\n[3] - Alta \n[2] - Media \n[1] - Baixa");
                                nivelPrioridade = input.nextInt();
                                if(nivelPrioridade < 1 || nivelPrioridade > 3){
                                    System.out.println("Erro: Escolha uma opção valida.");
                                }
                            } while (nivelPrioridade < 1 || nivelPrioridade > 3);

                            //Instanciação da tarefa com nivel de prioridade.
                            Tarefa tarefa = new TarefaPrioritaria(id, titulo, descricao, nivelPrioridade);
                            taskManager.adicionarTarefa(tarefa);
                        }
                        break;
                    case 2:
                        taskManager.listarTarefa();
                        break;
                    case 3:
                        do {
                            System.out.println("Qual o ID da tarefa que deseja concluir?");
                            id = input.nextInt();
                            if (id <= 0) {
                                System.out.println("Erro: Informe um ID válido. ");
                            }
                        } while (id <= 0);
                        taskManager.concluirTarefa(id);
                        break;
                    case 4:
                        do {
                            System.out.println("Qual o ID da tarefa que deseja remover?");
                            id = input.nextInt();
                            if (id <= 0) {
                                System.out.println("Erro: Informe um ID válido.");
                            }
                        } while (id <= 0);
                        taskManager.removerTarefa(id);
                        break;
                    case 5:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção Invalida, tente novamente!");
                }
            } catch (InputMismatchException e){
                System.out.println("Erro: digite apenas números válidos.");
                input.nextLine();
            } catch (TarefaNaoEncontradaException e) {
                System.out.println(e.getMessage());
            }
        } while (opcao != 5);
    }
}
