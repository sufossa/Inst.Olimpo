USE [master]
GO
/****** Object:  Database [InstitutoOlimpo]    Script Date: 22/07/2024 19:17:00 ******/
CREATE DATABASE [InstitutoOlimpo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'InstitutoOlimpo', FILENAME = N'C:\Users\HP\Documents\MSSQL16.SQLEXPRESS\MSSQL\DATA\InstitutoOlimpo.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'InstitutoOlimpo_log', FILENAME = N'C:\Users\HP\Documents\MSSQL16.SQLEXPRESS\MSSQL\DATA\InstitutoOlimpo_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [InstitutoOlimpo] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [InstitutoOlimpo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [InstitutoOlimpo] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET ARITHABORT OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [InstitutoOlimpo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [InstitutoOlimpo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET  DISABLE_BROKER 
GO
ALTER DATABASE [InstitutoOlimpo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [InstitutoOlimpo] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [InstitutoOlimpo] SET  MULTI_USER 
GO
ALTER DATABASE [InstitutoOlimpo] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [InstitutoOlimpo] SET DB_CHAINING OFF 
GO
ALTER DATABASE [InstitutoOlimpo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [InstitutoOlimpo] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [InstitutoOlimpo] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [InstitutoOlimpo] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [InstitutoOlimpo] SET QUERY_STORE = ON
GO
ALTER DATABASE [InstitutoOlimpo] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [InstitutoOlimpo]
GO
/****** Object:  Table [dbo].[alumno]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[alumno](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DNI] [varchar](50) NULL,
	[CODIGO] [varchar](50) NULL,
	[NOMBRE] [varchar](50) NULL,
	[TELEFONO] [varchar](50) NULL,
	[CORREO] [varchar](50) NULL,
	[CARRERA] [varchar](50) NULL,
 CONSTRAINT [PK_alumno] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[area]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[area](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[AREA] [varchar](50) NULL,
 CONSTRAINT [PK_area] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[autor]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[autor](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[AUTOR] [varchar](50) NULL,
 CONSTRAINT [PK_autor] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[carrera]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[carrera](
	[CARRERA] [varchar](50) NOT NULL,
 CONSTRAINT [PK_carrera] PRIMARY KEY CLUSTERED 
(
	[CARRERA] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[editorial]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[editorial](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[EDITORIAL] [varchar](50) NULL,
 CONSTRAINT [PK_editorial] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[libro]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[libro](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NOMBRE] [varchar](50) NULL,
	[ID_AUTOR] [int] NULL,
	[ID_EDITORIAL] [int] NULL,
	[ID_AREA] [int] NULL,
	[STOCK] [varchar](50) NULL,
	[FECHA_EDICION] [varchar](50) NULL,
 CONSTRAINT [PK_libro] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[prestamo_libro]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[prestamo_libro](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_USUARIO] [int] NULL,
	[ID_ESTUDIANTE] [int] NULL,
	[CODIGO] [varchar](50) NULL,
	[ID_LIBRO] [int] NULL,
	[AREA] [varchar](50) NULL,
	[CANTIDAD] [varchar](50) NULL,
	[FECHA_PRESTAMO] [varchar](50) NULL,
	[FECHA_DEVOLUCION] [varchar](50) NULL,
	[ESTADO] [varchar](50) NULL,
 CONSTRAINT [PK_prestamo_libro] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[prestamo_tablet]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[prestamo_tablet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_USUARIO] [int] NULL,
	[ID_ESTUDIANTE] [int] NULL,
	[CODIGO] [varchar](50) NULL,
	[ID_TABLET] [int] NULL,
	[N_SERIE] [varchar](50) NULL,
	[CANTIDAD] [varchar](50) NULL,
	[FECHA_PRESTAMO] [varchar](50) NULL,
	[FECHA_DEVOLUCION] [varchar](50) NULL,
	[ESTADO] [varchar](50) NULL,
 CONSTRAINT [PK_prestamo_tablet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tablet]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tablet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[N_SERIE] [varchar](50) NULL,
	[MODELO] [varchar](50) NULL,
	[MARCA] [varchar](50) NULL,
	[ESTADO] [varchar](50) NULL,
 CONSTRAINT [PK_tablet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usuario]    Script Date: 22/07/2024 19:17:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuario](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[USUARIO] [varchar](50) NULL,
	[NOMBRE] [varchar](50) NULL,
	[CORREO] [varchar](50) NULL,
	[CLAVE] [varchar](50) NULL,
 CONSTRAINT [PK_usuario] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[alumno] ON 

INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (1, N'45612378', N'O23327491', N'Ana María López Mendoza', N'987654321', N'ana.lopez@olimpo.edu.pe', N'Comunicaciones')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (2, N'78945612', N'O22253746', N'Juan Carlos Pérez Rojas', N'996541230', N'juan.perez@olimpo.edu.pe', N'Negocios')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (3, N'12378945', N'O21548792', N'María Fernanda Sánchez Díaz', N'945678321', N'maria.sanchez@olimpo.edu.pe', N'Diseño')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (4, N'87456123', N'O23487654', N'José Luis Gómez Torres', N'998745632', N'jose.gomez@olimpo.edu.pe', N'Marketing')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (5, N'65781234', N'O21735482', N'Carla Patricia Ruiz Soto', N'978652341', N'carla.ruiz@olimpo.edu.pe', N'Ing. Sistemas')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (6, N'90874561', N'O20945768', N'Francisco Javier Rivera Vega', N'963852741', N'francisco.rivera@olimpo.edu.pe', N'Negocios Internacionales')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (7, N'34219876', N'O20654321', N'Elena Mercedes Herrera Luna', N'953167842', N'elena.herrera@olimpo.edu.pe', N'Hotelería y Turismo')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (8, N'67543129', N'O24432198', N'Pedro Alejandro Chávez Mora', N'934785612', N'pedro.chavez@olimpo.edu.pe', N'Comunicaciones')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (9, N'12345678', N'O21123456', N'Lucia Beatriz Salazar Gil', N'957341298', N'lucia.salazar@olimpo.edu.pe', N'Negocios')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (10, N'78912345', N'O20876543', N'Rafael Antonio Flores Ruiz', N'965432178', N'rafael.flores@olimpo.edu.pe', N'Diseño')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (11, N'45678912', N'O23765432', N'Andrea Carolina Núñez Quispe', N'983456217', N'andrea.nunez@olimpo.edu.pe', N'Marketing')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (12, N'98765432', N'O19321476', N'Luis Fernando Medina Ortiz', N'994567832', N'luis.medina@olimpo.edu.pe', N'Ing. Sistemas')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (13, N'54321678', N'O21678431', N'Gabriela Sofía Castro Ponce', N'973465218', N'gabriela.castro@olimpo.edu.pe', N'Negocios Internacionales')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (14, N'87654321', N'O19123487', N'Martín Eduardo Vargas Rojas', N'936745812', N'martin.vargas@olimpo.edu.pe', N'Hotelería y Turismo')
INSERT [dbo].[alumno] ([ID], [DNI], [CODIGO], [NOMBRE], [TELEFONO], [CORREO], [CARRERA]) VALUES (15, N'78987654', N'O18217683', N'Patricia Elena Rojas Peña', N'942367589', N'patricia.rojas@olimpo.edu.pe', N'Comunicaciones')
SET IDENTITY_INSERT [dbo].[alumno] OFF
GO
SET IDENTITY_INSERT [dbo].[area] ON 

INSERT [dbo].[area] ([ID], [AREA]) VALUES (1, N'Diseño')
INSERT [dbo].[area] ([ID], [AREA]) VALUES (2, N'Marketing')
INSERT [dbo].[area] ([ID], [AREA]) VALUES (3, N'Negocios')
INSERT [dbo].[area] ([ID], [AREA]) VALUES (4, N'Tecnología')
INSERT [dbo].[area] ([ID], [AREA]) VALUES (5, N'Hotelería y Turismo')
INSERT [dbo].[area] ([ID], [AREA]) VALUES (6, N'Comunicaiones')
SET IDENTITY_INSERT [dbo].[area] OFF
GO
SET IDENTITY_INSERT [dbo].[autor] ON 

INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (1, N'Emma García')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (2, N'Alejandro Ramos')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (3, N'Valeria Martínez')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (4, N'Martín Herrera')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (5, N'Paula Gómez')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (6, N'Roberto López')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (7, N'Lucía Rodríguez')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (8, N'Sebastián Pérez')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (9, N'Marina Fernández')
INSERT [dbo].[autor] ([ID], [AUTOR]) VALUES (10, N'Daniel Sánchez')
SET IDENTITY_INSERT [dbo].[autor] OFF
GO
INSERT [dbo].[carrera] ([CARRERA]) VALUES (N'Comunicaciones')
INSERT [dbo].[carrera] ([CARRERA]) VALUES (N'Diseño')
INSERT [dbo].[carrera] ([CARRERA]) VALUES (N'Hotelería y Turismo')
INSERT [dbo].[carrera] ([CARRERA]) VALUES (N'Ing. Sistemas')
INSERT [dbo].[carrera] ([CARRERA]) VALUES (N'Marketing')
INSERT [dbo].[carrera] ([CARRERA]) VALUES (N'Negocios')
INSERT [dbo].[carrera] ([CARRERA]) VALUES (N'Negocios Internacionales')
GO
SET IDENTITY_INSERT [dbo].[editorial] ON 

INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (1, N'Penguin Random House')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (2, N'HarperCollins')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (3, N'Simon & Schuster')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (4, N'Macmillan Publishers')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (5, N'Hachette Livre')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (6, N'Scholastic Corporation')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (7, N'Bloomsbury Publishing')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (8, N'Pearson Education')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (9, N'Oxford University Press')
INSERT [dbo].[editorial] ([ID], [EDITORIAL]) VALUES (10, N'Wiley (John Wiley & Sons)')
SET IDENTITY_INSERT [dbo].[editorial] OFF
GO
SET IDENTITY_INSERT [dbo].[libro] ON 

INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (1, N'Comunicación Eficaz', 1, 3, 6, N'12', N'1919')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (2, N'Estrategias de Marketing Digital', 2, 9, 2, N'8', N'1960')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (3, N'Gestión de Proyectos Tecnológicos', 3, 2, 4, N'12', N'1981')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (4, N'Diseño de Experiencias de Usuario', 4, 1, 1, N'5', N'1988')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (5, N'Comunicación en la Era Digital', 5, 7, 6, N'10', N'2007')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (6, N'Estrategias de Negocios Internacionales', 6, 8, 3, N'20', N'1996')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (7, N'Innovación Tecnológica', 7, 6, 4, N'7', N'2019')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (8, N'Diseño Gráfico y Publicidad', 8, 10, 1, N'13', N'2020')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (9, N'Marketing para el Turismo', 9, 5, 2, N'6', N'2018')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (10, N'Estrategias de Comunicación Empresarial', 10, 3, 6, N'18', N'1969')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (11, N'Administración Hotelera Moderna', 1, 6, 5, N'9', N'1992')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (12, N'Diseño y Desarrollo Web', 2, 2, 4, N'11', N'1999')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (13, N'Comunicación Visual', 3, 9, 1, N'4', N'1957')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (14, N'Marketing de Contenidos', 4, 1, 2, N'14', N'1867')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (15, N'Estrategias de Negocios Online', 5, 4, 3, N'10', N'1908')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (16, N'Innovaciones en Tecnología Educativa', 6, 5, 4, N'12', N'1978')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (17, N'Diseño de Identidad Corporativa', 7, 10, 1, N'8', N'1993')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (18, N'Comunicación Estratégica en Negocios', 8, 7, 6, N'16', N'2018')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (19, N'Marketing en la Industria Hotelera', 9, 7, 5, N'5', N'2010')
INSERT [dbo].[libro] ([ID], [NOMBRE], [ID_AUTOR], [ID_EDITORIAL], [ID_AREA], [STOCK], [FECHA_EDICION]) VALUES (20, N'Gestión Estratégica de Turismo', 10, 9, 5, N'7', N'2007')
SET IDENTITY_INSERT [dbo].[libro] OFF
GO
SET IDENTITY_INSERT [dbo].[prestamo_libro] ON 

INSERT [dbo].[prestamo_libro] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_LIBRO], [AREA], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (1, 2, 5, N'O21735482', 10, N'Comunicaciones', N'01', N'2024-06-12', N'2024-06-19', N'Pendiente')
INSERT [dbo].[prestamo_libro] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_LIBRO], [AREA], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (2, 2, 5, N'O21735482', 13, N'Comunicaciones', N'01', N'2024-06-12', N'2024-06-19', N'Pendiente')
INSERT [dbo].[prestamo_libro] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_LIBRO], [AREA], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (3, 1, 11, N'O23765432', 14, N'Marketing', N'01', N'2024-06-14', N'2024-06-21', N'Pendiente')
INSERT [dbo].[prestamo_libro] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_LIBRO], [AREA], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (4, 4, 2, N'O22253746', 8, N'Diseño', N'01', N'2024-06-15', N'2024-06-22', N'Pendiente')
INSERT [dbo].[prestamo_libro] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_LIBRO], [AREA], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (5, 1, 9, N'O21123456', 3, N'Tecnología', N'01', N'2024-06-16', N'2024-06-23', N'Entregado')
INSERT [dbo].[prestamo_libro] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_LIBRO], [AREA], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (11, 2, 1, N'O23327491', 3, N'Tecnología', N'3', N'2024-07-22', N'2024-07-29', N'Pendiente')
SET IDENTITY_INSERT [dbo].[prestamo_libro] OFF
GO
SET IDENTITY_INSERT [dbo].[prestamo_tablet] ON 

INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (1, 2, 7, N'O20654321', 2, N'SN23456', N'01', N'2024-06-12', N'2024-06-19', N'Pendiente')
INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (2, 1, 8, N'O24432198', 5, N'SN56789', N'01', N'2024-06-13', N'2024-06-20', N'Pendiente')
INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (3, 4, 2, N'O22253746', 4, N'SN45678', N'01', N'2024-06-13', N'2024-06-16', N'Entregado')
INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (4, 4, 11, N'O23765432', 7, N'SN78901', N'01', N'2024-06-14', N'2024-06-21', N'Pendiente')
INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (5, 1, 5, N'O21735482', 10, N'SN01234', N'01', N'2024-06-14', N'2024-06-21', N'Pendiente')
INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (6, 1, 1, N'O23327491', 12, N'SN22450', N'01', N'2024-06-15', N'2024-06-22', N'Pendiente')
INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (7, 2, 9, N'O21123456', 14, N'SN45670', N'01', N'2024-06-16', N'2024-06-23', N'Pendiente')
INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (8, 2, 3, N'O21548792', 8, N'OL89012', N'1', N'2024-07-22', N'2024-07-29', N'Pendiente')
INSERT [dbo].[prestamo_tablet] ([ID], [ID_USUARIO], [ID_ESTUDIANTE], [CODIGO], [ID_TABLET], [N_SERIE], [CANTIDAD], [FECHA_PRESTAMO], [FECHA_DEVOLUCION], [ESTADO]) VALUES (9, 2, 3, N'O21548792', 8, N'OL89012', N'1', N'2024-07-22', N'2024-07-29', N'Pendiente')
SET IDENTITY_INSERT [dbo].[prestamo_tablet] OFF
GO
SET IDENTITY_INSERT [dbo].[tablet] ON 

INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (1, N'OL12345', N'iPad Air', N'Apple', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (2, N'OL23456', N'Galaxy Tab S7', N'Samsung', N'No Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (3, N'OL34567', N'Surface Pro 7', N'Microsoft', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (4, N'OL45678', N'Fire HD 10', N'Amazon', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (5, N'OL56789', N'iPad Pro', N'Apple', N'No Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (6, N'OL67890', N'Galaxy Tab A7', N'Samsung', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (7, N'OL78901', N'Surface Go 2', N'Microsoft', N'No Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (8, N'OL89012', N'Kindle Fire HD 8', N'Amazon', N'No disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (9, N'OL90123', N'iPad Mini', N'Apple', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (10, N'OL01234', N'Galaxy Tab S6 Lite', N'Samsung', N'No Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (11, N'OL12340', N'Surface Pro X', N'Microsoft', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (12, N'OL23450', N'Fire HD 8 Plus', N'Amazon', N'No Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (13, N'OL34560', N'iPad 8th Generation', N'Apple', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (14, N'OL45670', N'Galaxy Tab A 8.0', N'Samsung', N'No Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (15, N'OL56780', N'Surface Go', N'Microsoft', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (16, N'OL23409', N'Galaxy Tab S7', N'Samsung', N'Disponible')
INSERT [dbo].[tablet] ([ID], [N_SERIE], [MODELO], [MARCA], [ESTADO]) VALUES (17, N'OL01253', N'Galaxy Tab S6 Lite', N'Samsung', N'Disponible')
SET IDENTITY_INSERT [dbo].[tablet] OFF
GO
SET IDENTITY_INSERT [dbo].[usuario] ON 

INSERT [dbo].[usuario] ([ID], [USUARIO], [NOMBRE], [CORREO], [CLAVE]) VALUES (1, N'OLaura4433', N'Laura Castillo Morales', N'Laucast@olimpo.edu.pe', N'OlauCas')
INSERT [dbo].[usuario] ([ID], [USUARIO], [NOMBRE], [CORREO], [CLAVE]) VALUES (2, N'OJuan7741', N'Juan Morales Sierra', N'JuanSieera@olimpo.edu.pe', N'OJuanSie')
INSERT [dbo].[usuario] ([ID], [USUARIO], [NOMBRE], [CORREO], [CLAVE]) VALUES (3, N'OJosue7790', N'Josue Mamani Quispe', N'JosueQuisM@olimpo.edu.pe', N'OJosueQui')
INSERT [dbo].[usuario] ([ID], [USUARIO], [NOMBRE], [CORREO], [CLAVE]) VALUES (4, N'OLuis6223', N'Luis López Ortega', N'Loluis@olimpo.edu.pe', N'OLuisLop')
SET IDENTITY_INSERT [dbo].[usuario] OFF
GO
ALTER TABLE [dbo].[alumno]  WITH CHECK ADD  CONSTRAINT [FK_alumno_carrera] FOREIGN KEY([CARRERA])
REFERENCES [dbo].[carrera] ([CARRERA])
GO
ALTER TABLE [dbo].[alumno] CHECK CONSTRAINT [FK_alumno_carrera]
GO
ALTER TABLE [dbo].[libro]  WITH CHECK ADD  CONSTRAINT [FK_libro_area] FOREIGN KEY([ID_AREA])
REFERENCES [dbo].[area] ([ID])
GO
ALTER TABLE [dbo].[libro] CHECK CONSTRAINT [FK_libro_area]
GO
ALTER TABLE [dbo].[libro]  WITH CHECK ADD  CONSTRAINT [FK_libro_autor] FOREIGN KEY([ID_AUTOR])
REFERENCES [dbo].[autor] ([ID])
GO
ALTER TABLE [dbo].[libro] CHECK CONSTRAINT [FK_libro_autor]
GO
ALTER TABLE [dbo].[libro]  WITH CHECK ADD  CONSTRAINT [FK_libro_editorial] FOREIGN KEY([ID_EDITORIAL])
REFERENCES [dbo].[editorial] ([ID])
GO
ALTER TABLE [dbo].[libro] CHECK CONSTRAINT [FK_libro_editorial]
GO
ALTER TABLE [dbo].[prestamo_libro]  WITH CHECK ADD  CONSTRAINT [FK_prestamo_libro_alumno] FOREIGN KEY([ID_ESTUDIANTE])
REFERENCES [dbo].[alumno] ([ID])
GO
ALTER TABLE [dbo].[prestamo_libro] CHECK CONSTRAINT [FK_prestamo_libro_alumno]
GO
ALTER TABLE [dbo].[prestamo_libro]  WITH CHECK ADD  CONSTRAINT [FK_prestamo_libro_libro] FOREIGN KEY([ID_LIBRO])
REFERENCES [dbo].[libro] ([ID])
GO
ALTER TABLE [dbo].[prestamo_libro] CHECK CONSTRAINT [FK_prestamo_libro_libro]
GO
ALTER TABLE [dbo].[prestamo_libro]  WITH CHECK ADD  CONSTRAINT [FK_prestamo_libro_usuario] FOREIGN KEY([ID_USUARIO])
REFERENCES [dbo].[usuario] ([ID])
GO
ALTER TABLE [dbo].[prestamo_libro] CHECK CONSTRAINT [FK_prestamo_libro_usuario]
GO
ALTER TABLE [dbo].[prestamo_tablet]  WITH CHECK ADD  CONSTRAINT [FK_prestamo_tablet_alumno] FOREIGN KEY([ID_ESTUDIANTE])
REFERENCES [dbo].[alumno] ([ID])
GO
ALTER TABLE [dbo].[prestamo_tablet] CHECK CONSTRAINT [FK_prestamo_tablet_alumno]
GO
ALTER TABLE [dbo].[prestamo_tablet]  WITH CHECK ADD  CONSTRAINT [FK_prestamo_tablet_tablet] FOREIGN KEY([ID_TABLET])
REFERENCES [dbo].[tablet] ([ID])
GO
ALTER TABLE [dbo].[prestamo_tablet] CHECK CONSTRAINT [FK_prestamo_tablet_tablet]
GO
ALTER TABLE [dbo].[prestamo_tablet]  WITH CHECK ADD  CONSTRAINT [FK_prestamo_tablet_usuario] FOREIGN KEY([ID_USUARIO])
REFERENCES [dbo].[usuario] ([ID])
GO
ALTER TABLE [dbo].[prestamo_tablet] CHECK CONSTRAINT [FK_prestamo_tablet_usuario]
GO
USE [master]
GO
ALTER DATABASE [InstitutoOlimpo] SET  READ_WRITE 
GO
