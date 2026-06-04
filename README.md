# Dende Eventos API

API REST desenvolvida com Spring Boot para gerenciamento de eventos, organizadores e participantes.

## Objetivo

O sistema permite o cadastro e gerenciamento de eventos, organizadores e usuários participantes, disponibilizando operações completas de criação, consulta, atualização e remoção de dados através de uma API REST documentada com Swagger.

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Bean Validation
* Swagger / OpenAPI
* Gradle

## Funcionalidades

### Usuários

* Cadastrar usuário
* Listar usuários
* Buscar usuário por ID
* Atualizar usuário
* Remover usuário

### Organizadores

* Cadastrar organizador
* Listar organizadores
* Buscar organizador por ID
* Atualizar organizador
* Remover organizador

### Eventos

* Cadastrar evento
* Listar eventos
* Buscar evento por ID
* Atualizar evento
* Remover evento
* Associar organizador ao evento
* Associar participantes ao evento

## Estrutura do Projeto

O projeto foi desenvolvido seguindo a arquitetura em camadas:

* Controller
* Service
* Repository
* Entity
* DTO
* Mapper

Além disso, foram aplicadas boas práticas de desenvolvimento com:

* Injeção de dependência via construtor
* Uso de DTOs para Request e Response
* Mapeamento entre DTOs e Entidades
* Relacionamentos JPA
* Bean Validation
* Documentação Swagger

## Relacionamentos Implementados

* OneToMany
* ManyToOne
* ManyToMany

## Documentação da API

Após iniciar a aplicação, a documentação Swagger poderá ser acessada através do endereço:

```text
http://localhost:8080/swagger-ui/index.html
```

## Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/ryangroove/dende-eventos-spring-api-barcelona.git
```

2. Acesse a pasta do projeto:

```bash
cd dende-eventos-spring-api-barcelona
```

3. Configure o banco de dados PostgreSQL no arquivo:

```text
src/main/resources/application.properties
```

4. Execute a aplicação:

```bash
./gradlew bootRun
```

Ou execute a classe:

```text
DendeEventosApiApplication
```

## Equipe Barcelona

### Integrantes

* Ryan Ribeiro
* Rafael Ruas
* Luiz Alberto
* Raiane Lemos
* Igor Gustavo

## Disciplina

Projeto desenvolvido para a disciplina de Desenvolvimento Web Orientada a Objetos.

---

Centro Universitário de Excelência UNEX - Sistemas de Informação - Projeto Acadêmico 
