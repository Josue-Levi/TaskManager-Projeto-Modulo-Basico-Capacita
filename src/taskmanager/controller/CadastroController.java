package taskmanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import taskmanager.dao.TarefaDAO;
import taskmanager.model.Tarefa;

public class CadastroController {

    @FXML private TextField campoTitulo;
    @FXML private TextArea campoDescricao;

    private MainController mainController;
    private TarefaDAO dao = new TarefaDAO();

    // Guarda a referência da tela principal pra gente conseguir dar um atualizar na tabela depois
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void salvarTarefa(ActionEvent event) {
        String titulo = campoTitulo.getText();
        String descricao = campoDescricao.getText();

        if (titulo == null || titulo.trim().isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Aviso");
            alerta.setHeaderText(null);
            alerta.setContentText("O título da tarefa é obrigatório!");
            alerta.showAndWait();
            return;
        }

        Tarefa novaTarefa = new Tarefa(0, titulo, descricao);
        dao.salvar(novaTarefa);

        // Atualiza a tabela no ecrã principal
        if (mainController != null) {
            mainController.carregarTarefas();
        }

        fecharJanela();
    }

    @FXML
    public void cancelar(ActionEvent event) {
        fecharJanela();
    }

    private void fecharJanela() {
        Stage stage = (Stage) campoTitulo.getScene().getWindow();
        stage.close();
    }
}