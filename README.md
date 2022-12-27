# Reto Interseguro
## Tecnologia utilizado
Utilice [Spring Boot](https://spring.io/quickstart), con [Maiven](https://mvnrepository.com/) para gestion de dependencias.

### Dependencias utilizadas
1. [h2database](https://mvnrepository.com/artifact/com.h2database/h2/2.1.214)
2. [spring-boot-starter-data-jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/3.0.0)
3. [lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.24)
4. [springdoc-openapi-ui](https://springdoc.org/)
5. [junit](https://mvnrepository.com/artifact/junit/junit/4.13.2)

### Version de Spring Boot
v2.7.7

## Clonar el repositorio
```
git clone https://github.com/hidalgo27/intercorp.git
```

## Si se requiere, recargue Maiven
Si se usa un IDE como IntelliJ IDEA, click derecho en el archivo pom.xml > Maiven > Reload project

## Compilar y ejecutar en servidor local
#### Si se usa un IDE como IntelliJ IDEA
- click derecho en MatrixAmplication > Run "MatrixAmplication" o utilice los siguientes comandos:
#### Mac OS/Linux:
```
./mvnw spring-boot:run
```
#### Windows:
```
mvnw spring-boot:run
```
## Probar los servicios
- Si utilizamos la dependencia [springdoc-openapi](https://springdoc.org/) click [aquí](http://localhost:8080/swagger-ui/index.html), podemos utilizar los servicios creados: get (listar) y post (rota la matriz).
- Si se usa Postman:
    - Para rotar la matriz
      > POST: http://localhost:8080/matrix/

      Body: para rotar una matriz de NxN
        ```
        {
        "matriz" : [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
        }
        ```
    - Para listar matrices guardadas en base de datos:
      >GET: http://localhost:8080/matrix/
- Para poder ver la base de datos de H2
  >  http://localhost:8080/h2-console/
    - Driver Class: org.h2.Driver
    - JDBC URL: jdbc:h2:mem:testdb
    - User Name: sa
    - Password:
- Para hacer las pruebas unitarias con JUnit
  Ejecute el archivo [MatrixApplicationTests](https://github.com/hidalgo27/interseguro-matriz-back/blob/master/src/test/java/com/interseguro/matrix/MatrixApplicationTests.java)

## Estructura
- caseuse
- component
- controller
- dto
- entities
- repository
- service

## Algoritmo que rota una matriz NxN
- Para un adecuado funcionamiento del servicio primero se debe verificar que la matriz sea [cuadrada](https://economipedia.com/definiciones/matriz-cuadrada.html):
    - Se crea su dependencia en [MatrizDependency](https://github.com/hidalgo27/interseguro-matriz-back/blob/master/src/main/java/com/interseguro/matrix/component/MatrizDependency.java) metodo *matCuadrada* y el algoritmo se implementa en [MatrizImplement](https://github.com/hidalgo27/interseguro-matriz-back/blob/master/src/main/java/com/interseguro/matrix/component/MatrizImplement.java) metodo *matCuadrada*
- Luego rotamos la matriz para eso:
    - Se crea su dependencia en [MatrizDependency](https://github.com/hidalgo27/interseguro-matriz-back/blob/master/src/main/java/com/interseguro/matrix/component/MatrizDependency.java) metodo *mat* y el algoritmo se implementa en [MatrizImplement](https://github.com/hidalgo27/interseguro-matriz-back/blob/master/src/main/java/com/interseguro/matrix/component/MatrizImplement.java) metodo *mat*

## Controlador
- El controlador del servicio: [MatrizController](https://github.com/hidalgo27/interseguro-matriz-back/blob/master/src/main/java/com/interseguro/matrix/controller/MatrizController.java)


## Ejemplos
Ejercicio rota una matriz NxN en forma antihoraria (-90 grados). Ejemplos:

Matriz de 2x2
```
[[1,2],[3,4]]
```
Matriz de 3x3
```
[[1,2,3],[4,5,6],[7,8,9]]
```
Matriz de 4x4
```
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
