DROP TABLE IF EXISTS incidents;

CREATE TABLE IF NOT EXISTS incidents (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  clientId INTEGER,
  data DATE,
  startTimeHH INTEGER,
  statTimeSS INTEGER,
  finishTimeHH INTEGER,
  finishTimeSS INTEGER,
  duration INTEGER,
  description TEXT NOT NULL,
  subject TEXT NOT NULL,
  transactions INTEGER,
  type TEXT,
  component TEXT
  );

DROP TABLE IF EXISTS clients;

CREATE TABLE IF NOT EXISTS clients(
  clientId INT NOT NULL,
  clientName TEXT NOT NULL
  );

