-- Database initialization script for docker-compose-demo
-- This script creates the customer table

CREATE TABLE IF NOT EXISTS customer (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

-- Optional: Insert some sample data
-- INSERT INTO customer (first_name, last_name) VALUES 
--     ('Gozde', 'Yalcin'),
--     ('Boncuk', 'Yalcin');

-- Grant permissions (optional)
GRANT ALL PRIVILEGES ON TABLE customer TO testuser;
GRANT USAGE, SELECT ON SEQUENCE customer_id_seq TO testuser;
