package com.DavideBasciano.tris;


import java.util.Random;
import com.DavideBasciano.tris.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Multy extends Activity {


     int punti[][];
     int i, j, k = 0;
     Button bottoni[][];
     TextView visualizza;
     /** Turno mi gestisce qual'è il giocatore attivo
      * true: Giocatore 1
      * false: Giocatore 2
      */
     boolean turno=true;

     /** Chiamato alla creazione dell'activity */
     @Override
     public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.main);        


          InizializzaTavolo();
     }
    
     /** Imposto il tasto 'opzioni' */
     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
          super.onCreateOptionsMenu(menu);
          MenuItem item = menu.add("Ricomincia");
          return true;
     }
    
     public boolean onOptionsItemSelected(MenuItem item) {
          InizializzaTavolo();
          return true;
     }


    /** Imposto il "tavolo da gioco" */
     private void InizializzaTavolo() {
    	 
          bottoni = new Button[4][4];
          punti = new int[4][4];
          visualizza = (TextView) findViewById(R.id.vis);
          turno=true;
          
          //Colonna 1
          bottoni[1][3] = (Button) findViewById(R.id.uno);
          bottoni[1][2] = (Button) findViewById(R.id.due);
          bottoni[1][1] = (Button) findViewById(R.id.tre);

          //Colonna 2
          bottoni[2][3] = (Button) findViewById(R.id.quattro);
          bottoni[2][2] = (Button) findViewById(R.id.cinque);
          bottoni[2][1] = (Button) findViewById(R.id.sei);

          //Colonna 3
          bottoni[3][3] = (Button) findViewById(R.id.sette);
          bottoni[3][2] = (Button) findViewById(R.id.otto);
          bottoni[3][1] = (Button) findViewById(R.id.nove);
        
          for (i = 1; i <= 3; i++) {
               for (j = 1; j <= 3; j++)
                    punti[i][j] = 2;
          }


          /** Aggiungo gli ascoltatori per ogni bottone */
          for (i = 1; i <= 3; i++) {
               for (j = 1; j <= 3; j++) {
            	   bottoni[i][j].setOnClickListener(new MioClickListener(i, j));
                    if(!bottoni[i][j].isEnabled()) {
                    	bottoni[i][j].setText(" ");
                    	bottoni[i][j].setEnabled(true);
                    }
               }
          }
     }
     
     /*
      * Gestisco in modo alternato la pressione sui pulsanti dei due giocatori
      */
     class MioClickListener implements View.OnClickListener {
          int x;
          int y;


          public MioClickListener(int x, int y) {
               this.x = x;
               this.y = y;
          }


          public void onClick(View v) {
               if(bottoni[x][y].isEnabled()) {
            	   bottoni[x][y].setEnabled(false);
            	   if(turno)
            	   {
            		   bottoni[x][y].setText("O");
            		   punti[x][y] = 0;
            		   turno=!turno;
            	   }
            	   else
            	   {
            		   bottoni[x][y].setText("X");
            		   punti[x][y] = 1;
            		   turno=!turno;
            	   }
                   visualizza.setText("");
                   ControllaCampo();
               }
          }
     }

     // Controllo se qualcuno ha vinto
     private boolean ControllaCampo() {
          boolean fine = false;
          if ((punti[1][1] == 0 && punti[2][2] == 0 && punti[3][3] == 0)
                    || (punti[1][3] == 0 && punti[2][2] == 0 && punti[3][1] == 0)
                    || (punti[1][2] == 0 && punti[2][2] == 0 && punti[3][2] == 0)
                    || (punti[1][3] == 0 && punti[2][3] == 0 && punti[3][3] == 0)
                    || (punti[1][1] == 0 && punti[1][2] == 0 && punti[1][3] == 0)
                    || (punti[2][1] == 0 && punti[2][2] == 0 && punti[2][3] == 0)
                    || (punti[3][1] == 0 && punti[3][2] == 0 && punti[3][3] == 0)
                    || (punti[1][1] == 0 && punti[2][1] == 0 && punti[3][1] == 0)) {
               visualizza.setText("Giocatore 1 ha vinto!");
               fine = true;
          } else if ((punti[1][1] == 1 && punti[2][2] == 1 && punti[3][3] == 1)
                    || (punti[1][3] == 1 && punti[2][2] == 1 && punti[3][1] == 1)
                    || (punti[1][2] == 1 && punti[2][2] == 1 && punti[3][2] == 1)
                    || (punti[1][3] == 1 && punti[2][3] == 1 && punti[3][3] == 1)
                    || (punti[1][1] == 1 && punti[1][2] == 1 && punti[1][3] == 1)
                    || (punti[2][1] == 1 && punti[2][2] == 1 && punti[2][3] == 1)
                    || (punti[3][1] == 1 && punti[3][2] == 1 && punti[3][3] == 1)
                    || (punti[1][1] == 1 && punti[2][1] == 1 && punti[3][1] == 1)) {
               visualizza.setText("Giocatore 2 ha vinto!");
               fine = true;
          } else {
               boolean vuoto = false;
               for(i=1; i<=3; i++) {
                    for(j=1; j<=3; j++) {
                         if(punti[i][j]==2) {
                              vuoto = true;
                              break;
                         }
                    }
               }
               if(!vuoto) {
                    fine = true;
                    visualizza.setText("Pareggio!");
               }
          }
          return fine;
     }
}