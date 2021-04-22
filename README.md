# Clean Architecture with Domain Driven Design
O objetivo desse projeto é apresentar, de forma didática, alguns dos principais conceitos de Clean Architecture, juntamente com Domain-Driven Design (DDD) com Micronaut.

## Problema
Esse problema veio de origem do curso [Java e Domain Driven Design: Apresentando os conceitos](https://www.alura.com.br/curso-online-java-domain-driven-design-conceitos), com algumas modificações.

### Enunciado
Imagine um software em um contexto acadêmico, onde será necessário **matricular alunos** e **indicar alunos**.
- **indicar alunos**: quando um aluno indica uma pessoa como possível aluno (que não está matriculada, evidentemente), o aluno que indicou acaba recebendo alguma pontuação para isso. Com uma determinada pontuação acumulada, ele pode trocar os pontos por algum curso, ou algo do semelhante. A pessoa indicada recebe um e-mail contendo as informações para se matricular na próxima turma, bem como um determinado desconto na taxa da matrícula.
- **matricular alunos**: ao matricular um novo aluno em um curso, deve ser considerado se o que mesmo não foi indicado. Em caso positivo, o mesmo deverá receber um desconto na matricula. Do contrário, é o valor integral.

### References
- [Clean Architecture by Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Domain-Driven Design: Tackling Complexity in the Heart of Software](https://www.amazon.com.br/Domain-Driven-Design-Tackling-Complexity-Software/dp/0321125215)
- [Java e Clean Architecture: Descomplicando arquitetura de software](https://www.alura.com.br/curso-online-java-clean-architecture)
- [Java e Domain Driven Design: Apresentando os conceitos](https://www.alura.com.br/curso-online-java-domain-driven-design-conceitos)
