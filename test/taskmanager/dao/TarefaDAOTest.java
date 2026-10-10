package taskmanager.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taskmanager.model.Tarefa;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TarefaDAOTest {

    private TarefaDAO dao;

    @BeforeEach
    void setUp() {
        // Garante que a tabela existe antes de testar
        Conexao.inicializarBanco();
        dao = new TarefaDAO();
    }

    @Test
    void testSalvarEListarNoBanco() {
        // Conta quantas tarefas existem antes do teste
        int totalAntes = dao.listarTodas().size();

        // Cria e salva uma nova tarefa
        Tarefa t = new Tarefa(0, "Tarefa de Teste DAO", "Testando o SQLite");
        dao.salvar(t);

        // Verifica se o total aumentou em 1
        List<Tarefa> tarefas = dao.listarTodas();
        assertEquals(totalAntes + 1, tarefas.size(), "A base de dados deveria ter registado a nova tarefa.");
    }
}