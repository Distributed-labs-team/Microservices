CREATE KEYSPACE IF NOT EXISTS statistic_service WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;
CREATE TABLE IF NOT EXISTS statistic_service.event_store (
id timeuuid,
idUser text,
time_stamp timestamp,
PRIMARY KEY (id)
);