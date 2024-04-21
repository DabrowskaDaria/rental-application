
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
    display VARCHAR(255) NOT NULL,
    procesor VARCHAR(255) NOT NULL,
    drive VARCHAR(255) NOT NULL,
    ram INT NOT NULL,
    operating_system VARCHAR(255) NOT NULL,
    graphics_card VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS image_display(
    id SERIAL PRIMARY KEY,
    screen_size VARCHAR(50) NULL,
    screen_resolution VARCHAR(50) NULL,
    refresh_rate INT NULL,
    format VARCHAR(255) NULL,
    active_surface VARCHAR(100) NULL,
    matrix_type VARCHAR(255) NULL,
    lamp_power INT NULL
);

CREATE TABLE IF NOT EXISTS camera(
    id SERIAL PRIMARY KEY,
    resolution VARCHAR(100) NOT NULL,
    image_stablization BOOLEAN NOT NULL,
    optical_zoom BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS lighting(
    id SERIAL PRIMARY KEY,
    lighting_color VARCHAR(100) NOT NULL,
    power_consumption INT NOT NULL,
    lamp_power INT NOT NULL,
    device_size VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS audio_devices(
    id SERIAL PRIMARY KEY,
    speakers_power VARCHAR(100) NULL,
    number_of_speakers INT NULL,
    frequency_response VARCHAR(100) NULL,
    headphone_type VARCHAR(100) NULL,
    microphone_type VARCHAR(255) NULL,
    microphone BOOLEAN NULL,
    working_time INT NULL,
    wireless_transmission BOOLEAN NULL,
    
);

CREATE TABLE IF NOT EXISTS device_categories(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists devices (
    id SERIAL PRIMARY KEY,
    fk_device_categories_id INT NOT NULL,
    fk_computers_and_tablets_id INT NULL,
    fk_image_display_id INT NULL,
    fk_camera_id INT NULL,
    fk_audio_devices_id INT NULL,
    fk_lighting_id INT NULL,
    name VARCHAR (255) NOT NULL,
    price INT NOT NULL,
    deposit INT NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY (fk_device_categories_id) REFERENCES device_categories(id),
    FOREIGN KEY (fk_computers_and_tablets_id) REFERENCES computers_and_tablets(id),
    FOREIGN KEY (fk_image_display_id) REFERENCES image_display(id),
    FOREIGN KEY (fk_camera_id) REFERENCES camera(id),
    FOREIGN KEY (fk_audio_devices_id) REFERENCES audio_devices(id),
    FOREIGN KEY (fk_lighting_id) REFERENCES lighting(id)
);
CREATE TABLE IF NOT EXISTS connectors(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS devices_connectors(
    id SERIAL PRIMARY KEY,
    fk_connectors_id INT NOT NULL,
    fk_devices_id INT NOT NULL,
    FOREIGN KEY (fk_connectors_id) REFERENCES connectors(id),
    FOREIGN KEY (fk_devices_id) REFERENCES devices(id)
);

CREATE TABLE IF NOT EXISTS companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NULL,
    company_number VARCHAR(50) NULL,
    place VARCHAR(150) NULL,
    street VARCHAR(150) NULL,
    bulding_number VARCHAR(255) NULL,
    zip_code VARCHAR(40) NULL
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    fk_companies_id INT,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(130) NOT NULL,
    account_type VARCHAR(255) NOT NULL,
    FOREIGN KEY (fk_companies_id) REFERENCES companies(id)
);

CREATE TABLE IF NOT EXISTS persons (
    id SERIAL PRIMARY KEY,
    fk_users_id INT UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    pesel_number VARCHAR(11) NULL,
    phone_number VARCHAR(20) NOT NULL,
    place VARCHAR(150) NULL,
    street VARCHAR(150) NULL,
    house_number VARCHAR(255) NULL,
    zip_code VARCHAR(40) NULL,
    FOREIGN KEY(fk_users_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS favourites_lists(
    id SERIAL PRIMARY KEY,
    fk_users_id INT UNIQUE NOT NULL,
    FOREIGN KEY (fk_users_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS devices_favourites_lists(
    id SERIAL PRIMARY KEY,
    fk_devices_id INT NOT NULL,
    fk_favourites_lists_id INT NOT NULL,
    FOREIGN KEY (fk_devices_id) REFERENCES devices(id),
    FOREIGN KEY (fk_favourites_lists_id) REFERENCES favourites_lists(id)
);

CREATE TABLE IF NOT EXISTS carts(
    id SERIAL PRIMARY KEY,
    fk_users_id INT UNIQUE NOT NULL,
    FOREIGN KEY (fk_users_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS devices_carts(
    id SERIAL PRIMARY KEY,
    fk_cart_id INT NOT NULL,
    fk_devices_id INT NOT NULL,
    FOREIGN KEY (fk_cart_id) REFERENCES carts(id),
    FOREIGN KEY (fk_devices_id) REFERENCES devices(id)
);

CREATE TABLE IF NOT EXISTS rentals (
    id SERIAL PRIMARY KEY,
    fk_users_id INT NOT NULL,
    rental_status VARCHAR(255) NOT NULL,
    method_of_reception VARCHAR(255) NOT NULL,
    method_of_payment VARCHAR(255) NOT NULL,
    rental_start_date DATE NOT NULL,
    rental_end_date DATE NOT NULL,
    FOREIGN KEY (fk_users_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS devices_rentals(
    id SERIAL PRIMARY KEY,
    fk_rentals_id INT NOT NULL,
    fk_devices_id INT NOT NULL,
    FOREIGN KEY (fk_rentals_id) REFERENCES rentals(id),
    FOREIGN KEY (fk_devices_id) REFERENCES devices(id)
);


CREATE TABLE IF NOT EXISTS invoices (
    id SERIAL PRIMARY KEY,
    invoice_type VARCHAR(255) NOT NULL,
    fk_rentals_id INT NOT NULL,
    invoice_date DATE NOT NULL,
    total_price INT NOT NULL,
    full_deposit INT NOT NULL,
    FOREIGN KEY (fk_rentals_id) REFERENCES rentals(id)
);



INSERT INTO device_categories (name) VALUES ('telewizor'),('laptop'),('monitor'),('nagłośnienie'),('projektor multimedialny'), ('ekran'), ('oświetlenie'),('słuchawki'),('tablet'),('kamera'),('mikrofon');
INSERT INTO connectors (name) VALUES ('HDMI'), ('USB'),('Ethernet'), ('combo jack'),('Brak');


