CREATE TABLE department(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    part_name VARCHAR(255),
    contact VARCHAR(20)
);

/**
  ON DELETE CASCADE : 부모테이블에서 값이 삭제될 경우, 하위테이블도 같이 삭제됨
  ON DELETE SET NULL : ---, 하위테이블은 null 값으로 변경
 */
CREATE TABLE employee(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    age INT,
    career INT,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE CASCADE
);