package SmartDevice;

import java.util.Objects;

public class SmartCamera extends SmartDevice{
    public record CameraResolution (int height, int width) {
    }
    private CameraResolution resolution;
    private int size;

    private double consumption;

    public SmartCamera () {
        this.resolution = new CameraResolution(0,0);
        this.size = 0;
    }

    public SmartCamera (String id, State state,CameraResolution resolution,  int size) {
        super(id,state);
        this.resolution = new CameraResolution(resolution.height,resolution.width);
        this.size = size;
    }

    public SmartCamera (SmartCamera dev) {
        super(dev);
        this.resolution =dev.getResolution();
        this.size = dev.getSize();
    }

    public CameraResolution getResolution() {
        return resolution;
    }

    public int getSize() {
        return size;
    }

    public void setResolution(CameraResolution resolution) {
        this.resolution = resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartCamera that = (SmartCamera) o;
        return size == that.size && Objects.equals(resolution, that.resolution);
    }

    @Override
    public String toString() {
        return "SmartCamera{" +
                "resolution=" + resolution +
                ", size=" + size +
                '}';
    }
    @Override
    public SmartCamera clone () {
        return new SmartCamera(this);
    }

    /** The number that represents a position */
    public Integer representedBy() {
        return 1;
    }

    public int consumption(CameraResolution resolution,  int size){
        // só uma ideia, funciona assim pq quanto maior for a res mais comsumo tem
        return this.resolution.width *this.resolution.height * size;
    }

}

