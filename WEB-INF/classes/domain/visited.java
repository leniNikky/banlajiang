package domain;

public class visited {
	private int visitedCount;
	public visited() { }
	public int getVisitedCount() {
		return visitedCount;
	}
	public void setVisitedCount(int visitedCount) {
		this.visitedCount = visitedCount;
	}
	@Override
	public String toString() {
		return "visited [visitedCount=" + visitedCount + "]";
	}
	public visited(int visitedCount) {
		super();
		this.visitedCount = visitedCount;
	};
	
}
