package logica;


/**
 * Write a description of class Hora here.
 * 
 * @author Santiago Montoya Angarita
 * @version 08/05/2013
 */
public class Hora
{
    //Atributos
    private int hora;
    private int minutos;
    //Constructor
    public Hora(int h, int m){
        this.hora= h%24;
        this.minutos=m%60;
    }
    //Metodos
    public int getHora(){
       return this.hora;
    }
    public int getMin(){
       return this.minutos;
    }
    public void setHoras(Hora hora){
        this.hora=hora.getHora();
        this.minutos=hora.getMin();
    }
    public boolean compararHora(Hora hora){
        int h= hora.getHora();
        int m= hora.getMin();
        boolean ret;
        if(h%24>this.hora){
            ret= true;
        }
        else if(h%24<this.hora){
            ret= false;
        }
        else{
            if(m%60>this.minutos){
                ret= true;
            }
            else if(m%60<this.minutos){
                ret= false;
            }
            else{
                ret= false;
            }
        }
        return ret;
    }
    public static double compararHora(Hora uno, Hora dos){
        //Valor Retorno
        double total = 0.0;
        //Valor Aprox. de Un minuto en Horas;
        double unMin= 1.0/60.0;
        //Valores de Hora en temerminos de horas.
        double horaUno=uno.getHora()+(uno.getMin()*unMin);
        double horaDos=dos.getHora()+(dos.getMin()*unMin);
        //total
        total= horaDos-horaUno;
        return total;
    }
}
