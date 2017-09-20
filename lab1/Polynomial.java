import java.util.Formatter;
public class Polynomial {
    Term head;
    // create a polynomial
    public Polynomial(Term firstTerm) {
        this.head = new Term(0, 0);
        head.next = firstTerm;
    }
    // get the first term
    public Term getFirst() {
        return this.head.next;
    }
    // set the first term
    public void setFirst(Term first) {
        this.head.next = first;
    }
    // add a single term to the polynomial
    public void addTerm(Term term) {
        Term i = this.head;
        while (i.next.coef > term.coef)
            i = i.next;
        if (i.next.coef == term.coef)
            i.next.coef += term.coef;
        else {
            term.next = i.next;
            i.next = term;
        }
    }
    // add another polynomial, return the sum
    public Polynomial add(Polynomial another) {
        return null;
    }
    // convert to string representation
    // example: 4.0x^3+3.2x^2-2.1x^1+1.0x^0
    // example: -12.0x^9-1.0x^7+3.0x^5+10.0x^2+5.0x^0
    public String toString() {
        String s = "";
        Formatter fmt = new Formatter();
        for (Term t = head; t != null; t = t.next) {
            s += fmt.format(
                "%c%.1fx^%d", 
                (t != head && t.coef > 0) ? '+':'\0',
                t.coef,
                t.exp
            );
        }
        return s;
    }
    // write your own code to test your implementation
    public static void main(String[] args) {
        Term a = new Term(4, 3);
        Polynomial p = new Polynomial(a);
        System.out.println(p);
    }
}
