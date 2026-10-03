import greenfoot.World;

import java.util.Random;

public class MyWorld extends World {

    //Atributos - coisas que o mundo tem
    Random rd = new Random();

    Player player1;

    Enemy monstro1;
    Enemy monstro2;

    Coin coin1;
    Coin coin2;
    Coin coin3;
    Coin coin4;
    Coin coin5;

    //Metodo construtor
    public MyWorld(){
        super(1200,700,1);
        setBackground("imagens/background/background_light_600.png");

        player1 = new Player(3,5,100);
        addObject(player1, 600, 350);

        monstro1 = new Enemy(1, 3, "imagens/inimigos/Monstro/Monstro_baixo_0.png");
        addObject(monstro1, 800, rd.nextInt(700));
        monstro2 = new Enemy(1, 3, "imagens/inimigos/Monstro/Monstro_baixo_0.png");
        addObject(monstro2, 200, rd.nextInt(700));


        coin1 = new Coin(1, 10, 1000);
        coin1.spawn(this);
        coin2 = new Coin(1,  10, 1000);
        coin2.spawn(this);
        coin3= new Coin(1,  10, 1000);
        coin3.spawn(this);
        coin4 = new Coin(1,  10, 1000);
        coin4.spawn(this);
        coin5 = new Coin(1, 10, 1000);
        coin5.spawn(this);

    }


    //Metodo de Classe
}