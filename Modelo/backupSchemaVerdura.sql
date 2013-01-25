--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.7
-- Dumped by pg_dump version 9.0.7
-- Started on 2013-01-25 16:48:53

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 525 (class 2612 OID 11574)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 153 (class 1259 OID 49576)
-- Dependencies: 5
-- Name: group_user; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE group_user (
    id_security_group integer NOT NULL,
    id_security_user integer NOT NULL
);


ALTER TABLE public.group_user OWNER TO postgres;

--
-- TOC entry 150 (class 1259 OID 49563)
-- Dependencies: 5
-- Name: role_group; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE role_group (
    id_security_role integer NOT NULL,
    id_security_group integer NOT NULL
);


ALTER TABLE public.role_group OWNER TO postgres;

--
-- TOC entry 147 (class 1259 OID 49549)
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
-- TOC entry 146 (class 1259 OID 49547)
-- Dependencies: 147 5
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
-- TOC entry 1928 (class 0 OID 0)
-- Dependencies: 146
-- Name: security_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE security_group_id_seq OWNED BY security_group.id_security_group;


--
-- TOC entry 149 (class 1259 OID 49557)
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
-- TOC entry 148 (class 1259 OID 49555)
-- Dependencies: 5 149
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
-- TOC entry 1929 (class 0 OID 0)
-- Dependencies: 148
-- Name: security_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE security_role_id_seq OWNED BY security_role.id_security_role;


--
-- TOC entry 152 (class 1259 OID 49570)
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
-- TOC entry 151 (class 1259 OID 49568)
-- Dependencies: 152 5
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
-- TOC entry 1930 (class 0 OID 0)
-- Dependencies: 151
-- Name: security_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE security_user_id_seq OWNED BY security_user.id_security_user;


--
-- TOC entry 145 (class 1259 OID 49541)
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
-- TOC entry 144 (class 1259 OID 49539)
-- Dependencies: 5 145
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
-- TOC entry 1931 (class 0 OID 0)
-- Dependencies: 144
-- Name: tbasic_data_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbasic_data_id_seq OWNED BY tbasic_data.id_basic_data;


