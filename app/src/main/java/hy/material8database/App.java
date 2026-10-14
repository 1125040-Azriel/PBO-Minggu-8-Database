package hy.material8database;

import java.util.List;
import java.util.Scanner;

import hy.material8database.models.Mahasiswa;
import hy.material8database.repository.MahasiswaRepository;

public class App {

    private final Scanner scanner = new Scanner(System.in);

    public App() {
        menuUtama();
    }

    private void menuUtama() {
        while (true) {
            System.out.println("\n===== APLIKASI PBO DATABASE =====");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Jurusan");
            System.out.println("3. Mata Kuliah");
            System.out.println("4. Ambil Mata Kuliah");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1": menuMahasiswa(); break;
                case "2": menuJurusan(); break;
                case "3": menuMatakuliah(); break;
                case "4": menuAmbilMatakuliah(); break;
                case "0":
                    System.out.println("Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // ==================== MAHASISWA ====================

    private void menuMahasiswa() {
        while (true) {
            System.out.println("\n===== MENU MAHASISWA =====");
            System.out.println("1. Lihat semua mahasiswa");
            System.out.println("2. Tambah mahasiswa");
            System.out.println("3. Edit mahasiswa");
            System.out.println("4. Hapus mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1": printAllMahasiswa(); break;
                case "2": addNewMahasiswa(); break;
                case "3": editMahasiswa(); break;
                case "4": deleteMahasiswa(); break;
                case "0": return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void addNewMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama);
        MahasiswaRepository.addMahasiswa(mhs);
        System.out.println("Permintaan tambah mahasiswa selesai.");
    }

    private void printAllMahasiswa() {
        List<Mahasiswa> allMahasiswa = MahasiswaRepository.getAllMahasiswa();
        System.out.println("\n===== DAFTAR MAHASISWA =====");
        if (allMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }
        for (Mahasiswa m : allMahasiswa) {
            System.out.println(m.nim + " - " + m.nama);
        }
    }

    private void editMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin diedit: ");
        String nim = scanner.nextLine();
        Mahasiswa mhs = MahasiswaRepository.getMahasiswaByNim(nim);
        if (mhs == null) {
            System.out.println("Mahasiswa tidak ditemukan.");
            return;
        }
        System.out.println("Nama saat ini: " + mhs.nama);
        System.out.print("Masukkan nama baru: ");
        mhs.nama = scanner.nextLine();
        MahasiswaRepository.updateMahasiswa(mhs);
        System.out.println("Permintaan edit mahasiswa selesai.");
    }

    private void deleteMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();
        Mahasiswa mhs = MahasiswaRepository.getMahasiswaByNim(nim);
        if (mhs == null) {
            System.out.println("Mahasiswa tidak ditemukan.");
            return;
        }
        System.out.println("Mahasiswa: " + mhs.nama);
        System.out.print("Yakin ingin menghapus? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            MahasiswaRepository.deleteMahasiswa(nim);
            System.out.println("Permintaan hapus mahasiswa selesai.");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    // ==================== JURUSAN ====================

    private void menuJurusan() {
        while (true) {
            System.out.println("\n===== MENU JURUSAN =====");
            System.out.println("1. Lihat semua jurusan");
            System.out.println("2. Tambah jurusan");
            System.out.println("3. Edit jurusan");
            System.out.println("4. Hapus jurusan");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1": printAllJurusan(); break;
                case "2": addJurusan(); break;
                case "3": editJurusan(); break;
                case "4": deleteJurusan(); break;
                case "0": return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void printAllJurusan() {
        java.util.List<hy.material8database.models.Jurusan> daftar =
                hy.material8database.repository.JurusanRepository.getAllJurusan();
        System.out.println("\n===== DAFTAR JURUSAN =====");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada data jurusan.");
            return;
        }
        for (hy.material8database.models.Jurusan j : daftar) {
            System.out.println(j.kodeJurusan + " - " + j.nama);
        }
    }

    private void addJurusan() {
        System.out.print("Masukkan kode jurusan: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama jurusan: ");
        String nama = scanner.nextLine();

        hy.material8database.models.Jurusan jurusan =
                new hy.material8database.models.Jurusan(kode, nama);
        hy.material8database.repository.JurusanRepository.addJurusan(jurusan);
        System.out.println("Permintaan tambah jurusan selesai.");
    }

    private void editJurusan() {
        System.out.print("Masukkan kode jurusan yang ingin diedit: ");
        String kode = scanner.nextLine();
        hy.material8database.models.Jurusan jurusan =
                hy.material8database.repository.JurusanRepository.getJurusanByKode(kode);
        if (jurusan == null) {
            System.out.println("Jurusan tidak ditemukan.");
            return;
        }
        System.out.println("Nama saat ini: " + jurusan.nama);
        System.out.print("Masukkan nama baru: ");
        jurusan.nama = scanner.nextLine();
        hy.material8database.repository.JurusanRepository.updateJurusan(jurusan);
        System.out.println("Permintaan edit jurusan selesai.");
    }

    private void deleteJurusan() {
        System.out.print("Masukkan kode jurusan yang ingin dihapus: ");
        String kode = scanner.nextLine();
        hy.material8database.models.Jurusan jurusan =
                hy.material8database.repository.JurusanRepository.getJurusanByKode(kode);
        if (jurusan == null) {
            System.out.println("Jurusan tidak ditemukan.");
            return;
        }
        System.out.println("Jurusan: " + jurusan.nama);
        System.out.print("Yakin ingin menghapus? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            hy.material8database.repository.JurusanRepository.deleteJurusan(kode);
            System.out.println("Permintaan hapus jurusan selesai.");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    // ==================== MATA KULIAH ====================

    private void menuMatakuliah() {
        while (true) {
            System.out.println("\n===== MENU MATA KULIAH =====");
            System.out.println("1. Lihat semua mata kuliah");
            System.out.println("2. Tambah mata kuliah");
            System.out.println("3. Edit mata kuliah");
            System.out.println("4. Hapus mata kuliah");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1": printAllMatakuliah(); break;
                case "2": addMatakuliah(); break;
                case "3": editMatakuliah(); break;
                case "4": deleteMatakuliah(); break;
                case "0": return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void printAllMatakuliah() {
        java.util.List<hy.material8database.models.Matakuliah> daftar =
                hy.material8database.repository.MatakuliahRepository.getAllMatakuliah();
        System.out.println("\n===== DAFTAR MATA KULIAH =====");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada data mata kuliah.");
            return;
        }
        for (hy.material8database.models.Matakuliah mk : daftar) {
            System.out.println(mk.kodeMatakuliah + " - " + mk.nama
                    + " | SKS: " + mk.sks + " | Jurusan: " + mk.kodeJurusan);
        }
    }

    private void addMatakuliah() {
        System.out.print("Masukkan kode mata kuliah: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama mata kuliah: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan jumlah SKS: ");

        int sks;
        try {
            sks = Integer.parseInt(scanner.nextLine());
            if (sks <= 0) {
                System.out.println("SKS harus lebih dari 0.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("SKS harus berupa angka.");
            return;
        }

        System.out.print("Masukkan kode jurusan: ");
        String kodeJurusan = scanner.nextLine();
        hy.material8database.models.Matakuliah mk =
                new hy.material8database.models.Matakuliah(kode, nama, sks, kodeJurusan);
        hy.material8database.repository.MatakuliahRepository.addMatakuliah(mk);
    }

    private void editMatakuliah() {
        System.out.print("Masukkan kode mata kuliah yang ingin diedit: ");
        String kode = scanner.nextLine();
        hy.material8database.models.Matakuliah mk =
                hy.material8database.repository.MatakuliahRepository.getMatakuliahByKode(kode);
        if (mk == null) {
            System.out.println("Mata kuliah tidak ditemukan.");
            return;
        }

        System.out.println("Nama saat ini: " + mk.nama);
        System.out.print("Masukkan nama baru: ");
        mk.nama = scanner.nextLine();
        System.out.println("SKS saat ini: " + mk.sks);
        System.out.print("Masukkan jumlah SKS baru: ");

        try {
            int sksBaru = Integer.parseInt(scanner.nextLine());
            if (sksBaru <= 0) {
                System.out.println("SKS harus lebih dari 0.");
                return;
            }
            mk.sks = sksBaru;
        } catch (NumberFormatException e) {
            System.out.println("SKS harus berupa angka.");
            return;
        }

        System.out.println("Jurusan saat ini: " + mk.kodeJurusan);
        System.out.print("Masukkan kode jurusan baru: ");
        mk.kodeJurusan = scanner.nextLine();
        hy.material8database.repository.MatakuliahRepository.updateMatakuliah(mk);
    }

    private void deleteMatakuliah() {
        System.out.print("Masukkan kode mata kuliah yang ingin dihapus: ");
        String kode = scanner.nextLine();
        hy.material8database.models.Matakuliah mk =
                hy.material8database.repository.MatakuliahRepository.getMatakuliahByKode(kode);
        if (mk == null) {
            System.out.println("Mata kuliah tidak ditemukan.");
            return;
        }

        System.out.println("Mata kuliah: " + mk.nama);
        System.out.print("Yakin ingin menghapus? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            hy.material8database.repository.MatakuliahRepository.deleteMatakuliah(kode);
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    
private void menuAmbilMatakuliah() {
    while (true) {
        System.out.println("\n===== MENU AMBIL MATA KULIAH =====");
        System.out.println("1. Lihat pengambilan mata kuliah");
        System.out.println("2. Tambah pengambilan mata kuliah");
        System.out.println("3. Hapus pengambilan mata kuliah");
        System.out.println("0. Kembali");
        System.out.print("Pilih menu: ");

        String pilihan = scanner.nextLine();

        switch (pilihan) {
            case "1":
                hy.material8database.repository.AmbilMatakuliahRepository
                        .tampilkanSemua();
                break;

            case "2":
                System.out.print("Masukkan NIM mahasiswa: ");
                String nim = scanner.nextLine();

                System.out.print("Masukkan kode mata kuliah: ");
                String kode = scanner.nextLine();

                hy.material8database.repository.AmbilMatakuliahRepository
                        .tambah(nim, kode);
                break;

            case "3":
                System.out.print("Masukkan NIM mahasiswa: ");
                String nimHapus = scanner.nextLine();

                System.out.print("Masukkan kode mata kuliah: ");
                String kodeHapus = scanner.nextLine();

                System.out.print("Yakin ingin menghapus? (y/n): ");
                String konfirmasi = scanner.nextLine();

                if (konfirmasi.equalsIgnoreCase("y")) {
                    hy.material8database.repository.AmbilMatakuliahRepository
                            .hapus(nimHapus, kodeHapus);
                } else {
                    System.out.println("Penghapusan dibatalkan.");
                }
                break;

            case "0":
                return;

            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}


    public static void main(String[] args) {
        new App();
    }
}
