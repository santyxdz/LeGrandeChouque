package logica;


/**
 * Write a description of class Deudor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente
{
    // instance variables - replace the example below with your own
    private int id;
    private double deuda;
    public Cliente(int id)
    {
        this.deuda=0;
        this.id=id;
    }
    public int getID(){
        return id;
    }
    public void setDeuda(double deuda){
        this.deuda = this.deuda + deuda;
    }
    public void setNDeuda(double deuda){
        this.deuda = deuda;
    }
    public double getDeuda(){
        return deuda;
    }
}
