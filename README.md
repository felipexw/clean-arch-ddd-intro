# Clean Architecture with Domain Driven Design (DDD)
O objetivo desse projeto é apresentar, de forma didática, alguns dos principais conceitos de Clean Architecture, juntamente com Domain-Driven Design (DDD) com Micronaut.

## Problema
Esse problema veio de origem do curso [Java e Domain Driven Design: Apresentando os conceitos](https://www.alura.com.br/curso-online-java-domain-driven-design-conceitos), com algumas modificações.

### Enunciado
Imagine um software em um contexto acadêmico, onde será necessário **matricular alunos** e **indicar alunos**.
- **indicar alunos**: quando um aluno indica uma pessoa como possível aluno (que não está matriculada, evidentemente), o aluno que indicou acaba recebendo alguma pontuação para isso. Com uma determinada pontuação acumulada, ele pode trocar os pontos por algum curso, ou algo do semelhante. A pessoa indicada recebe um e-mail contendo as informações para se matricular na próxima turma, bem como um determinado desconto na taxa da matrícula.
- **matricular alunos**: ao matricular um novo aluno em um curso, deve ser considerado se o que mesmo não foi indicado. Em caso positivo, o mesmo deverá receber um desconto na matricula. Do contrário, é o valor integral.


## Aplicando os conceitos
Alguns conceitos são necessários para melhor entendimento do desenho da solução. São eles:

- **Use cases/commands/queries/actions**: Representam as features identificadas na modelagem.
- **Entities**: Tudo aquilo que pode ser identificado por alguma propriedade única (ex: pessoa é uma entidade, pois todas possuem um CPF - cadastro de pessoa física).
- **Value objects**: São classes que não possuem identidade, porém possuem alguma lógica de funcionamento (ex: uma classe `Address`)
- **Domain events**: São eventos que são disparados ao executar um caso de uso (ex: `StudentRegistered`).
- **Bounded contexts**: São contextos que delimitam o espaço de um problema.
- **Event storming**: Eventos em que atores, casos de etc, agregados, contextos, etc. são identificados. Evento importante para que os os devs e o pessoal de negócio definam um linguagem única (ubíqua) para utilização durante o desenvolvimento.
- **Business invariantes**: são regras de negócio.
- **Actors**: são aqueles que interagem diretamente com os casos de uso (ex: `Student`).


A estrutura do projeto ficou da seguinte maneira:
``` 
   /academic
      /application
      /domain
      /infrastructure
   /email
      /application
      /domain
      /infrastructure
   /gamefification
      /application
      /domain
      /infrastructure
   /shared
      /application
      /domain
      /infrastructure
```

O primeiro nível representa o domínio, ou seja, foram identificados 4 domínios: academic (acadêmico), email, gamification (pontuação), shared (compartilhado). Em cada domínio, há basicamente 3 pacotes: 
- *application*: lógica de aplicação (ex: `StudentController` do Micronaut). E a camada de **entrada/saída com o mundo externo**.
- *domain*: **toda a lógica de negócio** e casos de usos (também conhecidos como `commands`e `queries` dentro do DDD, ou `actions`).
- *infrastructure*: camada de infraestrutura que **dá suporte para a camada de domínio** (ex: implementação concreta de algum repositório ou alguma classe que tenha dependência com algum framework ou algo do gênero).

### References
- [Clean Architecture by Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Domain-Driven Design: Tackling Complexity in the Heart of Software](https://www.amazon.com.br/Domain-Driven-Design-Tackling-Complexity-Software/dp/0321125215)
- [Java e Clean Architecture: Descomplicando arquitetura de software](https://www.alura.com.br/curso-online-java-clean-architecture)
- [Java e Domain Driven Design: Apresentando os conceitos](https://www.alura.com.br/curso-online-java-domain-driven-design-conceitos)
