--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-11-04 01:16:01

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
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 2 (class 3079 OID 16539)
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 16576)
-- Name: City; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."City" (
    id character varying(255) NOT NULL,
    name character varying(189) NOT NULL,
    country_id character varying(255)
);


ALTER TABLE public."City" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16582)
-- Name: Country; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Country" (
    id character varying(255) NOT NULL,
    name character varying(90) NOT NULL
);


ALTER TABLE public."Country" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16632)
-- Name: measure_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.measure_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.measure_seq OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16585)
-- Name: Measure; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Measure" (
    nature character varying(100),
    date timestamp without time zone,
    value double precision,
    sensor_id bigint,
    id bigint DEFAULT nextval('public.measure_seq'::regclass) NOT NULL
);


ALTER TABLE public."Measure" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16588)
-- Name: Sensor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Sensor" (
    id bigint NOT NULL,
    city_id character varying(255),
    latitude numeric,
    longitude numeric
);


ALTER TABLE public."Sensor" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16594)
-- Name: Users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Users" (
    id integer NOT NULL,
    email text NOT NULL,
    password text NOT NULL
);


ALTER TABLE public."Users" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16600)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 202
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public."Users".id;


--
-- TOC entry 2729 (class 2604 OID 16602)
-- Name: Users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users" ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 203
-- Name: measure_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.measure_seq', 6, true);


--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 202
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- TOC entry 2731 (class 2606 OID 16604)
-- Name: City City_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."City"
    ADD CONSTRAINT "City_pkey" PRIMARY KEY (id);


--
-- TOC entry 2733 (class 2606 OID 16606)
-- Name: Country Country_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Country"
    ADD CONSTRAINT "Country_pkey" PRIMARY KEY (id);


--
-- TOC entry 2737 (class 2606 OID 16608)
-- Name: Sensor Sensor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Sensor"
    ADD CONSTRAINT "Sensor_pkey" PRIMARY KEY (id);


--
-- TOC entry 2735 (class 2606 OID 16635)
-- Name: Measure id_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Measure"
    ADD CONSTRAINT "id_PK" PRIMARY KEY (id);


--
-- TOC entry 2739 (class 2606 OID 16612)
-- Name: Users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 2741 (class 2606 OID 16614)
-- Name: Users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2744 (class 2606 OID 16615)
-- Name: Sensor city_id_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Sensor"
    ADD CONSTRAINT "city_id_FK" FOREIGN KEY (city_id) REFERENCES public."City"(id);


--
-- TOC entry 2742 (class 2606 OID 16620)
-- Name: City country_id_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."City"
    ADD CONSTRAINT "country_id_FK" FOREIGN KEY (country_id) REFERENCES public."Country"(id);


--
-- TOC entry 2743 (class 2606 OID 16625)
-- Name: Measure sensor_id_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Measure"
    ADD CONSTRAINT "sensor_id_FK" FOREIGN KEY (sensor_id) REFERENCES public."Sensor"(id);


-- Completed on 2018-11-04 01:16:03

--
-- PostgreSQL database dump complete
--
