# AgroConecta

AgroConecta es una plataforma diseñada para apoyar a pequeños productores agrícolas, facilitando la comercialización de sus cosechas y conectándolos directamente con consumidores, restaurantes y mercados. El sistema permite gestionar usuarios, productores, cultivos, productos y pedidos.

## Integrantes del equipo
* Zahid Serna Cebrero
* Yerik Ian Lugo Vasquez
* Andrey Edryhu Trujillo Gonzalez

## Módulos y Endpoints
El sistema cuenta con los siguientes 5 módulos principales (todos con soporte para `GET`, `GET /{id}` y `POST`):
* **Usuarios:** `/api/usuarios`
* **Productores:** `/api/productores`
* **Cultivos:** `/api/cultivos`
* **Productos:** `/api/productos`
* **Pedidos:** `/api/pedidos`

Además, cuenta con endpoints de salud para verificar el estado de la aplicación y la base de datos:
* `GET /api/health` -> Retorna OK.
* `GET /api/health/db` -> Verifica la conexión con la base de datos Neon.

## Estructuras de Datos Utilizadas
Para cumplir con los requisitos de la materia, se implementaron dos estructuras de datos:
1. **Lista Ligada Propia (`MiListaLigada`):** Implementada con nodos. Se utiliza para almacenar los datos de los módulos de *Usuarios*, *Productores*, *Cultivos* y *Productos*. Incluye un método `toList()` para que Spring pueda convertirla a JSON.
2. **Cola (`Queue`):** Implementada con `java.util.LinkedList`. Se utiliza en el módulo de *Pedidos* para manejar el flujo de los pedidos entrantes.

## Cómo correr el proyecto
1. Asegúrate de tener configurado el archivo `.env` en la raíz del proyecto con las credenciales de la base de datos (`DB_URL`, `DB_USER`, `DB_PASSWORD`). Puedes basarte en el archivo `.env.example`.
2. Abre la terminal en la raíz del proyecto y ejecuta:
   ```bash
   ./gradlew bootRun