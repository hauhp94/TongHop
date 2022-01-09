CREATE DATABASE SponsorManager
CREATE TABLE sponsor
(
Type INT NOT NULL,
SponsorId CHAR(5) PRIMARY KEY,
Name NVARCHAR(50),
Address NVARCHAR(100),
Phone VARCHAR(10),
Email VARCHAR(50),
BankingAccount VARCHAR(50),
BankName VARCHAR(50),
Job NVARCHAR(50),
Company NVARCHAR(50),
GroupSize INT,
Domain NVARCHAR(50),
TaxCode VARCHAR(50),
SponsorMoney MONEY,
SponsorDate VARCHAR(10)
)
TRUNCATE TABLE dbo.sponsor
SELECT * FROM dbo.sponsor
INSERT INTO dbo.sponsor
(Type,SponsorId,Name,Address,Phone,Email,BankingAccount,BankName,Job,Company,GroupSize,Domain,TaxCode,SponsorMoney,SponsorDate)
VALUES
( )
UPDATE dbo.sponsor SET SponsorMoney = 1, SponsorDate = '2020-12-12'
WHERE SponsorId = 'SP002'