package simulador.batalla;
import simulador.pokemon.Pokemon;
import java.util.*;

public class Batalla {
    Random nAleatorio = new Random();
    public Pokemon inciarBatalla(Pokemon  pokemon1, Pokemon pokemon2){
        int saludPokemon1 = pokemon1.getSalud();
        int saludPokemon2 = pokemon2.getSalud();
        Pokemon ganador;
        boolean primerAtaque = nAleatorio.nextBoolean();
        while (saludPokemon1 >0 && saludPokemon2>0) {
            if (primerAtaque){
                pokemon1.atacar(pokemon2);
            }
            else {
                pokemon2.atacar(pokemon1);
            }
            if (saludPokemon1<0){
                saludPokemon1 = 0;
            }
            if (saludPokemon2<0){
                saludPokemon2 = 0;
            }
        }
        if (saludPokemon1 > saludPokemon2){
            ganador = pokemon1;
        }
        else{
            ganador = pokemon2;
        }
        return ganador;
    }
}
