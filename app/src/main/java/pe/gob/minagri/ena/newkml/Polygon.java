package pe.gob.minagri.ena.newkml;

import org.simpleframework.xml.Element;

public class Polygon {

	@Element(required = true)
	private OuterBoundaryIs outerBoundaryIs;

	@Element(required = false)
	private InnerBoundaryIs innerBoundaryIs;

	public OuterBoundaryIs getOuterBoundaryIs() {
		return outerBoundaryIs;
	}

	public void setOuterBoundaryIs(OuterBoundaryIs outerBoundaryIs) {
		this.outerBoundaryIs = outerBoundaryIs;
	}

	public InnerBoundaryIs getInnerBoundaryIs() {
		return innerBoundaryIs;
	}

	public void setInnerBoundaryIs(InnerBoundaryIs innerBoundaryIs) {
		this.innerBoundaryIs = innerBoundaryIs;
	}
}
