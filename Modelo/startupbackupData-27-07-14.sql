--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.13
-- Dumped by pg_dump version 9.1.13
-- Started on 2014-07-27 14:47:16 VET

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2026 (class 0 OID 19388)
-- Dependencies: 166 2053
-- Data for Name: security_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2031 (class 0 OID 19409)
-- Dependencies: 171 2053
-- Data for Name: security_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2032 (class 0 OID 19415)
-- Dependencies: 172 2026 2031 2053
-- Data for Name: group_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2028 (class 0 OID 19396)
-- Dependencies: 168 2053
-- Data for Name: security_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2029 (class 0 OID 19402)
-- Dependencies: 169 2026 2028 2053
-- Data for Name: role_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 165
-- Name: security_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_group_id_seq', 1, false);


--
-- TOC entry 2058 (class 0 OID 0)
-- Dependencies: 167
-- Name: security_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_role_id_seq', 1, false);


--
-- TOC entry 2059 (class 0 OID 0)
-- Dependencies: 170
-- Name: security_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_user_id_seq', 1, false);


--
-- TOC entry 2022 (class 0 OID 19372)
-- Dependencies: 162 2053
-- Data for Name: tdata_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (1, 'BUSINESS PARTNER TYPE', 'TYPE OF BUSINESS PARTNER TYPE', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (2, 'RIF TYPE', 'RIF TYPE BY BUSINESS PARTNER', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (3, 'COUNTRY', 'COUNTRY FOR GROUP TO THE STATES', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (4, 'STATE', 'STATE FOR GROUP TO THE CITIES', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (5, 'CITY', 'PLACE OF BUSINESS PARTNER', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (6, 'ITEM TYPE', 'ITEM TYPE', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (7, 'UNIT MEASURE', 'UNIT OF MEASURE FOR ITEM', 'A');
INSERT INTO tdata_type (id_data_type, name, description, status) VALUES (8, 'UNIT MEASURE ORDER', 'UNIT OF MEASURE FOR ORDERS', 'A');


--
-- TOC entry 2024 (class 0 OID 19380)
-- Dependencies: 164 2022 2053
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
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (20, NULL, 7, 'CESTA', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (19, NULL, 7, 'SACO', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (21, NULL, 7, 'UNIDAD', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (22, NULL, 7, 'BANDEJA', 'UNIDAD DE MEDIDA DE PESO', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (23, NULL, 8, 'KG', 'UNIDAD DE MEDIDA PARA PEDIDOS', true, 'A');
INSERT INTO tbasic_data (id_basic_data, parent_id_basic, id_data_type, name, description, editable, status) VALUES (24, NULL, 8, 'CESTA', 'UNIDAD DE MEDIDA PARA PEDIDOS', true, 'A');


--
-- TOC entry 2060 (class 0 OID 0)
-- Dependencies: 163
-- Name: tbasic_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbasic_data_id_seq', 2, true);


--
-- TOC entry 2040 (class 0 OID 19446)
-- Dependencies: 180 2024 2024 2053
-- Data for Name: tbusiness_partner; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (2, 'Leyner Castillo', 4, '18654277', 'URB PLAZA CARIBE', 1, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (3, 'COOPERATIVA POPULAR', 3, '12345678', 'AV LA POPULAR', 2, 'A');


--
-- TOC entry 2043 (class 0 OID 19459)
-- Dependencies: 183 2024 2040 2053
-- Data for Name: tbusiness_partner_branch; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (2, 2, 'LEYNER CASTILLO', 'URB PLAZA CARIBE', '', NULL, '0141353342', 'LEYNER CASTILLO', 10, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (3, 3, 'COOPERATIVA POPULAR', 'AV LA POPULAR', '', NULL, '0251-2544738', 'COOPERATIVA POPULAR', 14, true);


--
-- TOC entry 2046 (class 0 OID 19472)
-- Dependencies: 186 2043 2053
-- Data for Name: torder; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2048 (class 0 OID 19481)
-- Dependencies: 188 2024 2043 2046 2053
-- Data for Name: tbill; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2034 (class 0 OID 19422)
-- Dependencies: 174 2024 2053
-- Data for Name: titem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (2, '12345', 'TOMATE', true, 17, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (3, '54321', 'ACELGA', false, 16, 'A');


--
-- TOC entry 2050 (class 0 OID 19489)
-- Dependencies: 190 2034 2048 2053
-- Data for Name: tbill_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 189
-- Name: tbill_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbill_detail_id_seq', 1, false);


--
-- TOC entry 2062 (class 0 OID 0)
-- Dependencies: 187
-- Name: tbill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbill_id_seq', 1, false);


--
-- TOC entry 2041 (class 0 OID 19452)
-- Dependencies: 181 2024 2034 2040 2053
-- Data for Name: tbusines_partner_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 2, 70, 18);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 3, 1, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 3, 10, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 2, 1, 18);


--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 182
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_branch_id_seq', 3, true);


--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 179
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_id_seq', 3, true);


--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 161
-- Name: tdata_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tdata_type_id_seq', 1, false);


--
-- TOC entry 2038 (class 0 OID 19438)
-- Dependencies: 178 2024 2034 2053
-- Data for Name: tinput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 2, 18, 1, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 2, 20, 10, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (4, 3, 18, 1, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (5, 3, 20, 15, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (6, 3, 19, 8, 'A');


--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 177
-- Name: tinput_measure_unit_id_input_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tinput_measure_unit_id_input_measure_unit_seq', 6, true);


--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 173
-- Name: titem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('titem_id_seq', 3, true);


--
-- TOC entry 2052 (class 0 OID 19497)
-- Dependencies: 192 2024 2034 2046 2053
-- Data for Name: torder_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 191
-- Name: torder_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_detail_id_seq', 1, false);


--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 184
-- Name: torder_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_id_seq', 4, true);


--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 185
-- Name: torder_ordernumber_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_ordernumber_seq', 3, true);


--
-- TOC entry 2036 (class 0 OID 19430)
-- Dependencies: 176 2024 2034 2053
-- Data for Name: toutput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 2, 20, 10, 'A');
INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 3, 19, 6, 'A');


--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 175
-- Name: toutput_measure_unit_id_output_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('toutput_measure_unit_id_output_measure_unit_seq', 3, true);


-- Completed on 2014-07-27 14:47:17 VET

--
-- PostgreSQL database dump complete
--

