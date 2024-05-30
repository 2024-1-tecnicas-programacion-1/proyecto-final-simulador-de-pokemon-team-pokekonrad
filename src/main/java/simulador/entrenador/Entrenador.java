package simulador.entrenador;
import simulador.pokemon.Pokemon;
import java.util.*;

public class Entrenador {
    private String nombre;
    private ArrayList<Pokemon> listaDePokemones = new ArrayList<>();
    
    public Entrenador(String nombre){
        this.nombre = nombre;
       
    }
    public void agregarPokemon(Pokemon pokemon){
        listaDePokemones.add(pokemon);
        //Añade un pokemon al equipo del entrenador
    }
    public void entrenarPokemones(Pokemon pokemon){
        pokemon.entrenar();
        //Selecciona un pokemon para entrenar, mejorando sus estadisticas
    }
    public void sanarPokemones(Pokemon pokemon){
        pokemon.sanar();
    }
    public ArrayList mostrarPokemones(){
        return listaDePokemones;
        //Muestra la lista de los pokemones actuales del entrenador
    }
    public void prepararBatalla(){
        //Selecciona un pokemon de su equipo para participar en una batalla
    }
    public String getNombre(){
        return nombre;
    }

    public ArrayList<Pokemon> getListaDePokemones() {
        return listaDePokemones;
    }

    public void setListaDePokemones(ArrayList<Pokemon> listaDePokemones) {
        this.listaDePokemones = listaDePokemones;
    }
    
    


}
