package com.example.sorojara.mathematician;
import java.util.*;
import android.widget.ImageButton;



/*
import com.example.sorojara.mathematician.Mathematik;
import org.mariuszgromada.math.mxparser.*;
*/

public class BlockMaster {
    public Mathematik root;

    public BlockMaster() {
        root = new Mathematik();
    }

    public Mathematik creator(int op){
        Mathematik salida = new Mathematik();
        Mathematik leftBlock = new Mathematik();
        Mathematik rightBlock = new Mathematik();
        salida.addBlock(leftBlock);
        salida.addBlock(rightBlock);
        salida.sub = true;

        switch(op){
            case 0://Bloque Base
                Mathematik centro = new Mathematik();
                salida.addBlock(centro);
                salida.setStructure(" _0 (_2 ) _1 ");
                salida.counter = 3;
                break;

            case 1://Bloque Division
                Mathematik dividendo = new Mathematik();
                Mathematik divisor = new Mathematik();
                salida.addBlock(dividendo);
                salida.addBlock(divisor);
                salida.setStructure(" _0 ((_2 )/(_3 )) _1 ");
                salida.counter = 4;
                break;

            case 2://Bloque Exponencial
                Mathematik base = new Mathematik();
                Mathematik exponente = new Mathematik();
                salida.addBlock(base);
                salida.addBlock(exponente);
                salida.setStructure(" _0 ((_2 )^(_3 )) _1 ");
                salida.counter = 4;
                break;

            case 3://Bloque Raiz
                Mathematik raiz = new Mathematik();
                Mathematik num = new Mathematik();
                salida.addBlock(raiz);
                salida.addBlock(num);
                salida.setStructure(" _0 ((_3 )^(1/(_2 )) _1 ");
                salida.counter = 4;
                break;
        }


        return salida;
    }


    public void updateBlock(Mathematik base, Mathematik r420, int route[], int i){
        if(i<route.length-1){
            System.out.println("counter i: " + i);//printer
            i= i+1;
            updateBlock(base.bloques[i], r420, route, i);
        }else{
            System.out.println("PRE ERROR: "+ base.getText());//printer
            base.updateBlock(r420, i);
            //base.lista = new ArrayList<Mathematik>(Arrays.asList(base.bloques));
        }


    }

    public void updateBlock(Mathematik base, Mathematik r420, int i){
        base.updateBlock(r420, i);
        //base.lista = new ArrayList<Mathematik>(Arrays.asList(base.bloques));
    }

}
