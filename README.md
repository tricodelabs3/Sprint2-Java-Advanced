# 🩺 Saúde Inteligente — Prevenção Personalizada (Sprint 2)

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.3-green)
![Oracle](https://img.shields.io/badge/Oracle_Database-Connected-red)
![HATEOAS](https://img.shields.io/badge/HATEOAS-Enabled-yellow)
![Maven](https://img.shields.io/badge/Maven-3.8+-orange)
![Postman](https://img.shields.io/badge/Postman-Tested-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📘 1. Nome da Aplicação
**Saúde Inteligente – Prevenção Personalizada**

---

## 👥 2. Integrantes e Funções

| Nome | Função no Projeto |
|------|--------------------|
| **Luann Noqueli (RM 560313)** | Backend (Java / Spring Boot), integração H2, aplicação do HATEOAS e testes Postman, proposta de solução e pitch de apresentação |
| **Lucas Higuti (RM 561120)** | Estruturação do banco de dados (modelo lógico, tabelas e relacionamentos) |
| **Jhonatta Sandes (RM 560277)** | Documentação técnica |


---


## 💡 3. Descrição Geral

**Saúde Inteligente** é uma aplicação de **saúde preventiva** desenvolvida em **Java Spring Boot**, totalmente integrada ao **banco de dados Oracle (FIAP)**.

O sistema auxilia o usuário no monitoramento de **sono**, **alimentação**, **exercícios** e **bem-estar**, promovendo uma **prevenção personalizada** e **melhoria contínua da saúde**.


### 🧩 Evoluções da Sprint 2
- Implementação completa de **HATEOAS**;
- Criação e uso de **DTOs** para segurança e desacoplamento;
- Estrutura organizada em camadas (`controller`, `service`, `repository`, `model`, `dto`);
- Integração real com o **Oracle Database** via JPA / Hibernate;
- Testes de todos os endpoints via **Postman** e verificação no **SQL Developer**.


---

## ⚙️ 4. Como Rodar a Aplicação

### 🔧 Pré-requisitos
- ☕ **Java 17+**
- 🧱 **Maven 3.8+**
- 🖥️ **IDE** (IntelliJ, Eclipse ou VS Code)
- 🧪 **Postman**
- 🧩 **SQL Developer (Oracle)**
  
### 🚀 Passos

```bash
# 1️⃣ Clone o repositório
git clone https://github.com/tricodelabs3/Sprint2-Java-Advanced.git
cd saude-inteligente

# 2️⃣ Instale as dependências
mvn clean install

# 3️⃣ Rode o projeto
mvn spring-boot:run

```
### 💾 Conexão com o Oracle DataBase (FIAP)
# =========================================
# 🔹 CONEXÃO COM ORACLE (FIAP)
# =========================================
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# =========================================
# 🔹 JPA / HIBERNATE
# =========================================
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# =========================================
# 🔹 SERVIDOR
# =========================================
server.port=8080

## 🧩 5. Estrutura do Projeto

```bash
src/
 ├── main/java/br/com/saudeinteligente/
 │   ├── controller/      # Camada de controle (com HATEOAS)
 │   ├── dto/             # Objetos de transferência de dados
 │   ├── model/           # Entidades JPA
 │   ├── repository/      # Interfaces de persistência (Spring Data JPA)
 │   ├── service/         # Regras de negócio
 │   └── SaudeInteligenteApplication.java
 │
 └── main/resources/
     ├── application.properties  # Configuração do Oracle
```

---

## 🧠 6. Funcionalidades da API

A API segue boas práticas **RESTful**, com **respostas HATEOAS**, e persistência real no **Oracle Database**.

### ⚙️ Funcionalidades principais

- ✅ **CRUD completo de usuários**
- 🔗 **Respostas HATEOAS** para navegação entre endpoints
- 💾 **Integração com Oracle Database (FIAP)**
- 🔐 **DTOs** para segurança e padronização dos dados
- 🧱 **Criação automática de tabelas via Hibernate**
- 🧪 **Testes de endpoints via Postman**
- 🧩 **Camadas organizadas:** Controller / Service / Repository / Model / DTO

---

## 🔗 7. Endpoints da API (com HATEOAS)

| Método | Endpoint | Descrição |
|:------:|:----------|:-----------|
| `GET` | `/api/usuarios` | Lista todos os usuários |
| `GET` | `/api/usuarios/{id}` | Busca usuário por ID |
| `POST` | `/api/usuarios` | Cria novo usuário |
| `PUT` | `/api/usuarios/{id}` | Atualiza usuário existente |
| `DELETE` | `/api/usuarios/{id}` | Remove usuário |

> 🧩 **Demais entidades** — *Sono*, *Exercício*, *Alimentação* e *Recomendação* — seguem o mesmo padrão CRUD, utilizando a mesma estrutura com DTOs e links HATEOAS.

---

## 📊 8. Testes no Postman e Banco Oracle

Após a integração com o **Oracle Database** (banco da FIAP), as requisições enviadas via **Postman** são persistidas automaticamente no banco através do **Hibernate**, que cria as tabelas conforme as entidades do projeto.

### 🧪 Exemplo de requisição `POST`

**Endpoint:**

**http://localhost:8080/api/usuarios**

**Header:**

**Content-Type: application/json**


**Body (JSON):**
```json
{
  "nome": "Ana Oliveira",
  "email": "ana.duda@example.com",
  "senha": "123456",
  "dtNascimento": "1995-08-20",
  "genero": "Feminino",
  "sono": [],
  "exercicios": [],
  "alimentacoes": [],
  "recomendacoes": []
}
```
### 🧪 Coleção de Testes (Requisito G)

A coleção completa do Postman com todos os *endpoints* (GET, POST, PUT, DELETE) está disponível no repositório.

O professor pode importar este ficheiro para validar a persistência e recuperação dos dados:

* **Link para Download:** [./docs/RequisiçõesSprint2-Java.postman_collection](https://github.com/tricodelabs3/Sprint2-Java-Advanced/blob/main/docs/Requisi%C3%A7%C3%B5esSprint2-Java.postman_collection)



```
## 💾 Verificação no Banco Oracle

Após enviar a requisição, é possível confirmar o registro diretamente no SQL Developer com o comando:

```sql
SELECT * FROM USUARIO;


| ID_USUARIO | NOME       | EMAIL                | DT_NASCIMENTO | GENERO    |
|------------|------------|--------------------|---------------|-----------|
| 1          | Ana Oliveira  | ana.duda@example.com | 1995-08-20    | Feminino  |
```
---

## 🧾 9. Tecnologias Utilizadas

| Categoria        | Tecnologias                           |
|-----------------|--------------------------------------|
| Linguagem        | Java 17                               |
| Framework        | Spring Boot 3.3.3                     |
| Banco de Dados   | Oracle Database (FIAP)                |
| Persistência     | Spring Data JPA + Hibernate           |
| HATEOAS          | Spring Boot Starter HATEOAS           |
| Build Tool       | Maven                                 |
| Auxiliar         | Lombok                                |
| Testes           | Postman + SQL Developer               |


## 🧠 10. Conclusão

A Sprint 2 consolidou o backend do projeto **Saúde Inteligente**, tornando a API completa, funcional e integrada ao Oracle Database.  
O uso do Hibernate automatizou a criação das tabelas conforme as entidades Java, simplificando o processo de deploy e testes.

**Principais conquistas:**

- ✅ CRUD completo de usuários conectado ao Oracle
- 🔗 Retornos padronizados com HATEOAS (`self`, `allUsuarios`)
- 🧱 Criação automática de tabelas pelo Hibernate
- 🧪 Testes de requisições via Postman
- 💾 Validação dos dados persistidos no banco Oracle

Esses avanços posicionam o projeto no **Nível 3 do Modelo REST de Richardson**, com uma API autodescritiva e pronta para integração com sistemas externos.

---

## 🚀 11. Próximos Passos / Melhorias Futuras

- 🔒 Implementar autenticação e autorização com JWT (JSON Web Token)
- 🌤️ Integrar APIs externas (ex: OpenWeather, Spoonacular, Fitbit)
- 📊 Criar um Dashboard Web (React/Next.js) conectado ao backend
- ☁️ Migrar o banco de dados para Oracle Cloud
- 🧠 Adicionar recomendações automáticas baseadas em IA preditiva
- 🧪 Implementar testes automatizados (JUnit + MockMvc)
- 🧰 Adicionar Swagger UI para documentação dos endpoints
- ⚡ Otimizar performance e padronizar respostas da API

- ## 📊 . Diagramas (Sprint 2)

Para cumprir os requisitos da entrega (critérios b e f-3.4), seguem os três diagramas que representam a solução:

### 1. Diagrama de Arquitetura
<img width="121" height="681" alt="Diagrama de arquitetura drawio" src="https://github.com/user-attachments/assets/9cbe9bb1-2f0a-4a2f-858e-f82b9b9c4ee8" />

### 2. Diagrama de Classes de Entidade
<img width="921" height="502" alt="Diagrama_Sprint1_Vitta drawio" src="https://github.com/user-attachments/assets/a366a6d5-cd13-4b56-95ae-3679b814c401" />

### 3. Diagrama de Entidade e Relacionamento (DER)
<img width="1281" height="1111" alt="Diagrama de Entidade e Relacionamento (DER)  drawio" src="https://github.com/user-attachments/assets/7db99c90-f9a4-4134-a7d7-b3b25ba53937" />


## 💾  Link do vídeo de apresentação

🔗 [https://youtu.be/86jrndKIOwo]

---

> 💬 **Equipe Saúde Inteligente**  
> *“Prevenir é mais inteligente do que remediar.”*













