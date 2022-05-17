package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] getPointerMatrix() {
        int aantal = this.gewichtenMatrix.length;
        int[][] pointerMatrix = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] DMatrix = this.gewichtenMatrix.clone();
        for (int i = 0; i < DMatrix.length;i++){
            DMatrix[i] = DMatrix[i].clone();
        }

        for (int k= 0; k < aantal; k++){
            for (int i = 0; i<aantal;i++){
                for (int j = 0; j<aantal;j++){
                    if (DMatrix[i][k] + DMatrix[k][j] < DMatrix[i][j]){
                        DMatrix[i][j] = DMatrix[i][k] + DMatrix[k][j];
                        pointerMatrix[i][j] = k + 1;
                    }
                }
            }

        }


		return pointerMatrix;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] pointer) {
		List<Integer> res = new ArrayList<>();
        if (i == j) {
            return res;
        } else {
            int via = pointer[i - 1][j - 1];
            if (via == 0){
                res.add(i);
                res.add(j);
            } else {
                res = getShortestPath(i, via, pointer);
                res.remove(res.size() - 1);
                res.addAll(getShortestPath(via, j, pointer));
            }
        }
        return res;
    }

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
	
		return som;
	}

}
