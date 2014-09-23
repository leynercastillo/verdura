--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.14
-- Dumped by pg_dump version 9.1.14
-- Started on 2014-09-21 23:54:42 VET

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2041 (class 0 OID 30041)
-- Dependencies: 168 2069
-- Data for Name: security_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2046 (class 0 OID 30062)
-- Dependencies: 173 2069
-- Data for Name: security_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2047 (class 0 OID 30068)
-- Dependencies: 174 2041 2046 2069
-- Data for Name: group_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2043 (class 0 OID 30049)
-- Dependencies: 170 2069
-- Data for Name: security_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2044 (class 0 OID 30055)
-- Dependencies: 171 2041 2043 2069
-- Data for Name: role_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 167
-- Name: security_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_group_id_seq', 1, false);


--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 169
-- Name: security_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_role_id_seq', 1, false);


--
-- TOC entry 2075 (class 0 OID 0)
-- Dependencies: 172
-- Name: security_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_user_id_seq', 1, false);


--
-- TOC entry 2037 (class 0 OID 30025)
-- Dependencies: 164 2069
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
-- TOC entry 2039 (class 0 OID 30033)
-- Dependencies: 166 2037 2069
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
-- TOC entry 2076 (class 0 OID 0)
-- Dependencies: 165
-- Name: tbasic_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbasic_data_id_seq', 2, true);


