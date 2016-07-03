/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaposleni;

/**
 *
 * @author Pionir SU
 */
public class Zaposleni {
    
    private int id;
    private String Ime;
    private String Adresa;
    private int Starost;
    private double Zarada;

    public Zaposleni() {
    }

    public Zaposleni(int id, String Ime, String Adresa, int Starost, double Zarada) {
        this.id = id;
        this.Ime = Ime;
        this.Adresa = Adresa;
        this.Starost = Starost;
        this.Zarada = Zarada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String Adresa) {
        this.Adresa = Adresa;
    }

    public int getStarost() {
        return Starost;
    }

    public void setStarost(int Starost) {
        this.Starost = Starost;
    }

    public double getZarada() {
        return Zarada;
    }

    public void setZarada(double Zarada) {
        this.Zarada = Zarada;
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "id=" + id + ", Ime=" + Ime + ", Adresa=" + Adresa + ", Starost=" + Starost + ", Zarada=" + Zarada + '}';
    }
    
}
