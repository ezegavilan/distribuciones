
# Distribuciones Uniforme AB - Normal - Exponencial Negativa - Poisson
Este proyecto contiene la lógica de negocio y el componente WEB para el TP3 de Simulación: Generar distribuciones (uniforme ab, normal, exp. negativa y poisson).

## Run
El proyecto utiliza la librería de Histograma que se puede descargar en **ezegavilan/histograma-lib**.
Necesitas instalar la librería para poder usarla de forma local en este proyecto

````bash
git clone https://github.com/ezegavilan/histograma-lib.git
cd historama-lib
mvn clean install
````

Cuando se generen los paquetes de **distribuciones** (mvn clean package) se compilará también
la librería **histograma-lib**.

Finalmente:
````bash
mvn spring-boot:run
````

La aplicación Web se ejecuta en el puerto **8080**.