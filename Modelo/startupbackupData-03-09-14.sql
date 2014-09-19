--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.14
-- Dumped by pg_dump version 9.1.14
-- Started on 2014-09-03 09:00:17 VET

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2012 (class 0 OID 28948)
-- Dependencies: 168 2034
-- Data for Name: security_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2017 (class 0 OID 28969)
-- Dependencies: 173 2034
-- Data for Name: security_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2018 (class 0 OID 28975)
-- Dependencies: 174 2012 2017 2034
-- Data for Name: group_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2014 (class 0 OID 28956)
-- Dependencies: 170 2034
-- Data for Name: security_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2015 (class 0 OID 28962)
-- Dependencies: 171 2012 2014 2034
-- Data for Name: role_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 167
-- Name: security_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_group_id_seq', 1, false);


--
-- TOC entry 2039 (class 0 OID 0)
-- Dependencies: 169
-- Name: security_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_role_id_seq', 1, false);


--
-- TOC entry 2040 (class 0 OID 0)
-- Dependencies: 172
-- Name: security_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_user_id_seq', 1, false);


--
-- TOC entry 2008 (class 0 OID 28932)
-- Dependencies: 164 2034
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
-- TOC entry 2010 (class 0 OID 28940)
-- Dependencies: 166 2008 2034
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
-- TOC entry 2041 (class 0 OID 0)
-- Dependencies: 165
-- Name: tbasic_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbasic_data_id_seq', 2, true);


--
-- TOC entry 2026 (class 0 OID 29006)
-- Dependencies: 182 2010 2010 2034
-- Data for Name: tbusiness_partner; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (2, 'Leyner Castillo', 4, '18654277', 'URB PLAZA CARIBE', 1, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (3, 'COOPERATIVA POPULAR', 3, '12345678', 'AV LA POPULAR', 2, 'A');


--
-- TOC entry 2020 (class 0 OID 28982)
-- Dependencies: 176 2010 2034
-- Data for Name: titem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (2, '12345', 'TOMATE', true, 17, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (3, '54321', 'ACELGA', false, 16, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (4, '100', 'Lechuga', true, 16, 'A');


--
-- TOC entry 2027 (class 0 OID 29012)
-- Dependencies: 183 2010 2020 2026 2034
-- Data for Name: tbusines_partner_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 2, 70, 18);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 3, 1, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 3, 10, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 2, 1, 18);


--
-- TOC entry 2029 (class 0 OID 29019)
-- Dependencies: 185 2010 2026 2034
-- Data for Name: tbusiness_partner_branch; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (2, 2, 'LEYNER CASTILLO', 'URB PLAZA CARIBE', '', NULL, '0141353342', 'LEYNER CASTILLO', 10, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (3, 3, 'COOPERATIVA POPULAR', 'AV LA POPULAR', '', NULL, '0251-2544738', 'COOPERATIVA POPULAR', 14, true);


--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 184
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_branch_id_seq', 3, true);


--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 181
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_id_seq', 3, true);


--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 163
-- Name: tdata_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tdata_type_id_seq', 1, false);


--
-- TOC entry 2024 (class 0 OID 28998)
-- Dependencies: 180 2010 2020 2034
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
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 179
-- Name: tinput_measure_unit_id_input_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tinput_measure_unit_id_input_measure_unit_seq', 9, true);


--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 175
-- Name: titem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('titem_id_seq', 4, true);


--
-- TOC entry 2006 (class 0 OID 28924)
-- Dependencies: 162 2034
-- Data for Name: torder_number; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder_number (id_order_number, status) VALUES (1, 'C');
INSERT INTO torder_number (id_order_number, status) VALUES (2, 'C');
INSERT INTO torder_number (id_order_number, status) VALUES (3, 'C');
INSERT INTO torder_number (id_order_number, status) VALUES (4, 'A');


--
-- TOC entry 2031 (class 0 OID 29030)
-- Dependencies: 187 2006 2029 2034
-- Data for Name: torder; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder (id_order, id_bp_branch, id_order_number, bp_name, order_date, delivery_date, rif, bp_branch_address, status) VALUES (1, 3, 1, 'COOPERATIVA POPULAR', '2014-08-01 10:19:22.861', '2014-08-01 10:19:22.861', '12345678', 'AV LA POPULAR', 'A');
INSERT INTO torder (id_order, id_bp_branch, id_order_number, bp_name, order_date, delivery_date, rif, bp_branch_address, status) VALUES (2, 3, 2, 'COOPERATIVA POPULAR', '2014-08-01 10:21:00.198', '2014-08-01 10:21:00.198', '12345678', 'AV LA POPULAR', 'A');
INSERT INTO torder (id_order, id_bp_branch, id_order_number, bp_name, order_date, delivery_date, rif, bp_branch_address, status) VALUES (3, 2, 3, 'Leyner Castillo', '2014-08-03 22:24:58.638', '2014-08-03 22:24:58.638', 'V-18654277', 'URB PLAZA CARIBE', 'A');
INSERT INTO torder (id_order, id_bp_branch, id_order_number, bp_name, order_date, delivery_date, rif, bp_branch_address, status) VALUES (4, 2, 3, 'Leyner Castillo', '2014-08-12 08:52:16.039', '2014-08-12 08:52:16.039', 'V-18654277', 'URB PLAZA CARIBE', 'A');
INSERT INTO torder (id_order, id_bp_branch, id_order_number, bp_name, order_date, delivery_date, rif, bp_branch_address, status) VALUES (5, 2, 3, 'Leyner Castillo', '2014-08-12 14:51:41.263', '2014-08-12 14:51:41.263', 'V-18654277', 'URB PLAZA CARIBE', 'A');


--
-- TOC entry 2033 (class 0 OID 29038)
-- Dependencies: 189 2010 2020 2031 2034
-- Data for Name: torder_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (2, 2, 3, 'ACELGA', 5, 18, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (3, 2, 2, 'TOMATE', 6, 18, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (4, 3, 2, 'TOMATE', 4, 18, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (5, 3, 3, 'ACELGA', 2, 18, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (6, 4, 2, 'TOMATE', 10, 18, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (7, 4, 3, 'ACELGA', 1, 18, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (1, 1, 3, 'ACELGA', 5, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (8, 5, 2, 'TOMATE', 2, 20, 'A');
INSERT INTO torder_detail (id_order_detail, id_order, id_item, item_name, quantity, measure_unit, status) VALUES (9, 5, 3, 'ACELGA', 5, 20, 'A');


--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 188
-- Name: torder_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_detail_id_seq', 9, true);


--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 186
-- Name: torder_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_id_seq', 5, true);


--
-- TOC entry 2049 (class 0 OID 0)
-- Dependencies: 161
-- Name: torder_number_id_order_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_number_id_order_number_seq', 4, true);


--
-- TOC entry 2022 (class 0 OID 28990)
-- Dependencies: 178 2010 2020 2034
-- Data for Name: toutput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 2, 20, 10, 'A');
INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 3, 19, 6, 'A');


--
-- TOC entry 2050 (class 0 OID 0)
-- Dependencies: 177
-- Name: toutput_measure_unit_id_output_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('toutput_measure_unit_id_output_measure_unit_seq', 3, true);


-- Completed on 2014-09-03 09:00:17 VET

--
-- PostgreSQL database dump complete
--

