CREATE TABLE Ambassador 
(	first_name			VARCHAR(20)		NOT NULL,
	last_name 			VARCHAR(20) 	NOT NULL,
	email				VARCHAR(25)		NOT NULL,
	major				VARCHAR(50)		NOT NULL,
	graduation_date		DATE,
	comm_name			VARCHAR(20)		NOT NULL,
	dept_name			VARCHAR(60)		NOT NULL,
	PRIMARY KEY(email),
	FOREIGN KEY(comm_name) REFERENCES Committee(cname),
	FOREIGN KEY(dept_name) REFERENCES Department(dname) );

CREATE TABLE Committee
(	cname				VARCHAR(20)		NOT NULL,
	leader_email 		VARCHAR(25) 	NOT NULL,
	PRIMARY KEY(cname),
	UNIQUE(leader_email),
	FOREIGN KEY(leader_email) REFERENCES Ambassador(email) );

CREATE TABLE Department
(	dname				VARCHAR(60)		NOT NULL,
	dchair 				VARCHAR(25) 	NOT NULL,
	dlocation			INT				NOT NULL,
	PRIMARY KEY(dname, dchair) );

CREATE TABLE Committee_Events
(	ename				VARCHAR(30)		NOT NULL,
	enum				INT				NOT NULL,
	comm_name			VARCHAR(20)		NOT NULL,
	PRIMARY KEY(ename, enum),
	FOREIGN KEY(comm_name) REFERENCES Committee(cname) );


INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Jason', 'Wherry', 'jw473415@ohio.edu', 'Computer Science', '2020-05', 'Service', 'School of Electrical Engineering and Computer Science');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Lydia', 'Shiffler', 'ls512815@ohio.edu', 'Computer Science', '2020-05', 'X', 'School of Electrical Engineering and Computer Science');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Tim', 'Napoli', 'tn017316@ohio.edu', 'Aviation', '2021-05', 'X', 'Department of Aviation');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Kimi', 'Segarra-Ibañez', 'as789615@ohio.edu', 'Aviation', '2020-05', 'X', 'Department of Aviation');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Charlotte', 'Kapral', 'ck652614@ohio.edu', 'Chemical Engineering', '2020-05', 'x', 'Department of Chemical and Biomolecular Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Melissa', 'Kuchta', 'mk259215@ohio.edu', 'Chemical Engineering', '2020-05', 'x', 'Department of Chemical and Biomolecular Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Lydia', 'Seiter', 'ls095014@ohio.edu', 'Chemical Engineering', '2020-05', 'x', 'Department of Chemical and Biomolecular Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Haley', 'Nau', 'hn625815@ohio.edu', 'Civil Engineering', '2021-05', 'x', 'Department of Civil Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Lydia', 'Ramlo', 'lr822514@ohio.edu', 'Civil Engineering', '2020-05', 'x', 'Department of Civil Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Alexis', 'Lanier', 'al628814@ohio.edu', 'Electrical Engineering', '2020-05', 'x', 'Electrical Engineering and Computer Science');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Dillon', 'Mahr', 'dm453216@ohio.edu', 'Electrical Engineering', '2021-05', 'x', 'Electrical Engineering and Computer Science');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Reagan', 'Richardson', 'rr059715@ohio.edu', 'Energy Engineering', '2021-05', 'Service', 'Department of ...');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Allie', 'Gabbard', 'ag515615@ohio.edu', 'Engineering Technology and Management', '2020-05', 'Service', 'Department of Engineering Technology and Management');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Adam', 'Kirby', 'ak535214@ohio.edu', 'Engineering Technology and Management', '2020-05', 'x', 'Department of Engineering Technology and Management');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Hope', 'Bowden', 'hb295315@ohio.edu', 'Industrial and Systems Engineering', '2020-05', 'x', 'Department of Industrial and Systems Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Alvin', 'Chaney', 'ac410815@ohio.edu', 'Industrial and Systems Engineering', '2020-05', 'x', 'Department of Industrial and Systems Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Maggie', 'Allen', 'ma571115@ohio.edu', 'Mechanical Engineering', '2020-05', 'x', 'Department of Mechanical Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Kay', 'Dunlevy', 'kd508816@ohio.edu', 'Mechanical Engineering', '2020-05', 'x', 'Department of Mechanical Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Brittany', ' Hesson', 'bh070215@ohio.edu', 'Mechanical Engineering', '2020-05', 'x', 'Department of Mechanical Engineering');

INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name)
VALUES('Logan', 'Veley', 'lv199716@ohio.edu', 'Mechanical Engineering', '2021-05', 'x', 'Department of Mechanical Engineering');






