## 📌 Visão Geral
**Upskill Platform** é uma API RESTful criada para suportar uma plataforma de upskilling/reskilling voltada ao futuro do trabalho (2030+).  
A solução foi desenvolvida como prova de conceito para o trabalho da disciplina *Global Solution – O Futuro do Trabalho (FIAP, 2025)* e atende requisitos de arquitetura em camadas, migrações, seeds, validações e tratamento centralizado de erros.

---

## 🎯 Objetivos
- Permitir cadastro e gerenciamento de **Usuários** e **Trilhas de Aprendizagem** (CRUDs completos).
- Oferecer seeds iniciais com competências do futuro (IA, Análise de Dados, Empatia, Colaboração).
- Usar migrações (Flyway) para criar o esquema e inserir seeds automaticamente.
- Seguir arquitetura em camadas: `controller` → `service` → `repository`.
- Expor endpoints REST com status codes corretos.
- Fornecer README claro e reprodutível.

---

## 🧰 Tecnologias / Versões
- **Linguagem:** Java 21  
- **Framework:** Spring Boot 3.2.x  
- **Build:** Maven  
- **Banco (dev):** H2 (in-memory)  
- **Banco (prod opcional):** MySQL 8+  
- **Migrações:** Flyway  
- **JPA:** Spring Data JPA / Hibernate  
- **Validação:** Jakarta Bean Validation (spring-boot-starter-validation)  
- **DTO mapping (opcional):** ModelMapper  
- **Ajuda de boilerplate (opcional):** Lombok

---

## 📁 Organização do Código
src/main/java/com/example/upskillplatform/
├─ controller/ # REST controllers (API)
├─ service/ # Regras de negócio
├─ repository/ # Interfaces Spring Data JPA
├─ entity/ # JPA entities
├─ dto/ # DTOs (entrada/saída)
└─ UpskillPlatformApplication.java # main
src/main/resources/
├─ application.yml
└─ db/migration/
└─ V1__init.sql # Flyway migrations + seeds
pom.xml

## 🔧 Instalar dependências (Maven)
No diretório raiz do projeto:

```bash
# baixa dependências e compila o projeto
mvn clean install
🗄️ Configurar o banco
✅ H2 (Padrão — recomendado para desenvolvimento)

O projeto já vem configurado por padrão para H2 em memória. Arquivo: src/main/resources/application.yml.

Acessar console H2:

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:globalsolutiondb

User: sa

Password: (vazio)
▶️ Executar a aplicação
Pelo IntelliJ

Abra a classe principal UpskillPlatformApplication.java.

Clique no ícone ▶️ à esquerda do método main → Run 'UpskillPlatformApplication'.

Pelo terminal
mvn spring-boot:run

📬 Autor
Global Solution – O Futuro do Trabalho (FIAP 2025). Felipe Santana rm 554259 Enzo Barbeli 554272
