class MLModel {

    // PRIVATE DATA (hidden completely)
    private double[] weights;        // can't be accessed
    private String trainingDataset;  // hidden
    private String algorithm;        // hidden (e.g., Neural Network)

    // PRIVATE METHOD (hidden logic)
    private double preprocess(double input) {
        return input / 100;  // just an example
    }

    private double internalPredict(double processed) {
        return processed * weights[0] + 0.4;  // simplified hidden formula
    }

    // PUBLIC METHOD (controlled access)
    public double predict(double input) {
        double processed = preprocess(input);  // hidden step
        return internalPredict(processed);     // hidden step
    }
}
