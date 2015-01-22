public class ArrayOps {

    public static double findMax(double[] data) {
        double max = data[0];
        for (int i = 1; i < data.length; i++) {
        	if (data[i] > max) max = data[i];
        }
        return max;
    }

    public static double[] normalise(double data[]) {
    	double sum = 0;
    	for (int i = 0; i < data.length; i++) {
    		sum += data[i];
    	}
    	double[] normalised = new double[data.length];
    	for (int i = 0; i < data.length; i++) {
    		normalised[i] = data[i] / sum;
    	}
    	
    	return normalised;
    }

    public static void normaliseInPlace(double data[]) {
    	double sum = 0;
    	for (int i = 0; i < data.length; i++) {
    		sum += data[i];
    	}
    	for (int i = 0; i < data.length; i++) {
    		data[i] /= sum;
    	}
    }

    public static double[] reverse(double[] data) {
        double[] reversed = new double[data.length];
        for (int i = 0; i < data.length; i++) {
        	reversed[i] = data[data.length-i-1];
        }
    	return reversed;
    }

    public static void reverseInPlace(double[] data) {
        for (int i = 0; i < data.length / 2; i++) {
        	double temp = data[i];
        	data[i] = data[data.length - 1 - i];
        	data[data.length - 1 - i] = temp;
        }
    }

    public static void swap(double[] data1, double[] data2) {
        for (int i = 0; i < data1.length; i++) {
            double temp = data1[i];
            data1[i] = data2[i];
            data2[i] = temp;
        }
    }
    
    public static void main(String args[]) {
    	double[] input1 = { 1.0, 2.0, 3.0, 4.0 };
        double[] input2 = { 5.0, 4.0, 3.0, 2.0 };
        
    	input1 = new double[] { 1.0 };
        input2 = new double[] { 5.0 };

        ArrayOps.swap(input1, input2);
    }

}
