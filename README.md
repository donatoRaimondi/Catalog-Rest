# Catalog – Enterprise Java REST (Maven Multi‑Module)

**Progetto dimostrativo orientato al CV** che mostra competenze su Maven multi‑modulo, Spring Boot REST, JPA, Flyway e integrazione con PostgreSQL.

---

## 🎯 Obiettivo

Dimostrare capacità reali su:

* Maven come orchestratore di build (multi‑modulo)
* Architettura a moduli riusabili
* API REST con Spring Boot
* Persistenza con JPA + PostgreSQL
* Migrazioni DB con Flyway
* Testing e qualità di build

---

## 🧩 Architettura

```
catalog/
  pom.xml                # Parent (packaging pom)
  catalog-api/           # DTO e contratti condivisi
  catalog-service/       # Business logic
  catalog-web/           # Spring Boot REST API
```

Relazioni:

```
catalog-api  <-  catalog-service  <-  catalog-web
```

---

## 🛠️ Stack Tecnologico

* **Java 21 (LTS)**
* **Maven 3.9+**
* **Spring Boot 3.4.x**
* Spring Web, Spring Data JPA, Validation
* PostgreSQL 16+
* Flyway
* JUnit 5, Spring Boot Test

---

## 🚀 Funzionalità Implementate

### Build & Struttura

* Progetto **multi‑modulo Maven** con parent POM
* Gestione centralizzata di:

  * versioni dipendenze (BOM Spring Boot)
  * versioni plugin
* Build riproducibile con reactor Maven
* Supporto a esecuzione da root con `-pl` e `-am`

### API REST

Endpoint:

* `GET /api/products`
* `GET /api/products/{id}`
* `POST /api/products`

Funzionalità:

* Serializzazione JSON automatica
* Validazione input con Bean Validation
* Mapping Entity → DTO

### Persistenza

* PostgreSQL come database
* JPA/Hibernate
* Flyway per versionamento schema
* Entità: `products (id, name, active)`

### Testing

* Test di integrazione con Spring Boot Test + MockMvc
* Test automatici nella fase Maven `test`

---

## ▶️ Avvio Applicazione

### Prerequisiti

* PostgreSQL in esecuzione su `localhost:5432`
* Database: `catalog`
* Utente: `catalog`
* Password configurata in `application.yml`

Esempio schema:

```
products(
  id varchar(50) primary key,
  name varchar(255) not null,
  active boolean not null default true
)
```

### Build

Dalla root del progetto:

```bash
mvn clean test
```

### Avvio REST API

```bash
mvn -pl ./catalog-web -am spring-boot:run
```

Cambio porta:

```bash
mvn -pl ./catalog-web spring-boot:run \
  -Dspring-boot.run.arguments=--server.port=8081
```

---

## 🌐 Esempi API

```bash
curl http://localhost:8080/api/products

curl http://localhost:8080/api/products/0

curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Monitor"}'
```

---

## 🧠 Competenze Dimostrate

* Progettazione Maven multi‑modulo
* Gestione dipendenze e plugin in modo strutturato
* Costruzione API REST con Spring Boot
* Dependency Injection e configurazione bean
* JPA + PostgreSQL
* Flyway per migrazioni DB
* Testing automatico integrato nella build
* Avvio applicazioni da root con orchestrazione Maven

---

## 📈 Prossimi Step (Roadmap)

* Autenticazione e ruoli
* Migliorare copertura test
* Docker compose completo
* CI con GitHub Actions
* Metriche e health check

---

Questo progetto rappresenta una base solida per sviluppo Java backend in contesto enterprise, con focus su build, architettura modulare e integrazione reale con database.
