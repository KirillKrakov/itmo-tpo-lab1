package software_testing.text.abstract_classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import software_testing.text.characters.StarSystem;

@Getter
@Setter
@AllArgsConstructor
public abstract class SpaceObject {
    private String name;
    private double weight;
    private double x, y, z;

    public double getOtherSpaceObjectDistance(SpaceObject spaceObject) {
        return getOtherSpaceObjectNewDistance(spaceObject, this.x, this.y, this.z);
    }

    public double getOtherSpaceObjectNewDistance(SpaceObject spaceObject, double x, double y, double z) {
        double x2 = Math.pow(x - spaceObject.x, 2);
        double y2 = Math.pow(y - spaceObject.y, 2);
        double z2 = Math.pow(z - spaceObject.z, 2);
        return Math.sqrt(x2 + y2 + z2);
    }
}
