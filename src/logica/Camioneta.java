package logica;


/**
 * Write a description of class Camioneta here.
 * 
 * @author Santiago Montoya Angarita
 * @version 08/05/2013
 */
public class Camioneta extends Vehiculo
{
    //Atributos
    //Contructor
    Camioneta(String placa, Hora ent, Hora ret, int numero, Cliente user){
        this.placa = placa;
        this.entrada= ent;
        this.retirada= ret;
        this.cobro= 2500.0;
        this.numero = numero;
        this.user = user;
    }
    //Metodos
}
