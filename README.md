# 📝 Gerenciador de Tarefas | [Task Manager]

Um sistema interativo de gerenciamento de tarefas via console, desenvolvido em Java. O projeto foca na aplicação prática de Programação Orientada a Objetos (POO), validação rigorosa de entradas de usuário e arquitetura modular.

## ✨ Funcionalidades

* **Interface Gráfica (GUI):** Interface intuitiva e amigável construída com JavaFX e FXML.
* **Persistência de Dados:** As tarefas são guardadas de forma segura numa base de dados relacional local (SQLite).
* **Gestão Completa:** Adição, listagem em tabela interativa, conclusão e remoção de tarefas com caixas de confirmação.
* **Arquitetura MVC:** Código estritamente separado em Camada Visual (Views/CSS), Controladores e Modelos/Persistência (DAO).

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem e Gestão:** Java (JDK 21) e Maven.
* **Interface Gráfica:** JavaFX (Scene Builder, FXML, CSS).
* **Persistência (JDBC):** SQLite (dispensa instalação de servidores externos) com uso de `PreparedStatement` para segurança.
* **Testes Automatizados:** JUnit 5 para validação da lógica de negócio e operações da base de dados.
* **Estruturas de Código Avançadas:** Utilização de `Generics` (`<T>`) para maior flexibilidade na manipulação das listas de tarefas.
* **POO:** Encapsulamento, Herança, Interfaces e tratamento de Exceções.

## 🚀 Como Executar o Projeto

### Pré-requisitos
* **Java JDK** (versão 21 recomendada).
* **Maven** (para gestão automática das dependências do JavaFX, SQLite e JUnit).
* Git instalado.

### Passo a Passo

1. Clone este repositório para a sua máquina local:
   ```bash
   git clone [https://github.com/Josue-Levi/TaskManager-Projeto-Modulo-Basico-Capacita.git]
   
   Inicialize o projeto na sua IDE de preferência (recomendado o IntelliJ IDEA). 
2. Localize o arquivo principal de execução no seguinte caminho: src/taskmanager/app/Launcher.java

3. Não execute a classe MainApplication  . Clique com o botão direito na classe Launcher e selecione "Run". A base de dados será criada automaticamente na primeira execução.
