import java.awt.Color;
public class SeamCarver {
	// create a seam carver object based on the given picture
	Picture picture;
	//double[][] energy;
	public SeamCarver(Picture picture1) {
		picture = new Picture(picture1);
	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return picture.width();
	}
	// height of current picture
	public int height() {
		return picture.height();
	}
	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x == 0 || y == 0 || x == picture.width() - 1 ||
		        y == picture.height() - 1) {
			return 1000;
		} else {
			Color left = picture.get(x, y - 1);
			Color right = picture.get(x, y + 1);
			Color top = picture.get(x - 1, y);
			Color bottom = picture.get(x + 1, y);
			int rh = bottom.getRed() - top.getRed();
			int bh = bottom.getBlue() - top.getBlue();
			int gh = bottom.getGreen() - top.getGreen();
			int horizontal = rh * rh + bh * bh + gh * gh;
			int rv = left.getRed() - right.getRed();
			int bv = left.getBlue() - right.getBlue();
			int gv = left.getGreen() - right.getGreen();
			int vertical = rv * rv + bv * bv + gv * gv;
			double enr = Math.sqrt(horizontal + vertical);
			return enr;
		}
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}