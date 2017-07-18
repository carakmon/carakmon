package oop2lotto;

public class LottoBall {

	int num;
	boolean selected;

	public LottoBall(int num) {
		super();
		this.num = num;
		this.selected = false;

	}

	@Override
	public String toString() {
		return "LottoBall [num=" + num + ", selected=" + selected + "]";
	}

	public boolean askSelected() {
		if (selected) {
			return true;
		}
		this.selected = true;

		return false;
	}

	public void reset() {
		this.selected = false;
		
	}

}
