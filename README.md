# SERVER-MANAGER-BACK-END
## O projeto tem como propósito ser um gerenciador de servidores.
<div>
    <div style="display: inline_block"><br>
    <img align="center" alt="Diego-Java" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
    <img align="center" alt="Diego-Spring" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
    <img align="center" alt="Diego-Angularjs" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/angularjs/angularjs-plain.svg">
    <img align="center" alt="Diego-ts" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/typescript/typescript-plain.svg">
    <img align="center" alt="Rafa-CSS" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-plain.svg">
    <img align="center" alt="Rafa-Html5" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-plain.svg">
 </div>
 
![ezgif com-gif-maker](https://user-images.githubusercontent.com/83510729/156898781-96dcab1c-789d-4849-8a80-4fc9546c1724.gif)


###  link front end do projeto:
 [https://github.com/DiegoCardosoDev/SERVER-MANAGER-FRONT-END](https://github.com/DiegoCardosoDev/SERVER-MANAGER-FRONT-END)  


   ### TECNOLOGIAS USADAS:
  * [JAVA 17](https://www.azul.com/downloads/)  
  * [SPRING](https://start.spring.io/)
  * [MAVEN]( https://mvnrepository.com/)
  * [H2 DATABASE]( https://www.h2database.com/html/main.html)
  * [MYSQL ](  https://www.mysql.com/downloads/)
  * [INTELLIJ IDEA ](  https://www.jetbrains.com/pt-br/idea/)
  
 
#### para testar as requisições http usei o [POSTMAN  ](https://www.postman.com/downloads/)

### funcionalidades e regras:
  #### criar um servidor
  * Para criar um servidor deve se inserir um endereço de ip,
  * seu nome,e tipo, se o ip ja existir no cadastro o sistema impedirá a inserção do mesmo.
  * E status SERVER_UP ou SERVER_DOWN
  * o id e imagem são ATRIBUIDOS automaticamente pelo sistema.

### formato do Json:
```
{
    "ipAndress": "192.168.15.1",
    "name": " Linux",
    "memory": "16Gb",
    "type": "Personal",
    "status": "SERVER_UP"
}
```
  ```
  localhost://8080/server/save
  ```


### pingar um servidor
 * para pingar o servidor deve se indicar o  existente

#### exemplo:
  
  ```
  localhost://8080/server/ping/192.168.15.1
  ```
###  deletar um servidor
 * para deletera o servidor dseve se indicar seu id de cadastro.

#### exemplo:
  ```
  localhost://8080/server/delete/1
  ```
  
  ###  procurar servidor por id
 * para procurar um servidor por id inca o id no  path:

#### exemplo:
  ```
  localhost://8080/server/get/1
  ```
  
  
  ### Listar todos servidores
 * para listar todos 

#### exemplo:
  ```
  localhost://8080/server/list
  ```
 
  ### FRONT END: 
  ![Screenshot_20220305_152532](https://user-images.githubusercontent.com/83510729/156895665-7112a715-5b29-416a-baa5-87006f0f6177.png)
  
  ### EXECUTAR O PROJETO
  
  #### clonar o front e back-end
  ### front
  
  ```
  git clone https://github.com/DiegoCardosoDev/SERVER-MANAGER-FRONT-END
  ```
  ### BACK END
  
  ```
  git clone https://github.com/DiegoCardosoDev/SERVER-MANAGER-BACK-END
  ```
  ### EXECUTAR O FRONT END NO TERMINAL DO VS CODE
   ```
     ng serve
  ```
  
  #### BACK-END:
  ![Screenshot_20220305_153049](https://user-images.githubusercontent.com/83510729/156896931-bec1b851-a03f-4009-a7ac-2125b011f54c.png)
    
  


  
  



  





