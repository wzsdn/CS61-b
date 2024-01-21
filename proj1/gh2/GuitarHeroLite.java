package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHeroLite {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    public static final double CONCERT_D = CONCERT_A * Math.pow(2, 6.0 / 12.0);
    public static final double CONCERT_B = CONCERT_A * Math.pow(2, -6.0 / 12.0);
    public static final double CONCERT_O = CONCERT_A * Math.pow(2, 6.0 / 12.0);



    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);
        GuitarString stringD = new GuitarString(CONCERT_D);
        GuitarString stringB = new GuitarString(CONCERT_B);
        GuitarString stringO = new GuitarString(CONCERT_O);


        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') {
                    stringA.pluck();
                } else if (key == 'c') {
                    stringC.pluck();
                }
                else if (key=='b')
                    stringB.pluck();
                else if(key=='o')
                    stringO.pluck();
                else if(key=='d'){
                    stringD.pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = stringA.sample()+stringC.sample()+ stringD.sample()+ stringB.sample()+stringO.sample();/* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            stringA.tic();
            stringC.tic();
            stringD.tic();
            stringO.tic();
            stringB.tic();
        }
    }
}

