# T1-GCS

## Requisitos Gerais
1. Deseja-se um sistema para gerência de custos dos departamentos de uma empresa.
2. O sistema deverá ser implementado em Java Console /ou/ Web Puro (apenas
HTML+CSS+Javascript). Não utilizar frameworks ou outras dependências. A ideia é ter a base de
código o mais simples possível. Cuidar para que todos os membros do time conheçam a(s)
linguagem(s) escolhida(s).
3. Não implementar um mecanismo de persistência de dados. O sistema deverá manter dados
apenas em memória durante a execução.
4. Não implementar um mecanismo de login. No entanto, deverá ser possível identificar/alterar o
usuário/funcionário que está usando o sistema no momento.
5. O sistema deverá iniciar com dados já preenchidos (em bom número e de boa qualidade), de
forma a facilitar os testes.

## Detalhamento
A empresa possui diversos funcionários e departamentos. Um departamento tem diversos funcionários, mas
um funcionário pertence a apenas um departamento. Deseja-se manter um registro de todos os custos
gerados pela empresa. Um registro de custo é inserido pelo funcionário atualmente logado no sistema, e
todo registro de custo deve ter uma categoria e estar associado a um dos departamentos da empresa.
Deseja-se poder consultar informações sobre os custos já registrados e também exibir um painel geral de
estatísticas.

## Funcionalidades Desejadas
1) O sistema deverá permitir escolher de uma lista qual o funcionário que está usando o sistema
naquele momento (facilitando para não precisar implementar mecanismos de login).
2) O sistema deverá permitir incluir um novo funcionário, indicando matrícula, nome e o departamento
em que está associado.
3) O sistema deverá vir com departamentos previamente cadastrados. Por exemplo: RH, Compras,
Vendas, Expedição, Engenharia, Produção etc.
4) O sistema deverá permitir que o funcionário atualmente logado possa incluir um novo registro de
custo. Cada registro de custo deverá conter:
a) o valor do custo
b) a descrição do custo
c) a data do custo
d) a categoria do custo (aquisição de bens, manutenção de bens, outros serviços)
e) e o departamento ao qual o custo foi vinculado.
Exemplo: “aquisição de impressora colorida, R$ 980,00, 20/05/2023, para o depto de Vendas.”
5) O sistema deverá permitir pesquisar registros de custo pela descrição (Ex. pesquisar por
“impressora”), pela categoria, pela data ou pelo departamento. A listagem deverá ocorrer do mais
recente ao mais antigo. Todos os detalhes dos registros de custo deverão ser exibidos.
6) O sistema deverá permitir excluir apenas o registro de custo mais recente. O sistema deverá impedir
a exclusão de quaisquer outros registros mais antigos.
7) O sistema deverá permitir ao usuário visualizar um painel com os seguintes dados:
a) o funcionário atualmente logado
b) o valor total dos custos do mês atual
c) o valor total dos custos dos últimos 3 meses, por departamento
d) os 3 funcionários com a maior soma de custos registrados.
8) Duas funcionalidades a mais, à escolha do grupo.
