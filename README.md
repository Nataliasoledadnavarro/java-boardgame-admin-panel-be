# 🛡️ Admin Panel Backend - Juegos de Mesa

Este proyecto es el **backend Java (Spring Boot)** para el panel de administración de juegos de mesa. Permite gestionar productos y categorías, y expone una API REST que es consumida por el frontend desarrollado en Next.js.

---

## 📝 Descripción general

El backend implementa operaciones CRUD para productos y categorías, maneja relaciones entre entidades y valida reglas de negocio (por ejemplo, no permite eliminar categorías con productos asociados).  
Incluye manejo de errores y CORS para integración con el frontend desplegado en Vercel o en local.

---

## 🚀 Características principales del backend

- API RESTful para productos y categorías
- Arquitectura en capas: Controller, Service, Repository, Model
- Validaciones automáticas con anotaciones (`@NotBlank`, `@Positive`, etc.)
- Relación entre productos y categorías (ManyToOne / OneToMany)
- Manejo de errores descriptivo (por ejemplo, 409 Conflict si intentas eliminar una categoría con productos)
- Excepciones personalizadas para reglas de negocio
- CORS habilitado para frontend local y en producción (Vercel)
- Configuración lista para MySQL y Spring Boot
- Código y endpoints listos para integración con frontend moderno

---

## ⚙️ Tecnologías utilizadas

- **Backend:** Java 17+, Spring Boot 3.5.x, Spring Data JPA, MySQL
- **Build:** Maven
- **Base de datos:** MySQL 8+
- **Frontend compatible:** Next.js (ver sección de acceso)

---

## 🛠️ Requisitos previos

- Java 17 o superior
- Maven 3.8+ (o usar el wrapper `./mvnw`)
- MySQL 8+ (puedes usar XAMPP, MAMP, Docker, etc.)
- (Opcional) Node.js 18+ si quieres correr el frontend localmente

---

## 🟢 ¿Cómo correr el backend?

1. **Clona este repositorio:**
   ```bash
   git clone https://github.com/Nataliasoledadnavarro/java-boardgame-admin-panel-be.git
   cd java-boardgame-admin-panel-be
   ```

2. **Configura la base de datos:**
   - Crea una base de datos llamada `admin_panel_db` en tu MySQL.
   - El usuario y contraseña por defecto son `root` y vacío (`""`).  
     Si usas otros datos, edita `src/main/resources/application.properties`.

3. **Instala dependencias y ejecuta el backend:**
   ```bash
   ./mvnw spring-boot:run
   ```
   O desde tu IDE favorito (IntelliJ, Eclipse, VS Code).

4. **La API estará disponible en:**  
   [http://localhost:8080/api](http://localhost:8080/api)

---

## 🌐 ¿Cómo probar el frontend?

### Opción 1: Usar el frontend ya desplegado

Accede directamente desde:

👉 [https://boardgames-admin-panel-fe.vercel.app/](https://boardgames-admin-panel-fe.vercel.app/)

> **Importante:**  
> Debes tener este backend corriendo en tu máquina para que el frontend funcione correctamente.

---

### Opción 2: Correr el frontend localmente

1. Clona el frontend:
   ```bash
   git clone https://github.com/Nataliasoledadnavarro/boardgames-admin-panel-fe.git
   cd boardgames-admin-panel-fe
   ```

2. Instala dependencias:
   ```bash
   npm install
   ```

3. Crea el archivo `.env.local` con:
   ```
   NEXT_PUBLIC_API_URL=http://localhost:8080/api
   ```

4. Ejecuta el frontend:
   ```bash
   npm run dev
   ```
   Accede a [http://localhost:3000](http://localhost:3000)

---

## 📚 Endpoints principales

- `GET    /api/categories` — Listar categorías
- `POST   /api/categories` — Crear categoría
- `PUT    /api/categories/{id}` — Actualizar categoría
- `DELETE /api/categories/{id}` — Eliminar categoría (409 si tiene productos)
- `GET    /api/products` — Listar productos
- `POST   /api/products` — Crear producto
- `PUT    /api/products/{id}` — Actualizar producto
- `DELETE /api/products/{id}` — Eliminar producto
- `GET    /api/products/category/{id}` — Productos por categoría

---
Puedes acceder al video demo:

👉 [https://www.veed.io/view/es-ES/fca82af2-0fa5-4d38-b86d-2b4d0c29e88b?panel=share/](https://www.veed.io/view/es-ES/fca82af2-0fa5-4d38-b86d-2b4d0c29e88b?panel=share)

---
## 👩‍💻 Autoría

Proyecto realizado por Natalia Navarro como parte del curso de Java.

---

¡Gracias por pasar por acá!.
