# Sistema de Gerenciamento de Filas

Sistema desenvolvido para organizar e modernizar o atendimento em locais que trabalham com filas presenciais. A aplicação permite o controle digital de entradas, acompanhamento da posição na fila em tempo real e a gestão das unidades de atendimento.

## 🔥 Introdução

Este software foi desenvolvido como projeto final da disciplina **PEX0130 - Programação Orientada a Objetos**, da **Universidade Federal Rural do Semi-Árido (UFERSA) - Campus Pau dos Ferros**.

O objetivo do sistema é reduzir a desorganização em filas presenciais, proporcionando um gerenciamento mais eficiente do atendimento através de uma solução digital.

### Funcionalidades

* Cadastro de usuários do sistema.
* Cadastro de cidadãos.
* Cadastro de unidades de atendimento.
* Geração e gerenciamento de senhas.
* Controle da fila de atendimento.
* Acompanhamento da posição na fila.
* Persistência dos dados utilizando SQLite.
* Organização do código seguindo o padrão MVC.

### 🔨 Guia de instalação

Siga os passos abaixo para executar o projeto em seu computador.

#### 1. Clonar o repositório

```bash
git clone https://github.com/angelosilvanno/SistemaGerenciamentoFilas.git
```

#### 2. Abrir o projeto na IDE

Importe o projeto em uma IDE Java de sua preferência, como:

```text
Eclipse
IntelliJ IDEA
NetBeans
VS Code
```

#### 3. Adicionar o driver SQLite

Certifique-se de que o arquivo `.jar` do SQLite localizado na pasta `/lib` esteja adicionado às bibliotecas do projeto.

```text
lib/
└── sqlite-jdbc.jar
```

#### 4. Executar o sistema

Localize a classe principal e execute:

```text
src/Main.java
```

Após a execução, o sistema estará pronto para uso.

## 📦 Tecnologias usadas

* Java
* SQLite
* JDBC SQLite Driver
* Arquitetura MVC
* DAO (Data Access Object)

## 📁 Estrutura do Projeto

```text
src/
├── models/
├── views/
├── controllers/
├── dao/
└── Main.java

lib/
└── sqlite-jdbc.jar
```

### Descrição das Pastas

* **models:** entidades do sistema como Usuário, Cidadão, Unidade e Senha.
* **views:** interface e interação com o usuário.
* **controllers:** regras de negócio e comunicação entre interface e dados.
* **dao:** acesso e manipulação do banco de dados SQLite.
* **lib:** bibliotecas externas utilizadas pelo projeto.

## 👷 Autores

* **Ângelo Silvano da Silva Sabino** - *Desenvolvedor* - [angelosilvanno](https://github.com/angelosilvanno) 

* **Sávio de Oliveira Jerônimo** - *Membro* - [nome_do_dev](https://github.com/link_do_Perfil)
