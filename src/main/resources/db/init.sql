CREATE  TABLE  heroes (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT,
  power TEXT,
  weakness TEXT,
  squadId INTEGER
);

CREATE  TABLE  squads (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  squadName TEXT,
  cause TEXT,
  maxSize INTEGER,
  createdAt TEXT
);