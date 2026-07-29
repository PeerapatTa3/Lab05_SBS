Run with Maven:
```bash
   mvn spring-boot:run
```

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | `/coffees` | Get all coffees |
| GET | `/coffees/{id}` | Get one coffee by id |
| POST | `/coffees` | Add a new coffee |
| PUT | `/coffees/{id}` | Update an existing coffee |
| DELETE | `/coffees/{id}` | Delete a coffee |

## Examples

### 1. Get all coffees
```bash
curl http://localhost:8080/coffees
```

### 2. Get coffee by id
```bash
curl http://localhost:8080/coffees/1
```

### 3. Add a new coffee
```bash
curl -X POST http://localhost:8080/coffees \
     -H "Content-Type: application/json" \
     -d '{"name":"Cappuccino","price":60.0}'
```

### 4. Update a coffee
```bash
curl -X PUT http://localhost:8080/coffees/2 \
     -H "Content-Type: application/json" \
     -d '{"name":"Latte","price":50.0}'
```

### 5. Delete a coffee
```bash
curl -X DELETE http://localhost:8080/coffees/3
```
