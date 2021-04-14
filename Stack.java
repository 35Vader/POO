import java.util.ArrayList;
import java.util.Collections;

public class Stack {
    private ArrayList<String> stack;

    public Stack() {
        stack = new ArrayList<String>();
    }

    public Stack(int size) {
        stack = new ArrayList<String>(size);
    }

    public Stack(Stack s) {
        stack = s.getStack();
    }

    public ArrayList<String> getStack() {
        ArrayList<String> ret = new ArrayList<String>();
        Collections.copy (ret, stack); //strings imutaveis
        /*
        for(int i = 0; i < stack.size(); i++) {
            ret.set(i, Stack.get(i));
        }
        */
        return ret;
    }

    public void setStack(ArrayList<String> newStack) {
        this.stack = new ArrayList<String>();
        for(String s : newStack) {
            this.stack.add(s); //s.clone() para objetos nao imutaveis
        }
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if((o == null) || this.getClass() != o.getClass()) return false;

        Stack s = (Stack) o;
        //comparar ArrayLists
        //"In other words, two lists are defined to be equal
        //if they contain the same elements in the same order."
        return s.getStack().equals(this.stack);
    }

    public String toString() {
        return "String:" + this.stack.toString();
    }

    public Stack clone() {
        return new Stack(this);
    }

    public int length() {
        return this.stack.size(); //devolve o num de elementos colocados no arrayList
    }

    public boolean empty() {
        //return this.Stack.size() == 0;
        return this.stack.isEmpty();
    }

    public String top() {
        return this.stack.get(this.stack.size() - 1);
    }

    public void push(String s) {
        this.stack.add(s); //add coloca no final do arrayList
    }

    public void pop() {
        if(!this.empty()) {
            this.stack.remove(this.stack.size() - 1);
        }
    }
}