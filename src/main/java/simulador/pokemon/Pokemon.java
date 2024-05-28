package simulador.pokemon;

public abstract class Pokemon {
    // TODO: Aquí va tu código 
    
    private String nombre;
    private double salud;
    private double puntosDeAtaque;
    private String tipo;
    private String estado;
    
    public Pokemon(String nombre, double salud, double puntosDeAtaque, String tipo, String estado){
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
    
}

