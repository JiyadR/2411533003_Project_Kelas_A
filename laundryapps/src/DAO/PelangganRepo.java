package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pelanggan;

public class PelangganRepo {

    private Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/laundry_apps";
        String user = "root"; 
        String password = ""; 
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public void save(Pelanggan pelanggan) {
        String sql = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pelanggan.getNama());
            stmt.setString(2, pelanggan.getEmail());
            stmt.setString(3, pelanggan.getTelepon());
            stmt.executeUpdate();

            System.out.println("Data pelanggan berhasil disimpan ke database!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pelanggan> show() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setId(rs.getString("id")); // pastikan kolom id ada di tabel
                p.setNama(rs.getString("nama"));
                p.setEmail(rs.getString("email"));
                p.setTelepon(rs.getString("telepon"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(Pelanggan pelanggan) {
        String sql = "UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pelanggan.getNama());
            stmt.setString(2, pelanggan.getEmail());
            stmt.setString(3, pelanggan.getTelepon());
            stmt.setString(4, pelanggan.getId());
            stmt.executeUpdate();

            System.out.println("Data pelanggan berhasil diupdate di database!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM pelanggan WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

            System.out.println("Data pelanggan berhasil dihapus dari database!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
