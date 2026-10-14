
package hy.material8database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hy.material8database.database.Database;

public class AmbilMatakuliahRepository {

    private static final Connection conn = Database.connect();

    // READ: melihat mata kuliah yang diambil mahasiswa
    public static void tampilkanSemua() {
        String sql =
                "SELECT mm.nim, m.nama AS nama_mahasiswa, " +
                "mm.kode_matakuliah, mk.nama AS nama_matakuliah, " +
                "mm.indeks_nilai " +
                "FROM mahasiswa_matakuliah mm " +
                "JOIN mahasiswa m ON mm.nim = m.nim " +
                "JOIN matakuliah mk " +
                "ON mm.kode_matakuliah = mk.kode_matakuliah " +
                "ORDER BY mm.nim";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n===== DAFTAR PENGAMBILAN MATA KULIAH =====");

            boolean adaData = false;

            while (rs.next()) {
                adaData = true;

                System.out.println(
                        rs.getString("nim") + " - " +
                        rs.getString("nama_mahasiswa") +
                        " | " + rs.getString("kode_matakuliah") +
                        " - " + rs.getString("nama_matakuliah") +
                        " | Nilai: " + rs.getString("indeks_nilai")
                );
            }

            if (!adaData) {
                System.out.println("Belum ada data pengambilan mata kuliah.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menampilkan pengambilan mata kuliah.");
            e.printStackTrace();
        }
    }

    // CREATE: mendaftarkan mahasiswa ke mata kuliah
    public static void tambah(String nim, String kodeMatakuliah) {
        String sql =
                "INSERT INTO mahasiswa_matakuliah " +
                "(nim, kode_matakuliah, indeks_nilai) " +
                "VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.setString(2, kodeMatakuliah);
            stmt.setNull(3, java.sql.Types.VARCHAR);

            int hasil = stmt.executeUpdate();

            if (hasil > 0) {
                System.out.println("Pengambilan mata kuliah berhasil ditambahkan.");
            }

        } catch (SQLException e) {
            System.out.println(
                    "Gagal menambahkan. Periksa NIM, kode mata kuliah, " +
                    "dan apakah mahasiswa sudah mengambil mata kuliah tersebut."
            );
            e.printStackTrace();
        }
    }

    // DELETE: membatalkan pengambilan mata kuliah
    public static void hapus(String nim, String kodeMatakuliah) {
        String sql =
                "DELETE FROM mahasiswa_matakuliah " +
                "WHERE nim = ? AND kode_matakuliah = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.setString(2, kodeMatakuliah);

            int hasil = stmt.executeUpdate();

            if (hasil > 0) {
                System.out.println("Pengambilan mata kuliah berhasil dihapus.");
            } else {
                System.out.println("Data pengambilan mata kuliah tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menghapus pengambilan mata kuliah.");
            e.printStackTrace();
        }
    }
}
