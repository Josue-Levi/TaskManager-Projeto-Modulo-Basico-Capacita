package taskmanager.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import taskmanager.dao.TarefaDAO;
import taskmanager.model.Tarefa;

import java.io.IOException;
import java.util.Optional;

public class MainController {

    @FXML private TableView<Tarefa> tabelaTarefas;
    @FXML private TableColumn<Tarefa, Integer> colunaId;
    @FXML private TableColumn<Tarefa, String> colunaTitulo;
    @FXML private TableColumn<Tarefa, String> colunaDescricao;
    @FXML private TableColumn<Tarefa, String> colunaStatus;

    private TarefaDAO dao = new TarefaDAO();

    @FXML
    public void initialize() {
        // Configura as colunas para lerem os atributos da classe Tarefa
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        // Customiza a coluna de status para exibir um texto
        colunaStatus.setCellValueFactory(cellData -> {
            boolean concluida = cellData.getValue().getStatus();
            return new SimpleStringProperty(concluida ? "Concluída" : "Pendente");
        });

        carregarTarefas();
    }

    public void carregarTarefas() {
        ObservableList<Tarefa> tarefasObservable = FXCollections.observableArrayList(dao.listarTodas());
        tabelaTarefas.setItems(tarefasObservable);
    }

    @FXML
    public void abrirTelaCadastro(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/taskmanager/view/CadastroView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 350);

            Stage stage = new Stage();
            stage.setTitle("Nova Tarefa");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); // Bloqueia a tela de trás

            // Passa a referência deste controlador para a tela de cadastro poder atualizar a tabela ao salvar
            CadastroController controller = fxmlLoader.getController();
            controller.setMainController(this);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void concluirTarefa(ActionEvent event) {
        Tarefa selecionada = tabelaTarefas.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            dao.concluir(selecionada.getId());
            carregarTarefas();
        } else {
            mostrarAlerta("Selecione uma tarefa na tabela para concluir.");
        }
    }

    @FXML
    public void removerTarefa(ActionEvent event) {
        Tarefa selecionada = tabelaTarefas.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Exclusão");
            confirmacao.setHeaderText("Você tem certeza que deseja remover esta tarefa?");
            confirmacao.setContentText("Título: " + selecionada.getTitulo());

            Optional<ButtonType> resultado = confirmacao.showAndWait();
            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                dao.excluir(selecionada.getId());
                carregarTarefas();
            }
        } else {
            mostrarAlerta("Selecione uma tarefa na tabela para remover.");
        }
    }

    private void mostrarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}