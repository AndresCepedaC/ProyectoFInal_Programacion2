package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

public class Pago {
    private Double numeroInscripcion;
    private Double valorPago;
    private int numeroPago;

    public Pago() {    }

    public Pago(Double numeroInscripcion, Double valorPago, int numeroPago) {
        this.numeroInscripcion = numeroInscripcion;
        this.valorPago = valorPago;
        this.numeroPago = numeroPago;
    }

    public Double getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(Double numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public int getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(int numeroPago) {
        this.numeroPago = numeroPago;
    }
}
