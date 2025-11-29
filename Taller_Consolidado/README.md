4. Ejercicio propuesto: Sistema — Elección de la Reina
de Quito

Detalle del trabajo realizado:

Creación de clases (POO)

Se creó la clase abstracta Candidata con atributos base (id, nombre, edad, distrito, puntajeJurado) y el método abstracto mostrarDetalles().

Se implementaron dos clases hijas:

- CandidataEstudiante (universidad, carrera)

- CandidataProfesional (profesión, añosExperiencia)

Ambas sobrescriben mostrarDetalles() usando polimorfismo.

- Excepción personalizada:

Se implementó DatoInvalidoException para validar: nombre vacío, edad inválida, puntajes fuera de rango, distrito vacío.

- Gestión con ArrayList

Se creó un ArrayList<Candidata> para: registrar, listar, buscar y filtrar candidatas.

Implementación de registro, edición y eliminación.

- Simulación de votación

Se creó una clase Voto y se manejaron votos con: ArrayList<Voto> o Map<Integer, Integer> para conteo.

Se implementó el cálculo de ganadora y desempate por puntaje del jurado.

- Menú en consola

Opciones implementadas:

1. Registrar candidata

2. Listar

3. Buscar

4. Filtrar

5. Votar / simular votación

6. Mostrar resultados

7. Salir

- Pruebas

Se registraron al menos 5 candidatas y se realizaron simulaciones completas de votación.

Enunciado:
Desarrollar un programa Java en consola para gestionar candidatas a la elección de la Reina de
Quito. El sistema debe permitir registrar candidatas, simular votaciones, mostrar resultados y
usar herencia, polimorfismo, excepciones personalizadas y ArrayList.

Captura del codigo:

Clase abstracta: Candidata
<img width="787" height="428" alt="image" src="https://github.com/user-attachments/assets/40209f2c-6ca3-4366-a6e0-4be155d5941e" />

<img width="818" height="380" alt="image" src="https://github.com/user-attachments/assets/27d901e9-abf7-4785-9a17-7b123289b7d7" />

<img width="757" height="134" alt="image" src="https://github.com/user-attachments/assets/006be11f-cdf0-4842-a6e5-5f5a1dacaa01" />

Clase hija: CandidataEstudiante

<img width="878" height="391" alt="image" src="https://github.com/user-attachments/assets/d1d644ae-472d-441a-9217-db6c0b69b484" />

<img width="389" height="129" alt="image" src="https://github.com/user-attachments/assets/e49d1431-57bd-485d-bda2-de557c5e5078" />

Clase hija: CandidataProfesional

<img width="890" height="374" alt="image" src="https://github.com/user-attachments/assets/bacc094f-5c7b-49b0-9fc6-a7dd99925de1" />

<img width="728" height="313" alt="image" src="https://github.com/user-attachments/assets/f3b319ef-f306-426a-9835-95676425a045" />

Clase: Concurso

<img width="727" height="403" alt="image" src="https://github.com/user-attachments/assets/a37c7451-0acb-4bd4-b9fa-32780e3b3d01" />

<img width="674" height="331" alt="image" src="https://github.com/user-attachments/assets/051e89d2-5342-4d21-abc5-93c6a5bbbd29" />

<img width="626" height="379" alt="image" src="https://github.com/user-attachments/assets/f646d33b-9484-4c61-9973-b42f2d8d639a" />

<img width="607" height="323" alt="image" src="https://github.com/user-attachments/assets/fd567b0c-0087-497f-9156-5e797ae8d85b" />

<img width="532" height="406" alt="image" src="https://github.com/user-attachments/assets/f87d660d-be06-4e5e-a2b2-060b3c0be8f3" />

<img width="550" height="408" alt="image" src="https://github.com/user-attachments/assets/93b1bcbc-48c3-4175-b728-ddbc29facc46" />

<img width="514" height="380" alt="image" src="https://github.com/user-attachments/assets/1a4e126a-735e-403e-8b16-5784fa1b976e" />

Clase: Voto

<img width="629" height="397" alt="image" src="https://github.com/user-attachments/assets/95518407-20b7-4a81-9216-8fd8faccfe6c" />

Excepcion Personalizada:

<img width="515" height="137" alt="image" src="https://github.com/user-attachments/assets/0c2ab352-ddc7-4d8f-87f3-08aedce86010" />

Main:

<img width="638" height="434" alt="image" src="https://github.com/user-attachments/assets/b219d5c7-2853-41ec-ab42-0266ff107a39" />

<img width="521" height="385" alt="image" src="https://github.com/user-attachments/assets/8521bf08-dc40-40a8-995f-3562a8b69b32" />

Resultado:

<img width="677" height="365" alt="image" src="https://github.com/user-attachments/assets/3c52c632-ab2f-431e-ae5f-0823d1490a18" />

<img width="692" height="344" alt="image" src="https://github.com/user-attachments/assets/7e237120-8b07-4af1-a514-5c223ab2d2da" />

<img width="683" height="371" alt="image" src="https://github.com/user-attachments/assets/004e265f-c229-4b7f-83a2-10bdb6a087db" />

<img width="481" height="263" alt="image" src="https://github.com/user-attachments/assets/aa73db8a-ac58-42ef-bae7-930c92b14010" />

<img width="699" height="239" alt="image" src="https://github.com/user-attachments/assets/bd00d4c8-f7f2-41c9-a093-1c696fce2462" />

<img width="492" height="359" alt="image" src="https://github.com/user-attachments/assets/6c7217e6-b656-41ee-af1e-086c2317223a" />

<img width="702" height="232" alt="image" src="https://github.com/user-attachments/assets/246949f6-bf58-4d20-bd42-063567b2d1a3" />

<img width="415" height="295" alt="image" src="https://github.com/user-attachments/assets/ce33f233-de6a-442d-bb77-038abb8e025a" />

<img width="350" height="280" alt="image" src="https://github.com/user-attachments/assets/f3f07da5-34be-460e-8fc3-f6f6d1e3cdf9" />

<img width="578" height="369" alt="image" src="https://github.com/user-attachments/assets/e3e46695-c015-4037-8194-69eaa2df0dac" />

<img width="425" height="335" alt="image" src="https://github.com/user-attachments/assets/48cdfbf3-9ee6-4af6-ab1f-209eb124deb9" />

<img width="379" height="228" alt="image" src="https://github.com/user-attachments/assets/5b0178b6-5822-47fd-83e7-e33cdc57bdf7" />

<img width="334" height="231" alt="image" src="https://github.com/user-attachments/assets/4168cd06-12f5-44d7-835b-503688717646" />
