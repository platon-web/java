package org.example;

import org.w3c.dom.ls.LSOutput;

class Punkt{
    int x,y,z;

    Punkt(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Strecke{
    Punkt p1;
    int x;
    Punkt p2;

    Strecke(Punkt p1, Punkt p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public double gibLaenge(){
        double laenge = Math.sqrt(
                Math.pow(p1.x-p2.x,2) +
                        Math.pow(p1.y-p2.y,2) +
                        Math.pow(p1.z-p2.z,2));
        return laenge;
    }
    public double gibWolumen(){
      double wolumen = Math.pow(p1.x,2)*0.33*p1.y;
      return wolumen;
    }
    public double gibWolumen2(){
        double wolumen2 = Math.pow(p2.x,2)*0.33*p2.y;
        return wolumen2;
    }




}





class KlausurTest{
    public static void main(String[] args){
        Punkt p1 = new Punkt(10,20,30);
        Punkt p2 = new Punkt(40,50,60);



        Strecke laenge = new Strecke(p1,p2);

      //  System.out.print(laenge.gibLaenge());
//        int a = (int) (laenge.gibWolumen()>laenge.gibWolumen2()?  1 : 2);
//
//        System.out.println(a);
        if(laenge.gibWolumen()>laenge.gibWolumen2()){
            System.out.println(1);
        }else{
            System.out.println(2);
        }



    }
}


