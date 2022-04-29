package SmartDevice;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;

/**
 * This class represents a SmartSpeaker device
 * The comments are mainly written in English.
 * */
public class SmartSpeaker extends SmartDevice{
    public static final int MAX = 100; //volume máximo

    private int volume;
    private String channel;
    private String SpeakerBrand;

    /**
     * Constructor for objects of class SmartSpeaker
     */
    public SmartSpeaker() {
        // initialise instance variables
        super();
        this.volume = 0;
        this.channel = "";
        this.SpeakerBrand = "";
    }

    public SmartSpeaker(String channel, int volume, String SpeakerBrand) {
        // initialise instance variables
        super();
        this.channel = channel;
        this.volume = 10;
        this.SpeakerBrand = SpeakerBrand;
    }

    public SmartSpeaker(String s, String s1, int i) {
        // initialise instance variables
        super(s);
        this.channel = s1;

        if (i < 0) this.volume = 0;
        else this.volume = i;
    }

    public void volumeUp() {
        if (this.volume<MAX) this.volume++;
    }

    public void volumeDown() {
        if (this.volume>0) this.volume--;
    }

    public int getVolume()
    {
        return this.volume;
    }

    public String getChannel()
    {
        return this.channel;
    }

    public void setChannel(String c)
    {
        this.channel = c;
    }
    public Integer representedBy() {
        return 1;}

}
