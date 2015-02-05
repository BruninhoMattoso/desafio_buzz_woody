//////////////////////
     Introdução
//////////////////////

Um de nossos clientes, a Buzz Inc. está reclamando que a tela da aplicação que costumava exibir uma lista de todos os usuários do sistema deixou de funcionar depois de um sprint de "melhorias".
Além disso, alguns usuários mal intencionados conseguiram realizar injeção de código SQL, danificando os dados no Banco de Dados através do sistema de pesquisa por nome.
Vocês serão os responsáveis por deixar nosso cliente satisfeito novamente :)
Boa sorte!

/////////////////////
     O Desafio
/////////////////////

O desafio consiste em duas etapas:

Correção de bug(s) para que a lista de usuários volte a ser carregada ao se entrar na página principal da aplicação
Refatoração do mecanismo de pesquisa para que não seja mais possível a  injeção de código  SQL mal intencionado

Você pode:

Refatorar o código a vontade, mas lembre-se, TDD e muito importante para isso;
Realizar melhorias gerais que jugar necessárias visando melhorar a segurança de nossa aplicação;
Tomar medidas para melhorar a performance da aplicação;

Você NÃO pode:

Deixar de usar JDBC;
Alterar a aplicação de forma que ela deixe de ser uma aplicação Web;
Fugir correndo e chorando :D

/////////////////////
     Instruções
/////////////////////

Após ter os arquivos do projeto, basta na raiz da pasta injectIt, onde se encontra o arquivo pom.xml executar o seguinte comando:

mvn clean install eclipse:eclipse

Para iniciar a aplicação você pode usar o comando:
    
    mvn tomcat7:run

Lembre-se que é necessário reiniciar o servidor da aplicação após realizar alguma alteração no código *.java

/////

Qualquer dúvida, a Buzz está a disposição :)
  

