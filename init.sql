SELECT 'CREATE DATABASE file_db' WHERE NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'file_db');
