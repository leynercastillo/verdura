--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.14
-- Dumped by pg_dump version 9.1.14
-- Started on 2014-09-08 19:48:42 VET

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 195 (class 3079 OID 11645)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 195
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 174 (class 1259 OID 29213)
-- Dependencies: 5
-- Name: group_user; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE group_user (
    id_security_group integer NOT NULL,
    id_security_user integer NOT NULL
);


ALTER TABLE public.group_user OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 29200)
-- Dependencies: 5
-- Name: role_group; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE role_group (
    id_security_role integer NOT NULL,
    id_security_group integer NOT NULL
);


ALTER TABLE public.role_group OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 29186)
-- Dependencies: 5
-- Name: security_group; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE security_group (
    id_security_group integer NOT NULL,
    name character varying(40) NOT NULL,
    status smallint NOT NULL
);


ALTER TABLE public.security_group OWNER TO postgres;

--
-- TOC entry 167 (class 1259 OID 29184)
-- Dependencies: 168 5
-- Name: security_group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE security_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.security_group_id_seq OWNER TO postgres;

--
-- TOC entry 2039 (class 0 OID 0)
-- Dependencies: 167
-- Name: security_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE security_group_id_seq OWNED BY security_group.id_security_group;


--
-- TOC entry 170 (class 1259 OID 29194)
-- Dependencies: 5
-- Name: security_role; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE security_role (
    id_security_role integer NOT NULL,
    name character varying(40) NOT NULL,
    description character varying(150) NOT NULL,
    status smallint NOT NULL
);


ALTER TABLE public.security_role OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 29192)
-- Dependencies: 170 5
-- Name: security_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE security_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.security_role_id_seq OWNER TO postgres;

--
-- TOC entry 2040 (class 0 OID 0)
-- Dependencies: 169
-- Name: security_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE security_role_id_seq OWNED BY security_role.id_security_role;


--
-- TOC entry 173 (class 1259 OID 29207)
-- Dependencies: 5
-- Name: security_user; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE security_user (
    id_security_user integer NOT NULL,
    name character varying(40) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(50) NOT NULL,
    status smallint NOT NULL
);


ALTER TABLE public.security_user OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 29205)
-- Dependencies: 173 5
-- Name: security_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE security_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.security_user_id_seq OWNER TO postgres;

--
-- TOC entry 2041 (class 0 OID 0)
-- Dependencies: 172
-- Name: security_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE security_user_id_seq OWNED BY security_user.id_security_user;


--
-- TOC entry 166 (class 1259 OID 29178)
-- Dependencies: 5
-- Name: tbasic_data; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbasic_data (
    id_basic_data integer NOT NULL,
    parent_id_basic integer,
    id_data_type integer NOT NULL,
    name character varying(150) NOT NULL,
    description character varying(300),
    editable boolean NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.tbasic_data OWNER TO postgres;

--
-- TOC entry 165 (class 1259 OID 29176)
-- Dependencies: 5 166
-- Name: tbasic_data_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbasic_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbasic_data_id_seq OWNER TO postgres;

--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 165
-- Name: tbasic_data_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbasic_data_id_seq OWNED BY tbasic_data.id_basic_data;


--
-- TOC entry 183 (class 1259 OID 29250)
-- Dependencies: 5
-- Name: tbusines_partner_item; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbusines_partner_item (
    id_business_partner integer NOT NULL,
    id_item integer NOT NULL,
    price real NOT NULL,
    measure_unit integer NOT NULL
);


ALTER TABLE public.tbusines_partner_item OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 29244)
-- Dependencies: 5
-- Name: tbusiness_partner; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbusiness_partner (
    id_business_partner integer NOT NULL,
    name character varying(100) NOT NULL,
    rif_type integer NOT NULL,
    rif character varying(15) NOT NULL,
    address character varying(200),
    type integer NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.tbusiness_partner OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 29257)
-- Dependencies: 5
-- Name: tbusiness_partner_branch; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbusiness_partner_branch (
    id_business_partner_branch integer NOT NULL,
    id_business_partner integer NOT NULL,
    name character varying(120) NOT NULL,
    address character varying(200) NOT NULL,
    email character varying(100),
    fax character varying(15),
    contact_phone character varying(15) NOT NULL,
    contact_name character varying(100) NOT NULL,
    city integer NOT NULL,
    address_default boolean NOT NULL
);


