package com.example.sorojara.mathematician;
import java.util.*;
import android.widget.EditText;
import android.widget.TextView;


public class Mathematik {
    public ArrayList<Mathematik> lista;//lista de bloques
    public Mathematik []bloques;
    String text;//texto en nodos hoja
    boolean sub;//control para hojas
    public String structure;// estructura del bloque
    int counter; //contador de bloques
    public TextView txt;


    /*
     * EJEMPLO DE ESTRUCTURA
     * structure:
     * (4)/(20)*(_0 )
     */

    public Mathematik() {
        lista = new ArrayList<Mathematik>();
        text="";
        sub=false;
        structure = "";
        counter = 0;
        //bloques = new Mathematik[0];
        bloques = lista.toArray(new Mathematik[lista.size()]);
    }

    public Mathematik(android.content.Context cont) {
        lista = new ArrayList<Mathematik>();
        text="";
        sub=false;
        structure = "";
        counter = 0;
        //bloques = new Mathematik[0];
        bloques = lista.toArray(new Mathematik[lista.size()]);
        txt = new TextView(cont);
    }

    public Mathematik(String t, boolean b, String st, int c) {
        lista = new ArrayList<Mathematik>();
        text=t;
        sub=b;
        structure = st;
        counter = c;
    }
    /* ADD YOUR CODE HERE */

    public String getText(){
        int i, j;

        if(sub==false){
            return text;
        }else{
            System.out.println("");
            ArrayList<Integer> structValues = new ArrayList<>();

            String firstList[] = structure.split("_");
            String buffer = firstList[0];

            for(i=1;i<firstList.length;i++){
                String secondList[] = firstList[i].split(" ");
                int num = Integer.parseInt(secondList[0]);
                structValues.add(num);
                String texto = bloques[num].getText();
                buffer = buffer + texto;

                for(j=1; j<secondList.length;j++){
                    buffer = buffer + secondList[j];
                }

            }



            return buffer;
        }
    }

    public void addBlock(Mathematik r420){
        lista = new ArrayList<Mathematik>(Arrays.asList(bloques));
        lista.add(r420);
        counter += 1;
        sub = true;
        bloques = lista.toArray(new Mathematik[lista.size()]);
    }

    public void updateBlock(Mathematik r420, int i){
        bloques[i]=r420;
    }


    public void setText(String in){
        text = in;
    }

    public void setText(String in, int num){
        lista = new ArrayList<Mathematik>(Arrays.asList(bloques));
        Mathematik buffer = lista.get(num);
        buffer.setText(in);
        lista.set(num, buffer);
        bloques = lista.toArray(new Mathematik[lista.size()]);
    }



    public void setStructure(String in){
        structure = in;
    }

    public void mantenerBL(){
        bloques = lista.toArray(new Mathematik[lista.size()]);
    }

    public void mantenerLB(){
        lista = new ArrayList<Mathematik>(Arrays.asList(bloques));
    }
}
