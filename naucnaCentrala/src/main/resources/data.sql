insert into user_data(id, email, grad, ime, odobren_recenzent, password, prezime, recenzent, scientific_area, titula, username, role) values 
(1,'demo@gmail.com','kula','demo',true,'demo','demo',true,'demo' , 'demo', 'demo', 'admin');
insert into user_data(id, email, grad, ime, odobren_recenzent, password, prezime, recenzent, scientific_area, titula, username, role) values 
(2,'urednik@gmail.com','kula','urednik',true,'urednik','urednik',true,'urednik' , 'urednik', 'urednik', 'urednik');
insert into user_data(id, email, grad, ime, odobren_recenzent, password, prezime, recenzent, scientific_area, titula, username, role) values 
(3,'autor@gmail.com','kula','autor',false,'autor','autor',false,'autor' , 'autor', 'autor', 'autor');
insert into user_data(id, email, grad, ime, odobren_recenzent, password, prezime, recenzent, scientific_area, titula, username, role) values 
(4,'urednik1@gmail.com','kula','urednik1',true,'urednik1','urednik1',true,'Naucna oblast 1,' , 'urednik1', 'urednik1', 'urednik');
insert into user_data(id, email, grad, ime, odobren_recenzent, password, prezime, recenzent, scientific_area, titula, username, role) values 
(5,'recenzent@gmail.com','kula','recenzent',true,'recenzent','recenzent',true,'recenzent' , 'recenzent', 'recenzent', 'recenzent');
insert into user_data(id, email, grad, ime, odobren_recenzent, password, prezime, recenzent, scientific_area, titula, username, role) values 
(6,'recenzent1@gmail.com','kula','recenzent1',true,'recenzent1','recenzent1',true,'recenzent1' , 'recenzent1', 'recenzent1', 'recenzent');
insert into scientific_area(id, scientific_area) values (1, 'Naucna oblast 1');
insert into scientific_area(id, scientific_area) values (2, 'Naucna oblast 2');
insert into scientific_area(id, scientific_area) values (3, 'Naucna oblast 3');
insert into scientific_area(id, scientific_area) values (4, 'Naucna oblast 4');
insert into scientific_area(id, scientific_area) values (5, 'Naucna oblast 5');
insert into magazine_data(id, aktivnost, glavni_urednik, isdn, komentar, naucne_oblasti, naziv, open_access, procesid, provera_podataka, publish_magazina, recenzenti, urednici) 
values (1, true, 'urednik', 234, '', 'Naucna Oblast 3,', 'asfaf', true, 'df9ff441-4b9a-11ea-aa3f-daf2ca3bbc08', true, true, 'recenzent,', 'urednik,');
insert into magazine_data(id, aktivnost, glavni_urednik, isdn, komentar, naucne_oblasti, naziv, open_access, procesid, provera_podataka, publish_magazina, recenzenti, urednici) 
values (2, true, 'urednik', 2344, '', 'Naucna Oblast 4,', 'asfafasdas', false, 'e7f437e8-4b9a-11ea-aa3f-daf2ca3bbc08', true, true, 'recenzent1,', 'urednik1,');