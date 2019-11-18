  
INSERT INTO doctor ( id,name,hospital_id,type,date_available,time_available,rate,status,created_on,created_by,modified_on,modified_by)
VALUES (1, 'Dr. Kumarswamy','1001','Dentist','Monday,WednesDay,Friday','9 to 11',500,'Y',sysdate(),'admin',sysdate(),'admin');
INSERT INTO doctor ( id,name,hospital_id,type,date_available,time_available,rate,status,created_on,created_by,modified_on,modified_by)
VALUES (2, 'Dr. Smita','1002','Dentist','Monday,WednesDay,Friday','9 to 11',500,'Y',sysdate(),'admin',sysdate(),'admin');

INSERT INTO hospital(hospital_id,hospital_name,created_on,created_by,modified_on,modified_by)
VALUES('1001','ABC',sysdate(),'admin',sysdate(),'admin');
INSERT INTO hospital(hospital_id,hospital_name,created_on,created_by,modified_on,modified_by)
VALUES('1002','XYZ',sysdate(),'admin',sysdate(),'admin');