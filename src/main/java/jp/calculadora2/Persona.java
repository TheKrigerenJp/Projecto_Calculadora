package jp.calculadora2;

/**
 * Objeto Persona
 * Objeto con atributos como nombre, provincias y edad
 * author Jose Pablo Guerrero
 * version 1.0 2023/03/08
 */
public class Persona {
    //Atributos de la persona,  en este caso nombre, provincia y edad
    /**
     * Atributos del objeto Persona
     * Creamos los atributos que necesitaremos identificar de parte de los usuarios
     * Valores validos: Strings para provincia y nombre e int para edad
     *
     */
    private String nombre;
    private  String provincia;
    private int edad;
    //Metodos como gets y sets de nombre, provinvia y edad
    public String getNombre(){
        return nombre;
    }
    public String getProvincia(){
        return provincia;
    }
    public int getEdad(){
        return edad;
    }
    public void setNombre(String n){
        nombre = n;

    }
    public void setProvincia(String p){
        provincia = p;
    }
    public void setEdad(int e){
        edad = e;
    }

}


