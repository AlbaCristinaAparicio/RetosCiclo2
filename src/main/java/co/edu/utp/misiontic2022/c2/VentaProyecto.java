package co.edu.utp.misiontic2022.c2;

public class VentaProyecto {
    // Atributos
    private double monto;
    private double interes;
    private int tiempo;

    //Constructores
    
    VentaProyecto(){
        this.monto = 0;
        this.interes = 0;
        this.tiempo = 0;
    }

    VentaProyecto(int pTiempo, double pMonto, double pInteres){
        this.monto = pMonto;
        this.interes = pInteres;
        this.tiempo = pTiempo;
    }

    //Métodos de Lógica
    

    public double calcularInteresSimple()  {
        //System.out.println("Tiempo: "+tiempo+" Monto: "+monto+" Interes: "+interes);
        double interesSimple = Math.round(monto * (interes / 100) * tiempo);
        //System.out.println("Interes simple: "+interesSimple);
        return interesSimple;
        
    }

    public double calcularInteresCompuesto() {
        double interesCompuesto = Math.round(monto * (Math.pow((1+(interes/100)),tiempo)-1));
        //System.out.println("Interes compuesto: "+interesCompuesto);
        return interesCompuesto;
    }
    public String compararInversion(int pTiempo, double pMonto, double pInteres) {
        this.tiempo = pTiempo;
        this.monto = pMonto;
        this.interes = pInteres;
        double diferencia = calcularInteresCompuesto() - calcularInteresSimple();
        return ("La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia);
    }
    public String compararInversion(){
        double diferencia = calcularInteresCompuesto() - calcularInteresSimple();
        if (diferencia == 0) {
            return ("No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.");
        }
        else{
            return ("La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia);

        }
            
    }


    //Getters

    //Setters

    public static void main(String[] args) {
        // ***Caso de Prueba 1: Valores enviados a través del método compararInversion
        //VentaProyecto ventaConstruccion = new VentaProyecto();
        //System.out.println(ventaConstruccion.calcularInteresSimple());
        //System.out.println(ventaConstruccion.calcularInteresCompuesto());
        //System.out.println(ventaConstruccion.compararInversion(36,200000,5.0)); 

        // ***Caso de Prueba 2: Valores entregados al constructor de la clase VentaProyecto
        VentaProyecto ventaConstruccion = new VentaProyecto(12,150000,2.0);
        System.out.println(ventaConstruccion.calcularInteresSimple());
        System.out.println(ventaConstruccion.calcularInteresCompuesto());
        System.out.println(ventaConstruccion.compararInversion()); 

        // ***Caso de Prueba 3: Sin entradas
        //VentaProyecto ventaConstruccion = new VentaProyecto();
        //System.out.println(ventaConstruccion.calcularInteresSimple());
        //System.out.println(ventaConstruccion.calcularInteresCompuesto());
        //System.out.println(ventaConstruccion.compararInversion());
    }
}
