INSERT INTO incidents (id, clientId, data, startTimeHH, startTimeMM, finishTimeHH,finishTimeMM,duration, description, subject,transactions) VALUES
  (1,1, '2019-01-05', '01','5','2','10','65','First incident description','First incident subject','500'),
  (2,1, '2019-01-06', '02','27','04','27','120','Second incident description','Second incident subject','1'),
  (3,2, '2019-01-07', '13','15','14','15','60','Thrid incident description','Thrid incident subject','100');

INSERT INTO clients (clientId, clientName) VALUES
(1,'First Client Name'),
(2,'Second Client Name'),
(3,'Thrid Client Name'),
