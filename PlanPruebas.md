# Plan de Pruebas de Software (IEEE 829)
**Proyecto:** “inspira-T” — Ejecutable de Escritorio para la Preservación del Patrimonio Cultural  
**Versión del Documento:** 1.0  
**Tecnología Base:** Java (Desktop Application)  
**Fase del Proyecto:** Corto Plazo (Pruebas y Correcciones)  
**Fecha:** Agosto 2026  

---

## Resumen Ejecutivo
El presente documento establece la estrategia, alcance, entorno y casos de prueba detallados para la verificación y validación del ejecutable de escritorio **"inspira-T"**. El sistema tiene como propósito conectar a portadores de conocimientos ancestrales mexicanos con aprendientes mediante recursos audiovisuales y transmisiones en vivo, garantizando una interfaz accesible, una base de datos robusta y una navegación fluida en Java.

---

## 1. Alcance y Objetivos de las Pruebas

El plan cubre las funcionalidades del ejecutable de escritorio desarrolladas en el alcance de corto plazo (0 a 6 meses), alineadas con la metodología Design Thinking y el cronograma del proyecto.

### 1.1 Módulos Incluidos en el Alcance
* **Módulo de Autenticación y Registro:** Creación de cuenta, login, validación de credenciales y asignación de roles.
* **Módulo de Perfiles de Usuario:** Gestión de perfiles diferenciados para Instructores (artesanos, sabios) y Aprendientes.
* **Módulo de Navegación e Interfaz:** Flujo de pantallas en Java, menús, categorización e interacción con prototipos UI/UX.
* **Módulo de Base de Datos:** Operaciones CRUD, persistencia del modelo E-R/Relacional y almacenamiento categorizado.
* **Módulo Multimedia (Cápsulas/Videos):** Carga, reproducción y clasificación de contenidos culturales.

### 1.2 Exclusiones (Fuera del Alcance Actual)
* Integración de Pasarela de Pagos (Previsto para Mediano Plazo: 6–12 meses).
* Sistema de Suscripciones y Monetización.
* Módulo de Inteligencia Artificial (IA) y Recomendaciones.
* Traducción automática a lenguas indígenas (Previsto para Largo Plazo: 12–24 meses).
* Certificaciones digitales de aprendizaje.

---

## 2. Estrategia y Tipos de Pruebas

Se aplicará un enfoque de pruebas multinivel para garantizar tanto el cumplimiento técnico como la usabilidad por parte de adultos mayores y comunidades tradicionales:

| Tipo de Prueba | Objetivo Principal | Herramientas / Técnica | Criterio de Éxito |
| :--- | :--- | :--- | :--- |
| **Pruebas Unitarias** | Verificar métodos, controladores Java y conexiones DB de forma aislada. | JUnit 5 / Mockito | 100% métodos críticos aprobados |
| **Pruebas de Integración** | Validar comunicación entre interfaces Java y el SGBD Relacional. | JDBC Test / In-Memory DB | Cero fallos de persistencia |
| **Pruebas Funcionales (Caja Negra)** | Validar casos de uso: Registro, login, filtrado por categorías culturales. | Manual / Test scripts | 100% Flujos OK |
| **Pruebas de Usabilidad e Inclusión** | Evaluar accesibilidad para instructores (fácil lectura, botones claros). | Evaluación Heurística / Testing con usuarios | SUS Score > 85/100 |
| **Pruebas de Rendimiento** | Verificar consumo de RAM/CPU del ejecutable en equipos convencionales. | JProfiler / VisualVM | RAM < 350MB, CPU < 15% |

---

## 3. Entorno de Pruebas Requerido

* **Sistema Operativo:** Windows 10/11 (64-bit), macOS Monterey/Ventura, Linux Ubuntu 22.04 LTS (por ser ejecutable de escritorio multiplataforma Java).
* **Entorno de Ejecución:** Java Development Kit (JDK) 17+ / Java Runtime Environment (JRE).
* **Base de Datos:** MySQL / PostgreSQL local o servidor de pruebas dedicado.
* **Dispositivos de Prueba:** Laptops y PCs de escritorio con resoluciones 1366x768 (estándar) y 1920x1080 (Full HD).

---

## 4. Casos de Prueba Detallados (Test Cases)

### 4.1 Módulo: Registro y Gestión de Perfiles

