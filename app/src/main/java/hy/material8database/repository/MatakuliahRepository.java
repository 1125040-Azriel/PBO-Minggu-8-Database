
package hy.material8database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hy.material8database.database.Database;
import hy.material8database.models.Matakuliah;

public class MatakuliahRepository {

    private static final Connection conn;

    static {
        conn = Database.connect();
    }

    // CREATE
    public static void addMatakuliah(Matakuliah mk) {
        String sql = "INSERT INTO matakuliah " +
                "(kode_matakuliah, nama, sks, kode_jurusan) " +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mk.kodeMatakuliah);
            stmt.setString(2, mk.nama);
            stmt.setInt(3, mk.sks);
            stmt.setString(4, mk.kodeJurusan);

            stmt.executeUpdate();
            System.out.println("Mata kuliah berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan mata kuliah.");
            e.printStackTrace();
        }
    }

    // READ ALL
    public static List<Matakuliah> getAllMatakuliah() {
        List<Matakuliah> daftar = new ArrayList<>();

        String sql = "SELECT kode_matakuliah, nama, sks, kode_jurusan " +
                "FROM matakuliah";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                daftar.add(new Matakuliah(
                        rs.getString("kode_matakuliah"),
                        rs.getString("nama"),
                        rs.getInt("sks"),
                        rs.getString("kode_jurusan")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daftar;
    }

    // READ BY KODE
    public static Matakuliah getMatakuliahByKode(String kode) {
        String sql = "SELECT kode_matakuliah, nama, sks, kode_jurusan " +
                "FROM matakuliah WHERE kode_matakuliah = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kode);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Matakuliah(
                        rs.getString("kode_matakuliah"),
                        rs.getString("nama"),
                        rs.getInt("sks"),
                        rs.getString("kode_jurusan")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public static void updateMatakuliah(Matakuliah mk) {
        String sql = "UPDATE matakuliah " +
                "SET nama = ?, sks = ?, kode_jurusan = ? " +
                "WHERE kode_matakuliah = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mk.nama);
            stmt.setInt(2, mk.sks);
            stmt.setString(3, mk.kodeJurusan);
            stmt.setString(4, mk.kodeMatakuliah);

            stmt.executeUpdate();
            System.out.println("Mata kuliah berhasil diperbarui.");
        } catch (SQLException e) {
            System.out.println("Gagal memperbarui mata kuliah.");
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteMatakuliah(String kode) {
        String sql = "DELETE FROM matakuliah WHERE kode_matakuliah = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kode);

            stmt.executeUpdate();
            System.out.println("Mata kuliah berhasil dihapus.");
        } catch (SQLException e) {
            System.out.println("Gagal menghapus mata kuliah.");
            e.printStackTrace();
        }
    }
}
