package pe.gob.minagri.ena.newkml;

import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class LineString {
	
	@Path("tessellate")
	@Text(required=false)
	private String tessellate;
	
	@Path("coordinates")
	@Text(required=false)
	private String coordinates;

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getTessellate() {
		return tessellate;
	}

	public void setTessellate(String tessellate) {
		this.tessellate = tessellate;
	}
	
	

}
