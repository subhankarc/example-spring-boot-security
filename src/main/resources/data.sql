INSERT INTO role (name)
VALUES ('ADMIN');

INSERT INTO user (email, password_hash, role_id)
VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 1);