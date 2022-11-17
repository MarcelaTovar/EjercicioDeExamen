
package ejericiosdetutoriasparapuntos;

import java.util.*;

public class EjericiosDeTutoriasParaPuntos {

    public static void main(String[] args) {
       Menu();
    }
    
    public static void Menu(){
        int opcion = 0;
        Scanner ObiWan = new Scanner (System.in);
        System.out.println("¡Hola Stephanie!");
        System.out.println("Aquí está uno de los programas que no logré hacer en el examen");
        System.out.println("¡Gracias Steph!");
        System.out.println("Ahora si, empezemos");
        System.out.println("----------------------------------------------------");
        System.out.println("¡Hola! Porfavor dime \n¿Como me llamó?: ");
        String miNombre = ObiWan.nextLine();
        System.out.println("¡Me presentó! Yo soy "+miNombre);
        System.out.println("¿Como te gustaría que te llamrá?: ");
        String tuNombre = ObiWan.nextLine();
        System.out.println("Es un gusto "+tuNombre);
        System.out.println("Empecemos con el menú");
        System.out.println("-----------------------------------------------------");
        
        do{
            System.out.println("--Menu--");
            System.out.println("1. Conjuntos");
            System.out.println("2. Salir");
            System.out.println("Porfavor "+tuNombre +" ¿Qué desearías hacer?");
            opcion = ObiWan.nextInt();
            //Validacion de los numeros
            while(opcion !=1 || opcion !=2){
                break;
            }
            switch(opcion){
                case 1 -> Conjuntos(); //Iba a hacer el sobre pero no me salió :(
            }
        }while(opcion == 1 || opcion != 2);
        System.out.println("¡Gracias Stephanie! <3");
    }
    
    public static void Conjuntos(){
        Scanner ObiWan = new Scanner (System.in);
        System.out.println("¡Hello! Este programa te ayudará a saber las uniones e intersecciones de un conjunto.");
        System.out.println("Porfavor ingresa el primer conjunto: ");
        String conjunto1 = ObiWan.nextLine();
        System.out.println("Porfavor ingresa el segundo conjunto: ");
        String conjunto2 = ObiWan.nextLine();
        boolean val = validacion(conjunto1,conjunto2);
        //Decidí hacerlo todo por partes como me dijiste y fue más fácil :D
        if(val){
            String acumulador1 = ObtenerConjuntos(conjunto1);
            String acumulador2 = ObtenerConjuntos(conjunto2);
            boolean revisar = Igualdad(acumulador1, acumulador2);
            if(revisar){
                System.out.println("Los conjuntos son iguales \nNo hay nada que se pueda hacer aquí :D");
            }else{
                System.out.println("Los conjuntos no son iguales");
                String intersect = Interseccion(acumulador1,acumulador2);
                String un = Union(acumulador1,acumulador2);
                System.out.println("Este es la union de los conjuntos: "+un);
                //Validacion de el intersecto
                if(intersect.equals("D = {}")){
                    System.out.println("Este es la interseccion de los conjuntos: D = {0}");
                }else{
                System.out.println("Este es la intersección de los conjuntos: "+intersect);
                }
            }
        }else{
            System.out.println("Porfavor ingresalo en el formato correcto");
            
        }
    }
    
