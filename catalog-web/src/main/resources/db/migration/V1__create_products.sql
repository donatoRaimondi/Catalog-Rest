CREATE TABLE IF NOT EXISTS products (
  id VARCHAR(50) primary key,
  name VARCHAR(255) not null,
  active BOOLEAN not null default true
);

INSERT INTO products (id, name, active) values
('1', 'Keyboard', true),
('2', 'Mouse', true)
on conflict (id) do nothing;
