package pe.gob.minagri.ena.newkml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Document {
	
	@Attribute(name = "id",required = false,empty = "ID")
	private String id;
	
	@Element
	private String name;
	
	@Element(name = "Snippet")
	private Snippet snippet;
	
	@Element(name = "Style")
	private Style style;
	
	@Element(name = "Folder")
	private Folder folder;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Snippet getSnippet() {
		return snippet;
	}

	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	
	
	
}
