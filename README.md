# Sentinels

Plataforma de monitoramento de infraestrutura para **websites, APIs, bancos de dados e RabbitMQ**, com alertas por **e-mail e SMS**.

## Sobre o projeto

O Sentinels é um backend construído em **Spring Boot** para monitorar a saúde de serviços críticos de uma aplicação. Ele verifica periodicamente a disponibilidade de endpoints, bancos de dados e filas RabbitMQ, disparando alertas automáticos quando algo sai do ar ou apresenta falha.

## Tecnologias

- **Java 21**
- **Spring Boot 3.5.0**
- Spring Web / WebFlux
- Spring Data JPA
- Spring Validation
- Spring Mail (alertas por e-mail)
- Spring AMQP (integração com RabbitMQ)
- springdoc-openapi (documentação Swagger/OpenAPI)
- Lombok
- H2 (banco em memória para desenvolvimento/testes)
- Suporte a **SQL Server** e **MySQL** como banco de produção
- Maven

## Pré-requisitos

- JDK 21+
- Maven (ou use o wrapper `mvnw` incluso no projeto)
- Uma instância RabbitMQ (se for testar o monitoramento de filas)
- Banco de dados MySQL ou SQL Server (opcional — por padrão o projeto pode rodar com H2)

## Como rodar o projeto

Clone o repositório:

```bash
git clone https://github.com/FelipePLM/Sentinels.git
cd Sentinels
```

Rode a aplicação com o Maven Wrapper:

```bash
# Linux/macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## Documentação da API

Com a aplicação rodando, a documentação Swagger/OpenAPI fica disponível em:

```
http://localhost:8080/swagger-ui.html
```

## Configuração

As configurações de conexão com banco de dados, RabbitMQ, e-mail (SMTP) e SMS devem ser definidas em `src/main/resources/application.properties` (ou `application.yml`), incluindo:

- Credenciais de acesso ao banco (MySQL/SQL Server)
- Host, porta e credenciais do RabbitMQ
- Configuração do servidor SMTP para envio de alertas por e-mail
- Credenciais do provedor de SMS utilizado para os alertas

> Recomenda-se manter essas credenciais fora do controle de versão, utilizando variáveis de ambiente ou um arquivo `application-local.properties` ignorado pelo Git.

## Licença

Este projeto ainda não possui uma licença definida.

## Autor

Desenvolvido por [FelipePLM](https://github.com/FelipePLM).