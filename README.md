# Lista de Exercicícios (Desenvolvimento de Sistemas Web 2)

**Instituto Federal de Educação, Ciência e Tecnologia de Pernambuco**  
**Curso:** Tecnologia em Análise e Desenvolvimento de Sistemas  
**Professor:** [Paulo Maurício Gonçalves Júnior](https://sites.google.com/site/paulomgj)  
**Aluno:** [Carlos Roberto Morais Cunha](https://www.linkedin.com/in/carlos-roberto-morais-cunha/)

---

**Observações**

- Todos os exercícios abaixo foram feitos utilizando a [IDE NetBeans 8.2](https://netbeans.org/downloads/8.2/) e o [Java SE Development Kit 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html).

- Todos os comentários no código estão em português e sem acento, enquanto as variáveis e funções estão em inglês.

- A apresentação visual foi feita utilizando o framework [Bootstrap](https://getbootstrap.com/), e está em português.

---

1. Crie uma página que imprima uma tabela de conversão Celsius Fahrenheit entre – 40 e 100 graus Celsius com incrementos de 10 em 10. A fórmula para conversão é F = (9/5)*C + 32. Altere-o de forma que a tela apresente um campo numérico para a entrada de um valor em Celsius em um formulário que envie dados utilizando o método POST.

2. Implementar uma página que apresente a tabuada. Dois campos numéricos serão criados em HTML, um para representar o início e outro o fim da tabuada. Abaixo dos campos será apresentada uma tabela com a tabuada dos números informados. Realizar validação do valor digitado pelo usuário em JavaScript antes da submissão ao servidor. Verificar se o usuário digitou alguma coisa e se o que ele digitou é um inteiro ou não. Caso tenha acontecido algum problema na entrada de dados, informar ao usuário escrevendo a mensagem na tela (sem utilizar uma janela de alerta) e recolocando o foco no campo de entrada.

3. Criar uma página com um campo de texto. Ao submeter a página, o servidor:

    (a) calculará a numerologia do nome completo de uma pessoa. Cada letra possui um código obtido através da Tabela Pitagórica, como apresentado abaixo:

    | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
    |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
    | A | B | C | D | E | F | G | H | I |
    | J | K | L | M | N | O | P | Q | R |
    | S | T | U | V | W | X | Y | Z |

    Verifique o valor de cada letra do nome completo e some seus respectivos códigos. Em cada soma o resultado deve ser de um dígito de 1 a 9, ou os números 11, 22 e 33. De acordo com o exemplo da tabela, o nome João da Silva seria calculado da seguinte forma:

    a) 1 + 6 + 1 + 6 + 4 + 1 + 1 + 9 + 3 + 4 + 1 = 37  
    b) 3 + 7 = 10  
    c) 1 + 0 = 1

    O número associado ao nome é 1 (um).

    (b) informará se é um palíndromo ou não. Um palíndromo é uma palavra, frase ou qualquer outra sequência de unidades que tenha a propriedade de poder ser lida tanto da direita para a esquerda como da esquerda para a direita obtendo-se o mesmo resultado.

4. Criar uma página que implemente uma enquete sobre a disciplina favorita dos alunos do 4o período. A página da enquete deve apresentar a lista de disciplinas onde o aluno deverá escolher uma única disciplina. O aluno poderá votar em uma disciplina ou ver o resultado parcial até o momento. Ao votar, uma nova página será aberta com o resultado parcial informando a quantidade total de votos, a quantidade de votos recebida por cada disciplina até o momento, o percentual de votos de cada disciplina e uma barra horizontal indicando graficamente o percentual de votos.

5. Criar uma página para calcular o valor futuro de um investimento baseado no montante inicial, taxa de juros mensal, tempo do investimento em meses e aportes mensais. Após receber os dados do usuário, criar uma tabela com quatro colunas: tempo, aporte, juros e montante. Para cada intervalo de tempo, informar o mês corrente, o valor do aporte, o valor dos juros aplicados ao montante e o montante corrente. Na última linha informar a soma de todos os aportes realizados, o total de juros obtidos e o valor final do investimento.

6. Criar uma página que realize o cadastramento das informações de funcionários de uma empresa. Cada funcionário será representado pelo nome, data de nascimento e salário. A tela principal deverá apresentar uma tabela com as informações de todos os funcionários cadastrados até o momento, apresentando uma mensagem caso não existam funcionários cadastrados. Um botão de inserção de novos funcionários deve aparecer ao lado do cabeçalho da tabela. Ao clicar neste botão, uma página será aberta com as três informações de um funcionário a serem digitadas. Considere as seguintes restrições aos dados dos funcionários:

    a) O nome deve conter, no mínimo, três caracteres;  
    b) Nenhum funcionário pode ter menos que 18 anos ou mais que 70 anos;  
    c) Nenhum funcionário pode ganhar menos que um salário mínimo.

    Caso alguma das restrições não seja satisfeita, uma mensagem deve aparecer ao lado do campo com erro. Ao inserir um funcionário, deverá se retornar à página principal. Ao lado do nome da cada funcionário, deverão aparecer dois botões: um para alterar e outro para remover o respectivo funcionário.

