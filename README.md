# 📖 Biblioteca

Sistema de gerenciamento de biblioteca via **terminal**, desenvolvido em **Kotlin**. Permite listar, alugar e devolver livros, além de um painel de administrador para cadastrar e remover títulos do acervo.

---

## ✨ Funcionalidades

- 📋 **Listar livros** — exibe título, autor, ano de publicação, descrição e status de disponibilidade
- 📦 **Alugar livro** — marca o livro como indisponível após o aluguel
- 🔁 **Devolver livro** — marca o livro como disponível novamente
- 🔐 **Painel do Administrador** (acesso por usuário e senha)
  - Cadastrar novos livros no acervo
  - Remover livros existentes

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Uso |
|---|---|
| [Kotlin](https://kotlinlang.org/) | Linguagem principal |
| Terminal / Console | Interface do usuário |

---

## 📋 Pré-requisitos

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) ou superior
- [Kotlin](https://kotlinlang.org/docs/command-line.html) instalado (ou usar a IDE IntelliJ IDEA)

---

## 🚀 Como executar o projeto

### Opção 1: Via IntelliJ IDEA (recomendado)

1. Clone o repositório:
```bash
git clone https://github.com/DaviSO7/Biblioteca-Kotlin.git
cd biblioteca
```
2. Abra o projeto no **IntelliJ IDEA**
3. Execute o arquivo `Pessoa.kt` (que contém a função `main`)

### Opção 2: Via linha de comando

1. Clone o repositório:
```bash
git clone https://github.com/DaviSO7/Biblioteca-Kotlin.git
cd biblioteca
```

2. Compile os arquivos:
```bash
kotlinc Livro.kt Biblioteca.kt Pessoa.kt -include-runtime -d biblioteca.jar
```

3. Execute:
```bash
java -jar biblioteca.jar
```

---

## 🗂️ Estrutura do projeto

```
biblioteca/
├── Pessoa.kt        # Ponto de entrada (função main)
├── Biblioteca.kt    # Classe principal com toda a lógica do sistema
├── Livro.kt         # Classe modelo do livro
└── README.md
```

### Responsabilidade de cada arquivo

- **`Livro.kt`** — define o modelo de dados de um livro (título, autor, ano, descrição, disponibilidade)
- **`Biblioteca.kt`** — contém toda a lógica: menus, aluguel, devolução, painel admin, cadastro e remoção de livros
- **`Pessoa.kt`** — inicializa a biblioteca e chama o menu principal

---

## 📚 Acervo inicial

O sistema já começa com 3 livros pré-cadastrados:

| Título | Autor | Ano |
|---|---|---|
| Arquitetura Limpa | Robert C. Martin | 2017 |
| O Programador Pragmático | Andrew Hunt e David Thomas | 1999 |
| Entendendo Algoritmos | Aditya Bhargava | 2016 |

---

## 🔐 Credenciais do Administrador

> ⚠️ Credenciais padrão — altere no código antes de usar em produção.

| Campo | Valor |
|---|---|
| Usuário | `admin` |
| Senha | `1234` |

---

## 🧭 Roadmap / Possíveis melhorias

- [ ] Persistência de dados (arquivo ou banco de dados)
- [ ] Credenciais do administrador via variável de ambiente
- [ ] Sistema de usuários para controle de quem alugou cada livro
- [ ] Prazo de devolução com data limite
- [ ] Busca de livros por título ou autor

---

## 👤 Autor

Feito por [Davi de Souza Rocha da Silva](https://github.com/DaviSO7)
