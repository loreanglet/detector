# detector
Para ejecutar el detector lo que se tiene que hacer es levantar en un apache tomcat 10 para correr local, una vez levantado se le asigna el proyecto al servidor para que corra dentro. 
Una vez corrida la app para llamar a la accion del detector, se debe generar un request POST apuntando al url asignado localmente agreagandole /webapi/magneto/isMutant al final

Ej de request 

POST http://localhost:8081/detector/webapi/magneto/isMutant

Body 
type Json
{
    "dna":["AAAATG","TTAAAG","GGGTTC","TTGGGC","AAATTG","TTAAAG"]
}
