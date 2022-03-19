package com.utn;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicioPOO();



    }

    /** EJERCICIO 1: Pide un número por teclado e indica si es un número primo o no. */
    public static void ejercicio1(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        int entrada = reader.nextInt();
        boolean resultado = false;
        if (entrada == 0 || entrada == 1 || entrada == 4){ //Estos tres numeros no son primos.
            resultado = true;
        }
        for (int i = 2; i < entrada/2; i++) {
            if (entrada % i == 0) {
                resultado = true; //Si es posible dividir el numero ingresado por cualquier numero entero desde el 2 hasta
                                  //el numero resultado de la mitad del mismo, entonces no es primo.
            }
        }
        if (resultado) {
            System.out.println("EL NUMERO INGRESADO, NO ES UN NUMERO PRIMO.");
        }else{
            System.out.println("EL NUMERO INGRESADO, ES UN NUMERO PRIMO.");
        }
    }

    /** EJERCICIO 2: Escribe una aplicación que solicite al usuario que ingrese una contraseña cualquiera. Después se le
        pedirá que ingrese nuevamente la contraseña, con 3 intentos. Cuando acierte ya no pedirá más la contraseña y
        mostrará un mensaje diciendo “Felicitaciones, recordá tu contraseña”. Si falla luego de 3 intentos se mostrará
        el mensaje “Tenes que ejercitar la memoria”. Los mensajes quedarán en pantalla a la espera que el usuario
        presione una tecla, luego de esto se cerrará el programa. */
    public static void ejercicio2(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese su nueva contraseña: ");
        String newPassword = reader.nextLine(); ///Guarda una cadena incluyendo espacios
        int intento = 0;
        String esc = null;
        boolean resultado = true;
        do {
            do {
                System.out.println("Ingrese contraseña: ");
                String password = reader.nextLine(); ///Guarda una cadena incluyendo espacios
                if (newPassword.equals(password)) {
                    System.out.println("Felicitaciones, recorda tu contraseña");
                    resultado = false;
                } else {
                    intento++;
                }
            } while (resultado && intento < 3); //Mientras no se ingrese la contraseña corretamente y no se superen lo 3
                                                //intentos, se solicita el ingreso nuevamente de la contraseña.
            if (resultado) {
                System.out.println("Tenes que ejercitar la memoria");
            }
            System.out.println("PRESIONE UNA TECLA PARA SALIR");
            esc = reader.next();
        }while (esc == null);
    }

    /** EJERCICIO 3: Por teclado se ingresa el valor hora de un empleado. Posteriormente se ingresa el nombre del empleado,
        la antigüedad y la cantidad de horas trabajadas en el mes. Se pide calcular el importe a cobrar teniendo en cuenta
        que al total que resulta de multiplicar el valor hora por la cantidad de horas trabajadas. Además, si el empleado
        tiene más de 10 años de antigüedad hay que sumarle la cantidad de años trabajados multiplicados por $30.
        Imprimir en pantalla el nombre, la antigüedad y el total a cobrar.*/
    public static void ejercicio3(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el valor hora del empleado: ");
        double valorHora = reader.nextDouble(); //Guarda el valor decimal.
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = reader.next();
        System.out.println("Ingrese antiguedad: ");
        int antiguedad = reader.nextInt();
        System.out.println("Ingrese cantidad de horas trabajadas en el mes: ");
        int cantidadHoras = reader.nextInt();
        int montoPorAntiguedad = 0;
        if (antiguedad > 10) {
            montoPorAntiguedad = antiguedad * 30;
        }
        double montoPorHorasDelMes = valorHora * cantidadHoras;
        double montoTotal = montoPorHorasDelMes + montoPorAntiguedad;
        String formato = "NOMBRE: %s \nANTIGUEDAD: %d años \nTOTAL A COBRAR: $%.2f";
        System.out.println(String.format(formato, nombre, antiguedad, montoTotal));
    }


    /** EJERCICIO 4:Generar un número aleatorio comprendido entre 0 y 1000. Pedir, a continuación, al usuario adivinar el
        número escogido por el ordenador. Para ello, debe introducir un número comprendido entre 0 y 1000. Se compara el
        número introducido con el calculado por el ordenador y se muestra en la consola "es mayor" o "es menor" en función
        del caso. Se repite la operación hasta que el usuario encuentra el número.*/
    public static void ejercicio4() {
        Scanner reader = new Scanner(System.in);
        int numeroAleatorio = (int) (Math.random() * 1000);
        System.out.println(numeroAleatorio);
        boolean respuesta = true;
        do {
            System.out.println("Adivine el numero que salio, ingrese un numero entre el 0 y el 1000: ");
            int numero = reader.nextInt();
            if (numero > numeroAleatorio){
                System.out.println("ES MENOR"); //hago referencia a que el numero aleatorio es menor que el que dice el usuario
            }else if (numero < numeroAleatorio) {
                System.out.println("ES MAYOR"); //hago referencia a que el numero aleatorio es mayor que el que dice el usuario
            }else{
                System.out.println("FELICITACIONES!!! ADIVINO!!!");
                respuesta = false;
            }
        }while(respuesta);
    }

    /** EJERCICIO 5: Pedir al usuario que ingrese un número repetidamente hasta que ingrese un -1 y en ese caso se
        terminará el programa. Al terminar, mostrará lo siguiente:
        a. – mayor número introducido
        b. – menor número introducido
        c. – suma de todos los números
        d. – suma de los números */

    public static void ejercicio5() {
        Scanner reader = new Scanner(System.in);
        int numero = 0;
        int suma = 0;
        int mayor = 0;
        int menor = 1000000;
        int sumaPares = 0;
        do {
            System.out.println("Ingrese un numero entero: ");
            numero = reader.nextInt();
            if (numero != -1){
                suma += numero;
                if (numero > mayor){
                    mayor = numero;
                }
                if (numero < menor){
                    menor = numero;
                }
                if (numero % 2 == 0){
                    sumaPares += numero;
                }
            }
        }while(numero != -1);

        String formato = "MAYOR NUMERO INGRESADO: %d \nMENOR NUMERO INGRESADO: %d \nSUMA TOTAL = %d \nSUMA TOTAL DE NUMEROS PARES = %d";
        System.out.println(String.format(formato, mayor, menor, suma, sumaPares));
    }

    /** EJERCICIO POO: Crear un proyecto de consola que solicite al usuario una contraseña por teclado y muestre un mensaje
        indicando la contraseña y si es o no fuerte.*/
    public static void ejercicioPOO() {
        Scanner reader = new Scanner(System.in);
        Password password = new Password(); //instancio un objeto Password por defecto, porque le voy a pedir al usuario
                                            //que ingrese una contraseña.
        //Si quisiera generar una contraseña aleatorio, instancion un objeto Password pasando la longitud como parametro,
        //para hacer uso del constructor que llama al metodo generar_password
        int size = password.getLongitud();
        System.out.println("INGRESE UNA CONTRASENA DE " + size + " CARACTERES: ");
        String pass = reader.nextLine();
        password.setPassword(pass);
        System.out.println(password);
        if (password.esFuerte()){
            System.out.println("LA CONTRASENA ES FUERTES.");
        }else{
            System.out.println("LA CONTRASENA NO ES FUERTE.");
        }

    }

    /** EJERCICIO BASE DE DATOS: No lo pude resolver en codigo. Es la materia que me falta para recibirme y la estoy
        preparando.Pude realizar el modelo entidad-relacion y pasarlo a tablas pero no lo pude volcar al codigo aun.
        Hice el modelo de clases, generando una clase padre PERSONA, luego una clase EMPLEADO que hereda atributos de
        persona y cree una clase ENUM llamada MUNICIPALIDAD donde apareceria toda la lista de municipios existentes (solo
        puse algunos para el caso) */

}
