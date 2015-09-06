package logica;

import java.util.*;
/**
 * Write a description of class Sotano here.
 * 
 * @author Santiago Montoya Angarita
 * @version 08/05/2013
 */
public class Sotano 
{
    //Atributos
    private ArrayList<Vehiculo> sotano;
    //Contructor
    public Sotano(){
        this.sotano = new ArrayList<Vehiculo>(100);
    }
    //Metodos
    public void addVehiculo(Vehiculo temp){
        this.sotano.add(temp);
    }
    public ArrayList getArray(){
        return this.sotano;
    }
    public boolean retirar(String placa){
        for(int i=0;i<sotano.size();i++){
            if(sotano.get(i).getPlaca().equals(placa)){
                sotano.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean retirar(int nRegistro){
        for(int i=0;i<sotano.size();i++){
            if(sotano.get(i).getNumero()==nRegistro){
                sotano.remove(i);
                return true;
            }
        }
        return false;
    }
    public void desalojo(){
        sotano.clear();
    }
    public int tamano(){
        return sotano.size();
    }
    public Vehiculo getVehiculo(int position){
        return sotano.get(position);
    }
    public int buscar(String placa){
        for(int i=0;i<sotano.size();i++){
        if(sotano.get(i).getPlaca().equals(placa)){
         return i;
        }
     }
     return 100;
   }
   public int buscar(int registro){
    for(int i=0;i<sotano.size();i++){
        if(sotano.get(i).getNumero()==registro){
            return i;
        }
    }
    return 100;
   }
}
