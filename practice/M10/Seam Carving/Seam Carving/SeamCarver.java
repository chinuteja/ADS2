
public class SeamCarver {
	// create a seam carver object based on the given picture
	Picture picture;
	public SeamCarver(Picture picture) {
		picture = new Picture(picture);

	}
	// current picture
	// public Picture picture() {
	// 	return null;
	// }
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
		if (x == 0 || y == 0 || x == picture.width() - 1 || y == picture.height() - 1) {
             return 1000;
		}
		return 0;
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