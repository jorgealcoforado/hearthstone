insert into baralho (classe, nome) values (0, 'B1');
insert into baralho (classe, nome) values (1, 'B2');
insert into baralho (classe, nome) values (2, 'B3');

insert into carta (ataque, classe, defesa, descricao, nome, tipo) values (5, 0, 5, 'C1', 'C1', 0);
insert into carta (ataque, classe, defesa, descricao, nome, tipo) values (5, 0, 5, 'C2', 'C2', 1);

insert into carta (ataque, classe, defesa, descricao, nome, tipo) values (5, 1, 5, 'C3', 'C3', 0);
insert into carta (ataque, classe, defesa, descricao, nome, tipo) values (5, 1, 5, 'C4', 'C4', 1);

insert into carta (ataque, classe, defesa, descricao, nome, tipo) values (5, 2, 5, 'C5', 'C5', 0);
insert into carta (ataque, classe, defesa, descricao, nome, tipo) values (5, 2, 5, 'C6', 'C6', 1);

insert into carta (ataque, classe, defesa, descricao, nome, tipo) values (5, 4, 5, 'C7', 'C7', 0);
insert into carta (ataque, classe, defesa, descricao, nome, tipo) values (5, 4, 5, 'C8', 'C8', 1);

insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (1,1);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (1,2);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (1,7);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (1,8);

insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (2,3);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (2,4);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (2,7);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (2,8);

insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (3,5);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (3,6);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (3,7);
insert into BARALHO_CARTA  (BARALHO_ID, CARTA_ID) values (3,8);