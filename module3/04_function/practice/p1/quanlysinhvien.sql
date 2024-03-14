-- Hiển thị số lượng sinh viên ở từng nơi
SELECT Address, COUNT(id) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;

-- Tính điểm trung bình các môn học của mỗi học viên
SELECT S.id,S.name, AVG(m.mark)
FROM Student S join Mark M on S.id = M.Student_Id
GROUP BY S.id;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT S.id,S.name, AVG(m.mark) as avg_mark
FROM Student S join Mark M on S.id = M.Student_Id
GROUP BY S.id
HAVING avg_mark > 15;

-- Hiển thị thông tin học viên có điểm trung bình lớn nhất.
SELECT S.id,S.name, AVG(m.mark) as avg_mark
FROM Student S join Mark M on S.id = M.Student_Id
GROUP BY S.id
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.Student_Id);





