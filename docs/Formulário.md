# Documentação do Projeto: Formulário Online com Java no Codespaces  

---

## **Visão Geral**  
Este projeto consiste em um formulário online desenvolvido em **Java** usando o **Spring Boot** no ambiente do **GitHub Codespaces**. O formulário permite que os usuários enviem dados (nome, e-mail e mensagem), que são validados, persistidos em um banco de dados **H2** e armazenados em arquivos `.txt` e `.csv`. O projeto inclui:  
- Validação de campos com **Hibernate Validator**.  
- Estilização com **Bootstrap**.  
- Persistência em banco de dados e arquivos locais.  

---

## **Tecnologias Utilizadas**  
- **Java 17**  
- **Spring Boot 3.4.3**  
- **Spring Data JPA** (para persistência)  
- **H2 Database** (banco em memória)  
- **Thymeleaf** (templates HTML)  
- **Bootstrap 5.3.0** (estilização)  
- **GitHub Codespaces** (ambiente de desenvolvimento)  

---

## **Configuração Inicial**  

### 1. Criar o Projeto no Codespaces  
- Crie um repositório no GitHub e abra-o no Codespaces.  
- Instale as dependências no terminal:  
  ```bash  
  sudo apt update && sudo apt install openjdk-17-jdk maven -y  
  ```  

### 2. Estrutura do Projeto  
O projeto foi gerado com o **Spring Initializr** usando as dependências:  
- `Spring Web`  
- `Thymeleaf`  
- `Spring Data JPA`  
- `H2 Database`  
- `Validation`  

---

## **Funcionalidades Principais**  

### 1. Formulário de Contato  
- **Campos**: Nome, E-mail e Mensagem (todos obrigatórios).  
- **Validação**:  
  - `@NotBlank` para campos obrigatórios.  
  - `@Email` para validação de formato de e-mail.  

### 2. Persistência de Dados  
- **Banco de Dados H2**:  
  - Dados salvos em memória.  
  - Acessível via console em `http://localhost:8080/h2-console`.  
- **Arquivos Locais**:  
  - Dados salvos em `dados/txt/dados_formulario.txt` (formato texto).  
  - Dados salvos em `dados/csv/dados_formulario.csv` (formato CSV).  

### 3. Interface do Usuário  
- **Páginas HTML**:  
  - `form.html`: Formulário estilizado com Bootstrap.  
  - `resultado.html`: Exibição dos dados enviados.  

---

## **Estrutura do Código**  

```
Formulario/  
├── src/  
│   └── main/  
│       ├── java/  
│       │   └── com/primeiroform1/  
│       │       ├── controller/  
│       │       │   └── FormController.java  
│       │       ├── model/  
│       │       │   └── Mensagem.java  
│       │       ├── repository/  
│       │       │   └── MensagemRepository.java  
│       │       └── service/  
│       │           └── FileStorageService.java  
│       └── resources/  
│           ├── static/  
│           ├── templates/  
│           │   ├── form.html  
│           │   └── resultado.html  
│           └── application.properties  
```  

---

## **Evolução do Projeto**  

### 1. Versão Inicial (Formulário Básico)  
- **Objetivo**: Criar um formulário simples sem persistência.  
- **Tecnologias**: Spring Boot, Thymeleaf.  
- **Arquivos**:  
  - `FormController.java`: Métodos para exibir e processar o formulário.  
  - `form.html`: Página HTML básica.  

### 2. Adição de Persistência com H2  
- **Objetivo**: Salvar dados em um banco de dados.  
- **Mudanças**:  
  - Adição da dependência `spring-boot-starter-data-jpa` no `pom.xml`.  
  - Criação da entidade `Mensagem.java`.  
  - Uso do `MensagemRepository` para operações CRUD.  

### 3. Validação de Campos  
- **Objetivo**: Garantir dados corretos antes do envio.  
- **Mudanças**:  
  - Uso de `@NotBlank` e `@Email` na entidade `Mensagem`.  
  - Modificação do `FormController` para usar `@Valid` e `BindingResult`.  

### 4. Estilização com Bootstrap  
- **Objetivo**: Melhorar a interface do usuário.  
- **Mudanças**:  
  - Inclusão do CSS e JavaScript do Bootstrap no HTML.  
  - Uso de classes como `container`, `card`, e `form-label`.  

### 5. Salvamento em Arquivos .txt e .csv  
- **Objetivo**: Armazenar dados localmente para backup.  
- **Mudanças**:  
  - Criação do `FileStorageService.java` para manipulação de arquivos.  
  - Ajuste de caminhos relativos (`dados/txt` e `dados/csv`).  

### 6. Correção de Erros  
- **Problemas Encontrados**:  
  - Métodos duplicados no `FormController`.  
  - Falta de imports (`IOException`, `File`).  
- **Soluções**:  
  - Remoção de métodos redundantes.  
  - Adição das imports necessárias.  

---

## **Como Executar o Projeto**  

### 1. No Codespaces:  
```bash  
mvn clean spring-boot:run  
```  

### 2. Acessar o Formulário:  
- Abra a URL gerada na aba **Ports** do Codespaces (geralmente é aleatorio)

### 3. Banco de Dados H2:  
- Acesse `http://localhost:8080/h2-console`.(erro)  
- Use as credenciais:  
  - JDBC URL: `jdbc:h2:mem:testdb` (erro)
  - User: `sa`  
  - Password: (vazio)  

---

## **Desafios e Soluções**  

| **Desafio**                          | **Solução**                                      |  
|--------------------------------------|--------------------------------------------------|  
| Método duplicado no Controller       | Remoção do método redundante.                    |  
| Erro de compilação (`IOException`)   | Adição da importação `import java.io.IOException`. |  
| Caminhos incorretos dos arquivos     | Uso de diretórios relativos (`dados/txt`).       |  

---

## **Possíveis Melhorias**  
1. **Autenticação de Usuários**: Integrar Spring Security.  
2. **Dashboard de Dados**: Exibir registros em uma tabela HTML.  
3. **Envio de Emails**: Notificar o usuário após o envio.  
4. **Persistência em Nuvem**: Usar PostgreSQL ou MySQL.  
5. **Testes Automatizados**: Implementar testes com JUnit e Mockito.  

---

## **Conclusão**  
Este projeto demonstra como criar um formulário online completo usando Java e Spring Boot, com persistência em banco de dados e arquivos locais. Ele serve como base para aplicações mais complexas, como sistemas de gerenciamento de contatos ou plataformas de feedback.  

**Repositório do Projeto**: [GitHub](https://github.com/Od0g/JavaProjects/tree/main/Formulario).  

--- 

📁 **Documentação por**: Augusto Daniel Silva Inacio
📅 **Última Atualização**: 20 de Março de 2025