# Support Ticket API

Sistema de chamados de suporte técnico com número automático, atribuição de agentes, histórico de comentários, prioridades e fluxo completo de status.

## Tecnologias
Java 17 · Spring Boot 3.2 · Spring Data JPA · PostgreSQL · Maven · Swagger/OpenAPI

## Funcionalidades
- Abertura de chamados com geração automática de número (TKT-XXXXXXXX)
- Categorias: BUG, FEATURE_REQUEST, BILLING, TECHNICAL_SUPPORT
- Prioridades: LOW, MEDIUM, HIGH, CRITICAL
- Fluxo: OPEN → IN_PROGRESS → RESOLVED → CLOSED
- Atribuição de chamado para agente e registro de comentários internos
- Filtros por status, prioridade, solicitante e agente responsável

## Como Executar
```bash
mvn spring-boot:run
# Acesse: http://localhost:8103/swagger-ui.html
```
**Patryck Martins Langsdorff** — Java Back End Developer Junior | [LinkedIn](https://www.linkedin.com/in/patryck-martins-langsdorff)
