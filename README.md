# 📝 Gerenciador de Tarefas | [Task Manager]

Um sistema interativo de gerenciamento de tarefas via console, desenvolvido em Java. O projeto foca na aplicação prática de Programação Orientada a Objetos (POO), validação rigorosa de entradas de usuário e arquitetura modular.

## ✨ Funcionalidades

* **Adicionar Tarefas:** Suporte para criação de tarefas Normais ou Prioritárias.
* **Listagem:** Visualização de todas as tarefas cadastradas e seus respectivos status formatados na tela.
* **Conclusão de Tarefa:** Busca inteligente pelo ID para alterar o status da tarefa.
* **Remoção:** Exclusão rápida e segura de tarefas do sistema.
* **Validação de Dados:** Prevenção ativa contra IDs duplicados, campos obrigatórios vazios e erros de digitação.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem:** Java(JDK21).
* **POO:** Encapsulamento, Herança (`Tarefa` -> `TarefaPrioritaria`) e Interfaces (`InterfaceGerenciadorTarefas`).
* **Estruturas de Dados:** Uso de `ArrayList` para o armazenamento dinâmico em memória.
* **Segurança e Exceções:** Uso de `do-while`, blocos `try-catch` e criação de exceções customizadas para as regras de negócio (`TarefaNaoEncontradaException`).
* **Arquitetura:** Código modularizado e dividido nos pacotes `app`, `controller`, `model` e `exceptions`.

## 🚀 Como Executar o Projeto

### Pré-requisitos
* Ter o **Java JDK** (recomendado versão 21 LTS) instalado em sua máquina.
* Git instalado.

### Passo a Passo

1. Clone este repositório para a sua máquina local:
   ```bash
   git clone [https://github.com/Josue-Levi/TaskManager-Projeto-Modulo-Basico-Capacita.git]
   
   Inicialize o projeto na sua IDE de preferência (recomendado o IntelliJ IDEA). 
2. Localize o arquivo principal de execução no seguinte caminho: src/taskmanager/app/Main.java

3. Execute a classe principal (No IntelliJ, abra a classe Main e clique no botão ▶️ verde ou pressione Shift + F10).
