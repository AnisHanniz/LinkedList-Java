public class ListeChainee{

    private Cellule tete = new Cellule();
    private Cellule queue= new Cellule();

    public ListeChainee(){
        tete=null;
        queue= null;
    }
    public ListeChainee(Cellule _tete){
        tete= _tete;
        Cellule tmp =tete;
        while (tmp.getSuivant()!=null){
            tmp=tmp.getSuivant();
        }
        queue=tmp;
    }
    public ListeChainee(ListeChainee lo){
        Cellule tmpo=lo.getTete();
        Cellule tmpc=new Cellule();
        tmpc.setContenu(tmpo.getContenu());
        tete=tmpc;
        tmpo=tmpo.getSuivant();
        while(tmpo!=null){
            Cellule intermediaire = new Cellule(tmpo.getContenu());
            tmpc.setSuivant(intermediaire);
            tmpo=tmpo.getSuivant();
            tmpc=tmpc.getSuivant();
        }
        queue=tmpc;
    }
    public boolean estVide(){
        return tete==null;
    }
    public Object enTete(){
        return tete.getContenu();
    }
    public Object enQueue(){
        return queue.getContenu();
    }

    public Cellule getTete(){
        return tete;
    }
    public Cellule getQueue(){
        return queue;
    }
    public void ajouteQueue(Object o_tete){
        Cellule c = new Cellule(o_tete);
        if(estVide()){
            tete=c;
            queue=tete;
        }else{
            Cellule d = queue;
            d.setSuivant(c);
        }
    }
    public void ajouteTete(Object o_tete){
        Cellule c = new Cellule(o_tete);
        if(estVide()){
            tete=c;
            queue=tete;
        }else{
            c.setSuivant(tete);
            }
            tete=c;
        }
        


    public void retireTete(){
        Cellule tmp = tete;
        Cellule sauv = tete.getSuivant();
        tmp.setSuivant(null);
        tete=sauv;
    }

    public void retireQueue(){
        Cellule tmp = tete;
        while(tmp.getSuivant()!=queue){
            tmp=tmp.getSuivant();
        }
        tmp.setSuivant(null);
        queue=tmp;
    }

    public void inserePos(int pos, Object o){
    if(pos==1){ajouteTete(o);}
    else if(pos==length()){ajouteQueue(o);}
    else if(pos>length() || pos<=0){System.out.println("Erreur position!");}
    else{
    
        int i = 1;
        Cellule courrante = tete;
        Cellule obj = new Cellule(o);
        if(!estVide()){
            while(i!=pos){
                courrante=courrante.getSuivant();
                i++;
            }
            Cellule suivante=new Cellule();
            suivante=courrante.getSuivant();
            courrante.setSuivant(obj);
            obj.setSuivant(suivante);
        }
    }
    }

    public void retirePos(int pos){
        if(pos==1){retireTete();}
    else if(pos==length()){retireQueue();}
    else if(pos>length() || pos<=0){System.out.println("Erreur position!");}
    else{

        int i = 2;
        Cellule precedente = tete;
        Cellule courrante = tete.getSuivant();
        while(i!=pos){
            precedente=precedente.getSuivant();
            courrante=courrante.getSuivant();
            i++;
        }
        precedente.setSuivant(courrante.getSuivant());
        courrante.setSuivant(null);
    }}


    public int length(){
        if(estVide())return 0;
        int i = 1;
        Cellule tmp=tete;
        while(tmp.getSuivant()!=null){
            i++;
            tmp=tmp.getSuivant();
        }
        return i;
    }


    public String toString(){
        if(estVide()){return "nil";}
        Cellule tmp = tete;
        String str= tmp.toString();
        tmp=tmp.getSuivant();
        while(tmp!=null){
            str+="-> "+tmp.toString();
            tmp=tmp.getSuivant();
        }
        return str+" -> nil";
    }

    public static void main(String[] args){
        ListeChainee lc= new ListeChainee();
        System.out.println(lc.toString());
        lc.ajouteTete(2);
        lc.ajouteTete(7);
        lc.ajouteTete(5);
        lc.ajouteTete(5);
        lc.ajouteTete(5);
        lc.ajouteQueue(1);
        System.out.println(lc.toString());
        /*
        lc.retireTete();
        System.out.println(lc.toString());
        lc.retireQueue();
        System.out.println(lc.toString());
        lc.retirePos(1);
        System.out.println(lc.toString());
        ListeChainee lv= new ListeChainee(lc.getTete());
        lc.retireTete();
        System.out.println(lv.toString());*/
        ListeChainee l3 = new ListeChainee(lc);
        System.out.println(l3.toString());
    }
}