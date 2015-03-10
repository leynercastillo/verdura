--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.14
-- Dumped by pg_dump version 9.1.14
-- Started on 2014-12-17 17:26:44 VET

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2091 (class 0 OID 31343)
-- Dependencies: 175 2120
-- Data for Name: security_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2096 (class 0 OID 31364)
-- Dependencies: 180 2120
-- Data for Name: security_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2097 (class 0 OID 31370)
-- Dependencies: 181 2091 2096 2120
-- Data for Name: group_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2093 (class 0 OID 31351)
-- Dependencies: 177 2120
-- Data for Name: security_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2094 (class 0 OID 31357)
-- Dependencies: 178 2091 2093 2120
-- Data for Name: role_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2124 (class 0 OID 0)
-- Dependencies: 174
-- Name: security_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_group_id_seq', 1, false);


--
-- TOC entry 2125 (class 0 OID 0)
-- Dependencies: 176
-- Name: security_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_role_id_seq', 1, false);


--
-- TOC entry 2126 (class 0 OID 0)
-- Dependencies: 179
-- Name: security_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_user_id_seq', 1, false);


--
-- TOC entry 2082 (class 0 OID 31305)
-- Dependencies: 166 2120
-- Data for Name: tdata_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (1, 'BUSINESS PARTNER TYPE', 'TYPE OF BUSINESS PARTNER TYPE', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (2, 'RIF TYPE', 'RIF TYPE BY BUSINESS PARTNER', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (3, 'COUNTRY', 'COUNTRY FOR GROUP TO THE STATES', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (4, 'STATE', 'STATE FOR GROUP TO THE CITIES', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (5, 'CITY', 'PLACE OF BUSINESS PARTNER', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (6, 'ITEM TYPE', 'ITEM TYPE', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (7, 'UNIT MEASURE', 'UNIT OF MEASURE FOR ITEM', 'A');


--
-- TOC entry 2084 (class 0 OID 31313)
-- Dependencies: 168 2082 2120
-- Data for Name: tbasic_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (1, NULL, 1, 'CLIENTE', 'CLIENTE, FACTURAS VENTAS', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (2, NULL, 1, 'PROVEEDOR', 'PROVEEDOR, FACTURA COMPRAS', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (3, NULL, 2, 'J', 'RIF JURIDICO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (4, NULL, 2, 'V', 'RIF PERSONAL', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (5, NULL, 2, 'E', 'RIF EXTRANJERO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (6, NULL, 3, 'VENEZUELA', 'PAIS', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (7, 6, 4, 'LARA', 'ESTADO LARA', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (8, 6, 4, 'CARABOBO', 'ESTADO CARABOBO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (9, 6, 4, 'ZULIA', 'ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (12, 9, 5, 'MARACAIBO', 'CIUDAD ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (13, 9, 5, 'CABIMAS', 'CIUDAD ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (14, 8, 5, 'VALENCIA', 'CIUDAD ESTADO CARABOBO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (15, 8, 5, 'GUACARA', 'CIUDAD ESTADO CARABOBO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (10, 7, 5, 'BARQUISIMETO', 'CIUDAD ESTADO LARA', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (11, 7, 5, 'CABUDARE', 'CIUDAD ESTADO LARA', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (17, NULL, 6, 'FRUTA', 'TIPO DE PRODUCTO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (16, NULL, 6, 'HORTALIZA', 'TIPO DE PRODUCTO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (18, NULL, 7, 'KG', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (19, NULL, 7, 'SACO', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (21, NULL, 7, 'UNIDAD', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (22, NULL, 7, 'BANDEJA', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (20, NULL, 7, 'MEDIA CESTA', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (23, NULL, 7, 'CESTA', 'UNIDAD DE MEDIDA', true, 'A');


--
-- TOC entry 2127 (class 0 OID 0)
-- Dependencies: 167
-- Name: tbasic_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbasic_data_id_seq', 2, true);


--
-- TOC entry 2105 (class 0 OID 31401)
-- Dependencies: 189 2084 2084 2120
-- Data for Name: tbusiness_partner; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (2, 'Leyner Castillo', 4, '18654277', 'URB PLAZA CARIBE', 1, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (3, 'COOPERATIVA POPULAR', 3, '12345678', 'AV LA POPULAR', 2, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (4, 'Nohely Pernalete', 4, '20348349', 'EL CUJI', 1, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (5, 'CECOSESOLA', 3, '25748404-2', 'URB DEL DEL ESTE', 2, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (6, 'CENTRAL MADEIRENSE, C.A.', 3, '00006275-7', 'Av. Caura, Centro Comercial Parque Humboldt, Urbanización Residencial Parque Humboldt, Planta Baja, Edif. Automercado, Municipio Baruta', 1, 'A');


--
-- TOC entry 2099 (class 0 OID 31377)
-- Dependencies: 183 2084 2120
-- Data for Name: titem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (2, '12345', 'TOMATE', true, 17, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (3, '54321', 'ACELGA', false, 16, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (4, '100', 'Lechuga', true, 16, 'A');


--
-- TOC entry 2106 (class 0 OID 31407)
-- Dependencies: 190 2084 2099 2105 2120
-- Data for Name: tbusines_partner_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 2, 70, 18);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 3, 1, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 3, 20, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 2, 10, 18);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (5, 4, 1, 20);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (5, 2, 5, 20);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (5, 3, 1, 20);


--
-- TOC entry 2108 (class 0 OID 31414)
-- Dependencies: 192 2084 2105 2120
-- Data for Name: tbusiness_partner_branch; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (2, 2, 'LEYNER CASTILLO', 'URB PLAZA CARIBE', '', NULL, '0141353342', 'LEYNER CASTILLO', 10, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (3, 3, 'COOPERATIVA POPULAR', 'AV LA POPULAR', '', NULL, '0251-2544738', 'COOPERATIVA POPULAR', 14, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (4, 4, 'Nohely Pernalete', 'El cuji', '', NULL, '0414-3534887', 'Nohely Pernalete', 10, false);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (5, 4, 'Noelia Peraza', 'Tamaca', '', NULL, '02518857658', 'Noelia Peraza', 10, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (6, 5, 'CECOSESOLA', 'URB DEL ESTE', '', NULL, '02512533445', 'JUAN GUTIERREZ', 10, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (8, 6, 'CENTRAL Cagua', 'Intersección Avenida Intercomunal, La Encrucijada, Villa de Cura con Avenida principal de la Zona Industrial de Cagua.', '', NULL, '0244-447.14.34', 'MANUEL GUERRA', 14, true);


--
-- TOC entry 2128 (class 0 OID 0)
-- Dependencies: 191
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_branch_id_seq', 8, true);


--
-- TOC entry 2129 (class 0 OID 0)
-- Dependencies: 188
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_id_seq', 6, true);


--
-- TOC entry 2078 (class 0 OID 31289)
-- Dependencies: 162 2120
-- Data for Name: troute; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2109 (class 0 OID 31423)
-- Dependencies: 193 2078 2108 2120
-- Data for Name: tbusiness_partner_route; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 165
-- Name: tdata_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tdata_type_id_seq', 1, false);


--
-- TOC entry 2103 (class 0 OID 31393)
-- Dependencies: 187 2084 2099 2120
-- Data for Name: tinput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 2, 18, 1, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 2, 20, 10, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (4, 3, 18, 1, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (5, 3, 20, 15, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (6, 3, 19, 8, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (7, 4, 18, 1, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (8, 4, 20, 10, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (9, 4, 19, 40, 'A');


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 186
-- Name: tinput_measure_unit_id_input_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tinput_measure_unit_id_input_measure_unit_seq', 9, true);


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 182
-- Name: titem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('titem_id_seq', 4, true);


--
-- TOC entry 2080 (class 0 OID 31297)
-- Dependencies: 164 2120
-- Data for Name: torder_number; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder_number (id_order_number, status) VALUES (2, 'C');
INSERT INTO torder_number (id_order_number, status) VALUES (3, 'A');


--
-- TOC entry 2117 (class 0 OID 31451)
-- Dependencies: 201 2080 2108 2120
-- Data for Name: torder; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder (id_order, cod_number, id_order_number, id_bp_branch, rif, bp_name, bp_branch_address, order_date, delivery_date, status) VALUES (2, 2, 2, 2, 'V-18654277', 'Leyner Castillo', 'URB PLAZA CARIBE', '2014-09-21 17:23:28.893', '2014-09-21 17:23:28.893', 'A');
INSERT INTO torder (id_order, cod_number, id_order_number, id_bp_branch, rif, bp_name, bp_branch_address, order_date, delivery_date, status) VALUES (3, 3, 2, 4, 'V-20348349', 'Nohely Pernalete', 'El cuji', '2014-09-21 17:24:22.785', '2014-09-21 17:24:22.785', 'A');
INSERT INTO torder (id_order, cod_number, id_order_number, id_bp_branch, rif, bp_name, bp_branch_address, order_date, delivery_date, status) VALUES (4, 4, 2, 5, 'V-20348349', 'Nohely Pernalete', 'Tamaca', '2014-09-21 17:24:40.443', '2014-09-21 17:24:40.443', 'A');
INSERT INTO torder (id_order, cod_number, id_order_number, id_bp_branch, rif, bp_name, bp_branch_address, order_date, delivery_date, status) VALUES (8, 5, 3, 2, 'V-18654277', 'Leyner Castillo', 'URB PLAZA CARIBE', '2014-09-24 14:26:03.629', '2014-09-24 14:26:03.629', 'A');
INSERT INTO torder (id_order, cod_number, id_order_number, id_bp_branch, rif, bp_name, bp_branch_address, order_date, delivery_date, status) VALUES (10, 6, 3, 5, 'V-20348349', 'Nohely Pernalete', 'Tamaca', '2014-10-16 22:27:12.03', '2014-10-16 22:27:12.03', 'A');


--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 200
-- Name: torder_cod_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_cod_number_seq', 6, true);


--
-- TOC entry 2119 (class 0 OID 31460)
-- Dependencies: 203 2084 2099 2117 2120
-- Data for Name: torder_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (2, 2, 2, 'TOMATE', 100, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (3, 2, 4, 'Lechuga', 50, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (4, 2, 3, 'ACELGA', 45, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (5, 3, 2, 'TOMATE', 50, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (6, 3, 4, 'Lechuga', 20, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (7, 3, 3, 'ACELGA', 15, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (8, 4, 2, 'TOMATE', 50, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (9, 4, 4, 'Lechuga', 20, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (10, 4, 3, 'ACELGA', 15, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (12, 8, 3, 'ACELGA', 150, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (11, 8, 4, 'Lechuga', 60, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (13, 10, 3, 'ACELGA', 300, 20, 'A');


--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 202
-- Name: torder_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_detail_id_seq', 14, true);


--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 199
-- Name: torder_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_id_seq', 1, true);


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 163
-- Name: torder_number_id_order_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_number_id_order_number_seq', 3, true);


--
-- TOC entry 2101 (class 0 OID 31385)
-- Dependencies: 185 2084 2099 2120
-- Data for Name: toutput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 2, 20, 10, 'A');
INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 3, 19, 6, 'A');


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 184
-- Name: toutput_measure_unit_id_output_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('toutput_measure_unit_id_output_measure_unit_seq', 3, true);


--
-- TOC entry 2112 (class 0 OID 31432)
-- Dependencies: 196 2080 2108 2120
-- Data for Name: tpurchase; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tpurchase (id_purchase, id_order_number, purchase_number, id_bp_branch, rif, bp_name, bp_branch_address, purchase_date, delivery_date, status) VALUES (5, 2, 1, 3, 'J-12345678', 'COOPERATIVA POPULAR', 'AV LA POPULAR', '2014-09-22 21:46:55.553', '2014-09-22 21:46:55.553', 'A');
INSERT INTO tpurchase (id_purchase, id_order_number, purchase_number, id_bp_branch, rif, bp_name, bp_branch_address, purchase_date, delivery_date, status) VALUES (6, 2, 2, 3, 'J-12345678', 'COOPERATIVA POPULAR', 'AV LA POPULAR', '2014-09-22 21:51:53.35', '2014-09-22 21:51:53.35', 'A');
INSERT INTO tpurchase (id_purchase, id_order_number, purchase_number, id_bp_branch, rif, bp_name, bp_branch_address, purchase_date, delivery_date, status) VALUES (7, 2, 3, 6, 'J-25748404-2', 'CECOSESOLA', 'URB DEL ESTE', '2014-09-22 23:46:54.503', '2014-09-22 23:46:54.503', 'A');
INSERT INTO tpurchase (id_purchase, id_order_number, purchase_number, id_bp_branch, rif, bp_name, bp_branch_address, purchase_date, delivery_date, status) VALUES (9, 2, 4, 6, 'J-25748404-2', 'CECOSESOLA', 'URB DEL ESTE', '2014-09-24 14:28:48.417', '2014-09-24 14:28:48.417', 'A');


--
-- TOC entry 2114 (class 0 OID 31441)
-- Dependencies: 198 2084 2099 2112 2120
-- Data for Name: tpurchase_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tpurchase_detail (id_purchase_detail, id_purchase, id_item, item_name, quantity, measure_unit, price, total_price, missing_quantity, status) VALUES (1, 5, 2, 'TOMATE', 10, 18, 3, 30, 190, 'A');
INSERT INTO tpurchase_detail (id_purchase_detail, id_purchase, id_item, item_name, quantity, measure_unit, price, total_price, missing_quantity, status) VALUES (3, 6, 2, 'TOMATE', 20, 18, 10, 200, 150, 'A');
INSERT INTO tpurchase_detail (id_purchase_detail, id_purchase, id_item, item_name, quantity, measure_unit, price, total_price, missing_quantity, status) VALUES (4, 7, 2, 'TOMATE', 300, 20, 5, 150, 20.0999985, 'A');
INSERT INTO tpurchase_detail (id_purchase_detail, id_purchase, id_item, item_name, quantity, measure_unit, price, total_price, missing_quantity, status) VALUES (5, 9, 4, 'Lechuga', 300, 20, 1, 30, -21, 'A');
INSERT INTO tpurchase_detail (id_purchase_detail, id_purchase, id_item, item_name, quantity, measure_unit, price, total_price, missing_quantity, status) VALUES (6, 9, 2, 'TOMATE', 300, 20, 5, 150, -43, 'A');
INSERT INTO tpurchase_detail (id_purchase_detail, id_purchase, id_item, item_name, quantity, measure_unit, price, total_price, missing_quantity, status) VALUES (7, 9, 3, 'ACELGA', 450, 20, 1, 30, -25.2000008, 'A');
INSERT INTO tpurchase_detail (id_purchase_detail, id_purchase, id_item, item_name, quantity, measure_unit, price, total_price, missing_quantity, status) VALUES (2, 6, 3, 'ACELGA', 8, 19, 20, 20, 2.625, 'A');


--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 197
-- Name: tpurchase_detail_id_purchase_detail_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tpurchase_detail_id_purchase_detail_seq', 7, true);


--
-- TOC entry 2139 (class 0 OID 0)
-- Dependencies: 194
-- Name: tpurchase_id_purchase_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tpurchase_id_purchase_seq', 10, true);


--
-- TOC entry 2140 (class 0 OID 0)
-- Dependencies: 195
-- Name: tpurchase_purchase_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tpurchase_purchase_number_seq', 4, true);


--
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 161
-- Name: troute_id_route_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('troute_id_route_seq', 1, false);


--
-- TOC entry 2086 (class 0 OID 31321)
-- Dependencies: 170 2084 2120
-- Data for Name: tvehicle; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tvehicle (id_vehicle, doc_num, model, owner, owner_phone, measure_unit, capacity, comment, status) VALUES (2, 'XSG-089', 'PREMIO', 'LEYNER', NULL, 20, 100, NULL, 'I');


--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 169
-- Name: tvehicle_id_vehicle_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tvehicle_id_vehicle_seq', 2, true);


--
-- TOC entry 2089 (class 0 OID 31334)
-- Dependencies: 173 2078 2080 2086 2120
-- Data for Name: twaybill; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 171
-- Name: twaybill_id_waybill_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('twaybill_id_waybill_seq', 1, false);


--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 172
-- Name: twaybill_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('twaybill_number_seq', 1, false);


-- Completed on 2014-12-17 17:26:45 VET

--
-- PostgreSQL database dump complete
--

