# API_Biblioteca

Api desenvolvida utilizando as dependências Spring Data JPA, Spring Web, Spring Boot DevTools, Lombok e PostgreSQL Driver

## Pacotes:

Foi utilizada a arquitetura MVC, contendo pacotes Model, Repository, Service e Controller.

### **Model**
Possui classe LivrosModel que origina a tabela tb_livros. Tem como atributos idLivro (id único e serial gerado automaticamente), titulo, autor, dataLancamento e codigoLivro.

### **Repository**
Possui interface LivrosRepository que extende interface JpaRepository

### **Controller**
Possui classe LivrosController que processa requisições web. Possui um método para cada funcionalidade, e cada método repassa a solicitação para a classe LivrosService para que sejam processadas.

### **Service**
Possui classe LivrosService, que tem acesso a LivrosRepository. Processa requisições da classe controller.

## Funcionalidades:

- **Ver todos os livros**: Acessa o banco de dados e exibe Id, título, autor, data de lançamento e código de todos os livros registrados.
- **Ver livro pelo seu ID**: Exibe Id, título, autor, data de lançamento e código do livro especificado
- **Adicionar livro**: Gera automaticamente ID para o novo livro, contendo título, autor, data de lançamento e código
- **Alterar livro**: atualiza campos de título, autor, data de lançamento e/ou código do livro especificado
- **Deletar livro**: Deleta do banco de dados o livro especificado através do ID
