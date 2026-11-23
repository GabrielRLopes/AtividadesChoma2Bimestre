# Estoque

O produto inicia com estoque zero. Entradas válidas são acumuladas e retiradas válidas reduzem a quantidade. Operações com quantidade inválida, retirada acima do disponível ou entrada que ultrapasse o limite de `int` preservam o estoque.

Execute `mvn clean verify` nesta pasta. Veja o enunciado em [requisitos_estoque_tdd.md](requisitos_estoque_tdd.md).
