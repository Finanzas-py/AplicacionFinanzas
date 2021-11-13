INSERT INTO company(compay_name) VALUES ('Empresa');
INSERT INTO company(compay_name) VALUES ('BCP');
INSERT INTO company(compay_name) VALUES ('Interbank');
INSERT INTO company(compay_name) VALUES ('Continental');
INSERT INTO company(compay_name) VALUES ('Ninguna');

INSERT INTO type(name) VALUES ('Documento');
INSERT INTO type(name) VALUES ('DNI');
INSERT INTO type(name) VALUES ('RUC');

INSERT INTO reason_ci(name) VALUES ('Portes');
INSERT INTO reason_ci(name) VALUES ('Fotocopias');
INSERT INTO reason_ci(name) VALUES ('Comisión de estudio');
INSERT INTO reason_ci(name) VALUES ('Comisión de desembolso');
INSERT INTO reason_ci(name) VALUES ('Comisión de intermediación');
INSERT INTO reason_ci(name) VALUES ('Comisión de administración');
INSERT INTO reason_ci(name) VALUES ('Gastos notariales');
INSERT INTO reason_ci(name) VALUES ('Gastos registrales');
INSERT INTO reason_ci(name) VALUES ('Seguro');
INSERT INTO reason_ci(name) VALUES ('Otros Gastos');

INSERT INTO reason_cf(name) VALUES ('Portes');
INSERT INTO reason_cf(name) VALUES ('Gastos de administración');
INSERT INTO reason_cf(name) VALUES ('Otros Gastos');

INSERT INTO users(last_name,name,email,password,phone_number,id_company,id_type,type_text) 
VALUES ('Calcín','Kevin','kevin@gmail.com','123','969217457',1,1,'71736923');

INSERT INTO type_document(name) VALUES ('Factura');
INSERT INTO type_document(name) VALUES ('Letra');
INSERT INTO type_document(name) VALUES ('Recibo');

INSERT INTO rate_type(rate_name) VALUES ('Efectivo');
INSERT INTO rate_type(rate_name) VALUES ('Nominal');

INSERT INTO term_rate(term_name,num_days) VALUES ('Diario',1);
INSERT INTO term_rate(term_name,num_days) VALUES ('Quincenal',15);
INSERT INTO term_rate(term_name,num_days) VALUES ('Mensual',30);
INSERT INTO term_rate(term_name,num_days) VALUES ('Bimestral',60);
INSERT INTO term_rate(term_name,num_days) VALUES ('Trimestral',90);
INSERT INTO term_rate(term_name,num_days) VALUES ('Cuatrimestral',120);
INSERT INTO term_rate(term_name,num_days) VALUES ('Semestral',180);
INSERT INTO term_rate(term_name,num_days) VALUES ('Anual',360);
INSERT INTO term_rate(term_name,num_days) VALUES ('Especial',0);
