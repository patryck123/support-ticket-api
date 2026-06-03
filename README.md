# 🎫 Support Ticket API

Sistema de chamados de suporte com número TKT, prioridades, SLA e comentários.

## 📋 Sobre o Projeto

API para equipes de suporte técnico gerenciarem chamados de clientes. Cada chamado recebe um número único no formato `TKT-0001`, tem prioridade e status. A equipe pode adicionar comentários internos e rastrear o histórico de atualizações.

## ✨ Funcionalidades

- ✅ Abrir chamado com título e descrição
- ✅ Número automático no formato TKT-XXXX
- ✅ Prioridade: LOW, MEDIUM, HIGH, CRITICAL
- ✅ Status: OPEN → IN_PROGRESS → RESOLVED → CLOSED
- ✅ Categoria: BUG, FEATURE_REQUEST, SUPPORT, BILLING
- ✅ Comentários internos da equipe
- ✅ Histórico de mudanças de status
- ✅ Filtrar por prioridade, status ou categoria
- ✅ Listagem de chamados abertos

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET/POST | `/api/tickets` | Listar / Abrir chamado |
| GET | `/api/tickets/{id}` | Detalhes do chamado |
| PATCH | `/api/tickets/{id}/status` | Atualizar status |
| POST | `/api/tickets/{id}/comments` | Adicionar comentário |
| GET | `/api/tickets?priority=HIGH` | Filtrar por prioridade |
| GET | `/api/tickets/open` | Chamados em aberto |

## 🛠️ Tecnologias

- Java 17 · Spring Boot 3.2 · PostgreSQL · Maven · Lombok
