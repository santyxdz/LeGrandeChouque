package logica;

import java.util.*;
/**
 * Write a description of class ColaVehiculos here.
 * 
 * @author Santiago Montoya Angarita
 * @version 08/05/2013
 */
public class Cola
{
   //Atributos
   private ArrayList<Vehiculo> celdas;
   //Contructor
   public Cola(){
       this.celdas= new ArrayList<Vehiculo>(24);
   }
   //Metodos
   public void addVehiculo(Vehiculo temp){
        this.celdas.add(temp);
        ordenar();
    }
   public void ordenar(){
       Vehiculo temp1;
       Vehiculo temp2;
       for(int i=1;i<celdas.size();i++){
           for(int j=0;j<celdas.size()-1;j++){
               //el metodo .compararHora devuelve true si es >, pero se ordena de < a > por ello la !negacion
               if(!celdas.get(j).getHoraRetirada().compararHora(celdas.get(j+1).getHoraRetirada())){
                   temp1= celdas.get(j);
                   temp2= celdas.get(j+1);
                   celdas.set(j, temp2);
                   celdas.set(j+1, temp1);
               }
           }
       }
   }
   //Si retorna 24 es por que no se encuentra en la cola.
   public int buscar(String placa){
    ordenar();
    for(int i=0;i<celdas.size();i++){
        if(celdas.get(i).getPlaca().equals(placa)){
         return i;
        }
    }
    return 24;
   }
   public int buscar(int registro){
    ordenar();
    for(int i=0;i<celdas.size();i++){
        if(celdas.get(i).getNumero()==registro){
            return i;
        }
    }
    return 24;
   }
   public boolean retirar(int position){
    celdas.remove(position);
    ordenar();
    return true;
   }
   public int tamano(){
    return celdas.size();
   }
   public Vehiculo getVehiculo(int position){
    return celdas.get(position);
   }
   public void desalojo(){
    celdas.clear();
   }
}
