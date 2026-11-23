# Semana 14 — Teste de usuário no Mercado Livre

## Cenário e limite

Buscar um fone de ouvido Bluetooth para uso diário, aplicar o filtro de entrega Full, comparar as avaliações, abrir um anúncio, adicionar ao carrinho, simular o início da compra e retornar à página inicial. O limite da simulação é a primeira tela da compra, antes de confirmar o pedido ou realizar o pagamento. [Enunciado da Semana 14](https://github.com/JoaoChoma/teste_software_2026/blob/main/aulas/SEMANA14/TESTE%20USUARIO%20FINAL.pdf)

## Execução e resultado

O percurso foi executado em 22/11/2026 no navegador, em uma sessão de visitante. As tarefas, os tempos medidos e os resultados estão na [ficha preenchida](FICHA-DE-OBSERVACAO.md).

O filtro Full foi aplicado. O menu de ordenação ofereceu **Mais relevantes**, **Menor preço** e **Maior preço**. A opção por avaliação estava indisponível, então as notas de anúncios Full foram comparadas manualmente. O AGOLD A39 tinha nota 4,7 e o JBL Tune 530BT bege tinha nota 4,9. O anúncio da JBL foi escolhido.

Ao acionar **Adicionar ao carrinho**, o site exibiu “Olá! Para adicionar ao carrinho, acesse a sua conta”. A execução parou nesse ponto, e o retorno à página inicial foi confirmado pelo logotipo do Mercado Livre. **Resultado do cenário de visitante: fluxo bloqueado antes do carrinho e da primeira tela da compra.**

## Indicadores

| Indicador do enunciado | Resultado da execução técnica |
| --- | --- |
| Adição ao carrinho, com meta de pelo menos 90% dos participantes | 0 de 1 tentativa técnica (0%). A tela de login impediu a adição. |
| Conclusão do fluxo sem ajuda | 0 de 1 tentativa técnica completou o fluxo. A ordenação por avaliação e a adição ao carrinho ficaram bloqueadas. |
| Tempo médio de conclusão, com meta de até 4 minutos | Indisponível, pois o fluxo de compra ficou incompleto. A soma dos intervalos medidos foi de 24,0 s até a mensagem de login e de 25,6 s incluindo o retorno à página inicial. |
| Erros cometidos | 0 cliques incorretos registrados. Dois bloqueios de interface foram observados, a opção de ordenação ausente e a exigência de login. |

Os indicadores descrevem uma única execução técnica. A amostra de participantes humanos foi de 0 pessoas, portanto as metas com participantes ficaram sem medição.
