package simulador.batalla;
import simulador.pokemon.Pokemon;
import java.util.*;
import simulador.pokemon.TipoPokemon;

public class Batalla {
    Pokemon ganador;
    Random nAleatorio = new Random();
    public Pokemon inciarBatalla(Pokemon  pokemon1, Pokemon pokemon2){
        boolean primerAtaque = nAleatorio.nextBoolean();
        int turno = (primerAtaque)?1:2;
        while (pokemon1.getSalud() > 0 && pokemon2.getSalud()>0) {
            if (turno == 1){
                pokemon1.atacar(pokemon2);
                pokemon2.recibirDaño((int)(pokemon1.getPuntosDeAtaque()*TipoPokemon.obtenerMultiplicadorDeDaño(pokemon1.getTipo(), pokemon2.getTipo())));//definir daño
                System.out.println("El pokemon " + pokemon1.getNombre() + " ataco a " + pokemon2.getNombre());
            }
            else {
                pokemon2.atacar(pokemon1);
                pokemon1.recibirDaño((int)(pokemon2.getPuntosDeAtaque()*TipoPokemon.obtenerMultiplicadorDeDaño(pokemon2.getTipo(), pokemon1.getTipo())));//definir daño
                System.out.println("El pokemon " + pokemon2.getNombre() + " ataco a " + pokemon1.getNombre());
            }
            
            System.out.println("La vida del 1 pokemon " + pokemon1.getNombre()+ " es de: "+pokemon1.getSalud());
            System.out.println("La vida del 2 pokemon " + pokemon2.getNombre()+ " es de: "+pokemon2.getSalud());
          
            if (pokemon1.getSalud()<0){
                System.out.println("El Pokemon " + pokemon1.getNombre() + " no puede seguir luchando");
                
            }
            if (pokemon2.getSalud()<0){
                System.out.println("El Pokemon " + pokemon2.getNombre() + " no puede seguir luchando");
                
            }
            
            turno = (turno==1)?2:1;
        }
        if (pokemon1.getSalud() > pokemon2.getSalud()){
            ganador = pokemon1;
        }
        else{
            ganador = pokemon2;
        }
        return ganador;
    }
}