| ID Caso | Descripción del Test | Pasos de Ejecución | Resultado Esperado | Prioridad |
| :---: | :--- | :--- | :--- | :---: |
| **CP-REG-01** | Registro exitoso de Instructor Cultural (Artesano/Sabio). | 1. Abrir app Java.<br>2. Clic en "Registrarse".<br>3. Seleccionar rol "Instructor".<br>4. Llenar saberes (ej. Medicina Tradicional).<br>5. Guardar. | Usuario creado en BD Relacional, perfil guardado con rol 'Instructor' y redirección al panel principal. | **ALTA** |
| **CP-REG-02** | Registro exitoso de Aprendiente. | 1. Seleccionar rol "Aprendiente".<br>2. Ingresar datos personales e intereses culturales.<br>3. Confirmar. | Registro correcto, asignación de perfil 'Aprendiente' sin campos de especialidad requeridos. | **ALTA** |
| **CP-REG-03** | Validación de campos obligatorios en registro. | 1. Dejar campos en blanco.<br>2. Clic en "Registrar". | El ejecutable muestra alerta clara de error resaltando campos requeridos sin congelar la app. | **MEDIA** |

### 4.2 Módulo: Clasificación y Catálogo de Contenidos Culturales

| ID Caso | Descripción del Test | Pasos de Ejecución | Resultado Esperado | Prioridad |
| :---: | :--- | :--- | :--- | :---: |
| **CP-CAT-01** | Filtrado por categorías de conocimiento ancestral. | 1. Ir a catálogo.<br>2. Seleccionar categoría "Gastronomía Ancestral" o "Lenguas Indígenas". | La interfaz actualiza la lista mostrando únicamente recursos etiquetados con dicha categoría. | **ALTA** |
| **CP-CAT-02** | Búsqueda directa de saberes o tutoriales. | 1. Ingresar "Tejido" en la barra de búsqueda.<br>2. Presionar Enter. | Muestra coincidencia exacta y parcial con cápsulas multimedia registradas en la BD. | **MEDIA** |

### 4.3 Módulo: Publicación y Visualización de Recursos Audiovisuales

| ID Caso | Descripción del Test | Pasos de Ejecución | Resultado Esperado | Prioridad |
| :---: | :--- | :--- | :--- | :---: |
| **CP-MED-01** | Carga de cápsula de video por Instructor. | 1. Iniciar sesión como Instructor.<br>2. Clic en "Subir Contenido".<br>3. Adjuntar video/tutorial y categorizar.<br>4. Publicar. | Video/Cápsula registrada en BD, metadata almacenada correctamente y visible en el catálogo general. | **ALTA** |
| **CP-MED-02** | Reproducción de cápsula por Aprendiente. | 1. Seleccionar cápsula de "Herbolaria".<br>2. Presionar "Reproducir". | Reproductor integrado en la interfaz Java reproduce video de forma fluida sin desfasar audio/video. | **ALTA** |

### 4.4 Módulo: Navegación, Interfaz e Inclusión (Usabilidad)

| ID Caso | Descripción del Test | Pasos de Ejecución | Resultado Esperado | Prioridad |
| :---: | :--- | :--- | :--- | :---: |
| **CP-NAV-01** | Flujo completo de navegación entre pantallas Java. | Navegar: Inicio -> Perfil -> Catálogo -> Detalle Curso -> Inicio. | Transición fluida sin fugas de memoria, ventanas emergentes no deseadas ni bloqueos de pantalla. | **MEDIA** |
| **CP-USA-01** | Prueba de Accesibilidad Visual para Adultos Mayores. | Verificar tamaño de fuente, contraste de botones e íconos descriptivos. | Los textos son legibles (mínimo 12pt UI), botones amplios y leyendas claras para usuarios no nativos digitales. | **ALTA** |

---

## 5. Criterios de Aceptación y Suspensión

### 5.1 Criterios de Éxito / Aceptación
* 100% de los Casos de Prueba con prioridad **ALTA** ejecutados y aprobados.
* Mínimo 90% de aprobación en Casos de Prueba con prioridad **MEDIA/BAJA**.
* Cero (0) defectos de severidad Bloqueante o Crítica sin resolver en el ejecutable Java.
* Verificación completa de integridad referencial en la Base de Datos Relacional.

### 5.2 Criterios de Suspensión y Reanudación
* **Suspensión:** Si el ejecutable se cierra inesperadamente (*crash* / `Exception` Java) en más del 20% de las pruebas iniciales.
* **Suspensión:** Si la Base de Datos no permite la conexión o corrompe registros de usuarios.
* **Reanudación:** Una vez entregada una *build* corregida mediante el repositorio de control de versiones (Git).

---

## 6. Entregables del Proceso de Pruebas

1. **Documento de Plan de Pruebas** (El presente informe).
2. **Matriz de Trazabilidad de Requisitos vs. Casos de Prueba.**
3. **Reporte de Fallos y Defectos Registrados** (*Bug Tracking Report*).
4. **Informe Final de Aceptación y Calidad del Software para Liberación.**

}