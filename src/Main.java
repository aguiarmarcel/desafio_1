import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /*
        Implemente um algoritmo que verifique se uma string possui chaves, parentesis e colchetes balanceados. Em
uma dada string, você deve indicar se os parênteses e colchetes estão balanceados. Diz-se que uma string está
balanceada quando para cada parenteses ou colchetes abrindo, existe um equivalente fechando. Por exemplo, a
string: (()[]) está balanceada, enquanto as strings ((()) e )( não estão balanceadas.
Input format
Você irá receber um número inteiro n indicando a quantidade de strings que virão a seguir. Depois, você receberá
n strings, uma em cada linha.A string contém no máximo 255 caracteres e pode ser composta pelos caracteres ')',
'(', ']', '[' e ' '. O caracter branco deve ser ignorado.
Também é possível receber uma linha vazia.
Output format
Para cada string, você deve imprimir 'Yes' , caso a string esteja balanceada e 'No' caso contrário.
Se a string for vazia, você deve imprimir 'Yes'
         */
        String[] strings = {"([] )", "(([()])))", "([()[]()])()", "(", "(]", ")(", "]["};
        for (String string : strings) {
            System.out.println(string + " " + (isBalanced(string) ? "Yes" : "No"));
        }

    }

    private static boolean isBalanced(String s) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[') {
                pilha.push(c);
            } else if (c == ')' || c == ']') {
                if (pilha.empty()) {
                    return false;
                }

                char topo = pilha.pop();

                if ((c == ')' && topo != '(') || (c == ']' && topo != '[')) {
                    return false;
                }
            }
        }

        return pilha.empty();
    }
}
