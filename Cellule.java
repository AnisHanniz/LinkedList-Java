
public class Cellule {

    private Object contenu;
    private Cellule suivant;

    public Cellule() {
        contenu = null;
        suivant = null;
    }

    public Cellule(Object _contenu) {
        contenu = _contenu;
        suivant = null;
    }
    public Cellule getSuivant() {
        return suivant;
    }

    public void setSuivant(Cellule _c) {
        suivant = _c;
    }
    
    public void setSuivant(Object _o) {
        suivant = new Cellule(_o);
    }
    
    public Object getContenu() {
        return contenu;
    }
    public void setContenu(Object _c) {
        contenu = _c;
    }
    public String toString() {
        if (contenu == null) {
            return "nil";
        }
        else {
            return contenu.toString();
        }
    }
    

}