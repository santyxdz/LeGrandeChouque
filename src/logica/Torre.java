package logica;

import java.util.*;
/**
 * Write a description of class Torre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Torre
{
   //Atributos
   private String nombre;
   private static int NV=26;
   private static int ENT=10;
   private Cola torre[][];
   private Sotano sotano;
   private Reloj reloj;
   private int nLugaresT= 6340;
   private int nRecibo;
   private ArrayList<Cliente> clientes;
   private boolean aceptar = true;
   public Torre(){
       this.nombre = "Le Grande Chouque";
       this.torre= new Cola[NV][ENT];
       this.sotano= new Sotano();
       this.nRecibo=0;
       this.reloj= new Reloj();
       clientes = new ArrayList<Cliente>();
       init();
   }
   //Metodos
   private void init(){
    for(int i=0;i<this.NV;i++){
        for(int j=0;j<this.ENT;j++){
        torre[i][j]= new Cola();
       }
    }
   }
   public boolean adelantarReloj(int h, int m){
        if(reloj.adelantar(h,m)&&h>=0&&m>=0){
         return true;
        }
        else{
         return false;
        }
   }
   public boolean reiniciar(){
    boolean ret=false;
    if(this.aceptar==false){ 
       reloj.reiniciar();
       this.nRecibo=0;
       this.aceptar=true;
       ret=true;
    }
    return ret;
   }
    public int agregar(String placa, String tipo, int hRet, int mRet, int id){
     if(this.aceptar){}
     else{
        return 0;
     }
     //Saber Nivel y Entrada Segun Placa
     int nivel = (int)placa.charAt(0)-65; //Saber Nivel
     int entrada = (int)placa.charAt(placa.length()-1)-48; //Saber Entrada
     int retorno = 0; //0 = no ingresa, 1 = en torre, 2 = en sotano
     //Hora entrada
     Hora ent= reloj.getHoraActual();
     //Hora Retirada
     Hora ret= new Hora(hRet%24,mRet%60);
     //
     nRecibo = nRecibo +1; //Primera Cifra del Codigo & Automento de Lugar
     int nAnteAntePenUltimo=nivel/10;//Nv Digito 1
     int nAntePenUltimo=nivel%10;//Nv Digito 2
     int nPenUltimo=entrada/10; //Ent Digito 1
     int nUltimo=entrada%10; //Ent Digito 2
     int numero = Integer.parseInt(""+nRecibo+""+nAnteAntePenUltimo+""+nAntePenUltimo+""+nPenUltimo+""+nUltimo+"");
     //Buscar/Crear Cliente
     Cliente user;
     user= new Cliente(id);
     boolean encontrado = false;
     for(int i=0;i<clientes.size();i++){
      if(id==clientes.get(i).getID()){
        user = clientes.get(i);
        encontrado = true;
      }
     }
     if(encontrado == false){
        clientes.add(user);
     }
     //Ubicar Vehiculo en Torre ó Sotano
     if(torre[nivel][entrada].tamano()<24){
         //Creo Vehiculo
         Vehiculo temp;
         if(tipo.equalsIgnoreCase("Camioneta")){
             //Es una Camioneta
             temp= new Camioneta(placa,ent,ret,numero,user);
             torre[nivel][entrada].addVehiculo(temp);
             torre[nivel][entrada].ordenar();
             retorno = Integer.parseInt(numero+""+1);
         }
         else if(tipo.equalsIgnoreCase("Automovil")){
             //Es un Automovil
             temp= new Automovil(placa,ent,ret,numero,user);
             torre[nivel][entrada].addVehiculo(temp);
             torre[nivel][entrada].ordenar();
             retorno = Integer.parseInt(numero+""+1);;
         }
         else if(tipo.equalsIgnoreCase("Campero")){
             temp= new Campero(placa,ent,ret,numero,user);
             torre[nivel][entrada].addVehiculo(temp);
             torre[nivel][entrada].ordenar();
             retorno = Integer.parseInt(numero+""+1);;
         }
     }
     else if(sotano.getArray().size()<100){
         Vehiculo temp;
         if(tipo.equalsIgnoreCase("Camioneta")){
             temp= new Camioneta(placa,ent,ret,numero,user);
             sotano.addVehiculo(temp);
             retorno = Integer.parseInt(numero+""+2);;
         }
         else if(tipo.equalsIgnoreCase("Automovil")){
             temp= new Automovil(placa,ent,ret,numero,user);
             sotano.addVehiculo(temp);
             retorno = Integer.parseInt(numero+""+2);;
         }
         else if(tipo.equals("Campero")){
             temp= new Campero(placa,ent,ret,numero,user);
             sotano.addVehiculo(temp);
             retorno = Integer.parseInt(numero+""+2);;
         }
     }
     else{
         nRecibo = nRecibo-1;
         /*clientes.remove(user);*/
         for(int i=0;i<clientes.size();i++){
          if(clientes.get(i).getID()==id){
              clientes.remove(i);
          }
         }
         retorno = 0;
     }
     return retorno;
   }
   public boolean retirar(String placa){
     boolean ret=false;
     int nivel = (int)placa.charAt(0)-65; //Saber Nivel
     int entrada = (int)placa.charAt(placa.length()-1)-48; //Saber Entrada
     //Buscar en Torre
     int busqueda = torre[nivel][entrada].buscar(placa);
     //Retirar
     if(busqueda>=0&&busqueda<24){
        ret=torre[nivel][entrada].retirar(busqueda);
     }
     //Si es 24 esta en el Sotano, Retirar del sotano
     else if(busqueda==24){
        ret=sotano.retirar(placa);
     }
     //No esta en la torre ni en el Sotano
     else{
        ret=false;
     }
     return ret;
   }
   public boolean retirar(int nParqueo){
    boolean ret= false;
    int nivel = (nParqueo%10000)/100; //Saber Nivel
    int entrada = nParqueo%100; //Saber Entrada
    //Buscar en torre
    int busqueda = torre[nivel][entrada].buscar(nParqueo);
    //Retirar
    if(busqueda>=0&&busqueda<24){
        ret=torre[nivel][entrada].retirar(busqueda);
    }
    else if(busqueda==24){
        ret=sotano.retirar(nParqueo);
    }
    return ret;
   }
   public Vehiculo buscar(int nivel, int entrada, String placa){
    Vehiculo temp = null;
    int busqueda = torre[nivel][entrada].buscar(placa);
    if(busqueda>=0&&busqueda<24){
        temp=torre[nivel][entrada].getVehiculo(busqueda);
     }
     //Si es 24 esta en el Sotano, Buscar en el sotano
     else if(busqueda==24){
        int sbusqueda = sotano.buscar(placa);
        if(sbusqueda>=0&&sbusqueda<100){
             temp=sotano.getVehiculo(sbusqueda);
        }
        else{
            temp = null;
        }
     }
    return temp;
   }
   public Vehiculo buscar(int nivel, int entrada, int nParqueo){
    Vehiculo temp = null;
    int busqueda = torre[nivel][entrada].buscar(nParqueo);
    if(busqueda>=0&&busqueda<24){
        temp=torre[nivel][entrada].getVehiculo(busqueda);
     }
     //Si es 24 esta en el Sotano, Buscar en el sotano
     else if(busqueda==24){
        int sbusqueda = sotano.buscar(nParqueo);
        if(sbusqueda>=0&&sbusqueda<100){
             temp=sotano.getVehiculo(sbusqueda);
        }
        else{
            temp = null;
        }
     }
    return temp;
   }
   public double cobro(Vehiculo temp, Hora actual){
    double valor = 0.0;
    //Si la HoraActual es > HoraRetira
    if(temp.getHoraRetirada().compararHora(actual)){
        //Cobrar Multa
        //Horas normales hasta la hora de salida indicada con precio normal
        double v1= temp.getPrecio()*Hora.compararHora(temp.getHoraEntrada(), temp.getHoraRetirada());
        //Horas de mas hasta la hora actual con precio 25% de mas
        double v2= (temp.getPrecio()+(temp.getPrecio()*0.25))*Hora.compararHora(temp.getHoraRetirada(), actual);
        valor = v1+v2;
    }
    else{
        //Falta Aprox Hora a la mas cercana
       valor = temp.getPrecio()*Hora.compararHora(temp.getHoraEntrada(), actual);
    }
    /*double horas = Hora.compararHora(temp.getHoraEntrada(), temp.getHoraRetirada());
    return (temp.getPrecio()*horas);*/
    //Deudas pendientes
    valor=valor+temp.getCliente().getDeuda();
    //temp.getCliente().setNDeuda(0);//depronto
    return valor;
   }
   public Reloj Clock(){
    return reloj;
   }
   public boolean desalojo(){
     boolean ret = false;
     if(reloj.getHoraActual().getHora()==23&&reloj.getHoraActual().getMin()==59){
        //Desalojar Torre
        for(int i=0;i<NV;i++){
            for(int j=0;j<ENT;j++){
                for(int k=0;k<torre[i][j].tamano();k++){
                    double cobro = cobro(torre[i][j].getVehiculo(k),reloj.getHoraActual());
                    torre[i][j].getVehiculo(k).getCliente().setDeuda(cobro);
                }
                torre[i][j].desalojo();
            }
        }
        //Desalojar Sotano
        for(int i=0;i<sotano.tamano();i++){
            double cobro = cobro(sotano.getVehiculo(i),reloj.getHoraActual());
            sotano.getVehiculo(i).getCliente().setDeuda(cobro);
        }
        sotano.desalojo();
        ret = true;
     }
     this.aceptar=false;
     return ret;
   }
   public int nVehiculos(){
    int ret=0;
    for(int i=0;i<NV;i++){
        for(int j=0;j<ENT;j++){
            ret+=torre[i][j].tamano();
        }
    }
    ret+=sotano.tamano();
    return ret;
   }
   public Vehiculo proxSalir(){
    Vehiculo temp = null;
     for(int i=0; i<NV;i++){
        for(int j=0; j<ENT;j++){
            torre[i][j].ordenar();
            if(torre[i][j].tamano()>0){
                //Si no ha encontrado ninguno
                if(temp==null){
                    temp = torre[i][j].getVehiculo(0);
                }
                //Si ya tiene uno previo y es menor a temp
                else if(!temp.getHoraRetirada().compararHora(torre[i][j].getVehiculo(0).getHoraRetirada())){
                    temp=torre[i][j].getVehiculo(0);
                }
            }
        }
     } 
     return temp;
   }
   public int inSotano(){
      return sotano.tamano();
   }
   public boolean status(){
       return this.aceptar;
   }
}
