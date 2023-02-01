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
                String v =Double.toString(computeResult);
                return doubleToInt(v);
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

    private String doubleToInt(String data){
        String input = data;
        int inputLength = data.length();
        String newString;
        String char1 = Character.toString(input.charAt(inputLength-1));
        String char2 = Character.toString(input.charAt(inputLength-2));


        if(char1.equals("0") && char2.equals(".")){
            newString = input.substring(0, input.length() - 2);
            return newString;
        }
        else{
            newString = input;
            return newString;
        }

    }

}
