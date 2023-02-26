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
public class proizvodBean {
    int id;
    String naziv;
    String opis;
    int cena;
    String tip_programa; //slatki/slani

    public proizvodBean() {
    }

    public proizvodBean(int id, String naziv, String opis, int cena,String tip_programa) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.tip_programa= tip_programa;
    }

    public String getTip_programa() {
        return tip_programa;
    }

    public void setTip_programa(String tip_programa) {
        this.tip_programa = tip_programa;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    
    
    
}
