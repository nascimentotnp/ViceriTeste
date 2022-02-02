# ViceriTeste
Teste técnico Viceri
Projeto criado para realizar gestão de tarefas (TO-DO) através de uma API Rest.
Será possivel, realizar inclusão, exclusão, alteração ou listagem de todos as tarefas mantidas pelo usuário locado no sistema. Sendo possivel ainda, classifica-las e filtra-las
pela sua prioridade.

## Tecnologias utilizadas

``` 
Java 11
Spring Boot (Security, Data e Swagger)
Maven (Gerenciador de dependencias)
H2 (Banco de dados em memoria)

```


## Executar:

Para executar o projeto foi utilizado a IDE Eclipse, clicando com o botão direito no arquivo localizado em  src/main/java/br/com/viceri/ViceriThiagoApplication.java opção  "Run as" clicar em "Java Application".


## Deploy:

Caso queira realizar a compilação do projeto para subir em um servidor, rode o comando 

```
mvn clean install package
```

Esse comando ira compilar um arquivo .jar na pasta /target ao qual pode ser utilizado para subir em um servidor web com o comando:

```
java -jar testeTecnico-0.0.1-SNAPSHOT.jar
```




