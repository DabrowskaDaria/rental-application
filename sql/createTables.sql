
DROP TABLE IF EXISTS computers_and_tablets CASCADE;
DROP TABLE IF EXISTS image_display CASCADE;
DROP TABLE IF EXISTS camera CASCADE;
DROP TABLE IF EXISTS lighting CASCADE;
DROP TABLE IF EXISTS audio_devices CASCADE;
DROP TABLE IF EXISTS device_categories CASCADE;
DROP TABLE IF EXISTS devices CASCADE;
DROP TABLE IF EXISTS devices_connectors CASCADE;
DROP TABLE IF EXISTS connectors CASCADE;
DROP TABLE IF EXISTS devices_favourites_lists CASCADE;
DROP TABLE IF EXISTS favourites_lists CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS companies CASCADE;
DROP TABLE IF EXISTS persons CASCADE;
DROP TABLE IF EXISTS carts CASCADE;
DROP TABLE IF EXISTS devices_carts CASCADE;
DROP TABLE IF EXISTS devices_rentals CASCADE;
DROP TABLE IF EXISTS rentals CASCADE;
DROP TABLE IF EXISTS invoices CASCADE;


CREATE TABLE IF NOT EXISTS computers_and_tablets(
    id SERIAL PRIMARY KEY,
    display VARCHAR(50) NOT NULL,
    procesor VARCHAR(50) NOT NULL,
    drive VARCHAR(50) NOT NULL,
    RAM INT NOT NULL,
    graphics_card VARCHAR(50),
    operating_system VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS image_display(
    id SERIAL PRIMARY KEY,
    screen_size VARCHAR(20),
    screen_resolution VARCHAR(20),
    refresh_rate INT,
    format VARCHAR(30),
    active_surface VARCHAR(20),
    matrix_type VARCHAR(30),
    lamp_power INT
);

CREATE TABLE IF NOT EXISTS camera(
    id SERIAL PRIMARY KEY,
    resolution VARCHAR(20) NOT NULL,
    image_stablization BOOLEAN NOT NULL,
    optical_zoom BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS lighting(
    id SERIAL PRIMARY KEY,
    lighting_color VARCHAR(20) NOT NULL,
    power_consumption INT NOT NULL,
    lamp_power INT NOT NULL,
    device_size VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS audio_devices(
    id SERIAL PRIMARY KEY,
    speakers_power VARCHAR(20),
    number_of_speakers INT,
    frequency_response VARCHAR(30),
    connection_type VARCHAR(30),
    headphone_type VARCHAR(30),
    microphone BOOLEAN,
    working_time INT,
    wireless_transmission BOOLEAN
);

CREATE TABLE IF NOT EXISTS device_categories(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE if not exists devices (
    id SERIAL PRIMARY KEY,
    fk_device_categories_id INT,
    fk_computers_and_tablets_id INT,
    fk_image_display_id INT,
    fk_camera_id INT,
    fk_audio_devices_id INT,
    fk_lighting_id INT,
    name VARCHAR (70) NOT NULL,
    price INT NOT NULL,
    deposit INT NOT NULL,
    description VARCHAR (300) NOT NULL,
    FOREIGN KEY (fk_device_categories_id) REFERENCES device_categories(id),
    FOREIGN KEY (fk_computers_and_tablets_id) REFERENCES computers_and_tablets(id),
    FOREIGN KEY (fk_image_display_id) REFERENCES image_display(id),
    FOREIGN KEY (fk_camera_id) REFERENCES camera(id),
    FOREIGN KEY (fk_audio_devices_id) REFERENCES audio_devices(id),
    FOREIGN KEY (fk_lighting_id) REFERENCES lighting(id)
);
CREATE TABLE IF NOT EXISTS connectors(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS devices_connectors(
    id SERIAL PRIMARY KEY,
    fk_connectors_id INT,
    fk_devices_id INT,
    FOREIGN KEY (fk_connectors_id) REFERENCES connectors(id),
    FOREIGN KEY (fk_devices_id) REFERENCES devices(id)
);

CREATE TABLE IF NOT EXISTS companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    company_number VARCHAR(10),
    place VARCHAR(60),
    street VARCHAR(60),
    bulding_number INT,
    zip_code VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    fk_companies_id INT,
    email VARCHAR(40) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    FOREIGN KEY (fk_companies_id) REFERENCES companies(id)
);

CREATE TABLE IF NOT EXISTS persons (
    id SERIAL PRIMARY KEY,
    fk_users_id INT UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    pesel_number VARCHAR(11),
    phone_number VARCHAR(20) NOT NULL,
    place VARCHAR(60),
    street VARCHAR(60),
    house_number INT,
    zip_code VARCHAR(40),
    FOREIGN KEY(fk_users_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS favourites_lists(
    id SERIAL PRIMARY KEY,
    fk_users_id INT UNIQUE,
    FOREIGN KEY (fk_users_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS devices_favourites_lists(
    id SERIAL PRIMARY KEY,
    fk_devices_id INT,
    fk_favourites_lists_id INT,
    FOREIGN KEY (fk_devices_id) REFERENCES devices(id),
    FOREIGN KEY (fk_favourites_lists_id) REFERENCES favourites_lists(id)
);

CREATE TABLE IF NOT EXISTS carts(
    id SERIAL PRIMARY KEY,
    fk_users_id INT UNIQUE,
    FOREIGN KEY (fk_users_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS devices_carts(
    id SERIAL PRIMARY KEY,
    fk_cart_id INT,
    fk_devices_id INT,
    FOREIGN KEY (fk_cart_id) REFERENCES carts(id),
    FOREIGN KEY (fk_devices_id) REFERENCES devices(id)
);

CREATE TABLE IF NOT EXISTS rentals (
    id SERIAL PRIMARY KEY,
    fk_users_id INT,
    rental_start_date DATE NOT NULL,
    rental_end_date DATE NOT NULL,
    rental_status VARCHAR(50) NOT NULL,
    method_of_reception VARCHAR(40) NOT NULL,
    method_of_payment VARCHAR(40) NOT NULL,
    FOREIGN KEY (fk_users_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS devices_rentals(
    id SERIAL PRIMARY KEY,
    fk_rentals_id INT,
    fk_devices_id INT,
    FOREIGN KEY (fk_rentals_id) REFERENCES rentals(id),
    FOREIGN KEY (fk_devices_id) REFERENCES devices(id)
);


CREATE TABLE IF NOT EXISTS invoices (
    id SERIAL PRIMARY KEY,
    fk_rentals_id INT,
    invoice_date DATE NOT NULL,
    total_price INT NOT NULL,
    full_deposit INT NOT NULL,
    invoice_type VARCHAR(40) NOT NULL,
    FOREIGN KEY (fk_rentals_id) REFERENCES rentals(id)
);

INSERT INTO device_categories (name) VALUES ('telewizor'),('laptop'),('monitor'),('nagłośnienie'),('projektor multimedialny'), ('ekran'), ('oświetlenie'),('słuchawki'),('tablet'),('kamera'),('mikrofon');
INSERT INTO connectors (name) VALUES ('HDMI'), ('USB'),('Ethernet'), ('combo jack'),('Brak');