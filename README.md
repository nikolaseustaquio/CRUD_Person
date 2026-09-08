# 👤 CRUD Pessoa — VoltaPraticas

Sistema de cadastro de pessoas com persistência em banco de dados, desenvolvido em Java com MySQL via JDBC. Projeto criado para praticar os fundamentos de CRUD completo com banco de dados relacional.

---

## 🛠️ Tecnologias

- Java 17+
- MySQL (via XAMPP)
- JDBC com `PreparedStatement`
- Maven
- IntelliJ IDEA

---

## ⚙️ Funcionalidades

- ✅ Cadastrar nova pessoa (nome, idade, ocupação)
- ✅ Listar todas as pessoas cadastradas
- ✅ Buscar pessoa por ID
- ✅ Atualizar dados de uma pessoa
- ✅ Deletar pessoa (com reindexação automática de IDs)
- ✅ Exceções customizadas (`PessoaNaoEncontradaException`)
- ✅ Menu interativo via terminal

---

## 🗄️ Banco de Dados

```sql
CREATE DATABASE crudbasico;

USE crudbasico;

CREATE TABLE pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    idade INT,
    ocupacao VARCHAR(100)
);
```

---

## 🚀 Como executar

### Pré-requisitos
- Java 17+ instalado
- MySQL rodando na porta `3306` (XAMPP ou outro)
- Banco `crudbasico` criado com a tabela `pessoa`

### Passos
```bash
git clone https://github.com/[seu-usuario]/VoltaPraticas.git
cd VoltaPraticas
```
Abra no IntelliJ IDEA e execute a classe `Main.java`.

> A conexão está configurada com usuário `root` sem senha em `localhost:3306`. Ajuste em `ConexaoBD.java` se necessário.

---

## 📁 Estrutura do Projeto

```
src/
└── com/projectnik/
    ├── Main.java
    ├── Pessoa.java
    ├── Pessoas.java
    ├── ConexaoBD.java
    └── PessoaNaoEncontradaException.java
```

---

## 📚 O que aprendi

- Conexão com banco de dados via JDBC
- Uso de `PreparedStatement` para evitar SQL Injection
- Tratamento de exceções customizadas
- Manipulação de `ResultSet`
- Arquitetura simples de camadas (Model / DAO)

---

Desenvolvido por **Nikolas Carvalho Eustáquio** — estudante de Ciência da Computação.
