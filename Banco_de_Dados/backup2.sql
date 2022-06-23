--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

-- Started on 2022-06-16 23:28:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3352 (class 1262 OID 16394)
-- Name: Desktop_T3; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Desktop_T3" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE "Desktop_T3" OWNER TO postgres;

\connect "Desktop_T3"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 16399)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    tipo character varying(10),
    nome character varying(50),
    email character varying(30),
    telefone character varying(12),
    documento1 character varying(18),
    documento2 character varying(30),
    estado character varying(3),
    cidade character varying(20),
    bairro character varying(20),
    rua character varying(20),
    numero integer,
    complemento character varying(20)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16398)
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 210
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_cliente_seq OWNED BY public.cliente.id_cliente;


--
-- TOC entry 215 (class 1259 OID 16418)
-- Name: item_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item_venda (
    id_item_venda integer NOT NULL,
    id_produto_item integer NOT NULL,
    quantidade integer NOT NULL,
    valor_item real NOT NULL
);


ALTER TABLE public.item_venda OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16417)
-- Name: item_venda_id_item_venda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.item_venda_id_item_venda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.item_venda_id_item_venda_seq OWNER TO postgres;

--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 214
-- Name: item_venda_id_item_venda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.item_venda_id_item_venda_seq OWNED BY public.item_venda.id_item_venda;


--
-- TOC entry 213 (class 1259 OID 16406)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id_produto integer NOT NULL,
    nome character varying(50),
    preco numeric NOT NULL,
    descricao character varying(100)
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16405)
-- Name: produto_id_produto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_produto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_produto_seq OWNER TO postgres;

--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 212
-- Name: produto_id_produto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_produto_seq OWNED BY public.produto.id_produto;


--
-- TOC entry 209 (class 1259 OID 16395)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    nome character varying(20),
    senha character varying(10)
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16440)
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venda (
    id_venda integer NOT NULL,
    id_cliente integer,
    id_item_venda integer,
    valor_total real
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16439)
-- Name: venda_id_venda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.venda_id_venda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.venda_id_venda_seq OWNER TO postgres;

--
-- TOC entry 3356 (class 0 OID 0)
-- Dependencies: 216
-- Name: venda_id_venda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.venda_id_venda_seq OWNED BY public.venda.id_venda;


--
-- TOC entry 3183 (class 2604 OID 16402)
-- Name: cliente id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_cliente_seq'::regclass);


--
-- TOC entry 3185 (class 2604 OID 16421)
-- Name: item_venda id_item_venda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda ALTER COLUMN id_item_venda SET DEFAULT nextval('public.item_venda_id_item_venda_seq'::regclass);


--
-- TOC entry 3184 (class 2604 OID 16409)
-- Name: produto id_produto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id_produto SET DEFAULT nextval('public.produto_id_produto_seq'::regclass);


--
-- TOC entry 3186 (class 2604 OID 16443)
-- Name: venda id_venda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda ALTER COLUMN id_venda SET DEFAULT nextval('public.venda_id_venda_seq'::regclass);


--
-- TOC entry 3340 (class 0 OID 16399)
-- Dependencies: 211
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente (id_cliente, tipo, nome, email, telefone, documento1, documento2, estado, cidade, bairro, rua, numero, complemento) VALUES (1, 'FÍSICA', 'luan william', 'luan@hotmail.com', '43998666410', '9875412345', '78945612345', 'SP', 'marilia', 'centro', '9 de julho', 99, 'apt 35');
INSERT INTO public.cliente (id_cliente, tipo, nome, email, telefone, documento1, documento2, estado, cidade, bairro, rua, numero, complemento) VALUES (2, 'JURÍDICA', 'nome william', '', '4343', 'fantasia', '789456132', 'AC', 'marilia', 'centro', '9 de julho', 99, 'apt35');
INSERT INTO public.cliente (id_cliente, tipo, nome, email, telefone, documento1, documento2, estado, cidade, bairro, rua, numero, complemento) VALUES (4, 'FÍSICA', 'testado', 'testado@testado', 'testado', 'testado', 'testado', 'AC', 'testado', 'testado', 'testado', 76, 'testado');
INSERT INTO public.cliente (id_cliente, tipo, nome, email, telefone, documento1, documento2, estado, cidade, bairro, rua, numero, complemento) VALUES (3, 'FÍSICA', 'luan', 'luan@luan', '43998666410', '9876542352', '78945612345', 'AC', 'marilia', 'centro', '9 de julho', 1052, 'apt32');


