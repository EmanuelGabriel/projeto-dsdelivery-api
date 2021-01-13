
-- INSERIR DADOS NA TABELA PRODUTO
INSERT INTO produto (nome, preco_unitario, preco_total, quantidade, imagem_uri, descricao) VALUES ('Pizza Bacon', 149.9, 49.9, 1,'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg', 'Pizza de bacon com mussarela, orégano, molho especial e tempero da casa.');
INSERT INTO produto (nome, preco_unitario, preco_total, quantidade, imagem_uri, descricao) VALUES ('Pizza Moda da Casa', 529.9, 59.9, 1, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg', 'Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.');
INSERT INTO produto (nome, preco_unitario, preco_total, quantidade, imagem_uri, descricao) VALUES ('Pizza Portuguesa', 145.0, 45.0, 1, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_portuguesa.jpg', 'Pizza Portuguesa com molho especial, mussarela, presunto, ovos e especiarias.');
INSERT INTO produto (nome, preco_unitario, preco_total, quantidade, imagem_uri, descricao) VALUES ('Risoto de Carne', 52.0, 52.0, 1, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_carne.jpg', 'Risoto de carne com especiarias e um delicioso molho de acompanhamento.');
INSERT INTO produto (nome, preco_unitario, preco_total, quantidade, imagem_uri, descricao) VALUES ('Risoto Funghi', 59.95, 59.95, 1, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg', 'Risoto Funghi feito com ingredientes finos e o toque especial do chef.');
INSERT INTO produto (nome, preco_unitario, preco_total, quantidade, imagem_uri, descricao) VALUES ('Macarrão Espaguete', 35.9, 35.9, 1, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_espaguete.jpg', 'Macarrão fresco espaguete com molho especial e tempero da casa.');
INSERT INTO produto (nome, preco_unitario, preco_total, quantidade, imagem_uri, descricao) VALUES ('Macarrão Fusili', 38.0, 76.0, 2, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_fusili.jpg', 'Macarrão fusili com toque do chef e especiarias.');
INSERT INTO produto (nome, preco_unitario, preco_total, quantidade, imagem_uri, descricao) VALUES ('Macarrão Penne', 327.9, 37.9, 1, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_penne.jpg', 'Macarrão penne fresco ao dente com tempero especial.');


-- INSERIR DADOS NA TABELA DE FORNECEDOR
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('São João Alimentos', 'São João Alimentos Ltda', 1);
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('Pizza Las Vegas Amorin', 'Las Vegas Amorin Ltda', 2);
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('Sabor demais', 'Sabor demais Alimentos', 3);
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('Norte Sabor e Degustação Alimentos', 'Norte Sabor e Degustação Alimentos Ltda', 4);
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('Comida da Mamãe Alimentos', 'Comida da Mamãe Ltda', 5);
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('Vem comer?', 'Vem Comer Alimentos Ltda', 6);
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('DegusteMe Alimentos', 'DegusteMe Ltda', 7);
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('Que Sabor é este?', 'Corporação Junta Alimentos', 8);
INSERT INTO fornecedor (nome, descricao, produto_id) VALUES ('Alimentos Frescos', 'Alimentos Frescos Corporation', 8);


-- INSERIR DADOS NA TABELA PEDIDO
INSERT INTO pedido (subtotal, taxa_frete, valor_total, status_pedido, latitude, longitude, endereco, data_pedido) VALUES (49.9, 0.0, 49.9, 0, -23.561680, -46.656139, 'Avenida São Bartolomeu, 1500', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO pedido (subtotal, taxa_frete, valor_total, status_pedido, latitude, longitude, endereco, data_pedido) VALUES (59.9, 0.0, 59.9, 1, -22.946779, -43.217753, 'Avenida Rui Barbosa, 4947', TIMESTAMP WITH TIME ZONE '2021-01-01T15:00:00Z');
INSERT INTO pedido (subtotal, taxa_frete, valor_total, status_pedido, latitude, longitude, endereco, data_pedido) VALUES (45.0, 0.0, 45.0, 0, -25.439787, -49.237759, 'Avenida Paulista, 1623', TIMESTAMP WITH TIME ZONE '2021-01-01T16:00:00Z');
INSERT INTO pedido (subtotal, taxa_frete, valor_total, status_pedido, latitude, longitude, endereco, data_pedido) VALUES (52.0, 0.0, 52.0, 0, -23.561680, -46.656139, 'Rua Martins Oliveira, 4784', TIMESTAMP WITH TIME ZONE '2021-01-01T12:00:00Z');
INSERT INTO pedido (subtotal, taxa_frete, valor_total, status_pedido, latitude, longitude, endereco, data_pedido) VALUES (59.95, 0.0, 59.95, 1, -23.561680, -46.656139, 'Avenida São Paulo, 2498', TIMESTAMP WITH TIME ZONE '2021-01-01T08:00:00Z');
INSERT INTO pedido (subtotal, taxa_frete, valor_total, status_pedido, latitude, longitude, endereco, data_pedido) VALUES (35.9, 0.0, 35.9, 0, -23.561680, -46.656139, 'Avenida Ricardo Pintos, 9094', TIMESTAMP WITH TIME ZONE '2021-01-01T14:00:00Z');
INSERT INTO pedido (subtotal, taxa_frete, valor_total, status_pedido, latitude, longitude, endereco, data_pedido) VALUES (38.0, 0.0, 76.0, 0, -23.561680, -46.656139, 'Avenida Nunes Ales, 2733', TIMESTAMP WITH TIME ZONE '2021-01-01T09:00:00Z');


-- INSERIR DADOS NA TABELA PEDIDO_PRODUTO
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (1,1);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (1,4);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (2,2);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (2,5);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (2,8);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (3,3);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (3,4);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (4,2);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (4,6);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (5,4);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (5,6);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (6,5);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (6,1);
INSERT INTO pedido_produto (pedido_id, produto_id) VALUES (7,7);

