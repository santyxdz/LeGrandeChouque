package logica;


/**
 * Write a description of class Reloj here.
 * 
 * @author Santiago Montoya Angarita
 * @version 08/05/2013
 */
public class Reloj
{
    //Atributos
    private Hora hora;
    private Hora desalojo;
    //Constructor
    public Reloj(){
        hora = new Hora(0,0);
        desalojo = new Hora(23,59);
    }
    public Reloj(int m, int n){
        hora = new Hora(m,n);
        desalojo = new Hora(23,59);
    }
    //Metodos
    public Hora getHoraActual(){
        return this.hora;
    }
    public Hora getHoraDes(){
        return this.desalojo;
    }
    public boolean adelantar(int horas, int minutos){
        int resHor=horas+hora.getHora();
        int resMin=minutos+hora.getMin();
        //Comprobar que hora no exada las 24Horas
        if(resHor<24){
            //Adelanto en minutos si dan menor que 60
            if(resMin<60){
                Hora temp;
                temp= new Hora(resHor, resMin);
                hora=temp;
            }
            //Adelanto en minutos si dan mas que 60
            else{
                //Horas sacadas de los minutos>60 (Casi siempre 1)
                int HresMin= resMin/60;
                //Minutos Sacados de los minutos>60
                int MresMin= resMin%60;
                if(resHor+HresMin<24){
                 Hora temp;
                 temp= new Hora(resHor+HresMin,MresMin);
                 hora=temp;
                }
                else{
                return false;
                }
            }
            return true;
        }
        return false;
    }
    public void reiniciar(){
    hora=new Hora(0,0);
    }
}