ALTER TABLE public.tbusiness_partner_branch OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 29255)
-- Dependencies: 5 185
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbusiness_partner_branch_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbusiness_partner_branch_id_seq OWNER TO postgres;

--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 184
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbusiness_partner_branch_id_seq OWNED BY tbusiness_partner_branch.id_business_partner_branch;


--
-- TOC entry 181 (class 1259 OID 29242)
-- Dependencies: 5 182
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbusiness_partner_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbusiness_partner_id_seq OWNER TO postgres;

--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 181
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbusiness_partner_id_seq OWNED BY tbusiness_partner.id_business_partner;


--
-- TOC entry 164 (class 1259 OID 29170)
-- Dependencies: 5
-- Name: tdata_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tdata_type (
    id_data_type integer NOT NULL,
    name character varying(150) NOT NULL,
    description character varying(200) NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.tdata_type OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 29168)
-- Dependencies: 164 5
-- Name: tdata_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tdata_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tdata_type_id_seq OWNER TO postgres;

--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 163
-- Name: tdata_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tdata_type_id_seq OWNED BY tdata_type.id_data_type;


--
-- TOC entry 180 (class 1259 OID 29236)
-- Dependencies: 5
-- Name: tinput_measure_unit; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tinput_measure_unit (
    id_input_measure_unit integer NOT NULL,
    id_item integer NOT NULL,
    measure_unit integer NOT NULL,
    weight_unit real NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.tinput_measure_unit OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 29234)
-- Dependencies: 180 5
-- Name: tinput_measure_unit_id_input_measure_unit_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tinput_measure_unit_id_input_measure_unit_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tinput_measure_unit_id_input_measure_unit_seq OWNER TO postgres;

--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 179
-- Name: tinput_measure_unit_id_input_measure_unit_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tinput_measure_unit_id_input_measure_unit_seq OWNED BY tinput_measure_unit.id_input_measure_unit;


--
-- TOC entry 176 (class 1259 OID 29220)
-- Dependencies: 5
-- Name: titem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE titem (
    id_item integer NOT NULL,
    code character varying(15) NOT NULL,
    name character varying(100) NOT NULL,
    washable boolean NOT NULL,
    type integer NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.titem OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 29218)
-- Dependencies: 176 5
-- Name: titem_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE titem_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.titem_id_seq OWNER TO postgres;

--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 175
-- Name: titem_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE titem_id_seq OWNED BY titem.id_item;


--
-- TOC entry 192 (class 1259 OID 29287)
-- Dependencies: 5
-- Name: torder; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE torder (
    id_order integer NOT NULL,
    id_order_number integer NOT NULL,
    id_bp_branch integer NOT NULL,
    rif character varying(15) NOT NULL,
    bp_name character varying(100) NOT NULL,
    bp_branch_address character varying(200) NOT NULL,
    order_date timestamp without time zone NOT NULL,
    delivery_date timestamp without time zone NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.torder OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 29295)
-- Dependencies: 5
-- Name: torder_detail; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE torder_detail (
    id_order_detail integer NOT NULL,
    id_order integer NOT NULL,
    id_item integer NOT NULL,
    item_name character varying(100) NOT NULL,
    quantity real NOT NULL,
    measure_unit integer NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.torder_detail OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 29293)
-- Dependencies: 194 5
-- Name: torder_detail_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE torder_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.torder_detail_id_seq OWNER TO postgres;

--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 193
-- Name: torder_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE torder_detail_id_seq OWNED BY torder_detail.id_order_detail;


--
-- TOC entry 191 (class 1259 OID 29285)
-- Dependencies: 5 192
-- Name: torder_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE torder_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.torder_id_seq OWNER TO postgres;

--
-- TOC entry 2049 (class 0 OID 0)
-- Dependencies: 191
-- Name: torder_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE torder_id_seq OWNED BY torder.id_order;


