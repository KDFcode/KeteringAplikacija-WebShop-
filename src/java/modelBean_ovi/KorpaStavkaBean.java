/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelBean_ovi;

/**
 *
 * @author Aca
 */
public class KorpaStavkaBean {
    
    int id;
    int cena;
    int kolicina;
    String naziv_proizvoda;
    String korisnicko_ime_kupca;
    proizvodBean proizvod_stavke_korpe;

    public KorpaStavkaBean() {
    }

    public KorpaStavkaBean(int id, int cena,int kolicina, String naziv_proizvoda, String korisnicko_ime_kupca,proizvodBean proizvod_stavke_korpe) {
        this.id = id;
        this.cena = cena;
        this.naziv_proizvoda = naziv_proizvoda;
        this.korisnicko_ime_kupca = korisnicko_ime_kupca; 
        this.proizvod_stavke_korpe=proizvod_stavke_korpe;
    }

    public proizvodBean getProizvod_stavke_korpe() {
        return proizvod_stavke_korpe;
    }

    public void setProizvod_stavke_korpe(proizvodBean proizvod_stavke_korpe) {
        this.proizvod_stavke_korpe = proizvod_stavke_korpe;
    }

    
    
    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getNaziv_proizvoda() {
        return naziv_proizvoda;
    }

    public void setNaziv_proizvoda(String naziv_proizvoda) {
        this.naziv_proizvoda = naziv_proizvoda;
    }

    public String getKorisnicko_ime_kupca() {
        return korisnicko_ime_kupca;
    }

    public void setKorisnicko_ime_kupca(String korisnicko_ime_kupca) {
        this.korisnicko_ime_kupca = korisnicko_ime_kupca;
    }
    
     public int getUkupnaCena() {
        return kolicina * proizvod_stavke_korpe.getCena();
    }
    
    
}
