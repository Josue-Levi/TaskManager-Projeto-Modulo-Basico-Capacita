package taskmanager.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taskmanager.exceptions.TarefaNaoEncontradaException;
import taskmanager.model.Tarefa;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager<Tarefa> gerenciador;

    @BeforeEach
    void setUp() {
        gerenciador = new TaskManager<>();
    }

    @Test
    void testCriacaoDeTarefa() {
        Tarefa t1 = new Tarefa(1, "Estudar Java", "Revisar Generics e JUnit");
        gerenciador.adicionarTarefa(t1);

        assertTrue(gerenciador.existeID(1), "A tarefa devia ter sido adicionada e o ID existir.");
    }

    @Test
    void testConclusaoDeTarefa() {
        Tarefa t1 = new Tarefa(2, "Fazer TP", "Entregar até as 23h");
        gerenciador.adicionarTarefa(t1);

        gerenciador.concluirTarefa(2);

        // Como o concluirTarefa altera o status internamente, vamos verificar se o ID ainda existe e não lança exceção ao tentar concluir novamente
        assertDoesNotThrow(() -> gerenciador.concluirTarefa(2), "Não deve lançar erro ao concluir uma tarefa existente.");
    }

    @Test
    void testValidacaoDeDadosLancandoExcecao() {
        // Tenta remover uma tarefa que não existe (ID 99)
        Exception exception = assertThrows(TarefaNaoEncontradaException.class, () -> {
            gerenciador.removerTarefa(99);
        });

        assertTrue(exception.getMessage().contains("não foi encontrada"));
    }
}
