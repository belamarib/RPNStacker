import java.util.*;


class No {
    private int num;
    private No proximo;

    public No (int n) {
        this.num = n;
        this.proximo = null;
    }

    public int getNum () {
        return this.num;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void setProximo (No p) {
        this.proximo = p;
    }

}

class Pilha {
    private No number;

    public Pilha () {
        this.number = null;
    }

    public void adicionar (No n) {
        if (vazia()) {
            this.number = n;
        } else {
            n.setProximo(this.number);
            this.number = n;
        }
    }

    public int remover () {
        int removed = this.number.getNum();
        this.number = this.number.getProximo();
        return removed;
    }
    
    public boolean vazia () {
    	if (this.number == null) {
    		return true;
    	} else {
    		return false;
    	}
    }

}



public class RPNStacker {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String input = in.nextLine();
		
		String[] operations = input.split(" ");
		
		Pilha pilha = new Pilha();
		
		for (int i = 0; i < operations.length; i++) {
			No no;
			
			switch (operations[i]) {
			
			case "+":
				int num1 = pilha.remover();
				int num2 = pilha.remover();
				int res1 = num1 + num2;
				no = new No(res1);
				pilha.adicionar(no);
				break;
			case "*":
				int num3 = pilha.remover();
				int num4 = pilha.remover();
				int res2 = num3 * num4;
				no = new No(res2);
				pilha.adicionar(no);
				break;
			case "-":
				int num5 = pilha.remover();
				int num6 = pilha.remover();
				int res3 = num5 - num6;
				no = new No(res3);
				pilha.adicionar(no);
				break;
			case "/":
				int num7 = pilha.remover();
				int num8 = pilha.remover();
				int res4 = num7 / num8;
				no = new No(res4);
				pilha.adicionar(no);
				break;
			default:
				int input_num = Integer.parseInt(operations[i]);
				no = new No(input_num);
				pilha.adicionar(no);
			}
		}
		
		System.out.println(pilha.remover());

	}

}
