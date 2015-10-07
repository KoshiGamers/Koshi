
:Seteamos el path
set path=C:\oracle\product\11.2.0\client_1\jdk\bin;%path%


:Compilamos los archivos .java
javac Modelo\*.java
javac Controlador\*.java
javac -classpath C:\temp\koshi-mvc - copia\src\.xpp3_min-1.1.4c.jar;C:\temp\koshi-mvc - copia\src\.xstream-1.4.8.jar Vista\*.java
javac Principal.java

:Se crea el .jar con Modelo y Controlador
jar cvf MyC.jar Modelo\*.class Controlador\*.class

:Se crea el manifesto del .jar ejecutable referenciando al .jar anterior
echo Manifest-Version: 1.0>manifest.txt
echo Main-Class: Principal>>manifest.txt
echo Class-Path: MyC.jar>>manifest.txt

:Se crea el .jar ejecutable con el paquete Vista , la clase Principal y el manifesto
jar -cvfm Ejecutable.jar manifest.txt Vista\*.class Principal.class
