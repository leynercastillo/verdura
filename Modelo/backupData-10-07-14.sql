--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.13
-- Dumped by pg_dump version 9.1.13
-- Started on 2014-07-10 22:56:55 VET

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2025 (class 0 OID 19090)
-- Dependencies: 166 2052
-- Data for Name: security_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2030 (class 0 OID 19111)
-- Dependencies: 171 2052
-- Data for Name: security_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2031 (class 0 OID 19117)
-- Dependencies: 172 2025 2030 2052
-- Data for Name: group_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2027 (class 0 OID 19098)
-- Dependencies: 168 2052
-- Data for Name: security_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2028 (class 0 OID 19104)
-- Dependencies: 169 2025 2027 2052
-- Data for Name: role_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2056 (class 0 OID 0)
-- Dependencies: 165
-- Name: security_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_group_id_seq', 1, false);


--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 167
-- Name: security_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_role_id_seq', 1, false);


--
-- TOC entry 2058 (class 0 OID 0)
-- Dependencies: 170
-- Name: security_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_user_id_seq', 1, false);


--
-- TOC entry 2021 (class 0 OID 19074)
-- Dependencies: 162 2052
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
-- TOC entry 2023 (class 0 OID 19082)
-- Dependencies: 164 2021 2052
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


--
-- TOC entry 2059 (class 0 OID 0)
-- Dependencies: 163
-- Name: tbasic_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbasic_data_id_seq', 1, false);


--
-- TOC entry 2039 (class 0 OID 19148)
-- Dependencies: 180 2023 2023 2052
-- Data for Name: tbusiness_partner; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner (id_business_partner, name, rif_type, rif, address, type, status) VALUES (1, 'LEYNER CASTILLO', 4, '18654277', 'URB PLAZA CARIBE', 1, 'A');


--
-- TOC entry 2042 (class 0 OID 19161)
-- Dependencies: 183 2023 2039 2052
-- Data for Name: tbusiness_partner_branch; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (1, 1, 'LEYNER CASTILLO', 'URB PLAZA CARIBE', 'LEYNER.CASTILLO@GMAIL.COM', NULL, '0251-2544738', 'LEYNER CASTILLO', 11, true);
INSERT INTO tbusiness_partner_branch (id_business_partner_branch, id_business_partner, name, address, email, fax, contact_phone, contact_name, city, address_default) VALUES (2, 1, 'LUIS CASTILLO', 'EL CUJI', '', NULL, '042552343', 'LUIS CASTILLO', 14, false);


--
-- TOC entry 2045 (class 0 OID 19174)
-- Dependencies: 186 2042 2052
-- Data for Name: torder; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2047 (class 0 OID 19183)
-- Dependencies: 188 2023 2042 2045 2052
-- Data for Name: tbill; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2033 (class 0 OID 19124)
-- Dependencies: 174 2023 2052
-- Data for Name: titem; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (1, '1234', 'LECHUGA ROMANA', true, 16, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (2, '4321', 'LECHUGA NACIONAL', false, 16, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (3, '55555', 'TOMATE', false, 16, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (4, '5555', 'tomate', true, 17, 'A');
INSERT INTO titem (id_item, code, name, washable, type, status) VALUES (5, '01', 'Acelga', true, 16, 'A');


--
-- TOC entry 2049 (class 0 OID 19191)
-- Dependencies: 190 2033 2047 2052
-- Data for Name: tbill_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2060 (class 0 OID 0)
-- Dependencies: 189
-- Name: tbill_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbill_detail_id_seq', 1, false);


--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 187
-- Name: tbill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbill_id_seq', 1, false);


--
-- TOC entry 2040 (class 0 OID 19154)
-- Dependencies: 181 2033 2039 2052
-- Data for Name: tbusines_partner_item; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2062 (class 0 OID 0)
-- Dependencies: 182
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_branch_id_seq', 2, true);


--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 179
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_id_seq', 1, true);


--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 161
-- Name: tdata_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tdata_type_id_seq', 1, false);


--
-- TOC entry 2037 (class 0 OID 19140)
-- Dependencies: 178 2023 2033 2052
-- Data for Name: tinput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (1, 3, 20, 0, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 4, 19, 15, 'A');
INSERT INTO tinput_measure_unit (id_input_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (4, 5, 20, -4, 'A');


--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 177
-- Name: tinput_measure_unit_id_input_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tinput_measure_unit_id_input_measure_unit_seq', 4, true);


--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 173
-- Name: titem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('titem_id_seq', 5, true);


--
-- TOC entry 2051 (class 0 OID 19199)
-- Dependencies: 192 2023 2033 2045 2052
-- Data for Name: torder_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 191
-- Name: torder_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_detail_id_seq', 1, false);


--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 184
-- Name: torder_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_id_seq', 1, false);


--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 185
-- Name: torder_ordernumber_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_ordernumber_seq', 1, false);


--
-- TOC entry 2035 (class 0 OID 19132)
-- Dependencies: 176 2023 2033 2052
-- Data for Name: toutput_measure_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (1, 3, 19, 0, 'A');
INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (2, 4, 21, 20, 'A');
INSERT INTO toutput_measure_unit (id_output_measure_unit, id_item, measure_unit, weight_unit, status) VALUES (3, 5, 20, 6, 'A');


--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 175
-- Name: toutput_measure_unit_id_output_measure_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('toutput_measure_unit_id_output_measure_unit_seq', 3, true);


-- Completed on 2014-07-10 22:56:56 VET

--
-- PostgreSQL database dump complete
--