7. Implementar uma página em JSP que apresente o calendário a partir de um ano especificado pelo usuário. Pontuação:

    (a) Página implementada, apresentando todos os meses do ano em tabelas.  
    (b) Os domingos e feriados devem estar em vermelho.  
    (c) Criar uma lista de feriados fixos (01/01, 21/04, 01/05, 07/09, etc.) e apresentá-los nos dias
    respectivos juntamente com uma descrição do feriado através do atributo title.  
    (d) Criar uma lista de feriados móveis (carnaval, páscoa e corpus christi) e apresentá-los nos dias
    respectivos juntamente com uma descrição do feriado através do atributo title.  

8. O conceito de amortização é o processo de extinção de uma dívida através de pagamentos periódicos, que são realizados em função de um planejamento, de modo que cada prestação corresponde a soma do reembolso do capital ou dos juros do saldo devedor (juros sempre são calculados sobre o saldo devedor), podendo ainda ser o reembolso de ambos. Alguns dos principais sistemas de amortização são:

    - Sistema de pagamento único: ocorre um único pagamento (capital + juros) no final do período estipulado;
    - Sistema americano: ocorre um único pagamento ao final do período, porém os juros são calculados em várias fases durante o período;
    - Sistema de amortização constante (SAC): geralmente o mais utilizado, os juros e o
    capital são calculados uma única vez e divididos para o pagamento em várias parcelas durante o período;
    - Sistema price ou francês: geralmente usados em financiamentos de bens de consumo, todas as parcelas são iguais e com os juros já embutidos;
    - Sistema de amortização misto: calcula-se o financiamento pelos métodos SAC e price e faz-se uma média aritmética das prestações desses dois sistemas, chegando ao valor da prestação do sistema misto.

    Criar uma página para implementar os sistemas de amortização apresentados acima, recebendo como entrada os seguintes valores: sistema de amortização, valor do financiamento, número de meses e taxa de juros. Como saída, deverá ser gerado uma tabela com informações sobre os meses, valor dos pagamento efetuados até o momento, valor de juros pagos, amortização do saldo devedor, e por fim o saldo devedor. Por fim, mostrar o valor total gasto em cada um dos valores anteriores. Um exemplo pode ser obtido em http://fazaconta.com/amortizacao.htm.

9. Escreva dois RequestWrappers que encapsulam HttpServletRequest e sobrepõem o método getParameter():

    - Use o primeiro em um filtro chamado UpperCaseFilter, que coloque os valores de todos os parâmetros em caixa alta.
    - O segundo, ReverseFilter, deve inverter o texto dos parâmetros.
    - Coloque os dois em cascata apontando para um servlet simples.
