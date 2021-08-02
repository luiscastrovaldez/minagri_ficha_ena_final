package pe.gob.minagri.ena.newkml;

import org.simpleframework.xml.Element;

public class InnerBoundaryIs {

	@Element(name = "LinearRing")
	private LinearRing linearRing;

	public LinearRing getLinearRing() {
		return linearRing;
	}

	public void setLinearRing(LinearRing linearRing) {
		this.linearRing = linearRing;
	}
	
	
}
