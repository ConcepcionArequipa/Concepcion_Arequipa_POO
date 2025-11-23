Nombre: Concepcion Arequipa

****Ejercicio 1: SISTEMA DE REGISTRO DE JUEGOS****

**_Explicacion del trabajo:_**

Se desarrolló un sistema en Java para registrar y gestionar videojuegos, enfocado en juegos de tipo MarioBros y CarreraVehiculos. El sistema combina conceptos de programación orientada a objetos (POO), herencia, polimorfismo, colecciones dinámicas y manejo de excepciones, logrando un programa funcional, organizado y seguro.

_Estructura del Sistema_ 

**_**Clase abstracta Juego:**_**
Define los atributos generales de cualquier juego: nombre, precio y año de lanzamiento. Contiene un método abstracto mostrarDetallesJuego(), que obliga a las subclases a implementar su propia forma de mostrar información, y un toString() para mostrar los datos básicos.

_**Subclase MarioBros:**_
Hereda de Juego e incluye atributos específicos: personaje principal, número de mundos y número de niveles. Sobrescribe mostrarDetallesJuego() para mostrar tanto los datos generales como los propios de los juegos de Mario, aplicando polimorfismo.

**_Subclase CarreraVehiculos:_**
Hereda de Juego e incluye atributos específicos: tipo y color del vehículo, cantidad de circuitos y número de vueltas. Sobrescribe mostrarDetallesJuego() para mostrar información detallada de las carreras.

**_Excepción personalizada DatoInvalidoException:_**
Controla entradas inválidas, como nombres vacíos, precios negativos o valores fuera de rango, evitando que el programa se bloquee y mostrando mensajes claros al usuario.

**_Clase principal MainJuegos:_**
Contiene un menú de consola interactivo, permitiendo:

- Registrar juegos de Mario o carreras con validación de datos.

- Mostrar todos los juegos registrados.

- Buscar juegos por nombre.

- Filtrar juegos por tipo.

_Funcionalidades Clave_

- Registro de juegos con validaciones específicas (precio > 0, número de mundos y niveles dentro de rangos, cantidad de circuitos y vueltas válidas, etc.).

- Almacenamiento dinámico usando ArrayList<Juego>.

- Visualización de detalles mediante polimorfismo, diferenciando la información de Mario y Carrera.

- Búsqueda y filtrado de juegos por nombre o tipo.

- Manejo de errores con mensajes claros mediante DatoInvalidoException y control de excepciones generales.

_Validaciones Implementadas_

- Textos no vacíos (nombre, personaje principal, tipo y color del vehículo).

- Precios mayores a cero.

- Años de lanzamiento entre 1950 y 2025.

- Número de mundos entre 0 y 8 y niveles entre 0 y 32.

- Cantidad de circuitos entre 0 y 20, y número de vueltas entre 0 y 10.

_Conclusión_

El sistema demuestra un uso completo de POO, herencia, polimorfismo, colecciones y manejo de excepciones, logrando un programa confiable y escalable. La implementación permite agregar nuevos tipos de juegos o funcionalidades fácilmente en el futuro, y su interfaz de consola es clara e intuitiva para el usuario.

Capturas del codigo:

Clase abstracta: Juego

![img_20.png](img_20.png)

Clase hija: MarioBros

![img_21.png](img_21.png)

Clase hija: CarreraVehiculos

![img_22.png](img_22.png)

![img_23.png](img_23.png)

Clase: DatoInvalidoException

![img_24.png](img_24.png)

Clase: MainJuegos

![img_25.png](img_25.png)

![img_26.png](img_26.png)

![img_27.png](img_27.png)

![img_28.png](img_28.png)

![img_29.png](img_29.png)

![img_30.png](img_30.png)

![img_31.png](img_31.png)

![img_32.png](img_32.png)

![img_33.png](img_33.png)

![img_34.png](img_34.png)

_Capturas de la ejecucion del programa:_

![img_35.png](img_35.png)

![img_36.png](img_36.png)

![img_37.png](img_37.png)

![img_38.png](img_38.png)

![img_39.png](img_39.png)

![img_40.png](img_40.png)


**Ejercicio 2:** 

_Explicacion del trabajo:_

El sistema se fundamenta en la Programación Orientada a Objetos (POO). Se implementa el Encapsulamiento declarando atributos como private en la clase base Dispositivo, controlando su modificación únicamente a través de setters. Esta técnica es vital, ya que los setters y el constructor aplican validaciones con la excepción personalizada DatoInvalidoException, asegurando que el estado del objeto (ej., precio positivo) sea siempre válido desde su creación. La Herencia se establece al extender las clases Laptop y Telefono de Dispositivo, permitiendo la reutilización de código y la adición de atributos especializados. Finalmente, se aplica el Polimorfismo al sobrescribir el método mostrarInfo() en cada clase hija. Este enfoque permite que el ArrayList, aunque declarado para almacenar el tipo genérico Dispositivo, ejecute la versión específica del método (Laptop o Telefono) durante la iteración en tiempo de ejecución, demostrando un acoplamiento flexible y eficiente.

_Capturas del codigo:_

Clase Padre: Dispositivo

![img.png](img.png)

![img_1.png](img_1.png)

![img_2.png](img_2.png)

Clase: DatoInvalidoException

![img_15.png](img_15.png)


Clase hija: Laptop

![img_3.png](img_3.png)

![img_4.png](img_4.png)

![img_5.png](img_5.png)

Clase hija: Telefono

![img_6.png](img_6.png)

![img_7.png](img_7.png)

Main:

![img_8.png](img_8.png)

![img_9.png](img_9.png)

![img_10.png](img_10.png)

![img_11.png](img_11.png)

![img_12.png](img_12.png)

![img_13.png](img_13.png)

![img_14.png](img_14.png)

_Capturas de la ejecucion del programa:_

![img_16.png](img_16.png)

![img_17.png](img_17.png)

![img_18.png](img_18.png)

![img_19.png](img_19.png)


