import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.Random;

public class MyWorld extends World {

    //Atributos - coisas que o mundo tem
    Random rd = new Random();

    Player player1;

    Enemy monstro1;
    Enemy monstro2;

    //Metodo construtor
    public MyWorld(){
        super(1200,700,1);
        setBackground("imagens/background/background_light_600.png");

        player1 = new Player(3,5,100);
        addObject(player1, 600, 350);

        Monster monster1 = new Monster(1, 3);
        addObject(monster1, 800, rd.nextInt(700));
        Monster monster2 = new Monster(1, 3);
        addObject(monster2, 200, rd.nextInt(700));

        Ghost ghost1 = new Ghost(1, 3);
        addObject(ghost1, 200, rd.nextInt(700));

        for (int i = 0; i < 15; i++) {
            Coin coin1 = new Coin(10, 1000);
            coin1.spawn(this);
        }
    }

    //Metodo de Classe

    public void act() {

        mostarPontuacao();
        mostarVida();
        gerarMoeda();

    }

    public void mostarPontuacao(){
        showText("Pontos: " + player1.getPontos(), 60, 20);
    }

    public void mostarVida(){
        showText("Vidas: " + player1.getVida(), 1150, 20);
    }

    public void gerarMoeda(){
        int numRdm = Greenfoot.getRandomNumber(1000);
        if (numRdm <= 10){
            Coin coin1 = new Coin(10, 1000);
            coin1.spawn(this);
        }
    }

}