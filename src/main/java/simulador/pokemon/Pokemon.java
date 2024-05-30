package simulador.pokemon;

public abstract class Pokemon {
    // TODO: Aquí va tu código 
    
    private String nombre;
    private int salud;
    private int saludPorDefecto;
    private int puntosDeAtaque;
    private TipoPokemon tipo;
    private String estado;
    
    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo, String estado){
        this.nombre=nombre;
        this.salud=salud;
        this.puntosDeAtaque=puntosDeAtaque;
        this.tipo=tipo;
        this.estado=estado;
        this.saludPorDefecto=salud;
    }
    public void atacar(Pokemon oponente){
        int danio =(int)(this.puntosDeAtaque*TipoPokemon.obtenerMultiplicadorDeDaño(this.tipo, oponente.tipo));
        oponente.recibirDaño(danio);
    }
    public void recibirDaño(int danio){
        this.salud -= danio;
        if(this.salud < 0){
            this.salud = 0;
        }
    }
    public void entrenar(){
        this.puntosDeAtaque += 5;
        this.salud += 10;
        this.saludPorDefecto += 10;
    }
    public void sanar(){
        this.salud = saludPorDefecto;
    }
    public String getNombre(){
        return nombre;
    }
    public int getSalud(){
        return salud;
    }
    public int getSaludPorDefecto(){
        return saludPorDefecto;
    }
    public int getPuntosDeAtaque(){
        return puntosDeAtaque;
    }
    public TipoPokemon getTipo(){
        return tipo;
    }
}

