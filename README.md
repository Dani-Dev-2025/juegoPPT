# Piedra, Papel, Tijeras
### Implementación en Java con Swing

JuegoPPT es una implementación del clásico juego de **Piedra, Papel, Tijeras** desarrollado en Java con una interfaz gráfica **(GUI)** basada en Swing. Permite al usuario jugar contra la CPU, mostrando el resultado de cada ronda y el conteo de victorias en una ventana interactiva.

---

## Características

* Interfaz gráfica con botones para seleccionar las opciones (Piedra, Papel o Tijeras).
* Visualización clara de las elecciones del jugador y la CPU.
* Contador de rondas ganadas por el jugador y la CPU.
* Cuenta regresiva de 1.5 segundos antes de mostrar el resultado de cada jugada.
* Opción para iniciar una nueva partida en cualquier momento.

---

## Requisitos

* **Java Development Kit (JDK):** Versión 8 o superior.
* Un entorno de desarrollo integrado (IDE) como IntelliJ IDEA o Eclipse, o un compilador de Java.
* Imagen de fondo (`image1.png`) ubicada en la carpeta `resources/images/`.

---

## Instalación

1.  Clona el repositorio.
2.  Asegúrate de que la carpeta `resources/images/` contiene el archivo `image1.png`, ya que es necesario para la interfaz gráfica.
3.  Compila y ejecuta el proyecto desde tu IDE o usando la línea de comandos.

---

## Uso

1.  Al iniciar el programa, aparecerá una ventana con un mensaje de bienvenida.
2.  En la ventana principal:
    * Haz clic en los botones de Piedra, Papel o Tijeras para hacer tu elección.
    * Verás una cuenta regresiva antes de que se muestre el resultado.
    * Las áreas de texto te informarán sobre las elecciones, el resultado (victoria, derrota o empate) y el puntaje actual.
3.  Haz clic en el botón "Nueva Partida" para reiniciar el juego.

---

## Licencia

Este proyecto es **propietario** y todos los derechos están reservados. No se permite copiar, distribuir ni usar el código sin permiso explícito del autor.
Las contribuciones son bienvenidas a través de pull requests en GitHub, siempre y cuando se respeten los términos de la licencia.

---

## Autor

* **Daniel Pacheco** - cloudxdam@gmail.com

---

## Notas

* Asegúrate de que el archivo `image1.png` esté presente o el programa lanzará una `IOException`.

---
