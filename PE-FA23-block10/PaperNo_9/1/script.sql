USE [master]
GO
DROP DATABASE [CapstoneManagement]
CREATE DATABASE [CapstoneManagement]
GO
USE [CapstoneManagement]
GO

CREATE TABLE [dbo].[tblUsers](
	[userID] [nvarchar](50) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID]) VALUES (N'admin', N'Toi la admin', N'1', N'AD')
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID]) VALUES (N'hoadnt', N'Hoa Doan', N'1', N'AD')
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID]) VALUES (N'SE170443', N'LE MINH KHOA', N'1', N'US')
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID]) VALUES (N'SE170969', N'Nguyen Gia Tin', N'123', N'US')
GO

CREATE TABLE [dbo].[tblCapstones](
	[id] [char](5) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](500) NOT NULL,
	[userID] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblFashion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[tblCapstones]  WITH CHECK ADD  CONSTRAINT [FK_tblCapstones_tblUsers] FOREIGN KEY([userID])
REFERENCES [dbo].[tblUsers] ([userID])
GO
ALTER TABLE [dbo].[tblCapstones] CHECK CONSTRAINT [FK_tblCapstones_tblUsers]
GO

INSERT [dbo].[tblCapstones] ([id], [name], [description], [userID]) VALUES (N'FA001', N'Xe tu hanh', N'du an phat trien xe tu hanh thong minh', N'Hoadnt')
INSERT [dbo].[tblCapstones] ([id], [name], [description], [userID]) VALUES (N'FA002', N'Quan ly sinh vien', N'de tai quan ly sinh vien', N'SE170443')

SELECT * FROM tblUsers
SELECT * FROM tblCapstones
Select * From tblUsers WHERE userID = 'admin' and password = '1'