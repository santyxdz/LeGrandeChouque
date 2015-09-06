package logica;


/**
 * Write a description of class Campero here.
 * 
 * @author Santiago Montoya Angarita
 * @version 08/05/2013
 */
public class Campero extends Vehiculo
{
    //Atributos
    //Contructor
    Campero(String placa, Hora ent, Hora ret, int numero, Cliente user){
        this.placa = placa;
        this.entrada= ent;
        this.retirada= ret;
        this.cobro= 3000.0;
        this.numero = numero;
        this.user = user;
    }
    //Metodos
}
