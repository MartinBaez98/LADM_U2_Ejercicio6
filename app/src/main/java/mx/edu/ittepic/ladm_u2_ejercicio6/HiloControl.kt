package mx.edu.ittepic.ladm_u2_ejercicio6

class HiloControl (p:MainActivity) : Thread() {
    private var iniciado = false
    private var puntero = p
    private var pausa = false

    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            sleep(50)
            if(!pausa){
                puntero.runOnUiThread {

                }
            }
        }

    }

    fun estaIniciado(): Boolean {
        return iniciado
    }

    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }
}