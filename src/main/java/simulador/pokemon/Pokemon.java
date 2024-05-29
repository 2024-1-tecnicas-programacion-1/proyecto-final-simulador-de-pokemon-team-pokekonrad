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
        
    }
    public void recibirDaño(int daño){
        
    }
    public void entrenar(){
        
    }
    public String getNombre(){
        return nombre;
    }
}

