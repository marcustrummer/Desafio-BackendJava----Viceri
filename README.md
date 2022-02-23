## Sobre a API 🖥️



### Como rodar 🎡

```
Requisitos

Para conseguir rodar o projeto, você precisa ter instalado em sua máquina:

• Java 11
• JUnit 5
• Maven


Passo a passo

#1
1. Clone o projeto na sua máquina
2. Abra a pasta do projeto na IDE de sua preferência
3. Abra o pacote 
4. Rode a aplicação.


#2
Caso você prefira algo mais prático realizei o deploy via heroku e é possível testá-la no link a seguir
[https://todotaskviceri.herokuapp.com/swagger-ui/#/]

```



### Documentação do projeto 📁

```
1. Para ter acesso a documentação da aplicação, visite o repositório [https://github.com/marcustrummer/Documentacao--Capgemini]
```



### Tecnologias utilizadas 👨‍💻

```
• Java
• Spring
• Swagger
```



## Desafio BackEnd - TO-DO Tasks 📝

### **Proposta**  📃

​		O objetivo desse desafio é a criação de uma API REST para um aplicativo de tarefas (TO-DO).

Leia com atenção todo esse documento antes de pôr a mão na massa!  



### **Requisitos**🛠️

​	Segue abaixo o resumo dos requisitos que devem ser desenvolvidos:  

- Cadastro de um novo usuário  
- Inclusão de uma nova tarefa  
- Exclusão de uma tarefa 
- Alteração de uma tarefa
- Marcar uma tarefa como concluída 
- Listar as tarefas pendentes, filtrando opcionalmente pela prioridade  
- Autenticação do usuário por meio de e-mail e senha
- Disponibilização da documentação da API Swagger.  





#### 1- Cadastro de um novo usuário

```
1.1. A API deve receber o nome, e-mail e senha do usuário para realizar a criação do usuário. Todos  os campos são obrigatórios.

1.2 A senha deve ser armazenada na forma de hash ou criptografada. Afinal, segurança é  importante.  Deve ser gerado automaticamente um ID para o usuário.

1.3 Não deve permitir criar dois usuários com o mesmo e-mail, senão isso daria uma boa confusão  na hora do login.

1.4  Opcionalmente, pode-se implementar uma política de segurança de senha para aumentar a  segurança da aplicação.
```

<br>
<br>




#### **2- Inclusão de uma nova tarefa**  

```
2.1 A API deve receber no JSON a descrição da tarefa, e a prioridade (Alta, Média, Baixa).  O usuário não deverá ser passado no JSON da requisição.

2.2 O usuário deve ser obtido através do  token de acesso, que poderá ser passado por exemplo no cabeçalho “Authorization”.  Deve ser gerado automaticamente um ID para a tarefa criada. 
```

 <br>
 <br>







#### **3- Exclusão de uma tarefa**  

```
3.1 A API deve receber o código da tarefa a ser excluída.  Se possível, validar que um usuário não exclua tarefas de outro usuário, para aumentar a  segurança da aplicação.
```

  <br>
  <br>








#### **4- Alteração de uma tarefa**

```
4.1 A API deve ter um método para que seja atualizado a descrição e prioridade de uma tarefa.  Se possível, validar que um usuário não altere tarefas de outro usuário.  
```



<br>
<br>




#### **5- Marcar uma tarefa como concluída**

```
5.1 A API deve ter um método para que uma tarefa seja marcada como concluída.  Se possível, validar que um usuário não conclua tarefas de outro usuário. 
```





<br>
<br>


#### **6- Listar as tarefas pendentes, filtrando opcionalmente pela prioridade**

```
6.1  A API deve ter um método para retornar a lista de tarefas pendentes de um usuário. Não deve  listar tarefas concluídas. Deve ser possível filtrar pela prioridade.

6.2  O usuário deve ser identificado pelo token de autenticação.
```
<br>
<br>







#### 7- **Autenticação do usuário por meio de e-mail e senha**

```
7.1  A API deve receber o e-mail do usuário, e a senha. O sistema então deve procurar o usuário pelo  e-mail e validar a senha.

7.2  Após verificado as credenciais, deve ser gerado um token de acesso. Preferencialmente utilizar  JWT. No final do documento há dicas sobre esse requisito
```

<br>
<br>




####  8- **Disponibilização da documentação da API por meio da OpenAPI**

```
8.1 A API deve ter uma documentação que utilize a OpenAPI, por exemplo Swagger.
```

<br>
<br>







####   **Requisitos técnicos**  

**Plataforma:** a API deve ser desenvolvida em Java com SpringBoot

**Banco de dados:** pode ser utilizado banco de dados em memória, por exemplo o h2, bem como  pode ser utilizado SQL-Server ou Oracle também. Disponibilizar os scripts de banco de dados  juntamente com o código fonte.  

**Build e Execução:** Adicionar informações no “readme” do código fonte para build e deploy da  aplicação. 

**Código fonte:** o código fonte deve ser disponibilizado no GitHub e deverá haver uma branch  chamada “develop” no repositório com o código fonte disponibilizado.

