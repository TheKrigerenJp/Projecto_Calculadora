package jp.calculadora2;


public class Persona {
    //Atributos de la persona,  en este caso nombre, provincia y edad
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


