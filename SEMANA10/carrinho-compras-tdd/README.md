# Carrinho de compras

O carrinho calcula o total dos itens adicionados e o atualiza após uma remoção. Um subtotal a partir de R$ 500,00 recebe 10% de desconto. O total é arredondado para centavos com `HALF_UP`.

O construtor de `Produto` rejeita preços negativos ou não finitos com `IllegalArgumentException`. O preço zero é válido.

Execute `mvn clean verify` nesta pasta. A sequência dos seis requisitos está em [REQUISITOS.md](REQUISITOS.md).
