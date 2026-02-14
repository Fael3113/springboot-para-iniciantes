# Sistema de Gerenciamento de Produtos

Um sistema de gerenciamento de produtos com autenticação JWT, desenvolvido em Spring Boot.

##  Funcionalidades

-  **Inserir produto** - Cadastro de novos produtos no sistema
-  **Registrar usuário** - Criação de novas contas de usuário
-  **Logar usuário** - Autenticação via JWT (JSON Web Token)
-  **Procurar produto** - Busca geral de produtos
-  **Procurar produto via ID** - Busca específica por identificador
-  **Deletar produto** - Remoção de produtos do sistema

##  Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 4.0.2**
- **Spring Security** (autenticação JWT)
- **Spring Data JPA**
- **PostgreSQL 18**
- **Maven**
- **JJWT** (biblioteca JWT)

##  Pré-requisitos

- JDK 17 ou superior
- PostgreSQL 18
- Maven 3.6+

##  Como Executar

1. Clone o repositório
```bash
git clone [url-do-repositorio]
```

2. Configure o banco de dados no `application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. Execute o projeto
```bash
mvn spring-boot:run
```

##  Autenticação

O sistema utiliza autenticação JWT. Para acessar endpoints protegidos:

1. Faça login através do endpoint `/auth/login`
2. Copie o token retornado
3. Adicione o token na aba Authorization -> Auth Type (Bearer Token) caso usar Postman

##  Endpoints Principais

### Autenticação
- `POST /auth/register` - Registrar novo usuário
- `POST /auth/login` - Fazer login e receber token JWT

### Produtos
- `POST /produtos` - Criar novo produto (requer autenticação)
- `GET /produtos` - Listar todos os produtos (requer autenticação)
- `GET /produtos/{id}` - Buscar produto por ID (requer autenticação)
- `DELETE /produtos/{id}` - Deletar produto (requer autenticação)

##  Principais Desafios do Projeto

### 1. `parseClaimsJws` ≠ `parseClaimsJwt`
> **O mais frustrante:** Descobrir que a autenticação falhava por causa de uma única letra diferente!

```java
//  ERRADO - para tokens NÃO assinados
.parseClaimsJwt(token)

//  CORRETO - para tokens assinados
.parseClaimsJws(token)  // Note o "s" no final!
```

A letra **"s"** no final faz toda a diferença. Use `parseClaimsJws` quando o token for assinado (que é o padrão de segurança).

### 2. Mudança no `DaoAuthenticationProvider`
> **Breaking change:** A injeção do `UserDetailsService` mudou entre versões do Spring Security

```java
//  Forma antiga
DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
authProvider.setUserDetailsService(userDetailsService);

//  Forma nova
DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
```

**Motivo:** O Spring Security tornou o `UserDetailsService` obrigatório, passando-o diretamente pelo construtor.  

### 3. Atualização do CSRF Disable
> **Modernização:** A sintaxe lambda foi substituída por method reference

```java
//  Forma antiga (ainda funciona)
http.csrf(csrf -> csrf.disable())

//  Forma moderna (recomendada)
http.csrf(AbstractHttpConfigurer::disable)
```

Ambas funcionam, mas a **method reference** é a forma idiomática do Spring Security 6+.

##  Segurança

- Senhas criptografadas com **BCrypt**
- Autenticação stateless via **JWT**
- Tokens com expiração configurável (padrão: 24 horas)
- Endpoints protegidos via Spring Security

##  Dependências Principais

Veja no arquivo pom.xml

##  Licença

Este projeto foi desenvolvido para fins educacionais.

##  Autor

Código original por Matheus Leandro Ferreira no CURSO GRATIS SPRING BOOT PARA INICIANTES ☕👩🏻‍💻 | 2025

Desenvolvido por Rafael de Melo Santiago durante o aprendizado de Spring Boot e Spring Security.
