package SmartDevice;

import java.util.Objects;

public class SmartCamera extends SmartDevice{
    public record CameraResolution (int height, int width) {
    }
    private CameraResolution resolution;
    private int size;

    public SmartCamera () {
        this.resolution = new CameraResolution(0,0);
        this.size = 0;
    }

    public SmartCamera (String id, State state,CameraResolution resolution,  int size) {
        super(id,state);
        this.resolution = new CameraResolution(resolution.height,resolution.width);
        this.size = size;
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

    /** The number that represents a position */
    public Integer representedBy() {
        return 1;
    }

    public int consumption(CameraResolution resolution,  int size){
        // só uma ideia, funciona assim pq quanto maior for a res mais comsumo tem
        return this.resolution.width *this.resolution.height * size;
    }

}
