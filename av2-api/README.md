# av2-api (Spring Boot 3 + Java 21)

API simples para demonstrar **REST + validação + tratamento de erros + persistência MySQL**.

## ✅ O que foi implementado (checklist AV2)
- [x] Endpoints REST (GET/POST/PUT/DELETE)
- [x] DTO com Bean Validation (nome/idade) e mensagens em português
- [x] Tratamento global de erros (`@ControllerAdvice`)
  - [x] 400 ValidationError com `fieldErrors`
  - [x] 404 NotFound
  - [x] 500 InternalError
- [x] Persistência com JPA/Hibernate (MySQL local)
- [x] Respostas padronizadas (JSON consistente)
- [x] Projeto rodando com Maven Wrapper (`./mvnw`)

## ⚙️ Requisitos
- Java 21
- Maven (usa wrapper)
- MySQL local (`av2db` com usuário `av2`/`av2pwd`)

## 🔧 Configuração
`src/main/resources/application.properties`
```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/av2db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=av2
spring.datasource.password=av2pwd
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
