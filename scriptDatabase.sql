--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-31 13:53:17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 9 (class 2615 OID 16395)
-- Name: Schema1; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "Schema1";


ALTER SCHEMA "Schema1" OWNER TO postgres;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 2 (class 3079 OID 16501)
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16406)
-- Name: City; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."City" (
    id character varying(255) NOT NULL,
    name character varying(189) NOT NULL,
    country_id character varying(255)
);


ALTER TABLE "Schema1"."City" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16396)
-- Name: Country; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."Country" (
    id character varying(255) NOT NULL,
    name character varying(90) NOT NULL
);


ALTER TABLE "Schema1"."Country" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16439)
-- Name: Measure; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."Measure" (
    id character varying(255) NOT NULL,
    nature character varying(100),
    date timestamp without time zone,
    value double precision,
    sensor_id bigint
);


ALTER TABLE "Schema1"."Measure" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16429)
-- Name: Sensor; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."Sensor" (
    id bigint NOT NULL,
    city_id character varying(255),
    latitude numeric,
    longitude numeric
);


ALTER TABLE "Schema1"."Sensor" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16490)
-- Name: Users; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."Users" (
    id integer NOT NULL,
    email text NOT NULL,
    password text NOT NULL
);


ALTER TABLE "Schema1"."Users" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16488)
-- Name: users_id_seq; Type: SEQUENCE; Schema: Schema1; Owner: postgres
--

CREATE SEQUENCE "Schema1".users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Schema1".users_id_seq OWNER TO postgres;

--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 202
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: Schema1; Owner: postgres
--

ALTER SEQUENCE "Schema1".users_id_seq OWNED BY "Schema1"."Users".id;


--
-- TOC entry 2727 (class 2604 OID 16493)
-- Name: Users id; Type: DEFAULT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Users" ALTER COLUMN id SET DEFAULT nextval('"Schema1".users_id_seq'::regclass);


--
-- TOC entry 2865 (class 0 OID 16406)
-- Dependencies: 199
-- Data for Name: City; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."City" (id, name, country_id) FROM stdin;
ParisId	Zbrarazrharazr	FR
\.


--
-- TOC entry 2864 (class 0 OID 16396)
-- Dependencies: 198
-- Data for Name: Country; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."Country" (id, name) FROM stdin;
FR	IBRAHIM
\.


--
-- TOC entry 2867 (class 0 OID 16439)
-- Dependencies: 201
-- Data for Name: Measure; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."Measure" (id, nature, date, value, sensor_id) FROM stdin;
\.


--
-- TOC entry 2866 (class 0 OID 16429)
-- Dependencies: 200
-- Data for Name: Sensor; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."Sensor" (id, city_id, latitude, longitude) FROM stdin;
15425	ParisId	\N	\N
\.


--
-- TOC entry 2869 (class 0 OID 16490)
-- Dependencies: 203
-- Data for Name: Users; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."Users" (id, email, password) FROM stdin;
\.


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 202
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: Schema1; Owner: postgres
--

SELECT pg_catalog.setval('"Schema1".users_id_seq', 1, false);


--
-- TOC entry 2731 (class 2606 OID 16413)
-- Name: City City_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."City"
    ADD CONSTRAINT "City_pkey" PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 16400)
-- Name: Country Country_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Country"
    ADD CONSTRAINT "Country_pkey" PRIMARY KEY (id);


--
-- TOC entry 2733 (class 2606 OID 16433)
-- Name: Sensor Sensor_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Sensor"
    ADD CONSTRAINT "Sensor_pkey" PRIMARY KEY (id);


--
-- TOC entry 2735 (class 2606 OID 16443)
-- Name: Measure measure_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Measure"
    ADD CONSTRAINT measure_pkey PRIMARY KEY (id);


--
-- TOC entry 2737 (class 2606 OID 16500)
-- Name: Users users_email_key; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Users"
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 2739 (class 2606 OID 16498)
-- Name: Users users_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Users"
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2741 (class 2606 OID 16465)
-- Name: Sensor city_id_FK; Type: FK CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Sensor"
    ADD CONSTRAINT "city_id_FK" FOREIGN KEY (city_id) REFERENCES "Schema1"."City"(id);


--
-- TOC entry 2740 (class 2606 OID 16460)
-- Name: City country_id_FK; Type: FK CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."City"
    ADD CONSTRAINT "country_id_FK" FOREIGN KEY (country_id) REFERENCES "Schema1"."Country"(id);


--
-- TOC entry 2742 (class 2606 OID 16470)
-- Name: Measure sensor_id_FK; Type: FK CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Measure"
    ADD CONSTRAINT "sensor_id_FK" FOREIGN KEY (sensor_id) REFERENCES "Schema1"."Sensor"(id);


-- Completed on 2018-10-31 13:53:18

--
-- PostgreSQL database dump complete
--

