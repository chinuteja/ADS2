/**.
 * Class for edge.
 */
public final class Edge implements Comparable<Edge> {
	/**.
	 * vertex
	 */
	private final int v;
	/**.
	 * vertex
	 */
	private final int w;
	/**.
	 * weight of edge
	 */
	private final double weight;
	/**.
	 * Initializes an edge between vertices {@code v} and {@code w} of
	 * the given {@code weight}.
	 * @param  v1 one vertex
	 * @param  w1 the other vertex
	 * @param  weight1 the weight of this edge
	 */
	public Edge(final int v1, final int w1, final double weight1) {
		this.v = v1;
		this.w = w1;
		this.weight = weight1;
	}
	/**.
	 * Returns the weight of this edge.
	 * Time complexity is constant bcz each statement is executed only once
	 * @return the weight of this edge
	 */
	public double weight() {
		return weight;
	}
	/**.
	 * Returns either endpoint of this edge.
	 *Time complexity is constant bcz each statement is executed only once
	 * @return either endpoint of this edge
	 */
	public int either() {
		return v;
	}
	/**.
	 * Returns the endpoint of this edge that is different
	 * from the given vertex.
	 *Time complexity is constant bcz each statement is executed only once
	 * @param  vertex one endpoint of this edge
	 * @return the other endpoint of this edge
	 * @throws IllegalArgumentException if the vertex is not one of the
	 *         endpoints of this edge
	 */
	public int other(final int vertex) {
		if      (vertex == v)  {
			return w;
		} else if (vertex == w) {
			return v;
		} else {
			throw new IllegalArgumentException("Illegal endpoint");
		}
	}
	/**.
	 * Compares two edges by weight.
	 * Note that {@code compareTo()} is not consistent
	 * with {@code equals()},
	 * which uses the reference equality implementation
	 * inherited from {@code Object}.
	 * @param  that the other edge
	 * @return a negative integer, zero, or positive integer
	 * depending on whether
	 *  the weight of this is less than, equal to, or greater than the
	 * argument edge
	 */
	@Override
	public int compareTo(final Edge that) {
		return Double.compare(this.weight, that.weight);
	}
	/**.
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		// String str = "";
		// str += str + v1 + v2 + weight;
		// System.out.println("String."+str);
		// return str;
		return String.format("%d-%d %.5f", v, w, weight);
		//return "Hello";
	}
}
