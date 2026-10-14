CREATE TABLE IF NOT EXISTS "jurusan" (
	"kode_jurusan" VARCHAR(10) NOT NULL,
	"nama" VARCHAR(100) NOT NULL,
	PRIMARY KEY ("kode_jurusan")
);


INSERT INTO "jurusan" ("kode_jurusan", "nama") VALUES
	('IF', 'Informatika'),
	('SI', 'Sistem Informasi');


CREATE TABLE IF NOT EXISTS "mahasiswa" (
	"nim" VARCHAR(20) NOT NULL,
	"nama" VARCHAR(100) NOT NULL,
	"kode_jurusan" VARCHAR(10) NULL DEFAULT NULL,
	PRIMARY KEY ("nim"),
	CONSTRAINT "fk_mahasiswa_jurusan" FOREIGN KEY ("kode_jurusan") REFERENCES "jurusan" ("kode_jurusan") ON UPDATE NO ACTION ON DELETE NO ACTION
);


INSERT INTO "mahasiswa" ("nim", "nama", "kode_jurusan") VALUES
	('1112048', 'Hans Yulian', 'IF'),
	('1117001', 'Natasha Yulian', 'IF');


CREATE TABLE IF NOT EXISTS "matakuliah" (
	"kode_matakuliah" VARCHAR(10) NOT NULL,
	"nama" VARCHAR(100) NOT NULL,
	"sks" INTEGER NOT NULL,
	"kode_jurusan" VARCHAR(10) NULL DEFAULT NULL,
	PRIMARY KEY ("kode_matakuliah"),
	CONSTRAINT "fk_matakuliah_jurusan" FOREIGN KEY ("kode_jurusan") REFERENCES "jurusan" ("kode_jurusan") ON UPDATE NO ACTION ON DELETE NO ACTION
);


INSERT INTO "matakuliah" ("kode_matakuliah", "nama", "sks", "kode_jurusan") VALUES
	('IF-101', 'Algoritma dan Pemrograman', 3, 'IF'),
	('IF-102', 'Struktur Data', 3, 'IF'),
	('IF-103', 'Basis Data', 3, 'IF'),
	('IF-104', 'Pemrograman Berorientasi Objek', 3, 'IF'),
	('SI-201', 'Sistem Informasi Manajemen', 3, 'SI'),
	('SI-202', 'Analisis Proses Bisnis', 3, 'SI');


CREATE TABLE IF NOT EXISTS "mahasiswa_matakuliah" (
	"nim" VARCHAR(20) NOT NULL,
	"kode_matakuliah" VARCHAR(10) NOT NULL,
	"indeks_nilai" CHAR(1) NULL DEFAULT NULL,
	PRIMARY KEY ("nim", "kode_matakuliah"),
	CONSTRAINT "fk_mhs_mk_mahasiswa" FOREIGN KEY ("nim") REFERENCES "mahasiswa" ("nim") ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT "fk_mhs_mk_matakuliah" FOREIGN KEY ("kode_matakuliah") REFERENCES "matakuliah" ("kode_matakuliah") ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT "mahasiswa_matakuliah_indeks_nilai_check" CHECK ((indeks_nilai = ANY (ARRAY['A'::bpchar, 'B'::bpchar, 'C'::bpchar, 'D'::bpchar, 'E'::bpchar])))
);


INSERT INTO "mahasiswa_matakuliah" ("nim", "kode_matakuliah", "indeks_nilai") VALUES
	('1125001', 'IF-101', 'A'),
	('1125001', 'IF-102', 'B'),
	('1125001', 'IF-103', 'A'),
	('1125002', 'IF-101', 'C'),
	('1125002', 'IF-103', 'B'),
	('1125002', 'IF-104', 'A'),
	('1125004', 'SI-201', 'A'),
	('1125004', 'SI-202', 'B');
