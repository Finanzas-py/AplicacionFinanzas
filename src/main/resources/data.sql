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
