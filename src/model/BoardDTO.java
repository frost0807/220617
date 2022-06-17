package model;

public class BoardDTO {
	private int id;
	private String writer;
	private String title;
	private String content;
	
	public BoardDTO(){}
	public BoardDTO(int id){
		this.id=id;
	}
	public BoardDTO(BoardDTO b){
		this.id=b.id;
		this.title=b.title;
		this.writer=b.writer;
		this.content=b.content;
	}
	public int getId() {
		return id;
	}
	public String getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean equals(Object o) {
		if(o instanceof BoardDTO) {
			return this.id==((BoardDTO)o).id;
		} else {
			return false;
		}
	}
}