--
-- TOC entry 164 (class 1259 OID 49623)
-- Dependencies: 5
-- Name: tbill; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbill (
    id_bill integer NOT NULL,
    id_bp_branch integer NOT NULL,
    id_order integer NOT NULL,
    control_number character varying(12) NOT NULL,
    bill_number character varying(12) NOT NULL,
    bp_name character varying(100) NOT NULL,
    bp_rif_type integer NOT NULL,
    bp_rif character varying(15) NOT NULL,
    bp_address character varying(200) NOT NULL,
    bill_date timestamp without time zone NOT NULL,
    bill_total real NOT NULL,
    tax_total real NOT NULL,
    delivery_date timestamp without time zone,
    printed character(1) NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.tbill OWNER TO postgres;

--
-- TOC entry 166 (class 1259 OID 49631)
-- Dependencies: 5
-- Name: tbill_detail; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbill_detail (
    id_bill_detail integer NOT NULL,
    id_bill integer NOT NULL,
    id_item integer NOT NULL,
    item_name character varying(100) NOT NULL,
    quantity real NOT NULL,
    price real NOT NULL,
    total_price real NOT NULL,
    rating smallint,
    status character(1) NOT NULL
);


ALTER TABLE public.tbill_detail OWNER TO postgres;

--
-- TOC entry 165 (class 1259 OID 49629)
-- Dependencies: 5 166
-- Name: tbill_detail_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbill_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbill_detail_id_seq OWNER TO postgres;

--
-- TOC entry 1932 (class 0 OID 0)
-- Dependencies: 165
-- Name: tbill_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbill_detail_id_seq OWNED BY tbill_detail.id_bill_detail;


--
-- TOC entry 163 (class 1259 OID 49621)
-- Dependencies: 164 5
-- Name: tbill_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbill_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbill_id_seq OWNER TO postgres;

--
-- TOC entry 1933 (class 0 OID 0)
-- Dependencies: 163
-- Name: tbill_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbill_id_seq OWNED BY tbill.id_bill;


--
-- TOC entry 158 (class 1259 OID 49597)
-- Dependencies: 5
-- Name: tbusines_partner_item; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbusines_partner_item (
    id_business_partner integer NOT NULL,
    id_item integer NOT NULL
);


ALTER TABLE public.tbusines_partner_item OWNER TO postgres;

--
-- TOC entry 157 (class 1259 OID 49591)
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
-- TOC entry 160 (class 1259 OID 49604)
-- Dependencies: 5
-- Name: tbusiness_partner_branch; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbusiness_partner_branch (
    id_business_partner_branch integer NOT NULL,
    id_business_partner integer NOT NULL,
    name character varying(120) NOT NULL,
    address character varying(200) NOT NULL,
    email character varying(100) NOT NULL,
    fax character varying(15) NOT NULL,
    contact_phone character varying(15) NOT NULL,
    contact_name character varying(100) NOT NULL,
    city integer NOT NULL,
    address_default boolean NOT NULL
);


ALTER TABLE public.tbusiness_partner_branch OWNER TO postgres;

--
-- TOC entry 159 (class 1259 OID 49602)
-- Dependencies: 160 5
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
-- TOC entry 1934 (class 0 OID 0)
-- Dependencies: 159
-- Name: tbusiness_partner_branch_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbusiness_partner_branch_id_seq OWNED BY tbusiness_partner_branch.id_business_partner_branch;


--
-- TOC entry 156 (class 1259 OID 49589)
-- Dependencies: 157 5
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
-- TOC entry 1935 (class 0 OID 0)
-- Dependencies: 156
-- Name: tbusiness_partner_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbusiness_partner_id_seq OWNED BY tbusiness_partner.id_business_partner;


--
-- TOC entry 143 (class 1259 OID 49533)
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
-- TOC entry 142 (class 1259 OID 49531)
-- Dependencies: 5 143
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
-- TOC entry 1936 (class 0 OID 0)
-- Dependencies: 142
-- Name: tdata_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tdata_type_id_seq OWNED BY tdata_type.id_data_type;


--
-- TOC entry 155 (class 1259 OID 49583)
-- Dependencies: 5
-- Name: titem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE titem (
    id_item integer NOT NULL,
    code character varying(15) NOT NULL,
    name character varying(100) NOT NULL,
    washable boolean NOT NULL,
    cost real NOT NULL,
    price real NOT NULL,
    weight_unit integer NOT NULL,
    unit_car integer NOT NULL,
    type integer NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.titem OWNER TO postgres;

--
-- TOC entry 154 (class 1259 OID 49581)
-- Dependencies: 155 5
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
-- TOC entry 1937 (class 0 OID 0)
-- Dependencies: 154
-- Name: titem_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE titem_id_seq OWNED BY titem.id_item;


--
-- TOC entry 162 (class 1259 OID 49615)
-- Dependencies: 5
-- Name: torder; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE torder (
    id_order integer NOT NULL,
    id_bp_branch integer NOT NULL,
    order_number character varying(12) NOT NULL,
    bp_name character varying(100) NOT NULL,
    order_date timestamp without time zone NOT NULL,
    delivery_date timestamp without time zone NOT NULL,
    rif character varying(15) NOT NULL,
    bp_branch_address character varying(200) NOT NULL,
    type integer NOT NULL,
    order_total real NOT NULL,
    tax_total real NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.torder OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 49639)
-- Dependencies: 5
-- Name: torder_detail; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE torder_detail (
    id_order_detail integer NOT NULL,
    id_order integer NOT NULL,
    id_item integer NOT NULL,
    item_name character varying(100) NOT NULL,
    quantity real NOT NULL,
    price real NOT NULL,
    total_price real NOT NULL,
    status character(1) NOT NULL
);


ALTER TABLE public.torder_detail OWNER TO postgres;

--
-- TOC entry 167 (class 1259 OID 49637)
-- Dependencies: 168 5
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
-- TOC entry 1938 (class 0 OID 0)
-- Dependencies: 167
-- Name: torder_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE torder_detail_id_seq OWNED BY torder_detail.id_order_detail;


--
-- TOC entry 161 (class 1259 OID 49613)
-- Dependencies: 5 162
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
-- TOC entry 1939 (class 0 OID 0)
-- Dependencies: 161
-- Name: torder_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE torder_id_seq OWNED BY torder.id_order;


--
-- TOC entry 1861 (class 2604 OID 49552)
-- Dependencies: 146 147 147
-- Name: id_security_group; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY security_group ALTER COLUMN id_security_group SET DEFAULT nextval('security_group_id_seq'::regclass);


--
-- TOC entry 1862 (class 2604 OID 49560)
-- Dependencies: 149 148 149
-- Name: id_security_role; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY security_role ALTER COLUMN id_security_role SET DEFAULT nextval('security_role_id_seq'::regclass);


--
-- TOC entry 1863 (class 2604 OID 49573)
-- Dependencies: 152 151 152
-- Name: id_security_user; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY security_user ALTER COLUMN id_security_user SET DEFAULT nextval('security_user_id_seq'::regclass);


--
-- TOC entry 1860 (class 2604 OID 49544)
-- Dependencies: 144 145 145
-- Name: id_basic_data; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbasic_data ALTER COLUMN id_basic_data SET DEFAULT nextval('tbasic_data_id_seq'::regclass);


--
-- TOC entry 1868 (class 2604 OID 49626)
-- Dependencies: 163 164 164
-- Name: id_bill; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbill ALTER COLUMN id_bill SET DEFAULT nextval('tbill_id_seq'::regclass);


--
-- TOC entry 1869 (class 2604 OID 49634)
-- Dependencies: 166 165 166
-- Name: id_bill_detail; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbill_detail ALTER COLUMN id_bill_detail SET DEFAULT nextval('tbill_detail_id_seq'::regclass);


--
-- TOC entry 1865 (class 2604 OID 49594)
-- Dependencies: 156 157 157
-- Name: id_business_partner; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner ALTER COLUMN id_business_partner SET DEFAULT nextval('tbusiness_partner_id_seq'::regclass);


--
-- TOC entry 1866 (class 2604 OID 49607)
-- Dependencies: 160 159 160
-- Name: id_business_partner_branch; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner_branch ALTER COLUMN id_business_partner_branch SET DEFAULT nextval('tbusiness_partner_branch_id_seq'::regclass);


--
-- TOC entry 1859 (class 2604 OID 49536)
-- Dependencies: 143 142 143
-- Name: id_data_type; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tdata_type ALTER COLUMN id_data_type SET DEFAULT nextval('tdata_type_id_seq'::regclass);


--
-- TOC entry 1864 (class 2604 OID 49586)
-- Dependencies: 155 154 155
-- Name: id_item; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY titem ALTER COLUMN id_item SET DEFAULT nextval('titem_id_seq'::regclass);


--
-- TOC entry 1867 (class 2604 OID 49618)
-- Dependencies: 162 161 162
-- Name: id_order; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder ALTER COLUMN id_order SET DEFAULT nextval('torder_id_seq'::regclass);


--
-- TOC entry 1870 (class 2604 OID 49642)
-- Dependencies: 167 168 168
-- Name: id_order_detail; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder_detail ALTER COLUMN id_order_detail SET DEFAULT nextval('torder_detail_id_seq'::regclass);


--
-- TOC entry 1874 (class 2606 OID 49546)
-- Dependencies: 145 145
-- Name: id_basic_data; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbasic_data
    ADD CONSTRAINT id_basic_data PRIMARY KEY (id_basic_data);


--
-- TOC entry 1896 (class 2606 OID 49628)
-- Dependencies: 164 164
-- Name: id_bill; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbill
    ADD CONSTRAINT id_bill PRIMARY KEY (id_bill);


--
-- TOC entry 1898 (class 2606 OID 49636)
-- Dependencies: 166 166
-- Name: id_bill_detail; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbill_detail
    ADD CONSTRAINT id_bill_detail PRIMARY KEY (id_bill_detail);


--
-- TOC entry 1888 (class 2606 OID 49596)
-- Dependencies: 157 157
-- Name: id_business_partner; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbusiness_partner
    ADD CONSTRAINT id_business_partner PRIMARY KEY (id_business_partner);


--
-- TOC entry 1892 (class 2606 OID 49612)
-- Dependencies: 160 160
-- Name: id_business_partner_branch; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbusiness_partner_branch
    ADD CONSTRAINT id_business_partner_branch PRIMARY KEY (id_business_partner_branch);


--
-- TOC entry 1890 (class 2606 OID 49601)
-- Dependencies: 158 158 158
-- Name: id_business_partner_item; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbusines_partner_item
    ADD CONSTRAINT id_business_partner_item PRIMARY KEY (id_business_partner, id_item);


--
-- TOC entry 1872 (class 2606 OID 49538)
-- Dependencies: 143 143
-- Name: id_data_type; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tdata_type
    ADD CONSTRAINT id_data_type PRIMARY KEY (id_data_type);


--
-- TOC entry 1886 (class 2606 OID 49588)
-- Dependencies: 155 155
-- Name: id_item; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY titem
    ADD CONSTRAINT id_item PRIMARY KEY (id_item);


--
-- TOC entry 1894 (class 2606 OID 49620)
-- Dependencies: 162 162
-- Name: id_order; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY torder
    ADD CONSTRAINT id_order PRIMARY KEY (id_order);


--
-- TOC entry 1900 (class 2606 OID 49644)
-- Dependencies: 168 168
-- Name: id_order_detail; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY torder_detail
    ADD CONSTRAINT id_order_detail PRIMARY KEY (id_order_detail);


--
-- TOC entry 1880 (class 2606 OID 49567)
-- Dependencies: 150 150 150
-- Name: id_role_group; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY role_group
    ADD CONSTRAINT id_role_group PRIMARY KEY (id_security_role, id_security_group);


--
-- TOC entry 1876 (class 2606 OID 49554)
-- Dependencies: 147 147
-- Name: id_security_group; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY security_group
    ADD CONSTRAINT id_security_group PRIMARY KEY (id_security_group);


--
-- TOC entry 1878 (class 2606 OID 49562)
-- Dependencies: 149 149
-- Name: id_security_role; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY security_role
    ADD CONSTRAINT id_security_role PRIMARY KEY (id_security_role);


--
-- TOC entry 1882 (class 2606 OID 49575)
-- Dependencies: 152 152
-- Name: id_security_user; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY security_user
    ADD CONSTRAINT id_security_user PRIMARY KEY (id_security_user);


--
-- TOC entry 1884 (class 2606 OID 49580)
-- Dependencies: 153 153 153
-- Name: idgroupuser; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY group_user
    ADD CONSTRAINT idgroupuser PRIMARY KEY (id_security_group, id_security_user);


--
-- TOC entry 1909 (class 2606 OID 49665)
-- Dependencies: 1873 145 157
-- Name: basicdata_tbusinesspartner_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner
    ADD CONSTRAINT basicdata_tbusinesspartner_fk FOREIGN KEY (type) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1913 (class 2606 OID 49670)
-- Dependencies: 145 160 1873
-- Name: basicdata_tbusinesspartneraddress_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner_branch
    ADD CONSTRAINT basicdata_tbusinesspartneraddress_fk FOREIGN KEY (city) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1920 (class 2606 OID 49750)
-- Dependencies: 166 1895 164
-- Name: bill_billdetail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbill_detail
    ADD CONSTRAINT bill_billdetail_fk FOREIGN KEY (id_bill) REFERENCES tbill(id_bill);


--
-- TOC entry 1912 (class 2606 OID 49725)
-- Dependencies: 157 1887 158
-- Name: businesspartner_businespartneritem_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusines_partner_item
    ADD CONSTRAINT businesspartner_businespartneritem_fk FOREIGN KEY (id_business_partner) REFERENCES tbusiness_partner(id_business_partner);


--
-- TOC entry 1914 (class 2606 OID 49720)
-- Dependencies: 157 160 1887
-- Name: businesspartner_businesspartneraddress_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner_branch
    ADD CONSTRAINT businesspartner_businesspartneraddress_fk FOREIGN KEY (id_business_partner) REFERENCES tbusiness_partner(id_business_partner);


--
-- TOC entry 1917 (class 2606 OID 49735)
-- Dependencies: 164 160 1891
-- Name: businesspartneraddress_bill_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbill
    ADD CONSTRAINT businesspartneraddress_bill_fk FOREIGN KEY (id_bp_branch) REFERENCES tbusiness_partner_branch(id_business_partner_branch);


--
-- TOC entry 1915 (class 2606 OID 49730)
-- Dependencies: 160 1891 162
-- Name: businesspartneraddress_order_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder
    ADD CONSTRAINT businesspartneraddress_order_fk FOREIGN KEY (id_bp_branch) REFERENCES tbusiness_partner_branch(id_business_partner_branch);


--
-- TOC entry 1919 (class 2606 OID 49715)
-- Dependencies: 1885 166 155
-- Name: item_billdetail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbill_detail
    ADD CONSTRAINT item_billdetail_fk FOREIGN KEY (id_item) REFERENCES titem(id_item);


--
-- TOC entry 1911 (class 2606 OID 49705)
-- Dependencies: 1885 158 155
-- Name: item_businespartneritem_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusines_partner_item
    ADD CONSTRAINT item_businespartneritem_fk FOREIGN KEY (id_item) REFERENCES titem(id_item);


--
-- TOC entry 1921 (class 2606 OID 49710)
-- Dependencies: 155 1885 168
-- Name: item_orderdetail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder_detail
    ADD CONSTRAINT item_orderdetail_fk FOREIGN KEY (id_item) REFERENCES titem(id_item);


--
-- TOC entry 1918 (class 2606 OID 49745)
-- Dependencies: 164 1893 162
-- Name: order_bill_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbill
    ADD CONSTRAINT order_bill_fk FOREIGN KEY (id_order) REFERENCES torder(id_order);


--
-- TOC entry 1922 (class 2606 OID 49740)
-- Dependencies: 1893 168 162
-- Name: order_orderdetail_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY torder_detail
    ADD CONSTRAINT order_orderdetail_fk FOREIGN KEY (id_order) REFERENCES torder(id_order);


--
-- TOC entry 1905 (class 2606 OID 49690)
-- Dependencies: 1875 147 153
-- Name: sgroup_sgroupuser_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_user
    ADD CONSTRAINT sgroup_sgroupuser_fk FOREIGN KEY (id_security_group) REFERENCES security_group(id_security_group);


--
-- TOC entry 1903 (class 2606 OID 49685)
-- Dependencies: 147 150 1875
-- Name: sgroup_srolegroup_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_group
    ADD CONSTRAINT sgroup_srolegroup_fk FOREIGN KEY (id_security_group) REFERENCES security_group(id_security_group);


--
-- TOC entry 1904 (class 2606 OID 49695)
-- Dependencies: 149 1877 150
-- Name: srole_srolegroup_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_group
    ADD CONSTRAINT srole_srolegroup_fk FOREIGN KEY (id_security_role) REFERENCES security_role(id_security_role);


--
-- TOC entry 1906 (class 2606 OID 49700)
-- Dependencies: 152 153 1881
-- Name: suser_sgroupuser_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_user
    ADD CONSTRAINT suser_sgroupuser_fk FOREIGN KEY (id_security_user) REFERENCES security_user(id_security_user);


--
-- TOC entry 1916 (class 2606 OID 49680)
-- Dependencies: 145 164 1873
-- Name: tbasic_data_tbill_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbill
    ADD CONSTRAINT tbasic_data_tbill_fk FOREIGN KEY (bp_rif_type) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1910 (class 2606 OID 49675)
-- Dependencies: 1873 145 157
-- Name: tbasic_data_tbusiness_partner_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusiness_partner
    ADD CONSTRAINT tbasic_data_tbusiness_partner_fk FOREIGN KEY (rif_type) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1902 (class 2606 OID 49650)
-- Dependencies: 1873 145 145
-- Name: tbasicdata_tbasicdata_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbasic_data
    ADD CONSTRAINT tbasicdata_tbasicdata_fk FOREIGN KEY (parent_id_basic) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1907 (class 2606 OID 49655)
-- Dependencies: 155 145 1873
-- Name: tbasicdata_titem_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY titem
    ADD CONSTRAINT tbasicdata_titem_fk FOREIGN KEY (unit_car) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1908 (class 2606 OID 49660)
-- Dependencies: 1873 145 155
-- Name: tbasicdata_titem_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY titem
    ADD CONSTRAINT tbasicdata_titem_fk2 FOREIGN KEY (type) REFERENCES tbasic_data(id_basic_data);


--
-- TOC entry 1901 (class 2606 OID 49645)
-- Dependencies: 143 145 1871
-- Name: tdatatype_basicdata_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbasic_data
    ADD CONSTRAINT tdatatype_basicdata_fk FOREIGN KEY (id_data_type) REFERENCES tdata_type(id_data_type);


--
-- TOC entry 1927 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-01-25 16:48:53

--
-- PostgreSQL database dump complete
--

