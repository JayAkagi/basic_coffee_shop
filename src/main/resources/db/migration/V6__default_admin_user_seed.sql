INSERT INTO users(
    username,
    password_hash,
    email,
    is_admin,
    created_at
) VALUES
      ('admin',
       '$2a$10$N9qo8uLOickgx2ZMRZo5e.PQ5Xn6nX5tP3y9FQ1Yp2wZKzE5QH3iG',
       'admin@email.com',
       TRUE,
       NOW()
      );

-- password is admin123