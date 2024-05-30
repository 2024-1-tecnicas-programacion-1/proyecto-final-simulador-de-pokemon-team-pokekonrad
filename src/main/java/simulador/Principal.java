package simulador;
import java.util.*;
import simulador.batalla.Batalla;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Aerodactyl;
import simulador.pokemon.Electabuzz;
import simulador.pokemon.Gastly;
import simulador.pokemon.Jynx;
import simulador.pokemon.Magmar;
import simulador.pokemon.Mime;
import simulador.pokemon.Pokemon;
import simulador.pokemon.Sandshrew;
import simulador.pokemon.Seel;
import simulador.pokemon.Tangela;
import simulador.pokemon.Tentacool;
import simulador.pokemon.TipoPokemon;


public class Principal {
    
    static Scanner sc = new Scanner(System.in);
    static Entrenador entrenador;
    static ArrayList<Entrenador> Entrenadores = new ArrayList<>(); 
    static ArrayList<Pokemon> Pokemones = new ArrayList<>();
    static Entrenador entrenador1;
    static Entrenador entrenador2;
    static Pokemon pokemon1;
    static Pokemon pokemon2;
    static Pokemon newPokemon;
    
    public static void main(String[] args) {
        crearPokemones();
        mostrarMenu();
        
    }
    // -------- METODOS DE MENÚ -----------------
    public static void mostrarMenu(){
        
        int opcionMenuPrincipal;
        do{
            System.out.println(ejecutarBatalla(Pokemones.get(0), Pokemones.get(1)));
            System.out.println("MENU PRINCIPAL\n--------------------------------\n1.Gestionar entrenadores\n2.Gestionar pokemones\n3.Iniciar batalla\n4.Salir ");
            opcionMenuPrincipal = sc.nextInt();
            limpiarConsola();
            switch (opcionMenuPrincipal) {
                case 1:
                    int opcionSubmenu1;
                    do {
                        System.out.println("GESTIONAR ENTRENADORES\n--------------------------------\n1.Registrar nuevo entrenador\n2.Ver lista de entrenadores\n3.Seleccionar un entrenador\n4.Volver al menu principal");
                        opcionSubmenu1 = sc.nextInt();
                        limpiarConsola();
                        switch (opcionSubmenu1) {
                            case 1:
                                //Aqui va el registro de un nuevo entrenador
                                registrarNuevoEntrenador();
                                sc.nextLine();
                                validarContinuar();
                                limpiarConsola();
                                break;
                            case 2:
                                //Aqui va mostrar la lista de todos los entrenadores
                                if (Entrenadores.size()>0){
                                    System.out.println("Estos son los entrenadores registrados:");
                                    mostrarEntrenadores();
                                }
                                else{
                                    System.out.println("Aun no hay entrenadores registrados.");
                                }
                                sc.nextLine();
                                validarContinuar();
                                limpiarConsola();
                                break;
                            case 3:
                                //Aqui va seleccionar un entrenador
                                System.out.println("Selecciona un entrenador:");
                                if(Entrenadores.size()== 0){
                                    System.out.println("Aun no hay entrenadores registrados.");
                                }
                                else{
                                    mostrarEntrenadores();
                                    int seleccionEntrenador = sc.nextInt();
                                    if(seleccionEntrenador > Entrenadores.size()){
                                        System.out.println("Opcion invalida");
                                        sc.nextLine();
                                        validarContinuar();
                                        limpiarConsola();
                                    }
                                    else{
                                        int opcionAccionesDeEntrenador;
                                        doWhileOpcionAccionesDeEntrenador: //Esta es la etiqueta del ciclo do while externo para luego romperlo desde el ciclo interno con un break etiqueta;
                                        do{
                                            limpiarConsola();
                                            System.out.println(Entrenadores.get(seleccionEntrenador-1).getNombre().toUpperCase());
                                            System.out.println("---------------\n1.Ver equipo de Pokemones\n2.Agregar Pokemon al equipo\n3.Entrenar Pokemon\n4.Volver a gestionar entrenadores");
                                            opcionAccionesDeEntrenador = sc.nextInt();
                                            sc.nextLine();
                                            limpiarConsola();
                                            switch (opcionAccionesDeEntrenador) {
                                                case 1:
                                                    //Aqui va mostrar el equipo de pokemones
                                                    if (Entrenadores.get(seleccionEntrenador-1).getListaDePokemones().size()== 0){
                                                        System.out.println("Aun no has agregado Pokemones a tu equipo");
                                                    }
                                                    else{
                                                        System.out.println(Entrenadores.get(seleccionEntrenador-1).getNombre() + " tu equipo de Pokemones esta conformado por:");
                                                        int contador = 0;
                                                        for (Pokemon pok: Entrenadores.get(seleccionEntrenador-1).getListaDePokemones()){
                                                            contador ++;
                                                            System.out.println(contador + ". " + pok.getNombre());
                                                        }
                                                    }
                                                    validarContinuar();
                                                    limpiarConsola();
                                                    break;
                                                case 2:
                                                    //Aqui va agregar pokemones al equipo
                                                    System.out.println("Selecciona un Pokemon para agregarlo a tu equipo: ");
                                                    mostrarTodosPokemones();
                                                    int opcionPokemonAgregar = sc.nextInt();
                                                    Entrenadores.get(seleccionEntrenador-1).agregarPokemon(Pokemones.get(opcionPokemonAgregar-1));
                                                    System.out.println( Pokemones.get(opcionPokemonAgregar-1).getNombre() + " se agrego correctamente a tu equipo de Pokemones.");
                                                    sc.nextLine();
                                                    validarContinuar();
                                                    limpiarConsola();
                                                    break;
                                                case 3:
                                                    //Aqui va entrenar pokemon
                                                    if (Entrenadores.get(seleccionEntrenador-1).getListaDePokemones().size()== 0){
                                                        System.out.println("Aun no has agregado Pokemones a tu equipo");
                                                    }
                                                    else{
                                                        entrenarPokemon(Entrenadores.get(seleccionEntrenador-1));
                                                        
                                                    }
                                                    sc.nextLine();
                                                    validarContinuar();
                                                    limpiarConsola();
                                                    break;
                                                case 4:
                                                    break doWhileOpcionAccionesDeEntrenador; //Aqui se rompe el ciclo externo

                                                default:
                                                    System.out.println("Opcion invalida");
                                            }

                                        }while(opcionAccionesDeEntrenador!=4);
                                    }
                                }
                                
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                validarContinuar();
                        }
                    } while (opcionSubmenu1!=4);
                    
                    break;
                case 2:
                    int opcionSubmenu2;
                    do {
                        System.out.println("GESTIONAR POKEMONES\n--------------------------------\n1.Ver todos los Pokemones registrados\n2.Registrar nuevo Pokemon\n3.Volver al menu principal");
                        opcionSubmenu2 = sc.nextInt();
                        limpiarConsola();
                        switch (opcionSubmenu2) {
                            case 1:
                                //Aqui va ver todos los Pokemones
                                System.out.println("Todos los Pokemones registrados son:\n");
                                mostrarTodosPokemones();
                                sc.nextLine();
                                validarContinuar();
                                limpiarConsola();
                                break;
                            case 2:
                                System.out.println("Aqui va Registrar un nuevo pokemon");
                                validarContinuar();
                                limpiarConsola();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                validarContinuar();
                                limpiarConsola();
                        }
                    } while (opcionSubmenu2!=3);
                    break;
                case 3:
                    int opcionSubmenu3;
                    do {
                        System.out.println("INICIAR BATALLA\n--------------------------------\n1.Elegir entrenador 1\n2.Elegir entrenador 2\n3.Seleccionar Pokemon de entrenador 1\n4.Seleccionar Pokemon entrenador 2\n5.Comenzar batalla\n6.Volver al menu principal");
                        opcionSubmenu3 = sc.nextInt();
                        limpiarConsola();
                        switch (opcionSubmenu3) {
                            case 1:
                                if (Entrenadores.size()>0){
                                    System.out.println("Escoge el primer entrenador que participara en la batalla:");
                                    mostrarEntrenadores();
                                    entrenador1 = Entrenadores.get(sc.nextInt()-1);
                                }
                                else{
                                    System.out.println("Aun no se ha registrado ningun entrenador");
                                }
                                sc.nextLine();
                                validarContinuar();
                                break;
                            case 2:     
                                if (Entrenadores.size()>0){
                                    System.out.println("Escoge el segundo entrenador que participara en la batalla:");
                                    mostrarEntrenadores();
                                    entrenador2 = Entrenadores.get(sc.nextInt()-1);
                                }
                                else{
                                    System.out.println("Aun no se ha registrado ningun entrenador");
                                }
                                sc.nextLine();
                                validarContinuar();
                                break;
                            case 3:
                                if(entrenador1 != null){
                                     System.out.println("Selecciona un pokemon del entrenador " + entrenador1.getNombre() + " para luchar:");
                                    if (entrenador1.getListaDePokemones().size()>0){
                                        mostrarEquipoPokemon(entrenador1);
                                        pokemon1 = entrenador1.getListaDePokemones().get(sc.nextInt()-1);
                                        sc.nextLine();
                                    }
                                    else{
                                        System.out.println("Este entrenador no ha agregado pokemones a su equipo");
                                    }
                                }
                                else{
                                    System.out.println("No se ha seleccionado un primer entrenador para participar en la batalla");
                                }
                                validarContinuar();
                                sc.nextLine();
                                break;
                            case 4:
                                if(entrenador2 != null){
                                     if (entrenador2.getListaDePokemones().size()>0){
                                        System.out.println("Selecciona un pokemon del entrenador " + entrenador2.getNombre() + " para luchar: ");
                                        sc.nextLine();
                                        mostrarEquipoPokemon(entrenador2);
                                        pokemon2 = entrenador2.getListaDePokemones().get(sc.nextInt()-1);
                                    }
                                    else{
                                        System.out.println("Este entrenador no ha agregado pokemones a su equipo");
                                    }
                                }
                                else{
                                    System.out.println("No se ha seleccionado un primer entrenador para participar en la batalla");
                                }
                                validarContinuar();
                                sc.nextLine();
                                break;
                            case 5:
                                if (entrenador1 == null){
                                    System.out.println("No se ha seleccionado el primer entrenador para participar en la batalla");
                                }
                                else if (entrenador2 == null){
                                    System.out.println("No se ha seleccionado el segundo entrenador para participar en la batalla");
                                }
                                else{
                                    if(pokemon1 == null){
                                        System.out.println("No se ha elegido el Pokemon del entrenador " + entrenador1.getNombre() + "que peleará en la batalla.");
                                    }
                                    else if (pokemon2 == null){
                                        System.out.println("No se ha elegido el Pokemon del entrenador " + entrenador2.getNombre() + "que peleará en la batalla.");

                                    }
                                    else{
                                        System.out.println(ejecutarBatalla(pokemon1, pokemon2));
                                        System.out.println(pokemon1.getNombre() +" Este es el 1 " +  pokemon2.getNombre() + " Este es el segundo");
                                        System.out.println("Gano el pokemon " + ejecutarBatalla(pokemon1, pokemon2));
                                    }
                                }
                                validarContinuar();
                                sc.nextLine();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                validarContinuar();
                        }
                    } while (opcionSubmenu3!=6);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion ivalida");
                    sc.nextLine();
                    validarContinuar();
                    limpiarConsola();
            }
        }while(opcionMenuPrincipal != 4);
    }
    public static void limpiarConsola(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
    public static void validarContinuar(){
        System.out.println("\nPara continuar al menu oprima ENTER->");
        sc.nextLine();
   
    }
    
    
    //--------------- METODOS DE ENTRENADOR ---------------\\
    public static void registrarNuevoEntrenador(){
        System.out.println("Ingrese el nombre del entrenador: ");
        String nombre = sc.next();
        boolean existeEntrenador = false;
        for (Entrenador e: Entrenadores){
            if(e.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                existeEntrenador = true;
            }
            else{
                continue;
            }
        }
        if(existeEntrenador == true){
            System.out.println("Este entrenador ya esta registrado");
        }
        else{
            Entrenador entrenador = new Entrenador(nombre);
            Entrenadores.add(entrenador);
            System.out.println("Entrenador registrado con exito!");
        }
        //Validar si ya existe el entrenador
    }
    public static void mostrarEntrenadores(){
        int contador = 0;
        for (Entrenador e: Entrenadores) {
            contador++;
            System.out.println(contador + ". "+ e.getNombre());
        }
    }
    public static void mostrarEquipoPokemon(Entrenador entrenador){
        int contador = 0;
        for (Pokemon pok: entrenador.getListaDePokemones()){
            contador++;
            System.out.println(contador + ". " + pok.getNombre());
        }
    }
    public static void entrenarPokemon(Entrenador entrenador){
        System.out.println("Escoge el Pokemon que quieres entrenar: ");
        mostrarEquipoPokemon(entrenador);
        int pokAEntrenar = sc.nextInt();
        if (pokAEntrenar > 0 && pokAEntrenar <=  entrenador.getListaDePokemones().size()){
            Pokemon pokEntrenado = entrenador.getListaDePokemones().get(pokAEntrenar-1);
            entrenador.entrenarPokemones(pokEntrenado);
            System.out.println("+10HP\n+5 AttackPoints ");
            System.out.println(pokEntrenado.getNombre() + " ha sido entrenado satisfactoriamente");
        }
        else{
            System.out.println("Opcion invalida");
        }
    }
    
        //--------------- METODOS DE POKEMON ---------------\\
    public static void crearPokemones(){
        Pokemon seel = new Seel();
        Pokemon sandshrew = new Sandshrew();
        Pokemon Tangela = new Tangela();
        Pokemon Tentacool = new Tentacool();
        Pokemon Aerodactyl = new Aerodactyl();
        Pokemon Mime = new Mime();
        Pokemon Magmar = new Magmar();
        Pokemon Jynx = new Jynx();
        Pokemon Gastly = new Gastly();
        Pokemon Electabuzz = new Electabuzz();
        
        
        Pokemones.add(seel);
        Pokemones.add(sandshrew);
        Pokemones.add(Tangela);
        Pokemones.add(Tentacool);
        Pokemones.add(Aerodactyl);
        Pokemones.add(Mime);
        Pokemones.add(Magmar);
        Pokemones.add(Jynx);
        Pokemones.add(Gastly);
        Pokemones.add(Electabuzz);
        
    }
    public static void mostrarTodosPokemones(){
        int contador = 0;
        for (Pokemon pok: Pokemones){
            contador ++;
            System.out.println(contador + ". " + pok.getNombre() + ":\nSalud: " + pok.getSalud() + " HP\nAtaque: " + pok.getPuntosDeAtaque() + " Points\nTipo: " + pok.getTipo() + "\n\n");        }
    }
    public static void registrarNuevoPokemon(String nombre){
       
    } 
        //--------------- METODOS DE BATALLA ---------------\\
    public static String ejecutarBatalla(Pokemon pokemon1, Pokemon pokemon2){
        Batalla nuevaBatalla = new Batalla();
        Pokemon ganador = nuevaBatalla.inciarBatalla(pokemon1, pokemon2);
        return ganador.getNombre();
    }
    

}
