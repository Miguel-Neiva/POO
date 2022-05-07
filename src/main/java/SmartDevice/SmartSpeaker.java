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

    public SmartSpeaker(String id, State state, int volume, String channel, String speakerBrand) {
        super(id, state);
        this.volume = volume;
        this.channel = channel;
        this.SpeakerBrand = speakerBrand;
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

    @Override
    public String toString() {
        return "SmartSpeaker{" +
                "volume=" + volume +
                ", channel='" + channel + '\'' +
                ", SpeakerBrand='" + SpeakerBrand + '\'' +
                '}';
    }

    public String getChannel()
    {
        return this.channel;
    }
    public String getSpeakerBrand(){
        return this.SpeakerBrand;
    }

    public void setChannel(String c)
    {
        this.channel = c;
    }
    public Integer representedBy() {
        return 1;}


}
