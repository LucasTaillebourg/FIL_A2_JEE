--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-24 14:16:06

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
-- TOC entry 8 (class 2615 OID 16395)
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
-- TOC entry 2826 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 16406)
-- Name: City; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."City" (
    id character varying(255) NOT NULL,
    name character varying(189) NOT NULL,
    "countryId" character varying(255)
);


ALTER TABLE "Schema1"."City" OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16396)
-- Name: Country; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."Country" (
    id character varying(255) NOT NULL,
    name character varying(90) NOT NULL
);


ALTER TABLE "Schema1"."Country" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16439)
-- Name: Measure; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."Measure" (
    id character varying(255) NOT NULL,
    nature character varying(100),
    date timestamp without time zone,
    value double precision,
    "sensorId" bigint
);


ALTER TABLE "Schema1"."Measure" OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16429)
-- Name: Sensor; Type: TABLE; Schema: Schema1; Owner: postgres
--

CREATE TABLE "Schema1"."Sensor" (
    id bigint NOT NULL,
    "cityId" character varying(255),
    latitude numeric,
    longitude numeric
);


ALTER TABLE "Schema1"."Sensor" OWNER TO postgres;

--
-- TOC entry 2816 (class 0 OID 16406)
-- Dependencies: 198
-- Data for Name: City; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."City" (id, name, "countryId") FROM stdin;
ParisId	Paris	FR
\.


--
-- TOC entry 2815 (class 0 OID 16396)
-- Dependencies: 197
-- Data for Name: Country; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."Country" (id, name) FROM stdin;
FR	France
\.


--
-- TOC entry 2818 (class 0 OID 16439)
-- Dependencies: 200
-- Data for Name: Measure; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."Measure" (id, nature, date, value, "sensorId") FROM stdin;
\.


--
-- TOC entry 2817 (class 0 OID 16429)
-- Dependencies: 199
-- Data for Name: Sensor; Type: TABLE DATA; Schema: Schema1; Owner: postgres
--

COPY "Schema1"."Sensor" (id, "cityId", latitude, longitude) FROM stdin;
15425	ParisId	\N	\N
\.


--
-- TOC entry 2686 (class 2606 OID 16413)
-- Name: City City_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."City"
    ADD CONSTRAINT "City_pkey" PRIMARY KEY (id);


--
-- TOC entry 2684 (class 2606 OID 16400)
-- Name: Country Country_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Country"
    ADD CONSTRAINT "Country_pkey" PRIMARY KEY (id);


--
-- TOC entry 2688 (class 2606 OID 16433)
-- Name: Sensor Sensor_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Sensor"
    ADD CONSTRAINT "Sensor_pkey" PRIMARY KEY (id);


--
-- TOC entry 2690 (class 2606 OID 16443)
-- Name: Measure measure_pkey; Type: CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Measure"
    ADD CONSTRAINT measure_pkey PRIMARY KEY (id);


--
-- TOC entry 2692 (class 2606 OID 16434)
-- Name: Sensor cityIdFK; Type: FK CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Sensor"
    ADD CONSTRAINT "cityIdFK" FOREIGN KEY ("cityId") REFERENCES "Schema1"."City"(id);


--
-- TOC entry 2691 (class 2606 OID 16414)
-- Name: City countryIdFK; Type: FK CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."City"
    ADD CONSTRAINT "countryIdFK" FOREIGN KEY ("countryId") REFERENCES "Schema1"."Country"(id);


--
-- TOC entry 2693 (class 2606 OID 16444)
-- Name: Measure sensorIdFK; Type: FK CONSTRAINT; Schema: Schema1; Owner: postgres
--

ALTER TABLE ONLY "Schema1"."Measure"
    ADD CONSTRAINT "sensorIdFK" FOREIGN KEY ("sensorId") REFERENCES "Schema1"."Sensor"(id);


-- Completed on 2018-10-24 14:16:08

--
-- PostgreSQL database dump complete
--

