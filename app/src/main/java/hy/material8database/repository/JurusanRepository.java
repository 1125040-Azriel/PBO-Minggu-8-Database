
package hy.material8database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hy.material8database.database.Database;
import hy.material8database.models.Jurusan;

public class JurusanRepository {

    private static final Connection conn = Database.connect();

    // READ ALL
    public static List<Jurusan> getAllJurusan() {
        List<Jurusan> result = new ArrayList<>();
        String sql = "SELECT kode_jurusan, nama FROM jurusan";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                result.add(new Jurusan(
                    rs.getString("kode_jurusan"),
                    rs.getString("nama")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // READ BY KODE
    public static Jurusan getJurusanByKode(String kode) {
        String sql = "SELECT kode_jurusan, nama FROM jurusan WHERE kode_jurusan = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, kode);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Jurusan(
                        rs.getString("kode_jurusan"),
                        rs.getString("nama")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // CREATE
    public static void addJurusan(Jurusan jurusan) {
        String sql = "INSERT INTO jurusan (kode_jurusan, nama) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, jurusan.kodeJurusan);
            stmt.setString(2, jurusan.nama);
            stmt.executeUpdate();
            System.out.println("Jurusan berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan jurusan.");
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateJurusan(Jurusan jurusan) {
        String sql = "UPDATE jurusan SET nama = ? WHERE kode_jurusan = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, jurusan.nama);
            stmt.setString(2, jurusan.kodeJurusan);
            stmt.executeUpdate();
            System.out.println("Permintaan edit jurusan selesai.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteJurusan(String kode) {
        String sql = "DELETE FROM jurusan WHERE kode_jurusan = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, kode);
            stmt.executeUpdate();
            System.out.println("Permintaan hapus jurusan selesai.");
        } catch (SQLException e) {
            System.out.println("Gagal menghapus jurusan. Pastikan jurusan tidak sedang digunakan mahasiswa atau mata kuliah.");
            e.printStackTrace();
        }
    }
}
