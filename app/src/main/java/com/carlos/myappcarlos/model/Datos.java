package com.carlos.myappcarlos.model;

public class Datos {

    private String nombre;

    private String apodo;

    private int edad;

    private String colegio;

    private String genero;

    public Datos(String nombre, String apodo, int edad, String colegio, String genero){
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.colegio = colegio;
        this.genero = genero;
    }

    //METODOS SET PARA DARLE VALOR A LAS VARIABLES

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApodo(String apodo){
        this.apodo = apodo;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setColegio(String colegio){
        this.colegio = colegio;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }
    //Metodos get para darle valor a las variables

    public String getNombre(){
        return nombre;
    }

    public String getApodo(){
        return apodo;
    }

    public int getEdad(){
        return edad;
    }

    public String getColegio(){
        return colegio;
    }

    public String getGenero(){
        return genero;
    }
}
