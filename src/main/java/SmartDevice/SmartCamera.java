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

    public SmartCamera (CameraResolution resolution,  int size) {
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
}
