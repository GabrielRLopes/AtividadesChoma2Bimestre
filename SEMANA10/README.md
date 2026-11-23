# Semana 10 — TDD

Quatro projetos da disciplina em módulos Maven independentes. Cada módulo preserva seu pacote Java e usa JUnit 5 para os testes. [Material original da Semana 10](https://github.com/JoaoChoma/teste_software_2026/tree/main/aulas/SEMANA10)

## Testes e cobertura

Execute o comando abaixo na raiz do projeto com JDK 17 e Maven.

```shell
mvn clean verify
```

| Módulo | Casos executados | Linhas | Ramificações |
| --- | ---: | ---: | ---: |
| [Bubble Sort](bubblesort-tdd/) | 6 | 100% | 100% |
| [Carrinho de compras](carrinho-compras-tdd/) | 14 | 100% | 100% |
| [Conta bancária](conta-bancaria-tdd-maven/) | 17 | 100% | 100% |
| [Estoque](estoque-tdd/) | 13 | 100% | 100% |
| **Total** | **50** | **100%** | **100%** |

O resultado também foi de 100% em instruções, complexidade, métodos e classes. A fase `verify` falha se a cobertura ficar abaixo de 100% em qualquer uma das seis métricas. Os relatórios HTML e XML ficam em `target/site/jacoco/` de cada módulo. A verificação foi executada com JDK 17 e Maven 3.9.11.

Para verificar um módulo individualmente, use, por exemplo, `mvn -pl carrinho-compras-tdd clean verify`.

## Ciclos de TDD

No primeiro RED, os testes originais registraram 2 falhas no Bubble Sort, 4 na conta bancária e 4 no estoque. Os três arquivos de teste fornecidos foram preservados. Os passos seguintes incrementaram as implementações e acrescentaram casos de fronteira.

Cada requisito do carrinho recebeu um teste executado em RED antes da implementação em GREEN. Os commits correspondentes estão no histórico Git.

| Requisito do carrinho | RED | GREEN |
| --- | --- | --- |
| 1. Total do carrinho vazio | `a8b512c` | `f633697` |
| 2. Adição de um produto | `5e7c69f` | `885ec53` |
| 3. Soma de vários produtos | `d24a5b2` | `be532ed` |
| 4. Remoção de produto | `d3c23af` | `6d30beb` |
| 5. Preço inválido | `80e09ea` | `f0d2ec7` |
| 6. Desconto | `042cd30` | `ab34361` |

O commit `5e5ffb0` registra o REFACTOR final do carrinho. O histórico também inclui os incrementos e as refatorações dos outros módulos. Para examinar um passo no repositório clonado, use `git show <hash>`.
