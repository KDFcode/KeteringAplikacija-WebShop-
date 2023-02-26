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
public class NarudzbenicaBean {
    int id;
    int ukupna_cena;
    String lista_proizvoda;
    String korisnicko_ime_kupca;

    public NarudzbenicaBean() {
    }

    public NarudzbenicaBean(int id, int ukupna_cena, String lista_proizvoda, String korisnicko_ime_kupca) {
        this.id = id;
        this.ukupna_cena = ukupna_cena;
        this.lista_proizvoda = lista_proizvoda;
        this.korisnicko_ime_kupca = korisnicko_ime_kupca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUkupna_cena() {
        return ukupna_cena;
    }

    public void setUkupna_cena(int ukupna_cena) {
        this.ukupna_cena = ukupna_cena;
    }

    public String getLista_proizvoda() {
        return lista_proizvoda;
    }

    public void setLista_proizvoda(String lista_proizvoda) {
        this.lista_proizvoda = lista_proizvoda;
    }

    public String getKorisnicko_ime_kupca() {
        return korisnicko_ime_kupca;
    }

    public void setKorisnicko_ime_kupca(String korisnicko_ime_kupca) {
        this.korisnicko_ime_kupca = korisnicko_ime_kupca;
    }
    
    
    
    
}
