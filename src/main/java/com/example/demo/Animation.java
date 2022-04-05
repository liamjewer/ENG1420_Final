package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Animation {
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    int frames;
    int speed;

    public Animation(String filepath){
        BufferedReader input = null;
        try {
            File file = new File(filepath);
            input = new BufferedReader(new FileReader(file));
            String line = "";

            ArrayList<String> lines = new ArrayList<String>();
            while((line= input.readLine())!=null){
                lines.add(line);
            }

            //header
            try {
                //frames
                frames = Integer.parseInt(lines.get(0).substring(8));
                //fps
                speed = Integer.parseInt(lines.get(1).substring(7, lines.get(1).length() - 3));
            }catch(IndexOutOfBoundsException e){
                System.out.println("-error in file header format-");
                System.exit(0);
            }

            //main body
            try{
                for(int i = 3; i < lines.size(); i++){
                    if (lines.get(i).equals("Circle")){
                        Circle c = new Circle();
                        while(i < lines.size() && !lines.get(i).isBlank()) {
                            if(lines.get(i).substring(0, 2).equals("x:")) {
                                //x
                                c.setX(Integer.parseInt(lines.get(i).substring(3)));
                            }else if(lines.get(i).substring(0, 2).equals("y:")) {
                                //y
                                c.setY(Integer.parseInt(lines.get(i).substring(3).trim()));
                            }else if(lines.get(i).substring(0, 2).equals("r:")) {
                                //r
                                c.setRadius(Integer.parseInt(lines.get(i).substring(3).trim()));
                            }else if(lines.get(i).length() >= 7 && lines.get(i).substring(0, 7).equals("border:")) {
                                //border
                                c.setBorderThicc(Integer.parseInt(lines.get(i).substring(8).trim()));
                            }else if(lines.get(i).length() >= 6 && lines.get(i).substring(0, 6).equals("color:")) {
                                c.setColor(Color.rgb(Integer.parseInt(lines.get(i).substring(7).split(",")[0].trim()), Integer.parseInt(lines.get(i).substring(7).split(",")[1].trim()), Integer.parseInt(lines.get(i).substring(7).split(",")[2].trim())));
                            }else if(lines.get(i).length() >= 7 && lines.get(i).substring(0, 7).equals("bcolor:")) {
                                c.setBcolor(Color.rgb(Integer.parseInt(lines.get(i).substring(8).split(",")[0].trim()), Integer.parseInt(lines.get(i).substring(8).split(",")[1].trim()), Integer.parseInt(lines.get(i).substring(8).split(",")[2].trim())));
                            }else if(lines.get(i).equals("effect")) {
                                while(i < lines.size() - 1 && !lines.get(i+1).isBlank() && !lines.get(i+1).equals("effect")){
                                    switch(lines.get(i)){
                                        case("Show"):
                                            Effect s = new Effect(Integer.parseInt(lines.get(i+1).substring(7).trim()), Effect.Type.Show);
                                            c.addEffect(s);
                                            break;
                                        case("Hide"):
                                            Effect h = new Effect(Integer.parseInt(lines.get(i+1).substring(7).trim()), Effect.Type.Hide);
                                            c.addEffect(h);
                                            break;
                                        case("Jump"):
                                            Jump j = new Jump();
                                            for(int n = 1; n <= 3; n++){
                                                if(lines.get(i+n).substring(0, 6).equals("start:")){
                                                    j.setFrame(Integer.parseInt(lines.get(i+n).substring(7).trim()));
                                                }else if(lines.get(i+n).substring(0, 2).equals("x:")){
                                                    j.setX(Integer.parseInt(lines.get(i+n).substring(2).trim()));
                                                }else if(lines.get(i+n).substring(0, 2).equals("y:")){
                                                    j.setY(Integer.parseInt(lines.get(i+n).substring(2).trim()));
                                                }
                                            }
                                            c.addEffect(j);
                                            break;
                                        case("Change"):
                                            Change ch = new Change();
                                            for(int n = 1; n <= 2; n++){
                                                if(lines.get(i+n).substring(0, 6).equals("start:")){
                                                    ch.setFrame(Integer.parseInt(lines.get(i+1).substring(7)));
                                                }else if(lines.get(i+n).substring(0, 6).equals("color:")){
                                                    ch.setColor(Color.rgb(Integer.parseInt(lines.get(i+n).substring(7).split(",")[0].trim()), Integer.parseInt(lines.get(i+n).substring(7).split(",")[1].trim()), Integer.parseInt(lines.get(i+n).substring(7).split(",")[2].trim())));
                                                }
                                            }
                                            c.addEffect(ch);
                                            break;
                                    }
                                    i++;
                                }
                            }
                            i++;
                        }
                        shapes.add(c);
                    }else if (lines.get(i).equals("Rect")){
                        Rectangle r = new Rectangle();
                        while(i < lines.size() && !lines.get(i).isBlank()) {
                            if(lines.get(i).substring(0, 2).equals("x:")) {
                                r.setX(Integer.parseInt(lines.get(i).substring(3)));
                            }else if(lines.get(i).substring(0, 2).equals("y:")) {
                                r.setY(Integer.parseInt(lines.get(i).substring(3).trim()));
                            }else if(lines.get(i).length() >= 7 &&lines.get(i).substring(0, 7).equals("length:")) {
                                r.setLength(Integer.parseInt(lines.get(i).substring(8).trim()));
                            }else if(lines.get(i).length() >= 6 && lines.get(i).substring(0, 6).equals("width:")) {
                                r.setWidth(Integer.parseInt(lines.get(i).substring(7).trim()));
                            }else if(lines.get(i).length() >= 7 && lines.get(i).substring(0, 7).equals("border:")) {
                                r.setBorderThicc(Integer.parseInt(lines.get(i).substring(8).trim()));
                            }else if(lines.get(i).length() >= 6 && lines.get(i).substring(0, 6).equals("color:")) {
                                r.setColor(Color.rgb(Integer.parseInt(lines.get(i).substring(7).split(",")[0].trim()), Integer.parseInt(lines.get(i).substring(7).split(",")[1].trim()), Integer.parseInt(lines.get(i).substring(7).split(",")[2].trim())));
                            }else if(lines.get(i).length() >= 7 && lines.get(i).substring(0, 7).equals("bcolor:")) {
                                r.setBcolor(Color.rgb(Integer.parseInt(lines.get(i).substring(8).split(",")[0].trim()), Integer.parseInt(lines.get(i).substring(8).split(",")[1].trim()), Integer.parseInt(lines.get(i).substring(8).split(",")[2].trim())));
                            }else if(lines.get(i).equals("effect")) {
                                while(i < lines.size() - 1 && !lines.get(i+1).isBlank() && !lines.get(i+1).equals("effect")){
                                    switch(lines.get(i)){
                                        case("Show"):
                                            Effect s = new Effect(Integer.parseInt(lines.get(i+1).substring(7).trim()), Effect.Type.Show);
                                            r.addEffect(s);
                                            break;
                                        case("Hide"):
                                            Effect h = new Effect(Integer.parseInt(lines.get(i+1).substring(7).trim()), Effect.Type.Hide);
                                            r.addEffect(h);
                                            break;
                                        case("Jump"):
                                            Jump j = new Jump();
                                            for(int n = 1; n <= 3; n++){
                                                if(lines.get(i+n).length() >= 6 && lines.get(i+n).substring(0, 6).equals("start:")){
                                                    j.setFrame(Integer.parseInt(lines.get(i+n).substring(7).trim()));
                                                }else if(lines.get(i+n).substring(0, 2).equals("x:")){
                                                    j.setX(Integer.parseInt(lines.get(i+n).substring(2).trim()));
                                                }else if(lines.get(i+n).substring(0, 2).equals("y:")){
                                                    j.setY(Integer.parseInt(lines.get(i+n).substring(2).trim()));
                                                }
                                                r.addEffect(j);
                                            }
                                            break;
                                        case("Change"):
                                            Change ch = new Change();
                                            for(int n = 1; n <= 2; n++){
                                                if(lines.get(i+n).substring(0, 6).equals("start:")){
                                                    ch.setFrame(Integer.parseInt(lines.get(i+1).substring(7)));
                                                }else if(lines.get(i+n).substring(0, 6).equals("color:")){
                                                    ch.setColor(Color.rgb(Integer.parseInt(lines.get(i+n).substring(7).split(",")[0].trim()), Integer.parseInt(lines.get(i+n).substring(7).split(",")[1].trim()), Integer.parseInt(lines.get(i+n).substring(7).split(",")[2].trim())));
                                                }
                                            }
                                            r.addEffect(ch);
                                            break;
                                    }
                                    i++;
                                }
                            }
                            i++;
                        }
                        shapes.add(r);
                    }else if (lines.get(i).equals("Line")){
                        Line l = new Line();
                        while(i < lines.size() && !lines.get(i).isBlank()) {
                            if(lines.get(i).substring(0, 2).equals("x:")) {
                                l.setX(Integer.parseInt(lines.get(i).substring(3)));
                            }else if(lines.get(i).substring(0, 2).equals("y:")) {
                                l.setY(Integer.parseInt(lines.get(i).substring(3).trim()));
                            }else if(lines.get(i).substring(0, 3).equals("x2:")) {
                                l.setX2(Integer.parseInt(lines.get(i).substring(4)));
                            }else if(lines.get(i).substring(0, 3).equals("y2:")) {
                                l.setY2(Integer.parseInt(lines.get(i).substring(4).trim()));
                            }else if(lines.get(i).length() >= 7 && lines.get(i).substring(0, 7).equals("border:")) {
                                l.setBorderThicc(Integer.parseInt(lines.get(i).substring(8).trim()));
                            }else if(lines.get(i).length() >= 6 && lines.get(i).substring(0, 6).equals("color:")) {
                                l.setColor(Color.rgb(Integer.parseInt(lines.get(i).substring(7).split(",")[0].trim()), Integer.parseInt(lines.get(i).substring(7).split(",")[1].trim()), Integer.parseInt(lines.get(i).substring(7).split(",")[2].trim())));
                            }else if(lines.get(i).equals("effect")) {
                                while(i < lines.size() - 1 && !lines.get(i+1).isBlank() && !lines.get(i+1).equals("effect")){
                                    switch(lines.get(i)){
                                        case("Show"):
                                            Effect s = new Effect(Integer.parseInt(lines.get(i+1).substring(7).trim()), Effect.Type.Show);
                                            l.addEffect(s);
                                            break;
                                        case("Hide"):
                                            Effect h = new Effect(Integer.parseInt(lines.get(i+1).substring(7).trim()), Effect.Type.Hide);
                                            l.addEffect(h);
                                            break;
                                        case("Jump"):
                                            Jump j = new Jump();
                                            for(int n = 1; n <= 3; n++){
                                                if(lines.get(i+n).length() >= 6 && lines.get(i+n).substring(0, 6).equals("start:")){
                                                    j.setFrame(Integer.parseInt(lines.get(i+n).substring(7).trim()));
                                                }else if(lines.get(i+n).substring(0, 2).equals("x:")){
                                                    j.setX(Integer.parseInt(lines.get(i+n).substring(2).trim()));
                                                }else if(lines.get(i+n).substring(0, 2).equals("y:")){
                                                    j.setY(Integer.parseInt(lines.get(i+n).substring(2).trim()));
                                                }
                                            }
                                            l.addEffect(j);
                                            break;
                                        case("Change"):
                                            Change ch = new Change();
                                            for(int n = 1; n <= 2; n++){
                                                if(lines.get(i+n).substring(0, 6).equals("start:")){
                                                    ch.setFrame(Integer.parseInt(lines.get(i+1).substring(7)));
                                                }else if(lines.get(i+n).substring(0, 6).equals("color:")){
                                                    ch.setColor(Color.rgb(Integer.parseInt(lines.get(i+n).substring(7).split(",")[0].trim()), Integer.parseInt(lines.get(i+n).substring(7).split(",")[1].trim()), Integer.parseInt(lines.get(i+n).substring(7).split(",")[2].trim())));
                                                }
                                            }
                                            l.addEffect(ch);
                                            break;
                                    }
                                    i++;
                                }
                            }
                            i++;
                        }
                        shapes.add(l);
                    }
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("-error in file body format-");
                System.exit(0);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void render(GraphicsContext gc) {
        for(int i = 0; i < shapes.size(); i++){
            shapes.get(i).render(gc);
        }
    }
}