--
-- TOC entry 2055 (class 0 OID 30099)
-- Dependencies: 182 2039 2039 2069
-- Data for Name: tbusiness_partner; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (2, 'Leyner Castillo', 4, '18654277', 'URB PLAZA CARIBE', 1, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (3, 'COOPERATIVA POPULAR', 3, '12345678', 'AV LA POPULAR', 2, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (4, 'Nohely Pernalete', 4, '20348349', 'EL CUJI', 1, 'A');
INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (5, 'CECOSESOLA', 3, '25748404-2', 'URB DEL DEL ESTE', 2, 'A');


--
-- TOC entry 2049 (class 0 OID 30075)
-- Dependencies: 176 2039 2069
-- Data for Name: titem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (2, '12345', 'TOMATE', true, 17, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (3, '54321', 'ACELGA', false, 16, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (4, '100', 'Lechuga', true, 16, 'A');


--
-- TOC entry 2056 (class 0 OID 30105)
-- Dependencies: 183 2039 2049 2055 2069
-- Data for Name: tbusines_partner_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 2, 70, 18);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (2, 3, 1, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 3, 10, 19);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (3, 2, 1, 18);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (5, 3, 1, 20);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (5, 2, 1, 20);
INSERT INTO tbusines_partner_item (id_business_partner, id_item, price, measure_unit) VALUES (5, 4, 1, 20);


--
-- TOC entry 2058 (class 0 OID 30112)
-- Dependencies: 185 2039 2055 2069
-- Data for Name: tbusiness_partner_branch; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (2, 2, 'LEYNER CASTILLO', 'URB PLAZA CARIBE', '', NULL, '0141353342', 'LEYNER CASTILLO', 10, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (3, 3, 'COOPERATIVA POPULAR', 'AV LA POPULAR', '', NULL, '0251-2544738', 'COOPERATIVA POPULAR', 14, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (4, 4, 'Nohely Pernalete', 'El cuji', '', NULL, '0414-3534887', 'Nohely Pernalete', 10, false);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (5, 4, 'Noelia Peraza', 'Tamaca', '', NULL, '02518857658', 'Noelia Peraza', 10, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (6, 5, 'CECOSESOLA', 'URB DEL ESTE', '', NULL, '02512533445', 'JUAN GUTIERREZ', 10, true);


--
-- TOC entry 2077 (class 0 OID 0)
-- Dependencies: 184
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_branch_id_seq', 6, true);


--
-- TOC entry 2078 (class 0 OID 0)
-- Dependencies: 181
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_id_seq', 5, true);


--
-- TOC entry 2079 (class 0 OID 0)
-- Dependencies: 163
-- Name: tdata_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tdata_type_id_seq', 1, false);


--
-- TOC entry 2053 (class 0 OID 30091)
-- Dependencies: 180 2039 2049 2069
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
-- TOC entry 2080 (class 0 OID 0)
-- Dependencies: 179
-- Name: tinput_measure_unit_id_input_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tinput_measure_unit_id_input_measure_unit_seq', 9, true);


--
-- TOC entry 2081 (class 0 OID 0)
-- Dependencies: 175
-- Name: titem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('titem_id_seq', 4, true);


--
-- TOC entry 2035 (class 0 OID 30017)
-- Dependencies: 162 2069
-- Data for Name: torder_number; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder_number (id_order_number, status) VALUES (3, 'C');
INSERT INTO torder_number (id_order_number, status) VALUES (2, 'C');


--
-- TOC entry 2066 (class 0 OID 30144)
-- Dependencies: 193 2035 2058 2069
-- Data for Name: torder; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO torder (id_order, cod_number, id_order_number, id_bp_branch, rif, bp_name, bp_branch_address, order_date, delivery_date, status) VALUES (2, 2, 2, 2, 'V-18654277', 'Leyner Castillo', 'URB PLAZA CARIBE', '2014-09-21 17:23:28.893', '2014-09-21 17:23:28.893', 'A');
INSERT INTO torder (id_order, cod_number, id_order_number, id_bp_branch, rif, bp_name, bp_branch_address, order_date, delivery_date, status) VALUES (3, 3, 2, 4, 'V-20348349', 'Nohely Pernalete', 'El cuji', '2014-09-21 17:24:22.785', '2014-09-21 17:24:22.785', 'A');
INSERT INTO torder (id_order, cod_number, id_order_number, id_bp_branch, rif, bp_name, bp_branch_address, order_date, delivery_date, status) VALUES (4, 4, 2, 5, 'V-20348349', 'Nohely Pernalete', 'Tamaca', '2014-09-21 17:24:40.443', '2014-09-21 17:24:40.443', 'A');


--
-- TOC entry 2082 (class 0 OID 0)
-- Dependencies: 192
-- Name: torder_cod_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_cod_number_seq', 4, true);


--
-- TOC entry 2068 (class 0 OID 30153)
-- Dependencies: 195 2039 2049 2066 2069
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


--
-- TOC entry 2083 (class 0 OID 0)
-- Dependencies: 194
-- Name: torder_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_detail_id_seq', 10, true);


--
-- TOC entry 2084 (class 0 OID 0)
-- Dependencies: 191
-- Name: torder_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_id_seq', 1, true);


--
-- TOC entry 2085 (class 0 OID 0)
-- Dependencies: 161
-- Name: torder_number_id_order_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_number_id_order_number_seq', 3, true);


--
-- TOC entry 2051 (class 0 OID 30083)
-- Dependencies: 178 2039 2049 2069
-- Data for Name: toutput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 2, 20, 10, 'A');
INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 3, 19, 6, 'A');


--
-- TOC entry 2086 (class 0 OID 0)
-- Dependencies: 177
-- Name: toutput_measure_unit_id_output_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('toutput_measure_unit_id_output_measure_unit_seq', 3, true);


--
-- TOC entry 2061 (class 0 OID 30125)
-- Dependencies: 188 2035 2058 2069
-- Data for Name: tpurchase; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2063 (class 0 OID 30134)
-- Dependencies: 190 2039 2049 2061 2069
-- Data for Name: tpurchase_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2087 (class 0 OID 0)
-- Dependencies: 189
-- Name: tpurchase_detail_id_purchase_detail_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tpurchase_detail_id_purchase_detail_seq', 1, false);


--
-- TOC entry 2088 (class 0 OID 0)
-- Dependencies: 186
-- Name: tpurchase_id_purchase_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tpurchase_id_purchase_seq', 4, true);


--
-- TOC entry 2089 (class 0 OID 0)
-- Dependencies: 187
-- Name: tpurchase_purchase_number_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tpurchase_purchase_number_seq', 1, false);


-- Completed on 2014-09-21 23:54:43 VET

--
-- PostgreSQL database dump complete
--

