# Semana 11 — Testes de integração com Spring Boot

A aplicação original usa Java 17, Spring Boot 3.3.13, Spring Data JPA e H2 em memória. A suíte implementa os cinco casos da atividade com JUnit 5 e MockMvc. [Projeto-base e enunciado](https://github.com/JoaoChoma/teste_software_2026/tree/main/aulas/SEMANA11/exercicios_integracao_springboot)

| Caso | Teste e evidência verificada |
| --- | --- |
| CT01 — Cadastro válido | Cadastra Teclado a R$ 150,00, confirma a geração do ID e consulta o registro com o nome e o preço esperados. |
| CT02 — Nome em branco | Confirma `IllegalArgumentException` e preservação da contagem de registros. |
| CT03 — Atualização de preço | Cadastra Mouse a R$ 80,00, atualiza para R$ 95,00 e valida o novo valor em consulta ao repositório. |
| CT04 — Cadastro pela API | Envia JSON por `POST /produtos` e verifica HTTP 200, tipo JSON, ID numérico, nome e preço. |
| CT05 — Consulta pela API | Extrai o ID do POST, executa `GET /produtos/{id}` e confere status, ID, nome e preço. |

## Persistência e isolamento

Nos cenários de releitura, `flush()` envia alterações pendentes ao H2 e `clear()` limpa as entidades mantidas pelo JPA. A consulta pelo repositório verifica os dados armazenados no banco. Inspecionar apenas o objeto devolvido pelo serviço verificaria somente o estado desse objeto em memória.

Todos os casos executam dentro de uma transação de teste. O Spring faz rollback no fim de cada método para que os registros de um caso fiquem isolados dos demais.

O MockMvc entrega as requisições simuladas ao `DispatcherServlet` dentro do contexto Spring. A chamada percorre o controller, o service, o repository e o H2 com os componentes reais, sem subir servidor HTTP nem abrir uma porta.

O POM exclui as dependências Mockito do classpath de teste para evitar a inicialização do agente durante a suíte, que usa os componentes reais.

## Execução

Na pasta deste projeto, execute com JDK 17 e Maven.

```shell
mvn clean test
```

```text
ProdutoServiceIntegrationTest     3 testes
ProdutoControllerIntegrationTest  2 testes

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Os relatórios da execução ficam em `target/surefire-reports/`.