    public static boolean validacion(String conjunto1, String conjunto2){
        String cadena1=conjunto1.replace(" ", "");//Si hubieran espacios el contador los toma como iguales
        String cadena2=conjunto2.replace(" ","");
            if(cadena1.charAt(0) != 'A' || cadena1.charAt(1) != '=' || cadena1.charAt(2) != '{' || cadena1.charAt(cadena1.length()-1) != '}'){
                return false;
            }
        //El patron es el mismo por eso funciona, si fuera distinto ya no
           if(cadena2.charAt(0) != 'B' || cadena2.charAt(1) != '=' || cadena2.charAt(2) != '{' || cadena2.charAt(cadena2.length()-1) != '}'){
                return false;
            }
      return true;
    }
    public static String ObtenerConjuntos (String conjunto){
        String acumuladorLetras = "";
        boolean checking = false;
        //Aqui se sacan los conjuntos de los brackets para que no estorben
            for (int i = 0; i < conjunto.length(); i++) {
                //Si es verdad, entonces checking se vuelve true porque quiere decir que ya no hay brackets
                if(conjunto.charAt(i)=='{'){
                    checking = true;
                }
                if(checking){
                    //Si checking es true y no es ninguno de los otros caracteres se guarda en un acumulador
                    if(conjunto.charAt(i) != ',' && conjunto.charAt(i) != '}' && conjunto.charAt(i) != '{'){
                        acumuladorLetras += conjunto.charAt(i);
                    }
                }
        }
            return acumuladorLetras;
    }
    public static boolean Igualdad(String acumulador1, String acumulador2){
        boolean checking = false;
        /*Para checkear si son iguales utilice la tabla ASCII para ordenarlos.
        Asi es más fácil revisar si son iguales*/
        String arreglos1 = acumulador1.toLowerCase();
        String arreglos2 = acumulador2.toLowerCase();
        char cadena_nueva = 0;
        char cadena_nueva2 = 0;
        for (int i = 97; i < 122; i++) {
            for (int j = 0; j < arreglos1.length(); j++) {
                if (i == (int)arreglos1.charAt(j)){
                    cadena_nueva += arreglos1.charAt(j);
                }
            }
        }
        for (int i = 97; i < 122; i++) {
            for (int j = 0; j < arreglos2.length(); j++) {
                if (i == (int)arreglos2.charAt(j)){
                    cadena_nueva2 += arreglos2.charAt(j);
                }
            }
        }
        
        if((int) cadena_nueva == (int) cadena_nueva2){
            checking = true;
        }else{
            checking = false;
        }
        return checking;
    }
    public static String Interseccion(String acumulador1, String acumulador2){
        String acumuladorLetras = "D = {";
        String acumulador1_1 = acumulador1.replace(" ", "");
        String acumulador2_2 = acumulador2.replace(" ", "");
        /*Empecé recorriendo la cadena así como me enseñaste, un for para una y otro for para la otra
        y guardandola en acumuladores.*/
        if(acumulador1_1.length()<acumulador2_2.length()){
            for (int i = 0; i < acumulador1_1.length(); i++) {
                for (int j = 0; j < acumulador2_2.length(); j++) {
                    if(acumulador1_1.charAt(i) == acumulador2_2.charAt(j)){
                        acumuladorLetras += acumulador1_1.charAt(i)+",";
                        
                    }
                }
            }
        }else{
            for (int i = 0; i < acumulador2_2.length(); i++) {
                for (int j = 0; j < acumulador1_1.length(); j++) {
                    if(acumulador2_2.charAt(i) == acumulador1_1.charAt(j)){
                        acumuladorLetras += acumulador2_2.charAt(i)+",";
                        
                    }
                }
            }
        }
        
       
        return acumuladorLetras+"}";
    }
    public static String Union(String acumulador1, String acumulador2){
        String acumulador1_1 = acumulador1.replace(" ", "");
        String acumulador2_2 = acumulador2.replace(" ", "");
        String acumuladorLetras = acumulador1_1;
        String end_str = "C = {";
        //Seguí la misma lógica que con la intersección, nada más al reves
        /*En este caso el acumulador empieza en uno de las cadenas para que solo tenga uqe revisar si son iguales en una*/
        for (int i = 0; i < acumulador1_1.length(); i++) {
            for (int j = 0; j < acumulador2_2.length(); j++) {
                if (! acumuladorLetras.contains(acumulador2_2.charAt(j)+"") && acumulador1_1.charAt(i) != acumulador2_2.charAt(j)) {
                    acumuladorLetras += acumulador2_2.charAt(j);
                   
                }
            }
        }/*Empezar el contador donde lo hice y eliminando los espacios me dificultó imprimirlo, pero
        lo que hice fue guardar letra por letra en una nueva cadena*/
        for (int i = 0; i < acumuladorLetras.length(); i++) {
            if (i == acumuladorLetras.length()-1) {
                end_str += acumuladorLetras.charAt(i);
            }else{
                end_str += acumuladorLetras.charAt(i)+",";
            }
        }
        

        return end_str +"}";
    }
    
    /*Aquí esta el sobre que intente empezar pero no me salió:
    public static void ImprimirSobre(int altura, char caracter){
    int tam = altura *2+1;
    for(int i = 0; i < tam; i++){
    for(int j = 0; j < tam; j++){
    if( i == 0){
    System.out.print(caracter);
    }
    else if( j == 0){
    System.out.print(caracter);
    }
    else if( j == tam.length()-1){
    System.out.print(caracter);
    }
    else if( i == tam.length()-1){
    System.out.print(caracter);
    }
    else if( j == i){
    System.out.print(caracter);
    }
    System.out.println("");
    
    }
    No está completo pero cuando lo corría ni el cuadro me salía
    Intente hacer lo que me enseñaste pero como no terminamos no se porque no me salió :(
    
    Gracias Stephanie!!*/
}
        
   