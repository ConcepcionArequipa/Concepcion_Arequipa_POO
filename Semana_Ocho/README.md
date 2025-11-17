Ejercicio 1: 

**Detalle del Trabajo Realizado**
Este proyecto implementa un sistema en Java para gestionar precios de casas y departamentos utilizando estructuras de datos dinámicas (ArrayList).
El programa funciona mediante un menú interactivo que permite: 

- Ingresar precios
- Listar todos los precios almacenados
- Mostrar el precio más alto y el más bajo
- Mostrar precios iguales
- Buscar un precio específico dentro de la colección

Se aplicaron conceptos como:
- Uso de ArrayList<Double>
- Validación de datos
- Menú con ciclos repetitivos
- Uso de métodos para modularizar el código
- Manejo de entrada de datos con Scanner
- Modelado UML básico

**Enunciado del Ejercicio**

Desarrollar un programa en Java que permita gestionar los precios de casas y departamentos usando colecciones.

Requerimientos principales: 

Utilizar un ArrayList<Double> para almacenar los precios.

Implementar un menú con las siguientes opciones:
- Opción 1: Ingresa un precio mayor que cero y lo agrega a la lista.

- Opción 2: Muestra todos los precios, o avisa si la lista está vacía.

- Opción 3: Calcula y muestra el precio más alto.

- Opción 4: Calcula y muestra el precio más bajo.

- Opción 5: Permite ingresar un valor y verifica si existen precios iguales.

- Opción 6: Permite buscar un precio utilizando contains().

- Opción 7: Finaliza el programa.

**Capturas del codigo:**

![img_18.png](img_18.png)

![img_19.png](img_19.png)

![img_20.png](img_20.png)

![img_21.png](img_21.png)

![img_22.png](img_22.png)

![img_23.png](img_23.png)

![img_24.png](img_24.png)


**Capturas del Resultado**

Opcion 1: Ingresar precio

![img_11.png](img_11.png)

Opcion 2: Mostrar todos los precios

![img_12.png](img_12.png)

Opcion 3: Mostrar el precio mas alto

![img_13.png](img_13.png)

Opcion 4: Mostrar el precio mas bajo

![img_14.png](img_14.png)

Opcion 5: Mostrar precios iguales

![img_15.png](img_15.png)

Opcion 6: Buscar precio

![img_16.png](img_16.png)

Opcion 7: Salir

![img_17.png](img_17.png)


Ejercicio 2: Sistema de registro de Olimpiadas

**Detalle del trabajo:**

En este ejercicio se desarrolló un sistema en Java para gestionar una Olimpiada, aplicando los conceptos principales de Programación Orientada a Objetos.

✔ Implementación realizada

- Clase abstracta Participante: contiene atributos base y un método abstracto mostrarTipo().

- Clases hijas Atleta y Equipo: heredan de Participante y sobrescriben el método abstracto para aplicar polimorfismo.

- Clase Evento: permite registrar participantes utilizando un ArrayList.

- Clase Olimpiada: almacena la información general y la lista de eventos registrados.

- Excepciones personalizadas: usadas para validar datos incorrectos (edad, número de integrantes, dorsal, cadenas vacías).

- Uso de ArrayList: para manejar listas dinámicas en participantes y eventos.

- Menú principal: permite registrar la olimpiada, crear eventos, agregar participantes y consultar información.

**Enunciado del trabajo:**

Desarrollar un sistema básico orientado a objetos para gestionar Olimpiadas, Eventos deportivos y Deportistas, aplicando:
Clases e instancias , Herencia , Composición , Uso de ArrayList , Manejo de excepciones (según requerimientos del trabajo) ,Representación UML.

El sistema debe permitir registrar deportistas, crear eventos, asignar deportistas a eventos y relacionar eventos dentro de una Olimpiada.

**Justificaciones Técnicas:**

¿Por qué se usa herencia?

Para reutilizar código, evitar duplicar atributos y modelar correctamente relaciones del mundo real (por ejemplo, si hubiera Deportista → Nadador, Corredor, etc.).

¿Por qué se usa composición?

Porque una Olimpiada contiene Eventos y un Evento contiene Deportistas.
Si la Olimpiada desaparece, sus eventos también; eso corresponde a composición en UML.

¿Por qué usar ArrayList en lugar de arreglos comunes?

Permite crecimiento dinámico, métodos útiles: add(), remove(), size() , se integra mejor con colecciones de Java y es más flexible para CRUD.

**Capturas del Código:**

Clase Abstracta: Participante

![img_3.png](img_3.png)

![img_4.png](img_4.png)

Subclase: Atleta
![img.png](img.png)

![img_1.png](img_1.png)

Subclase: Equipo

![img_2.png](img_2.png)

**Resultados del programa:**

Opcion 1: Crear evento

![img_5.png](img_5.png)

Opcion 2: Registrar Atleta

![img_6.png](img_6.png)

Opcion 3: Registrar equipo

![img_7.png](img_7.png)

Opcion 4: Mostrar eventos

![img_8.png](img_8.png)

Opcion 5: Mostrar participantes

![img_9.png](img_9.png)

Opcion 6: Salir

![img_10.png](img_10.png)