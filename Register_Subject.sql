create database [AssPRJ]
go
use [AssPRJ]
go

create table Accounts(
	[accountID] [int] PRIMARY KEY,
	[account] [varchar] (50) NOT NULL,
	[password] [varchar] (20) NOT NULL,
	[dateCreated] [datetime] NULL,
	

)
go
create table Students(
	[studentID] [varchar] (8) primary key,
	[name] [nvarchar] (50) NOT NULL,
	[gender] [bit] NOT NULL,
	[address] [nvarchar] (60) NULL,
	[DOB] [datetime] NULL,
	[accountID] [int] UNIQUE FOREIGN KEY REFERENCES Accounts([accountID]),

)
go
create table Semester(
	[semesterID] [int] primary key,
	[name] [varchar] (20) NOT NULL,
)
go
create table Student_Semester(
	[studentID] [varchar](8) FOREIGN KEY REFERENCES Students([studentID]),
	[semesterID] [int] FOREIGN KEY REFERENCES Semester([semesterID]),
	PRIMARY KEY ([studentID], [SemesterID]),

)
go
create table Teachers(
	[teacherID] [varchar] (8) primary key,
	[name] [nvarchar] (50) NOT NULL,
	[gender] [bit] NOT NULL,
	[address] [nvarchar] (60) NULL,
	[DOB] [datetime] NULL,
)
go
create table Subjectss(
	[subjectID] [varchar] (8) PRIMARY KEY,
	[subjectName] [nvarchar] (50) NOT NULL,
)
go
create table Student_Subject(
	[accountID] [int],
	[teacherID] [varchar](8) FOREIGN KEY REFERENCES Teachers([teacherID]),
	[subjectID] [varchar] (8) FOREIGN KEY REFERENCES Subjectss([subjectID]),
	[slot] [int] NOT NULL,
	[days] [varchar] (20) NOT NULL, 
	PRIMARY KEY ([teacherID], [subjectID], [slot], [days],accountId),
)
go
create table Teacher_Subject(
	[teacherID] [varchar](8) FOREIGN KEY REFERENCES Teachers([teacherID]),
	[subjectID] [varchar] (8) FOREIGN KEY REFERENCES Subjectss([subjectID]),
	[slot] [int] NOT NULL,
	[days] [varchar] (20) NOT NULL, 
	PRIMARY KEY ([teacherID], [subjectID], [slot], [days]),
)
