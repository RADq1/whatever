package pl.nauczka.demo;

import javax.persistence.*;

@Entity
public class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String imie;
    private String nazwisko;
    private Double cash;
    @Enumerated(value = EnumType.STRING)
    private Plec plec;

    public Osoba() {
    }

    public Osoba(String imie, String nazwisko, Plec plec, Double cash) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.cash = cash;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Plec getPlec() {
        return plec;
    }

    public void setPlec(Plec plec) {
        this.plec = plec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", cash=" + cash +
                ", plec=" + plec +
                '}';
    }
}
