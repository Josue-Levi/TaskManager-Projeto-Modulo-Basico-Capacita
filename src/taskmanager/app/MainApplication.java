package taskmanager.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import taskmanager.dao.Conexao;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Inicializa a tabela no banco de dados SQLite
        Conexao.inicializarBanco();

        // Carrega o arquivo visual da tela principal
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/taskmanager/view/MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        scene.getStylesheets().add(getClass().getResource("/taskmanager/css/style.css").toExternalForm());

        stage.setTitle("TaskManager - Gerenciador de Tarefas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}