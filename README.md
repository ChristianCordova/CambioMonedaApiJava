# CambioMonedaApiJava

Se realizó API (CRUD) para cambio de moneda, se trabajó en local con conexión a POSTGRESQL por lo que será necesario tenerlo instalado y cambiar los siguientes valores de conexión:

Archivo: "aplication.properties"

spring.datasource.url=jdbc:postgresql://localhost:5432/postgres spring.datasource.username=postgres spring.datasource.password=1234

Se trabajó sobre la siguiente ruta:

API: http://localhost:8080/api/moneda/

POST*************** API: CREATE

Genera correlativos, donde el 1 es para Soles y el 2 es para Dolares.

http://localhost:8080/api/moneda/registrar/

Input Postman: { "tipocambio": 3.5 }

Input Postman: { "tipocambio": 2.5 }

GET*************** API: READ

Obtiene todos los registros almancenados.

http://localhost:8080/api/moneda/consultar/

Output Postman: [ { "cod_moneda": 1, "tipocambio": 3.5 }, { "cod_moneda": 2, "tipocambio": 2.5 } ]

GET*************** API: READ (BUSQUEDA)

Obtiene tipo de cambio por moneda, donde 1 es Soles y 2 es Dolares.

http://localhost:8080/api/moneda/buscar/2

Output Postman: { "cod_moneda": 2, "tipocambio": 2.5 }

PUT*************** API: UPDATE

Actualiza el tipo de cambio para el tipo de moneda, donde 1 es Soles y 2 es Dolares.

http://localhost:8080/api/moneda/actualizar/1

Input Postman: { "tipocambio": 3.7 }

Output Postman: { "cod_moneda": 1, "tipocambio": 3.7 }

DELETE*************** API: DELETE

Elimina el tipo de cambio para el tipo de moneda, donde 1 es Soles y 2 es Dolares.

http://localhost:8080/api/moneda/eliminar/

Input Postman: { "cod_moneda" : 1 }
