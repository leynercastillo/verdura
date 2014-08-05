--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.13
-- Dumped by pg_dump version 9.1.13
-- Started on 2014-08-01 10:13:49 VET

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2031 (class 0 OID 28387)
-- Dependencies: 167 2057
-- Data for Name: security_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2036 (class 0 OID 28408)
-- Dependencies: 172 2057
-- Data for Name: security_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2037 (class 0 OID 28414)
-- Dependencies: 173 2031 2036 2057
-- Data for Name: group_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2033 (class 0 OID 28395)
-- Dependencies: 169 2057
-- Data for Name: security_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2034 (class 0 OID 28401)
-- Dependencies: 170 2031 2033 2057
-- Data for Name: role_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 166
-- Name: security_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_group_id_seq', 1, false);


--
-- TOC entry 2062 (class 0 OID 0)
-- Dependencies: 168
-- Name: security_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_role_id_seq', 1, false);


--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 171
-- Name: security_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_user_id_seq', 1, false);


--
-- TOC entry 2027 (class 0 OID 28371)
-- Dependencies: 163 2057
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
-- TOC entry 2029 (class 0 OID 28379)
-- Dependencies: 165 2027 2057
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
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 164
-- Name: tbasic_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbasic_data_id_seq', 2, true);


--
-- TOC entry 2045 (class 0 OID 28445)
-- Dependencies: 181 2029 2029 2057
-- Data for Name: tbusiness_partner; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (2, 'Leyner Castillo', 4, '18654277', 'URB PLAZA CARIBE', 1, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (3, 'COOPERATIVA POPULAR', 3, '12345678', 'AV LA POPULAR', 2, 'A');


--
-- TOC entry 2048 (class 0 OID 28458)
-- Dependencies: 184 2029 2045 2057
-- Data for Name: tbusiness_partner_branch; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (2, 2, 'LEYNER CASTILLO', 'URB PLAZA CARIBE', '', NULL, '0141353342', 'LEYNER CASTILLO', 10, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (3, 3, 'COOPERATIVA POPULAR', 'AV LA POPULAR', '', NULL, '0251-2544738', 'COOPERATIVA POPULAR', 14, true);


--
-- TOC entry 2025 (class 0 OID 28364)
-- Dependencies: 161 2057
-- Data for Name: torder_number; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder_number (id_order_number, status) VALUES (1, 'A');


--
-- TOC entry 2050 (class 0 OID 28469)
-- Dependencies: 186 2025 2048 2057
-- Data for Name: torder; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2052 (class 0 OID 28477)
-- Dependencies: 188 2029 2048 2050 2057
-- Data for Name: tbill; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2039 (class 0 OID 28421)
-- Dependencies: 175 2029 2057
-- Data for Name: titem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (2, '12345', 'TOMATE', true, 17, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (3, '54321', 'ACELGA', false, 16, 'A');


--
-- TOC entry 2054 (class 0 OID 28485)
-- Dependencies: 190 2039 2052 2057
-- Data for Name: tbill_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 189
-- Name: tbill_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbill_detail_id_seq', 1, false);


--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 187
-- Name: tbill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbill_id_seq', 1, false);


--
-- TOC entry 2046 (class 0 OID 28451)
-- Dependencies: 182 2029 2039 2045 2057
-- Data for Name: tbusines_partner_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 2, 70, 18);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 3, 1, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 3, 10, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 2, 1, 18);


--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 183
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_branch_id_seq', 3, true);


--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 180
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_id_seq', 3, true);


--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 162
-- Name: tdata_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tdata_type_id_seq', 1, false);


--
-- TOC entry 2043 (class 0 OID 28437)
-- Dependencies: 179 2029 2039 2057
-- Data for Name: tinput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 2, 18, 1, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 2, 20, 10, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (4, 3, 18, 1, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (5, 3, 20, 15, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (6, 3, 19, 8, 'A');


--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 178
-- Name: tinput_measure_unit_id_input_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tinput_measure_unit_id_input_measure_unit_seq', 6, true);


--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 174
-- Name: titem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('titem_id_seq', 3, true);


--
-- TOC entry 2056 (class 0 OID 28493)
-- Dependencies: 192 2029 2039 2050 2057
-- Data for Name: torder_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 191
-- Name: torder_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_detail_id_seq', 1, false);


--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 185
-- Name: torder_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_id_seq', 1, false);


--
-- TOC entry 2041 (class 0 OID 28429)
-- Dependencies: 177 2029 2039 2057
-- Data for Name: toutput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 2, 20, 10, 'A');
INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 3, 19, 6, 'A');


--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 176
-- Name: toutput_measure_unit_id_output_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('toutput_measure_unit_id_output_measure_unit_seq', 3, true);


-- Completed on 2014-08-01 10:13:49 VET

--
-- PostgreSQL database dump complete
--

