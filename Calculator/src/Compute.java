public class Compute{

    String firstVariable;
    String secondVariable;
    String operand;
    double computeResult;

    //Constuctor for the Compute Class
    Compute(String x, String y, String operand){
        this.firstVariable = x;
        this.secondVariable = y;
        this.operand = operand;
    }

    public String compute(){

        switch (this.operand) {
            case "+" -> {
                computeResult = Double.parseDouble(this.firstVariable) + Double.parseDouble(this.secondVariable);
                return (Double.toString(computeResult));
            }
            case "-" -> {
                computeResult = Double.parseDouble(this.firstVariable) - Double.parseDouble(this.secondVariable);
                return (Double.toString(computeResult));
            }
            case "x" -> {
                computeResult = Double.parseDouble(this.firstVariable) * Double.parseDouble(this.secondVariable);
                return (Double.toString(computeResult));
            }
            case "/" -> {
                computeResult = Double.parseDouble(this.firstVariable) / Double.parseDouble(this.secondVariable);
                return (Double.toString(computeResult));
            }
            default -> {
                return null;
            }
        }

    }
}
