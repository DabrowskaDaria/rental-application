
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
DROP TABLE IF EXISTS ram CASCADE;
DROP TABLE IF EXISTS operating_system CASCADE;
DROP TABLE IF EXISTS method_of_reception CASCADE;
DROP TABLE IF EXISTS method_of_payment CASCADE;
DROP TABLE IF EXISTS invoice_type CASCADE;
DROP TABLE IF EXISTS matrix_type CASCADE;
DROP TABLE IF EXISTS headphone_type CASCADE;
DROP TABLE IF EXISTS account_type CASCADE;
DROP TABLE IF EXISTS rental_status CASCADE;

CREATE TABLE IF NOT EXISTS ram (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS operating_systems (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS methods_of_reception (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS methods_of_payment (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS invoice_types (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS matrix_types (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS headphone_types (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS account_types (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS microphone_types (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS rental_statuses (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS computers_and_tablets(
    id SERIAL PRIMARY KEY,
    fk_ram_id INT NOT NULL,
    fk_operating_system_id INT NOT NULL,
    display VARCHAR(255) NOT NULL,
    procesor VARCHAR(255) NOT NULL,
    drive VARCHAR(255) NOT NULL,
    graphics_card VARCHAR(255) NULL,
    FOREIGN KEY (fk_ram_id) REFERENCES ram(id),
    FOREIGN KEY (fk_operating_system_id) REFERENCES operating_systems(id)
);

CREATE TABLE IF NOT EXISTS image_display(
    id SERIAL PRIMARY KEY,
    fk_matrix_type_id INT NOT NULL,
    screen_size VARCHAR(100) NULL,
    screen_resolution VARCHAR(150) NULL,
    refresh_rate INT NULL,
    format VARCHAR(255) NULL,
    active_surface VARCHAR(255) NULL,
    lamp_power INT NULL,
    FOREIGN KEY (fk_matrix_type_id) REFERENCES matrix_types(id)
);

CREATE TABLE IF NOT EXISTS camera(
    id SERIAL PRIMARY KEY,
    resolution VARCHAR(150) NOT NULL,
    image_stablization BOOLEAN NOT NULL,
    optical_zoom BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS lighting(
    id SERIAL PRIMARY KEY,
    lighting_color VARCHAR(255) NOT NULL,
    power_consumption INT NOT NULL,
    lamp_power INT NOT NULL,
    device_size VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS audio_devices(
    id SERIAL PRIMARY KEY,
    fk_microphone_type_id INT NOT NULL,
    fk_headphone_type_id INT NOT NULL,
    speakers_power VARCHAR(150) NULL,
    number_of_speakers INT NULL,
    frequency_response VARCHAR(150) NULL,
    microphone BOOLEAN NULL,
    working_time INT NULL,
    wireless_transmission BOOLEAN NULL,
    FOREIGN KEY (fk_microphone_type_id) REFERENCES microphone_types(id),
    FOREIGN KEY (fk_headphone_type_id) REFERENCES headphone_types(id)
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
    company_number VARCHAR(255) NULL UNIQUE,
    place VARCHAR(255) NULL,
    street VARCHAR(255) NULL,
    bulding_number VARCHAR(255) NULL,
    zip_code VARCHAR(100) NULL
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    fk_companies_id INT NULL,
    fk_account_type_id INT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (fk_companies_id) REFERENCES companies(id),
    FOREIGN KEY (fk_account_type_id) REFERENCES account_types(id)
);

CREATE TABLE IF NOT EXISTS persons (
    id SERIAL PRIMARY KEY,
    fk_users_id INT UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    pesel_number VARCHAR(11) NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    place VARCHAR(255) NULL,
    street VARCHAR(255) NULL,
    house_number VARCHAR(255) NULL,
    zip_code VARCHAR(100) NULL,
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
    fk_rental_status_id INT NOT NULL,
    fk_method_of_reception_id INT NOT NULL,
    fk_method_of_payment_id INT NOT NULL,
    rental_start_date DATE NOT NULL,
    rental_end_date DATE NOT NULL,
    FOREIGN KEY (fk_users_id) REFERENCES users(id),
    FOREIGN KEY (fk_rental_status_id) REFERENCES rental_statuses(id),
    FOREIGN KEY (fk_method_of_reception_id) REFERENCES methods_of_reception(id),
    FOREIGN KEY (fk_method_of_payment_id) REFERENCES methods_of_payment(id)
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
    fk_invoice_type_id INT NOT NULL,
    fk_rentals_id INT NOT NULL,
    invoice_date DATE NOT NULL,
    total_price INT NOT NULL,
    full_deposit INT NOT NULL,
    FOREIGN KEY (fk_invoice_type_id) REFERENCES invoice_types(id),
    FOREIGN KEY (fk_rentals_id) REFERENCES rentals(id)
);

INSERT INTO device_categories (name) VALUES ('telewizor'),('laptop'),('monitor'),('nagłośnienie'),('projektor multimedialny'), ('ekran'), ('oświetlenie'),('słuchawki'),('tablet'),('kamera'),('mikrofon');
INSERT INTO connectors (name) VALUES ('HDMI'), ('USB'),('Ethernet'), ('combo jack'),('Brak');

INSERT INTO ram (name) VALUES (4), (8), (16), (32), (64);

INSERT INTO operating_systems (name) VALUES ('Windows'), ('macOs'), ('Linux'), ('Android'), ('iOS');
INSERT INTO methods_of_reception (name) VALUES ('odbiór osobisty'), ('dostawa na adres');

INSERT INTO methods_of_payment (name) VALUES ('płatne przy odbiorze');

INSERT INTO invoice_types (name) VALUES ('korygująca'), ('podstawowa');

INSERT INTO matrix_types (name) VALUES ('Laser'), ('3LCD'), ('DLP'), ('LCD'), ('LED');

INSERT INTO headphone_types (name) VALUES ('nauszne'), ('dokanałowe'), ('douszne');

INSERT INTO account_types (name) VALUES ('Administrator'), ('Użytkownik'), ('Pracownik'), ('Magazynier');

INSERT INTO rental_statuses (name) VALUES ('Zwrócone'), ('Anulowane'), ('W trakcie przygotowania'), ('Nowe'), ('Gotowe do odbioru');
