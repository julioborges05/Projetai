# Projetai

Projeto desenvolvido como parte de um desafio técnico proposto para resolver um problema real de gerenciamento de tarefas e demandas em uma empresa ficticia.

## ✨ Objetivo

Criar uma plataforma própria de **gerenciamento de projetos**, customizável e de código aberto, que permita organizar de forma eficiente as solicitações recebidas, melhorando o fluxo entre **clientes**, **suporte técnico** e **desenvolvedores**.

---

## 🧩 Problema Identificado

A empresa enfrentava dificuldades no controle de solicitações vindas por telefone ou e-mail, o que levava à perda de demandas e sobrecarga da equipe. Tentativas com ferramentas como o Trello apresentaram limitações e custos elevados, o que motivou o desenvolvimento de uma solução interna, flexível e customizável.

---

## 🔍 Funcionalidades

- Registro e acompanhamento de tickets de atendimento.
- Priorização de demandas baseada em análise prévia.
- Atribuição de responsáveis e estimativa de prazos.
- Revisão de código e etapa de refinamento técnico.
- Testes de qualidade antes da finalização da entrega.
- Comunicação eficiente via notificações e comentários.

---

## 🧱 Arquitetura

O sistema é baseado na arquitetura **MVC**, com separação dos domínios segundo os princípios de **Domain-Driven Design (DDD)**. A estrutura do projeto está organizada em módulos com os seguintes pacotes:

- `application`: endpoints e services
- `domain`: entidades e regras de negócio
- `infra`: persistência com JPA e Spring

Um módulo `shared-core` centraliza os componentes reutilizáveis.

Banco de dados: **PostgreSQL**

- Migrations com **Flyway**
- Ambiente facilitado com **Docker Compose**

---

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- PostgreSQL
- Flyway
- Docker / Docker Compose

---

## 📂 Módulos do Domínio

1. **Atendimento:** captação e categorização inicial das solicitações.
2. **Ticket:** criação, status e acompanhamento das tarefas.
3. **Desenvolvimento:** execução técnica das tarefas.
4. **Refinamento:** revisão técnica feita pelo TechLead.
5. **Qualidade:** etapa de testes antes da liberação final.

---

## 🚀 Fluxo de Trabalho

1. Cliente solicita uma demanda → Atendimento registra.
2. Suporte analisa → Criação de ticket.
3. Desenvolvedor implementa e envia para revisão.
4. TechLead refina → QA testa.
5. Ticket finalizado e entregue.

---

## 👥 Autores

- Ana Carolina Oliveira Genova
- Denner Matheus Ribeiro de Oliveira
- Júlio do Nascimento Borges
- Lucas Marques Ferreira
- Rodrigo Dias Flamia

---

## 📎 Links Úteis

- **Repositório GitHub:** [Projetai no GitHub](https://github.com/julioborges05/Projetai)
- **Quadro de Requisitos no Miro:** [Acessar](https://miro.com/app/board/uXjVKgdpKBo=)

---

## 📚 Referências

- [Arquitetura Java - Alura](https://cursos.alura.com.br/course/arquitetura-java-descomplicando-clean-architecture)
- [Exemplo de DDD - Miro](https://miro.com/app/board/uXjVMK9tIRA=)
- [PostgreSQL - CREATE TABLE](https://www.postgresql.org/docs/current/sql-createtable.html)
