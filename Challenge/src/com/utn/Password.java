package com.utn;

public class Password {
    private int longitud;
    private String password;

    //Constructor por defecto
    public Password(){
        this.longitud = 8;
        setPassword(password);
    }

    //Constructor donde pasamos la longitud de la contraseña por parametro.
    public Password(int longitud) {
        setLongitud(longitud);
        this.generarPassword(longitud);
    }

    //Metodos Get y Set
    public int getLongitud() {
        return this.longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
       // generar_password(longitud);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void generarPassword(int longitud){
        String alphaNumerico = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder newPass = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            int index = (int)(alphaNumerico.length() * Math.random());
            newPass.append(alphaNumerico.charAt(index));
        }
        this.password = newPass.toString();
    }

    public boolean esFuerte(){
        int cant_min = 0;
        int cant_may = 0;
        int cant_num = 0;
        for (char ch: password.toCharArray()) {
            if (Character.isLowerCase(ch)){
                cant_min += 1;
            }
            else if(Character.isUpperCase(ch)){
                cant_may += 1;
            }
            else { cant_num += 1; }
        }
        if (cant_may > 2 && cant_min > 1 && cant_num > 3) { //cumpliendo estas condiciones, una contraseña ingresada por
            // el usuario, nunca podra ser fuerte, siendo que estaria usando el constructor por defecto, el cual tiene
            // una longitud de 8 caracteres, y para cumplir con las especificaciones de FUERTE, necesitaria un minimo de
            // 9 caracteres.
            return true;
        }
        else { return false; }
    }

    @Override
    public String toString() {
        String formato = "PASSWORD: \n* Longitud: %d \n* CONTRASENA: %s";
        return String.format(formato,getLongitud(),getPassword());
    }

}
