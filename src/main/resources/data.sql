INSERT INTO academic_years
    (calendar_year, number) VALUES (
                                       '2021/2022', 'FIRST'),
                                       ('2021/2022', 'SECOND'),
                                       ('2021/2022', 'THIRD'),
                                       ('2021/2022', 'FOURTH');

INSERT INTO faculties (name) VALUES (
                                    'Philosophy'), ('History'), ('Journalism');
INSERT INTO departments
    (name, faculty_name) VALUES (
                                 'Phenomenology', 'Philosophy'),
                                ('Religious Studies', 'Philosophy'),
                                ('Modern History', 'History'),
                                ('Ancient History', 'History'),
                                ('Media Technologies', 'Journalism'),
                                ('Radio and TV', 'Journalism');
INSERT INTO professors
    (professor_card, is_dismissed, name,
     surname, phone_number, rank) VALUES (
                                         'PRFSR-532-863-1263', false, 'Gilles',
                                          'Deleuze', '(021) 343-24-64', 'ASSOCIATE_PROFESSOR'),
                                         ('PRFSR-342-643-5274', false, 'Jacques',
                                          'Derrida', '(021) 456-12-13', 'PROFESSOR'),
                                         ('PRFSR-356-235-7534', false, 'Michael',
                                          'Foucault', '(021) 453-23-45', 'ASSOCIATE_PROFESSOR'),
                                         ('PRFSR-846-243-6436', false, 'Arnold',
                                          'Toynbee', '(035) 343-24-64', 'ASSISTANT_PROFESSOR'),
                                         ('PRFSR-476-235-8624', false, 'Hunter',
                                          'Thompson', '(021) 453-23-41', 'INSTRUCTOR'),
                                         ('PRFSR-365-247-3457', false, 'Thomas',
                                          'Wolfe', '(035) 374-26-43', 'PROFESSOR');
INSERT INTO auditoriums
(id, capacity, has_screen,
 index, faculty_name) VALUES (
                             1, 30, true, '4A', 'Philosophy'), (2, 25, false, '5A', 'Philosophy'),
                             (3, 50, true, '6A', 'Philosophy'), (4, 15, false, '7A', 'Philosophy'),
                             (5, 30, true, '18', 'History'), (6, 25, false, '25', 'History'),
                             (7, 50, true, '45BD', 'History'), (8, 15, false, '19', 'History'),
                             (9, 30, true, '1', 'Journalism'), (10, 25, false, '2', 'Journalism'),
                             (11, 50, true, '3', 'Journalism'), (12, 15, false, '4', 'Journalism');
INSERT INTO studies
    (id, name, type, auditorium_id,
     professor_card) VALUES (
                            1, 'Philosophy of logic and language', 'THEORY', 1, 'PRFSR-532-863-1263'),
                            (2, 'Philosophy of science and social science', 'THEORY', 2, 'PRFSR-342-643-5274'),
                            (3, 'Philosophy of mind', 'THEORY', 3, 'PRFSR-342-643-5274'),
                            (4, 'Ethics', 'THEORY', 4, 'PRFSR-342-643-5274'),
                            (5, 'Aesthetics', 'THEORY', 1, 'PRFSR-342-643-5274'),
                            (6, 'Historical Analysis', 'PRACTICE', 5, 'PRFSR-356-235-7534'),
                            (7, 'Modern European History', 'THEORY', 6, 'PRFSR-356-235-7534'),
                            (8, 'American History', 'THEORY', 7, 'PRFSR-846-243-6436'),
                            (9, 'Ancient and Medieval History', 'THEORY', 8, 'PRFSR-846-243-6436'),
                            (10, 'History of Journalism', 'THEORY', 9, 'PRFSR-476-235-8624'),
                            (11, 'Creative Writing', 'PRACTICE', 10, 'PRFSR-476-235-8624'),
                            (12, 'Reportage', 'PRACTICE', 11, 'PRFSR-365-247-3457'),
                            (13, 'Economics of Media', 'THEORY', 12, 'PRFSR-365-247-3457');
INSERT INTO groups
    (id, group_number, academic_year_id,
     department_name) VALUES (
                             1, 'FIRST', 1, 'Phenomenology'),
                             (2, 'FIRST', 2, 'Phenomenology'),
                             (3, 'FIRST', 1, 'Religious Studies'),
                             (4, 'FIRST', 2, 'Religious Studies'),
                             (5, 'FIRST', 1, 'Modern History'),
                             (6, 'FIRST', 2, 'Modern History'),
                             (7, 'FIRST', 1, 'Ancient History'),
                             (8, 'FIRST', 2, 'Ancient History'),
                             (9, 'FIRST', 1, 'Media Technologies'),
                             (10, 'FIRST', 2, 'Radio and TV');
INSERT INTO day_schedules
    (id, semester, study_day,
     group_id) VALUES (
                       1, 'SECOND', 'MONDAY', 1), (2, 'SECOND', 'TUESDAY', 1),
                      (3, 'SECOND', 'WEDNESDAY', 1), (4, 'SECOND', 'THURSDAY', 1),
                      (5, 'SECOND', 'FRIDAY', 1);
INSERT INTO departments_professors
    (department_name,
     professor_card) VALUES (
                                        'Phenomenology', 'PRFSR-532-863-1263'),
                                       ('Phenomenology', 'PRFSR-342-643-5274');
INSERT INTO day_schedules_studies
    (day_schedule_id, study_id) VALUES (
                                        1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
                                       (2, 2), (2, 1), (2, 3), (2, 5), (2, 4),
                                       (3, 5), (3, 4), (3, 4), (3, 1), (3, 3),
                                       (4, 4), (4, 5), (4, 3), (4, 2), (4, 1),
                                       (5, 5), (5, 4), (5, 2), (5, 3);
INSERT INTO students
    (student_card, name,
     surname, phone_number,
     academic_year_id, department_name,
     group_id) VALUES (
                       'STDNT-342-345-3356', 'Andrey', 'Sidorkin',
                       '(096) 309-61-78', 1, 'Phenomenology', 1);
