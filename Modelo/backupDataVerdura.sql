INSERT INTO tdata_type VALUES (1, 'BUSINESS PARTNER TYPE', 'TYPE OF BUSINESS PARTNER TYPE', 'A');
INSERT INTO tdata_type VALUES (2, 'RIF TYPE', 'RIF TYPE BY BUSINESS PARTNER', 'A');
INSERT INTO tdata_type VALUES (3, 'COUNTRY', 'COUNTRY FOR GROUP TO THE STATES', 'A');
INSERT INTO tdata_type VALUES (4, 'STATE', 'STATE FOR GROUP TO THE CITIES', 'A');
INSERT INTO tdata_type VALUES (5, 'CITY', 'PLACE OF BUSINESS PARTNER', 'A');

INSERT INTO tbasic_data VALUES (1, NULL, 1, 'CLIENTE', 'CLIENTE, FACTURAS VENTAS', true, 'A');
INSERT INTO tbasic_data VALUES (2, NULL, 1, 'PROVEEDOR', 'PROVEEDOR, FACTURA COMPRAS', true, 'A');
INSERT INTO tbasic_data VALUES (3, NULL, 2, 'J', 'RIF JURIDICO', true, 'A');
INSERT INTO tbasic_data VALUES (4, NULL, 2, 'V', 'RIF PERSONAL', true, 'A');
INSERT INTO tbasic_data VALUES (5, NULL, 2, 'E', 'RIF EXTRANJERO', true, 'A');
INSERT INTO tbasic_data VALUES (6, NULL, 3, 'VENEZUELA', 'PAIS', true, 'A');
INSERT INTO tbasic_data VALUES (7, 6, 4, 'LARA', 'ESTADO LARA', true, 'A');
INSERT INTO tbasic_data VALUES (8, 6, 4, 'CARABOBO', 'ESTADO CARABOBO', true, 'A');
INSERT INTO tbasic_data VALUES (9, 6, 4, 'ZULIA', 'ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data VALUES (10, 6, 5, 'BARQUISIMETO', 'CIUDAD ESTADO LARA', true, 'A');
INSERT INTO tbasic_data VALUES (11, 6, 5, 'CABUDARE', 'CIUDAD ESTADO LARA', true, 'A');
INSERT INTO tbasic_data VALUES (12, 9, 5, 'MARACAIBO', 'CIUDAD ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data VALUES (13, 9, 5, 'CABIMAS', 'CIUDAD ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data VALUES (14, 8, 5, 'VALENCIA', 'CIUDAD ESTADO CARABOBO', true, 'A');
INSERT INTO tbasic_data VALUES (15, 8, 5, 'GUACARA', 'CIUDAD ESTADO CARABOBO', true, 'A');