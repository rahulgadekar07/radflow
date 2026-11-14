CREATE TABLE patients (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          mrn VARCHAR(50) NOT NULL,
                          full_name VARCHAR(150) NOT NULL,
                          gender VARCHAR(20),
                          date_of_birth DATE,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                          CONSTRAINT pk_patients PRIMARY KEY (id),
                          CONSTRAINT uk_patients_mrn UNIQUE (mrn)
);