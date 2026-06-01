### T2 - CSES Shortest Routes I

## Link do problema:

https://cses.fi/problemset/task/1671

## Integrantes do grupo:

João Vitor De Sousa Silva, João Vitor Maia Braga, João Pedro Prata Lima e Levi Augusto Cavalcante De Castro.

## Linguagem Utilizada:

Java.

## Como Executar a solução:

No arquivo normal(Main.java e ShortestRoutes.java) será necessário utilizar a biblioteca Algs4.jar, que está localizada na pasta lib para executar o main corretamente. 

No arquivo versão CSES, será necessário baixar o código e executar ele no ambiente de submissão do CSES, fazendo o download do arquivo no espaço encontrado no ambiente do CSES. Ex: baixar o arquivo versão CSES > abrir o link do problema > submit > escolher arquivo > clicar em submeter.

## Explicação da modelagem do problema:

O enunciado do problema consiste em um cenário com n cidades(que são os vertices) e m conexões de voo(que são as arestas).

- Cada cidade é representada por um número inteiro de 1 até n.

- A cidade 1 é Syrjälä, a origem de todas as rotas.

- Cada voo é uma aresta direcionada com três atributos:
* a: cidade de origem do voo.
* b: cidade de destino do voo.
* c: comprimento (ou custo) do voo.

Como os voos são unidirecionais(Saindo de uma cidade para a outra), por esse motivo o grafo é direcionado.

A representação adotada foi uma lista de adjacência, onde cada cidade armazena suas conexões de saída como pares (destino, comprimento).

## algoritmo utilizado:

O algoritmo escolhido foi Dijkstra, que deve ser utilizado em casos onde o grafo possuí pesos não negativos.

- Estrutura auxiliar: fila de prioridade mínima.
* Na versão Normal: IndexMinPQ da biblioteca Algs4.
* Na versão para submissão no CSES: PriorityQueue da biblioteca padrão Java.

- Operações principais:
* Relaxamento de arestas: atualizar a distância de uma cidade vizinha se encontramos um voo mais curto.
* Fila de prioridade: sempre expandimos a cidade com menor distância atual.

## Variação de Dijkstra usada: 

- Versão normal(Algs4): utiliza IndexMinPQ, que permite operações eficientes de decreaseKey.

- Versão CSES: utiliza PriorityQueue com técnica de lazy deletion (Utilizada para descartar estados obsoletos) para evitar múltiplos processamentos redundantes.

Ambas garantem que cada cidade seja processada com sua melhor distância.

## Análise de complexidade:

- Inicialização das distâncias:
* Complexidade: 𝑂(𝑛).
* Justificativa: precisamos atribuir ∞ para cada cidade inicialmente.

- Inserção na fila de prioridade:
* Complexidade: 𝑂(log 𝑛).
* Justificativa: a fila é implementada como um heap binário, e cada inserção ajusta a estrutura em tempo logarítmico.

- Extração do vértice com menor distância (poll):
* Complexidade: 𝑂(log 𝑛).
* Justificativa: remover o mínimo em um heap binário exige reorganização da árvore.

- Relaxamento de cada voo (aresta):
* Complexidade: 𝑂(1).
* Justificativa: verificar se dist[u] + peso < dist[v] é uma operação constante. Se a distância for atualizada, há uma nova inserção na fila, que custa 𝑂(log 𝑛)

- complexidade total: O(n + m log m)

## Imagem comprovando o Accepted no CSES:

![Imagem do Aceppted](evidencias\accepted2.png)
