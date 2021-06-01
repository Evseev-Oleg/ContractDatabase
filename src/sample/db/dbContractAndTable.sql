create DATABASE contractBase;

create TABLE contract(
       id int NOT NULL AUTO_INCREMENT,
       date_contract date NOT NULL,
       number_contract int NOT NULL,
       date_change date NOT NULL,
       PRIMARY KEY (id));
