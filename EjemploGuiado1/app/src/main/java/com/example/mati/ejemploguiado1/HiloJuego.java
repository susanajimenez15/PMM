package com.example.mati.ejemploguiado1;

/**
 * Created by mati on 7/12/16.
 */

public class HiloJuego extends Thread {


        @Override
        public void run() {
            while (true) {
                actualizaMovimiento();
            }
        }
    }
}
