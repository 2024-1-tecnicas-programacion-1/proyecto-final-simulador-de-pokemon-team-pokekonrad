package simulador;
import java.util.*;


public class Principal {
    
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {

        mostrarMenu();
    }
    // -------- METODOS DE MENÚ -----------------
    public static void mostrarMenu(){
        
        int opcionMenuPrincipal;
        do{
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
                                System.out.println("Aqui va el registro de un nuevo entrenador");
                                validarContinuar();
                                break;
                            case 2:
                                System.out.println("Aqui va mostrar la lista de todos los entrenadores");
                                validarContinuar();
                                break;
                            case 3:
                                System.out.println("Aqui va seleccionar un entrenador");
                                validarContinuar();
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
                                System.out.println("Aqui va ver todos los Pokemones");
                                validarContinuar();
                                break;
                            case 2:
                                System.out.println("Aqui va Registrar un nuevo pokemon");
                                validarContinuar();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opcion invalida");
                                validarContinuar();
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
                                System.out.println("Aqui va Elegir entrenador 1");
                                validarContinuar();
                                break;
                            case 2:
                                System.out.println("Aqui va Elegir entrenador 2");
                                validarContinuar();
                                break;
                            case 3:
                                System.out.println("Aqui va Seleccionar pokemon entrenador 1");
                                validarContinuar();
                                break;
                            case 4:
                                System.out.println("Aqui va Seleccionar pokemon entrenador 2");
                                validarContinuar();
                                break;
                            case 5:
                                System.out.println("Aqui va Comenzar batalla");
                                validarContinuar();
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
        sc.nextLine();
    }
    // -------- METODOS DE ENTRENADOR -----------------
    public static void registrarNuevoEntrenador(){
    
    }
}
