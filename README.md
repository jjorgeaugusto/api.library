# api.library
# Biblioteca
O projeto é uma demonstração de um sistema de bibliotecas. 

<br/>

## Funcionalidades:
<ul>
    <li>Receber doação de livro</li>
    <li>Emprestar livro</li> 
    <li>Pesquisar Livros</li>
</ul>

<br/>

## Dependências
<ul>
    <li>Docker</li>
    <li>Maen</li>
    <li>Java 11</li>
</ul>

<br/>

# Como executar o aplicativo
</br>

```
# Baixar imagem do banco de dados no DockerHub
docker pull mysql

# Criar novo container a partir da imagem do banco de dados MySQL
# Nesse comando também está incluso a criação do banco que a aplicação irá se conectar e configuração da senha do usuário root
docker run --name mymysql -p 3306:3306 -e MYSQL_DATABASE=biblioteca -e MYSQL_ROOT_PASSWORD=root -d mysql


<br/>

## Tecnologias
<ul>
    <li>Linguagem: Java</li>
    <li>Gerenciador de dependências: Maven</li>
    <li>Banco de dados: Mysql</li>
    <li>Virtualização: Docker</li>
</ul>
