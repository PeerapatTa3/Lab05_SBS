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
<img width="940" height="58" alt="image" src="https://github.com/user-attachments/assets/66db6f45-96c8-445a-bb78-b6e4b3d7ed1f" />

### 2. Get coffee by id
```bash
curl http://localhost:8080/coffees/1
```
<img width="940" height="52" alt="image" src="https://github.com/user-attachments/assets/039922ad-1f25-4cf1-a5d3-abca5c2c6f8b" />

### 3. Add a new coffee
```bash
curl -X POST http://localhost:8080/coffees \
     -H "Content-Type: application/json" \
     -d '{"name":"Cappuccino","price":60.0}'
```
<img width="940" height="83" alt="image" src="https://github.com/user-attachments/assets/8844ddf4-0d28-474e-8872-7fc1a1521a3b" />

### 4. Update a coffee
```bash
Invoke-RestMethod -Uri "http://localhost:8080/coffees/2" -Method Put `
  -ContentType "application/json" `
  -Body '{"name":"Latte","price":50.0}'
```
<img width="940" height="192" alt="image" src="https://github.com/user-attachments/assets/22b61ce9-e89b-42cd-b211-9ffd15a6ea15" />

### 5. Delete a coffee
```bash
curl -X DELETE http://localhost:8080/coffees/3
```
<img width="940" height="104" alt="image" src="https://github.com/user-attachments/assets/d7a90742-f3d8-43d4-bd0a-f7d7e8b9d9f6" />

### Bonus เพิ่ม ค้นหาเมนูตามชื่อ 
```bash
curl.exe http://localhost:8080/coffees/search?name=Latte
```
<img width="940" height="77" alt="image" src="https://github.com/user-attachments/assets/eddc1882-d651-4604-b8de-2f31627909e7" />

### Discussion
1.	HTTP method แต่ละตัว (GET/POST/PUT/DELETE) ต่างกันอย่างไร ยกตัวอย่างจากโปรเจกต์ตัวเอง
ตอบ	GET ดึงข้อมูล — @GetMapping("/coffees") ดึงรายการกาแฟทั้งหมด
POST สร้างใหม่ — @PostMapping("/coffees") เพิ่มเมนูใหม่พร้อมส่ง JSON
PUT แก้ไข — @PutMapping("/{id}") อัปเดตข้อมูลเดิม เช่นเปลี่ยนราคา
DELETE ลบ — @DeleteMapping("/{id}") ลบเมนูออกจาก List
2.	ทำไมต้องแยก Controller กับ Service ออกจากกัน มีข้อดีอย่างไรถ้าโปรแกรมโตขึ้น
ตอบ ถ้าไม่แยก Controller จะเก็บข้อมูล + logic ตั้งหลายแห่ง หลังจากนี้แก้ bug ยาก สามารถทดสอบยากด้วย แยกแล้วแต่ละตัวดูแลตัวเอง Controller แค่รับ request ส่วน Service ดูแล business logic เฉพาะ
3.	ข้อมูลที่เก็บไว้ใน List ใน memory หายไปตอนไหน และถ้าอยากให้ไม่หายควรทำอย่างไร (ตอบเป็นแนวคิดพอ)
ตอบ ตอนปิด app ข้อมูลใน memory หายทั้งหมด ถ้าไม่อยากให้หาย ต้องเก็บลงฐานข้อมูล (Database) หรือบันทึกเป็นไฟล์
4.	@RestController, @GetMapping, @PostMapping, @PathVariable, @RequestBody แต่ละตัวทำหน้าที่อะไร
ตอบ 	@RestController บอก Spring ว่านี่ endpoint ที่ return JSON
@GetMapping / @PostMapping / @PutMapping / @DeleteMapping สร้าง endpoint ตามข้อมูล method
@PathVariable ดึงค่าจาก URL เช่น /coffees/{id} ได้ id มาใช้
@RequestBody แปลง JSON จาก request body เป็น object

