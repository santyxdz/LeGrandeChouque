package logica;


/**
 * Abstract class Vehiculo - write a description of the class here
 * 
 * @author Santiago Montoya Angarita
 * @version 08/05/2013
 */
public abstract class Vehiculo
{
    protected String placa;
    protected Hora entrada;
    protected Hora retirada;
    protected double cobro;
    protected int numero;
    protected Cliente user;
    public String getPlaca(){
        return this.placa;
    }

    public int getHoraEnt(){
        return this.entrada.getHora();
    }
    public int getMinEnt(){
        return this.entrada.getMin();
    }
    public Hora getHoraRetirada(){
        return this.retirada;
    }
    public Hora getHoraEntrada(){
        return this.entrada;
    }
    public int getNumero(){
        return this.numero;
    }
    public Cliente getCliente(){
        return this.user;
    }
    public double getPrecio(){
        return cobro;
    }
}