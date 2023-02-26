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
public class korisnik {
    int id;
    String ime;
    String lozinka;

    public korisnik() {
    }

    public korisnik(int id,String ime, String lozinka) {
        this.id=id;
        this.ime = ime;
        this.lozinka = lozinka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    
}
