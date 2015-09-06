package logica;


/**
 * Write a description of class Automovil here.
 * 
 * @author Santiago Montoya Angarita
 * @version 08/05/2013
 */
public class Automovil extends Vehiculo
{
    //Atributos
    //Contructor
    Automovil(String placa, Hora ent, Hora ret, int numero, Cliente user){
        this.placa = placa;
        this.entrada= ent;
        this.retirada= ret;
        this.cobro= 2000.0;
        this.numero = numero;
        this.user = user;
    }
    //Metodos
}
