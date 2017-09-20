public class Polynomial {
    // create a polynomial
    Term head;
    public Polynomial(Term firstTerm) {
        this.head = firstTerm;
    }
    // get the first term
    public Term getFirst() {
        return this.head;
    }
    // set the first term
    public void setFirst(Term first) {
        this.head = first;
    }
    // add a single term to the polynomial
    public void addTerm(Term term) {
        Term i = this.head;
        Term prev = null;
        while (i.exp > term.exp) 
            i = i.next;
        if (i.exp == term.exp)
            i.coef += term.coef;
        else 
            i.setNext(term);
    }
    // add another polynomial, return the sum
    public Polynomial add(Polynomial another) {
    }
    // convert to string representation
    // example: 4.0x^3+3.2x^2-2.1x^1+1.0x^0
    // example: -12.0x^9-1.0x^7+3.0x^5+10.0x^2+5.0x^0
    public String toString() {
        String s = "";
        Formatter fmt = new Formatter();
        for (Term t = head; t != null; t = t.getNext()) {
            s += fmt.format(
                "%c%fx^%d", 
                (t != head && t.coef > 0) ? '+':'',
                t.coef,
                t.exp
            );
        }
        return s;
    }
    // write your own code to test your implementation
    public static void main(String[] args) {
        Term a = new Term(4, 3);
        Term b = new Term(3.2, 2);
        Term c = new Term(-2.1, 1);
        Term d = new Term(1, 0);
        Polynomial p = new Polynomial(a);
        p.addTerm(b);
        p.addTerm(c);
        p.addTerm(d);
        System.out.println(p);
    }
}
