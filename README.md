# Catalog

# Catalog – Enterprise Java REST (Maven Multi‑Module)

**Progetto dimostrativo orientato al CV** che mostra competenze su Maven multi‑modulo, Spring Boot REST, testing e buone pratiche di build.

---

## 🎯 Obiettivo

Dimostrare capacità reali su:

* Maven come orchestratore di build (multi‑modulo)
* Architettura a moduli riusabili
* API REST con Spring Boot
* Testing e qualità di build
* Avvio e gestione applicazione da root

---

## 🧩 Architettura

```
catalog/
  pom.xml                # Parent (packaging pom)
  catalog-api/           # DTO e contratti condivisi
  catalog-service/       # Business logic
  catalog-app/           # Console app di test
  catalog-web/           # Spring Boot REST API
```

Relazioni:

```
catalog-api  <-  catalog-service  <-  catalog-app
                          |
                          +--------<- catalog-web
```

---

## 🛠️ Stack Tecnologico

* **Java 21 (LTS)**
* **Maven 3.9+**
* **Spring Boot 3.4.x**
* Spring Web, Validation
* JUnit 5, Spring Boot Test
* Tomcat embedded

---

## 🚀 Funzionalità Implementate

### Build & Struttura

* Progetto **multi‑modulo Maven** con parent POM
* Gestione centralizzata di:

  * versioni dipendenze (BOM)
  * versioni plugin (pluginManagement)
* Build riproducibile con reactor Maven
* Supporto a esecuzione da root con `-pl` e `-am`

### API REST

* Endpoint REST:

  * `GET /api/products`
  * `GET /api/products/{id}`
  * `POST /api/products`
* Serializzazione JSON automatica
* Validazione input con Bean Validation

### Error Handling

* Gestione centralizzata errori con `@ControllerAdvice`
* Risposte strutturate:

  * `400` bad request
  * `422` validation error
  * `404` not found
  * `500` internal error

### Testing

* Test di integrazione con Spring Boot Test + MockMvc
* Test automatici nella fase Maven `test`

---

## ▶️ Avvio Applicazione

Dalla root del progetto:

```bash
mvn clean test
mvn -pl ./catalog-web spring-boot:run
```

Con ricostruzione automatica moduli dipendenti:

```bash
mvn -pl ./catalog-web -am spring-boot:run
```

Cambio porta:

```bash
mvn -pl ./catalog-web spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

---

## 🌐 Esempi API

```bash
curl http://localhost:8080/api/products
curl http://localhost:8080/api/products/1
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Monitor"}'
```

---

## 🧠 Competenze Dimostrate

* Progettazione Maven multi‑modulo
* Gestione dipendenze e plugin in modo enterprise
* Costruzione API REST con Spring Boot
* Dependency Injection e configurazione bean
* Validazione e gestione errori centralizzata
* Testing automatico integrato nella build
* Avvio applicazioni da root con orchestrazione Maven

---

## 📈 Prossimi Step (Roadmap)

* Persistenza con PostgreSQL
* JPA + Flyway
* Testcontainers
* Sicurezza JWT
* Observability (metrics, health, tracing)

Questo progetto rappresenta una base solida per sviluppo enterprise Java.
Breve progetto di dimostrazione di utilizzo Java, Maven e Spring Boot 
