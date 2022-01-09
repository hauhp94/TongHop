CREATE DATABASE CandidateManagement

CREATE TABLE CandidateType
(CandidateTypeID INT PRIMARY KEY IDENTITY(0,1),
CandidateTypeName VARCHAR(50))

CREATE TABLE Candidate
(CandidateID INT PRIMARY KEY IDENTITY,
FullName NVARCHAR(50),
BirthDate VARCHAR(10),
Phone NVARCHAR(10),
Email VARCHAR(50),
CandidateTypeID INT,
ExpInYear INT,
ProSkill VARCHAR(50),
GraduationDate VARCHAR(10),
GraduationRank INT,
Education NVARCHAR(50),
Majors NVARCHAR(50),
Semester NVARCHAR(50),
UniversityName NVARCHAR(100),
FOREIGN KEY (CandidateTypeID) REFERENCES CandidateType(CandidateTypeID))

CREATE TABLE Certificated
(CertificatedID INT PRIMARY KEY IDENTITY,
CertificatedName NVARCHAR(50),
CertificatedRank INT,
CertificatedDate VARCHAR(10),
CandidateID INT,
FOREIGN KEY (CandidateID) REFERENCES dbo.Candidate(CandidateID))

select * from candidateType
INSERT INTO dbo.CandidateType
(
    CandidateTypeName
)
VALUES
('Experience' -- CandidateTypeName - varchar(50)
    ),
('Fresher ' -- CandidateTypeName - varchar(50)
    ),
('Intern  ' -- CandidateTypeName - varchar(50)
    )
	INSERT INTO dbo.Candidate
	(
	    FullName,
	    BirthDate,
	    Phone,
	    Email,
	    CandidateTypeID,
	    ExpInYear,
	    ProSkill,
	    GraduationDate,
	    GraduationRank,
	    Education,
	    Majors,
	    Semester,
	    UniversityName
	)
	VALUES
	(   N'Huỳnh Phước Hậu', -- FullName - nvarchar(50)
	    '1995-12-12',  -- BirthDate - varchar(10)
	    N'0912456456', -- Phone - nvarchar(10)
	    'hauhp@gmail.com',  -- Email - varchar(50)
	    0,   -- CandidateTypeID - int
	    2,   -- ExpInYear - int
	    'Java',  -- ProSkill - varchar(50)
	    '',  -- GraduationDate - varchar(10)
	    0,   -- GraduationRank - int
	    N'', -- Education - nvarchar(50)
	    N'', -- Majors - nvarchar(50)
	    N'', -- Semester - nvarchar(50)
	    N''  -- UniversityName - nvarchar(100)
	    )

		INSERT INTO dbo.Candidate
		(
		    FullName,
		    BirthDate,
		    Phone,
		    Email,
		    CandidateTypeID,
		    ExpInYear,
		    ProSkill,
		    GraduationDate,
		    GraduationRank,
		    Education,
		    Majors,
		    Semester,
		    UniversityName
		)
		VALUES
		(   N'', -- FullName - nvarchar(50)
		    '',  -- BirthDate - varchar(10)
		    N'', -- Phone - nvarchar(10)
		    '',  -- Email - varchar(50)
		    0,   -- CandidateTypeID - int
		    0,   -- ExpInYear - int
		    '',  -- ProSkill - varchar(50)
		    '',  -- GraduationDate - varchar(10)
		    0,   -- GraduationRank - int
		    N'', -- Education - nvarchar(50)
		    N'', -- Majors - nvarchar(50)
		    N'', -- Semester - nvarchar(50)
		    N''  -- UniversityName - nvarchar(100)
		    )
			INSERT INTO dbo.Certificated
			(
			    CertificatedName,
			    CertificatedRank,
			    CertificatedDate,
			    CandidateID
			)
			VALUES
			(   N'', -- CertificatedName - nvarchar(50)
			    0,   -- CertificatedRank - int
			    '',  -- CertificatedDate - varchar(10)
			    0    -- CandidateID - int
			    )
				SELECT MAX(CANDIDATEID) FROM dbo.Candidate
				SELECT MAX(CANDIDATEID)AS id FROM dbo.Candidate
				SELECT* FROM dbo.Certificated
				SELECT* FROM dbo.Candidate
				JOIN dbo.Certificated ON Certificated.CandidateID = Candidate.CandidateID

				SELECT MAX(CandidateID) AS id FROM dbo.Candidate