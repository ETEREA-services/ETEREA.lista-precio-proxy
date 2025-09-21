# ETEREA Lista Precio Proxy

[![Java](https://img.shields.io/badge/Java-24-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.0.0-green)](https://spring.io/projects/spring-cloud)
[![Maven](https://img.shields.io/badge/Maven-3.9.9-blue)](https://maven.apache.org/)

Version: 0.0.1

## Descripción

Este proyecto es un microservicio desarrollado con Spring Boot que actúa como proxy para la gestión de listas de precios. Proporciona APIs RESTful para acceder y gestionar artículos (artículos) y rubros, con soporte para paginación y enlaces HATEOAS.

Para documentación detallada, incluyendo diagramas de arquitectura, estadísticas del proyecto y más, visita nuestro [sitio de documentación](https://[owner].github.io/[repo]/).

## Características

- **Endpoints RESTful**: APIs para consultar artículos y rubros publicados.
- **Paginación**: Soporte para paginación en consultas de artículos.
- **HATEOAS**: Enlaces hipermedia para navegación entre recursos.
- **Descubrimiento de Servicios**: Integración con Consul para registro y descubrimiento de servicios.
- **Documentación Automática**: Generación de documentación OpenAPI con Swagger UI.
- **Cliente Feign**: Comunicación con servicios backend mediante Feign clients.

## Tecnologías Utilizadas

- **Java 24**: Lenguaje de programación principal.
- **Spring Boot 3.5.6**: Framework para desarrollo de aplicaciones Java.
- **Spring Cloud 2025.0.0**: Para microservicios y descubrimiento de servicios.
- **Spring Web**: Para crear APIs REST.
- **Spring Cloud OpenFeign**: Para llamadas a servicios remotos.
- **Spring HATEOAS**: Para enlaces hipermedia.
- **SpringDoc OpenAPI**: Para documentación automática de APIs.
- **Lombok**: Para reducir código boilerplate.
- **Maven**: Herramienta de construcción y gestión de dependencias.
- **Docker**: Para contenerización de la aplicación.

## Instalación

### Prerrequisitos

- Java 24
- Maven 3.9+
- Docker (opcional, para ejecución en contenedor)

### Construcción

1. Clona el repositorio:
   ```bash
   git clone <repository-url>
   cd eterea.lista-precio-proxy
   ```

2. Construye el proyecto:
   ```bash
   mvn clean package
   ```

### Ejecución

#### Con Maven
```bash
mvn spring-boot:run
```

#### Con Docker
```bash
docker build -t eterea/lista-precio-proxy .
docker run -p 8080:8080 eterea/lista-precio-proxy
```

## Uso

La aplicación expone los siguientes endpoints principales:

- `GET /api/lista/precio/articuloListaPrecio/page`: Lista artículos publicados con paginación.
- `GET /api/lista/precio/articuloListaPrecio/{articuloId}`: Obtiene un artículo por ID.
- `GET /api/lista/precio/articuloListaPrecio/rubro/{rubroId}/page`: Lista artículos por rubro con paginación.
- `GET /api/lista/precio/rubroListaPrecio/`: Lista todos los rubros.
- `GET /api/lista/precio/rubroListaPrecio/{rubroId}`: Obtiene un rubro por ID.
- `POST /api/lista/precio/rubroListaPrecio/`: Agrega o actualiza un rubro.

### Configuración

La aplicación se configura mediante `bootstrap.yml` y variables de entorno:

- `APP_PORT`: Puerto del servidor (default: 8080)
- `APP_CONSUL_HOST`: Host de Consul (default: consul-service)
- `APP_CONSUL_PORT`: Puerto de Consul (default: 8500)

## Documentación de la API

Accede a la documentación interactiva de la API en: `http://localhost:8080/swagger-ui.html`

## Contribución

1. Fork el proyecto.
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`).
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`).
4. Push a la rama (`git push origin feature/AmazingFeature`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## Contacto

Para preguntas o soporte, contacta al equipo de desarrollo.
