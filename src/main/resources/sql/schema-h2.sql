DROP TABLE IF EXISTS incidents;

CREATE TABLE IF NOT EXISTS incidents (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  clientId INT,
  data DATE,
  startTimeHH INT,
  startTimeMM INT,
  finishTimeHH INT,
  finishTimeMM INT,
  duration INT,
  description TEXT NOT NULL,
  subject TEXT NOT NULL,
  transactions INT,
  );

DROP TABLE IF EXISTS clients;

CREATE TABLE IF NOT EXISTS clients(
  clientId INT NOT NULL,
  clientName TEXT NOT NULL
  );

