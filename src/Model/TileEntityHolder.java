package Model;

import Model.Entity.Building;
import Model.Entity.TileResource;
import Model.Entity.Unit;

public class TileEntityHolder {
    private Building building;
    private Unit unit;
    private TileResource resource;

    public TileEntityHolder() {
        building = null;
        unit = null;
        resource = null;
    }
    public TileEntityHolder(Building building, Unit unit, TileResource resource) {
        this.building = building;
        this.unit = unit;
        this.resource = resource;
    }
    public void setBuilding(Building building) {
        this.building = building;
    }
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    public void setTileResource(TileResource resource) {
        this.resource = resource;
    }
    public Building getBuilding() {
        return this.building;
    }
    public Unit getUnit() {
        return this.unit;
    }
    public TileResource getTileResource() {
        return this.resource;
    }
}
