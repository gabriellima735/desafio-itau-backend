# Desafio Itaú – API de Transações

API REST desenvolvida em **Java 17 + Spring Boot** como solução para o desafio proposto pelo Itaú Unibanco.

## 📋 Descrição

A aplicação recebe transações financeiras e fornece estatísticas em tempo real sobre as transações ocorridas nos **últimos 60 segundos**, sem uso de banco de dados (tudo em memória).

---

## 🚀 Funcionalidades

- **POST /transacao**  
  Recebe uma nova transação.
    - Corpo (JSON):
      ```json
      {
        "valor": 123.45,
        "dataHora": "2025-09-13T14:00:00-03:00"
      }
      ```
    - Regras:
        - `valor` ≥ 0
        - `dataHora` não pode ser futura
    - Respostas:
        - `201 Created` – Transação aceita
        - `422 Unprocessable Entity` – Dados inválidos
        - `400 Bad Request` – JSON mal formatado

- **GET /estatistica**  
  Retorna estatísticas das transações dos últimos 60 segundos.
    - Exemplo de resposta:
      ```json
      {
        "count": 10,
        "sum": 1234.56,
        "avg": 123.45,
        "min": 10.0,
        "max": 250.0
      }
      ```

- **DELETE /transacao**  
  Remove todas as transações armazenadas.
    - Resposta: `200 OK`

---

## 🛠 Tecnologias

- Java 17
- Spring Boot 3.x
- Maven
- Lombok
- Spring Validation
- **Swagger/OpenAPI** para documentação interativa
- JUnit + Spring Boot Test para testes automatizados

---

## ▶️ Como executar

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/seu-usuario/desafio-itau-backend.git
   cd desafio-itau-backend
   ```
2. **Compilar e iniciar a aplicação**

Se estiver usando o wrapper do Maven (recomendado):
```bash
./mvnw spring-boot:run   # Linux/Mac
```
ou
```bash
mvnw spring-boot:run     # Windows
```

Caso prefira, também é possível usar:
```bash
mvn spring-boot:run
```

3. **Acessar a API**
A aplicação estará disponível em:
http://localhost:8080
