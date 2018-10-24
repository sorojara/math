package com.example.sorojara.pruebabloques;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.*;
import android.content.Context;
import java.util.*;

public class blockerPrueba {

    EditText blocks [];

    public blockerPrueba(){
        blocks = new EditText[0] ;
    }

    @SuppressLint("ResourceType")
    public RelativeLayout create(Context c){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.BELOW, 1001);
        ArrayList<EditText> lista = new ArrayList<EditText>(Arrays.asList(blocks));
        lista.add(new EditText(c));
        blocks = lista.toArray(new EditText[lista.size()]);
        blocks[0].setLayoutParams(params);
        blocks[0].setId(420);
        blocks[0].setHint("(                  )");
        blocks[0].setEnabled(true);
        Button but1 = new Button(c);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        but1.setLayoutParams(params2);
        but1.setText("Press Here!");
        but1.setId(1001);

        lista = new ArrayList<EditText>(Arrays.asList(blocks));
        lista.add(new EditText(c));
        blocks = lista.toArray(new EditText[lista.size()]);

        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params3.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params3.addRule(RelativeLayout.BELOW, 420);

        blocks[1] = new EditText(c);
        blocks[1].setLayoutParams(params);
        blocks[1].setId(1003);
        blocks[1].setHint("(                  )");
        blocks[1].setEnabled(true);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(blocks[0].getText());
            }
        });

        RelativeLayout layout1 = new RelativeLayout(c);
        layout1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
        layout1.addView(blocks[0]);
        layout1.addView(but1);
        //layout1.removeView(but1);
        //layout1.addView(but2);
        //layout1.removeView(but2);
        //layout1.addView(blocks[1]);

        return layout1;

    }
}