--
-- TOC entry 3344 (class 0 OID 16418)
-- Dependencies: 215
-- Data for Name: item_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (2, 1, 1, 30);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (3, 5, 1500, 67500);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (4, 5, 2000, 90000);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (5, 3, 2000, 12000);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (11, 1, 1, 30);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (12, 1, 50, 1500);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (13, 3, 50, 300);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (14, 4, 50, 1500);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (15, 6, 50, 1000);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (16, 3, 999999, 5.999994e+06);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (17, 2, 999999, 9.99999e+06);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (18, 3, 999999, 5.999994e+06);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (19, 2, 999999, 9.99999e+06);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (7, 5, 999999, 4.4999956e+07);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (8, 3, 999999, 5.999994e+06);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (9, 2, 999999, 9.99999e+06);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (20, 5, 5000, 225000);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (21, 6, 5000, 100000);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (22, 3, 5000, 30000);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (23, 4, 5000, 150000);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (24, 1, 5, 150);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (25, 2, 5, 50);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (26, 3, 5, 30);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (27, 4, 5, 150);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (28, 5, 5, 225);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (29, 6, 5, 100);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (30, 3, 10, 60);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (31, 5, 10, 450);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (32, 6, 10, 200);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (33, 4, 10, 300);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (34, 2, 3, 30);
INSERT INTO public.item_venda (id_item_venda, id_produto_item, quantidade, valor_item) VALUES (35, 4, 3, 90);


--
-- TOC entry 3342 (class 0 OID 16406)
-- Dependencies: 213
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.produto (id_produto, nome, preco, descricao) OVERRIDING SYSTEM VALUE VALUES (1, 'arroz', 30, '5kg, tipo 1');
INSERT INTO public.produto (id_produto, nome, preco, descricao) OVERRIDING SYSTEM VALUE VALUES (2, 'feijao', 10, '2kg, tipo 1');
INSERT INTO public.produto (id_produto, nome, preco, descricao) OVERRIDING SYSTEM VALUE VALUES (5, 'alcatra', 45, 'kilo, carne vermelha');
INSERT INTO public.produto (id_produto, nome, preco, descricao) OVERRIDING SYSTEM VALUE VALUES (3, 'macarrao parafuso', 6, '500g, integral');
INSERT INTO public.produto (id_produto, nome, preco, descricao) OVERRIDING SYSTEM VALUE VALUES (6, 'peito de frango', 20, 'filé de peito de frango, kilo');
INSERT INTO public.produto (id_produto, nome, preco, descricao) OVERRIDING SYSTEM VALUE VALUES (4, 'maçã', 30, 'Fruta por kilo');


--
-- TOC entry 3338 (class 0 OID 16395)
-- Dependencies: 209
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuarios (nome, senha) VALUES ('admin', 'admin');
INSERT INTO public.usuarios (nome, senha) VALUES ('luan', 'luan');


--
-- TOC entry 3346 (class 0 OID 16440)
-- Dependencies: 217
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (1, 3, 24, 705);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (1, 3, 25, 705);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (1, 3, 26, 705);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (1, 3, 27, 705);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (1, 3, 28, 705);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (1, 3, 29, 705);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (2, 3, 30, 1010);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (2, 3, 31, 1010);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (2, 3, 32, 1010);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (2, 3, 33, 1010);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (3, 2, 34, 120);
INSERT INTO public.venda (id_venda, id_cliente, id_item_venda, valor_total) VALUES (3, 2, 35, 120);


--
-- TOC entry 3357 (class 0 OID 0)
-- Dependencies: 210
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_cliente_seq', 1, false);


--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 214
-- Name: item_venda_id_item_venda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.item_venda_id_item_venda_seq', 1, false);


--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 212
-- Name: produto_id_produto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_produto_seq', 1, false);


--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 216
-- Name: venda_id_venda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.venda_id_venda_seq', 1, false);


--
-- TOC entry 3190 (class 2606 OID 16433)
-- Name: produto id_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT id_produto_pkey PRIMARY KEY (id_produto) INCLUDE (id_produto);


--
-- TOC entry 3188 (class 2606 OID 16404)
-- Name: cliente pk_id_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_id_cliente PRIMARY KEY (id_cliente);


--
-- TOC entry 3193 (class 2606 OID 16423)
-- Name: item_venda pk_id_item_venda; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT pk_id_item_venda PRIMARY KEY (id_item_venda);


--
-- TOC entry 3194 (class 1259 OID 24611)
-- Name: fk_id_cliente; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_id_cliente ON public.venda USING btree (id_cliente);


--
-- TOC entry 3195 (class 1259 OID 24617)
-- Name: fk_id_item_produto; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_id_item_produto ON public.venda USING btree (id_item_venda);


--
-- TOC entry 3191 (class 1259 OID 24599)
-- Name: id_produto_item_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX id_produto_item_fk ON public.item_venda USING btree (id_produto_item);


--
-- TOC entry 3196 (class 2606 OID 24600)
-- Name: item_venda fk_id_produto_item; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT fk_id_produto_item FOREIGN KEY (id_produto_item) REFERENCES public.produto(id_produto) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3197 (class 2606 OID 24606)
-- Name: venda id_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3198 (class 2606 OID 24612)
-- Name: venda id_item_produto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT id_item_produto FOREIGN KEY (id_item_venda) REFERENCES public.item_venda(id_item_venda) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2022-06-16 23:28:58

--
-- PostgreSQL database dump complete
--

