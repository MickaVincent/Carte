package graphique;

import parser.PointInteret;

import java.awt.image.BufferedImage;

/**
 * Created by Hamor on 19/12/2016.
 */


public final class Icon {
    private static float xMin = 5.25f;
    private static float xMax = 7.23f;
    private static float yMin = 46.23f;
    private static float yMax = 48.183f;

    protected static class Pos{
        private int x;
        private int y;

        protected Pos(){
            this.x = 0;
            this.y = 0;
        }

        protected Pos(float x, float y){
            this.x = Math.round(x);
            this.y = Math.round(y);
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }

    public static Pos getIcon(int width, int height, BufferedImage icone, PointInteret p){
        //Transformation de la longitude pour qu'elle corresponde à l'echelle de la carte
        float xx = ((p.getLongitude()-xMin)/(xMax - xMin))*width - ((icone.getWidth() + 1) / 2);

        //meme chose, mais l'axe étant inversé, on rajoute un 1-
        float yy = (1-((p.getLatitude()-yMin)/(yMax - yMin)))*height - ((icone.getHeight() + 1) / 2);
        return (new Pos(xx, yy));
    }
}
