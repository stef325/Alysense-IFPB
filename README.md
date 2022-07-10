![Badge em Desenvolvimento](https://img.shields.io/static/v1?label=status&message=Projeto%20em%20construção&color=blue&style=for-the-badge&logo=appveyor)
<h1 align="center">Projeto Alysense</h1>


<h2>O Tema:</h2>
<p>
  O Projeto Alysense está sendo desenvolvido na disciplina de Desenvolvimento de Aplicações Coorporativas e tem como objetivo montar um sistema que simplifique a forma com que são feitas as análises sensoriais. Estas análises visam avaliar os mais diversos produtos na intenção de garantir uma opinião prévia, para que sejam feitas modificações e melhorias que agradem seu público alvo e garantir a qualidade do que é ofertado.
</p>


<h1 align="center">Como configurar o projeto na sua máquina</h1>

Para gerenciamento do projeto, é indicado que estejam instalados na sua máquina:
- [Maven](https://maven.apache.org/download.cgi) (automação e gerenciamento de projetos Java)
- [Lombok](https://projectlombok.org/download) (criação de metodos)
- [NodeJs *npm*](https://nodejs.org/en/)(gerenciador de pacotes)
- [PostgreSQL](https://www.postgresql.org/download/) (banco recomendado)
- [Visual Studio Code](https://code.visualstudio.com/) e [Spring Tool Suite](https://spring.io/tools) (Editores de Código)

*Bonus* 
Caso a IDE escolhida para trabalhar em todo o projeto for o [VSCODE](https://code.visualstudio.com/), [aqui](https://github.com/stef325/Alysense-IFPB/wiki/Extens%C3%B5es-recomendadas-VSCODE) estão algumas extensões que podem ajudar durante o desenvolvimento


<h2>Acesso ao projeto:</h2>

<h3>Download:</h3>
O projeto está disponível apenas no repositório do GITHUB. Para fazer o download, basta executar o seguinte comando no seu terminal para a pasta escolhida:
<br><br>

```
git clone https://github.com/stef325/Alysense-IFPB.git
```
<br>
Após o download ter sido completado, a pasta com o código fonte do projeto estará no local indicado. Para continuar a configuração, basta abrir a pasta ou digitar o seguinte comando no terminal a partir da pasta onde foi feito o git clone:
<br><br>

```
cd Alysense-IFPB
```
<br>

Dentro desta pasta estarão disponíveis as pastas do Back-End (server) e do Front-End(client). Abra o projeto com o editor de código de sua escolha. A seguir será indicado como configurar o projeto para execução.

<h3>Configurando o Back-End:</h3>


Abra a pasta do Back-End clicando na pasta '📁server' ou a partir do terminal aberto no diretório do projeto e digite o seguinte comando: 


```
cd server/
```

Para executar o Back-End será nescessário configurar o banco de dados previamente. O banco que está sendo utilizado atualmente no projeto é o PostgreSQL, para alterar isso basta mudar a configuração contida no arquivo 'application.properties' para o banco desejado. Caso não opte por mudar, será nescessário apenas criar as váriaveis de ambiente contendo os dados de conexão como no seguinte exemplo:

<h5>Exemplo de váriaveis utilizando o PostgreSQL da Heroku:</h5>


```
DB_NAME: diqweyiqu234

DB_POSTGRES_PASS: 2348h2k3j4hg2j3hg4j2h34tu2hgjk23g4jh234nb23x4g23tgd423

DB_POSTGRES_URL: ec25-676-2-34-556.compute-1.amazonaws.com

DB_POSTGRES_USER: 223j4hgju12
```

Tendo configurado as variáveis, basta executar a aplicação a partir do botão de executar disponível na sua IDE ou digitar o seguinte comando no terminal:


```
mvn spring-boot:run
```

Se todas as configurações foram feitas da forma correta, o Back-End já estará disponível.


<h3>Configurando o Front-End:</h3>

Abra a pasta do Front-End clicando na pasta '📁client' ou a partir do terminal aberto no diretório do projeto e digite o seguinte comando:

```
cd client/
```

agora basta fazer a instalação dos modulos com o seguinte comando no seu terminal: 

```
npm install
```
Após a conclusão da instalação, o Front poderá ser iniciado com o comando a seguir:

```
npm start
```
com isso, será aberta uma nova aba no seu navegador padrão na tela principal do projeto.

