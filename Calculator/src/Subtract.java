public class Subtract {

    //This class performs subtraction operations

    int number1;
    int number2;


    //This is the constructor
    Subtract(int x, int y){
        this.number1 = x;
        this.number2 = y;
    }

    public void main(){
        int output = number1 - number2;
        System.out.println("The subtraction is : "+ output);
    }
}