--
-- TOC entry 162 (class 1259 OID 29162)
-- Dependencies: 5
-- Name: torder_number; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE torder_number (
    id_order_number integer NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.torder_number OWNER TO postgres;

--
-- TOC entry 161 (class 1259 OID 29160)
-- Dependencies: 5 162
-- Name: torder_number_id_order_number_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE torder_number_id_order_number_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.torder_number_id_order_number_seq OWNER TO postgres;

--
-- TOC entry 2050 (class 0 OID 0)
-- Dependencies: 161
-- Name: torder_number_id_order_number_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE torder_number_id_order_number_seq OWNED BY torder_number.id_order_number;


--
-- TOC entry 178 (class 1259 OID 29228)
-- Dependencies: 5
-- Name: toutput_measure_unit; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE toutput_measure_unit (
    id_output_measure_unit integer NOT NULL,
    id_item integer NOT NULL,
    measure_unit integer NOT NULL,
    weight_unit real NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.toutput_measure_unit OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 29226)
-- Dependencies: 178 5
-- Name: toutput_measure_unit_id_output_measure_unit_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE toutput_measure_unit_id_output_measure_unit_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.toutput_measure_unit_id_output_measure_unit_seq OWNER TO postgres;

--
-- TOC entry 2051 (class 0 OID 0)
-- Dependencies: 177
-- Name: toutput_measure_unit_id_output_measure_unit_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE toutput_measure_unit_id_output_measure_unit_seq OWNED BY toutput_measure_unit.id_output_measure_unit;


--
-- TOC entry 188 (class 1259 OID 29270)
-- Dependencies: 5
-- Name: tpurchase; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tpurchase (
    id_purchase integer NOT NULL,
    id_order_number integer NOT NULL,
    purchase_number integer NOT NULL,
    id_bp_branch integer NOT NULL,
    rif character varying(15) NOT NULL,
    bp_name character varying(100) NOT NULL,
    bp_branch_address character varying(200) NOT NULL,
    purchase_date timestamp without time zone NOT NULL,
    delivery_date timestamp without time zone NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.tpurchase OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 29279)
-- Dependencies: 5
-- Name: tpurchase_detail; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tpurchase_detail (
    id_purchase_detail integer NOT NULL,
    id_purchase integer NOT NULL,
    id_item integer NOT NULL,
    item_name character varying(100) NOT NULL,
    quantity real NOT NULL,
    measure_unit integer NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.tpurchase_detail OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 29277)
-- Dependencies: 190 5
-- Name: tpurchase_detail_id_purchase_detail_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tpurchase_detail_id_purchase_detail_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tpurchase_detail_id_purchase_detail_seq OWNER TO postgres;

--
-- TOC entry 2052 (class 0 OID 0)
-- Dependencies: 189
-- Name: tpurchase_detail_id_purchase_detail_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tpurchase_detail_id_purchase_detail_seq OWNED BY tpurchase_detail.id_purchase_detail;


--
-- TOC entry 186 (class 1259 OID 29266)
-- Dependencies: 5 188
-- Name: tpurchase_id_purchase_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tpurchase_id_purchase_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tpurchase_id_purchase_seq OWNER TO postgres;

--
-- TOC entry 2053 (class 0 OID 0)
-- Dependencies: 186
-- Name: tpurchase_id_purchase_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tpurchase_id_purchase_seq OWNED BY tpurchase.id_purchase;


--
-- TOC entry 187 (class 1259 OID 29268)
-- Dependencies: 5 188
-- Name: tpurchase_purchase_number_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tpurchase_purchase_number_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tpurchase_purchase_number_seq OWNER TO postgres;

--
-- TOC entry 2054 (class 0 OID 0)
-- Dependencies: 187
-- Name: tpurchase_purchase_number_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tpurchase_purchase_number_seq OWNED BY tpurchase.purchase_number;


--
-- TOC entry 1853 (class 2604 OID 29189)
-- Dependencies: 167 168 168
-- Name: id_security_group; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY security_group ALTER COLUMN id_security_group SET DEFAULT nextval('security_group_id_seq'::regclass);


--
-- TOC entry 1854 (class 2604 OID 29197)
-- Dependencies: 169 170 170
-- Name: id_security_role; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY security_role ALTER COLUMN id_security_role SET DEFAULT nextval('security_role_id_seq'::regclass);


--
-- TOC entry 1855 (class 2604 OID 29210)
-- Dependencies: 173 172 173
-- Name: id_security_user; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY security_user ALTER COLUMN id_security_user SET DEFAULT nextval('security_user_id_seq'::regclass);


--
-- TOC entry 1852 (class 2604 OID 29181)
-- Dependencies: 165 166 166
-- Name: id_basic_data; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbasic_data ALTER COLUMN id_basic_data SET DEFAULT nextval('tbasic_data_id_seq'::regclass);


--
-- TOC entry 1859 (class 2604 OID 29247)
-- Dependencies: 182 181 182
-- Name: id_business_partner; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner ALTER COLUMN id_business_partner SET DEFAULT nextval('tbusiness_partner_id_seq'::regclass);


--
-- TOC entry 1860 (class 2604 OID 29260)
-- Dependencies: 184 185 185
-- Name: id_business_partner_branch; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner_branch ALTER COLUMN id_business_partner_branch SET DEFAULT nextval('tbusiness_partner_branch_id_seq'::regclass);


--
-- TOC entry 1851 (class 2604 OID 29173)
-- Dependencies: 163 164 164
-- Name: id_data_type; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tdata_type ALTER COLUMN id_data_type SET DEFAULT nextval('tdata_type_id_seq'::regclass);


--
-- TOC entry 1858 (class 2604 OID 29239)
-- Dependencies: 179 180 180
-- Name: id_input_measure_unit; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tinput_measure_unit ALTER COLUMN id_input_measure_unit SET DEFAULT nextval('tinput_measure_unit_id_input_measure_unit_seq'::regclass);


--
-- TOC entry 1856 (class 2604 OID 29223)
-- Dependencies: 176 175 176
-- Name: id_item; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY titem ALTER COLUMN id_item SET DEFAULT nextval('titem_id_seq'::regclass);


--
-- TOC entry 1864 (class 2604 OID 29290)
-- Dependencies: 192 191 192
-- Name: id_order; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder ALTER COLUMN id_order SET DEFAULT nextval('torder_id_seq'::regclass);


--
-- TOC entry 1865 (class 2604 OID 29298)
-- Dependencies: 194 193 194
-- Name: id_order_detail; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder_detail ALTER COLUMN id_order_detail SET DEFAULT nextval('torder_detail_id_seq'::regclass);


--
-- TOC entry 1850 (class 2604 OID 29165)
-- Dependencies: 161 162 162
-- Name: id_order_number; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder_number ALTER COLUMN id_order_number SET DEFAULT nextval('torder_number_id_order_number_seq'::regclass);


--
-- TOC entry 1857 (class 2604 OID 29231)
-- Dependencies: 177 178 178
-- Name: id_output_measure_unit; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY toutput_measure_unit ALTER COLUMN id_output_measure_unit SET DEFAULT nextval('toutput_measure_unit_id_output_measure_unit_seq'::regclass);


--
-- TOC entry 1861 (class 2604 OID 29273)
-- Dependencies: 186 188 188
-- Name: id_purchase; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tpurchase ALTER COLUMN id_purchase SET DEFAULT nextval('tpurchase_id_purchase_seq'::regclass);


--
-- TOC entry 1862 (class 2604 OID 29274)
-- Dependencies: 187 188 188
-- Name: purchase_number; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tpurchase ALTER COLUMN purchase_number SET DEFAULT nextval('tpurchase_purchase_number_seq'::regclass);


--
-- TOC entry 1863 (class 2604 OID 29282)
-- Dependencies: 189 190 190
-- Name: id_purchase_detail; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tpurchase_detail ALTER COLUMN id_purchase_detail SET DEFAULT nextval('tpurchase_detail_id_purchase_detail_seq'::regclass);


--
-- TOC entry 1871 (class 2606 OID 29183)
-- Dependencies: 166 166 2032
-- Name: id_basic_data; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbasic_data
    ADD CONSTRAINT id_basic_data PRIMARY KEY (id_basic_data);


--
-- TOC entry 1889 (class 2606 OID 29249)
-- Dependencies: 182 182 2032
-- Name: id_business_partner; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbusiness_partner
    ADD CONSTRAINT id_business_partner PRIMARY KEY (id_business_partner);


--
-- TOC entry 1893 (class 2606 OID 29265)
-- Dependencies: 185 185 2032
-- Name: id_business_partner_branch; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbusiness_partner_branch
    ADD CONSTRAINT id_business_partner_branch PRIMARY KEY (id_business_partner_branch);


--
-- TOC entry 1891 (class 2606 OID 29254)
-- Dependencies: 183 183 183 2032
-- Name: id_business_partner_item; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbusines_partner_item
    ADD CONSTRAINT id_business_partner_item PRIMARY KEY (id_business_partner, id_item);


--
-- TOC entry 1869 (class 2606 OID 29175)
-- Dependencies: 164 164 2032
-- Name: id_data_type; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tdata_type
    ADD CONSTRAINT id_data_type PRIMARY KEY (id_data_type);


--
-- TOC entry 1887 (class 2606 OID 29241)
-- Dependencies: 180 180 2032
-- Name: id_input_measure_unit; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tinput_measure_unit
    ADD CONSTRAINT id_input_measure_unit PRIMARY KEY (id_input_measure_unit);


--
-- TOC entry 1883 (class 2606 OID 29225)
-- Dependencies: 176 176 2032
-- Name: id_item; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY titem
    ADD CONSTRAINT id_item PRIMARY KEY (id_item);


--
-- TOC entry 1899 (class 2606 OID 29292)
-- Dependencies: 192 192 2032
-- Name: id_order; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY torder
    ADD CONSTRAINT id_order PRIMARY KEY (id_order);


--
-- TOC entry 1901 (class 2606 OID 29300)
-- Dependencies: 194 194 2032
-- Name: id_order_detail; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY torder_detail
    ADD CONSTRAINT id_order_detail PRIMARY KEY (id_order_detail);


--
-- TOC entry 1867 (class 2606 OID 29167)
-- Dependencies: 162 162 2032
-- Name: id_order_number; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY torder_number
    ADD CONSTRAINT id_order_number PRIMARY KEY (id_order_number);


--
-- TOC entry 1885 (class 2606 OID 29233)
-- Dependencies: 178 178 2032
-- Name: id_output_measure_unit; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY toutput_measure_unit
    ADD CONSTRAINT id_output_measure_unit PRIMARY KEY (id_output_measure_unit);


--
-- TOC entry 1895 (class 2606 OID 29276)
-- Dependencies: 188 188 2032
-- Name: id_purchase; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tpurchase
    ADD CONSTRAINT id_purchase PRIMARY KEY (id_purchase);


--
-- TOC entry 1897 (class 2606 OID 29284)
-- Dependencies: 190 190 2032
-- Name: id_purchase_detail; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tpurchase_detail
    ADD CONSTRAINT id_purchase_detail PRIMARY KEY (id_purchase_detail);


--
-- TOC entry 1877 (class 2606 OID 29204)
-- Dependencies: 171 171 171 2032
-- Name: id_role_group; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY role_group
    ADD CONSTRAINT id_role_group PRIMARY KEY (id_security_role, id_security_group);


--
-- TOC entry 1873 (class 2606 OID 29191)
-- Dependencies: 168 168 2032
-- Name: id_security_group; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY security_group
    ADD CONSTRAINT id_security_group PRIMARY KEY (id_security_group);


--
-- TOC entry 1875 (class 2606 OID 29199)
-- Dependencies: 170 170 2032
-- Name: id_security_role; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY security_role
    ADD CONSTRAINT id_security_role PRIMARY KEY (id_security_role);


--
-- TOC entry 1879 (class 2606 OID 29212)
-- Dependencies: 173 173 2032
-- Name: id_security_user; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY security_user
    ADD CONSTRAINT id_security_user PRIMARY KEY (id_security_user);


--
-- TOC entry 1881 (class 2606 OID 29217)
-- Dependencies: 174 174 174 2032
-- Name: idgroupuser; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY group_user
    ADD CONSTRAINT idgroupuser PRIMARY KEY (id_security_group, id_security_user);


--
-- TOC entry 1913 (class 2606 OID 29326)
-- Dependencies: 166 182 1870 2032
-- Name: basicdata_tbusinesspartner_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner
    ADD CONSTRAINT basicdata_tbusinesspartner_fk FOREIGN KEY (type) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1918 (class 2606 OID 29331)
-- Dependencies: 185 166 1870 2032
-- Name: basicdata_tbusinesspartneraddress_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner_branch
    ADD CONSTRAINT basicdata_tbusinesspartneraddress_fk FOREIGN KEY (city) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1917 (class 2606 OID 29416)
-- Dependencies: 1888 182 183 2032
-- Name: businesspartner_businespartneritem_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusines_partner_item
    ADD CONSTRAINT businesspartner_businespartneritem_fk FOREIGN KEY (id_business_partner) REFERENCES tbusiness_partner(id_business_partner);


--
-- TOC entry 1919 (class 2606 OID 29411)
-- Dependencies: 1888 185 182 2032
-- Name: businesspartner_businesspartneraddress_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner_branch
    ADD CONSTRAINT businesspartner_businesspartneraddress_fk FOREIGN KEY (id_business_partner) REFERENCES tbusiness_partner(id_business_partner);


--
-- TOC entry 1926 (class 2606 OID 29421)
-- Dependencies: 1892 185 192 2032
-- Name: businesspartneraddress_order_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder
    ADD CONSTRAINT businesspartneraddress_order_fk FOREIGN KEY (id_bp_branch) REFERENCES tbusiness_partner_branch(id_business_partner_branch);


--
-- TOC entry 1916 (class 2606 OID 29386)
-- Dependencies: 183 1882 176 2032
-- Name: item_businespartneritem_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusines_partner_item
    ADD CONSTRAINT item_businespartneritem_fk FOREIGN KEY (id_item) REFERENCES titem(id_item);


--
-- TOC entry 1928 (class 2606 OID 29391)
-- Dependencies: 194 1882 176 2032
-- Name: item_orderdetail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder_detail
    ADD CONSTRAINT item_orderdetail_fk FOREIGN KEY (id_item) REFERENCES titem(id_item);


--
-- TOC entry 1929 (class 2606 OID 29436)
-- Dependencies: 1898 194 192 2032
-- Name: order_orderdetail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder_detail
    ADD CONSTRAINT order_orderdetail_fk FOREIGN KEY (id_order) REFERENCES torder(id_order);


--
-- TOC entry 1906 (class 2606 OID 29371)
-- Dependencies: 168 174 1872 2032
-- Name: sgroup_sgroupuser_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_user
    ADD CONSTRAINT sgroup_sgroupuser_fk FOREIGN KEY (id_security_group) REFERENCES security_group(id_security_group);


--
-- TOC entry 1904 (class 2606 OID 29366)
-- Dependencies: 1872 171 168 2032
-- Name: sgroup_srolegroup_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_group
    ADD CONSTRAINT sgroup_srolegroup_fk FOREIGN KEY (id_security_group) REFERENCES security_group(id_security_group);


--
-- TOC entry 1905 (class 2606 OID 29376)
-- Dependencies: 170 1874 171 2032
-- Name: srole_srolegroup_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_group
    ADD CONSTRAINT srole_srolegroup_fk FOREIGN KEY (id_security_role) REFERENCES security_role(id_security_role);


--
-- TOC entry 1907 (class 2606 OID 29381)
-- Dependencies: 174 1878 173 2032
-- Name: suser_sgroupuser_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_user
    ADD CONSTRAINT suser_sgroupuser_fk FOREIGN KEY (id_security_user) REFERENCES security_user(id_security_user);


--
-- TOC entry 1915 (class 2606 OID 29356)
-- Dependencies: 1870 183 166 2032
-- Name: tbasic_data_tbusines_partner_item_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusines_partner_item
    ADD CONSTRAINT tbasic_data_tbusines_partner_item_fk FOREIGN KEY (measure_unit) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1914 (class 2606 OID 29336)
-- Dependencies: 182 166 1870 2032
-- Name: tbasic_data_tbusiness_partner_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner
    ADD CONSTRAINT tbasic_data_tbusiness_partner_fk FOREIGN KEY (rif_type) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1911 (class 2606 OID 29346)
-- Dependencies: 180 166 1870 2032
-- Name: tbasic_data_tinput_measure_unit_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tinput_measure_unit
    ADD CONSTRAINT tbasic_data_tinput_measure_unit_fk FOREIGN KEY (measure_unit) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1927 (class 2606 OID 29341)
-- Dependencies: 194 166 1870 2032
-- Name: tbasic_data_torder_detail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder_detail
    ADD CONSTRAINT tbasic_data_torder_detail_fk FOREIGN KEY (measure_unit) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1909 (class 2606 OID 29351)
-- Dependencies: 1870 178 166 2032
-- Name: tbasic_data_toutput_measure_unit_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY toutput_measure_unit
    ADD CONSTRAINT tbasic_data_toutput_measure_unit_fk FOREIGN KEY (measure_unit) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1922 (class 2606 OID 29361)
-- Dependencies: 1870 166 190 2032
-- Name: tbasic_data_tpurchase_detail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tpurchase_detail
    ADD CONSTRAINT tbasic_data_tpurchase_detail_fk FOREIGN KEY (measure_unit) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1903 (class 2606 OID 29316)
-- Dependencies: 166 166 1870 2032
-- Name: tbasicdata_tbasicdata_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbasic_data
    ADD CONSTRAINT tbasicdata_tbasicdata_fk FOREIGN KEY (parent_id_basic) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1908 (class 2606 OID 29321)
-- Dependencies: 166 176 1870 2032
-- Name: tbasicdata_titem_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY titem
    ADD CONSTRAINT tbasicdata_titem_fk2 FOREIGN KEY (type) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1921 (class 2606 OID 29426)
-- Dependencies: 1892 185 188 2032
-- Name: tbusiness_partner_branch_tpurchase_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tpurchase
    ADD CONSTRAINT tbusiness_partner_branch_tpurchase_fk FOREIGN KEY (id_bp_branch) REFERENCES tbusiness_partner_branch(id_business_partner_branch);


--
-- TOC entry 1902 (class 2606 OID 29311)
-- Dependencies: 166 1868 164 2032
-- Name: tdatatype_basicdata_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbasic_data
    ADD CONSTRAINT tdatatype_basicdata_fk FOREIGN KEY (id_data_type) REFERENCES tdata_type(id_data_type);


--
-- TOC entry 1912 (class 2606 OID 29396)
-- Dependencies: 1882 176 180 2032
-- Name: titem_tinput_measure_unit_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tinput_measure_unit
    ADD CONSTRAINT titem_tinput_measure_unit_fk FOREIGN KEY (id_item) REFERENCES titem(id_item);


--
-- TOC entry 1910 (class 2606 OID 29401)
-- Dependencies: 176 1882 178 2032
-- Name: titem_toutput_measure_unit_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY toutput_measure_unit
    ADD CONSTRAINT titem_toutput_measure_unit_fk FOREIGN KEY (id_item) REFERENCES titem(id_item);


--
-- TOC entry 1923 (class 2606 OID 29406)
-- Dependencies: 176 1882 190 2032
-- Name: titem_tpurchase_detail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tpurchase_detail
    ADD CONSTRAINT titem_tpurchase_detail_fk FOREIGN KEY (id_item) REFERENCES titem(id_item);


--
-- TOC entry 1925 (class 2606 OID 29301)
-- Dependencies: 192 162 1866 2032
-- Name: torder_number_torder_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder
    ADD CONSTRAINT torder_number_torder_fk FOREIGN KEY (id_order_number) REFERENCES torder_number(id_order_number);


--
-- TOC entry 1920 (class 2606 OID 29306)
-- Dependencies: 188 162 1866 2032
-- Name: torder_number_tpurchase_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tpurchase
    ADD CONSTRAINT torder_number_tpurchase_fk FOREIGN KEY (id_order_number) REFERENCES torder_number(id_order_number);


--
-- TOC entry 1924 (class 2606 OID 29431)
-- Dependencies: 190 188 1894 2032
-- Name: tpurchase_tpurchase_detail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tpurchase_detail
    ADD CONSTRAINT tpurchase_tpurchase_detail_fk FOREIGN KEY (id_purchase) REFERENCES tpurchase(id_purchase);


--
-- TOC entry 2037 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-09-08 19:48:43 VET

--
-- PostgreSQL database dump complete
--

