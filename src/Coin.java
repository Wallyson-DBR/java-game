import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.Random;

public class Coin extends Actor {

    //Atributos
    public int valor;
    public String imagem;
    public int quantidade;
    public int tempo;

    //Construtores
    public Coin(){}

    public Coin(int valor, int quantidade, int tempo) {
        this.valor = valor;
        setImage("imagens/moedas/coin_java.png");
        this.quantidade = quantidade;
        this.tempo = tempo;
    }

    public void act() {
        despawn();
    }

    public void spawn(World mundo){
        int x = Greenfoot.getRandomNumber(1200);
        int y = Greenfoot.getRandomNumber(700);
        mundo.addObject(this,x,y);
    }

    public void despawn(){
        this.tempo --;
        if (tempo == 0){
            getWorld().removeObject(this);
        }
        getImage().setTransparency(tempo/4);
    }

}
