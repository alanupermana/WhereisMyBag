  create table databaseLocation (
  id_location varchar(10),
  locations varchar(30),
  constraint databaseLocation_pk PRIMARY KEY (id_location)
  );
--------------------------------------------------------------------------------  
  create table databaseBarcode(
  id_barcode varchar(10),
  constraint databaseBarcode_pk PRIMARY KEY (id_barcode)
  );
-----------------------------------------------------------------------------------------------------------  
  create table scanner(
  id_scanner varchar(10),
  id_location varchar(30),
  constraint scanner_pk PRIMARY KEY (id_scanner),
  constraint scanner_fk FOREIGN KEY (id_location)references databaseLocation(id_location) on delete cascade
  );
-----------------------------------------------------------------------------------------------------------  
  create table penumpang (
  id_user varchar(10),
  nama varchar(30),
  constraint penumpang_pk PRIMARY KEY (id_user)
  );
--------------------------------------------------------------------------------  
  create table ticket (
  id_ticket varchar(10),
  constraint ticket_pk PRIMARY KEY (id_ticket)
  );
--------------------------------------------------------------------------------  
  create table boardingPass (
  id_boardingPass varchar(10),
  barcode varchar(7),
  nama_penumpang varchar(30),
  destinasi varchar(30),
  constraint boardingPass_pk PRIMARY KEY (id_boardingPass)
  );
 -----------------------------------------------------------------------------
  create table petugas(
  id_petugas varchar(10),
  nama varchar(30),
  id_barcode varchar(10),
  constraint petugas_pk PRIMARY KEY (id_petugas),
  constraint petugas_fk FOREIGN KEY (id_barcode)references databaseBarcode(id_barcode) on delete cascade
  );
 -------------------------------------------------------------------------------------------------------
  create table barang (
  id_barang varchar(10),
  id_petugas varchar(10),
  id_user varchar(10),
  id_boardingPass varchar(10),
  jenis varchar2(15),
  berat varchar2(10),
  constraint barang_pk PRIMARY KEY (id_barang) ENABLE,
  constraint barang_fk FOREIGN KEY (id_user)references penumpang (id_user) on delete cascade,
  constraint barang2_fk FOREIGN KEY (id_petugas)references petugas (id_petugas) on delete cascade,
  constraint barang3_fk FOREIGN KEY (id_boardingPass)references boardingPass (id_boardingPass) on delete cascade
  );
  ---------------------------------------------------------------------------------------------------------------
  create table pindai(
  id_scanner varchar(10),
  id_barang varchar(10),
  constraint pindai_fk FOREIGN KEY (id_scanner)references scanner(id_scanner) on delete cascade,
  constraint pindai1_fk FOREIGN KEY (id_barang)references barang(id_barang) on delete cascade
  );
 -------------------------------------------------------------------------------------------------- 
  insert into databaseBarcode values ('89149');
  insert into databaseBarcode values ('11021');
  insert into databaseBarcode values ('10193');
  insert into databaseBarcode values ('32124');
  insert into databaseBarcode values ('35914');
  insert into databaseBarcode values ('21519');
  insert into databaseBarcode values ('46438');
  insert into databaseBarcode values ('21667');
  insert into databaseBarcode values ('41313');
  insert into databaseBarcode values ('35744');
  insert into databaseBarcode values ('35839');
  insert into databaseBarcode values ('77193');
  insert into databaseBarcode values ('20792');
  insert into databaseBarcode values ('62195');
  insert into databaseBarcode values ('79792');
  insert into databaseBarcode values ('92877');
  insert into databaseBarcode values ('68429');
  insert into databaseBarcode values ('27047');
  insert into databaseBarcode values ('70011');
  insert into databaseBarcode values ('88225');
-----------------------------------------------------------------------------  
  insert into databaseLocation values ('A1908','CGK_GATE_A');
  insert into databaseLocation values ('B1875','CGK_GATE_B');
  insert into databaseLocation values ('D5379','CGK_GATE_D');
  insert into databaseLocation values ('F9267','CGK_GATE_F');
  insert into databaseLocation values ('E6439','CGK_GATE_E');
  insert into databaseLocation values ('H1368','CGK_GATE_H');
  insert into databaseLocation values ('G6195','CGK_GATE_G');
  insert into databaseLocation values ('I8563','CGK_GATE_I');
  insert into databaseLocation values ('C0987','CGK_GATE_C');
  insert into databaseLocation values ('B1547','NGK_GATE_B');
  insert into databaseLocation values ('A6879','NGK_GATE_A');
  insert into databaseLocation values ('D0956','NGK_GATE_D');
  insert into databaseLocation values ('F3580','NGK_GATE_F');
  insert into databaseLocation values ('E0869','NGK_GATE_E');
  insert into databaseLocation values ('H1769','NGK_GATE_H');
  insert into databaseLocation values ('G6890','NGK_GATE_G');
  insert into databaseLocation values ('C1578','NGK_GATE_C');
 -------------------------------------------------------------- 
  select locations, id_barcode
  from databaseBarcode
  join petugas using (id_barcode)
  join barang using (id_petugas)
  join pindai using (id_barang)
  join scanner using (id_scanner)
  join databaseLocation using (id_location)
  where id_barcode = '35744';
  -------------------------------------------------------------
  update databaseLocation set locations ='NGK_GATE_C'
  where id_location = 'C1578';
  
  -------------------------------------------------------------
  delete from database_barcode
  where id_barcode = '89149';

  
  
  