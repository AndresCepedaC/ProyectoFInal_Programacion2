package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

public class Inscripcion {
    private Usuario usuario;
    private Curso curso;
    private int numeroInscripcion;
    private Pago pago;

    public Inscripcion() {
    }

    public Inscripcion(Usuario usuario, Curso curso, int numeroInscripcion, Pago pago) {
        this.usuario = usuario;
        this.curso = curso;
        this.numeroInscripcion = numeroInscripcion;
        this.pago = pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
