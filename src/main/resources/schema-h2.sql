CREATE TABLE doctor
        (
        id INT NOT NULL,
        name VARCHAR(50) NOT NULL,
        hospital_id VARCHAR(50) NOT NULL,
        type VARCHAR(50) NOT NULL,
        date_available VARCHAR(150) NOT NULL,
        time_available VARCHAR(50) NOT NULL,
        rate INT NOT NULL,
        status VARCHAR(50) NOT NULL,
        created_on DATE  NULL
        created_by VARCHAR(50) 
        modified_on DATE  NULL
        modified_by VARCHAR(50) 
        );
        
CREATE TABLE hospital
        (
        hospital_name VARCHAR(50) NOT NULL,
        hospital_id VARCHAR(50) NOT NULL,
        created_on DATE  NULL
        created_by VARCHAR(50) 
        modified_on DATE NULL
        modified_by VARCHAR(50) 
        );
 