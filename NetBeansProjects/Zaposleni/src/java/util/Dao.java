package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import zaposleni.Zaposleni;

public class Dao {

    //private Connection connection;
    Konekcija con;

    public Dao() {
        // connection = getInstance();
        //      Konekcija con = Konekcija.getInstance();
        con = Konekcija.getInstance();
    }

    public void addZaposleni(Zaposleni zaposleni) {
//        Zaposleni zaposleni = new Zaposleni();
        try {

            PreparedStatement preparedStatement
                    = con.connect.prepareStatement("insert into zaposleni (ime, starost, adresa, zarada) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, zaposleni.getIme());
            preparedStatement.setInt(2, zaposleni.getStarost());
            preparedStatement.setString(3, zaposleni.getAdresa());
            preparedStatement.setDouble(4, zaposleni.getZarada());
            // preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteZaposleni(int Id) {
        try {
            PreparedStatement preparedStatement = con.connect.prepareStatement("delete from zaposleni where Id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateZaposleni(Zaposleni zaposleni) {
        try {
            PreparedStatement preparedStatement = con.connect
                    .prepareStatement("update zaposleni set ime=?, starost=?, adresa=?, zarada=?"
                            + "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, zaposleni.getIme());
            preparedStatement.setInt(2, zaposleni.getStarost());
            // preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
            preparedStatement.setString(3, zaposleni.getAdresa());
            preparedStatement.setDouble(4, zaposleni.getZarada());
            preparedStatement.setInt(5, zaposleni.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Zaposleni> getAllZaposleni() {
        List<Zaposleni> zaposleniList = new ArrayList<Zaposleni>();
        Zaposleni zaposleni = new Zaposleni();
        try {
            Statement statement = con.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from zaposleni");
            while (rs.next()) {
                // Zaposleni zaposleni = new Zaposleni();
                zaposleni.setId(rs.getInt("id"));
                zaposleni.setIme(rs.getString("ime"));
                zaposleni.setAdresa(rs.getString("adresa"));
                zaposleni.setStarost(rs.getInt("starost"));
                zaposleni.setZarada(rs.getDouble("zarada"));
                zaposleniList.add(zaposleni);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return zaposleniList;
    }

    public Zaposleni getZaposleniById(int zaposleniId) {
        Zaposleni zaposleni = new Zaposleni();
        try {
            PreparedStatement preparedStatement = con.connect.
                    prepareStatement("select * from zaposleni where id=?");
            preparedStatement.setInt(1, zaposleniId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                zaposleni.setId(rs.getInt("Id"));
                zaposleni.setIme(rs.getString("ime"));
                zaposleni.setAdresa(rs.getString("adresa"));
                zaposleni.setStarost(rs.getInt("starost"));
                zaposleni.setZarada(rs.getDouble("zarada"));                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return zaposleni;
    }

}
