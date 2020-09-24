# LAB 5 AREP Docker & AWS

Este Laboratorio el desarrollo de un servicio web de acuerdo a las especificacione dadas en clase, con balanceadores de carga
servicio de bases de datos a partir de docker y montado en una maquina virtual ec2 de Amazon web Service

## requsites
    -java version 1.7+
    -maven installed
	-Docker
	-mongoDB
	
#Instalacion 

	 ```sh
		$ git clone https://github.com/danielGomez1703/arepLab5
		$ cd arepLab5
		$ docker-compose up -d
	
	```

# Manual

	si lo vamos a usar con el despliegue de aws debe ir al siguiente link:
	
		http://ec2-34-226-211-147.compute-1.amazonaws.com:8091/messages
		
alli podremos observar una pagina basica donde podemos enviar un mensaje y se encolara en la tabla
	
![ev1](https://github.com/danielGomez1703/arepLab5/blob/master/resources/ev1.JPG)
		
la tabla  muestra los ultimos 10 mensajes
		
![ev2](https://github.com/danielGomez1703/arepLab5/blob/master/resources/ev2.JPG)
		
aqui podemos ver todos los datos que hay dentro de la base de datos.
	
![ev3](https://github.com/danielGomez1703/arepLab5/blob/master/resources/ev3.JPG)
	
por ultimo la evidencia del docker Local funcionando

![ev4](https://github.com/danielGomez1703/arepLab5/blob/master/resources/ev4.JPG)
		
y el docker en AWS 
	
![ev5](https://github.com/danielGomez1703/arepLab5/blob/master/resources/EV5.JPG)

# Descripcion
Para consultar el documento [vaya a este link](https://github.com/danielGomez1703/arepLab5/blob/master/resources/DockerAWS.pdf)

el objetivo es tener un sistema en la nube que nos sirva para un servicio stateless,  aqui nos enfocamos en los balancedores de carga y en la base de datos en este caso MONGO
# Documento Estructura y Diseño

## Author
    Daniel Felipe Gomez Suarez ![danielGomez1703](https://github.com/danielGomez1703)
    
## BUILT IN
   Proyecto construido en [Maven](https://maven.apache.org/)
## License
----
para consultar su licencia vaya al link 
[leer aqui](https://github.com/danielGomez1703/ARSW-Primer/blob/master/LICENSE.txt)