package com.micky.miprimeraaplicacion.backend;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.Random;

public class Grafico extends View {
    private static final String TAG ="GRAFICO";
    private Random random=new Random();

    public Grafico(Context context){
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        int ancho=getWidth();
        int alto=getHeight();
        Log.d(TAG,"ancho: "+ancho+" alto: x"+alto);

        canvas.drawLine(ancho/2,alto/2,ancho,alto/2, paint);
        canvas.drawLine(ancho/2,0,ancho/2,alto/2,paint);
        canvas.drawLine(ancho/2,alto/2,-ancho ,(float) (ancho*Math.sqrt(2)),paint);

        float limInfx=-20;
        float limSupx=20;
        float limInfy=-20;
        float limSupy=20;


        for (float x=limInfx; x<=limSupx;x+=0.01)
        {
            double y=fx(x);
            //Log.d(TAG,"x=  "+x+" y= "+y);
            double xt= ((x-limInfx/2)/(limSupx-limInfx))*ancho;
            double yt=alto-((y-limInfy/2)/(limSupy-limInfy))*alto;
            paint.setColor(Color.YELLOW);
            canvas.drawCircle((float)xt,(float)yt,3,paint);
            Log.d(TAG,"x: "+x+" xt="+xt+"y: "+y+" yt"+yt);
        }

       /* for (int i = 0; i < 50; i++) {
            double xOffset = i * 5; // Espacio entre cada figura
            double yOffset = i * 5;

            for (float x = limInfx; x <= limSupx; x += 0.01) {
                double y = fx(x);
                double xt = ((x - limInfx / 2) / (limSupx - limInfx)) * ancho + xOffset;
                double yt = alto - ((y - limInfy / 2) / (limSupy - limInfy)) * alto + yOffset;
                paint.setColor(Color.YELLOW);
                canvas.drawCircle((float) xt, (float) yt, 3, paint);
            }
        }*/

        for(float j=0; j<=10; j+=0.03){
            float limitInfX = -20+j;
            float limitSupX = 20+j;
            float LimitInfY = -20+j;
            float LimitSupY = 20+j;


            for (float x = limitInfX; x <= limitSupX; x += 0.1) {
                double Y = fx(x);
                double xt = ((x - limitInfX) / (limitSupX - limitInfX)) * ancho;
                double yt = alto - ((Y - LimitInfY) / (LimitSupY - LimitInfY)) * alto;
                //ouble zt = ((x - limitInfZ) / (limitSupZ - limitInfZ)) * ancho;
                paint.setColor(Color.YELLOW);
                canvas.drawCircle((float) xt, (float) yt, 3, paint);
                }
            }

/*

        canvas.drawColor(Color. WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawLine(10,10,50,50,paint);

        for(int i=1;i<=300;i++)
        {
            paint.setColor(Color.argb(255,10+i*5,5*i+10,3*i+20));
            canvas.drawLine(10,10,50*i,10*i,paint);
        }


        canvas.drawCircle(200,200,100,paint);
        for(int i=1;i<=100;i++)
        {
            paint.setColor(Color.argb(255,10+i*5,5*i+10,3*i+20));
            canvas.drawCircle(200+i,200,100,paint);
        }

        //canvas.drawCircle(10,500,100,paint);

        for (int i = 0; i < 1; i++) {
            int x = random.nextInt(canvas.getWidth());
            int y = random.nextInt(canvas.getHeight());
            int radius = random.nextInt(100) + 50;

            paint.setColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            canvas.drawCircle(x, y, radius, paint);
        }
        // triángulo
        paint.setColor(Color.RED);
        float[] triangle = {300, 950, 800, 950, 550, 650, 300, 950, 550, 650, 800, 950};
        canvas.drawLines(triangle, paint);

        // rectángulo
        paint.setColor(Color.RED);
        canvas.drawRect(450, 950, 650, 1150, paint);

        for(int i=1;i<=200;i++)
        {
            paint.setColor(Color.argb(255,10+i*5,5*i+10,3*i+20));
            canvas.drawLine(450+i,950,450+i,1150,paint);
        }

        for (int i = 0; i < 50; i++) {
            float x = random.nextFloat() * canvas.getWidth();
            float y = random.nextFloat() * canvas.getHeight();

            if (isPointInsideTriangle(x, y, triangle)) {
                int radius = random.nextInt(30) + 10;
                paint.setColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                canvas.drawCircle(x, y, radius, paint);
            } else {
                i--;
            }
        }*/
    }

    double fx(float x){

        return x*x;
    }
    // Función para verificar si un punto está dentro de un triángulo
    private boolean isPointInsideTriangle(float x, float y, float[] triangle) {
        float x1 = triangle[0];
        float y1 = triangle[1];
        float x2 = triangle[2];
        float y2 = triangle[3];
        float x3 = triangle[4];
        float y3 = triangle[5];

        // Verifica si el punto está en el lado correcto de cada línea del triángulo
        boolean b1 = (x - x1) * (y2 - y1) - (x2 - x1) * (y - y1) >= 0;
        boolean b2 = (x - x2) * (y3 - y2) - (x3 - x2) * (y - y2) >= 0;
        boolean b3 = (x - x3) * (y1 - y3) - (x1 - x3) * (y - y3) >= 0;

        // El punto está dentro del triángulo si está en el lado correcto de todas las líneas
        return ((b1 == b2) && (b2 == b3));
    }


}

