-- Inserção de clientes
INSERT INTO cliente (nome, email) VALUES
                                      ('João Silva', 'joao.silva@email.com'),
                                      ('Maria Santos', 'maria.santos@email.com'),
                                      ('Pedro Oliveira', 'pedro.oliveira@email.com');

-- Inserção de produtos
INSERT INTO produto (nome, descricao, preco) VALUES
                                                 ('Smartphone Galaxy S21', 'Smartphone Samsung Galaxy S21 128GB', 3999.99),
                                                 ('Notebook Dell XPS', 'Notebook Dell XPS 13 16GB RAM 512GB SSD', 6999.99),
                                                 ('Monitor LG 27"', 'Monitor LG UltraGear 27" 144Hz', 1999.99),
                                                 ('Teclado Mecânico', 'Teclado Mecânico RGB Switch Blue', 299.99),
                                                 ('Mouse Gamer', 'Mouse Gamer 12000 DPI RGB', 199.99);

-- Inserção de pedidos
INSERT INTO pedido (cliente_id, status) VALUES
                                            (1, 'PAGO'),
                                            (2, 'CRIADO'),
                                            (3, 'PAGO');

-- Inserção de produtos nos pedidos
INSERT INTO pedido_produto (produto_id, pedido_id, quantidade, preco_unitario) VALUES
                                                                                   (1, 1, 1, 3999.99),
                                                                                   (2, 1, 1, 6999.99),
                                                                                   (3, 2, 1, 1999.99),
                                                                                   (4, 3, 2, 299.99),
                                                                                   (5, 3, 1, 199.99);

-- Relacionamento cliente-pedido com valor total
INSERT INTO cliente_pedido (id_cliente, id_pedido, valor_total) VALUES
                                                                    (1, 1, 10999.98),  -- Soma dos produtos do pedido 1
                                                                    (2, 2, 1999.99),   -- Valor do pedido 2
                                                                    (3, 3, 799.97);    -- Soma dos produtos do pedido 3