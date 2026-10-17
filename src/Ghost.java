public class Ghost extends Enemy{

    public Ghost() {}
    public Ghost(int dano, int velocidade) {
        super(dano, velocidade);
        setImage("imagens/inimigos/Fantasma/fantasma_0001.png");
    }

    @Override
    public void movimentar() {

        Player playerAlvo = getWorld().getObjects(Player.class).get(0);

        if (getX() < playerAlvo.getX())
            setLocation(getX()+velocidade,getY());
        else
            setLocation(getX()-velocidade,getY());

        if (getY() < playerAlvo.getY())
            setLocation(getX(),getY()+velocidade);
        else
            setLocation(getX(),getY()-velocidade);

    }
}
