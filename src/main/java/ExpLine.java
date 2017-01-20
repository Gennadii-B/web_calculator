package main.java;

/**
 * Created by user on 20.01.2017.
 */
public class ExpLine {

    String id;
    String expression;
    String result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toString(){
        return "exp";
    }
}
