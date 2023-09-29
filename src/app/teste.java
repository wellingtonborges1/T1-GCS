package app;

import modelo.Empresa;

public class teste {
    public static void main(String[]args){
        Empresa emp= new Empresa();
        Sistema a= new Sistema(emp);

        a.executa();
    }
}
