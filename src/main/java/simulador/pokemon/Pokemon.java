package simulador.pokemon;

public abstract class Pokemon {
    // TODO: Aquí va tu código 
    
    private String nombre;
    private int salud;
    private int puntosDeAtaque;
    private TipoPokemon tipo;
    private String estado;
    
    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo, String estado){
        this.nombre=nombre;
        this.salud=salud;
        this.puntosDeAtaque=puntosDeAtaque;
        this.tipo=tipo;
        this.estado=estado;
    }
    public void atacar(Pokemon oponente){
        int danio =(int)(this.puntosDeAtaque*TipoPokemon.obtenerMultiplicadorDeDaño(this.tipo, oponente.tipo));
        oponente.recibirDaño(danio);
    }
    public void recibirDaño(int danio){
        
    }
    public void entrenar(){
        this.puntosDeAtaque += 5;
        this.salud += 10;
    }
    public String getNombre(){
        return nombre;
    }
}

