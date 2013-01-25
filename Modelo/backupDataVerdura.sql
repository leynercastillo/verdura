--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.7
-- Dumped by pg_dump version 9.0.7
-- Started on 2013-01-25 16:48:25

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 1940 (class 0 OID 0)
-- Dependencies: 146
-- Name: security_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_group_id_seq', 1, false);


--
-- TOC entry 1941 (class 0 OID 0)
-- Dependencies: 148
-- Name: security_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_role_id_seq', 1, false);


--
-- TOC entry 1942 (class 0 OID 0)
-- Dependencies: 151
-- Name: security_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_user_id_seq', 1, false);


--
-- TOC entry 1943 (class 0 OID 0)
-- Dependencies: 144
-- Name: tbasic_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbasic_data_id_seq', 1, false);


--
-- TOC entry 1944 (class 0 OID 0)
-- Dependencies: 165
-- Name: tbill_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbill_detail_id_seq', 1, false);


--
-- TOC entry 1945 (class 0 OID 0)
-- Dependencies: 163
-- Name: tbill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbill_id_seq', 1, false);


--
-- TOC entry 1946 (class 0 OID 0)
-- Dependencies: 159
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_branch_id_seq', 1, false);


--
-- TOC entry 1947 (class 0 OID 0)
-- Dependencies: 156
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbusiness_partner_id_seq', 1, false);


--
-- TOC entry 1948 (class 0 OID 0)
-- Dependencies: 142
-- Name: tdata_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tdata_type_id_seq', 1, false);


--
-- TOC entry 1949 (class 0 OID 0)
-- Dependencies: 154
-- Name: titem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('titem_id_seq', 1, false);


--
-- TOC entry 1950 (class 0 OID 0)
-- Dependencies: 167
-- Name: torder_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_detail_id_seq', 1, false);


--
-- TOC entry 1951 (class 0 OID 0)
-- Dependencies: 161
-- Name: torder_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('torder_id_seq', 1, false);


--
-- TOC entry 1925 (class 0 OID 49549)
-- Dependencies: 147
-- Data for Name: security_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1928 (class 0 OID 49570)
-- Dependencies: 152
-- Data for Name: security_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1929 (class 0 OID 49576)
-- Dependencies: 153 1925 1928
-- Data for Name: group_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1926 (class 0 OID 49557)
-- Dependencies: 149
-- Data for Name: security_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1927 (class 0 OID 49563)
-- Dependencies: 150 1925 1926
-- Data for Name: role_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1923 (class 0 OID 49533)
-- Dependencies: 143
-- Data for Name: tdata_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tdata_type VALUES (1, 'BUSINESS PARTNER TYPE', 'TYPE OF BUSINESS PARTNER TYPE', 'A');
INSERT INTO tdata_type VALUES (2, 'RIF TYPE', 'RIF TYPE BY BUSINESS PARTNER', 'A');
INSERT INTO tdata_type VALUES (3, 'COUNTRY', 'COUNTRY FOR GROUP TO THE STATES', 'A');
INSERT INTO tdata_type VALUES (4, 'STATE', 'STATE FOR GROUP TO THE CITIES', 'A');
INSERT INTO tdata_type VALUES (5, 'CITY', 'PLACE OF BUSINESS PARTNER', 'A');


--
-- TOC entry 1924 (class 0 OID 49541)
-- Dependencies: 145 1923
-- Data for Name: tbasic_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tbasic_data VALUES (1, NULL, 1, 'CLIENTE', 'CLIENTE, FACTURAS VENTAS', true, 'A');
INSERT INTO tbasic_data VALUES (2, NULL, 1, 'PROVEEDOR', 'PROVEEDOR, FACTURA COMPRAS', true, 'A');
INSERT INTO tbasic_data VALUES (3, NULL, 2, 'J', 'RIF JURIDICO', true, 'A');
INSERT INTO tbasic_data VALUES (4, NULL, 2, 'V', 'RIF PERSONAL', true, 'A');
INSERT INTO tbasic_data VALUES (5, NULL, 2, 'E', 'RIF EXTRANJERO', true, 'A');
INSERT INTO tbasic_data VALUES (6, NULL, 3, 'VENEZUELA', 'PAIS', true, 'A');
INSERT INTO tbasic_data VALUES (7, 6, 4, 'LARA', 'ESTADO LARA', true, 'A');
INSERT INTO tbasic_data VALUES (8, 6, 4, 'CARABOBO', 'ESTADO CARABOBO', true, 'A');
INSERT INTO tbasic_data VALUES (9, 6, 4, 'ZULIA', 'ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data VALUES (12, 9, 5, 'MARACAIBO', 'CIUDAD ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data VALUES (13, 9, 5, 'CABIMAS', 'CIUDAD ESTADO ZULIA', true, 'A');
INSERT INTO tbasic_data VALUES (14, 8, 5, 'VALENCIA', 'CIUDAD ESTADO CARABOBO', true, 'A');
INSERT INTO tbasic_data VALUES (15, 8, 5, 'GUACARA', 'CIUDAD ESTADO CARABOBO', true, 'A');
INSERT INTO tbasic_data VALUES (10, 7, 5, 'BARQUISIMETO', 'CIUDAD ESTADO LARA', true, 'A');
INSERT INTO tbasic_data VALUES (11, 7, 5, 'CABUDARE', 'CIUDAD ESTADO LARA', true, 'A');


--
-- TOC entry 1931 (class 0 OID 49591)
-- Dependencies: 157 1924 1924
-- Data for Name: tbusiness_partner; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1933 (class 0 OID 49604)
-- Dependencies: 160 1924 1931
-- Data for Name: tbusiness_partner_branch; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1934 (class 0 OID 49615)
-- Dependencies: 162 1933
-- Data for Name: torder; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1935 (class 0 OID 49623)
-- Dependencies: 164 1924 1933 1934
-- Data for Name: tbill; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1930 (class 0 OID 49583)
-- Dependencies: 155 1924 1924
-- Data for Name: titem; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1936 (class 0 OID 49631)
-- Dependencies: 166 1930 1935
-- Data for Name: tbill_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1932 (class 0 OID 49597)
-- Dependencies: 158 1930 1931
-- Data for Name: tbusines_partner_item; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1937 (class 0 OID 49639)
-- Dependencies: 168 1930 1934
-- Data for Name: torder_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2013-01-25 16:48:26

--
-- PostgreSQL database dump complete
--

